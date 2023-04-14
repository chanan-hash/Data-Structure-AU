import java.util.ArrayList;

public class GenStack<T> { // This class will represent a generic type stack
    ArrayList<T> stack;
    int maxLength, top;

    public GenStack(int maxSize) {
        this.maxLength = maxSize; // limiting our size, and memory allocation --> malloc
        this.top = -1; // pointer of the last value, in the beginning we haven't any value, 0--> is an index, that why -1
        stack = new ArrayList<T>(maxSize); // ArrayList<>(initial capacity)
    }

    public GenStack() {
        stack = new ArrayList<>(); // unlimited capacity from the beginning
        this.maxLength = -1; // because we have no length or limit for now, so it doesn't matter
    }

    public boolean push(T type) {
        boolean res = true;
        if (stack.size() == maxLength) {
            System.out.println("Stack Overflow");
            res = false; // there is no more place, we want to limit and control our stack
        } else {
            stack.add(type);
        }
        return res;
    }

    public T pop() {
        T ans = null;
        if (!stack.isEmpty()) { // if it is not empty
            ans = stack.remove(stack.size() - 1); // removing the last object form the arraylist
        }
        return ans;
    }

    public T top() {
        T res = null;
        if (!stack.isEmpty()) { // stack.size > 0
            res = stack.get(stack.size() - 1); // getting the last value, but not removing it
        }
        return res;
    }

    public void clear() {
        stack.clear();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public String toString() {
        return stack.toString();
    }
}
