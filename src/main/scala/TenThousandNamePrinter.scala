import java.util.concurrent.{Executors, TimeUnit}
import java.util.concurrent.atomic.AtomicInteger

object TenThousandNamePrinter extends App {

  val es = Executors.newFixedThreadPool(200)
  val counter = new AtomicInteger(0)

  val threads = for (i <- 1 to 10000) yield {
    es.submit(new Runnable {
      override def run(): Unit = {
        val count = counter.incrementAndGet()
        Thread.sleep(1000)
        println(s"${count} ${Thread.currentThread().getName}")
      }
    })
  }

  es.shutdown()

}