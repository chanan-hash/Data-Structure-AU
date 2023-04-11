import java.util.Arrays;
import java.util.function.BooleanSupplier;

public class ex5 {
    public static void main(String[] args) {
        int a[] = {4, 7, 43, 92, 59};
        quicksort(a);
        System.out.println(Arrays.toString(a));

        int[] evenOdd = {-3,6,12,4,-7,45,-6,-3,-1,2,3,10,1,2,3,4,5};
        int [] even_odd = Arrays.copyOf(evenOdd, evenOdd.length);

        even_odd_sort(evenOdd);
        System.out.println(Arrays.toString(evenOdd));

        evenOddSort(even_odd);
        System.out.println(Arrays.toString(even_odd));

    }

    // Ex1 even-odd sort
    // one way is to use quick sort, but the condition for swapping will be if it is odd = high, even = low
    // but this will be in O(nlog(n)) and not O(n)
    // This according to Maya's algorithm in the exercise
    public static void even_odd_sort(int[] arr) {
            int evenPoint = 0, oddPoint = arr.length-1; // initial two pointers, one for even one for odd.
                                                        // even in the beginning (because that what they wanted
                                                        // and odd in the end from the same reason
        while (evenPoint < oddPoint){ // O(n), if all the array is only even or only odd

            while (evenPoint < arr.length && arr[evenPoint] % 2 == 0){ // because we aren't getting in this loop each time we aren't multiplying the length, for complexity
            evenPoint++;            // moving the evenPoint to the first even value
            }

            while (oddPoint >= 0 && Math.abs(arr[oddPoint] % 2) == 1){ // if we'll do %2 == 1, it won't work,
                                                                       // because of a negative numbers, so we need to put it in abs or
                                                                       // arr[oddPoint] % 2 != 0
                    oddPoint--;    // moving the oddPoint to the last odd value
            }

            if(evenPoint < oddPoint){ // O(1)
                swap(arr,evenPoint,oddPoint); // 3 * O(1) --> O(1)
            }
        }
    }

    // Another way to do it, on actually the same idea, contributed by eyal's levi github
    // https://github.com/LeviEyal/DataStructuresCourse/blob/master/leead_exsercises/src/%D7%AA%D7%99%D7%A8%D7%92%D7%95%D7%9C%D7%99%D7%9D/ex5.java
    public static void evenOddSort(int[] array) {
        int low = 0, high = array.length - 1;
        while (low < high) {
            int modulu2Low = Math.abs(array[low] % 2); // in abs because of negative numbers
            int modulu2High = Math.abs(array[high] % 2);

            if (modulu2Low == 0 && modulu2High == 0) { // means the two places are even, and we want to swap between even and odd. and not both even
                                                        // because then we haven't done anything, we'll still have the even in the end, and not, in the beginning
                low++;
                }
            else if (modulu2Low == 1 && modulu2High == 1) { // means the two places are odd
                high--;                                 // not sure that we to check also, if modulu2Low == 1, works without it
            }
            else if (modulu2Low == 1 && modulu2High == 0){
                swap(array,low++,high--); // swap and forward every index representation, neans in the low is odd, and the high is even, so we want to swap between them
            }
            else {
                low++; high--; // modulu2Low == 0 && modulu2High == 1 --> and this is fine situation, so we can continue, and not ot swap
            }
        }

    }

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


    // Ex2

}
