import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex3Test {

    @Test
    public void testValidHeight() {
        BinaryTree tree = new BinaryTree();

        // Create a valid red-black tree
        Node root = new Node(7, true);
        Node node1 = new Node(3, false);
        Node node2 = new Node(10, false);
        Node node3 = new Node(1, true);
        Node node4 = new Node(5, true);
        Node node5 = new Node(8, true);
        Node node6 = new Node(12, true);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        //tree.getRoot() = root;

        assertTrue(Ex3.countBlackNodes(root,0)!=-1);
    }

    @Test
    public void testInvalidHeight() {
        BinaryTree tree = new BinaryTree();

        // Create an invalid red-black tree
        Node root = new Node(7, true);
        Node node1 = new Node(3, false);
        Node node2 = new Node(10, false);
        Node node3 = new Node(1, true);
        Node node4 = new Node(5, true);
        Node node5 = new Node(8, true);
        Node node6 = new Node(12, true);
        Node node7 = new Node(15, true);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node6.right = node7;

       // tree.getRoot() = root;

        assertFalse(Ex3.countBlackNodes(root,0)!=-1);
    }
}

