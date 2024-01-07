package basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() = runBlocking {
    launch {
        myWorld()
    }

    println("Hello,")
}

suspend fun myWorld() {
    delay(1000L)
    println("World!")
}