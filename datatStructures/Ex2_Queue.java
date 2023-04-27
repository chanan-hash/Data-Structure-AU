public class Ex2_Queue {

    private int min = 0, length = 0, max = 0, front = 0, tail = 0;
    private double avg = 0, sum = 0;

    private int[] que;

    // constructor
    public Ex2_Queue(int capacity) {
        que = new int[capacity];
        this.front = 0;
        this.tail = -1;
        // initialize them with something from the queue
    }

    // O(1), adding to the que
    public boolean add(int val) {
        if (length == que.length) {
            return false;
        } else {
            que[(++tail) % que.length] = val; // ++tail, is increasing tail and then using it, tail++, using the tail ind then increasing
            max = que[0]; // for the first adding it needs to be here
            min = que[0];
            this.min = Math.min(this.min, val);
            this.max = Math.max(this.max, val);
            length++;
            sum += val; // keeping the sum for calculating the average
            this.avg = sum/length;
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
            front = (front + 1) % que.length;
            length--;
            this.avg = ((avg * (length + 1)) - ans) / length; // restoring the sum of the values before dividing in the length,
            // subtracting form the sum the values that was dequeued,
            // and dividing by the new length

            // we can do also
            // if(ans == min || ans == max), for/while....and updating min/max values,
            // but here, we will compare and update again sometimes max because we popped min (and the opposite)


            // if we have removed the min value
            if (ans == this.min) {

                for (int i = 0; i < length; i++) {
                    min = Math.min(que[(front + i)%que.length] ,que[front]); // so we will compare only from what has remained in the queue
                }
            }

            // if we have removed the max value
            if (ans == max) {
                for (int i = 0; i < length; i++) {
                    max = Math.max(que[i],que[front]);
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

    public String toString() {
        if (length == 0) return "The Queue is empty";
        int k = front;
        String s = "The queue: [";
        for (int i = 0; i < length-1; i++) {
            k = (front + i) % que.length;
            s += que[k] + ", ";
        }
        return s + "" + que[(tail)] + "]";
    }


    // checking the queue
    public static void main(String[] args) {
        Ex2_Queue qu = new Ex2_Queue(6);
        qu.add(1);
        qu.add(6);
        qu.add(2);
        qu.add(3);
        qu.add(4);
        System.out.println(qu.add(5));

        System.out.println(qu.getMax());
        System.out.println(qu.getMin());
        System.out.println(qu.getAvg());

        System.out.println(qu);
        System.out.println(qu.getLen());

        qu.remove();

        System.out.println(qu.remove());
        System.out.println(qu);

        System.out.println(qu.getMax());
        System.out.println(qu.getMin());
        System.out.println(qu.getAvg());
        System.out.println(qu.getLen());
    }

}

