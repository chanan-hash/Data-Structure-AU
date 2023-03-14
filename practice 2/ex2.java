import org.w3c.dom.ls.LSOutput;

public class ex2 {

    public static void main(String[] args) {
        double a = 5;
        double b = 6;
        System.out.println(sum(a, b));
        System.out.println(subtract(a, b));
        System.out.println(subtract(b, a));
        System.out.println(mul(a, b));
        System.out.println(mul(2.5, 2));
        System.out.println(div(10, 2));

        System.out.println(remainder(6, 12));
        System.out.println(remainder(12, 6.5));
        System.out.println(remainder(28, 4));
        System.out.println(remainder(4, 28));

        System.out.println(pow2(4));
        System.out.println(pow2(0));
        System.out.println(pow2(1));
        System.out.println(pow2(2));
        System.out.println(pow2(3));

        System.out.println(reverse(314));

    }

    // Functions for ex1

    //Sum - according to this recursion formula "a + b = (a + (b-1)) + 1  , a + 0 = a"

    public static double sum(double a, double b) {
        if (b == 0) {
            return a;
        }
        return sum(a + 1, b - 1); // in each - recursion we're stepping forward 'a', and taking 'b' one step back
    }

    // Subtraction - according to this recursion formula "a - b = (a - (b-1)) + 1  , a - 0 = a"
    public static double subtract(double a, double b) {
        if (b == 0) {
            return a;
        }
        return subtract(a - 1, b - 1); // against to the sum, on sub, both a and b are been reduced by 1
    }

    //Multiplication - according to this recursion formula "a * b = (a * (b-1)) + a  , a * 1 = a"
    public static double mul(double a, double b) {
        if (b == 1) {
            return a;
        }
        return a + mul(a, b - 1);
    }

    // Division - according to this recursion formula "a/b = (a-b)/b+1, a/b = 0 a<b"
    // it returning hte integer of the division
    public static double div(double a, double b) {
        if (a < b) {
            return 0;
        } else {
            return div(a - b, b) + 1;
        }
    }

    // Remainder - according to this recursion formula "a%b = (a-b)%b , a&b = a, a<b"
    public static double remainder(double a, double b) {
        if (a < b) {
            return a;
        }
        return remainder(a - b, b);
    }


    // Ex2
    // Recursion of 2 power --> 2^n = 2^(n-1) + 2^(n-1)
    // Do it without multiplication
    public static int pow2(int n) {
        if (n == 0) {
            return 1;
        }
        return pow2(n - 1) + pow2(n - 1);
    }

    //Ex3
    // Reversing a number in iterative way
    // Actually it is giving us a new number that it is the reverse number
    // n % 10 = giving us the One's digit
    public static int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev = (rev *10) + n%10 ;
            n /= 10;
        }
        return rev;
    }

}
