package context

import kotlinx.coroutines.*

// 부모 코루틴은 자식 코루틴이 실행이 다 끝날때까지 기다려준다.
fun main() = runBlocking<Unit> {
    // launch a coroutine to process some kind of incoming request
    val request = launch {
        repeat(3) { i ->
            launch {
                delay((i+1) * 200L)
                println("Coroutine $i is done")
            }
        }
        println("request: I'm done and I don't explicitly join my children that are still active")
    }
//    request.join()
    println("Now processing of the request is complete")
}