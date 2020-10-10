package me.bristermitten.komms

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


/**
 * @author AlexL
 */
class CommandHandlerTests {

    @Test
    fun `Test Basic Command Handling`() {
        val handler = CommandHandler()

        var messageValue = ""

        val broadcastCommand = command("broadcast", arg("message")) { message ->
            messageValue = message
        }

        handler.commands.register(broadcastCommand)
        handler.handle("broadcast message")

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
        val broadcastCommand2 = command("broadcast", arg("message"),arg("message2")) { _, message2 ->
            messageValue2 = message2
        }

        handler.commands.register(broadcastCommand)
        handler.commands.register(broadcastCommand2)

        handler.handle("broadcast message")

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

        handler.commands.register(broadcastCommand)

        handler.handle("number 3")

        assertEquals(3, value)
    }
}
