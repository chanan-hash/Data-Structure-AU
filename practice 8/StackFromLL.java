public class StackFromLL {
    /**
     * Implementing stack from LL by ourselves
     * Ex2
     */
    NodeNum head, tail;
    int size;

    public StackFromLL() {
        head = tail = null;
        size = 0;
    }

    public boolean push(Integer value) {
        if (head == null) {
            head = new NodeNum(value);
        } else {
            head = new NodeNum(value, head); // adding at the end of the list, so that the pop will be in O(1)
            size++;
//            NodeNum temp = new NodeNum(val);
//            temp.next = head;
//            head = temp;
        }
        return true;
    }

    public Integer pop() { // because of that we added at the first of the list, because than we had to go over the whole list till tail, and keep it's node, and delete it
        Integer ans = null;
        if (head == null) {
            return null; // list is empty
        } else {
            ans = head.num;
            head = head.next;
            size--;
        }
        return ans;
    }

    public Integer peek() {
        return head.num; // Not removing the element, just showing
    }

    public Integer tail() {
        return tail.num;
    }


    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        while (head != null) {
            head = head.next;
        }
        size = 0;
    }
}
