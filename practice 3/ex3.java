public class ex3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 8, 9, 11, 57};
        System.out.println(binarySreach(arr, 10));
        System.out.println(recBinaryserach(arr, 11, arr[0], arr.length - 1));
        System.out.println(finalRecBin(arr,57));
        System.out.println(finalRecBin(arr,12));


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
    public static int finalRecBin(int[] arr, int value){
        return recBinaryserach(arr,value,arr[0],arr.length-1);
    }

    // Ex2 is to make binary search to a game


    // Ex3 --> if the binary search is different from -1, we will add them to array list and return id to array
    // we need to create before a binary search for String
}
