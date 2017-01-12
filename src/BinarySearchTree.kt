import java.util.*

fun main(args: Array<String>) {
  runBinaryTress()
}


fun runBinaryTress() {
  val tree: BinaryTree = BinaryTree()

  with(tree) {
    addNode(50, "Boss")
    addNode(25, "Vice Pres")
    addNode(15, "Office Manager")
    addNode(30, "Secretary")
    addNode(75, "Sales Manager")
    addNode(85, "Salesman")
  }
  tree.inOrderTraverse(tree.root)
  println("-------")
  //tree.preorderTraverse(tree.root)
  //println("-------")
  //tree.postorderTraverse(tree.root)
  //println("-------")
  //println("search for 30")
  //println(tree.findNode(30))

  println("remove 25")
  println(tree.remove(25))
  println("-------")
  tree.inOrderTraverse(tree.root)
}

fun <T> linkedListOf(vararg items: T) = LinkedList<T>().apply {
  for (i in items) {
    add(i)
  }
}

data class Node(val key: Int,
                val name: String) {
  var leftChild: Node? = null
  var rightChild: Node? = null
}

class BinaryTree : Tree {
  override var root: Node? = null

  fun remove(key: Int): Node? {
    val node = findNode(key)

    if (node == root) {
      println("not implemented...")
    }

    node?.let {
      val parent = findParent(node)
      parent?.let {
        println("parent = $parent")

        when (numChildren(node)) {
          0 -> removeFromParent(parent, node)
          1 -> removeWithOneChild(parent, node)
          2 -> removeWithTwoChildren(parent, node)
        }
      }
    }
    return node
  }

  private fun removeWithOneChild(parent: Node, node: Node) {
    if (parent.rightChild == node) {
      node.rightChild?.let {
        parent.rightChild = node.rightChild
      }
      node.leftChild?.let {
        parent.rightChild = node.leftChild
      }
    } else if (parent.leftChild == node) {
      node.rightChild?.let {
        parent.leftChild = node.rightChild
      }
      node.leftChild?.let {
        parent.leftChild = node.leftChild
      }
    }
  }

  private fun removeWithTwoChildren(parent: Node, node: Node) {

    //find min node in right tree
    var minNode: Node = node.rightChild!!

    while (minNode.leftChild != null) {
      minNode = minNode.leftChild!!
    }

    //remove link from min node to parent
    val minNodeParent = findParent(minNode)
    minNodeParent?.let {
      if (it.rightChild == minNode) {
        it.rightChild = null
      } else if (it.leftChild == minNode) {
        it.leftChild = null
      }
    }

    minNode.rightChild = node.rightChild
    minNode.leftChild = node.leftChild

    if (parent.rightChild == node) {
      parent.rightChild = minNode
    } else if (parent.leftChild == node) {
      parent.leftChild = minNode
    }
  }

  fun numChildren(node: Node): Int {
    var num = 0
    if (node.leftChild != null) num++
    if (node.rightChild != null) num++
    return num
  }

  fun removeFromParent(parent: Node?, child: Node) {
    parent?.let {
      if (parent.leftChild == child) {
        parent.leftChild = null
      } else if (parent.rightChild == child) {
        parent.rightChild = null
      }
    }

  }

  fun addNode(key: Int, name: String) {
    val node = Node(key, name)

    if (root == null) {
      root = node
    } else {
      var focusNode = root
      var parent: Node?

      while (true) {
        parent = focusNode

        if (key < focusNode!!.key) {
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

  fun inOrderTraverse(focus: Node?) {

    focus?.let {
      //if (focus != null) {
      inOrderTraverse(focus.leftChild)
      println(focus)
      inOrderTraverse(focus.rightChild)
    }
    //}
  }

  fun preorderTraverse(focus: Node?) {

    focus?.let {
      println(focus)
      preorderTraverse(focus.leftChild)
      preorderTraverse(focus.rightChild)
    }
  }

  fun postorderTraverse(focus: Node?) {

    focus?.let {
      postorderTraverse(focus.leftChild)
      postorderTraverse(focus.rightChild)
      println(focus)
    }
  }

  fun findNode(key: Int): Node? {
    var focus = root

    while (focus?.key != key) {
      if (key < focus!!.key) {
        focus = focus.leftChild
      } else {
        focus = focus.rightChild
      }

      if (focus == null) {
        return null
      }
    }
    return focus
  }

  fun findParent(child: Node): Node? {
    var focus = root

    while (focus?.rightChild != child && focus?.leftChild != child) {
      if (child.key < focus!!.key) {
        focus = focus.leftChild
      } else {
        focus = focus.rightChild
      }

      if (focus == null) {
        return null
      }
    }
    return focus
  }
}

