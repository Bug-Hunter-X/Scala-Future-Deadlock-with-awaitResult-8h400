```scala
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

 object ImplicitExecutionContextExample extends App {
  // This will lead to a deadlock because the Future is executed in the same thread
  // that is also blocking on the result of the Future.
   val future = Future {
     Thread.sleep(5000)
     println("Future completed")
     "Result"
   }

   val result = future.awaitResult(10000) // blocking

   println(s"Result : $result")
 }
```