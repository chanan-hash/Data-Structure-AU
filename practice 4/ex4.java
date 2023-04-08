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

        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        Point p3 = new Point(5, 6);
        Point p4 = new Point(7, 8);
        Point p5 = new Point(9, 10);
        Point p6 = new Point(11, 12);
        Point p7 = new Point(13, 14);
        Point p8 = new Point(15, 16);
        Point p9 = new Point(-1, -2);


        Point[] prr = {p4, p6, p8, p1, p5, p2, p3, p7, p9};
        System.out.println(Arrays.toString(prr));
        mergeSortPoint(prr);
        System.out.println(Arrays.toString(prr));
        System.out.println(fromZero(prr));

        System.out.println(isEqualToA(e, 6));
        System.out.println(isEqualToA(e, 11));

        int[] a4 = {2, 6, 3, 8, 3, 9, 3, 55, 7, 223, 9};
        mergesort(a4);
        System.out.println(Arrays.toString(a4));

        System.out.println(Arrays.toString(intersection(d, e)));
        System.out.println(Arrays.toString(intersection(e, a4)));
        int[] a5 = {1, 4, 2, 5, 6};
        System.out.println(Arrays.toString(intersection(e, a5)));
        System.out.println(Arrays.toString(intersection(e, e)));
        System.out.println(Arrays.toString(intersection2(e, e)));


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
        }
        return false;
    }

    private static void mergeSortPoint(Point[] prr) {
        mergeSortPoint(prr, 0, prr.length - 1);
    }

    private static void mergeSortPoint(Point[] prr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSortPoint(prr, 0, mid);
        mergeSortPoint(prr, mid + 1, high);
        merge2(prr, low, mid, high);
    }

    // sorting a point array according to x values
//    private static void merge2(Point[] prr, int low, int mid, int high) {
//        Point[] ptemp = new Point[high - low + 1]; // the new size of the temp array
//        int i = low, j = mid + 1, k = 0;
//        while (low <= mid && j <= high) {
//            if (Math.abs(prr[i].x()) < Math.abs(prr[j].x())) {
//                ptemp[k++] = prr[i++];
//            } else {
//                ptemp[k++] = prr[j++];
//            }
//        }
//        // adding the rest of the values
//        while (i <= mid) {
//            ptemp[k++] = prr[i++];
//        }
//        while (j <= high) {
//            ptemp[k++] = prr[j++];
//        }
//        // copying the temp sorted array to the original array
//        for (int t = 0; t < ptemp.length; t++) {
//            prr[t + low] = ptemp[t];
//        }
//
//    }

    // was contributed from  eyal's levi github, https://github.com/LeviEyal/DataStructuresCourse/blob/master/leead_exsercises/src/%D7%AA%D7%99%D7%A8%D7%92%D7%95%D7%9C%D7%99%D7%9D/ex4.java
    private static void merge2(Point[] a, int l, int m, int h) {
        Point t[] = new Point[h - l + 1];
        int i = l, j = m + 1;
        int k = 0;
        while (i <= m && j <= h) {
            if (Math.abs(a[i].x()) < Math.abs(a[j].x())) // we want the sort in abs, because it just for the calculating after it, and can save time
                // but we can sort it regularly and then to check as we've done
                t[k++] = a[i++];
            else t[k++] = a[j++];
        }
        while (i <= m) t[k++] = a[i++];
        while (j <= h) t[k++] = a[j++];
        //copy from t to a
        for (i = 0; i < t.length; i++)
            a[l + i] = t[i];
    }

    // Ex4
    // finding to values the equal to 'a' value in sorted array and with complexity of O(n)
    // To do it we will initial two pointers and while they're different we will continue checking
    public static boolean isEqualToA(int[] array, int a) {
        int l = 0, r = array.length - 1;
        while (l < r) {
            if (array[l] + array[r] == a) {
                return true;
            } else if (array[l] + array[r] < a) {
                l++;
            } else {
                r--;
            }
        }
        return false; // we haven't found numbers like that
    }

    // Ex5
    // the function gets to equal length arrays, and returning an intersection array by O(nlog(n))
    public static int[] intersection(int[] a1, int[] a2) {
        // Starting by sorting the two arrays with merge sort, it can be also with quicksort
        mergesort(a1); // O(nlog(n))
        mergesort(a2); // O(nlog(n))
        int i = 0, j = 0, counter = 0;
        int[] a3 = new int[a1.length];

        while (i < a1.length && j < a2.length) { // O(n)
            if (a1[i] == a2[j]) {
                a3[counter++] = a1[i];
                i++;
                j++;
            } else if (a1[i] < a2[j]) { // because they are sorted array, if some values is smaller than the other values in the same place,
                // we need to move forward
                i++;
            } else { // a1[i] > a2[j]
                j++;
            }
        }

        return Arrays.copyOf(a3, counter); // O(n), copying only the values that in, and throwing out the empty places
    }


    //  Ex5 with binary search. searching each value in the second arraym and adding it to a new intersection array
    public static int[] intersection2(int[] b1, int[] b2) {
        mergesort(b1); // O(nlog(n))
        mergesort(b2); // O(nlog(n))
        int counter = 0;
        int[] temp = new int[b2.length];
        for (int i = temp.length-1; i >= 0; i--) { //O(nlog(n)). and descending order
            if (binarySearch(b2, b1[i]) != -1) { // O(log(n))
                temp[counter++] = b1[i]; // because they have the same value
            }
        }
        return Arrays.copyOf(temp, counter); // O(n)
    }


    // ***** helping functions *****//
    public static void mergesort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = (high + low) / 2;
        mergeSort(arr, low, middle);
        mergeSort(arr, middle + 1, high);
        merge(arr, low, middle, high);
    }

    // contributed from eyal's levi github https://github.com/LeviEyal/DataStructuresCourse/blob/master/leead_exsercises/src/%D7%AA%D7%99%D7%A8%D7%92%D7%95%D7%9C%D7%99%D7%9D/ex4.java
    public static void merge(int[] arr, int l, int m, int h) {
        int[] arr2 = new int[h - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= h) {
            if (arr[i] < arr[j]) {
                arr2[k++] = arr[i++];
            } else {
                arr2[k++] = arr[j++];
            }
        }

        while (i <= m) {
            arr2[k++] = arr[i++];
        }
        while (j <= h) {
            arr2[k++] = arr[j++];
        }

        //copy from t to a
        for (i = 0; i < arr2.length; i++) {
            arr[l + i] = arr2[i];
        }
    }

    public static int binarySearch(int[] a, int k) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == k) {
                return mid; // the index we've found it
            } else if (k > a[mid]) {
                left = mid + 1;
            } else {  // k < a[mid]
                right = mid - 1;
            }
        }
        return -1;
    }

}
