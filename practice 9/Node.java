public class Node {
    Integer data;
    Node left, right, parent;

    public Node(Integer num) {
        this.data = num;
        left = right = null;
    }

    public Node(Integer num, Node left, Node right) {
        this.data = num;
        this.left = left;
        this.right = right;
    }
}
