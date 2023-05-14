public class BinaryTree {

    /**
     * This binary tree is representing Red-Black Tree.
     * This  tree is first a binary search tree and each node has also an argument of color (boolean, red = 1, black = 0,
     * that helps maintain the tree with it functions
     * of complexity of O(log(n))
     */
    private Node root;
    int size;

    public BinaryTree(){
        root = null;
        size = 0;
    }

    /**
     * This function is checking if the tree is a binary search tree, means:
     * We are going to check if the left son is smaller than the parent,
     * and if the right son is bigger than his parent.
     *
     * complexity:
     * Usually to check if a BT is a search tree, it can take O(n), if the tree only on it's left (or right) side.
     * we need to go over the whole tree and check it, so The complexity is O(n).
     *
     */
    public boolean isBST(){
        boolean ans = true;
        return ans;
    }

    public boolean isBlackHeigh(){
        boolean ans = true;
        return ans;
    }

}
