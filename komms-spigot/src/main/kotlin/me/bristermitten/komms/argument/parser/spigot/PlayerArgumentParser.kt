package me.bristermitten.komms.argument.parser.spigot

import me.bristermitten.komms.argument.parser.ArgumentParser
import me.bristermitten.komms.argument.parser.Failure
import me.bristermitten.komms.argument.parser.ParseResult
import me.bristermitten.komms.argument.parser.Success
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import java.util.*

object PlayerArgumentParser : ArgumentParser<Player> {
    override fun parse(arguments: Deque<String>): ParseResult<Player> {
        val name = arguments.pop()

        val player = Bukkit.getPlayer(name) ?: return Failure("No such player $name")
        return Success(player)
    }
}
