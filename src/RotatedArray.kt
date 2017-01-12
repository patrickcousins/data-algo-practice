import java.util.*

fun main(args: Array<String>) {

  println("RotatedArray.kt")
  //true
  val intArray1 = arrayOf(1,2,3,4,5,6,7,8,9)
  val intArray2 = arrayOf(6,7,8,9,1,2,3,4,5)

  //true
  val intArray3 = arrayOf(5,4,3,2,1,0)
  val intArray4 = arrayOf(2,1,0,5,4,3)

  //false
  val intArray5 = arrayOf(1, 2, -2, 2, 3, -3, 4, 5, 6, 7, 8, 9)
  val intArray6 = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
  println(RotatedArray().isRotated(intArray1, intArray2))
  println(RotatedArray().isRotated(intArray3, intArray4))
  println(RotatedArray().isRotated(intArray5, intArray6))
}

/**
 * Given two arrays, determine if one is just a rotated version of another
 */

class RotatedArray {


  fun isRotated(array1:Array<Int>, array2:Array<Int>):Boolean {
    //could also match array lengths and sum the arrays for quick sanity checks

    for (i in 0..array1.size-1) {
      print("i = $i, ")
      if (array2[0] == array1[i]) {
        val offset = i

        for (j in 0..array1.size-1) {

          var absoluteIndex = j+offset
          if (absoluteIndex >= array1.size) {
            absoluteIndex -= array1.size
          }
          print("j = $j, ")
          print("absoluteIndex = $absoluteIndex, ")
          print("array2[j] = ${array2[j]}, ")
          print("array1[absoluteIndex] = ${array1[absoluteIndex]}, ")
          if (array2[j] != array1[absoluteIndex]) {
            return false
          } else if (j == array1.size-1) {
            return true
          }
        }
      }
    }

    return false
  }
}