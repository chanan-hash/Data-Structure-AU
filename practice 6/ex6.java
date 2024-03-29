import java.util.Stack;

public class ex6 {
    public static void main(String[] args) {
        System.out.println(isBalanced("{[2*(6+7)]+4}*(3+2)"));
        System.out.println(isBalanced("{[2*(6+7)]+4})*(3+2)"));
        System.out.println(isBalanced("{[2*(6+7)]+4)*(3+2)"));
        String str = "({()[]})";
        String str2 = "([{";

        System.out.println(isBalanced(str));
        System.out.println(isBalanced(str2));
        System.out.println(str2.length() / 2);

        System.out.println(DecEqual("2435.5342")); // true
        System.out.println(DecEqual("2435.534"));  // false
        System.out.println(DecEqual("1435.5341")); // true


        System.out.println(sortByStack(new int[]{2, 8, 6, 3, 7, 4, 5, 1}));

        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(6);
        stack.push(3);
        stack.push(5);
        stack.push(8);
        stack.push(20);
        stack.push(5);
        stack.push(7);
        stack.push(1);

        Stack<Integer> sortedStack = sortStack(stack);
        System.out.println(sortedStack);


    }

    // The answers were contributed from, eyal's levi github:
    // https://github.com/LeviEyal/DataStructuresCourse/blob/master/leead_exsercises/src/%D7%AA%D7%99%D7%A8%D7%92%D7%95%D7%9C%D7%99%D7%9D/ex6.java

    // Ex1
    // The arithmetic expression are in String format

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (stack.size() > (str.length() / 2)) {
                return false; //means there are too many opening brackets than closing ones
            }
            char c = str.charAt(i);
            if (c == '<' || c == '(' || c == '[' || c == '{') { // checking if it is one of the brackets
                stack.add(c); // the size of the stack will be n/2, because we're adding only half of the brackets
            }
            if (c == '>' || c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty() || Math.abs(c - stack.pop()) > 2) { // if the stack isEmpty
                    // or the subtraction between the two brackets according to the ascii, is bigger than 2,
                    // means they are strange brackets
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
    // first way is to sort the array and then put into the stack
    public static Stack<Integer> sortByStack(int[] arr) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack1.isEmpty() && stack1.peek() > arr[i]) {
                stack2.add(stack1.pop()); // adding to the second stack, the last value from the first stack
            }
            stack1.add(arr[i]); // adding a value to check
            while (stack2.isEmpty() == false) {
                stack1.add(stack2.pop()); // adding the last value from the second stack
            }
        }
        return stack1;
    }

    // From netanel exercise
    public static Stack<Integer> sortStack(Stack<Integer> s1) {
        Stack<Integer> temp = new Stack<>();
        while (!s1.isEmpty()) { // while this stack is not empty
            int t = s1.pop(); // popping out the first element

            while (!temp.empty() && temp.peek() < t) { // while the temp stack is not empty, and the top value is bigger than top of temp
                s1.push(temp.pop()); // pop from the temp stack and putting in our stack
            }
            // pushing into the temp stack 't' value, because it is the biggest value, and continuing like this till first stack 's1' is empty
            temp.push(t);
        }
        return temp;
    }
}