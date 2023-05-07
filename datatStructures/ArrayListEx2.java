import java.util.ArrayList;
import java.util.LinkedList;


public class ArrayListEx2 {
    /**
     * This class represents an array that holding LinkedList,ArrayList,Stack,Queue:
     * Every data-structure the adding to it is O(1)
     * Leead the lecture said that we can use array that holds 10 places for each range although sometimes the places can be null,
     * because allocating a finite and small mount of memory is not affecting so much for the complexity of space
     */

    /*
     * We will use an array of linked list.
     * we will allocate a 10 size array, each place will represent a range of number
     * 1) When we want to erase a whole range, we will just change the place in the array to be null --> O(1)
     * 2) To add an element we will just add in the end/or in the beginning of the list, because we have 'head' and 'tail' Nodes, the complexity of adding is O(1)
     * 3) To return an while range in linear time O(n), just to print the whole, place of the range if it is not null
     * 4) we will count how many places in the array we have that ar not null, because it will be no more than 10, so it is O(10) --> O(1)
     */

    private LinkedList<Double>[] arr;


}
