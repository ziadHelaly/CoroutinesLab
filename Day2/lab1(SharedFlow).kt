package eg.edu.iti.kotlind1.coroutines2

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    val sharedFlow = MutableSharedFlow<Int>()
    sharedFlow.emit(8)
    launch {
        sharedFlow.collect {
            println("first: $it")
        }
    }
    delay(500)
    sharedFlow.emit(9)
    sharedFlow.emit(99)
    sharedFlow.emit(999)
    launch {
        sharedFlow.collect {
            println("second: $it")
        }
    }

    sharedFlow.emit(10)
    delay(100)
    sharedFlow.emit(11)
    delay(100)
    sharedFlow.emit(12)
    sharedFlow.emit(13)
    sharedFlow.emit(14)
    println("Done")


}