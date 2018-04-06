
import dsa.ai.graph.astar.AStarTest;
import dsa.graph.BFSTest;
import dsa.graph.DFSTest;
import dsa.ai.graph.DijkstraTest;
import dsa.list.DoublyLinkedListTest;
import dsa.list.SinglyLinkedListTest;
import dsa.queue.QueueArrayTest;
import dsa.sort.AllSortTest;
import dsa.stack.StackArrayTest;
import dsa.tree.BSTTreeTest;
import dsa.tree.HuffmanTreeTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({BFSTest.class, DFSTest.class, DijkstraTest.class, DoublyLinkedListTest.class, SinglyLinkedListTest.class, QueueArrayTest.class, StackArrayTest.class, AStarTest.class, BSTTreeTest.class, HuffmanTreeTest.class, AllSortTest.class})
public class AllTests {
}
