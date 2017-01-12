fun main(args: Array<String>) {
  val start = System.currentTimeMillis()
  countTo(10000)
  val end = System.currentTimeMillis()
  println(end-start)
}

/*
 write a counter function that counts from 1 to max but only
 returns numbers whose digits don’t repeat.

For example, part of the output would be:

    8, 9, 10, 12 (11 is not valid)
    98, 102, 103 (99, 100 and 101 are not valid)
    5432, 5436, 5437 (5433, 5434 and 5435 are not valid)

 */

fun countTo(max: Int) {

  val digitsUsed: MutableSet<Char> = mutableSetOf()
  val skippedSequentially: MutableSet<Int> = mutableSetOf()
  var numSkipped: Int = 0
  var maxSkipped: Int = 0
  var totalNumbers: Int = 0
  var i: Int = 0
  while (i <= max) {
    val chars = i.toString().toCharArray()
    var hasRepeatedChar = false
    if (chars.size > 1) {
      for (j in 0..chars.size-1) {
        if (digitsUsed.contains(chars[j])) {
          hasRepeatedChar = true
          val remaining = chars.size - (j+1)
          val remainingDigits = Math.pow(10.0, remaining.toDouble()).toInt()
          print("-> ")
          i += remainingDigits
          break
        } else {
          digitsUsed.add(chars[j])
        }
      }
    }
    digitsUsed.clear()

    if (hasRepeatedChar) {
      if (skippedSequentially.isEmpty()) {
        skippedSequentially.add(i)
        numSkipped++
        if (numSkipped > maxSkipped) maxSkipped = numSkipped
      } else if (skippedSequentially.contains(i - 1)) {
        skippedSequentially.add(i)
        numSkipped++
        if (numSkipped > maxSkipped) maxSkipped = numSkipped
      } else {
        skippedSequentially.clear()
        numSkipped = 0
      }

      continue
    }
    print("$i ")
    i++
    totalNumbers++
  }

  println()
  println("maxSkipped = $maxSkipped")
  println("totalNumbers = $totalNumbers")

}


