import java.util.LinkedList;

public class StackFromJavaLL<T> {
    /**
     * Implementing Stack from java's built-in LinkedList
     */

    private LinkedList<T> stack;

    public StackFromJavaLL() {
        stack = new LinkedList<>();
    }

    // Adding at the first each element, and in the end we will remove each time the first element
    // It can be implemented by adding at the last val each time, the same idea
    public boolean push(T obj) {
        return stack.offerFirst(obj); // like addFirst, but a boolean function
    }

    public void add(T obj) {
        stack.addFirst(obj);
    }

    public T pop() {
        return stack.remove(); // The remove function is removing the first element, it is using removeFirst function
//        return stack.removeFirst();
    }

    public boolean contain(T obj) {
        return stack.contains(obj);
    }

    public int size() {
        return stack.size();
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public void clear() {
        stack.clear();
    }

    public T front() {
        return stack.peek(); // Retrieves, but does not remove, the head (first element) of this list.
        // return stack.peekFirst();
    }

    public T tail(){
        return stack.peekLast();
    }
}
