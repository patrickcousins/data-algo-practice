import java.util.*

fun main(args: Array<String>) {

  println("IntArrayPairSum.kt")
  val intArray1 = arrayOf(1, 2, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9)
  val intArray2 = arrayOf(1, 2, -2, 2, 3, -3, 4, 5, 6, 7, 8, 9, 13, 12)
  val intArray3 = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
  val intArray4 = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, -10, 10, 10, 0)

  IntArrayPairSum().findPairs(intArray1)
  IntArrayPairSum().findPairs(intArray2)
  IntArrayPairSum().findPairs(intArray3)
  IntArrayPairSum().findPairs(intArray4)
}

/**
 * Find pairs of integers in an array whose sum is 10
 * (extra credit: linear time)
 */

class IntArrayPairSum {

  fun findPairs(array: Array<Int>) {

    //key is 10-array[i], val is number of occupancies
    val subtractedValues: MutableMap<Int, Int> = mutableMapOf()

    //put the difference in a map
    array.forEach { value ->
      val tenMinusValue = 10 - value
      val occurrences = subtractedValues[tenMinusValue] ?: 0
      subtractedValues.put(tenMinusValue, occurrences + 1)
    }

    val pairs: MutableList<String> = mutableListOf()

    //loop over the array and use the map to match the pairs
    for (i in array) {
      if (subtractedValues.containsKey(i)) {
        pairs.add("($i ${10-i})")
        if (subtractedValues[i]!! <= 1) {
          subtractedValues.remove(i)
        } else {
          subtractedValues[i] = subtractedValues[i]!! - 1
        }
      }
    }

    println(pairs)
  }
}