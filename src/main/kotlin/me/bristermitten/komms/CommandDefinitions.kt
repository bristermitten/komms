package me.bristermitten.komms

import me.bristermitten.komms.argument.Argument
import me.bristermitten.komms.argument.parser.ArgumentParser
import me.bristermitten.komms.argument.parser.IntArgumentParser
import me.bristermitten.komms.argument.parser.StringArgumentParser
import me.bristermitten.komms.sender.Sender
import kotlin.reflect.KClass

/**
 * @author AlexL
 */

fun <T : Any> command(name: String, arg1: Argument<T>, body: (T) -> Unit): Command {

    return object : Command {
        override val name: String = name
        override val senderType: Sender<*>
            get() = TODO("Not yet implemented")
        override val arguments: List<Argument<*>> = listOf(arg1)

        override fun execute(arguments: List<Any>) {
            @Suppress("UNCHECKED_CAST")
            body(arguments[0] as T)
        }

    }
}

fun <A : Any, B : Any> command(name: String, arg1: Argument<A>, arg2: Argument<B>, body: (A, B) -> Unit): Command {

    return object : Command {
        override val name: String = name
        override val senderType: Sender<*>
            get() = TODO("Not yet implemented")
        override val arguments: List<Argument<*>> = listOf(arg1, arg2)

        override fun execute(arguments: List<Any>) {
            @Suppress("UNCHECKED_CAST")
            body(arguments[0] as A, arguments[2] as B)
        }

    }
}

@JvmName("stringArg")
fun arg(name: String) = arg<String>(name)

@Suppress("UNCHECKED_CAST")
inline fun <reified T : Any> arg(name: String) = object : Argument<T> {
    override val type: KClass<T> = T::class
    override val name: String = name
    override val parser: ArgumentParser<T>
        get() = when (T::class) {
            String::class -> StringArgumentParser
            Int::class -> IntArgumentParser
            else -> throw UnsupportedOperationException("No parser for ${T::class.java}")
        } as ArgumentParser<T>
}
