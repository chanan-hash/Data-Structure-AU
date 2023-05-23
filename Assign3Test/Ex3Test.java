import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex3Test {
    static boolean RED = false, Black = true;

    @Test
    void isBSTTest() {

        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);


        // null problem
        Node root2 = new Node(10);
        root2.left = new Node(5);
        root2.right = new Node(15);
        root2.left.left = new Node(2);
        root2.left.left.left = new Node(1);
        root2.left.right = new Node(7);
        root2.right.left = new Node(13);
        root2.right.left.right = new Node(14);
        root2.right.right = new Node(21);

        assertTrue(Ex3.isValidBST(root));

        assertTrue(Ex3.isValidBST(root2));

        Node root3 = new Node(5);
        root3.left = new Node(7);
        root3.right = new Node(10);

        assertFalse(Ex3.isValidBST(root3));
    }

//    @Test
//    void isRedBlack() {
//
//        BinaryTree tree = new BinaryTree();
//        tree.insert(8);
//        tree.insert(5);
//        tree.insert(10);
//
//        assertTrue(Ex3.hasValidHeight(tree));
//    }

}