public class BTEx2<Double> {
    /**
     * This class represent the approximate sort according to Ex4 on assignment 2 on DS course
     * <p>
     * The sort is going according to the range [i,i+1)
     * For this input, this is count sorted:
     * input: 2.8, 3.1, 2.2, 4.1, 3.2
     * <p>
     * sorted:
     * 2.2, 2.8, 3.1, 3.2, 4.1
     * but also this is sorted:
     * 2.8, 2.2 3.2, 3.1, 4.1
     * <p>
     * This is not sorted:
     * 2.8, 4.1, 2.2 3.2, 3.1
     * <p>
     * The order inside the range is not important, but the order between the ranges is important
     * <p>
     * For this we will use A binary tree data-structure, that is based on he idea binary search tree, but with a slight difference
     * <p>
     * The right children of the tree will be the range representors, and every left child will be a number inside the range
     */


    // Date
    private BTNode<Double> root;
    private int size;

    //constructors

    public BTEx2() {
        root = null;
        size = 0;
    }

    // Removing a whole range in constant tome
    // O(1), because in the worst case we will go till the end of the range, it is O(10)
    public void removeRange(Double range) {
        if (root == null) { // means there is no tree, it's empty
            System.out.println("The tree is empty"); //return null;
        } else { // we will go to the till we'll find the range and change the nodes
            BTNode p = root;
            BTNode n = null; // one that runs one step before p
            for (p = root; p != null; n = p, p = p.right) {
                if ((int) p.data == (int) range) {
                    n = p.right;
                    p = null;
                }
            }
            if (p == null) { // means we haven't found the range
                System.out.println("The range is not exists");
            }
        }

    }

    // O(1), the most way we can go it is O(10)
    // will go over the right sons and find the right range if it exists, and add it at the beginning
    public void add(Double dl) {
        if (root == null) {
            root = new BTNode<>(dl);
        } else { // going on the right side of the tree and trying to find the ragne
            BTNode p = root;
            while (p!=null && (int)p.data < (int)p.right.data){
                p = p.right;
            }
            if(p!=null){
                addNode(p,dl); // fount where to put it
            }
            // need to take care on if this in the middle
        }
    }

    // adding a value on the range on the left side of a given node
    public void addNode(BTNode range, Double d) {
        BTNode newNode = new BTNode(d);
        BTNode temp = range.left;
        range.left = newNode;
        newNode.left = temp;
    }

    // we will find the range if exits than, and printing the elements
    // O(n) --> the size of the range
    public void printRange(Double range) {
        BTNode p = root;
        while (p != null && (int) p.data != (int) range) { // O(10)--> O(1)
            p = p.right;
        }

        if (p != null) { // if we've found the range
            String str = "";
            str += p.data;
            for (p = p; p != null; p = p.left) { // running on the left side --> means the range
                str += ", " + p.data;
            }
            System.out.println(str);
        } else {
            System.out.println("Range wasn't found");
        }
    }

    // running on the right side of the tree and counting how many ranges we have
    //O(10) --> O(1)
    public int countRanges() {
        int count = 0;
        if (root == null) { // the tree has no range
            return 0;
        } else {
            for (BTNode p = root; p != null; p = p.right) {
                count++;
            }
        }
        return count;
    }


    public void printPreOrder() {
        printPreOrder(root);
        System.out.println();
    }

    // parent --> left --> right
    public void printPreOrder(BTNode<Double> p) {
        if (p != null) {
            System.out.println(p.data + ", ");
            printPreOrder(p.left); // moving left
            printPreOrder(p.right); // moving right after we have finished lefts
        }
    }

}
