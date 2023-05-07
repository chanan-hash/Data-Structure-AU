import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Assignment2Ex4 {
    /**
     * This class represents an array that holding LinkedList,ArrayList,Stack,Queue:
     * Every data-structure the adding to it is O(1)
     * Leead the lecturer said that we can use array that holds 10 places for each range although sometimes the places can be null,
     * because allocating a finite and small mount of memory is not affecting so much for the complexity of space
     */

    /*
     * We will use an array of linked list.
     * we will allocate a 10 size array, each place will represent a range of number
     * 1) When we want to erase a whole range, we will just change the place in the array to be null --> O(1)
     * 2) To add an element we will just add in the end/or in the beginning of the list, because we have 'head' and 'tail' Nodes, the complexity of adding is O(1)
     * 3) To return an while range in linear time O(n), just to print the whole, place of the range if it is not null
     * 4) we will count how many places in the array we have that ar not null, because it will be no more than 10, so it is O(10) --> O(1)
     *
     * The checking will be by casting to int, because we are checking the headline if the range, and the internal order is not important
     */

    private LinkedList<Double>[] arr;

    public Assignment2Ex4() {
        arr = new LinkedList[10];
    }

    // The ranges are representing by casting to int, and returning the range that was erased
    // O(1)
    public void eraseRange(double range) {
        if (arr[(int) range] == null) {
            System.out.println("The range is all ready erased");
            // return null;
        } else {
            arr[(int) range] = null; // making it null
            // return (int) range;
            System.out.println((int) range + " range was erased");
        }
    }

    // O(1)
    public void addToRange(double value) {
        // If it is the first value in the range
        if (arr[(int) value] == null) {
            arr[(int) value] = new LinkedList<Double>();
            arr[(int) value].add(value); // also 'add' function is adding by default at the end
        } else {
            arr[(int) value].addLast(value); // if the range is already exists, so we are adding it to the range in the end of the LinkedList in that place
        }
    }

    // Getting a whole range in linear time --> O(range) --> O(n)
    // we can do it also manually depends on the  implementation of the toString.
    // Or to save it before as a String and then return it.
    public String getRange(double range) {
        if (arr[(int) range] == null) {
            return null;
        } else {
            return arr[(int) range].toString(); // O(n)
        }
    }


    // The range won't be more than 10, as the instruction in the assignment
    public int countRange() {
        int count = 0;
        for (int i = 0; i < arr.length; i++) { // O(1O) --> O(1)
            if (arr[i] != null) {
                count++;
            }
        }
        return count;
    }


    // toString for the whole array itself
    @Override
    public String toString() {
        return "Assignment2Ex4{" +
                " arr = " + Arrays.toString(arr) +
                '}';
    }


    public static void main(String[] args) {
        Assignment2Ex4 list = new Assignment2Ex4();
        list.addToRange(5.4);// 1 --> nu,ber of ranges
        list.addToRange(6.4);// 2
        list.addToRange(7.4);// 3
        list.addToRange(3.4);// 4
        list.addToRange(2.2);// 5
        list.addToRange(2.8);
        list.addToRange(5.5);
        list.addToRange(6.8);
        list.addToRange(0.2);// 6
        list.addToRange(1.1);// 7
        list.addToRange(8.9);// 8
        list.addToRange(4.3);// 9
        System.out.println(list.getRange(5.3));
        System.out.println(list.countRange());
        System.out.println(list.toString());
        list.eraseRange(5);

        System.out.println(list.getRange(5.2));
        System.out.println(list.countRange());
        System.out.println(list.toString());

    }
}
