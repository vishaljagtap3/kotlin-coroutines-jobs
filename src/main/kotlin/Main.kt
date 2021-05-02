import kotlinx.coroutines.*

//4
fun main() {
    runBlocking {
        val job1 = launch {
            println("Job1 is running...")
            val job2 = launch {
                println("Job2 started...")
                delay(2000)
                println("Job2 ended...")
            }
            job2.invokeOnCompletion { println("Job2 completed...") }

            val job3 = launch {
                println("Job3 started...")
                delay(2000)
                println("Job3 ended...")
            }
            job3.invokeOnCompletion { println("Job3 completed...") }
        }

        job1.invokeOnCompletion { println("Job1 completed...") }
        delay(500)
        println("Job1 would be cancelled...")
        job1.cancel() //will cancel the job and because of it the invokeOnCompletion will be triggered
    }
}

//3
//fun main() {
//    runBlocking {
//        val job1 = launch {
//            delay(2000)
//            println("Job1 is running...")
//        }
//        job1.invokeOnCompletion { println("Job1 completed...") }
//        delay(500)
//        println("Job1 would be cancelled...")
//        job1.cancel() //will cancel the job and because of it the invokeOnCompletion will be triggered
//    }
//}



//2
//fun main() {
//    runBlocking {
//        val job1 = launch {
//            println("Job1 is running...")
//        }
//        job1.invokeOnCompletion { println("Job1 completed...") }
//    }
//}


//1
//fun main() {
//    var job1 = GlobalScope.launch {
//        coroutineScope {
//            var job2 = launch { }
//        }
//    }
//}

