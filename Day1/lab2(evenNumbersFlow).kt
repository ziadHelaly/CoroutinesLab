package eg.edu.iti.kotlind1.corutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

fun evenNumbersFlow(): Flow<Int> = flow {
    for (i in 0..100 step 2) {
        emit(i)
        delay(1000)
    }
}

fun main(): Unit = runBlocking {
    evenNumbersFlow()
        .take(10)
        .collect { println("$it") }
}