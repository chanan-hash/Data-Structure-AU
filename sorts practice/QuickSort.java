import java.util.Arrays;

public class QuickSort {

    /**
     * This sort is built on the concept of partition of a pivot
     * <p>
     * The psoudo-code:
     * <p>
     * quicksort( arr, low, high){
     *      if(low < high){
     *      pivot = partition(arr,low,high)
     *      quicksort(arr,low,pivot-1)
     *      quicksort(arr,pivot+1,high)
     *   }
     * }
     * <p>
     * partition(arr,L,H){
     *    pivot = L  // in this algorithm the pivot starting from the low
     *    L = L + 1
     *    while (L<H){
     *        if (arr[L] <= arr[pivot]){ // means it in the right place and we will check the next element after the low
     *              L = L + 1           // because in the end we will change the place of the pivot,
     *                                  // although the values is now on the place after the pivot
     *                                  // because in the beginning we've advanced the L (low = low + 1)
     *                     // but according tto the place and because the pivot will change it is theoretically in the right place
     *        }
     *        else if (arr[H] > arr[pivot]) {// means it in the right place, and we will check the previous element before the high
     *          H = H - 1
     *        }
     *        else{
     *              swap(arr[low], arr[high]) // because it is not in the right place rhe value is high, and it in the low place,
     *       }   //so we need to push it up
     *      }
     *      swap(arr[high],arr[pivot]) // putting the pivot in the right place, because the high went down almost towards to the pivot place
     *      return high // pivot = high // because we've swapped them
     *  }
     */


    public static void main(String[] args) {
        int a[] = {7, 3, 9, 5, 4, 8, 1};
        quicksort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high); // This function is O(n), because we can go threw over the whole array in liner order,
            // because  of the while loop
            quickSort(arr, low, pivot - 1); // The recursive call, then we are splitting the array
            quickSort(arr, pivot + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = low;
        low++;
        while (low <= high) {
            if (arr[low] <= arr[pivot]) {
                low += 1;
            } else if (arr[high] >= arr[pivot]) {
                high = high - 1;
            } else {
                swap(arr, low, high);
            }
        }
        swap(arr, high, pivot);
        return high;
    }

    // Casing function that will be more comfortable to use the sort, that we need to pass only the array itself
    public static void quicksort(int [] a){
        quickSort(a,0, a.length-1);
    }

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
