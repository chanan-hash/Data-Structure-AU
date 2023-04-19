import java.util.Arrays;

public class TwoStack {
    // This for question 4
    private Integer[] arr;
    int s1, s2; // indexes for the two stacks


    public TwoStack(int size) {
        arr = new Integer[size];
        s1 = -1; // initial for the first stack
        s2 = size - 1; // arr.length-1
    }

    public boolean adS1(Integer value) {
        if (s1 + 1 == s2) {
            return false; // means we are going to bump into each other
        }
        arr[s1++] = value;
        return true;
    }

    public boolean adS2(Integer value) {
        if (s2 - 1 == s1) {
            return false; // means we are going to bump into each other
        }
        arr[--s2] = value;
        return true;
    }

    public Integer pop1() { // need to be represented as an object
        if (s1 < 0) {
            return null;
        }
        return arr[--s1]; // because we've popped we are going the backwards with the first index. This will decrease s1
    }

    public Integer pop2() {
        if (s2 >= arr.length) {
            return null;
        }
        return arr[s2++]; // because we've popped we are going the towards with the second index. This will decrease s2
    }

    public Integer peekS1() {
        if (s1 < 0) {
            return null;
        }
        Integer val = arr[s1];
        return val;
    }

    public Integer peekS2() {
        if (s2 >= arr.length) {
            return null;
        }
        Integer val = arr[s2];
        return val;
    }

    public boolean isS1empty() {
        return s1 < 0;
    }

    public boolean isS2empty() {
        return s2 >= arr.length;
    }

    public int s1Size() {
        return s1 + 1;
    }

    public int s2Size() {
        return arr.length - s2; // to know how much from the length to decrease, because we are going from it backward, end to beginning
    }


    public void toStringS1() {
        if (isS1empty()) {
            System.out.println("Stack1 is empty");
        } else {
            System.out.println("[ ");
            for (int i = 0; i < s1; i++) {
                System.out.print(arr[i] + ", ");
            }
            System.out.print(arr[s1] + " ]");
        }
    }

    // Another wat is to break it to new array and print it
    public void printS1() {
        Integer[] a = Arrays.copyOf(arr, s1);
        Arrays.toString(a);
    }

    public void toStringS2() {
        if (isS2empty()) {
            System.out.println("Stack2 is empty");
        } else {
            System.out.println("[ ");
            for (int i = arr.length - 1; i > s2; i--) {
                System.out.print(arr[i] + ", ");
            }
            System.out.print(arr[s2] + " ]");
        }
    }

    public void printS2() {
        Integer[] a = Arrays.copyOfRange(arr, s1 + 1, s2); // copying from the end of Stack1, that is the first of Stack2
        Arrays.toString(a);
    }

}
