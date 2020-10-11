@file:Suppress("UNCHECKED_CAST")

package me.bristermitten.komms

import me.bristermitten.komms.argument.ArgumentSnapshot
import me.bristermitten.komms.command.Command

/**
 * @author AlexL
 */

fun <T : Any> command(name: String, arg1: ArgumentSnapshot<T>, body: (T) -> Unit): Command {
    return Command(
        name,
        listOf(arg1)
    ) { args ->
        body(args[0] as T)
    }
}

fun <A : Any, B : Any> command(
    name: String,
    arg1: ArgumentSnapshot<A>,
    arg2: ArgumentSnapshot<B>,
    body: (A, B) -> Unit,
): Command {
    return Command(
        name,
        listOf(arg1, arg2),
    ) { args ->
        body(args[0] as A, args[2] as B)
    }
}

@JvmName("stringArg")
fun arg(name: String) = arg<String>(name)

inline fun <reified T : Any> arg(name: String): ArgumentSnapshot<T> {
    return ArgumentSnapshot(
        name,
        T::class
    )
}
