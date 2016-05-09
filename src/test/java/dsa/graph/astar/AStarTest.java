package dsa.graph.astar;

import dsa.graph.path.astar.Grid2d;
import dsa.graph.path.astar.Grid2d.MapNode;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * https://gist.github.com/benruijl/3385624
 */
public class AStarTest {

    public AStarTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    //
    @Test
    public void findPath() {

        double[][] map = {{0, 1, 2}, {3, 3, 2}, {0, -1, 0}};
        Grid2d map2d = new Grid2d(map, false);
        List<MapNode> path = map2d.findPath(0, 0, 2, 2);
        String found = "[(0, 0), (1, 0), (2, 0), (2, 1), (2, 2)]";
        assertEquals(path.toString(), found);

    }
}
