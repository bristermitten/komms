package me.bristermitten.komms.spec

import me.bristermitten.komms.sender.Sender

interface CommandSpec<T: Sender<*>> {
    val root: SubCommandSpec<T>

    val subcommand: SubCommandSpec<T>

    infix fun aliasOf(alias: String)
}

