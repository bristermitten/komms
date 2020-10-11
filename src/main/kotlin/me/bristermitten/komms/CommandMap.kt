package me.bristermitten.komms

import me.bristermitten.komms.command.RegisteredCommand

/**
 * @author AlexL
 */
class CommandMap : MutableMap<String, List<RegisteredCommand>> by mutableMapOf() {

    fun register(value: RegisteredCommand) {
        val name = value.name
        val existing = this[name]?.toMutableList() ?: mutableListOf()

        existing += value

        this[name] = existing
    }
}
