import java.util.LinkedList;
import java.util.Queue;

public class Ex2_SpecialQueue {
    // working the same as Ex2_Queue, but is built on implemented java's queue
    private int min = 0, max = 0, length = 0;
    private double avg = 0, sum = 0;
    Queue<Integer> qu;


    // constructor
    public Ex2_SpecialQueue() {
        qu = new LinkedList<>();
        min = Integer.MAX_VALUE; // so we can find a min value
    }

    public boolean add(Integer val) {
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
                int i = 0; // need to be fixed
                while (i < getLen()) {
                    if (ans < min) {
                        min = ans;
                    } else if (ans >= max) { //max = val > max ? val :max;
                        max = ans;
                    }
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
        q.add(1);
        q.add(6);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.add(5));
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
