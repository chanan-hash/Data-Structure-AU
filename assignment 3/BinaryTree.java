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
     * There are 2 way do it:
     * 1. put the whole tree in Arraylist by inorder, because One of the binary tree qualities is that inorder we will get it sorted.
     * then we can go over the array and check if it sorted, if not return false
     *
     * 2.
     */
    public boolean isValidBST(){
        if(root == null){
            return false; // the tree is empty
        }
        else if (!(root.left.getKey().compareTo(root.getKey()) < 0 && root.right.getKey().compareTo(root.getKey()) > 0 )){

        }
        boolean ans = true;
        return ans;
    }

    public boolean isBlackHeight(){
        boolean ans = true;
        return ans;
    }

    // adding a binary tree to array list inorder, when we are creating the tree we also create an array list,
    // and adding it like printing inorder, just instead of printing list.add(value)
    /*
    import java.util.ArrayList;

    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public class BinaryTreeToList {
        Node root;
        ArrayList<Integer> list;

        public BinaryTreeToList() {
            root = null;
            list = new ArrayList<>();
        }

        private void inOrderTraversal(Node node) {
            if (node == null)
                return;

            inOrderTraversal(node.left);
            list.add(node.data);
            inOrderTraversal(node.right);
        }

        public void convertToList() {
            inOrderTraversal(root);
        }

        public static void main(String[] args) {
            BinaryTreeToList tree = new BinaryTreeToList();
            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left = new Node(4);
            tree.root.left.right = new Node(5);

            tree.convertToList();
            System.out.println("Binary Tree converted to ArrayList: " + tree.list);
        }
    }
*/

}
