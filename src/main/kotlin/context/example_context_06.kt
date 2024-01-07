package context

import kotlinx.coroutines.*
fun main() = runBlocking<Unit> {
    // launch a coroutine to process some kind of incoming request
    val request = launch {
        // it spawns two other jobs, one with GlobalScope
        GlobalScope.launch {
            println("job1: I run in GlobalScope and execute independently!")
            delay(1000L)
            println("job1: I am not affected by cancellation of the request")
        } // GlobalScope이기 때문에 cancel이 전파가 안된다. (부모가 request의 코루틴 스코프가 아니기 때문에)

        // and the other inherits the parent context
        launch {
            delay(100)
            println("job2: I am a child of the request coroutine")
            delay(1000)
            println("job2: I will not execute this line if my parent request is cancelled")
        }
    }
    delay(500)
    request.cancel() // cancel processing of the request
    println("request Job is cancelled")
    delay(1000) // delay a second to see what happens
    println("main: Who has survived request cancellation?")
}