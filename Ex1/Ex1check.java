public class Ex1check {

    public static void main(String[] args) {
//        foo1(10);
//        System.out.println();
//        foo2(6);
        foo3(17);
    }


    // Complexity O(nlog(n))
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

    public static void foo3(int n) {
        for (int i = 1; i < n; i = i * 2) {
            for (int j = 1; j < i; j++) {
                System.out.println(i);
            }
        }
    }
}
