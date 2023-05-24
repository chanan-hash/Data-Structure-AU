import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex3Test {
    static final boolean RED = false;
    static final boolean BLACK = true;

    @Test
    public void testValidHeight() {
        BinaryTree tree = new BinaryTree();

        // Create a valid red-black tree
        // Create an invalid red-black tree
        Node root = new Node(7, BLACK);
        Node node1 = new Node(3, RED);
        Node node2 = new Node(10, RED);
        Node node3 = new Node(1, BLACK);
        Node node4 = new Node(5, BLACK);
        Node node5 = new Node(8, BLACK);
        Node node6 = new Node(12, BLACK);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        //tree.getRoot() = root;

        assertTrue(Ex3.hasValidHeight1(root));
    }

    @Test
    public void testInvalidHeight() {
        BinaryTree tree = new BinaryTree();

        // Create an invalid red-black tree
        Node root = new Node(7, BLACK);
        Node node1 = new Node(3, RED);
        Node node2 = new Node(10, RED);
        Node node3 = new Node(1, BLACK);
        Node node4 = new Node(5, BLACK);
        Node node5 = new Node(8, BLACK);
        Node node6 = new Node(12, BLACK);
        Node node7 = new Node(15, BLACK);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node6.right = node7;

        assertFalse(Ex3.hasValidHeight1(root));
    }


    // need to be checked again
    @Test
    public void testValidHeight2() {

        Node root = new Node(10, BLACK);
        root.left = new Node(5, BLACK);
        root.right = new Node(15, BLACK);
        root.left.left = new Node(2, RED);
        root.left.left.left = new Node(1, BLACK);
        root.left.right = new Node(7, RED);
        root.right.left = new Node(13, RED);
        root.right.left.right = new Node(14, BLACK);
        root.right.right = new Node(21, RED);
        root.left.right.left = new Node(6, BLACK);
        root.right.right.right = new Node(22, BLACK);

        assertFalse(Ex3.hasValidHeight1(root));
    }


    @Test
    public void testValidHeight3() {
        Node roo3 = new Node(7, RED);
        roo3.left = new Node(4, BLACK);
        roo3.right = new Node(8, BLACK);
        roo3.left.left = new Node(5, BLACK);
        roo3.right.right = new Node(9, BLACK);
        roo3.left.right = new Node(2, RED);
        roo3.right.left = new Node(1, RED);
        roo3.left.left.left = new Node(6, RED);
        roo3.right.right.right = new Node(43, RED);
        roo3.left.left.right = new Node(36, RED);
        roo3.left.right.left = new Node(48, BLACK);
        roo3.right.right.left = new Node(21, RED);
        roo3.right.left.left = new Node(22, BLACK);
        roo3.right.left.right = new Node(24, BLACK);

        assertFalse(Ex3.hasValidHeight1(roo3));
    }

    @Test
    public void testValidHeight4() {
        Node roo = new Node(7, RED);
        roo.left = new Node(4, BLACK);
        roo.right = new Node(8, BLACK);
        roo.left.left = new Node(5, BLACK);
        roo.right.right = new Node(9, BLACK);
        roo.left.right = new Node(2, BLACK);
        roo.right.left = new Node(1, BLACK);
        roo.left.left.left = new Node(6, RED);
        roo.right.right.right = new Node(43, RED);
        roo.left.left.right = new Node(36, RED);
//        roo.left.right.left = new Node(48, BLACK);
        roo.right.right.left = new Node(21, RED);
//        roo.right.left.left = new Node(22, BLACK);
//        roo.right.left.right = new Node(24, BLACK);

        assertTrue(Ex3.hasValidHeight1(roo));
    }

    @Test
    public void testValidHeight5() {

        Node root4 = new Node(43, BLACK);
        root4.left = new Node(3, RED);
        root4.right = new Node(645, BLACK);
        root4.left.left = new Node(2, BLACK);
        root4.right.right = new Node(2342, RED);
        root4.right.left = new Node(324, RED);
        root4.left.right = new Node(24, BLACK);
        root4.left.right.right = new Node(40, RED);
        root4.left.right.left = new Node(4, RED);

        assertTrue(Ex3.isValidBST(root4, null, null));
        assertTrue(Ex3.hasValidHeight1(root4));
    }


    @Test
    public void testValidHeight6() {
        Node root5 = new Node(13, BLACK);
        // left subTree
        root5.left = new Node(8, RED);
        root5.left.left = new Node(1, BLACK);
        root5.left.right = new Node(11, BLACK);
        root5.left.left.right = new Node(6, RED);

        // right subTree
        root5.right = new Node(17, RED);
        root5.right.left = new Node(15, BLACK);
        root5.right.right = new Node(25, BLACK);
        root5.right.right.left = new Node(22, RED);
        root5.right.right.right = new Node(27, RED);

        assertTrue(Ex3.isValidBST(root5, null, null));
        assertTrue(Ex3.hasValidHeight1(root5));

    }

    @Test
   void testValidHeight7(){
        Node root7 = new Node(8,BLACK);
        root7.left = new Node(7,RED);
        root7.right = new Node(58,BLACK);
        root7.left.left = new Node(34,BLACK);

        assertFalse(Ex3.hasValidHeight1(root7));
    }

}

