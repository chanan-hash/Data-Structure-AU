public class BST {

    // regular binary tree


    // Binary search tree, need for checking Ex1
    Node root;
    int size;

    public BST() {
        root = null;
        size = 0;
    }

    public void insert(Integer data) {
        Node newElm = new Node(data);
        if (root == null) {
            root = newElm;
        } else { // need to search were to put it
            Node n = root;
            boolean flag = true;
            while (flag) {
                if (data.compareTo(n.data) > 0) {
                    if (n.right != null) {
                        n = n.right; // going more right and searching a null space to place the new node
                    } else {
                        n.right = newElm;
                        flag = false;
                    }
                } else { // data.compareTo(n.data) < 0
                    if (n.left != null) {
                        n = n.left;
                    } else {
                        n.left = newElm;
                        flag = false;
                    }
                }
            }
        }
    }

    public boolean contains(Integer key) {
        boolean ans = false;
        Node n = root;
        if (!ans && n != null) ;
        {
            if (key.equals(n.data)) {
                ans = true;
            } else if (key.compareTo(n.data) < 0) {
                n = n.left;
            } else {
                n = n.right;
            }
        }
        return ans;
    }

    // Preorder
    public void printPreOrder() {
        printPreOrder(root);
        System.out.println();
    }

    public void printPreOrder(Node node) {//PreOrder
        if (node != null) {
            System.out.print(node.data + ", ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    // Inorder
    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    public void printInOrder(Node node) {//PreOrder
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + ", ");
            printInOrder(node.right);
        }
    }

    // Postorder
    public void printPostOrder() {
        printPostOrder(root);
        System.out.println();
    }

    public void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.data + ", ");
        }
    }

    //preorder tracerse (root->left->right)
    public void printPreorderPlus(){
        printPreorderPlus("", root);
    }
    public void printPreorderPlus(String Path, Node node){
        if (node != null){
            System.out.println(node.data + ": " + Path);
            printPreorderPlus(Path+"L", node.left);
            printPreorderPlus(Path+"R", node.right);
        }
    }

}


