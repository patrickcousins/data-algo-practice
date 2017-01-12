fun main(args:Array<String>) {
//5x4x3x2x1=120
  println(factorial(5))
}

fun factorial(n:Int) : Int {
  if (n==1) return 1

  return n * factorial(n-1)
}