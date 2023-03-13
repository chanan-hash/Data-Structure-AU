public class ex2 {

    public static void main(String[] args) {
        double a = 5;
        double b = 6;
        System.out.println(sum(a, b));
        System.out.println(subtract(a, b));

    }

    // Functions for ex1

    //Sum - according to this recursion formula "a + b = (a + (b-1)) + 1  , a + 0 = a"

    public static double sum(double a, double b) {
        if (b == 0) {
            return a;
        }
        return sum(a+1, b-1); // in each recursion we're stepping forward 'a', and taking 'b' one step back
    }

    // Subtraction - according to this recursion formula "a - b = (a - (b-1)) + 1  , a - 0 = a"
    public static double subtract(double a, double b){
        if(b==0){
            return a;
        }
        return subtract(a-1,b-1); // against to the sum, on sub, both a and b are been reduced by 1
    }

    //Multiplication - according to this recursion formula "according to this recursion formula"

}
