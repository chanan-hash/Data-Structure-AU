public class AVLTree {
    private AVLNode root;

    // The rotation functions are O(1), because they aren't recursive, they have a lot of conditions but they are O(1)

    // The left rotation
    private AVLNode rotateLeft(AVLNode a) { // O(1)
        AVLNode b = a.right; // Node b that will be 'a' right Node
        b.parent = a.parent; // tha seam parent
        a.right = b.left; // we help to the switch

        if (a.right != null) {
            a.right.parent = a;
            b.left = a;
            a.parent = b;
        }
        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = a;
            }
        }
        setBalance(a, b);
        return b;
    }

    // Rotating the tree to the right
    private AVLNode rotateRight(AVLNode a) { // O(1)
        AVLNode b = a.left;
        b.parent = a.parent;
        a.left = b.right;
        if (a.left != null) {
            a.left.parent = a;
        }
        b.right = a;
        a.parent = b;
        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }
        setBalance(a, b);
        return b;
    }


    // A method for updating the height of the tree
    // Helping for checking the balance condition of the tree
    public int height(AVLNode p) { // O(1)
        if (p == null) {
            return -1;
        }
        int hLeft = p.left != null ? p.left.height : -1;
        int hRight = p.right != null ? p.right.height : -1;
        p.height = 1 + (hLeft > hRight ? hLeft : hRight);
        return p.height;
    }


    // A method that updating the balance of the tree nodes
    private void setBalance(AVLNode... nodes) {
        for (AVLNode n : nodes) {
            n.balance = height(n.right) - height(n.left);
        }
    }

    private AVLNode rotateLeftThanRight(AVLNode n) {
        n.left = rotateLeft(n.left);
        return rotateRight(n);
    }

    private AVLNode rotateRightThanLeft(AVLNode n) {
        n.left = rotateRight(n.left);
        return rotateLeft(n);
    }


    private void rebalance(AVLNode n) { //O(log(n))
        setBalance(n); // checking the balance factor of the Node
        if (n.balance == -2) {
            if (height(n.left.left) >= height(n.left.right)) {
                n = rotateRight(n); // rotation to the right
            } else {
                n = rotateLeftThanRight(n);
            }
        } else if (n.balance == 2) {
            if (height(n.right.right) >= height(n.right.left)) {
                n = rotateLeft(n);
            } else {
                n = rotateRightThanLeft(n);
            }
        }
        if (n.parent != null) {
            rebalance(n.parent);
        } else {
            root = n;
        }
    }


    public boolean insert(Integer key) { // O(log(n))
        if (root == null) {
            root = new AVLNode(key, null);
        } else {
            AVLNode n = root, parent;
            boolean flag = true;
            while (flag) {
                if (n.key == key) {
                    return false;
                }
                parent = n;
                boolean goLeft = n.key > key;
                n = goLeft ? n.left : n.right;
                if (n == null) {
                    if (goLeft) {
                        parent.left = new AVLNode(key, parent);
                    } else {
                        parent.right = new AVLNode(key, parent);
                    }
                    rebalance(parent);
                }
                flag = false;
            }
        }
        return true;
    }


    public void delete(Integer delkey) {
        if (root == null) {
            return;
        }
        AVLNode n = root, delNode = null;
        AVLNode child = root, parent = root;
        while (child != null) {
            parent = n;
            n = child;
            child = delkey >= n.key ? n.right : n.left;
            if (delkey == n.key) {
                n = delNode;
            }
            if (delNode != null) {
                delNode.key = n.key;
                child = n.left != null ? n.left : n.right;
                if (root.key == delkey) {
                    root = child;
                } else {
                    if (parent.left == n) {
                        parent.left = child;
                    } else {
                        parent.right = child;
                    }
                    rebalance(parent);
                }
            }
        }
    }

    public int height() {
        return height(root);
    }

    public int size() {
        return size(root);
    }

    public int size(AVLNode n) {
        int ans = 0;
        if (n != null) {
            ans = size(n.left) + size(n.right) + 1;
        }
        return ans;
    }

    public void printBalance() {
        printBalance(root);
        System.out.println();
    }

    private void printBalance(AVLNode n) {
        if (n != null) {
            printBalance(n.left);
            System.out.printf("%d ", n.balance);
            printBalance(n.right);
        }
    }

    public void printPreorderPlus() {
        printPreorderPlus("", root);
    }

    public void printPreorderPlus(String Path, AVLNode node) {
        if (node != null) {
            System.out.println(node.key + ": " + Path);
            printPreorderPlus(Path + "L", node.left);
            printPreorderPlus(Path + "R", node.right);
        }
    }

    public static void testAVL() {

        AVLTree tree = new AVLTree();


        //Integer[] a = {1,6,13,24,21,16,11,12};
        Integer[] a = {1, 2, 3, 4};
        //Integer[] a = {1,2,3,4,5,6,7,8,9};
        //Integer[] a = {10,5,20,15,40,80,30};
        System.out.println("Inserting values");
        for (int i = 0; i < a.length; i++) {
            tree.insert(a[i]);
        }
        tree.printPreorderPlus();
        System.out.println();

        System.out.println("size = " + tree.size());
        System.out.print("Printing balance: ");
        tree.printBalance();
        System.out.println("tree height: " + tree.height());
        System.out.println("delete 4");
        tree.delete(4);
        tree.printBalance();
        tree.printPreorderPlus();
        System.out.println("delete 1");
        tree.delete(1);
        tree.printBalance();
        tree.printPreorderPlus();
        System.out.println("delete 2");
        tree.delete(2);
        tree.printBalance();
        tree.printPreorderPlus();
        System.out.println("delete 3");
        tree.delete(3);
        tree.printBalance();
        tree.printPreorderPlus();
        System.out.println("delete 4");
        tree.delete(4);
        tree.printBalance();
        tree.printPreorderPlus();
    }

    public static void testExam_2016SbMAa() {
        AVLTree tree = new AVLTree();
        Integer[] a = {10, 5, 20, 15, 40, 80, 30};
        System.out.println("Inserting values");
        for (int i = 0; i < a.length; i++)
            tree.insert(a[i]);
        System.out.print("Printing balance: ");
        tree.printBalance();
        tree.printPreorderPlus();
        System.out.println("\ndelete 20");
        tree.delete(20);
        tree.printPreorderPlus();
        System.out.println("\ndelete 10");
        tree.delete(10);
        tree.printPreorderPlus();
        System.out.println("\ndelete 15");
        tree.delete(15);
        tree.printPreorderPlus();
        System.out.println("\ndelete 10");
        tree.delete(10);
        tree.printPreorderPlus();
        System.out.println("\ndelete 40");
        tree.delete(40);
        tree.printPreorderPlus();
        System.out.println("\ndelete 20");
        tree.delete(20);
        tree.printPreorderPlus();
        System.out.println("\ndelete 80");
        tree.delete(80);
        System.out.println("size = " + tree.size());
        tree.printPreorderPlus();
        System.out.println("\ndelete 30");
        tree.delete(30);
        System.out.println("size = " + tree.size());
        tree.printPreorderPlus();
        System.out.println("\ndelete 5");
        tree.delete(5);
        System.out.println("size = " + tree.size());
        tree.printPreorderPlus();
        System.out.println("\ndelete 5");
        tree.delete(5);
        System.out.println("size = " + tree.size());
        tree.printPreorderPlus();
    }

    public static void main(String[] args) {
        testExam_2016SbMAa();
        //testAVL();
    }
}
/*
Inserting values
Printing balance: 0 0 0 0 0 0 0
20:
10: L
5: LL
15: LR
40: R
30: RL
80: RR

delete 20
30:
10: L
5: LL
15: LR
40: R
80: RR

delete 10
30:
15: L
5: LL
40: R
80: RR

delete 15
30:
5: L
40: R
80: RR

delete 10
30:
5: L
40: R
80: RR

delete 40
30:
5: L
80: R

delete 20
30:
5: L
80: R

delete 80
size = 2
30:
5: L

delete 30
size = 1
5:

delete 5
size = 0

delete 5
size = 0
*/



