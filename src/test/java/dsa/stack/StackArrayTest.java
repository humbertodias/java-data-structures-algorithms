/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa.stack;

import org.junit.*;

import static org.junit.Assert.assertEquals;


public class StackArrayTest {

    StackArray stack = new StackArray();

    public StackArrayTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void size() {
        assertEquals(stack.size(), 4);
    }

    @Test
    public void push() {
        stack.push(5);
        assertEquals(stack.size(), 5);
    }

    @Test
    public void pop() {
        stack.push(6);
        Object last = stack.pop();
        assertEquals(last, 6);
    }

}
