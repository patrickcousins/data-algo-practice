
fun main(args: Array<String>) {

  println("Fibonacci.kt")

  Fibonacci().runFib()
  //Fibonacci().fibIterative(10000)
}


class Fibonacci {

  fun runFib() {
//    for (i in 40 downTo 1) {
//      println(fib(i))
//    }
    for (i in 92L downTo 1) {
      println(fibTail(i))
    }

    //println(fibTail(20))
  }

  fun fib(n:Int ):Int {
    return when(n) {
      1, 0 -> n
      else -> fib(n-1) + fib(n-2)
    }
  }

  fun fibTail(n : Long) : Long {
    tailrec fun _fibTail(index:Long, ant: Long = 0, act:Long  = 1) : Long =
        when(index) {
          0L -> ant
          else -> _fibTail( index - 1 , act, ant + act)
        }
    return _fibTail(n, 0, 1)
  }

  fun fibIterative(iterations:Int) {

    var previous = 1
    var previous2 = 0
    for(i in 1..iterations) {
      var current = previous + previous2
      previous2 = previous
      previous = current
      println(current)
    }
  }
}