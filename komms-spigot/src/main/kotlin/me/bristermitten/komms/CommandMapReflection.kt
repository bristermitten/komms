package me.bristermitten.komms

import org.bukkit.Bukkit
import org.bukkit.command.CommandMap
import org.bukkit.plugin.SimplePluginManager

val commandMap by lazy {
    val field = SimplePluginManager::class.java.getDeclaredField("commandMap")
    field.isAccessible = true

    field.get(Bukkit.getPluginManager()) as CommandMap
}
