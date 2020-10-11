package me.bristermitten.komms

import me.bristermitten.komms.command.arg
import me.bristermitten.komms.command.command
import me.bristermitten.komms.command.loggingSenderCommand
import me.bristermitten.komms.sender.LoggingSender
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class IntArgumentTests {

    private val sender = LoggingSender()
    private lateinit var handler: CommandHandler

    private var valueFromCommand = 0

    @BeforeEach
    fun setUp() {
        valueFromCommand = 0

        handler = CommandHandler()

        val broadcastCommand = loggingSenderCommand("number", arg<Int>("num")) { num ->
            valueFromCommand = num
        }
        handler.registerCommand(broadcastCommand)
    }

    @Test
    fun `Test Basic Command Handling with Valid Int`() {
        handler.handle(sender, "number 3")

        assertEquals(3, valueFromCommand)
    }

    @Test
    fun `Test Basic Command Handling with String where Int expected`() {
        handler.handle(sender, "number hello")

        assertEquals(0, valueFromCommand)
        assertTrue {
            sender.messages.poll().contains("Illegal arguments")
        }
    }

    @Test
    fun `Test Basic Command Handling with Float where Int expected`() {

        handler.handle(sender, "number 3.5")

        assertEquals(0, valueFromCommand)
        assertTrue {
            sender.messages.poll().contains("Illegal arguments")
        }
    }
}
