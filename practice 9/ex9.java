public class ex9 {


    public static void main(String[] args) {

    }

    private class Node {
        int data;
        Node left, right, parent;

        public Node(int num) {
            this.data = num;
            left = right = null;
        }

        public Node(int num, Node left, Node right) {
            this.data = num;
            this.left = left;
            this.right = right;
        }
    }

    public class BT{

    }
    // Ex1
    //
    /* preorder:
     *      tree1. 3,1,14,5,4,7,16,15,20
     *      tree2. F,B,A,D,C,E,G,I,H
     *      tree3. F.B,A,C,F,E,G
     *
     * inorder:
     *      tree1 = 1,3,3,4,7,14,15,16,20
     *      tree2 = A,B,C,D,E,F,G.H.I
     *      tree3 = A,B,C,D,E,F,G
     *
     * postorder:
     *      tree1 --> 1,4,7,5,15,20,16,14,3
     *      tree2 --> A,C,E,D,B,H,I,G,F
     *      tree3 --> A,C,B,E,G,F,D
     */
}
