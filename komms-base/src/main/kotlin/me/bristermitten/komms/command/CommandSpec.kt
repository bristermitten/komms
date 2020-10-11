package me.bristermitten.komms.command

import me.bristermitten.komms.sender.Sender

interface CommandSpec<T: Sender<*>> {
    fun root()
}

