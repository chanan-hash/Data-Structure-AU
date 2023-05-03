public class LeeadStack {
    /**
     * This class represent a simple class for Stack that lee'ad showed in his lecture
     * The stack will be represented as a simple array with the right methods
     */

    // Data
    private int[] stack;
    int size = 0;

    // constructors

    public LeeadStack(int capacity) { //The maximum size of the stack, the allocation in the memory
        stack = new int[capacity];
    }

    //O(1)
    public boolean push(int n) {
        if (stack.length == size) {
            return false;
        } else {
            stack[size++] = n;
            return true;
        }
    }


    /*
    can be a void method
    // O(1)
    public void push(int i) {
        if (size < a.length) {
            a[size] = i;
            size++;
        }
    }
    */

    // O(1)
    public int pop() {
        if (size == 0) {
            System.out.println("The stack is empty");
        }
        int res = stack[size--]; // size, and than decreasing it
        // or maybe - stack[--size];
        return res;
    }
    /*
    public int pop() {
		if(size == 0)
			return Integer.MIN_VALUE;
		size--;
		return a[size];
	}
     */

    // O(size), simple contains function
    public boolean contains(int q) {
        for (int i = 0; i < size; i++)
            if (stack[i] == q) {
                return true;
            }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
