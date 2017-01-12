import java.util.*


fun main(args: Array<String>) {
  Partition().partitionK()
  Partition().partition()
}


/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example, given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 */
class Partition() {
  val linkedList : LinkedList<Int> = linkedListOf(2, 4, 3, 2, 5, 1)
  val results : LinkedList<Int> = LinkedList()
  val pivot = 3

  fun partition() {
    val iterator = linkedList.listIterator()
    while (iterator.hasNext()) {
      val next = iterator.next()
      if (next < pivot) {
        results.addLast(next)
        iterator.remove()
      }
    }

    results.addAll(linkedList)
    println(results)
  }


  fun partitionK() {
    println (linkedList.filter { it < pivot }
        + linkedList.filter { it >= pivot })
  }

}