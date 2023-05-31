public class BinomialHeap {
    /**
     * Binomial heap is built from Binomial trees, which are keep the quality if minheap/maxheap
     * means: every Node value is smaller than it's children (minheap, max is the opposite)
     */

    public class Node {
        Integer key;
        Node parent, child, sibling; // the child node, is the most left node of the children
        private int degree;

        public Node(Integer key) {
            this.key = key;
            parent = child = sibling = null;
        }
    }

    private Node head;

    public BinomialHeap() { // O(1) building a new
        head = null;
    }

    public Integer findMin() { // log(n)
        if (head == null) {
            return null;
        } else {
            Node min = head;
            Node next = min.sibling;
            while (next != null) {
                if (next.key.compareTo(min.key) < 0) { // mens that the next node of the roots is smaller the the current One
                    min = next;
                }
                next = next.sibling;
            }
            return min.key;
        }
    }

    // Merge two binomial trees of the same order
    // r1.key > r2.key
    public void linkTrees(Node r1, Node r2) { // O(1)
        r1.parent = r2;
        r1.sibling = r2.child;
        r2.child = r1;
        r2.degree++;
    }

    // The idea is to build a new binomial tree with one Node, and merge it to the current binomialHeap
    public BinomialHeap binomialHeapInsert(BinomialHeap H, Integer key) { //O(log2n)
        Node x = new Node(key);
        BinomialHeap H1 = new BinomialHeap();
        x.parent = null;
        x.child = null;
        x.sibling = null;
        x.degree = 0;
        H1.head = x;
        linkTrees(H.head, H1.head);
        return H;
    }

    public void binomialHeapDecreaseKey(BinomialHeap H, Node x, Integer k) { // O(log2n)
        if (k > x.key) {
            System.out.println("error: new key is greater than");
        }
        x.key = k;
        Node y = x;
        Node z = x.parent;

        while (z != null && y.key < z.key) {
            swapKey(y.key, z.key);//swap  y.key ↔z.key
            y = z;
            z = y.parent;
        }
    }

    public void swapKey(Integer k1, Integer k2) {
        Integer temp = k1;
        k1 = k2;
        k2 = temp;
    }

    public void binomialHeapDelete(BinomialHeap H,Node x){ // O(log2n)
        binomialHeapDecreaseKey(H, x, Integer.MIN_VALUE); // O(log2n)
       // binomialHeapExtractMin(H) // O(log2n) --> need to build
    }
}
