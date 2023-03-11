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

    }


    // ex2
    public static void regularity(String srr[]) {
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

}
