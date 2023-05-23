import java.util.ArrayList;

import java.util.Arrays;

public class Ex3 {

    public static void main(String[] args) {
        Node root3 = new Node(5);
        root3.left = new Node(7);
        root3.right = new Node(10);
        System.out.println(isValidBST(root3));

    }


    //    private static int[] ans;
    private static ArrayList<Integer> highs;
//    private static int i=0;

    public static boolean isValidBST(BinaryTree tree) {
        return isValidBST(tree.getRoot());
    }

    public static boolean hasValidHeight(BinaryTree tree) {
//        int high = treeHigh(tree);
//        double maxNumOfLeaves = Math.pow(2, high);
//        ans = new int[(int) maxNumOfLeaves];
//        Arrays.fill(ans, -1);
        highs = new ArrayList<>();
        int counter = 0;
        countBlack(tree.getRoot(), counter);

//        for (int j = 0; j < ans.length; j++) {
//            if(ans[j]==-1){break;}
//            if(ans[j]!=ans[j-1]){return false;}
//        }

        for (int j = 0; j < highs.size() - 1; j++) {
            if (highs.get(j) != highs.get(j + 1)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isValidBST(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.getKey() > root.getKey()) {
            return false;
        }
        if (root.right != null && root.right.getKey() < root.getKey()) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    public static void countBlack(Node node, int counter) {
        if (node == null) {
            return;
        }

        if (isLeaf(node)) {
            if (!isRed(node)) {
                counter++;
//                ans[i++]=counter;
                highs.add(counter);
                counter--;
            } else {
//                ans[i++]=counter;
                highs.add(counter);
            }
            return;
        }

        if (!isRed(node)) {
            counter++;
            countBlack(node.left, counter);
            countBlack(node.right, counter);
            counter--;
        } else {
            countBlack(node.left, counter);
            countBlack(node.right, counter);
        }
    }

//    public static int treeHigh(BinaryTree bt) {
//        return treeHigh(bt.root());
//    }
//
//    public static int treeHigh(Node node) {
//        if (node == null) {
//            return 0;
//        }
//        return 1 + Math.max(treeHigh(node.left), treeHigh(node.right));
//    }

    public static boolean isRed(Node node) {
        return node.getColor();
    }
}
