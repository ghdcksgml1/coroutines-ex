package basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

fun main() {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
//    thread {
//        Thread.sleep(1000L)
//        println("World!")
//    }
    println("Hello, ")
    Thread.sleep(2000L)
}