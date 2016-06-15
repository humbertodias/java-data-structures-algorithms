package dsa.graph;

import dsa.graph.GraphMatrix;
import dsa.graph.GraphMatrix;
import java.util.Arrays;
import java.util.List;
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
public class DFSTest {

    private GraphMatrix graphMatrix;
    
    public DFSTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
//                        0  1  2  3  4  5  6  7  8
// ===================================================
              int [][] conn = {  { 0, 1, 0, 1, 0, 0, 0, 0, 1 },  // 0
			{ 1, 0, 0, 0, 0, 0, 0, 1, 0 },  // 1
			{ 0, 0, 0, 1, 0, 1, 0, 1, 0 },  // 2
			{ 1, 0, 1, 0, 1, 0, 0, 0, 0 },  // 3
			{ 0, 0, 0, 1, 0, 0, 0, 0, 1 },  // 4
			{ 0, 0, 1, 0, 0, 0, 1, 0, 0 },  // 5
			{ 0, 0, 0, 0, 0, 1, 0, 0, 0 },  // 6
			{ 0, 1, 1, 0, 0, 0, 0, 0, 0 },  // 7
			{ 1, 0, 0, 0, 1, 0, 0, 0, 0 } };
              
              graphMatrix = new GraphMatrix(conn);
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void dfs() {
         Integer[] walk = {0, 1, 7, 2, 3, 4, 8, 5, 6};
         List<Integer> dfs = Arrays.asList(walk);
         assertEquals(dfs, graphMatrix.dfs() );
     }
}
