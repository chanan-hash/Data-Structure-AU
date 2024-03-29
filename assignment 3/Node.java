public class Node {
    private final Integer key;
    private final boolean color; // RED = false, BLACK = true

    Node left, right; // we have changed it not to be private for working on it

    // constructor
    public Node(Integer data, boolean color) {
        this.key = data;
        this.color = color;
        left = right = null;
    }

    // adding for me, for isValidBST
    Node(int value) {
        this.key = value;
        color = false;
    }

    @Override
    public String toString() {
        return "" + key;
    }

    public boolean isColor() {
        return color;
    }

    public Node getLeft() {
        return this.left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return this.right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Integer getKey() {
        return key;
    }
}

