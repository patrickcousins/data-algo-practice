import java.util.*

fun main(args: Array<String>) {

  println("MostFrequentInt.kt")
  val intArray1 = arrayOf(1, 2, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9) //2
  val intArray2 = arrayOf(1, 2, -2, 2, 3, -3, 4, 5, 6, 7, 8, 9) //2
  val intArray3 = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0) //0
  println(MostFrequentInt().findMostFrequent(intArray1))
  println(MostFrequentInt().findMostFrequent(intArray2))
  println(MostFrequentInt().findMostFrequent(intArray3))
}


class MostFrequentInt {



  fun findMostFrequent(array:Array<Int>):Int {

    val occurrences:MutableMap<Int, Int> = HashMap()

    for (i in array) {
      if (occurrences.containsKey(i)) {
        occurrences.put(i, occurrences[i]!! + 1)
      } else {
        occurrences.put(i, 1)
      }
    }

    return occurrences.maxBy { it.value }!!.key
  }
}