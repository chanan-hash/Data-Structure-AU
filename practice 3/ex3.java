public class ex3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5,8,9,11,57};
        System.out.println(binarySreach(arr, 10));
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

}
