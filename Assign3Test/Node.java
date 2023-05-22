public class Node {
    Integer key;
    boolean color;

    Node left, right;

    // constructor
    public Node(Integer data, boolean color) {
        this.key = data;
        this.color = color;
        left = right = null;
    }

    // adding for me, for isValidBST
    public Node(int value) {
        this.key = value;
        color = false;
    }

    @Override
    public String toString() {
        return "key: " + key + " color: " + color;
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

    public boolean getColor() {
        return this.color;
    }
}

