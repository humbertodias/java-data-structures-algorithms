
import dsa.graph.astar.AStarTest;
import dsa.graph.test.BFSTest;
import dsa.graph.test.DFSTest;
import dsa.graph.test.DijkstraTest;
import dsa.list.test.DoublyLinkedListTest;
import dsa.list.test.SinglyLinkedListTest;
import dsa.queue.test.QueueArrayTest;
import dsa.sort.AllSortTest;
import dsa.stack.test.StackArrayTest;
import dsa.tree.test.BSTTreeTest;
import dsa.tree.test.HuffmanTreeTest;
import org.junit.runners.Suite.SuiteClasses;

@SuiteClasses({BFSTest.class, DFSTest.class, DijkstraTest.class, DoublyLinkedListTest.class, SinglyLinkedListTest.class, QueueArrayTest.class, StackArrayTest.class, AStarTest.class, BSTTreeTest.class, HuffmanTreeTest.class, AllSortTest.class})
public class AllTests {
}
