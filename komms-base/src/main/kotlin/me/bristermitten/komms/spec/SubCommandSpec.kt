package me.bristermitten.komms.spec

import me.bristermitten.komms.argument.ArgumentSnapshot
import me.bristermitten.komms.sender.Sender

interface SubCommandSpec<T: Sender<*>> : CommandSpec<T> {
    operator fun <A : Any?> invoke(name: String, sender: SenderSpec<T> = TODO(), arg: ArgumentSnapshot<A>, body: T.(A) -> Unit)
    operator fun <A : Any?> invoke(name: String, arg: ArgumentSnapshot<A>, body: T.(A) -> Unit)

    operator fun <T> invoke(name: String, sender: SenderSpec<T> = TODO(), body: Sender<T>.() -> Unit)

    operator fun invoke(name: String) : SubCommandSpec<T>
}
