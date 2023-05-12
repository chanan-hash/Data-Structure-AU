public class ex9 {
    public static void main(String[] args) {
            BST tree1 = new BST();
            BST tree2 = new BST();
            BST tree3 = new BST();

            tree1.insert(3);
            tree1.insert(14);
            tree1.insert(1);
            tree1.insert(5);
            tree1.insert(4);
            tree1.insert(7);
            tree1.insert(16);
            tree1.insert(15);
            tree1.insert(20);

            tree1.printPreOrder();
            tree1.printInOrder();
            tree1.printPostOrder();
            tree1.printPreorderPlus();
        }
        // Ex1
        //
        /* preorder:
         *      tree1. 3,1,14,5,4,7,16,15,20
         *      tree2. F,B,A,D,C,E,G,I,H
         *      tree3. F.B,A,C,F,E,G
         *
         * inorder:
         *      tree1 = 1,3,4,5,7,14,15,16,20
         *      tree2 = A,B,C,D,E,F,G.H.I
         *      tree3 = A,B,C,D,E,F,G
         *
         * postorder:
         *      tree1 --> 1,4,7,5,15,20,16,14,3
         *      tree2 --> A,C,E,D,B,H,I,G,F
         *      tree3 --> A,C,B,E,G,F,D
         */

    }

