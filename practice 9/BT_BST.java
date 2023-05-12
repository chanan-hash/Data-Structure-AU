public class BT_BST {

    public class Node {
        Integer data;
        Node left, right, parent;

        public Node(Integer num) {
            this.data = num;
            left = right = null;
        }

        public Node(Integer num, Node left, Node right) {
            this.data = num;
            this.left = left;
            this.right = right;
        }
    }

    // regular binary tree
    public class BT {

    }

    // Binary search tree, need for checking Ex1
    public class BST {
        Node root;
        int size;

        public BST() {
            root = null;
            size = 0;
        }

        public void insert(Integer data) {
            if (root == null) {
                root = new Node(data);
            } else { // need to search were to put it
                Node n = root;
                boolean flag = true;
                Node newElm = new Node(data);
                while (!flag) {
                    if (data.compareTo(n.data) > 0) {
                        if (n.right != null) {
                            n = n.right; // going more right and searching a null space to place the new node
                        } else {
                            n.right = newElm;
                            flag = flag;
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
                printPreOrder(node.left);
                System.out.print(node.data + ", ");
                printPreOrder(node.right);
            }
        }

        // Postorder
        public void printPostOrder() {
            printInOrder(root);
            System.out.println();
        }

        public void printPostOrder(Node node) {//PreOrder
            if (node != null) {
                printPreOrder(node.left);
                printPreOrder(node.right);
                System.out.print(node.data + ", ");
            }
        }
    }

}
