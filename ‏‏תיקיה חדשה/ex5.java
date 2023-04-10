import java.util.Arrays;
import java.util.function.BooleanSupplier;

public class ex5 {
    public static void main(String[] args) {
        int a[] = {4, 7, 43, 92, 59};
        quicksort(a);
        System.out.println(Arrays.toString(a));
    }

    // Ex1 even-odd sort
    // one way is to use quick sort, but the condition for swapping will be if it is odd = high, even = low
    // but this will be in O(nlog(n)) and not O(n)
    public static void even_odd_sort(int[] arr) {

    }

//    public static int oddEvenPivot(){}

    // let start form regular quick sort
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int partition(int[] array, int l, int h) {
        int pivot = array[h];
        int i = l - 1;
        for (int j = l; j < h; j++) {
            if (array[j] < pivot) {
                i++; // forwarding the low
                swap(array, i, j);
            }
        }
        swap(array, i + 1, h);
        return i + 1;
    }


    public static void quicksort(int[] a) {
        quicksort(a, 0, a.length - 1);
    }

    public static void quicksort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int pivot = partition(arr, low, high);
        quicksort(arr, low, pivot - 1);
        quicksort(arr, pivot + 1, high);
    }

}
