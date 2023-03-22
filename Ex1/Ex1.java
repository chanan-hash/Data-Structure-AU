public class Ex1 {
    public static void main(String[] args) {
        int[] arr = {-14, 1, 1, 1, 1, 2, 9, 15, 20};
        System.out.println(ones(arr, 1));
    }


    /**
     * The idea of the function is to find the first index which 'k' is found, and the last index, to subtract them,
     * and this will give how many times 'k' is in the array.
     * To do it in complexity of O(log(n)), we will use the concept of binary search, to find every first index and last index
     * each search will be on O(log(n)), and in total = O(log(n)) + O(log(n)) = O(log(n))
     */

    public static int ones(int[] a, int k) {
        int index1 = firstIndex(a, 0, a.length-1, k);
        int index2 = lastIndex(a, k);
        if ((index1 == -1) || (index2 == -1)) {
            return -1;          // means k is not in the array
        }
        return index2 - index1 + 1;
    }

    /**
     * This function will work recursively like a binary search but with a little bit different condition,
     * that keeps that we'll find the first index
     *
     * @param a - array
     * @param L - low place
     * @param H - high palce
     * @param k - the element to search
     * @return The complexity is O(log(n)), becuase in every recursive call we are dividing the array into half
     */

    public static int firstIndex(int[] a, int L, int H, int k) {
        if (H >= L) {
            int mid = (L + H) / 2; // like in binary search
            if ((mid == 0 || k > a[mid - 1]) && (a[mid] == k)) { // if the 'k' element is greater than a[mid-1] and it is in mid palce,
                return mid;                                                // means this is the first index of it, or if mid is 0, and it equals to 'k'
            } else if (k > a[mid]) {
                return firstIndex(a, mid + 1, H, k);  // need to go to search in the right side of the array
            } else {
                return firstIndex(a, L, mid - 1, k);
            }
        }
        return -1; // if we didn't find it;
    }

    /**
     * In the same way we will find the last index that 'k' is in the array
     * this function we will to iteratively, the same --> binary search with different condition
     *
     * @param a
     * @param k
     */
    public static int lastIndex(int a[], int k) {
        int left = 0;
        int right = a.length - 1;
        int ans = -1; // if we won't find it

        while (left <= right) {
            int middle = (left + right) / 2;
            if (a[middle] <= k) {     //so we need to go up and look for the last 'k'
                left = middle + 1; // for the next iteration
                if (a[middle] == k) {
                    ans = middle;  // we want to remember the index, it can be updated if we'll find a higher 'k',
                    // or stay if this the highest 'k'
                }
            } else {
                right = middle - 1; // we need to get lower to find k
            }
        }
        return ans;
    }
}
