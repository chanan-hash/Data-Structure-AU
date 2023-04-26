import java.util.NoSuchElementException;

public class Ex7MyQueue {

    private int[] que;
    private int size = 0, pointer = 0;


    // creating a new array, with allocation of maximum the capacity we want
    public Ex7MyQueue(int capacity) {
        que = new int[capacity];
    }

    // O(1)
    public boolean enqueue(int n) {
        if (size == que.length) {
            return false; // maximum of capacity
        }
        que[pointer] = n;
        pointer = (pointer + 1) % que.length; // for cycle queue
        size++;
        return true;
    }

    public int dequqe() {
        if (size == 0) {
            return Integer.MIN_VALUE;
        }
        int tail = (pointer - size + que.length) % que.length;
        size--;
        return que[tail]; // we are updating the size so the the next time we'll dequeue, we will go back according to the formula
        // and returning the value in that place
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    // Returning if there no more place to add values
    public boolean isfull() {
        return size == que.length;
    }

    // Ex1
    // O(size)
    public String toString() {
        if (size == 0) {
            return "Queue is empty!";
        } else {
            String str = "[";
            for (int i = 0; i < size; i++) {
                str += ", " + que[i];
            }
            str += " ]";
            return str;
        }
    }

    // another way of doing that:
    // for this we need pointer for first, and pointer for last, in this class
    // from Eyal's levi github --> https://github.com/LeviEyal/DataStructuresCourse/blob/master/leead_exsercises/src/%D7%AA%D7%99%D7%A8%D7%92%D7%95%D7%9C%D7%99%D7%9D/MyQueue.java
//    public String toString2() {
//        if (size == 0) return "The Queue is empty";
//        int k = first;
//        String s = "The queue: [";
//        for (int i = 0; i < size - 1; i++) {
//            k = (first + i) % a.length;
//            s += a[k] + ", ";
//        }
//        return s + "" + a[last] + "]";
//    }

    // Ex2
    public boolean contains(int value) {
        boolean ans = false;
        for (int i = 0; i < size; i++) {
            if (que[(pointer + i) % que.length] == value) { // we can also do it as regular searching
                // because this formula is for cycled array, we'll go over the whole elements
                ans = true;
            }
        }
        return ans;
    }

    //Ex3
    // first option is ro go ovr with a loop, but than it will be O(n), but this is not a linked list, we've implemented the Queue by an array
    // because we're working with array we can just return the element in the que[index]
    // and in cycled array we can return the que[(pointer + index) % que.length]
    // and it making it as an O(1)
    public int elementAt(int index) { // it can be parallel to "get(i)"
        if (index >= size || index < 0) {
            // return Integer.MAX_VALUE; // the index is bigger thean the size of the queue
            throw new NoSuchElementException("the index is to bigger form the size of the queue");
        } else {
            // return que[index];
            return que[(pointer + index) % que.length];
        }
    }
    
}
