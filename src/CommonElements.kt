fun main(args: Array<String>) {

  println("CommonElements.kt")
  val intArray1 = arrayOf(1, 2, 3, 4, 5)
  val intArray2 = arrayOf(3, 4, 5, 6, 7) //345
  println(CommonElements().find(intArray1, intArray2))

  val intArray3 = arrayOf(1, 2, 3, 4, 5)
  val intArray4 = arrayOf(6, 7, 8, 9, 0) //none
  println(CommonElements().find(intArray3, intArray4))
}

/**
 * Find the common elements of 2 int arrays
 */

class CommonElements {

  fun find(array1: Array<Int>, array2: Array<Int>): List<Int> {

    val uniqueElements: MutableList<Int> = mutableListOf()

    uniqueElements.addAll(array1)
    uniqueElements.retainAll(array2)

    return uniqueElements
  }
}