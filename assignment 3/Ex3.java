public class Ex3 {
    /**
     * This class have the Two functions of the assignment:
     * 1. checking if a binary tree is also a binary-search tree
     * 2. checking if a tree has from the root till it's leaves the same black nodes in every path
     */

    // Those variables for checking black height in the Tree
    static final boolean RED = false;
    static final boolean BLACK = true;

    public static void main(String[] args) {

    }


    /**
     * This function is checking if the tree is a binary search tree, means:
     * We are going to check if the left son is smaller than the parent,
     * and if the right son is bigger than his parent.
     *
     * Elizabet said that we can assume that the whole keys are different!!
     *
     * complexity:
     *    * Usually to check if a BT is a search tree, it can take O(n), if the tree only on it's left (or right) side.
     *    * we need to go over the whole tree and check it, so The complexity is O(n).
     *
     * There are 2 way do it:
     * 1.
     *     put the whole tree in Arraylist by Inorder, because One of the binary tree qualities is that inorder we will get it sorted.
     *     then we can go over the array and check if it sorted, if not return false.
     *
     * 2. our recursive function
     *     The function gets Node(the root), maximum value and minimum value.
     *     If the Node is null, means the tree is a search tree.
     *     Explanation: in the recursion if we got to that value that is null and didn't return false till there,
     *     means the tree is built like a search tree.
     *
     *     If the max value (that in the recursion will represent the right side of the tree), is less or equal to the node key,
     *     means it is not a search tree, and return false,
     *     because we'll get the nodes value is bigger than it's right son. (or smaller than it's left son).
     *     The same for the min value, that in the recursion will represent the left side of the tree.
     *     In each recursive call we are passing the Nodes value as the min value to the left subtree,
     *     and as the max value to the right subtree.
     *     And that how in each recursive call we are getting the parent key, and can check it according the node itself.
     */

    // Ex1.1
    public static boolean isValidBST(BinaryTree2 tree) { // O(n)
        return isValidBST(tree.getRoot(), null, null);
    }


    public static boolean isValidBST(Node n, Integer max, Integer min) {
        // an empty binary trees is a valid BST.
        if (n == null) {
            return true;
        }
        // in the recursion when we go each to left or subtree it will check the condition of the definition of BST
        if (max != null && n.getKey() >= max) {
            return false; // for checking the right side
        }
        if (min != null && n.getKey() <= min) { // for checking the right side
            return false;
        }
        return isValidBST(n.left, n.getKey(), min) && isValidBST(n.right, max, n.getKey());
    }


    /**
     * This function is built from 3 function
     * the complexity is O(n).
     * Explanation:
     *     we are going over the whole tree and checking for every leaf if the path is the same as every one.
     *     we need to check the whole tree, that why it can be O(n).
     *     we can also have the regular tree that looks like a linked list where all the node on one node (left or right)
     *
     * Let explain each function:
     * 1. getting a binary tree and returning the help function on that starts from the root of the tree.
     * 2. the function gets a node, and checking the black height, if we got to a null we are returning true, this is a leaf.
     *    and here we are counting the 'Nil' leaves like in Red-Black tree, that we are counting leaves as black nodes
     *    Leead told as to write it if we are counting them.
     *    if the black height for the left subtree is different from the right subtree --> return false
     *    then the recursive function on each subtree, and the 'And' logic gate between them. that if they are not equal,
     *    we'll return false. and if they are equal we will return true.
     *    In that way it will go up in the recursive function up till the nodes, and in the wrapping function, till the root
     *
     * 3. This function is actually works like a regular height function for binary tree.
     *    But!1 here the condition for incrementing the height is if the node is also BLACK.
     *    here we decided the BLACK = true, RED = false.
     *    And in the recursive call we are checking it for each subtree, and returning the max between the subtrees, each time,
     *    like a regular height function for binary tree.
     */

    // Ex1.2
    public static boolean hasValidHeight(BinaryTree tree) { // O(n)
        return hasValidHeightHelp(tree.getRoot());
    }

    public static boolean hasValidHeightHelp(Node node) {
        if (node == null) {
            return true;
        }
        if (blackHeight(node.getLeft()) != blackHeight(node.getRight())) {
            return false;
        }
        return hasValidHeightHelp(node.getLeft()) && hasValidHeightHelp(node.getRight());
    }

    public static int blackHeight(Node n) { // O(n)
        if (n == null) {
            return 0;
        }
        if (n.isColor() == BLACK) {
            return Math.max(blackHeight(n.getLeft()), blackHeight(n.getRight())) + 1;
        }
        return Math.max(blackHeight(n.getLeft()), blackHeight(n.getRight()));
    }

}
