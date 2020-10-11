package me.bristermitten.komms.command

/**
 * @author AlexL
 */
internal class CommandMap : MutableMap<String, List<RegisteredCommand>> by mutableMapOf() {

    fun register(value: RegisteredCommand) {
        val name = value.name
        val existing = this[name]?.toMutableList() ?: mutableListOf()

        existing += value

        this[name] = existing
    }
}
