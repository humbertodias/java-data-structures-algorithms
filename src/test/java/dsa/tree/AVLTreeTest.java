package dsa.tree;

import dsa.tree.avl.AVLTree;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class AVLTreeTest {

    AVLTree tree = new AVLTree();

    @Before
    public void setUp() {
        for (int i = 1; i < 10; i++) {
            tree.insert(i);
        }

    }

    @Test
    public void insert() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);
        tree.printBalance(out);
        String expected = "0 0 0 1 0 1 0 0 0 ";
        Assert.assertEquals(expected, baos.toString());
    }

}
