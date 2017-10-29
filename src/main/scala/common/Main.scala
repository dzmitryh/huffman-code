package common

import patmat.Huffman
import patmat.Huffman.{Fork, Leaf}

object Main {
  def main(args: Array[String]): Unit = {

    val inputTree = Fork(
      Leaf('A', 8),
      Fork(
        Fork(
          Leaf('B', 3),
          Fork(
            Leaf('C', 1),
            Leaf('D', 1),
            List('C', 'D'), 2),
          List('B', 'C', 'D'), 5),

        Fork(
          Fork(Leaf('E', 1), Leaf('F', 1),
            List('E', 'F'), 2),
          Fork(Leaf('G', 1), Leaf('H', 1),
            List('G', 'H'), 2),
          List('E', 'F', 'G', 'H'), 4),
        List('B', 'C', 'D', 'E', 'F', 'G', 'H'), 9),
      List('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'), 17)
    val totalWeight = Huffman.weight(inputTree)
    val totalChars = Huffman.chars(inputTree)


    println("total weight is: " + totalWeight)
    println("total chars for input tree are: " + totalChars)

    println(List(1, 2, 3) :: List(4, 5 ,6))
    println(List(1, 2, 3) ::: List(4, 5, 6))

    val sampleTree = Huffman.makeCodeTree(
      Huffman.makeCodeTree(Leaf('x', 1), Leaf('e', 1)), Leaf('t', 2)
    )
    println(sampleTree)

    println("times function returns: " + Huffman.times(List('a', 'b', 'a', 'a', 'b')))

    val list = List('a', 'a', 'c', 'b', 'b', 'd')
      .groupBy(tuple => tuple)
      .map(tuple => (tuple._1, tuple._2.length))
      .toList

    val sortedLeafs = list.sortBy(tuple => tuple._2).map(tuple => Leaf(tuple._1, tuple._2))
    val isSingleton = sortedLeafs.tail == List.empty
    println("isSingleton: " + isSingleton)
    println("before combine: " + sortedLeafs)
    println(patmat.Huffman.combine(sortedLeafs))
  }
}
