import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class bucketsort {
    /**
     * From https://www.programiz.com/dsa/bucket-sort
     * bucketSort()
     *   create N buckets each of which can hold a range of values
     *   for all the buckets
     *     initialize each bucket with 0 values
     *   for all the buckets
     *     put elements into buckets matching the range
     *   for all the buckets
     *     sort elements in each bucket
     *   gather elements from each bucket
     * end bucketSort
     */

    public static void main(String[] args) {
        double[] brr = {0.42, 0.32, 0.24, 0.22, 0.33, 0.52, 0.37, 0.47, 0.51, 0.25, 0.23};
        bucketSort(brr);
        System.out.println(Arrays.toString(brr));
    }

    // complexity of O(n + m)
    // One of the things here we need to think how to create the buckets, this is a memory question

    public static void bucketSort(double[] array) {
        int n = array.length;

        // we can calculate the n like in counting sort by finding max and min values
        ArrayList<Double>[] bucket = new ArrayList[n]; // creating and array of bucket (matrix/2D array/ array of arrays)
        for (int i = 0; i < n; i++) { // O(n)
            bucket[i] = new ArrayList<Double>(); // initializing every place with a bucket, represented as array by itself
        }

        for (int i = 0; i < n; i++) { // O(n)
            int bucketIndex = (int) array[i] * n;
            bucket[bucketIndex].add(array[i]); // putting each element in his right place/bucket
        }

        // osrt element in its own bucket, because we have the type and the n here, we can use 'countingSort', to keep the complexity with O(n+m)
        for (int i = 0; i < n; i++) {
            // Arrays.sort(); // quicksort --> O(nlogn), and here it will be n * nlog(n) = n^2 * log(n)
            Collections.sort(bucket[i]); // using Comperator
        }

        int index = 0;
        // get the sorted array
        for (int i = 0; i < n; i++) {
            ArrayList<Double> doubles = bucket[i];
            for (int j = 0, size = bucket[i].size(); j < size; j++) {
                array[index++] = bucket[i].get(j);
            }
        }
    }

}
