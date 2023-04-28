import java.util.LinkedList;
import java.util.Queue;

public class Ex2_SpecialQueue {
    // working the same as Ex2_Queue, but is built on implemented java's queue
    private int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, length = 0;
    private double avg = 0, sum = 0;
    Queue<Integer> qu;


    // constructor
    public Ex2_SpecialQueue() {
        qu = new LinkedList<>();
        min = Integer.MAX_VALUE; // so we can find a min value
    }

    public boolean addIN(Integer val) {
        length++;
        if (val < min) {
            min = val;
        } else if (val >= max) { //max = val > max ? val :max;
            max = val;
        }
        sum += val;
        avg = (sum / length);
        return qu.add(val);
    }

    public Integer remove() {
        Integer ans = null;
        if (qu.isEmpty()) {
            ans = null;
        } else {
            ans = qu.poll();
            sum -= ans;
            avg = (sum/length);
            if (ans == min || ans == max) {
                min = Integer.MAX_VALUE; max = Integer.MIN_VALUE; // initializing them again
                int i = 0; // need to be fixed
                while (i < getLen()) {
                    int temp = qu.poll(); // taking uot an element, checking if it is the min or max
                    if (temp < min) {
                        min = temp;
                    } else if (temp >= max) { //max = val > max ? val :max;
                        max = temp;
                    }
                    qu.add(temp); // adding it again. In the end of the loop we'll get the same queue as before, means we didn't change anything
                    i++;
                }
            }
        }
        return ans;
    }

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
        return qu.size();
    }

    public boolean empty() {
        return qu.isEmpty();
    }

    @Override
    public String toString() {
        return qu.toString();
    }

    public static void main(String[] args) {
        Ex2_SpecialQueue q = new Ex2_SpecialQueue();
        q.addIN(1);
        q.addIN(6);
        q.addIN(2);
        q.addIN(3);
        q.addIN(4);
        System.out.println(q.addIN(5));
        System.out.println(q);

        System.out.println(q.getMax());
        System.out.println(q.getMin());
        System.out.println(q.getAvg());

        q.remove();
        q.remove();
        q.remove();
        System.out.println(q);

        System.out.println(q.getMax());
        System.out.println(q.getMin());
        System.out.println(q.getAvg());

    }

}
