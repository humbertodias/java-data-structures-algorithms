package dsa.tree;

import dsa.tree.bst.BinarySearchTree;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BSTTreeTest {

    BinarySearchTree t = new BinarySearchTree();

    public BSTTreeTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void size() {
        assertEquals(t.countNodes(), 4);
    }

    @Test
    public void preorder() {
        assertEquals(t.preorder().toString(), "[1, 2, 3, 4]");
    }

    @Test
    public void postorder() {
        assertEquals(t.postorder().toString(), "[4, 3, 2, 1]");
    }

    @Test
    public void inorder() {
        assertEquals(t.inorder().toString(), "[1, 2, 3, 4]");
    }

}