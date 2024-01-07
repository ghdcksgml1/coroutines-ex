package basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() = runBlocking {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }

    println("Hello, ")
    delay(2000L)
}