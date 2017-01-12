fun main(args: Array<String>) {

  println("PrimeNumbers.kt")
  println(PrimeNumbers().findPrime(100))
}

/**
 * Use dynamic programming to find the first X prime numbers
 */

class PrimeNumbers {

  fun findPrime(n:Int): List<Int> {

    val primes: MutableList<Int> = mutableListOf()

    primes.add(1)

    for (i in 2..n) {
      var num : Int =  Math.ceil(Math.sqrt(i.toDouble())).toInt()
      while (true) {
        num--
        if (num == 1) {
          primes.add(i)
          break
        } else if (i % num == 0) {
          break
        }
      }
    }

    return primes
  }
}