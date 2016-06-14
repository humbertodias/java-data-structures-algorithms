package dsa.sort;

public class SelectionSort{

    public void sort(Integer[] num) {
        int i, j, first, temp;
        for (i = num.length - 1; i > 0; i--) {
            first = 0;   //initialize to subscript of first element
            for (j = 1; j <= i; j++) //locate smallest element between positions 1 and i.
            {
                if (num[j] < num[first]) {
                    first = j;
                }
            }
            temp = num[first];   //swap smallest found with element in position i.
            num[first] = num[i];
            num[i] = temp;
        }
    }
}