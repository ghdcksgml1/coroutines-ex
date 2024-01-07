package context

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

/**
 * 코루틴 디스패처 - https://kotlinworld.com/141
 *
 * Dispatcher는 한국어로 '보내다'라는 뜻으로 스레드에 코루틴을 보낸다.
 * 코루틴에서는 스레드 풀을 만들고 Dispacher를 통해 코루틴을 배분한다.
 * 즉, 코루틴을 만든 다음 해당 코루틴을 Dispatcher에 전송하면,
 * Dispatcher는 자신이 관리하는 스레드풀 내의 스레드의 부하 상황에
 * 맞춰 코루틴을 배분한다.
 */
fun main() = runBlocking<Unit> {
    launch {
        println("main runBlocking       :" +
                " I'm working in thread ${Thread.currentThread().name}") // main
    }
    launch(Dispatchers.Unconfined) {
        println("Unconfined             :" +
                " I'm working in thread ${Thread.currentThread().name}") // main
    }
    launch(Dispatchers.Default) {
        println("Default                :" +
                " I'm working in thread ${Thread.currentThread().name}") // DefaultDispatcher-worker-1
    }

    // 이 방식은 스레드를 자동으로 닫아주지 않기 때문에 Memory Leak이 발생할 수 있다.
//    launch(newSingleThreadContext("MyOwnThread")) { // 비용이 높은 방식
//        println("newSingleThreadContext :" +
//                " I'm working in thread ${Thread.currentThread().name}") // MyOwnThread
//    }
    newSingleThreadContext("MyOwnThread").use {
        launch(it) {
            println("newSingleThreadContext :" +
                " I'm working in thread ${Thread.currentThread().name}") // MyOwnThread
        }
    }
}