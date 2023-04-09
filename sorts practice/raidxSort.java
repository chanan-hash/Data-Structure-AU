import java.util.Arrays;

public class raidxSort {
    public static void main(String[] args) {
        int[] array = {6, 4, 7, 4, 6, 3, 2};
        radixsort(array);
        System.out.println(Arrays.toString(array));
        int[] brray = {6, 4, 45,614,5394,3920,0,472,5,2523,53,603, 3, 2};
        radixsort(brray);
        System.out.println(Arrays.toString(brray));
    }

    /**
     * This radix sort is according to Lsd to Msd, because in that way is stays stable.
     * If we're working the opposite sorting in descending order from MSD to LSD, it won't stay stable sort
     */
    public static void radixsort(int[] a) {
        int max = a[0], exp = 1, base = 10;
        int[] temp = new int[a.length];
        for (int i = 1; i < a.length; i++) { // O(n) finding the max value for the biggest number digits
            if (a[i] > max) {
                max = a[i];
            }
        }

        while (max / exp > 0) { // O(log(n)), we are dividing every iteration with the exponent, here the log is on 10 base
            int[] bucket = new int[base];
            int k = 0;
            for (int j = 0; j < a.length; j++) { // O(n)
                k = (a[j] / exp) % 10; // getting the digit itself
                bucket[k]++; // adding it to the bucket array, and forwarding to the next cell in the bucket array
            }

            for (int i = 1; i < base; i++) { // O(base)
                bucket[i] = bucket[i] + bucket[i - 1]; // like in counting sort with cumulative frequency
            }
            for (int j = a.length-1; j >= 0; j--) { // O(n)
                temp[--bucket[(a[j] / exp) % base]] = a[j]; // its important that the -- will be before the bucket, and not after it
                                                            // --bucket[] != bucket[]--. they are not similar, they are different
                // means:
                // j = [(a[i] / exp)] % base
                // index = --bucket[j]
                // temp[index] = a[i]
            }
            for (int i = 0; i < a.length; i++) { // O(n)
                a[i] = temp[i]; // copy temp to a[]
            }
            exp = exp * base; // increasing the exponent by 10, because we are in decimal counting, so that how we are moving to the next digit place
        }
    }

}
