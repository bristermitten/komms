package me.bristermitten.komms

import org.bukkit.ChatColor

fun String.color() : String = ChatColor.translateAlternateColorCodes('&', this)
