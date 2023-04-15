public class discreteMathCode {
    public static void main(String[] args) {
        System.out.println(factorial(3)); // 6
        System.out.println(choose(5, 2)); // 10
        int sum1 = choose(10, 3) * choose(7, 2) * choose(3 + 2, 2); // n = 10, k = 3 , m = 2, h = 2
        int sum2 = sigmaSevenFour(10, 2, 3, 2);
        System.out.println("sum1= " + sum1 + ", sum2= " + sum2);

        int threePowN = (int) Math.pow(3,4); // n = 4
        int sigm2 = sigmaSevenThree(4);
        int sigm3 = sigmaSevenThree2(4);
        System.out.println("sum1= " + threePowN + ", sum2= " + sigm2 + ", sum3= " + sigm3);

    }

    public static int factorialRec(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorialRec(n - 1);
    }

    // calculate in recursion is so big that we'll get stackoverflow, so we'll do it iterative
    public static int factorial(int n) {
        int s = 1;
        for (int i = 2; i <= n; i++) {
            s *= i;
        }
        return s;
    }

    public static int choose(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }


    // Ex1, ex7, 3
    public static int sigmaSevenThree(int n) {
        int sum = 0;
        for (int i = 0; i <= n ; i++) {
            sum += (choose(n,n-i) * Math.pow(2,n-i));
        }
        return sum;
    }
    public static int sigmaSevenThree2(int n) {
        int sum = 0;
        for (int i = 0; i <= n ; i++) {
            sum += (choose(n,i) * Math.pow(2,i));
        }
        return sum;
    }


    // Ex1, ex7 4
    public static int sigmaSevenFour(int n, int m, int k, int h) {
        int sum = 0;
        for (int i = 0; i <= h; i++) {
            sum += (choose(n, m) * choose(m, i) * choose(n - m, k) * choose(k, h - i));
        }
        return sum;
    }

}
