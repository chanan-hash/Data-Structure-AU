public class BinaryTree {

    Node root;
    int size;

    public BinaryTree() {
        root = null;
        size = 0;
    }


    public Node getRoot(){
        return this.root;
    }
    public void insert(Integer data) {
        boolean flag = false;
        Node node = root;
        if (root == null) {
            root = new Node(data);
            flag = true;
        }
        while (!flag) {
            double select = Math.random();
            System.out.printf("%5.2f  ", select);
            if (select < 0.5) {
                if (node.left == null) {
                    node.left = new Node(data,false);
                    flag = true;
                }
                node = node.left;
            } else {// select >= 0.5
                if (node.right == null) {
                    node.right = new Node(data,true);
                    flag = true;
                }
                node = node.right;
            }

        }
    }
}
