public class Node {
    private final Integer key;
    private final boolean color;

    Node left, right;

    // constructor
    public Node(Integer data, boolean color) {
        this.key = data;
        this.color = color;
        left = right = null;
    }

    @Override
    public String toString() {
        return "" + key;
    }

    public boolean isColor() {
        return color;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Integer getKey() {
        return key;
    }
}
