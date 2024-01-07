package compose

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    try {
        val time = measureTimeMillis {
            val one = somethingUsefulOneAsync()
            val two = somethingUsefulTwoAsync()

            println("my exceptions")
            throw Exception("my exceptions")
            runBlocking {
                println("The answer is ${one.await() + two.await()}")
            }
        }

        println("Completed in $time ms")
    } catch (e: Exception) {

    }

    runBlocking { delay(100000) }
}

fun somethingUsefulOneAsync() = GlobalScope.async {
    println("start, somethingUsefulOneAsync")
    val res = doSomethingUsefulOne()
    println("end, somethingUsefulOneAsync")
    res
}
fun somethingUsefulTwoAsync() = GlobalScope.async {
    println("start, somethingUsefulTwoAsync")
    val res = doSomethingUsefulTwo()
    println("end, somethingUsefulTwoAsync")
    res
}