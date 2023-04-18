public class Node<T> {

    // variables
    private T data;
    private Node next;

    public Node(T data, Node next){
        this.data = data;
        this.next = next;
    }
    
    // new node
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

}
