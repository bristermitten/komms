package me.bristermitten.komms

import me.bristermitten.komms.command.arg
import me.bristermitten.komms.command.command
import me.bristermitten.komms.command.loggingSenderCommand
import me.bristermitten.komms.sender.LoggingSender
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


/**
 * @author AlexL
 */
class SimpleCommandTests {

    private val sender = LoggingSender()
    private lateinit var handler: CommandHandler

    @BeforeEach
    fun setUp() {
        handler = CommandHandler()
    }

    @Test
    fun `Test Basic Command Handling`() {
        val broadcastCommand = loggingSenderCommand("broadcast", arg("message")) { message ->
            reply(message)
        }

        handler.registerCommand(broadcastCommand)
        handler.handle(sender, "broadcast message")

        assertEquals("message", sender.messages.poll())
    }

    @Test
    fun `Test Basic Command Handling with multiple commands`() {
        val broadcastCommand = loggingSenderCommand("broadcast", arg("message")) { message ->
            reply(message)
        }

        //This should not be executed
        val broadcastCommand2 = command("broadcast", arg("message"), arg("message2")) { _, message2 ->
            reply(message2)
        }

        handler.registerCommand(broadcastCommand)
        handler.registerCommand(broadcastCommand2)

        handler.handle(sender, "broadcast message")

        assertEquals("message", sender.messages.poll())
        assertTrue {
            sender.messages.isEmpty()
        }
    }
}
