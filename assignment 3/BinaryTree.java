public class BinaryTree {
    /**
     * This class represent an empty binary tree that we can work with in our assignment questions
     */
    private Node root;
    int size;

    public Node getRoot() {
        return this.root;
    }

    public BinaryTree() {
        root = null;
        size = 0;
    }
}
