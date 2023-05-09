public class MySortedLinkedList {
    private NodeNum head, tail;
    int size = 0;


    // Creating new list
    public MySortedLinkedList() {
        head = null;
        size = 0;
    }

    // Q(1) adding in sorted way
    public void add(Integer val) {
        if (head == null) {
            head = new NodeNum(val);
        } else if (val.compareTo(head.num) < 0) { // adding at the beginning
//            NodeNum temp = new NodeNum(val);
//            temp.next = head;
//            head = temp;
            head = new NodeNum(val, head); //Creating a node before the head, the will point on the previous head
        } else if (val.compareTo(tail.num) > 0) {// putting it at the end
            tail.next = new NodeNum(val);
        } else { // need to run and find the right place to put it
            NodeNum p = head, n = head.next;
            while (n != null && n.num.compareTo(val) < 0) { // while it is still small and not null
                p = n;
                n = n.next;
            }
            p.next = new NodeNum(val, n);
        }
        size++;
    }

    public Integer remove(Integer key) {
        Integer res = null;
        if (head == null) {
            return null;
        } else if (head.num.equals(key)) {
            res = head.num;
            head = head.next;
            size--;
        } else {
            NodeNum p = head, n = head;
            while (n != null && !n.num.equals(key) && n.num.compareTo(key) < 0) {
                p = n;
                n = n.next;
            }
            if (n.num.equals(key)) {
                res = n.num;
                p.next = n.next; // skipping on 'n' node, and pointing on the next nodes
                size--;
            }
        }
        return res;
    }

    /* Eyal's levi solution
    * https://github.com/LeviEyal/DataStructuresCourse/blob/master/leead_exsercises/src/%D7%AA%D7%99%D7%A8%D7%92%D7%95%D7%9C%D7%99%D7%9D/MyLinkedList.java

   public class MyLinkedList {

    class Node {
        private int key;
        private Node next;

        public Node(int key){
            this.key = key;
            this.next = null;
        }

    }

    private Node head, tail;
    private int size = 0;

    public MyLinkedList(){
        head = tail = null;
    }

//______________________________________________________
    //Question 1:
    public void add(int key){
        Node newNode = new Node(key);
        if(head == null)
            head = tail = newNode;
        else if(key < head.key){
            newNode.next = head;
            head = newNode;
        }
        else if(key > tail.key){
            tail.next = newNode;
            tail = newNode;
        }
        else{
            for(Node p=head; p.next!=null ; p=p.next){
                if(key<p.next.key){
                    newNode.next = p.next;
                    p.next = newNode;
                    break;
                }
            }
        }
        size++;
    }

     */

}
