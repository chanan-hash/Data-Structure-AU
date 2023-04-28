public class NodeSearch {
    // will be similar to the node of the binary tree
    // In the Nodes we haven't used public/private, it will be package so will be access to the variables without getters and setters

    // when we are comparing nodes, we are comparing/or changing addresses because they are pointing for addresses of objects
    Integer number;
    NodeSearch left, right;

    // constructor for new subtree
    public NodeSearch(Integer value) {
        this.number = value;
        left = null;
        right = null;
    }

    public NodeSearch(Integer data, NodeSearch left, NodeSearch right) {
        this.number = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "data: " + number + " ";
    }

}
