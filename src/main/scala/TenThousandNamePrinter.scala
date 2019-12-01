import java.util.concurrent.Executors
import java.util.concurrent.CountDownLatch
object TenThousandNamePrinter extends App {
  val latch = new CountDownLatch(10)
  val es = Executors.newFixedThreadPool(10)
  for (i <- 1 to 1000) {
    es.submit(new Runnable {
      override def run(): Unit = {
        Thread.sleep(100)
        println(Thread.currentThread().getName)
      }
    })
  }
  es.shutdown()
}