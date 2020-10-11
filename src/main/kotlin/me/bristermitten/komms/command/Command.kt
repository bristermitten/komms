package me.bristermitten.komms.command

import me.bristermitten.komms.CommandHandler
import me.bristermitten.komms.argument.ArgumentSnapshot
import me.bristermitten.komms.sender.Sender
import kotlin.reflect.KClass

/**
 * Represents everything that can be known about a command without fetching the data from a [CommandHandler]
 * For example, we can know the command's argument types (eg String, Int), but we cannot know their resolvers before realizing this into a [RegisteredCommand]
 */
data class Command<T: Sender<*>>(
    val name: String,
    val senderType: KClass<T>,
    val argumentTypes: List<ArgumentSnapshot<*>>,
    val body: T.(arguments: List<Any>) -> Unit
)
