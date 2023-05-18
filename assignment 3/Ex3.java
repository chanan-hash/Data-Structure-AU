public class Ex3 {
    static final boolean RED = false;
    static final boolean BLACK = true;

    public static void main(String[] args) {
        // creating a tree with random black height
        // Creating a binary tree with color, RED = true, BLACK = false, from elizabet class
        Node root = new Node(10, BLACK);
        root.left = new Node(5, BLACK);
        root.right = new Node(15, BLACK);
        root.left.left = new Node(2, RED);
        root.left.left.left = new Node(1, BLACK);
        root.left.right = new Node(7, RED);
        root.right.left = new Node(13, RED);
        root.right.left.right = new Node(14,BLACK);
        root.right.right = new Node(21, RED);
       // root.left.right.left = new Node(6, BLACK);
        root.right.right.right = new Node(22, BLACK);

        if (countBlackNodes(root,0) != -1) {
            System.out.println("A valid BST");
        } else {
            System.out.println("Not a valid BST");
        }

        boolean ans = false;
        System.out.println(ans == false);


        Node root2 = new Node(7, BLACK);
        Node node1 = new Node(3, RED);
        Node node2 = new Node(10, RED);
        Node node3 = new Node(1, BLACK);
        Node node4 = new Node(5, BLACK);
        Node node5 = new Node(8, BLACK);
        Node node6 = new Node(12, BLACK);
        Node node7 = new Node(15, BLACK);

        root2.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node6.right = node7;

        if (countBlackNodes(root2,0) != -1) {
            System.out.println("A valid BST");
        } else {
            System.out.println("Not a valid BST");
        }


        // suppose to be valid but getting not
        Node roo3 = new Node(7,RED);
        roo3.left = new Node(4,BLACK);
        roo3.right = new Node(8,BLACK);
        roo3.left.left = new Node(5,BLACK);
        roo3.right.right = new Node(9,BLACK);
        roo3.left.right = new Node(2,RED);
        roo3.right.left = new Node(1,RED);
        roo3.left.left.left = new Node(6,RED);
        roo3.right.right.right = new Node(43,RED);
        roo3.left.left.right = new Node(36,RED);
        roo3.left.right.left = new Node(48,BLACK);
        roo3.right.right.left = new Node(21,RED);
        roo3.right.left.left = new Node(22,BLACK);
        roo3.right.left.right = new Node(24,RED);

        System.out.println(countBlackNodes(roo3,0));
        if (countBlackNodes(roo3,0) != -1) {
            System.out.println("A valid BST");
        } else {
            System.out.println("Not a valid BST");
        }

    }

    public static boolean isValidBST(BinaryTree tree) {
        return isValidBST(tree.getRoot(), null, null);
    }

    public static boolean hasValidHeight(BinaryTree tree) {
//        boolean ans = isValidBST(tree);
//        if (ans == false) { // checking before if it is binary search tree
//            return false;
//        }
        if (tree.getRoot() == null) {
            return true;
        }
        return countBlackNodes(tree.getRoot(), 0) != -1;
    }


    /**
     * This function is checking if the tree is a binary search tree, means:
     * We are going to check if the left son is smaller than the parent,
     * and if the right son is bigger than his parent.
     * <p>
     * complexity:
     * Usually to check if a BT is a search tree, it can take O(n), if the tree only on it's left (or right) side.
     * we need to go over the whole tree and check it, so The complexity is O(n).
     * <p>
     * There are 2 way do it:
     * 1.
     * put the whole tree in Arraylist by inorder, because One of the binary tree qualities is that inorder we will get it sorted.
     * then we can go over the array and check if it sorted, if not return false
     * <p>
     * 2.
     * The function gets Node(the root), maximum value and minimum value.
     * if the Node is null, means the tree is a search tree.
     * explanation: in the recursion if we got to that value that is null and didn't return false till there,
     * means the tree is built like a search tree
     * Then if the max value (that in the recursion will represent the right side of the tree), is less or equal to the node key, means it is not a search tree,
     * because we'll get the nodes value is bigger than it's right son. (or smaller than it's left son)
     * The same for the min value, that in the recursion will represent the left side of the tree.
     * In each recursive call we are passing the Nodes value as the min value to the left subtree,
     * and as the max value to the right subtree
     */

    // visualisation for the function:
    // https://www.youtube.com/watch?v=RzagTQQbn5k

    // From assignment 3
    public static boolean isValidBST(Node n, Integer max, Integer min) {
        // an empty binary trees is a valid BST.
        if (n == null) {
            return true;
        }
        // in the recursion when we go each to left or subtree it will check thew condition of the definition of
        if (max != null && n.getKey() >= max) {
            return false; // for checking the right side
        }
        if (min != null && n.getKey() <= min) { // for checking the left side
            return false;
        }
        return isValidBST(n.left, n.getKey(), min) && isValidBST(n.right, max, n.getKey());
    }


    // The help function for function2

    /**
     * We are counting the black height from each subtree starting from the root and incrementing, every time we see black node.
     * Then in the end if they are different the right path from the left path, means there is a different number of black nodes.
     * in the wrapping function, if the answer is different from -1 means the Red-Black tree is correct
     */
    // Method to check if all paths from root to leaves have the same number of black nodes
    // Helper method to count the number of black nodes in each path

    public static int countBlackNodes(Node node, int blackCount) {
        if (node == null) {
            return blackCount;
        }

        if (node.isColor() == BLACK) { // means it is black node
            blackCount++;
        }

        int leftCount = countBlackNodes(node.left, blackCount);
        int rightCount = countBlackNodes(node.right, blackCount);

        if (node.left != null && node.right != null && leftCount != rightCount) {
            return -1; // means the black path are different one of each other
        }

        return Math.max(leftCount, rightCount);
    }

//    public static int countBlackNodes(Node node, int blackCount) {
//        if (node == null) {
//            return blackCount;
//        }
//
//        int leftCount = countBlackNodes(node.left, blackCount);
//        int rightCount = countBlackNodes(node.right, blackCount);
//
//        if (leftCount != rightCount || leftCount == -1) {
//            return -1; // means the black path are different one of each other
//        }
//        if (node.isColor() == false) { // means it is black node
//            return blackCount + 1;
//        } else {
//            return 0 + blackCount;
//        }
//        //return Math.max(leftCount, rightCount);
//    }

    // another way that fucntion

    public static boolean isValidBST2(BinaryTree tree) {
        return isValidBST2(tree.getRoot());
    }

    public static boolean isValidBST2(Node root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.key < root.left.key) {
            return false;
        }
        if (root.right != null && root.key > root.right.key) {
            return false;
        }
        return isValidBST2(root.left) && isValidBST2(root.right);
    }
}



