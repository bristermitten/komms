package me.bristermitten.komms

/**
 * @author AlexL
 */
class CommandMap : MutableMap<String, List<Command>> by mutableMapOf() {
    fun register(value: Command) {
        val name = value.name
        val existing = this[name]?.toMutableList() ?: mutableListOf()

        existing += value

        this[name] = existing
    }
}
