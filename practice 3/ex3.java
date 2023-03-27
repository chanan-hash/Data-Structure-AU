import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ex3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 8, 9, 11, 57};
        System.out.println(binarySreach(arr, 10));
        System.out.println(recBinaryserach(arr, 11, arr[0], arr.length - 1));
        System.out.println(finalRecBin(arr, 57));
        System.out.println(finalRecBin(arr, 12));


        String[] srr = {"contribute", "geeks", "ide", "practice"};
        String x = "ide";
        int result = stringBinarySerach(srr, x);
        System.out.println(result);

        System.out.println(isZero(arr));
        System.out.println(isZero2(arr));


        int[] arr1 = {1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3};
        int[] arr2 = {1, 1, 2, 2, 3, 3, 4, 4};
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr4 = {1, 1, 1, 1, 1, 1, 2, 2, 2};
        int[] arr5 = {1, 1, 1, 1, 1};
        int[] arr6 = {};
        int[] arr7 = {1};
        int[] arr8 = {1, 1};
        int[] arr9 = {1, 2};

//        System.out.println(moreThan(arr1));
//        System.out.println(moreThan(arr2));
//        System.out.println(moreThan(arr3));
//        System.out.println(moreThan(arr4));
//        System.out.println(moreThan(arr5));
//        System.out.println(moreThan(arr6));
//        System.out.println(moreThan(arr7));
//        System.out.println(moreThan(arr8));
//        System.out.println(moreThan(arr9));

        moreThan(arr1);
        moreThan(arr2);
        moreThan(arr3);
        moreThan(arr4);
        moreThan(arr5);
        moreThan(arr6);
        moreThan(arr7);
        moreThan(arr8);
        moreThan(arr9);

        System.out.println();
        int a6[] = {1,2,4,6,7,8,9,10,11,12};
        System.out.println(binarySearchBetween(a6, 5) + " and the value is: " + a6[binarySearchBetween(a6, 5)]);
    }


    public static int binarySreach(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] == value) {
                return mid; // The index of the value
            }

            if (value > arr[mid]) {
                left = mid + 1;
            } else {      // value < arr[mid}
                right = mid - 1;
            }
        }

        return -1;
    }

    //Need to be modulated
    public static int recBinaryserach(int[] arr, int value, int left, int right) {
        if (right >= left) {
            int mid = (right + left) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (value > arr[mid]) {
                return recBinaryserach(arr, value, mid + 1, right);
            } else {
                return recBinaryserach(arr, value, left, mid - 1);
            }
        }
        return -1;
    }

    // Comfortable recursive binary search, using the function above.
    public static int finalRecBin(int[] arr, int value) {
        return recBinaryserach(arr, value, arr[0], arr.length - 1);
    }

    // Ex2 is to make binary search to a game


    // Ex3 --> if the binary search is different from -1, we will add them to array list and return id to array
    // we need to create before a binary search for String

    public static int stringBinarySerach(String[] srr, String str) {
        int L = 0;
        int R = srr.length - 1;

        while (L < R) {
            int mid = (R + L) / 2;
            int res = str.compareTo(srr[mid]); // a for loop of O(n) --> but comparing to string by a comperator
            if (res == 0) {
                return mid;
            } else if (res < 0) { //we are comparing the chars
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return -1;
    }

    public static String[] joinSrr(String[] s1, String[] s2, String[] s3) {
        ArrayList<String> srr = new ArrayList<>();
        // we can run and find the min array but it more work for the program
        // int minLength = Math.min(Math.min(s1.length,s2.length),s3.length); // running on the minimum array
        //String sArr = // the minimum String array
        for (String str : s1) { // for reach loop
            if ((stringBinarySerach(s2, str) != -1) && (stringBinarySerach(s3, str) != -1)) { // means the string from s1 is in s2 and s3
                srr.add(str);
            }
        }
        // return (String[]) srr.toArray(); //need to be cast
        return srr.toArray(new String[]{});
    }

    // Ex4
    // The function with complexity of O(n^2)
    public static boolean isZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] + arr[j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    // The same function with complexity of O(n log(n))
// if we want that the sum of two number will be zero, they will be 'a' and '-a', the opposite of the number
// We will use binary search in every iteration
    public static boolean isZero2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (binarySreach(arr, -arr[i]) != -1) { // means there is the opposite number of it
                return true;
            }
        }
        return false;
    }

    // complexity O(n)
 /*   public static boolean isZero3(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(-num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
*/

    // Complexity O(n)
    // simialr to the idea of ex2 in intro2cs, to find the root of a polynomial

    /**
     * If the sum is less than zero, we move the left pointer to the right to try to increase the sum.
     * If the sum is greater than zero, we move the right pointer to the left to try to decrease the sum.
     * If we reach the end of the while loop without finding a pair of numbers with zero sum, we return false.
     *
     * @param arr
     * @return
     */
    public static boolean isZero4(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == 0) {
                return true;
            } else if (sum > 0) {
                right--; // means we are to high
            } else {
                left++; // means we are low
            }
        }
        return false;
    }

    // Ex5

//    public static int moreThan(int[] arr) {
//
//        int N = arr.length;
//
//        for (int i = 0; i < N/2; i++) {
//            if (arr[i] == arr[i + (N / 2)]) { // if from the index till the index + N / 2, is the same value, so it means the value is appearing more than N/2, time,
//                // We can say it only because the array is sorted, so we know there is no other element
//                return arr[i];
//            }
//        }
//        if (arr.length % 2 == 1 && arr[arr.length / 2] == arr[arr.length - 1]) { // if the length is an odd number,
//            // and from half of the array till the end is the same value so return it,
//            // it's for not going out of the array
//            return arr[arr.length - 1];
//        }
//        throw new NoSuchElementException("NO such element"); // If we'll get an exception like this, means we've got till the end of the array and didn't find any element,
//        // and in the next iteration we'll get arrayOutOfBound
//
//    }

    // from eyal's levi github
    // https://github.com/LeviEyal/DataStructuresCourse/blob/master/leead_exsercises/src/%D7%AA%D7%99%D7%A8%D7%92%D7%95%D7%9C%D7%99%D7%9D/ex3.java
    public static void moreThan(int a[]) {
        int n = a.length;
        for (int i = 0; i < n / 2; i++)
            if (a[i] == a[i + n / 2]) {
                System.out.println(a[i]);
                return;
            }
        System.out.println("not found");
    }

    // Ex6
    /*
     This function is based on binary search but with an addition to the condition
     this function is the casing for our function
     we need first a recursive binary search with the condition for the answer
     complexity of O(log(n))
    */
    public static int binarySearchBetween(int arr[], int value) {
            return binarySearchBetween2(arr, 0, arr.length-1,value);
    }

    public static int binarySearchBetween2(int[] arr, int low, int high, int value) {
        if(low>high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (value == arr[mid] || (value > arr[mid-1] && value < arr[mid])) {
            return mid;
        } else if (value > arr[mid]) {
            return binarySearchBetween2(arr, mid+1, high,value);
        }
        else {
            return binarySearchBetween2(arr,low, mid-1,value);
        }


    }

}