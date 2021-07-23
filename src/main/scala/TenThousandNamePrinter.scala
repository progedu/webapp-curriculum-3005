import java.util.concurrent.Executors

object TenThousandNamePrinter extends App {
  val es = Executors.newFixedThreadPool(100)

  for (i <- 1 to 10000) {
    es.submit(new Runnable {
      override def run(): Unit = println(Thread.currentThread().getName)
    })
  }
  es.shutdownNow()
}
