package dsa.tree.huffman;

import java.util.*;
import java.io.*;

public class Huffman {

    public static PriorityQueue<Node> q;
    public static HashMap<Character, String> charToCode;
    public static HashMap<String, Character> codeToChar;

    /**
     *
     * @param text
     */
    public static void parseFrequences(String text) {
        // Count the frequency of all the characters
        HashMap<Character, Integer> dict = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char a = text.charAt(i);

            if (dict.containsKey(a)) {
                dict.put(a, dict.get(a) + 1);
            } else {
                dict.put(a, 1);
            }
        }

        // Create a forest (group of trees) by adding all the nodes to a priority queue
        q = new PriorityQueue<>(100, new FrequencyComparator());
        int n = 0;

        for (Character c : dict.keySet()) {
            q.add(new Node(c, dict.get(c)));
            n++;
        }

        // Identify the root of the tree
        Node root = huffman(n);

        // Build the table for the variable length codes
        buildTable(root);

    }

    public static void main(String[] args) throws FileNotFoundException {
        // Read all the contents of the file
        //String text = new Scanner(new File("input.txt")).useDelimiter("\\A").next(); // nextLine(); // change it if you only want to read a single line without the new line character.

        String text = "The quieter you become, the more you can hear.";

        parseFrequences(text);

        String compressed = compress(text);
        System.out.println("The compressed used a total of " + compressed.length() + " bits");
        System.out.println(compressed);

        String decompressed = decompress(compressed);
        System.out.println("The original text used a total of " + decompressed.length() + " characters");
        System.out.println(decompressed);

        //saveToFile(compressed);
    }

    // This method builds the tree based on the frequency of every characters
    public static Node huffman(int n) {
        Node x, y;

        for (int i = 1; i <= n - 1; i++) {
            Node z = new Node();
            z.left = x = q.poll();
            z.right = y = q.poll();
            z.freq = x.freq + y.freq;
            q.add(z);
        }

        return q.poll();
    }

    // This method builds the table for the compression and decompression
    public static void buildTable(Node root) {
        charToCode = new HashMap<>();
        codeToChar = new HashMap<>();

        postorder(root, new String());
    }

    // This method is used to traverse from ROOT-to-LEAVES
    public static void postorder(Node n, String s) {
        if (n == null) {
            return;
        }

        postorder(n.left, s + "0");
        postorder(n.right, s + "1");

        // Visit only nodes with keys
        if (n.alpha != '\0') {
            System.out.println("\'" + n.alpha + "\' -> " + s);
            charToCode.put(n.alpha, s);
            codeToChar.put(s, n.alpha);
        }
    }

    // This method assumes that the tree and dictionary are already built
    public static String compress(String s) {
        String c = new String();

        for (int i = 0; i < s.length(); i++) {
            c = c + charToCode.get(s.charAt(i));
        }

        return c;
    }

    // This method assumes that the tree and dictionary are already built
    public static String decompress(String s) {
        String temp = new String();
        String result = new String();

        for (int i = 0; i < s.length(); i++) {
            temp = temp + s.charAt(i);

            if (codeToChar.containsKey(temp)) {
                result = result + codeToChar.get(temp);
                temp = new String();
            }
        }

        return result;
    }

    public static void saveToFile(String l) throws FileNotFoundException {
        try (PrintWriter oFile = new PrintWriter("output.txt")) {
            for (String s : codeToChar.keySet()) {
                oFile.println(s + "->" + codeToChar.get(s));
            }

            oFile.println(l);
        }
    }

}

class Node {

    public char alpha;
    public int freq;
    public Node left, right;

    public Node(char a, int f) {
        alpha = a;
        freq = f;
    }

    public Node() {

    }

    @Override
    public String toString() {
        return alpha + " " + freq;
    }

}

class FrequencyComparator implements Comparator<Node> {

    @Override
    public int compare(Node a, Node b) {
        int freqA = a.freq;
        int freqB = b.freq;

        return freqA - freqB;
    }

}
