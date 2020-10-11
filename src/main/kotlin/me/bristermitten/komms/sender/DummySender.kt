package me.bristermitten.komms.sender
object DummySender : Sender<Unit> {

    override val value: Unit = Unit

    override fun reply(message: String) {
        //Discard
    }

}
