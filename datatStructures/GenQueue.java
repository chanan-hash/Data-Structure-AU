import java.util.LinkedList;

public class GenQueue<T> {
    /**
     * This class represents generic queue.
     * Unlike generic stack that we've implemented by ArrayList,
     * The generic queue we'll implement by LinkedList, because of the 'front' and 'tail'
     * that it is easier to get them by front = getFirst, tail = getLast.
     * the complexity is O(1), because we have Nodes/pointer for then, and in array list it can be some time O(n)
     */

    // Variables
    int maxLength = -1; // to initialize the max length of the queue, the allocation in the memory
    LinkedList<T> queue = new LinkedList<>();

    // constructors
    public GenQueue(int maxSize) {
        this.maxLength = maxSize;
        queue = new LinkedList<T>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean enqueue(T valueType) {
        boolean res = true;
        if (queue.size() == maxLength) {
            res = false;
            System.out.println("The queue is full");

        } else { // if we had only 'if' statement, the code would continue and the 'res' variable would have changes
            queue.offer(valueType); // adding at the last place the new value. if we are getting inside the class of java bt Ctrl + mouse clicking,
            // we'll see the function is O(1)
        }
        return res;
    }

    // removing the first element from the queue --> FIFO
    public T dequeue() {
        T type = null;
        if (queue.isEmpty()) {
            System.out.println("The queue is empty");
        } else {
            type = queue.poll(); // poll function removing the first element from the LinkedList, and returning it.
            // so we are keeping it in type, so we'll return it, and that how we know it worked
            // poll --> because it's removing the first element in linked list, its is taking O(1)
        }
        return type;
    }

    public int size(){
        return queue.size();
    }

    // Form java's LinkedList class:
    // "Retrieves, but does not remove, the head (first element) of this list."
    // O(1)
    public T peek(){
        return queue.peek();
    }

    public boolean contains(T val){
        return queue.contains(val); // O(n)
    }

    public void clear(){
        queue.clear();;
    }
}
