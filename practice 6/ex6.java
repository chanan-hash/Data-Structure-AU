import java.util.Stack;

public class ex6 {
    public static void main(String[] args) {
        System.out.println(isBalanced("{[2*(6+7)]+4}*(3+2)"));
        System.out.println(isBalanced("{[2*(6+7)]+4})*(3+2)"));
        System.out.println(isBalanced("{[2*(6+7)]+4)*(3+2)"));
    }

    // Ex1
    // The arithmetic expression are in String format

    public static boolean isBalanced(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(' || c == '[' || c== '{'){ // checking if it is one of the brackets
                stack.add(c);
            }
            if (c == ')' || c == ']' || c== '}'){
                if (stack.isEmpty() || Math.abs(c - stack.pop()) > 2){ // need to understand, means there is a gap between the brackets
                    return false;
                }
            }
        }
        return stack.empty(); // stack.isEmpty();
    }

}
