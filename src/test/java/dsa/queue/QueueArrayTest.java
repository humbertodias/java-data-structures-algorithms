package dsa.queue;

import dsa.queue.QueueArray;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueArrayTest {

    QueueArray queue = new QueueArray();

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void size() {
        assertEquals(queue.size(), 4);
    }

    @Test
    public void enqueue() {
        queue.enqueue(5);
        assertEquals(queue.size(), 5);
    }

    @Test
    public void dequeue() {
        Object last = queue.dequeue();
        assertEquals(last, 1);
    }

}
