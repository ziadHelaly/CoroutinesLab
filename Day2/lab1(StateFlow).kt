package eg.edu.iti.kotlind1.coroutines2

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val stateFlow = MutableStateFlow(0)


    launch {
        stateFlow.collect { value ->
            println("first : $value")
        }
    }

    delay(500)

    stateFlow.value = 1
    stateFlow.value = 2

    delay(500)

    launch {
        stateFlow.collect { value ->
            println("second : $value")
        }
    }

    stateFlow.value = 3
    stateFlow.value = 4

    delay(1000)
}