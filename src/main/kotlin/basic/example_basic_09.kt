package basic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() = runBlocking {
    val repeatNum: Int = 10
    launch {
        repeat(repeatNum) { i ->
            println("Coroutine A, $i")
            delay(100L)
        }
    }

    launch {
        repeat(repeatNum) { i ->
            println("Coroutine B, $i")
        }
    }

    println("Coroutine Outer")
}

fun <T> println(msg: T) {
    kotlin.io.println("$msg [${Thread.currentThread().name}]")
}