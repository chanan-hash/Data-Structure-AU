public class Ex3 {
    public static void main(String[] args) {

    }
    public static boolean isValidBST(BinaryTree tree){
        return isValidBST(tree.getRoot(), null, null);
    }

    public static boolean hasValidHeight(BinaryTree tree){
        return false;
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

}
