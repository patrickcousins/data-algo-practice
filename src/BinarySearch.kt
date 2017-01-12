fun main(args: Array<String>) {

  println("BinarySearch.kt")
  val intArray1 = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19)
  println(BinarySearch().find(19, intArray1))

}

/**
 * Implement binary search of a sorted array of integers
 */

class BinarySearch {

  fun find(target: Int, array: Array<Int>): Int? {

    var start = 0
    var end = array.size

    var middle = end / 2
    var searches = 0

    while (end > start && searches < 1000) {
      println("$middle [ $start, $end ]")
      if (target == array[middle]) {
        return middle
      } else if (target > array[middle]) {
        start = middle + 1
        middle = start + (end - start) / 2
      } else if (target < array[middle]) {
        end = middle
        middle = start + (end - start) / 2
      } else if (end == start) {
        return null
      }
      searches++
    }
    return null
  }
}