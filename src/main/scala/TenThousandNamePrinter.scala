object TenThousandNamePrinter extends App {

  for (i <- 1 to 10000) {
    es.submit(new Runnable {
      override def run(): Unit =  {
        Thread.sleep(1000)
        println(Thread.currentThread().getName)
      }
    })
  }

}
