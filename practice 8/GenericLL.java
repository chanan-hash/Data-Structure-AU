public class GenericLL<T> {
    /**
     * This class represents a generic Linked List, we aren't using java's LinkedList because this is already built class
     *
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




}

