fun main(args: Array<String>) {
  println(Fib2().runFib())
}

class Fib2 {

  fun runFib() {
    for (i in 20 downTo 0) {
      print("${fib(i)}, ")
    }

    //println(fibTail(20))
  }

  fun fib(iterations:Int) : Int {

    if (iterations <= 1) return 1

    return fib(iterations-1) + fib(iterations-2)
  }
}