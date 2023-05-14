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

    // O(n), because we can have the kisted tree, all the elements on one side (right or left).
    public boolean search(Integer elem) {
        boolean ans = false;
        Node n = root;
        while (n != null) {
            if (elem == n.data) {
                ans = true;
            } else if (elem < n.data) {
                n = n.left;
            } else {
                n = n.right;
            }
        }
        return ans;
    }

    // Ex5
    // was contributed from Eyal's levi github
    // https://github.com/LeviEyal/DataStructuresCourse/blob/master/leead_exsercises/src/%D7%AA%D7%99%D7%A8%D7%92%D7%95%D7%9C%D7%99%D7%9D/BinaryTree.java
    // wrapping function
    public Node find(Integer data) {
        return find(data, root);
    }

    // recursive finding the node of the value
    // O(n), but it is not using the qualities of binary search tree
    public Node find(Integer key, Node p) {
        if (p == null) {
            return null;
        }
        if (p.data.equals(key)) {
            return p;
        }
        Node left = find(key, p.left);
        Node right = find(key, p.right);
        if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null; // didn't find ot at all
        }
    }

    public int numNodes() {
        return numNodes(root);
    }

    // Ex4
    public int numNodes(Node n) {
        if (n == null) {
            return 0; // empty tree
        }
        return 1 + numNodes(n.right) + numNodes(n.left);
    }

    // Ex6
    public String isLeaf(Integer data) {
        // first we need to find the object and then to check it's Node
        Node found = find(data);
        if (found == null) {
            return "Not a vertex";
        } else if (found.left == null && found.right == null) {
            return "A leaf";
        } else {
            return "Not a leaf";
        }
    }

    // Ex3
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

    // Ex2
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


    //preorder traverse (root->left->right)
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

}


