import java.util.*

fun main(args: Array<String>) {

  val graph = TripleGraph()

    for(i in 0..20) {
      graph.addNode(i)
    }

  graph.bfs(graph)
}


data class GraphNode(val key:Int) {
  val children : MutableList<GraphNode> = mutableListOf()
}

/**
 * Graph that lets each node have 3 children at max
 * just used as an example that might be easy to visualize
 */
class TripleGraph {
  var root:GraphNode? = null
  var focus:GraphNode? = null

  fun addNode (key: Int) {
    val node = GraphNode(key)

    if (root == null) {
      root = node
    } else {

      if (focus == null) {
        focus = root!!
      }

      val queue : ArrayDeque<GraphNode> = ArrayDeque()
      queue.add(root)

      while (queue.isNotEmpty()) {

        if (queue.peek().children.size < 3) {
          println("adding ${node.key} to ${queue.peek()}")
          queue.pop().children.add(node)
          return
        } else if (queue.peek().children.size > 0) {
          queue.pop().children.forEach { queue.addLast(it) }
        }
      }

    }

  }

  fun bfs(graph: TripleGraph) {
    val queue : ArrayDeque<GraphNode> = ArrayDeque()
    print("${graph.root!!.key}, ")
    queue.addAll(graph.root!!.children)
    var width = queue.size
    var iteration = 1
    var level = 0
    println("bfs-----------------")
    while (queue.isNotEmpty()) {
      iteration++
      val node = queue.pop()
      queue.addAll(node.children)

      print("${node.key}, ")
      if (iteration > width) {
        level++
        width = queue.size - iteration
        iteration = 1
        println("...")

      }
      //print(node.key)

    }
  }
}