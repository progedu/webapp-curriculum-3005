import java.util.concurrent.{Callable, Executors}

object TenThousandNamePrinter extends App {
  val es = Executors.newFixedThreadPool(1000)

  val printers = for (i <- 1 to 10000) yield {
    es.submit(new Callable[Unit] {
      override def call(): Unit = {
        Thread.sleep(1000)
        println(Thread.currentThread().getName)
      }
    })
  }

  printers.foreach(_.get())
  es.shutdownNow()
}
