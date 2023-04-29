public class BinarySearchTree {
    /**
     * In binary search tree the bigger element form the node is on the right side, and smaller in the left side
     */
    NodeSearch root;
    int size = 0;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    // Iterative add
    public void insert(Integer val) {
        NodeSearch newNode = new NodeSearch(val);
        if (root == null) {
            root = newNode;
        } else {
            NodeSearch p = root; // start going over form the head till we'll find the right place
            boolean flag = false;
            while (!flag) {
                // going to the right
                if (val.compareTo(p.number) > 0) { // means by the comperator val > root, returned 1;
                    if (p.right != null) {
                        p = p.right; // keep moving to the right side
                    } else {
                        p.right = newNode;
                        flag = true;
                    }
                } else { // val.compareTo(p.number) < 0
                    if (p.left != null) {
                        p = p.left; // moving to the left side
                    } else {
                        p.left = newNode;
                        flag = true;
                    }
                }
            }
        }
    }


}
