package me.bristermitten.komms.argument.parser.defaults

import me.bristermitten.komms.argument.parser.ArgumentParsers

fun ArgumentParsers.registerDefaultParsers() {
    registerParser(StringArgumentParser)
    registerParser(IntArgumentParser)
    registerParser(DoubleArgumentParser)
    registerParser(FloatArgumentParser)
}
