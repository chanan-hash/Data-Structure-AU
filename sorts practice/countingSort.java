import java.util.Arrays;

public class countingSort {

    /**
     * This sorting is basing on to facts:
     * 1. The numbers are in bounded range
     * 2. Integer can be also an index in the array
     * <p>
     * A. calculating the range of the array --> max - min + 1
     * B. creating new Zero array c[]
     * C. going over first array and counting the phases of each element in the first array, and adding the count in c[]
     * C2.The index j = a[i] - min --> that how we can increase the place even after we went after it, we can go back, because it according to the number
     * C3. c[j] = j + 1
     * <p>
     * Complexity - O(n + range), because of the last loop
     */

    /*
    // The pseudo-code https://www.programiz.com/dsa/counting-sort
    // different from the elizabet's algorithm
    The pseudo-code
    countingSort(array)
    c = new [array.length+1]
    max <- find largest element in array O(n)
        initialize count array with all zeros, in java its automatically
    for j <- 0 to size
        find the total count of each unique element and
        store the count at jth index in count array
    for i <- 1 to max
        find the cumulative sum and store it in count array itself
    for j <- size down to 1
        restore the elements to array
    decrease count of each element restored by 1
     */
    public static void main(String[] args) {

        int[] arr = {2, 3, 4, 4, 5, 2, 7, 9, -1, 8, 7, 9, 0, 0, 0, 2, 8};
        int[] arr2 = {2, 3, 4, 4, 5,-1, 2, 9, 8, 4,-1, 11, 10, 0, 0, 0, 2, 8};

        System.out.println(Arrays.toString(arr));
        countin_Sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println();
        System.out.println(Arrays.toString(arr2));
        cumulativeFrequency(arr2);
        System.out.println(Arrays.toString(arr2));

    }

    // Regular counting sort
    public static void countin_Sort(int[] arr) { // O(n+range)
        /** finding max and min, for range **/
        int max = arr[0], min = arr[0]; // lest asune they are in the beginning just for initializing
        for (int i = 0; i < arr.length; i++) {  // O(n)
            if (arr[i] > max) {
                max = arr[i];
            } // O(1)
            if (arr[i] < min) {
                min = arr[i];
            } // O(1)
        }

        int range = max - min + 1;
        /** creating count/frequency array, for each element **/
        int[] count = new int[range]; // O(n)
        for (int j = 0; j < arr.length; j++) {
            count[arr[j] - min]++;
        }
        /** sorting the original array, according to the counting array **/
        // Notice!!!! not every nested loop is multiplication of thew 2 sizes,
        // only if it's happening for each element in the first loop we are going into the second loop
        // if we aren't going for each element into the second array, we are adding the sizes
        // here we don't know for each element if we are going into the second loop, it depends on if that number was in the original array, and not just an index
        int k = 0;
        for (int l = 0; l < count.length; l++) { // O(n + range)
            for (int h = 0; h < count[l]; h++) { // in each iteration if it is happening we are going again till the place in the counting array,
                // and putting the number we've counted, according to the min + index
                arr[k++] = min + l;
            }
        }
    }


    // Cumulative frequency counting sort
    public static void cumulativeFrequency(int[] a) {
        /** The beginning is similar **/
        // finding the min and max
        int min = a[0], max = a[0];
        for (int i = 0; i < a.length; i++) { // O(n)
            if (a[i] > max) {
                max = a[i];
            } // O(1)
            if (a[i] < min) {
                min = a[i];
            } // O(1)
        }
        // making hte count array for each element
        int size = max - min + 1;
        int[] couting = new int[size];
        for (int j = 0; j < a.length; j++) { // O(n)
            couting[a[j] - min]++; // counting according to the size/range
        }

        // The cumulative frequency, the only difference
        for (int k = 1; k < size; k++) {
            couting[k] = couting[k] + couting[k - 1];
        }

        for (int i = 0, j = 0; j < size; j++) {
            while (i < couting[j]) {
                a[i++] = j + min;
            }
        }

    }

}
