import java.util.Random;

public class Elizabet_BT {

    // Node
    private class BTNode {
        Object data;
        BTNode left, right;
        boolean color;

        BTNode(Object data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public String toString() {
            return "" + data;
        }

        public Object getData() {
            return this.data;
        }
        public boolean getColor(){
            return this.color;
        }
    }

    // Binary Tree
    private static Random generator = new Random(19580427);
    BTNode root;

    // constructors
    public Elizabet_BT() {
        root = null;
    }

    //////// add a new node - loop
    public void insert(Object data) {
        boolean flag = false;
        BTNode node = root;
        if (root == null) {
            root = new BTNode(data);
            flag = true;
        }
        while (!flag) {
            double select = generator.nextDouble();
            System.out.printf("%5.2f  ", select);
            if (select < 0.5) {
                if (node.left == null) {
                    node.left = new BTNode(data);
                    flag = true;
                }
                node = node.left;
            } else {// select >= 0.5
                if (node.right == null) {
                    node.right = new BTNode(data);
                    flag = true;
                }
                node = node.right;
            }

        }
    }

    //////// add a new node - recursion
    public void add(Object data) {
        root = add(data, root);
    }

    public BTNode add(Object data, BTNode node) {
        if (node != null) {
            double select = generator.nextDouble();
            System.out.printf("%5.2f  ", select);
            if (select < 0.5) {
                node.left = add(data, node.left);
                return node;
            } else {
                node.right = add(data, node.right);
                return node;
            }
        } else {
            return new BTNode(data);
        }
    }

    /////////
    public boolean contains(Object data) {
        return contains(data, root);
    }

    public boolean contains(Object data, BTNode node) {
        boolean ans = false;
        if (node == null) {
            ans = false;
        } else {
            ans = node.data.equals(data) || contains(data, node.left) || contains(data, node.right);
        }
        return ans;
    }

    /////////
    public boolean isEmpty() {
        return this.root == null;
    }

    //////////
    public int height() {
        return height(root) - 1;
    }

    public int height(BTNode node) {
        int ans = 0;
        if (node != null) {
            int hLeft = height(node.left);
            int hRight = height(node.right);
            ans = (hLeft > hRight ? hLeft : hRight) + 1;
        }
        //else ans = Math.max(height(node.left), height(node.right)) + 1;
        return ans;
    }

    public int numOfNodes() {
        return numOfNodes(root) - 1;
    }

    public int numOfNodes(BTNode node) {
        int ans = 1;
        if (node == null) ans = 1;
        else ans = numOfNodes(node.left) + numOfNodes(node.right);
        return ans;
    }

    // print all tree nodes
    // PreOrder
    public void printPreOrder() {
        printPreOrder(root);
        System.out.println();
    }

    void printPreOrder(BTNode node) {//PreOrder
        if (node != null) {
            System.out.print(node.data + ", ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    public void printPreorderPlus() {
        printPreorderPlus("", root);
    }

    public void printPreorderPlus(String Path, BTNode node) {
        if (node != null) {
            System.out.println(node.data + ": " + Path);
            printPreorderPlus(Path + "L", node.left);
            printPreorderPlus(Path + "R", node.right);
        }
    }

    // InOrder
    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    void printInOrder(BTNode node) {//PreOrder
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + ", ");
            printInOrder(node.right);
        }
    }

    // PostOrder
    public void printPostOrder() {
        printPostOrder(root);
        System.out.println();
    }

    void printPostOrder(BTNode node) {//PreOrder
        if (node != null) {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.data + ", ");
        }
    }

    // From assignment 3
    public boolean isValidBST(BTNode root, Integer max, Integer min) {

        // an empty binary trees is a valid BST.
        if (root == null) {
            return true;
        }

        // in the recursion when we go each to left or subtree it will check thew condition of the definition of
        if (max != null && (Integer) root.getData() >= max) {
            return false; // for checking the lef side
        }

        if (min != null && (Integer) root.getData() <= min) { // for checking the right side
            return false;
        }

        return isValidBST(root.left, (Integer) root.getData(), min) &&
                isValidBST(root.right, max, (Integer) root.getData());
    }

    public boolean hasValidHeight() {
        if (root == null) {
            return true;
        }
        return countBlackNodes(root, 0) != -1;
    }

    // Helper method to count the number of black nodes in each path
    private int countBlackNodes(BTNode node, int blackCount) {
        if (node == null) {
            return blackCount;
        }

        if (!node.getColor() == false) { // means it is black node
            blackCount++;
        }

        int leftCount = countBlackNodes(node.left, blackCount);
        int rightCount = countBlackNodes(node.right, blackCount);

        if (node.left != null && node.right != null && leftCount != rightCount) {
            return -1; // means the black path are different one of each other
        }

        return Math.max(leftCount, rightCount);
    }


    public static void main(String[] args) {
        Elizabet_BT bt = new Elizabet_BT();
        int nodes[] = {19, 22, 38, 65, 78, 79, 90, 5, 55};
        for (int i = 0; i < nodes.length; i++) {
            //bt.add(nodes[i]);
            bt.insert(nodes[i]);
            System.out.println(nodes[i]);
        }
        System.out.println("by pre-order");
        bt.printPreOrder();
        System.out.println();
        System.out.println("by pre-order-plus");
        bt.printPreorderPlus();
        System.out.println();
        System.out.println("by in-order");
        bt.printInOrder();
        System.out.println("by post-order");
        bt.printPostOrder();
        System.out.println("height: " + bt.height());
        System.out.println("number of nodes: " + bt.numOfNodes());

        System.out.println("\n" + bt.isValidBST(bt.root, null, null));
        System.out.println(bt.hasValidHeight());
    }
}
/*19
 0.02  22
 0.27   0.29  38
 0.23   0.52  65
 0.26   0.44   0.25  78
 0.00   0.52   0.48  79
 0.69  90
 0.77   0.25  5
 0.12   0.68   0.92  55
by pre-order
19, 22, 38, 78, 65, 79, 55, 90, 5,

by pre-order-plus
19:
22: L
38: LL
78: LLL
65: LR
79: LRL
55: LRR
90: R
5: RL

by in-order
78, 38, 22, 79, 65, 55, 19, 5, 90,
by post-order
78, 38, 79, 55, 65, 22, 5, 90, 19,
heught: 4
number of nodes: 9

 *
 */


