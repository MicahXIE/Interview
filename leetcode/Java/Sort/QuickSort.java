import java.util.Arrays;

public class QuickSort {   // time O(nlogn) worst: O(n^2) space O(logn) function stack

    public static void main(String[] args) {
        int array[] = {32, 12, 7, 78, 23, 45};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = partition(array, left, right);
            quickSort(array, left, mid);
            quickSort(array, mid + 1, right);            
        }

    }

    public static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int i = left;
        int j = right;

        while (i < j) {

            while (i < j && array[j] > pivot)
                --j;
            array[i] = array[j];

            while (i < j && array[i] < pivot)
                ++i;
            array[j] = array[i];
        }

        array[i] = pivot;
        return i;

    }


}