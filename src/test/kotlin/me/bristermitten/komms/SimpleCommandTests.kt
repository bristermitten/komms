package me.bristermitten.komms

import me.bristermitten.komms.command.arg
import me.bristermitten.komms.command.command
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
        var messageValue = ""

        val broadcastCommand = command("broadcast", arg("message")) { message ->
            messageValue = message
        }

        handler.registerCommand(broadcastCommand)
        handler.handle(sender, "broadcast message")

        assertEquals("message", messageValue)
    }

    @Test
    fun `Test Basic Command Handling with multiple commands`() {
        var messageValue = ""
        var messageValue2 = ""

        val broadcastCommand = command("broadcast", arg("message")) { message ->
            messageValue = message
        }

        //This should not be executed
        val broadcastCommand2 = command("broadcast", arg("message"), arg("message2")) { _, message2 ->
            messageValue2 = message2
        }

        handler.registerCommand(broadcastCommand)
        handler.registerCommand(broadcastCommand2)

        handler.handle(sender, "broadcast message")

        assertEquals("message", messageValue)
        assertEquals("", messageValue2)
    }
}
