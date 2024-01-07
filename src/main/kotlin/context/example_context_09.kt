package context

import kotlinx.coroutines.*

class Activity(val mainScope: CoroutineScope) {

    fun destroy() {
        mainScope.cancel()
    }

    fun doSomething() {
        // launch ten coroutines for a demo, each working for a different time
        repeat(10) { i ->
            mainScope.launch {
                delay((i + 1) * 200L) // variable delay 200ms, 400ms, ... etc
                println("Coroutine $i is done")
            }
        }
    }
}

fun main() = runBlocking<Unit> {
    val activity = Activity(this)
    activity.doSomething()
    println("Launched coroutines") // run test function
    delay(500L) // delay for half a second
//    println("Destroying activity!")
//    activity.destroy() // cancels all coroutines
}