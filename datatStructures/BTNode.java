public class BTNode<T> {
    T data;

     BTNode left, right; // instead of Node next, in linked list

    // new
    public BTNode(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BTNode(T newDate, BTNode leftN, BTNode rightN){
        this.data = newDate;
        this.left = leftN;
        this.right = rightN;
    }


    // Getters and Setters

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BTNode getLeft() {
        return left;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public BTNode getRight() {
        return right;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }


}
