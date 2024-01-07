package basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() = runBlocking {
    launch {
        repeat(10) { i->
            println("I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(2000L)
}