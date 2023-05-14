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
}

