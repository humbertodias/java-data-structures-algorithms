package dsa.tree;

import dsa.tree.huffman.BitStream;
import dsa.tree.huffman.HuffmanTree;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HuffmanTreeTest {

    String testString = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt "
            + "ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco "
            + "laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in "
            + "voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat "
            + "non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    int[] frequencies;
    HuffmanTree ht;
    BitStream encoded;

    @Before
    public void setup() {
        // get frequency array
        frequencies = HuffmanTree.getFrequencies(testString);

        // create huffman tree from frequencies
        ht = new HuffmanTree(frequencies);

        encoded = ht.encode(testString);

    }

    @Test
    public void textLength() {
        assertEquals(445, testString.length());
    }

    @Test
    public void frequencyArray() {
        String sfrequencies = "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 68, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 29, 3, 16, 18, 37, 3, 3, 1, 42, 0, 0, 21, 17, 24, 29, 11, 5, 22, 18, 32, 28, 3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]";
        assertEquals(sfrequencies, Arrays.toString(frequencies));
    }

    @Test
    public void displayCodes() {
        String codes = "32 : 110\n"
                + "44 : 0101111\n"
                + "46 : 000000\n"
                + "68 : 000011010\n"
                + "69 : 000011011\n"
                + "76 : 00001000\n"
                + "85 : 00001001\n"
                + "97 : 1000\n"
                + "98 : 0101100\n"
                + "99 : 10110\n"
                + "100 : 11101\n"
                + "101 : 1111\n"
                + "102 : 0101101\n"
                + "103 : 0101110\n"
                + "104 : 00001100\n"
                + "105 : 001\n"
                + "108 : 0001\n"
                + "109 : 10111\n"
                + "110 : 0110\n"
                + "111 : 1001\n"
                + "112 : 01010\n"
                + "113 : 000001\n"
                + "114 : 0100\n"
                + "115 : 11100\n"
                + "116 : 1010\n"
                + "117 : 0111\n"
                + "118 : 0000111\n"
                + "120 : 0000101\n";
        assertEquals(codes, ht.displayCodes());
    }

    @Test
    public void encodeDecode() throws FileNotFoundException, IOException {

        // get BitStream of tree
        BitStream bs = ht.getEncodedTree();

        String bbs = bs.toString();
        assertEquals("\n2 5d 71 14 ca ad e0 b4 28 94 5b b5 b2 d2 5c 97 2 c5 66 59 e5 8b 75 d4 \n58 6d eb a2 c7 6d 48 b 9d 92 ca 1 ", bbs);

        int treelen = bs.getBank().length;
        assertEquals(36, treelen);

        // encode string to bitstream
        BitStream os = ht.encode(testString);

        String oos = "\n8 94 fb e2 ae 3d f7 64 65 37 d 68 bf d2 fd 69 6e 7d ab e9 d3 47 4a 8f \n"
                + "2c 59 76 f1 34 bf 73 fb bb 3b cb f2 f3 dd 5f 75 4a 62 d6 3d 3d 76 ac f5 \n"
                + "86 16 4a 7e fa dd 91 94 fd 78 5c d1 a0 48 2f 0 60 9a de c6 fa 3b ae 58 \n"
                + "df 7 f6 31 75 f8 17 3c cd 3c a4 7e ef b e9 63 51 46 5b 38 8c 5e d3 86 \n"
                + "16 4a 1e 66 3c 39 eb 40 90 5c ab 78 5d f1 ad 37 bc f6 75 a5 b9 e0 bc 50 \n"
                + "18 34 e7 9a 1e bf 14 74 fd d9 19 4c 5b 27 a9 3c 33 db be 86 b1 6c 1e 45 \n"
                + "d5 51 5f 83 f8 9a df ce 7e b1 11 7b ee c8 ca 7e f7 cb 5d 71 8a cc e2 31 \n"
                + "95 8 62 9d 0 c1 b0 b6 f5 57 ba 6e 16 ad 36 b4 7d a2 b5 9d 47 b1 51 59 \n"
                + "a5 b2 92 4f 7d a9 7e e3 b5 62 da ce 2a 8c b 9d 2b 56 9b 18 dd fe 7a 3b \n"
                + "56 bc 88 9a d0 c6 f8 f7 7f 2b c 2c 94 7b 80 1 ";
        assertEquals(oos, os.toString());

        int datalen = os.getBank().length;
        assertEquals(232, datalen);

        int compressedLength = (datalen + treelen);
        assertEquals(268, compressedLength);

        int orig = testString.length();
        int compressedPercent = (int) (((float) (orig - treelen - datalen) / orig) * 100);
        assertEquals(39, compressedPercent);

        // re-create huffman tree from encoded bitstream
        HuffmanTree dt = new HuffmanTree(bs);

        String codes = "32 : 110\n"
                + "44 : 0101111\n"
                + "46 : 000000\n"
                + "68 : 000011010\n"
                + "69 : 000011011\n"
                + "76 : 00001000\n"
                + "85 : 00001001\n"
                + "97 : 1000\n"
                + "98 : 0101100\n"
                + "99 : 10110\n"
                + "100 : 11101\n"
                + "101 : 1111\n"
                + "102 : 0101101\n"
                + "103 : 0101110\n"
                + "104 : 00001100\n"
                + "105 : 001\n"
                + "108 : 0001\n"
                + "109 : 10111\n"
                + "110 : 0110\n"
                + "111 : 1001\n"
                + "112 : 01010\n"
                + "113 : 000001\n"
                + "114 : 0100\n"
                + "115 : 11100\n"
                + "116 : 1010\n"
                + "117 : 0111\n"
                + "118 : 0000111\n"
                + "120 : 0000101\n";

        assertEquals(codes, dt.displayCodes());

        // decode back to string
        String output = dt.decode(os);
        assertEquals(testString, output);
    }

    @Test
    public void decode() {
        String decoded = ht.decode(encoded);
        assertEquals(testString, decoded);
    }

    @Test
    public void encode() {
        assertEquals(encoded, ht.encode(testString));
    }

}