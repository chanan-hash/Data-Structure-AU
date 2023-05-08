public class AVLNode {
    Integer key;
    int balance, height;
    AVLNode left, right, parent;

    public AVLNode(Integer key, AVLNode parent){
        this.key = key;
        this.parent = parent;
        left = right = null;
        height = 0;
    }

    @Override
    public String toString() {
        return "key: " + this.key;
    }
}
