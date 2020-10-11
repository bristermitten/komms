package me.bristermitten.komms.sender

import java.util.*

class LoggingSender : Sender<String> {
    val messages: Queue<String> = LinkedList()

    override val value: String
        get() = messages.joinToString(separator = "\n")

    override fun reply(message: String) {
        messages.offer(message)
    }


}
