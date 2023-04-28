public class BinaryTree<T> {

    private BTNode<T> root; // rott htat as left and right options for node
    int size;

    // constructor --> creating a new tree
    public BinaryTree() { // initializing every thing to null
        root = null;
        size = 0;
    }


    public boolean contians(T obj, BTNode p) { // we can wrap it and make it that it gets only the object to checkd
        boolean ans = false;
        if (p != null) {
            ans = (obj == root) || contians(obj, p.left) || contians(obj, p.right); // recursion move
        }
        return ans;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public int height(BTNode p) {
        int h = 0;
        if (p != null) {
            int leftHeight = height(p.left);
            int rightHeight = height(p.right);
            h = Math.max(leftHeight, rightHeight) + 1;
            // ans = (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
        }
        return h;
    }

    // counting the num of nodes in the tree
    public int nodesNum() {
        return nodesNum(root) - 1;
    }

    public int nodesNum(BTNode node) {
        int ans = 1;
        if (node == null) {
            ans = 1;
        } else {
            ans = nodesNum(node.left) + nodesNum(node.right);
        }
        return ans;
    }


    // recursive add
    // wrapping function
    public void add(T obj) {
        root = add(obj, root);
    }

    // when we are adding new element we are actually creating a new subTree
    public BTNode add(T data, BTNode node) {
        if (node != null) { // means while we have steal where to go on the tree and search for a new place that is empty
            // --> without lef or right or both child
            double random = Math.random(); // n < 0.5 going left, n > 0.5 going right, for each recursion different number
            if ((random < 0.5)) { // to keep the tree kind of balanced
                node.left = add(data, node.left); // the recursion
                return node;
            } else { // going right
                node.right = add(data, node.right);
                return node;
            }
        }
        // we've got to a place that is null, so we will create a new subTree
        else {
            size++; // found where to put it, and now incrementing the size
            return new BTNode(data);
        }
    }

    // Iterative implementation for add
    public void insert(T val) {
        boolean flag = false;
        BTNode node = root; // starting fom the beginning of the tree
        if (root == null) { // creating a new tree
            root = new BTNode(val);
            size++;
            flag = true;
        }
        while (!flag) { // if we've got here so flag = false, !flag = true.
            double r = Math.random(); // randomly choosing a number between 0 to 1, for each iteration
            if (r < 0.5) {
                if (node.left == null) {
                    node.left = new BTNode<T>(val);
                    size++;
                    flag = true;
                }
                node = node.left; // moving to the left
            } else { // r >= 0.5
                if (node.right == null) {
                    node.right = new BTNode(val);
                    size++;
                    flag = true;
                }
                node = node.right; // continue to the right
            }
        } // while we didn't find place the !flag will be true, and the loop will continue,
        // when we've added an element the flag will be true and !flag = false, and we'll go put of the loop
    }
}
