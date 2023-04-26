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
}
