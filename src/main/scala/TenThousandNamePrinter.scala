import java.util.concurrent.Executors

object TenThousandNamePrinter extends App {
  val es = Executors.newCachedThreadPool()

  for (i <- 1 to 10000) {
    es.submit(new Runnable {
      override def run(): Unit = {
        Thread.sleep(1000)
        println(s"${Thread.currentThread().getName} + $i")
      }
    })
  }

  es.shutdown()
}