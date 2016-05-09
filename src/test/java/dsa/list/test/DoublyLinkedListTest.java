package dsa.list.test;

import dsa.list.DoublyLinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author humbertodias
 */
public class DoublyLinkedListTest {

    DoublyLinkedList list = new DoublyLinkedList();
    int MAX = 10;

    public DoublyLinkedListTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        for (int i = 0; i < MAX; i++) {
            list.addFirst(Math.random());
        }

    }

    @After
    public void tearDown() {
    }

    @Test
    public void size() {
        assertEquals(list.size(), MAX);
    }
    
    public void remove(){
        list.removeFirst();
        assertEquals(list.size(), MAX-1);
    }
}
