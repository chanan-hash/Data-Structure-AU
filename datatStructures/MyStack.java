public class MyStack { // for generic type stack we'll use ArrayList, it more suitable for this
    /**
     * This class represent a data structure of queue
     * Lifo = Last In First Out
     */
    final int MAX_SIZE = Integer.MAX_VALUE; // Allocates memory space, the max that the stack can hold
    // every time we are creating stack it will allocate that memory space
    // Allocate --> specific place
    private Integer[] items; // the stack is represented as an array
    int current = 0, size = 0; // current will be the pointer till where we have values

    public MyStack() { // when creating a new stack
        size = MAX_SIZE;
        current = 0; // will be the pointer

        // creating new array
        items = new Integer[size]; // creating object array, and then casting it to T, type
    }

    // O(1)
    public boolean push(int value) { // this is a boolean function, to know if we've succeeded to push a new value to the stack
        boolean res = true;
        if (current == size) { // means there is no mpre place in the stack
            res = false;
        } else {
            items[current++] = value; // adding it in the next place,
        }
        return res;
    }

    // This function taking out the last element that was put in
    public Integer pop() {
        Integer ans = null;
        if (current > 0) {
            ans = items[--current]; // taking out an element, and decreasing the pointer to the last value
        }
        return ans; // if current is 0, so it will stay null
    }

    // Just showing the last element, but not taking it out from the stack
    public Integer top() { // we are doing it as an Integer and not int, because we want it as an object
        // if the stack is empty we want to return null, and not '0', because this is a value

        Integer res = null;
        if (current > 0) {
            res = items[current];
        }
        return res;
    }

    // clearing the stack
    public void clear() {
        current = 0; // making the pointer as '0', so we won't be able to access any value in the stack,
                    // and if we'll try, we'll get null
    }

    public boolean isEmpty(){
        return (current == 0);
    }

    public int size() {
        return current; // because the size is the memory place
    }
    
}
