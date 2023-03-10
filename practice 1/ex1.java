public class ex1 {

    public static void main(String[] args) {
        String words[] = {"be", "be", "not", "or", "to", "to", "to"};
        regularity(words);
        String words2[] = {"be", "be", "not", "or", "to", "to", "hello"};
        regularity(words2);
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
        if (!srr[srr.length-1].equals(srr[srr.length-2])) {
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
        if (!srr[srr.length-1].equals(srr[srr.length-2])) {
            str += 1;
        }
       return str;
    }
}
