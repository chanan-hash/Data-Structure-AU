import java.util.Arrays;


public class ex5 {
    public static void main(String[] args) {
        int a[] = {4, 7, 43, 92, 59};
        quicksort(a);
        System.out.println(Arrays.toString(a));

        int[] evenOdd = {-3, 6, 12, 4, -7, 45, -6, -3, -1, 2, 3, 10, 1, 2, 3, 4, 5};
        int[] even_odd = Arrays.copyOf(evenOdd, evenOdd.length);

        even_odd_sort(evenOdd);
        System.out.println(Arrays.toString(evenOdd));

        evenOddSort(even_odd);
        System.out.println(Arrays.toString(even_odd));

        int[] values2 = {1, 6, 1, 6, 6, 1, 6, 1, 1, 6, 6};
        sort2values(values2);
        System.out.println(Arrays.toString(values2));


        int a4[] = {3, 5, 6, 7, 8, 9, 12, 13, 14, 15};
        int a5[] = {1,2,3,4,5,6,7,8,9,10};

        System.out.println(binarySereachAdd3(a4));
        System.out.println(binarySereachAdd3(a5));


    }

    // Ex1 even-odd sort
    // one way is to use quick sort, but the condition for swapping will be if it is odd = high, even = low
    // but this will be in O(nlog(n)) and not O(n)
    // This according to Maya's algorithm in the exercise
    public static void even_odd_sort(int[] arr) {
        int evenPoint = 0, oddPoint = arr.length - 1; // initial two pointers, one for even one for odd.
        // even in the beginning (because that what they wanted
        // and odd in the end from the same reason
        while (evenPoint < oddPoint) { // O(n), if all the array is only even or only odd

            while (evenPoint < arr.length && arr[evenPoint] % 2 == 0) { // because we aren't getting in this loop each time we aren't multiplying the length, for complexity
                evenPoint++;            // moving the evenPoint to the first even value
            }

            while (oddPoint >= 0 && Math.abs(arr[oddPoint] % 2) == 1) { // if we'll do %2 == 1, it won't work,
                // because of a negative numbers, so we need to put it in abs or
                // arr[oddPoint] % 2 != 0
                oddPoint--;    // moving the oddPoint to the last odd value
            }

            if (evenPoint < oddPoint) { // O(1)
                swap(arr, evenPoint, oddPoint); // 3 * O(1) --> O(1)
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
            } else if (modulu2Low == 1 && modulu2High == 1) { // means the two places are odd
                high--;                                 // not sure that we to check also, if modulu2Low == 1, works without it
            } else if (modulu2Low == 1 && modulu2High == 0) {
                swap(array, low++, high--); // swap and forward every index representation, neans in the low is odd, and the high is even, so we want to swap between them
            } else {
                low++;
                high--; // modulu2Low == 0 && modulu2High == 1 --> and this is fine situation, so we can continue, and not ot swap
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
    // The array is maximum have two values and sorting it by O(n)
    // the same idea like before, just instead even and odd, min and max
    public static void sort2values(int[] a) {
        //finding first the max value and min value
        int max = a[0], min = a[0];
        for (int i = 0; i < a.length; i++) { // O(n)
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        int l = 0, h = a.length - 1;
        while (l < h) { // O(n)
            if (a[l] > a[h]) {
                swap(a, l++, h--); // swap and change the forward the index
            } else if (a[l] == min && a[h] == min) {
                l++;
            } else if (a[l] == max && a[h] == max) {
                h--;
            } else {
                l++;
                h--;
            } // means, a[l] == min && a[h] == max, like it supposed to

        }

    }


    // Another way to do it, on actually the same idea, contributed by eyal's levi github
    // https://github.com/LeviEyal/DataStructuresCourse/blob/master/leead_exsercises/src/%D7%AA%D7%99%D7%A8%D7%92%D7%95%D7%9C%D7%99%D7%9D/ex5.java
    //Question 2: O(n) #Another option#
    public static void q2_2(int a[]) {
        int max = a[0], min = a[0], countMax = 0, countMin = 0;
        for (int i = 0; i < a.length; i++) { // O(n), findig max and min values, there are only 2 values in the array
            if (a[i] > max) max = a[i];
            if (a[i] < min) min = a[i];
        }
        for (int element : a) { // O(n) counting max and min
            if (element == max) countMax++;
            if (element == min) countMin++;
        }
        int k = 0;
        while (countMin-- > 0)
            a[k++] = min; // O(k), filing and changing/overriding the previous values in a[] from the start,
        // till count min finishes with min value
        while (countMax-- > 0)
            a[k++] = max; // O(k), from where k stopped, we're continuing filling the array with max values

        // the problem here we have 4 loop instead of 2 loop, although if with complexity it is O(n), but 4 loop against 2 its different
    }

    // Ex3


    // Ex4
    // Because it is kind of binary search so the complexity is O(log(n))
    public static int binarySereachAdd3(int[] arr) {
        // regular binary search, but the k value that we are looking is mid + 3
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;  // O(log(n))
            if (arr[mid] == mid + 3) {
                return arr[mid];
            } else if (arr[mid] > mid + 3) {
                left = mid + 1;
            } else { // arr[mid] < mid + 3
                right = mid - 1;
            }
        }

        return arr[left] == left + 1 ? arr[left] : -111111; // means if we haven't found anything,
        // still need to figure why this is the condition
    }

    // Ex5


}
