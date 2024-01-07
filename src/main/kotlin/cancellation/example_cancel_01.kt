package cancellation

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        repeat(1_000) { i ->
            println("job: I'm Sleeping $i ...")
            delay(500L)
        }
    }

    val job1 = launch {
        repeat(1_000) { i ->
            println("job: I'm Sleeping $i ...")
            delay(500L)
        }
    }

    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancel()
    job.join()
    job1.join()
    println("main: Now I can quit.")
}
fun <T> println(msg: T) {
    kotlin.io.println("$msg [${Thread.currentThread().name}]")
}