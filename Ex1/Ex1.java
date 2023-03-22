public class Ex1 {

    public static void main(String[] args) {
//        foo1(10);
//        System.out.println();
        foo2(6);
    }

    public static void foo1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j = j / 2) {
                System.out.println(i);
            }
        }
    }


    public static void foo2(int n) {
        int sum = 1;
        for (int i = 0; i < n; i++) {
            sum = 2 * sum;
        }
        for (int j = sum; j > 0; j = j - n) {
            System.out.println(j);
        }
    }
}
