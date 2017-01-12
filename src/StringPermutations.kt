fun main(args: Array<String>) {
  StringPermutations().findAllPermutations()
}


class StringPermutations {


  fun findAllPermutations() {
    permute("", "ABC")
  }

  fun permute(prefix: String, string: String) {

    val n = string.length
    if (n == 0) println(prefix)

    for (i in 0..string.length-1) {
      permute(prefix + string[i], string.removeRange(i..i) )
    }
  }
}