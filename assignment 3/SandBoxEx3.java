public class SandBoxEx3 {
    static final boolean RED = false;
    static final boolean BLACK = true;

    public static void main(String[] args) {

        Node r = new Node(8);
        r.left = new Node(5);
        r.right = new Node(10);
//        System.out.println(isValidBST2(r));
        System.out.println(isValidBST(r, null, null)); // true

        Node root4 = new Node(10);
        root4.left = new Node(5);
        root4.right = new Node(15);
        root4.left.left = new Node(2);
        root4.left.left.left = new Node(1);
        root4.left.right = new Node(7);
        root4.right.left = new Node(13);
        root4.right.left.right = new Node(14);
        root4.right.right = new Node(21);

        //System.out.println(isValidBST2(root4));
        System.out.println(isValidBST(root4, null, null)); // true


        Node root8 = new Node(25, BLACK);

        // left subtree
        root8.left = new Node(12, BLACK);
        root8.left.left = new Node(6, BLACK);

        root8.left.right = new Node(15, RED);
        root8.left.right.left = new Node(14, BLACK);
        root8.left.right.right = new Node(16, BLACK);
        root8.left.right.left.left = new Node(13, RED);

        // right subtree
        root8.right = new Node(100, BLACK);
        root8.right.left = new Node(37, BLACK);
        root8.right.left.left = new Node(27, RED);
        root8.right.left.right = new Node(50, RED);

        root8.right.right = new Node(150, RED);
        root8.right.right.right = new Node(167, BLACK);
        root8.right.right.left = new Node(125, BLACK);
        root8.right.right.left.left = new Node(112, RED);

        System.out.println("This is: " + isValidBST(root8,null,null));

        Node root3 = new Node(5);
        root3.left = new Node(7);
        root3.right = new Node(10);

        System.out.println(isValidBST(root3, null, null)); // false


        // creating a tree with random black height
        // Creating a binary tree with color, RED = true, BLACK = false, from elizabet class


        // suppose to be valid but getting not


    }

    public static boolean isValidBST(BinaryTree2 tree) {
        return isValidBST(tree.getRoot(), null, null);
    }

    public static boolean hasValidHeight(BinaryTree2 tree) {
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

    // elizabet siad that we can assume that the whole keys are different
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

//    public static int countBlackNodes(Node node, int blackCount) {
//        if (node == null) {
//            return blackCount;
//        }
//
//        if (node.isColor() == BLACK) { // means it is black node
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
    public static int countBlackNodes(Node node, int blackCount) {
        if (node == null) {
            return blackCount;
        }

        int leftCount = countBlackNodes(node.left, blackCount);
        int rightCount = countBlackNodes(node.right, blackCount);

        if (leftCount != rightCount || leftCount == -1) {
            return -1; // means the black path are different one of each other
        }
        if (node.isColor() == BLACK) { // means it is black node
            return blackCount + 1;
        } else {
            return 0 + blackCount;
        }
//        return Math.max(leftCount, rightCount);
    }

    // another way that fucntion

//    public static boolean isValidBST2(BinaryTree tree) {
//        return isValidBST2(tree.getRoot());
//    }
//
//    public static boolean isValidBST2(Node root) {
//        if (root.left == null && root.right == null) {
//            return true;
//        }
//        if (root.left != null && root.key < root.left.key) {
//            return false;
//        }
//        if (root.right != null && root.key > root.right.key) {
//            return false;
//        }
//        return isValidBST2(root.left) && isValidBST2(root.right);
//    }


    public static boolean hasValidHeight2(BinaryTree2 tree) {
        return hasValidHeight1(tree.getRoot());
    }

    public static boolean hasValidHeight1(Node nd) {
        if (nd == null) {
            return true;
        }
        if (hight(nd.getLeft()) != hight(nd.getRight())) {
            return false;
        }
        return hasValidHeight1(nd.getRight()) && hasValidHeight1(nd.getLeft());
    }

    public static int hight(Node nd) {
        if (nd == null) {
            return 0;
        }
        if (nd.isColor() == BLACK) {
            return Math.max(hight(nd.getLeft()), hight(nd.getRight())) + 1; // changed --> adding also getRight
        }
        return Math.max(hight(nd.getLeft()), hight(nd.getRight()));
    }


    public static int _numBlack(Node root) {
        if (root == null) {
            return 0;
        }
        int black_left = _numBlack(root.left);
        int black_right = _numBlack(root.right);
        if (black_left != black_right || black_left == -1) {
            return -1;
        }
        if (root.isColor() == BLACK) {
            return 1 + black_left;
        } else {
            return 0 + black_left;
        }
    }

    public static boolean isBalanced(Node root) {

        int black_left = _numBlack(root.left);
        int black_right = _numBlack(root.right);
        if ((black_left != black_right) || (black_left == -1)) {
            return false;
        }
        return true;
    }
}



