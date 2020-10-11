package me.bristermitten.komms.sender
object DummySender : Sender<Unit> {

    override val sender: Unit = Unit

    override fun reply(message: String) {
        //Discard
    }

}
