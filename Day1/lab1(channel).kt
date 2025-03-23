import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

fun main() = runBlocking {
    val channel = Channel<Int>()


    launch {
        for (i in 1..5) {
            println("Sending: $i")
            channel.send(i)
            delay(500)
        }
        channel.close()
    }


    for (value in channel) {
        println("Received: $value")
    }

}
