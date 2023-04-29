import javax.print.DocFlavor;
import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

public class Ex7 {

    public static void main(String[] args) {
        String s1 = "abcdedcba";
        String s2 = "abcddcba";
        String s3 = "abdedcba";
        String s4 = "";
        System.out.println(palindrom(s1)); //true
        System.out.println(palindrom(s2)); //true
        System.out.println(palindrom(s3)); //false
        System.out.println(palindrom(s4)); //true

//        System.out.println();
//        System.out.println(palindrom2(s1)); //true
//        System.out.println(palindrom2(s2)); //true
//        System.out.println(palindrom2(s3)); //false
//        System.out.println(palindrom2(s4)); //true


        /* Testing question 5: */
        Queue<Integer> q = sortedQueue(20);
        System.out.println(q);

    }

    //Ex4
    // helping by Eyal's levi github
    // https://github.com/LeviEyal/DataStructuresCourse/blob/master/leead_exsercises/src/%D7%AA%D7%99%D7%A8%D7%92%D7%95%D7%9C%D7%99%D7%9D/ex7.java
    public static boolean palindrom(String str) {
        Queue<Character> qu = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        // first need to add the String into the Stack and queue

        for (int i = 0; i < str.length(); i++) {
            qu.add(str.charAt(i));
            stack.push(str.charAt(i));
        }

        while (!qu.isEmpty()) { // they are in the same size, so we can run only on one data-structure
            if (!qu.poll().equals(stack.pop())) {
                return false;
            }
        }
        return true;
    }

    /**
     * we can also run till half of the string and saving more time,
     * the queue will get the first half, and the stack the second half (or the opposite?)
     * and then checking each character one against each other.
     * if the String length was even so we'll and each half,
     * if the string length is odd, so there'll be one character that wasn't added to any one, but it will be exactly in the middle so it equals to itself, and not effecting our checkup
     * we will check from the beginning till it, and from after it till the end
     * <p>
     * notice!!!!!!!
     * This function logic won't work in this way (after debugging it)
     * if there are two Stack or two Queues, the same data-structures it will work.
     * but if they are the opposite of data-structures, it won;t work:
     * for example "abcba"
     * queue = 'a','b' --> FIFO
     * stack = 'a','b' --> LIFO
     * but when we'll try to pop/poll and compare we will get
     * poll = 'a'
     * pop = 'b'
     * and will remain:
     * queue = 'b'
     * stack = 'a'
     */
    public static boolean palindrom2(String str) {
        Queue<Character> q = new LinkedList<>();
        Stack<Character> s = new Stack<>();
        // O(n/2) --> although it equals to O(n), the logic behind is different, and can reduce the run time
        for (int i = 0; i < (str.length() / 2); i++) {
            q.add(str.charAt(i));
            s.add(str.charAt(str.length() - i - 1)); // adding form the end
        }
        while (!q.isEmpty()) {
            if (!q.poll().equals(s.pop())) {
                return false;
            }
        }
        return true;
    }

    //Ex5
    // We will randomize the number and add them to the array list, then will sort them by quick sort, then add them to the queue
    public static Queue sortedQueue2(int size) {
        Queue<Integer> que = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) { // O(size)
            Random r = new Random();
            int num = r.nextInt();
            // int num = (int) Math.random() * 100; //number between 0 till 100
            if (!arr.contains(num)) { // adding only if the number is not inside the array
                arr.add(num);
            } else {
                boolean flag = false;
                while (!flag) { // not always we will go in it, O(size), if we need to check the whole array, by contains function
                    num = r.nextInt();//(int) Math.random() * 100; // need to grill a new number
                    if (!arr.contains(num)) { // repeating as above, we are doing it twice because,maybe we won't have to go in the will
                        arr.add(num);
                        flag = true;
                    } else {
                        num = r.nextInt();//(int) Math.random() * 100;
                    }
                }
            }
        }
        Arrays.sort(arr.toArray()); // O(nlog(n)) -->quicksort
        for (int i = 0; i < arr.size(); i++) { // O(n) adding to the queue
            que.add(arr.get(i));
        }
        return que;
    }

    // Eyal's levi solution
    // https://github.com/LeviEyal/DataStructuresCourse/blob/master/leead_exsercises/src/%D7%AA%D7%99%D7%A8%D7%92%D7%95%D7%9C%D7%99%D7%9D/ex7.java
    public static Queue<Integer> sortedQueue(int size) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            int r = (int) (Math.random() * 100); //grilling a number
            while (q.contains(r)) r = (int) (Math.random() * 100); // O(q.size())
            q.add(r);
            while (q.element() < r) q.add(q.remove()); // Retrieves, but does not remove, the head of this queue.
            // This method differs from peek only in that it throws an exception if this queue is empty.
            q.add(r);
            while (q.element() > r)
                q.add(q.remove()); // taking it out add adding it again in the end if the number is bigger,
            // this will sort the queue
            q.remove();
        }
        return q;
    }

}



