@file:Suppress("UNCHECKED_CAST")

package me.bristermitten.komms.command

import me.bristermitten.komms.argument.ArgumentSnapshot
import me.bristermitten.komms.sender.LoggingSender
import me.bristermitten.komms.sender.Sender

/**
 * @author AlexL
 */

inline fun <reified S : Sender<*>, T : Any> command(
    name: String,
    arg1: ArgumentSnapshot<T>,
    crossinline body: S.(T) -> Unit,
): Command<S> {
    return Command(name, S::class, listOf(arg1)) { args ->
        body(args[0] as T)
    }
}

fun <T : Any> loggingSenderCommand(
    name: String,
    arg1: ArgumentSnapshot<T>,
    body: LoggingSender.(T) -> Unit,
): Command<LoggingSender> {
    return command(name, arg1, body)
}


fun <A : Any, B : Any> command(
    name: String,
    arg1: ArgumentSnapshot<A>,
    arg2: ArgumentSnapshot<B>,
    body: Sender<*>.(A, B) -> Unit,
): Command<Sender<*>> {
    return Command(name, Sender::class, listOf(arg1, arg2), ) { args ->
        body(args[0] as A, args[2] as B)
    }
}

@JvmName("stringArg")
fun arg(name: String) = arg<String>(name)

inline fun <reified T : Any> arg(name: String) = ArgumentSnapshot(name, T::class)
