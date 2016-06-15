package dsa.graph;

import dsa.graph.path.BellmanFord;
import org.junit.Test;
import static org.junit.Assert.*;

public class BellmanFordTest {

    public BellmanFordTest() {
    }

    @Test
    public void testBellmanFordWithPositiveEdges() throws Exception {
        Integer[][] weight = {
            {null, 10, null, null, 3},
            {null, null, 2, null, 1},
            {null, null, null, 7, null},
            {null, null, 9, null, null},
            {null, 4, 8, 2, null}
        };
        int source = 0;
        BellmanFord instance = new BellmanFord();
        Integer[][] expResult = {{-1, 4, 1, 4, 0}, {0, 7, 9, 5, 3}};
        Integer[][] result = instance.singleSourceShortestPath(weight, source);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testBellmanFordWithNegativeEdges() throws Exception {
        Integer[][] weight = {
            {null, -1, 4, null, null},
            {null, null, 3, 2, 2},
            {null, null, null, null, null},
            {null, 1, 5, null, null},
            {null, null, null, -3, null}
        };
        int source = 0;
        BellmanFord instance = new BellmanFord();
        Integer[][] expResult = {{-1, 0, 1, 4, 1}, {0, -1, 2, -2, 1}};
        Integer[][] result = instance.singleSourceShortestPath(weight, source);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testBellmanFordWithNegativeCycle() {
        Integer[][] weight = {
            {null, -1, 4, null, null},
            {null, null, 3, 2, 2},
            {null, -6, null, null, null},
            {null, 1, 5, null, null},
            {null, null, null, -3, null}
        };
        int source = 0;
        BellmanFord instance = new BellmanFord();
        try {
            instance.singleSourceShortestPath(weight, source);
            fail("Should have thrown an exception: Negative weight cycle");
        } catch (Exception ex) {
            assertTrue(true);
        }
    }
}