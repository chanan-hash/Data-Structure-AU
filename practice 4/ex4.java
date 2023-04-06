import java.util.Arrays;

public class ex4 {
    public static void main(String[] args) {

        int[] a = {0, 1, 2, 3, 4};
        int[] b = {6, 7, 8};
        int[] c = merge(a, b);

        System.out.println(Arrays.toString(c));

        int[] d = {-5, -4, -3, -2, -1, 0};
        System.out.println(Arrays.toString(merge3(a, b, d)));
        System.out.println();

        int[] e = {1, 2, 3, 4, 5, 5};
        System.out.println(indexSearch(a));
        System.out.println(indexSearch(b));
        System.out.println(e[5]);
        System.out.println(indexSearch(e));
        System.out.println();

        System.out.println(indexIS2(a));
        System.out.println(indexIS2(b));
        System.out.println(indexIS2(e));

    }


    // merging three sorted arrays.
    // like regular merge but with three arrays,
    // we can create a new function, or to use regular merge twice.

   /* public static int[] merge3(int[] a, int[] b, int[] c) {
        int[] d = new int[a.length + b.length + c.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length && k < c.length) {
            if (a[i++] < b[j++] && a[i++] < c[k++])
                d[i + j + k] = a[i++];
            else if (b[j++] < c[k++]){ // means b<a, but need to check if also b<c
                d[i + j + k] = b[j++];
            }
            else {
                d[i + j + k] = c[k++];
            }
        }

// putting the rest of the values but can be problem if they all length are different it can be a problem we'll need more loop for each case


        return d;
    }
    */

    // Ex1
    // lest just use merge twice
    public static int[] merge3(int[] a1, int[] a2, int[] a3) {
        return merge(a1, merge(a2, a3)); // using regular merge twice
    }

    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < b.length) {
            c[k++] = b[j++];
        }
        return c;
    }


    // Ex2
    /*
     * We need to find a number in ascending sorted array that also equals to its index, but in O(log(n)).
     * When it's usually says O(log(n)), it means binary search.
     */
    public static boolean indexSearch(int[] arr) {
        int low = 0;
        int high = arr.length;

        while (low < high) {

            int mid = (low + high) / 2;
            if (arr[mid] == mid) {
                return true;
            } else if (arr[mid] > mid) {
                low = mid + 1;
            } else { // arr[mid] < mid
                high = mid - 1;
            }
        }
        return false;
    }

    // now in recursive way

    // lest create a wrapping function
    public static boolean indexIS2(int[] a) {
        return indexIS(a, 0, a.length - 1);
    }

    public static boolean indexIS(int[] a, int low, int high) {
        if (low > high) { // here the stopping condition if we didn't find any number like that
            return false;
        }
        int middle = (low + high) / 2;
        if (a[middle] == middle) {     // another stopping condition
            return true;
        } else if (a[middle] > middle) {
            return indexIS(a, middle + 1, high);
        } else {
            return indexIS(a, low, middle - 1);
        }
    }


    // we will sort the point using merge sort according to x values, and then we will go over the whole points array and search a point that is the opposite to the specific point
    // because they are sorted we'll need to go over only once
    // because of the merge sort it will be O(nlog(n))
    // usually when it says O(nlog(n))  --> means mergesort or quicksort
    // Ex3

    public static boolean fromZero(Point[] prr) {
        mergeSortPoint(prr);
        for (int i = 0; i < prr.length - 1; i++) {
            if (prr[i].x() == -prr[i + 1].x() && prr[i].y() == -prr[i + 1].y()) {
                return true;
            }
            return false;
        }
    }

    private static void mergeSortPoint(Point[] prr) {
        mergeSortPoint(prr, 0, prr.length - 1);
    }

    private static void mergeSortPoint(Point[] prr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSortPoint(prr,0,mid);
        mergeSortPoint(prr,mid+1,high);
        merge2(prr,low,mid,high);
    }

    private static void merge2(Point[] prr, int low, int mid, int high) {

    }
}
