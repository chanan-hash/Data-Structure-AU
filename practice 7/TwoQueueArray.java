public class TwoQueueArray {
    // Ex6
    // helped by https://github.com/LeviEyal/DataStructuresCourse/blob/master/leead_exsercises/src/%D7%AA%D7%99%D7%A8%D7%92%D7%95%D7%9C%D7%99%D7%9D/TwoQueue.java
    private Integer[] arr;
    int q1, q2; // indexes for the two

    //O(1)
    public TwoQueueArray(int size) {
        arr = new Integer[size]; // max capacity
        q1 = -1;
        q2 = arr.length;
    }

    //O(1)
    public boolean enQueue1(Integer n) {
        if (q1 + 1 == q2) {
            return false; // means we are going to add to the second queue, so we are stopping
        } else {
            arr[++q1] = n; // incrementing q1 and then adding
            return true;
        }
    }

    // For q2 work tha same but starting from the opposite
    // O(1)
    public boolean enQueue2(Integer num) {
        if (q2 - 1 == q1) { // going back words
            return false;
        } else {
            arr[--q2] = num; // decrease q2 and than adding
            return true;
        }
    }

    //O(q1)
    public Integer dequeueQ1() {
        if (isEmptyQ1()) {
            return null;
        }
        Integer ans = arr[0]; // the firs element, we can move the pointer backwards, but we also want to move the elements backwards
        for (int i = 0; i < q1; i++) {
            arr[i] = arr[i + 1];
        }
        q1--;
        return ans;
    }

    // For q2 work tha same but starting from the opposite
    //O(q2)
    // if we'll move only the pointers it will be O(1), it different from stack, so we cant use the pointer like this
    // we need the access to the first place in the array, and the last place int the array, because of the FIFO
    // to understand it more I suggest to write and draw it to understand the difference and why we need to move the elements each time
    // We can build a cycled queue to make it O(1), but it a little bit more complicated because of the two pointers, but possible
    public Integer dequeueQ2() {
        if (isEmptyQ2()) {
            return null;
        }
        Integer res = arr[arr.length - 1];
        for (int j = arr.length - 1; j > q2; j--) {
            arr[j] = arr[j - 1]; // moving all te element to the right palse
        }
        q2++;
        return res;
    }

    //O(1)
    public int size1() {
        return q1 + 1; // because we are starting from -1
    }

    //O(1)
    public int size2() {
        return arr.length - q2; // because we are starting from arr/length
    }

    public boolean isEmptyQ1() {
        return size1() == 0;
    }

    public boolean isEmptyQ2() {
        return size2() == 0;
    }

}
