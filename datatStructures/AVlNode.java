public class AVlNode {
    Integer key;
    int balance, height;
    AVlNode left, right, parent;

    public AVlNode(Integer key, AVlNode parent){
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
