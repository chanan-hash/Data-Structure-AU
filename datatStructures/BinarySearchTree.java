public class BinarySearchTree<T> {
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

    /**
     * In removing an element from search tree we have 4 cases to deal with
     * <p>
     * 1. The element was not found, we no things to delete
     * 2. The element has no children is a leaf we need just to set it as a null
     * 3. The element has only one child, is internal node --> we need to delete it and put his child instead of him
     * 4. The element has two children so we cant just replace on of them instead, because that transformation can cause problems
     * in the sort down the tree. So we will want to move instead of the deleted element,
     * another element that will be bigger from the subRightTree, and smaller than the subLeftTree.
     * That element is or:
     * a. the smallest element on the subRightTree
     * b. the biggest element on the subLeftTree
     */

    public NodeSearch remove(NodeSearch p, Integer item) { // O(log(n))
        if (p != null) {
            if (item.compareTo(p.number) > 0) { // go right
                p.right = remove(p.right, item); // recursion
            } else if (item.compareTo(p.number) < 0) { // going left
                p.left = remove(p.left, item);
            } else { // the node we want to delete was not found, case (1)
                if (p.left == null && p.right == null) { // the node is a leaf, case (2)
                    p = null;
                } else if (p.left != null && p.right == null) { // case (3), has only left child
                    p = p.left; // going more left
                } else if (p.left == null && p.right != null) { // has only right child
                    p = p.right; // going more right
                } else { // has two children
                    if (p.right.left == null) { // his right node has only one child (right)
                        p.right.left = p.left;
                        p = p.right;
                    } else { // removing the smallest element
                        NodeSearch n = p.right;
                        while (p.left.left != null) {
                            p = p.left; // moving on the left side
                        }
                        n.number = p.left.number;
                        p.left = p.left.right;
                    }
                }
            }
        }
        return p;
    }

    public boolean search(Integer element) {
        boolean ans = false;
        NodeSearch node = root;
        while (!ans && node != null) { // O(n)
            if (element.equals(node.number)) {
                ans = true;
            } else if (element.compareTo(node.number) < 0) { // going left side
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return ans;
    }

    public void printPreorderPlus() {
        printPreorderPlus("", root);
    }

    public void printPreorderPlus(String Path, NodeSearch node) {
        if (node != null) {
            System.out.println(node.number + ": " + Path);
            printPreorderPlus(Path + "L", node.left);
            printPreorderPlus(Path + "R", node.right);
        }
    }

    // if the tree is empty returns true
    public boolean isEmpty() {
        return this.root == null;
    }

    public int height() {
        return height(root) - 1;
    }

    public int height(NodeSearch tree) {
        if (tree == null) return 0;
        return 1 + Math.max(height(tree.left), height(tree.right));
    }


    public NodeSearch findNodeSuccessor(NodeSearch x) { // O(log(n))
        if (x == null) {
            return treeMax(root);
        }
        if (x.right != null) { // case 2
            return treeMin(x.right); // O(log(n))
        }
        // need to add boolean flag to work
        NodeSearch y = x.parent; // case 3
        while (y != null && x == y.right) { // going backward as till the right number
            x = y;
            y = x.parent;
        }
        return y;
    }

    NodeSearch treeMin(NodeSearch x) { // going to the most left area --> O(log(n))
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    NodeSearch treeMax(NodeSearch y) { // going to the most right area --> O(log(n))
        while (y.right != null) {
            y = y.right;
        }
        return y;
    }

    public NodeSearch findNodePredecessor(NodeSearch x) { // O(log(n))
        if (x == null) {
            return treeMin(root);
        }
        if (x.left != null) {
            return treeMax(x.left);
        }
        NodeSearch y = x.parent;
        while (y != null && x == y.left) {
            x = y;
            y = x.parent;
        }
        return y;
    }
}
