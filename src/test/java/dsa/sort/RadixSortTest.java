package dsa.sort;

import java.util.Arrays;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RadixSortTest {

    RadixSort sorter = new RadixSort();
    Integer[] input = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};

    @Before
    public void setUp() {
    }

    @Test
    public void sort() {
        Integer[] expected = input.clone();
        Arrays.sort(expected);
        Integer[] sorted = input.clone();
        sorter.sort(sorted);
        assertArrayEquals(expected, sorted);
    }

}
