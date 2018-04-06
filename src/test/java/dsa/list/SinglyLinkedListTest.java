package dsa.list;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class SinglyLinkedListTest {

    SinglyLinkedList list = new SinglyLinkedList();
    int MAX = 10;

    public SinglyLinkedListTest() {
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
            list.add(Math.random());
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
    public void remove() {
        list.deleteFront();
        assertEquals(list.size(), MAX - 1);
    }
}
