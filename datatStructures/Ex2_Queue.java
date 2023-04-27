public class Ex2_Queue {

    private int min = 0, length = 0, max = 0, front = 0, tail = 0;
    private double avg = 0;

    private int[] que;

    // constructor
    public Ex2_Queue(int capacity) {
        que = new int[capacity];
        this.front = 0;
        this.tail = 0;
        // initialize them with something from the queue
        max = que[0];
        min = que[0];
    }

    // O(1), adding to the que
    public boolean add(int val) {
        if (length == que.length) {
            return false;
        } else {
            que[(front + 1) % que.length] = val;
            this.min = Math.min(this.min, val);
            this.max = Math.max(this.max, val);
            length++;
            this.avg = (avg + val) / length; // we have updated the length before it
            return true;
        }

        // may need to be changed as elizabet queue
    }

    //O(n) because we need to find the new min value if we have removed it, or max value
    public Integer remove() {
        if (isEmpty()) {
            return null;
        } else {
            Integer ans = que[front];
            front = (front + length) % que.length;
            length--;
            this.avg = ((avg * (length + 1)) - ans) / length; // restoring the sum of the values before dividing in the length,
            // subtracting form the sum the values that was dequeued,
            // and dividing by the new length
            if (ans == this.min) {
                for (int i = 0; i < length; i++) {
                    min = Math.min(que[front + i] % que.length, min);
                }
            }
            if (ans == max) {
                for (int i = 0; i < length; i++) {
                    max = Math.max(que[front + i] % que.length, max);
                }

            }
            return ans;
        }
    }

    //O(1)
    public boolean isEmpty() {
        return length == 0;
    }

    //O(1), just initializing the values to be Zero, so we won't have access to the queue
    public void clear() {
        this.length = 0;
        this.front = 0;
        this.tail = 0;
    }


    // All of those functions are in complexity of
    // O(1), because we are returning only the value, and not calculating anything else
    public int getMin() {
        return this.min;
    }

    public int getMax() {
        return this.max;
    }

    public double getAvg() {
        return this.avg;
    }

    public int getLen() {
        return this.length;
    }

}
