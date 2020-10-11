package me.bristermitten.komms.sender

/**
 * @author AlexL
 */
interface Sender<T> {
    val value: T
    fun reply(message: String)
}
