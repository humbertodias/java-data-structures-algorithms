package dsa.tree.test;

import dsa.tree.huffman.Huffman;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HuffmanTest {

    String text = "The quieter you become, the more you can hear.";
    String tcompress = "100001010111110100011100110001011101001110111110101100001001110001001110011000010111100101110010010101111100101000011111111010110000100111000111011101100110101011110111011101101";

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Huffman.parseFrequences(text);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void compress() throws IOException {
        Assert.assertEquals(tcompress, Huffman.compress(text));
    }

    @Test
    public void decompress() throws IOException {
        Assert.assertEquals(text, Huffman.decompress(tcompress));
    }

    @Test
    public void compressLength() throws IOException {
        Assert.assertEquals(177, tcompress.length());
    }

    @Test
    public void decompressLenght() throws IOException {
        Assert.assertEquals(text.length(), Huffman.decompress(tcompress).length());
    }

}
