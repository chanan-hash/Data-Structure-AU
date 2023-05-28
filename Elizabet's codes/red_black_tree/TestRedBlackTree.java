package red_black_tree;

public class TestRedBlackTree {
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        // 4 , 7 , 12 , 15 , 3 , 5 , 14 , 18 , 16 , 17
        rbt.insert(4);
        rbt.insert(7);
        rbt.insert(12);
        rbt.insert(15);
        rbt.insert(3);
        rbt.insert(5);
        rbt.insert(14);
        rbt.insert(18);
        rbt.insert(16);
        rbt.insert(17);
        rbt.printPreorderPlus();
    }
}
