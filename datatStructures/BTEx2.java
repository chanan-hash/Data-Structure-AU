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
    private BTNode root;
    private int size;

    //constructors

    public BTEx2() {
        root = null;
        size = 0;
    }

    // Removing a whole range in constant tome
    // O(1), because in the worst case we will go till the end of the range, it is O(10)
    public BTNode removeRange(Double range) {
        if (root == null) { // means there is no tree, it's empty
            return null;
        }
        else { // we will go to the till we'll find the range and change the nodes

        }
    }

    // O(1), the most way we can
    public void add(Double dl) {

    }

}
