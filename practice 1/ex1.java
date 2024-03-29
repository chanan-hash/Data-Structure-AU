import java.util.ArrayList;
import java.util.Arrays;

public class ex1 {

    public static void main(String[] args) {
        String words[] = {"be", "be", "not", "or", "to", "to", "to"};
        regularity(words);
        String words2[] = {"be", "be", "not", "or", "to", "to", "hello"};
        regularity(words2);

        int[] arr = {1, 4, 9, 17, 23, -1, 14};
        smallAbsolute(arr);
        int[] arr2 = {1, 4, 9, 17, 23, 0, 14};
        smallAbsolute(arr2);
        smallAbsolute3(arr2);


        int[] arr3 = {98, 2, 3, 1, 0, 0, 0, 3, 98, 98, 2, 2, 2, 0, 0, 0, 2};
        int[] arr4 = arr3.clone();
        System.out.println(Arrays.toString(arr4));
        sort(arr3);
        System.out.println(Arrays.toString(arr3));
        int[] arr5 = Arrays.copyOf(arr3, arr3.length);
        System.out.println(Arrays.toString(arr5));

        int[] arr6 = {1, 4, 9, 17, 23, -1, 14};
        maxAbsolute(arr6);
        maxAbsolute(arr3);

        System.out.println(sumZero(arr6));
        System.out.println(sumZero(arr2));

        System.out.println(Nth(arr3, 3));
    }

    //ex1
    /*
    This function is working on the idea of quick-select
     */

    /*
     The idea of this function is to check each value how much is bigger then the others,
     and if it is equals to the N'th value we have wanted
     Complexity of O(n^2)
     need to fix if there are the two same value the counter will grow
     this function work if the values are different  one from each other
    */
    public static int Nth(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            int counter = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    counter++;
                }
            }
            if (counter == n) {
                return arr[i];
            }
        }
        return -1;  // If we didn't find what we want
    }

    // returning the max value in an array
    public static int maxArray(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }


    // ex2
    public static void regularity(String srr[]) {
        String str = "";
        int count = 1;
        for (int i = 0; i < srr.length - 1; i++) {
            if (srr[i] == (srr[i + 1])) { // we can do also equals, it's not changing the complexity
                count++;
                // if the next iteration will be the last one, and the words are equal so we want to and the counter
                if (i + 1 == srr.length - 1) {
                    str += count;
                }
            }
            // if the words are not equal, we want to and the counter to the String, and initialized it
            else {
                str += count + ", ";
                count = 1;
            }
        }
        // if thew last word is not equal to the one before it we need to add the count '1' to the String
        if (!srr[srr.length - 1].equals(srr[srr.length - 2])) {
            str += 1;
        }
        System.out.println(str);
    }

    // This function is for testing, it is the same function, but it just can return String
    public static String regularity2(String srr[]) {
        String str = "";
        int count = 1;
        for (int i = 0; i < srr.length - 1; i++) {
            if (srr[i].equals(srr[i + 1])) {
                count++;
                // if the next iteration will be the last one, and the words are equal so we want to and the counter
                if (i + 1 == srr.length - 1) {
                    str += count;
                }
            }
            // if the words are not equal, we want to and the counter to the String, and initialized it
            else {
                str += count + ", ";
                count = 1;
            }
        }
        // if thew last word is not equal to the one before it we need to add the count '1' to the String
        if (!srr[srr.length - 1].equals(srr[srr.length - 2])) {
            str += 1;
        }
        return str;
    }


    // ex3
    // one way is to sort the array, but it not probably will help, complexity of O(n^2)
    public static void smallAbsolute(int[] arr) {
        int a1 = 0, a2 = 0;
        int s_absolute = Math.abs(arr[0] - arr[1]);

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[i] == arr[j]) {
                    continue;
                } else if (Math.abs(arr[i] - arr[j]) <= s_absolute) {
                    s_absolute = Math.abs(arr[i] - arr[j]);
                    a1 = arr[i];
                    a2 = arr[j];
                }
            }
        }
        System.out.println("a1= " + a1 + ", a2= " + a2);
    }

    // The same function but returning the small absolute for testing
    public static int smallAbsolute2(int[] arr) {
        int a1 = 0, a2 = 0;
        int s_absolute = Math.abs(arr[0] - arr[1]);

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[i] == arr[j]) {
                    continue;
                } else if (Math.abs(arr[i] - arr[j]) <= s_absolute) {
                    s_absolute = Math.abs(arr[i] - arr[j]);
                }
            }
        }
        return s_absolute;
    }

    // ex3 with O(nlog(n)) + O(n) = O(n) complexity, by sorting the array first with the efficient sort (QuickSort)
    /*
       The complexity will be O(n), because after sorting we still have to go over the whole array to find the smallest sub-absolute
       then we will search between to neighbor elements the smallest absolute subtraction.
       because for each element it won't be further form it's neighbours
    */
    public static void smallAbsolute3(int[] arr) {
        Arrays.sort(arr); // java's inbuilt sort is QuickSort (you can read in the class itself by Ctrl+clicking the mouse on the function)
        int s_absolute = Math.abs(arr[0] - arr[1]);
        int a1 = arr[0], a2 = arr[1]; // just for initializing
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) < s_absolute) {
                a1 = arr[i];
                a2 = arr[i + 1];
                s_absolute = Math.abs(arr[i] - arr[i + 1]);
            }
        }
        System.out.println("a1= " + a1 + ", a2= " + a2);
    }


    // Ex4
    /*
     for this function we can sort it before and then the complexity will be according to the sort.
     this function will be if we aren't sorting the array.
     The biggest absolute value subtraction will be on the min and max values.
     Complexity of O(n).
    */
    public static void maxAbsolute(int[] arr) {
        // lets assume the min value in the beginning and the max in the end. It may change according to what will happen
        int min = arr[0]; // initializing the min to just random value, but from the array, because then it will be Zero, it is unnecessarily correct
        int max = arr[arr.length - 1];

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < min) {
                min = arr[i]; // finding the min value in the array
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("min= " + min + ", max= " + max);
    }

    //The same function, but returning something for testing
    public static int maxAbsolute2(int[] arr) {
        int min = arr[0];
        int max = arr[arr.length - 1];

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < min) {
                min = arr[i]; // finding the min value in the array
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return Math.abs(max - min);
    }


    // Ex5
    /*
     Sorting an array int complexity of O(n) --> the idea is to keep in the loop and not to create another one,
     so we're updating the loop runner ('i') after getting in the condition to start again
     Based from https://www.geeksforgeeks.org/how-to-sort-an-array-in-a-single-loop/
    */
    public static void sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
                i = -1; // so the loop begins from the start, and that way we are starting in the same loop,
                // but won't get in the condition from the previous iteration.
                // its need to be -1, because -1<0, so we will start again
            }
        }
    }

    // outside function for help
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Ex6
    /*

   To find two number that the addition is Zero, meas they are opposite numbers
    It is similar to binary search, but the condition is changing, and the complexity can be the whole array --> O(n)

    this function with complexity of O(n^2) is easier -
    1. one loop runs on the current value,
    2. and the second loop on the values of the rest of the array

     we can assume that the array is sorted by ascending order --> that why because it works a little bit like binary-search

     By chatGpt: "The time complexity of this algorithm is O(n) because we only need to iterate through the array once."
     */
    public static boolean sumZero(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == 0) {
                return true;
            } else if (sum > 0) { // means the number is big, and we need to go to the zero more
                right -= 1;
            } else {              // The same way but the opposite
                left += 1;
            }
        }
        return false;
    }

}
