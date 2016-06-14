package dsa.search;

public class BinarySearch {

    public static boolean contains(Comparable[] a, Comparable b) {
        if (a.length == 0) {
            return false;
        }
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
//            if (b > a[middle]) {
            if (b.compareTo(a[middle]) >= 1) {
                low = middle + 1;
//            } else if (b < a[middle]) {
            } else if (b.compareTo( a[middle] ) <= -1 ) {
                high = middle - 1;
            } else { // The element has been found
                return true;
            }
        }
        return false;
    }
}
