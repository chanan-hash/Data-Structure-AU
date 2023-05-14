public class Elizabet_BST {
    // Node class
    public class Node {
        Integer data;
        Node left, right;

        public Node(Integer newData) {
            data = newData;
            left = null;
            right = null;
        }

        public Node(Integer data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return "data: " + data + " ";
        }

        public Integer getData() {
            return this.data;
        }
    }

    private Node root;

    public Elizabet_BST() {
        root = null;
    }

    // copy constructor
    public Elizabet_BST(Elizabet_BST bst) {
        this.root = clone(bst.root);
    }

    Node clone(final Node source) {
        if (source == null) return null;
        else
            return new Node(source.data, clone(source.left), clone(source.right));
    }

    // insert new element
    public void insert(Integer elem) {
        Node newNode = new Node(elem);
        if (root == null) {
            root = newNode;
        } else {
            Node n = root;
            boolean flag = true;
            while (flag) {
                if (elem.compareTo(n.data) > 0) {
                    if (n.right != null) n = n.right;
                    else {
                        n.right = newNode;
                        flag = false;
                    }
                } else {
                    if (n.left != null) n = n.left;
                    else {
                        n.left = newNode;
                        flag = false;
                        ;
                    }
                }
            }
        }
    }

    //remove the element from the tree
    public void remove(Integer elem) {
        root = remove(root, elem);
    }

    public static Node remove(Node node, Integer elem) {
        if (node != null) {
            if (elem.compareTo(node.data) > 0) {
                node.right = remove(node.right, elem);
            } else if (elem.compareTo(node.data) < 0) {
                node.left = remove(node.left, elem);
            } else {//the node that should be deleted is found
                if (node.left == null && node.right == null) {
                    node = null;
                } else if (node.left != null && node.right == null) {//the node has only one child (left)
                    node = node.left;
                } else if (node.right != null && node.left == null) {//the node has only one child (right)
                    node = node.right;
                } else {//node "tree" has two children
                    if (node.right.left == null) {// his right node has only one child (right)
                        node.right.left = node.left;
                        node = node.right;
                    } else {// remove the smallest element
                        Node p = node.right;
                        while (p.left.left != null)
                            p = p.left;
                        node.data = p.left.data;
                        p.left = p.left.right;
                    }
                }
            }
        }
        return node;
    }

    // find element, returns true if the element is found
    public boolean search(Integer elem) {
        boolean ans = false;
        Node n = root;
        while (n != null) {
            if (elem == n.data) ans = true;
            else if (elem < n.data) n = n.left;
            else n = n.right;
        }
        return ans;
    }

    //preorder tracerse (root->left->right)
    public void printPreorderPlus() {
        printPreorderPlus("", root);
    }

    public void printPreorderPlus(String Path, Node node) {
        if (node != null) {
            System.out.println(node.data + ": " + Path);
            printPreorderPlus(Path + "L", node.left);
            printPreorderPlus(Path + "R", node.right);
        }
    }

    // if the tree is empty returns true
    public boolean isEmpty() {
        return this.root == null;
    }

    // the height of the tree
    public int height() {
        return height(root) - 1;
    }

    public int height(Node tree) {
        if (tree == null) return 0;
        return 1 + Math.max(height(tree.left), height(tree.right));
    }

    //From assignment3
    public boolean isValidBST(Node root, Integer max, Integer min) {

        // an empty binary trees is a valid BST.
        if (root == null) {
            return true;
        }

        // in the recursion when we go each to left or subtree it will check thew condition of the definition of
        if (max != null && root.getData() >= max) {
            return false; // for checking the lef side
        }

        if (min != null && root.getData() <= min) { // for checking the right side
            return false;
        }

        return isValidBST(root.left, root.getData(), min) &&
                isValidBST(root.right, max, root.getData());
    }

    public static void main(String[] args) {
        Elizabet_BST tree = new Elizabet_BST();
        tree.insert(10);
        tree.insert(8);
        tree.insert(3);
        tree.insert(5);
        tree.insert(4);
        tree.insert(11);
        tree.insert(14);
        tree.insert(12);

        System.out.println(tree.isValidBST(tree.root,null,null));

    }

}

