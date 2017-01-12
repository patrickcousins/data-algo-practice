
fun main(args: Array<String>) {

  println("LonelyElement.kt")
  val intArray1 = arrayOf(2, 2, 2, 2, 3, 3, 4, 4, 4, 4, 4, 1) //One is the loneliest number
  val intArray2 = arrayOf(9, 2, -2, 2, 3, 3, -2, 5, 5, 7, 9) //7
  val intArray3 = arrayOf(0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0) //-1
  val intArray4 = arrayOf(1, 1, 2, 2, 3, 3, 4, 4) //none
  println(LonelyElement().findLoneWolf(intArray1))
  println(LonelyElement().findLoneWolf(intArray2))
  println(LonelyElement().findLoneWolf(intArray3))
  println(LonelyElement().findLoneWolf(intArray4))
}

/**
 * Find the only element in an array that only occurs once.
 */

class LonelyElement {

  fun findLoneWolf(array:Array<Int>):Int? {

    val uniqueElements:MutableSet<Int> = mutableSetOf()
    val duplicates:MutableSet<Int> = mutableSetOf()

    for (i in array) {
      if (uniqueElements.contains(i)) {
        duplicates.add(i)
      } else {
        uniqueElements.add(i)
      }
    }

    uniqueElements.removeAll(duplicates)

    return uniqueElements.firstOrNull()
  }
}