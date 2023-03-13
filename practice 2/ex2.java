public class ex2 {

    public static void main(String[] args) {
        double a = 5;
        double b = 6;
        System.out.println(sum(a, b));
    }

    // Functions for ex1

    //Sum - according to this recursion formula "a + b = (a + (b-1)) + 1  , a + 0 = a"

    public static double sum(double a, double b) {
        if (b == 0) {
            return a;
        }
        return sum(a+1, b-1); // in each recursion we're stepping forward 'a', and taking 'b' one step back
    }
}
