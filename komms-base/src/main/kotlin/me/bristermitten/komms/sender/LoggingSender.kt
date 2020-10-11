package me.bristermitten.komms.sender

import java.util.*

class LoggingSender : Sender<String> {
    val messages: Queue<String> = LinkedList()

    override val sender: String
        get() = messages.joinToString(separator = "\n")

    override fun reply(message: String) {
        messages.offer(message)
    }


}
