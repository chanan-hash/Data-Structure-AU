public class LinkedList<T> {
    private Node<T> head, tail;
    int size;

    public LinkedList() { // creating a new Linked list
        head = null;
        tail = null;
        size = 0;
    }

    // O(n)
    public void clear() {
        while (head != null) { // while we steel have node/pointers
            head = head.next; // forwarding till it is null, all the pointers will be head, and in the end it will be null
            // the garbage collector will throw out what will have a null pointer/node
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    // because it ia linked list we can always add new value, because we are using nodes/pointers, so it won't be a boolean function
    // Adding the object in the end of the list

    // O(1) --> because we have a tail node, if we hadn't had tail we had to go over the list and append it in the end
    // The complexity would have been O(n), when n is the size of the list till now
    public void add(T obj) {
        if (head == null) {
            head = tail = new Node<>(obj, null); // creating a new list by node, and adding the first element. so the next node is null
            // because we have only one node
        } else {
            Node<T> p = new Node<>(obj, null); // creating the new node, with pointer the next is null
            tail.next = p; // pointing the tial next node to the new node 'p', and making it the last element
        }
        size++; //because we've put new element
    }

    // need to take care of 4 cases
    public T remove(T obj) {
        return null;
    }

    // O(n)
    public boolean contains(T obj) {
        boolean res = false;
        for (Node<T> p = head; p != null; p = p.next) {
            if (p.data.equals(obj)) { // and not ==, because we are comparing the value itself and not it's address
                res = true;
            }
        }
        return res;
    }

    // Elizabet way for contains
    // O(n)
    public boolean contains2(T obj) {
        boolean res = true;
        Node<T> node = head;
        while (node != null && !node.data.equals(obj)) { // while they are not null and not equal
            node = node.next;
        }
        if (node == null) { // means we haven't found it in the list, the node stayed null
            res = false;
        }
        return res;
    }

    // O(1)
    public boolean isEmpty() {
        return size == 0;
    }

}
