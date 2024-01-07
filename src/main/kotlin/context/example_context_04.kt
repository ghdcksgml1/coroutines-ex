package context

import kotlinx.coroutines.*

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun main() {
    newSingleThreadContext("ctx1").use { ctx1 ->
        newSingleThreadContext("ctx2").use { ctx2 ->
            runBlocking(ctx1) {
                log("Started in ctx1")

                withContext(ctx2) {
                    log("Working in ctx2")
                }

                log("Back to ctx1")
            }
        }
    }
}