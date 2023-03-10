public class ex1 {

    public static void main(String[] args) {
        String words[] = {"be", "be", "not", "or", "to", "to", "to"};
        regularity(words);
    }


    // ex2
    public static void regularity(String srr[]) {
        String str = "";
        int count = 1;
        for (int i = 0; i <srr.length-1; i++) {
            if (srr[i].equals(srr[i + 1])) {
                count++;
            }
            else {
                str += count + ", ";
                count = 1;
            }
        }
//        if (!srr[srr.length].equals(srr[srr.length - 1])) {
//            str += 1;
//        }
        System.out.println(str);
    }
}
