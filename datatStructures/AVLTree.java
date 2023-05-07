public class AVLTree {
    private AVlNode root;

    // The rotation functions are O(1), because they aren't recursive, they have a lot of conditions but they are O(1)

    // The left rotation
    private AVlNode rotateLeft(AVlNode a) { // O(1)
        AVlNode b = a.right; // Node b that will be 'a' right Node
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
    private AVlNode rotateRight(AVlNode a) { // O(1)
        AVlNode b = a.left;
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
    public int height(AVlNode p) { // O(1)
        if (p == null) {
            return -1;
        }
        int hLeft = p.left != null ? p.left.height : -1;
        int hRight = p.right != null ? p.right.height : -1;
        p.height = 1 + (hLeft > hRight ? hLeft : hRight);
        return p.height;
    }


    // A method that updating the balance of the tree nodes
    private void setBalance(AVlNode... nodes) {
        for (AVlNode n : nodes) {
            n.balance = height(n.right) - height(n.left);
        }
    }

    private AVlNode rotateLeftThanRight(AVlNode n) {
        n.left = rotateLeft(n.left);
        return rotateRight(n);
    }

    private AVlNode rotateRightThanLeft(AVlNode n) {
        n.left = rotateRight(n.left);
        return rotateLeft(n);
    }


    private void rebalance(AVlNode n) { //O(log(n))
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
}
