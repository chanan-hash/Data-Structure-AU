public class SortedLinkedList {

    private SortedNode head;
    private int size;

    // initializing a new list
    public SortedLinkedList() {
        head = null;
        size = 0;
    }

    // need to keep the linked list sorted
    public void add(String str) {
        if (head == null) {
            head = new SortedNode(str); // creating a new list
        } else if (str.compareTo(head.data) < 0) { // if the object is smaller than the head
            head = new SortedNode(str, head);
        } else { // need to search where to put the right object, according to the comparison
            SortedNode n = head.next, prev = head;
            while (n != null && n.data.compareTo(str) < 0) { // O(n), while it it is still small we want to keep moving to the right pkace
                prev = n;
                n = n.next;
            }
            prev.next = new SortedNode(str, n); // putting it in the right place, and connecting it to the next object by Node 'n'
            // prev = new SortedNode(str,prev.next);
        }
        size++;
    }

    public boolean contains(String str) {
        for (SortedNode n = head; n != null; n = n.next) {
            if (n.data.equals(str)) { // n.data.compareTo(str) == 0;
                return true;
            }
        }
        return false; // didn't find it
    }

    // Elizabet's method for it
    // Returns true if this list contains the specified element
    public boolean contains2(String str) {// O(N)
        boolean ans = true;
        SortedNode n = head;
        while (n != null && !n.data.equals(str) && n.data.compareTo(str) < 0) { // moving till the right place
            n = n.next;
        }
        if (n == null || n.data.compareTo(str) > 0) {
            ans = false;  // checking if we got to the place and the object is bigger, means the specified element is not in the list
        }
        return ans;
    }

    public String remove(String str){ //O(n)

    }



    public String toString(){
        String s = "[";
        if (head != null){
            s = s + head.toString() + ", ";
            for (SortedNode n = head.next; n != null; n=n.next){
                s = s + n.toString() + ", ";
            }
            s = s.substring(0, s.length()-2); // to take of some of the spaces
        }
        return s+"]";
    }

}
