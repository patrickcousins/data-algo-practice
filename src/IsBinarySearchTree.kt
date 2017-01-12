fun main(args: Array<String>) {
  runTrees()
}

fun runTrees() {

  val tree = BinaryTree()

  with(tree) {
    addNode(50, "Boss")
    addNode(25, "Vice Pres")
    addNode(15, "Office Manager")
    addNode(30, "Secretary")
    addNode(75, "Sales Manager")
    addNode(85, "Salesman")
  }

  val randomTree = RandomTree()

  with(randomTree) {
    insert(50, "Boss")
    insert(25, "Vice Pres")
    insert(15, "Office Manager")
    insert(30, "Secretary")
    insert(75, "Sales Manager")
    insert(85, "Salesman")
  }

  println("bst is binary = ${isBinanry(tree)}")
  println("randomTree is binary = ${isBinanry(randomTree)}")
}

fun isBinanry(tree:Tree) : Boolean {

  nodeList.clear()
  inOrderTraverse(tree.root)

  for (i in 0..nodeList.size-1) {
    if(i < nodeList.size-1) {
      if (nodeList[i].key > nodeList[i+1].key) {
        return false
      }
    }
  }

  return true
}
val nodeList : MutableList<Node> = mutableListOf()

fun inOrderTraverse(focus: Node?) {

  focus?.let {
    inOrderTraverse(focus.leftChild)
    println(focus)
    nodeList.add(focus)
    inOrderTraverse(focus.rightChild)
  }
}


interface Tree {
  var root: Node?
}

class RandomTree() : Tree {

  override var root: Node? = null
  /**
   * Inserts stuff backwards
   */
  fun insert(key: Int, name: String) {
    val node = Node(key, name)

    if (root == null) {
      root = node
    } else {
      var focusNode = root
      var parent: Node?

      while (true) {
        parent = focusNode

        if (key > focusNode!!.key) {
          focusNode = focusNode.leftChild
          if (focusNode == null) {
            parent!!.leftChild = node
            return
          }
        } else {
          focusNode = focusNode.rightChild
          if (focusNode == null) {
            parent!!.rightChild = node
            return
          }
        }
      }
    }
  }
}