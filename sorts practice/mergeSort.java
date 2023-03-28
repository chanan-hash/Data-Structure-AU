import java.util.Arrays;

public class mergeSort {
    /**
     * The psudo-code:
     * <p>
     * we need two functions for it:
     * 1. Merging two sorted arrays
     * 2. The recursive merge sort on One array, that splitting into half each calling the array, and using the merge function in it
     * <p>
     * merge(a1[],a2[]){ //sorted arrays
     * res = [a1.length + a2.length] --> new array
     * i = 0
     * j = 0
     * while (i < L1 && j < L2){ // every variable is smaller from each array length
     * if(a1[i] < a2[j]) res[i+j] = a1[i++]
     * else  res[i+j] = a2[j++]
     * }
     * while (i < L1){
     * res[i+j] = a1[i++]
     * }
     * while (j < L2){
     * res[i+j] = a2[j++}
     * }
     * return res;
     * }
     * <p>
     * mergeSort(a[],L, H){
     * n = H - L // the length
     * if(n<=1) return; // we have only one value
     * mid = (H + L)/2
     * mergeSort(a[],L,mid)
     * mergeSort(a[],mid,H)
     * <p>
     * merge (a[l,mid],a[mid,H])
     * }
     */

    public static void main(String[] args) {

        int[] arr = {1, 52, 63, 673, 3, 6, 3};
        merge_sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * We need the main function of the sort --> merging 2 sorted arrays into a One array.
     * Then we will to it recursively on a One array, that we are splitting into half each time
     * <p>
     * This is a void functions !!
     * /
     * <p>
     * public static int[] merge(int[] arr1, int[] arr2) {
     * int[] newArr = new int[arr1.length + arr2.length]; //new array with the sum of both length
     * int i = 0, j = 0, k = 0; // when k = i+j index
     * while (i < arr1.length && j < arr2.length) { // O(n+m) running on both of the  loop at the same time
     * if (arr1[i] < arr2[j]) {
     * newArr[k++] = arr1[i++]; // it like to say newArr[i+j] = arr[i], and then i++
     * } else {
     * newArr[k++] = arr2[j++];
     * }
     * }
     * while (i < arr1.length) {
     * newArr[k++] = arr1[i++];
     * } // if arr1.length != arr2.length
     * // and arr1 > arr2 we need to add the rest of the values from arr1
     * while (j < arr2.length) {
     * newArr[k++] = arr2[j++];
     * } // same as above if  arr1 < arr2
     * return newArr;
     * }
     * <p>
     * /*
     * now we will do it on One array, we will split into half the array each time, what will give us O(log(n))
     * but every recursive call will call O(n)
     */

    // for convenient we will do the merge function on One array and two pointers instead with two arrays
    public static void merge(int[] a, int l, int m, int h) {
        // what that funny, that if the array is sorted we are just sorting a sorted array,
        // but it will help us to merge the array after it in the recursion
//        int[] a1 = Arrays.copyOfRange(a, l, m - l + 1);
//        int[] a2 = Arrays.copyOfRange(a, m, h);

        int a1[] = new int[m - l + 1];
        int a2[] = new int[h - m];

        // fill the left and right array
        for (int i = 0; i < a1.length; i++) {
            a1[i] = a[l + i];
        }
        for (int j = 0; j < a2.length; j++) {
            a2[j] = a[m + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = l;

//        int[] res = new int[a.length];

        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                a[k++] = a1[i++];
            } else {
                a[k++] = a2[j++];
            }
        }
        while (i < a1.length) {
            a[k++] = a1[i++];
        }
        while (j < a2.length) {
            a[k++] = a2[j++];
        }
        //return res;
    }

    public static void merge_sort(int[] arr) {
        merge_sort(arr, 0, arr.length - 1);
    }

    public static void merge_sort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            merge_sort(arr, low, middle);
            merge_sort(arr, middle + 1, high);
            merge(arr, low, middle, high);
        }
    }
}
