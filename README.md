# Java Data Structure Algoritms

Data Structure Algoritms using Java


## Prerequires

1. Git 2.6+
2. Maven 3+
3. Java 8+

## Algorithms

1. Stack **[Array,Linked]**

	![Preview](doc/stack.jpg)

2. Queue **[Array,Linked]**

	![Preview](doc/queue.jpg)

3. LinkedList
	
	* Singly	 
	
	![Preview](doc/linked_list.jpg)

	* Doubly
	
	![Preview](doc/doubly_linked_list.jpg)

4. Tree **[BinarySearch,MinPQ,MaxPQ,Huffman]**

	![Preview](doc/binary_tree.jpg)

5. Graph **[Vertex,Matrix]**

	![Preview](doc/graph.jpg)

6. Dijkstra

	![Preview](doc/dijkstra.gif)

7. AStar

	![Preview](doc/a-star.gif)

## How to Play

Clone

```
git clone https://github.com/humbertodias/java-data-structures-algorithms.git
```

Inside the folder

```
cd java-data-structures-algorithms
```

Run

```
mvn test
```
```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running dsa.graph.astar.AStarTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.102 sec
Running dsa.graph.test.BFSTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec
Running dsa.graph.test.DFSTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0 sec
Running dsa.graph.test.DijkstraTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.002 sec
Running dsa.list.test.DoublyLinkedListTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.006 sec
Running dsa.list.test.SinglyLinkedListTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.005 sec
Running dsa.queue.test.MaxPQTest
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.015 sec
Running dsa.queue.test.MinPQTest
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.008 sec
Running dsa.queue.test.QueueArrayTest
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.011 sec
Running dsa.stack.test.StackArrayTest
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.004 sec
Running dsa.tree.test.BSTTreeTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.013 sec
Running dsa.tree.test.HuffmanTreeTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.016 sec

Results :

Tests run: 26, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.069 s
[INFO] Finished at: 2016-06-11T18:38:32-03:00
[INFO] Final Memory: 9M/245M
[INFO] ------------------------------------------------------------------------
```


## References

1. [A* Search Algorithm](https://en.wikipedia.org/wiki/A*_search_algorithm)

2. [Dijkstra](http://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html)

3. [Huffman](https://rosettacode.org/wiki/Huffman_coding#Java)
