public class RedBlackTree {

    // https://www.happycoders.eu/algorithms/red-black-tree-java/
    public class Node {
        int data;
        Node left, right, parent;
        boolean color;

        public Node(int data) {
            this.data = data;
        }

        public String toString() {
            String c = color ? "black" : "red";
            return data + ", " + c;
        }

        public boolean getColor() {
            return this.color;
        }
    }


    // https://www.happycoders.eu/algorithms/red-black-tree-java/
    static final boolean RED = false;
    static final boolean BLACK = true;
    Node root;

    public RedBlackTree() {
        root = null;
    }

    private void rotateRight(Node node) {
        Node parent = node.parent;
        Node leftChild = node.left;
        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }
        leftChild.right = node;
        node.parent = leftChild;
        replaceParentsChild(parent, node, leftChild);
    }

    private void rotateLeft(Node node) {
        Node parent = node.parent;
        Node rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }
        rightChild.left = node;
        node.parent = rightChild;
        replaceParentsChild(parent, node, rightChild);
    }

    private void replaceParentsChild(Node parent, Node oldChild, Node newChild) {
        if (parent == null) {
            root = newChild;
        } else if (parent.left == oldChild) {
            parent.left = newChild;
        } else if (parent.right == oldChild) {
            parent.right = newChild;
        } else {
            throw new IllegalStateException("Node is not a child of its parent");
        }

        if (newChild != null) {
            newChild.parent = parent;
        }
    }

    private Node getUncle(Node parent) {
        Node grandparent = parent.parent;
        if (grandparent.left == parent) {
            return grandparent.right;
        } else if (grandparent.right == parent) {
            return grandparent.left;
        } else {
            throw new IllegalStateException("Parent is not a child of its grandparent");
        }
    }

    // search node with given key
    public Node searchNode(int key) {
        Node node = root;
        while (node != null) {
            if (key == node.data) {
                return node;
            } else if (key < node.data) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    // insert new key
    public void insert(int key) {
        Node node = root;
        Node parent = null;
        // Traverse the tree to the left or right depending on the key
        while (node != null) {
            parent = node;
            if (key < node.data) {
                node = node.left;
            } else if (key > node.data) {
                node = node.right;
            } else {
                throw new IllegalArgumentException("BST already contains a node with key " + key);
            }
        }
        // Insert new node
        Node newNode = new Node(key);
        newNode.color = RED;
        if (parent == null) {
            root = newNode;
        } else if (key < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        newNode.parent = parent;
        fixRedBlackPropertiesAfterInsert(newNode);
    }

    //
    private void fixRedBlackPropertiesAfterInsert(Node node) {
        Node parent = node.parent;
        // Case 1: Parent is null, we've reached the root, the end of the recursion
        if (parent == null) {
            // Uncomment the following line if you want to enforce black roots (rule 2):
            // node.color = BLACK;
            return;
        }
        // Parent is black --> nothing to do
        if (parent.color == BLACK) {
            return;
        }
        // From here on, parent is red
        Node grandparent = parent.parent;
        // Case 2:
        // Not having a grandparent means that parent is the root. If we enforce black roots
        // (rule 2), grandparent will never be null, and the following if-then block can be
        // removed.
        if (grandparent == null) {
            // As this method is only called on red nodes (either on newly inserted ones - or -
            // recursively on red grandparents), all we have to do is to recolor the root black.
            parent.color = BLACK;
            return;
        }

        // Get the uncle (may be null/nil, in which case its color is BLACK)
        Node uncle = getUncle(parent);

        // Case 3: Uncle is red -> recolor parent, grandparent and uncle
        if (uncle != null && uncle.color == RED) {
            parent.color = BLACK;
            grandparent.color = RED;
            uncle.color = BLACK;

            // Call recursively for grandparent, which is now red.
            // It might be root or have a red parent, in which case we need to fix more...
            fixRedBlackPropertiesAfterInsert(grandparent);
        }
        // Parent is left child of grandparent
        else if (parent == grandparent.left) {
            // Case 4a: Uncle is black and node is left->right "inner child" of its grandparent
            if (node == parent.right) {
                rotateLeft(parent);
                // Let "parent" point to the new root node of the rotated sub-tree.
                // It will be recolored in the next step, which we're going to fall-through to.
                parent = node;
            }
            // Case 5a: Uncle is black and node is left->left "outer child" of its grandparent
            rotateRight(grandparent);
            // Recolor original parent and grandparent
            parent.color = BLACK;
            grandparent.color = RED;
        }
        // Parent is right child of grandparent
        else {
            // Case 4b: Uncle is black and node is right->left "inner child" of its grandparent
            if (node == parent.left) {
                rotateRight(parent);
                // Let "parent" point to the new root node of the rotated sub-tree.
                // It will be recolored in the next step, which we're going to fall-through to.
                parent = node;
            }
            // Case 5b: Uncle is black and node is right->right "outer child" of its grandparent
            rotateLeft(grandparent);
            // Recolor original parent and grandparent
            parent.color = BLACK;
            grandparent.color = RED;
        }
    }

    public void printPreorderPlus() {
        printPreorderPlus("", root);
    }

    public void printPreorderPlus(String Path, Node node) {
        if (node != null) {
            System.out.println(node + ": " + Path);
            printPreorderPlus(Path + "L", node.left);
            printPreorderPlus(Path + "R", node.right);
        }
    }

    // assignment 3
//    public boolean isBlackHeight() {
//        if (root == null) {
//            return true;
//        }
//        return countBlackNodes(root, 0) != -1;
//    }
//
//    // Helper method to count the number of black nodes in each path
//    private int countBlackNodes(Node node, int blackCount) {
//        if (node == null) {
//            return blackCount;
//        }
//
//        if (node.getColor() == BLACK) { // means it is black node
//            blackCount++;
//        }
//
//        int leftCount = countBlackNodes(node.left, blackCount);
//        int rightCount = countBlackNodes(node.right, blackCount);
//
//        if (node.left != null && node.right != null && leftCount != rightCount) {
//            return -1; // means the black path are different one of each other
//        }
//
//        return Math.max(leftCount, rightCount);
//    }



//    public boolean hasValidHeight2() {
//        if (root == null) {
//            return true;
//        }
//        return countBlackNodes2(root, 0) != -1;
//    }


//    public static int countBlackNodes2(Node node, int blackCount) {
//        if (node == null) {
//            return blackCount;
//        }
//
//        int leftCount = countBlackNodes2(node.left, blackCount);
//        int rightCount = countBlackNodes2(node.right, blackCount);
//
//        if (leftCount != rightCount || leftCount == -1) {
//            return -1; // means the black path are different one of each other
//        }
//
//        if (node.color == BLACK) { // means it is black node
//            return blackCount + 1;
//        } else {
//            return blackCount + 0;
//        }
//    }





    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(7);
        tree.insert(11);
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(2);
        tree.insert(3);
        tree.insert(6);
        tree.insert(8);
        tree.insert(4);
        tree.printPreorderPlus();

//        System.out.println(tree.isBlackHeight());
//        System.out.println(tree.hasValidHeight2());



    }

}
