package me.bristermitten.komms

import me.bristermitten.komms.sender.LoggingSender
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


/**
 * @author AlexL
 */
class CommandHandlerTests {

    private val sender = LoggingSender()

    @Test
    fun `Test Basic Command Handling`() {
        val handler = CommandHandler()

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
        val handler = CommandHandler()

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

    @Test
    fun `Test Basic Command Handling with Int`() {
        val handler = CommandHandler()

        var value = 0

        val broadcastCommand = command("number", arg<Int>("num")) { num ->
            value = num
        }

        handler.registerCommand(broadcastCommand)

        handler.handle(sender, "number 3")

        assertEquals(3, value)
    }

    @Test
    fun `Test Basic Command Handling with Invalid Int`() {
        val handler = CommandHandler()

        var value = 0
        val broadcastCommand = command("number", arg<Int>("num")) { num ->
            value = num
        }

        handler.registerCommand(broadcastCommand)

        handler.handle(sender, "number hello")

        assertEquals(0, value)
        assertTrue {
            sender.messages.poll().contains("Illegal arguments")
        }
    }
}
