public class CyceldLinkedList<T> {
    private Node<T> head, tail;
    int size = 0;

    // creating new List
    public CyceldLinkedList() {
        head = tail = null;
        size = 0;
    }

    public void add(T data) {
        if (head == null) {
            head = new Node<>(data, null); // the next node is null, because we are adding the first element
            tail = head;
            tail.next = head;
        } else { // means there is more than 1 object in the list
            Node<T> p = new Node<T>(data, head); // the next node will be the head, because we are adding in the end of the list
            tail.next = p; // the nex of the tail will point on the new node, and the new node is already pointing on the head for the cycling
            tail = p;
        }
        size++;
    }


    // Removes the first occurrence of the specified element
    // from this list, if it is present.
    public T remove(T obj) {
        T res = null;
        if (head == null) { // empty list
            return null;
        }
        // removing the first element
        if (head.data.equals(obj)) {
            res = head.data;
            if (head.next == head) { // means there is only one Node in the list. size == 1
                head = null;
            } else {
                head = head.next; // And hte garbage collector will throw the first Node, because it is becomes null
                tail.next = head; // need to point on the now head that has been changed
            }
            size--;
        }
        // if the element is in the middle or at the end
        else {
            Node<T> prev = head, p = head.next; // 2 Node that One is faster than the other by One step, the prev will help us to erase, and the 'p' to run on the list
            while (!p.data.equals(obj) && p != tail) { // because if we are in this block means we have checked the first element, so the loop starting from the second element
                prev = p;
                p = p.next;
            }
            if (p.data.equals(obj)) { // now we went on the whole list, if we've found the element
                res = p.data;
                if (p != tail) { // the element is from the middle
                    prev.next = p.next; // the erasing
                } else { // The element is the tail
                    tail = prev; // The tail will be the element One before the end
                    tail.next = head;
                }
                size--;
            }
        }
        return res;
    }


    public boolean contains(T obj) {
        if (head == null) { // the list is empty
            return false;
        } else if (head.data.equals(obj)) { // In cycled list we will deal with the 'head' separately from the other node because of the cycling.
            // we will start form the node after 'head' --> head.next, and checking till we are getting again to the 'head' this is our stop condition
            // while (node != head)
            return true;
        } else {
            Node<T> n = head.next;
            while (n != head) {
                if (n.data.equals(obj)) {
                    return true;
                } else {
                    n = n.next;
                }
            }
        }
        return false; // If we got here, means we haven't found the object/element in the list
    }

    public String toString() {
        String s = "[";
        if (head != null) {
            s = s + head.toString() + ", ";
            for (Node<T> n = head.next; n != head; n = n.next) { // the stop condition here is no n != null, because the list is cycled it will be infinite loop, so we need to stop when we are getting again to 'head'
                s = s + n.toString() + ", ";
            }
            s = s.substring(0, s.length() - 2);
        }
        return s + "]";
    }
}
