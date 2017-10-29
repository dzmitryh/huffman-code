import patmat.Huffman.Leaf

//List('a', 'a', 'b', 'b')
val list = List('a', 'a')
  .groupBy(tuple => tuple)
  .map(tuple => (tuple._1, tuple._2.length))
  .toList

//val sortedLeafs = List()
val sortedLeafs = list.sortBy(tuple => tuple._2).map(tuple => Leaf(tuple._1, tuple._2))

sortedLeafs.head
sortedLeafs.tail

val isSingleton = sortedLeafs.tail == List.empty

patmat.Huffman.combine(sortedLeafs)

