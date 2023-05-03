public class LinkedLIstTortoise {
    /**
     * This class for checking if a simple linked list has a loop inside it.
     * different from cycled LinkedList, a list with a loop doesn't have to be from the tail to the head,
     * the loop can be after few steps inside the list
     */

    public static boolean hasLoop(Node<Integer> head) {
        if (head == null) { // the list is empty
            return false;
        } else {
            Node<Integer> fast = head.next, slow = head; // one runs one step before the other
            boolean ans = true;
            while (ans) {
                if (fast == null || slow == null || fast.next == null) {
                    return false; // means we've got to the end of the list and there is no more, because we got stuck at null
                    // so the list does't have a loop
                }
                if (fast == slow) { // means fast succeeded some how to catch slow, means there is a pointer inside the list, and created a loop
                    System.out.println("There is a loop at, slow: " + slow.data + "fast: " + fast.data);
                    return true;
                }
                fast = fast.next.next; // runs in a two step ahead
                slow = slow.next;
            }
            return ans;
        }
    }

    // Finding the Start of a Loop in a Circular Linked List
    /*
    we can't really use the previous function of 'hasLoop', because we need to find the meeting point,
    so we need to check again if there is a loop,
    and use the nodes from the checking,
    because if there is a loop so for the rest if the function we will start them from the meeting point

     */
    public static Node<Integer> findLoopStart(Node<Integer> head) { // usually we'll start checking form the head of the list
        if (head == null) {
            return null;
        }
        // Finding if there is a loop first
        // Again with the same idea we are using fast node and slow node
        Node<Integer> fast = head.next, slow = head; // one runs one step before the other
        boolean ans = true;
        while (!ans) {
            if (fast == null || slow == null || fast.next == null) break; // means there is no loop inside the list
            if (fast == slow) { // comparing addresses
                ans = true; // and we'll go out of the loop because !ans = !true = false
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        if (ans) { // ans == true;
            System.out.println("loop start - slow: " + slow.data + ", fast: " + fast.data);
            // the circle exists, the fast moves to the start point
            // the slow remains in the meeting point,
            // and we will count the number of steps we had to do
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next; // slow = slow ?
            }
            return fast;
        }
        return null;
    }

    //Finding the Length of a Loop in a Circular Linked List
    public static int findLoopLength(Node<Integer> head) {
        Node<Integer> meetingPoint = findLoopStart(head); // adter this function we'll get the start of the meeting point, if exists
        if (meetingPoint != null) {
            int count = 1;
            // Again The same idea of fast and slow nodes
            Node<Integer> fast = meetingPoint.next, slow = meetingPoint;
            while (fast != slow) {
                count++;
                fast = fast.next; // They both inside the loop if we are here, so we will count from the meeting point,
                // till we are again will be three
            }
            return count;
        }
        return -1; // There is no loop, so also no length, that is represented as -1
    }
    
}