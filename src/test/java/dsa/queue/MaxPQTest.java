package dsa.queue;

import dsa.queue.priority.MaxPQ;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MaxPQTest {

    MaxPQ queue = new MaxPQ();

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void size() {
        assertEquals(queue.size(), 4);
    }

    @Test
    public void insert() {
        queue.insert(5);
        assertEquals(queue.size(), 5);
    }

    @Test
    public void dequeue() {
        Object last = queue.delMax();
        assertEquals(last, 4);
    }

}