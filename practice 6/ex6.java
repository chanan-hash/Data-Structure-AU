import java.util.Stack;

public class ex6 {
    public static void main(String[] args) {
        System.out.println(isBalanced("{[2*(6+7)]+4}*(3+2)"));
        System.out.println(isBalanced("{[2*(6+7)]+4})*(3+2)"));
        System.out.println(isBalanced("{[2*(6+7)]+4)*(3+2)"));

        System.out.println();

        System.out.println(DecEqual("2435.5342")); // true
        System.out.println(DecEqual("2435.534"));  // false
        System.out.println(DecEqual("1435.5341")); // true
    }

    // Ex1
    // The arithmetic expression are in String format

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '[' || c == '{') { // checking if it is one of the brackets
                stack.add(c);
            }
            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty() || Math.abs(c - stack.pop()) > 2) { // need to understand, means there is a gap between the brackets
                    return false;
                }
            }
        }
        return stack.empty(); // stack.isEmpty();
    }

    public static boolean DecEqual(String str) {
        Stack<Character> stack = new Stack<>();
        boolean isDot = false; // flag if it is the dot

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '.') {
                isDot = true;
            } else if (!isDot) {
                stack.add(c); // adding all the elements till the dot,
                              // and then popping them from the stack and checking if they are equal to the rest of the String,
                              // and because this is a stack we'll get the opposite way, as we;ve wanted

            } else if (stack.isEmpty() || c != stack.pop()) { // means when we pop the stack, the values is different from the last
                return false;                         // 5432.2345, the last one before the dot is 2, and after the dot we'll
                                                     // add 2, and they are equal
            }
        }

        return stack.empty(); // means we've popped all, and every one were equal to their opposite, if the stack is not empty
        // means there are values we haven't popped
    }


    // Ex3
}
