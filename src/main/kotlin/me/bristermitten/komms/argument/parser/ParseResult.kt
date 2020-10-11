package me.bristermitten.komms.argument.parser

sealed class ParseResult<T: Any>

data class Success<T: Any>(val value: T) : ParseResult<T>()

data class Failure<T: Any>(val reason: String) : ParseResult<T>()

