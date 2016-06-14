package dsa.search;

import java.util.Objects;

public class SequentialSearch {

    public static boolean contains(Comparable[] a, Comparable b) {
        for (Comparable i : a) {
            if (Objects.equals(i, b)) {
                return true;
            }
        }
        return false;
    }
}