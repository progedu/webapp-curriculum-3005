import java.util.concurrent.Executors

object TenThousandNamePrinter extends App {
  val executors = Executors.newFixedThreadPool(10);

  val futures = for (i <- 1 to 10000) yield {
    executors.submit(new Runnable {
      override def run(): Unit = {
        Thread.sleep(1000)
        println(Thread.currentThread().getName)
      }
    })
  }

  futures.foreach(f => f.get())
  executors.shutdown()
}