package me.bristermitten.komms.command

import me.bristermitten.komms.CommandHandler
import me.bristermitten.komms.argument.ArgumentSnapshot

/**
 * Represents everything that can be known about a command without fetching the data from a [CommandHandler]
 * For example, we can know the command's argument types (eg String, Int), but we cannot know their resolvers before realizing this into a [RegisteredCommand]
 */
data class Command(
    val name: String,
    val argumentTypes: List<ArgumentSnapshot<*>>,
    val body: (arguments: List<Any>) -> Unit
)
