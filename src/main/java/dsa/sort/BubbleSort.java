package dsa.sort;

public class BubbleSort {

    /**
     * In bubble sort, we basically traverse the array from first to
     * array_length - 1 position and compare the element with the next one.
     * Element is swapped with the next element if the next element is greater.
     *
     * Bubble sort steps are as follows.
     *
     * 1. Compare array[0] & array[1] 2. If array[0] > array [1] swap it. 3.
     * Compare array[1] & array[2] 4. If array[1] > array[2] swap it. ... 5.
     * Compare array[n-1] & array[n] 6. if [n-1] > array[n] then swap it.
     *
     * After this step we will have largest element at the last index.
     *
     * Repeat the same steps for array[1] to array[n-1] *
     * @param intArray
     */
    public void sort(Integer[] intArray) {

        int n = intArray.length;
        int temp;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {

                if (intArray[j - 1] > intArray[j]) {
                    //swap the elements!
                    temp = intArray[j - 1];
                    intArray[j - 1] = intArray[j];
                    intArray[j] = temp;
                }

            }
        }

    }

}
