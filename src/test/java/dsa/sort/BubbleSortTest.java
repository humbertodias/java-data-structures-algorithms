package dsa.sort;

import java.util.Arrays;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {

    BubbleSort sorter = new BubbleSort();
    Integer[] input = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};

    @Before
    public void setUp() {
    }

    @Test
    public void sort() {
        Integer[] expected = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
        Arrays.sort(expected);
        Integer[] sorted = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
        sorter.sort(sorted);
        System.out.println("dsa.sort.BubbleSortTest.sort()" + Arrays.toString(expected));
        System.out.println("dsa.sort.BubbleSortTest.sort()" + Arrays.toString(sorted));
        Assert.assertArrayEquals(expected, sorted);
    }

}
