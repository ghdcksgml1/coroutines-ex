package cancellation

import kotlinx.coroutines.*

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) {
            if (System.currentTimeMillis() >= nextPrintTime) {
                yield()
//                delay(1L) // suspend fun 사용으로 코루틴에 협조적이므로 cancel이 가능하다.
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }

    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit.")
}
//fun <T> println(msg: T) {
//    kotlin.io.println("$msg [${Thread.currentThread().name}]")
//}