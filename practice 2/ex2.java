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
    }

    // Functions for ex1

    //Sum - according to this recursion formula "a + b = (a + (b-1)) + 1  , a + 0 = a"

    public static double sum(double a, double b) {
        if (b == 0) {
            return a;
        }
        return sum(a + 1, b - 1); // in each recursion we're stepping forward 'a', and taking 'b' one step back
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
        if (a<b){
            return a;
        }
        return remainder(a-b,b);
    }

}
