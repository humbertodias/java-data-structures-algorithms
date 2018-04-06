package dsa.list;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 *
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

    @Test
    public void remove(){
        list.removeFirst();
        assertEquals(list.size(), MAX-1);
    }
}
