package me.bristermitten.komms.sender

/**
 * @author AlexL
 */
interface Sender<T> {
    val sender: T
    fun reply(message: String)
}
