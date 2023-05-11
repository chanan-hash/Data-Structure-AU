import com.sun.source.tree.BinaryTree;

public class GenericLL<T> {
    /**
     * This class represents a generic Linked List, we aren't using java's LinkedList because this is already built class
     * <p>
     * For Ex3
     */

    // First building Node class
    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


    Node<T> head, tail;
    int size;

    public GenericLL() {
        head = tail = null;
        size = 0;
    }

    public void add(T data) {
        if (head == null) {
            head = new Node<T>(data);
        } else {
            tail = new Node<>(data, tail);
            // Node n = new Node<>(data);
            // tail.next = n;
            // tail = n;
        }
        size++;
    }

    public T removeFirst() {
        if (head != null) {
            T ans = head.data;
            head = head.next;
            size--;
            return ans;
        } else {
            return null;
        }
    }

    public T remove(T obj) {
        T ans = null;
        if (head.data.equals(obj)) {
            return removeFirst();
        } else {
            Node p = head, n = head;
            while (n != null && !n.data.equals(obj)) {
                p = n;
                n = n.next;
            }
            if (n.data.equals(obj)) {
                ans = (T) n.data;
                p.next = n.next;
                size--;
            }
        }
        return ans;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // For more detailed class see at:
    // https://github.com/LeviEyal/DataStructuresCourse/blob/master/leead_exsercises/src/%D7%AA%D7%99%D7%A8%D7%92%D7%95%D7%9C%D7%99%D7%9D/GenericLinkedList.java

    // Ex5
    public int rec_size() {
        return rec_size(head);
    }

    public int rec_size(Node n) {
        if (n == null) {
            return 0;
        }
        return 1 + rec_size(n.next); // Adding 1 each recursive call, and that how it will count the size
    }

    // Ex6
    // reversing a single linked list by using stack
    // we can do it with queue, but we need a method of 'remove last', and than adding it to the queue. It will behave like a stack
    public void opposite(GenericLL<Integer> list) {
        StackFromLL stack = new StackFromLL();
        while (!list.isEmpty()) { // O(n)
            stack.push(list.removeFirst());
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
    }

    // Another way without using another data structure
//    public Node reverse() {
//        //use copyList function to avoid altering head --> DOESN'T WORK
//        Node current = head;
//        Node temp = null;
//        Node copied_result = null;
//
//        while(current != null){
//            temp = current.next;
//            current.next = copied_result;
//            copied_result = current;
//            current = temp;
//        }
//        return copied_result;
//    }

}

