public class MyQueue {
    /**
     * implementing queue with cycled array, means that the next value in the array is calculated by the formula-->
     * i = (i + 1) % n, when 'i' is the index, and 'n' is the size of the array.
     * array that calculated like this called cycled array
     * In the cycled queue, we allocate the memory at the beginning and that it, we cant put values in the queue more than the maxSize
     *
     * The first way to implement queue is to keep the first index and last index, each time.
     * The problem when we want to add or to remove value we need to move also all the queue values O(n)
     * but the queue will be dynamic, and we don't need to allocate in the beginning place in the memory for the mexSize8
     */

    // variables
    private int front = 0, tail = 0; // pointers for the queue, to decrease the complexity
    private int size = 0; // the amount of numbers that actually in the array
    private int maxSize; // The memory allocation of the array in the memory --> the max size of the array
    private Integer[] data; // the array will be represented as an object of integers

    // constructor
    public MyQueue(int max) { // creating new queue, and initializing the class variable
        this.maxSize = max;
        this.front = 0;
        this.tail = 0;
        this.size = 0;
        data = new Integer[this.maxSize];
    }


    // functions
    // O(1)
    public boolean enqueue(Integer value) {
        boolean ans = true;
        if (size == maxSize) {
            ans = false;
            System.out.println("The queue is full");
        } else { // if tail == n-1 --> tail = 0
            data[tail] = value; // putting the new value in the end of the queue
            tail = (tail + 1) % maxSize; // formula for tail advancement of the tail is --> tail = (tail+1) % n, when 'n' is the size of the array
            size++;
        }
        return ans;
    }


    // when we are using dequeue, after it finished we are returning the value we've removed.
    // that how we know the function succeeded
    // O(1)
    public Integer dequeue() {
        Integer ans;

        if (isEmpty()) {
            System.out.println("The queue is empty");
            ans = null;
        } else {
            ans = data[front]; // first in first out
            front = (front + size) % maxSize; // that how we won't leap out from the array, the modulo keeping us in
            size--; // because we've removed one of the elements
        }
        return ans;
    }

    // giving showing the first element, but not removing it
    // O(1)
    public Integer peek() {
        Integer ans = null;
        if (isEmpty()) {
            System.out.println("The queue is empty");
            ans = null;
        } else {
            ans = data[front];
        }
        return ans;
    }

    //O(n)
    public boolean contains(Integer val) {
        boolean res = false;
        for (int i = 0; i < size; i++) {
            if (val == data[i + front % maxSize]) {
                res = true;
            }
        }
        return res;
    }

    // O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    // O(1)
    public int getSize() {
        return size;
    }

    // O(1)
    public void clear() {
        size = 0;
        front = 0;
        this.tail = 0;
    }

}
