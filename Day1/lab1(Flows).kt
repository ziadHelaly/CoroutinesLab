package eg.edu.iti.kotlind1.corutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun fetchNumbers(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(10)
        emit(6)
        emit(i)
        println("Emitting: $i")
        delay(500)
    }
}

@OptIn(FlowPreview::class)
fun main() = runBlocking {
    fetchNumbers()
        .filter { it>3 }
        .debounce(1000L)
        .collect { value -> println("Collected: $value") }
}
