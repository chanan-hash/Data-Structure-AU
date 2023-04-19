public class Node<T> {

    // variables
     T data;
     Node next;

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    // new node
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node n) {
        this.next = n;
    }

    public String toString() {
        return "" + data;
    }
}
