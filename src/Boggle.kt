import java.util.*

fun main(args: Array<String>) {
  //runBoggle()
}

class Boggle {

  fun <T> linkedListOf(vararg items: T) = LinkedList<T>().apply {
    for (i in items) {
      add(i)
    }
  }

  /**
   * Performs the given [action] on each element in each array.
   */
  inline fun <T> Array<Array<T>>.forEach2D(action: (T) -> Unit): Unit {
    for (array in this) for (element in array) action(element)
  }

  /*
  Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
     boggle[][]   = {{'G','I','Z'},
                     {'U','E','K'},
                     {'Q','S','E'}};
    isWord(str): returns true if str is present in dictionary
                 else false.

Output:  Following words of dictionary are present
       GEEKS
       QUIZ
   */

  data class Node(val i: Int, val j: Int, val character: Char)


  val input = arrayOf("GEEKS", "FOR", "QUIZ", "GO")
  val boggle = arrayOf(
      arrayOf('G', 'I', 'Z'),
      arrayOf('U', 'E', 'K'),
      arrayOf('Q', 'S', 'E'))
  val width = boggle.size
  val height = boggle[0].size

  val nodeStack = ArrayDeque<Node>()
  var wordsSet = HashSet<String>()

  fun main() {

    val start = Node(0, 0, 'G')
//        nodeStack.add(start)
//        traverse(start)
    var i = 0
    boggle.forEach {
      var j = 0
      boggle[i].forEach {
        println("words starting with ${boggle[i][j]}")
        val start = Node(i, j, boggle[i][j])
        nodeStack.add(start)
        traverse(start)
        //wordsSet.forEach { println(it) }
        wordsSet.forEach {
          if (input.contains(it)) {
            println(it)
          }
        }
        wordsSet.clear()
        nodeStack.clear()
        println()
        j++
      }
      i++
    }

  }

  fun traverse(start: Node) {

    val focusNeighbors = neighbors(start)

    for (node in focusNeighbors) {
      if (!nodeStack.contains(node) && node != null) {
        nodeStack.add(node)
        traverse(node)
        //println()
        //nodeStack.forEach { print(it.character) }
        val word = nodeStack.map { it.character }.joinToString("")
        if (couldBeWord(word)) {
          wordsSet.add(word)

        } else {
          //break
        }
        nodeStack.remove(node)
      }
    }

  }

  fun hasAllNeighbors(wordStack: ArrayDeque<Node>,
                      focusNeighbors: List<Node?>): Boolean {
    return focusNeighbors.any { wordStack.contains(it) }
  }

  fun isWord(word: String): Boolean {
    return input.contains(word)
  }

  fun couldBeWord(start: String): Boolean {
    if (input.any { it.startsWith(start) }) {
      println("could be word: $start")
      return true
    }
    println("not word: $start")
    return false
  }

  fun neighbors(focus: Node): List<Node?> {
    val i = focus.i
    val j = focus.j

    val neighborsAt = arrayListOf(
        north(i, j),
        northeast(i, j),
        east(i, j),
        southeast(i, j),
        south(i, j),
        southwest(i, j),
        west(i, j),
        northwest(i, j)
    )
        .filter { it != null }

    //println("neighbors at ($i, $j) ")
    //print("neighbors at ($i, $j) ")
    //neighborsAt.forEach { print(it?.character) }
    //println()
    return neighborsAt
  }

  fun getNodeAt(i: Int, j: Int): Node? {
    val charAt: Char
    try {
      charAt = boggle[i][j]
    } catch (ex: Exception) {
      return null
    }

    return Node(i, j, charAt)
  }

  fun north(i: Int, j: Int): Node? {
    return getNodeAt(i, j - 1)
  }

  fun northeast(i: Int, j: Int): Node? {
    return getNodeAt(i + 1, j - 1)
  }

  fun east(i: Int, j: Int): Node? {
    return getNodeAt(i + 1, j)
  }

  fun southeast(i: Int, j: Int): Node? {
    return getNodeAt(i + 1, j + 1)
  }

  fun south(i: Int, j: Int): Node? {
    return getNodeAt(i, j + 1)
  }

  fun southwest(i: Int, j: Int): Node? {
    return getNodeAt(i - 1, j + 1)
  }

  fun west(i: Int, j: Int): Node? {
    return getNodeAt(i - 1, j)
  }

  fun northwest(i: Int, j: Int): Node? {
    return getNodeAt(i - 1, j - 1)
  }

}


