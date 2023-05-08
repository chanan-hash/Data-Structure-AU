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

    public String remove(String str) { //O(n)
        String ans = null;
        if (head == null) { // empty list
            return null;
        } else if (head.data.equals(str)) { // removing the head
            ans = head.data;
            head = head.next; // and the head node will be thrown to the garbage collector
        } else {
            SortedNode prev = head, n = head; // One running One step, and the second with One before him
            while (n.next != null && !n.data.equals(str) && n.data.compareTo(str) < 0) { //means we didn't fount the element, and it is not equal to the data, and also still small
                prev = n;
                n = n.next;
            }
            if (n.data.equals(str)) {
                ans = n.data;
                prev.next = n.next; // skipping on 'n' node and throwing it to thw garbage collector
                size--;
            }
        }
        return ans;
    }


    public String toString() {
        String s = "[";
        if (head != null) {
            s = s + head.toString() + ", ";
            for (SortedNode n = head.next; n != null; n = n.next) {
                s = s + n.toString() + ", ";
            }
            s = s.substring(0, s.length() - 2); // to take of some of the spaces
        }
        return s + "]";
    }


    public static void main(String[] args) {
        SortedLinkedList list = new SortedLinkedList();
        list.add("f");
        list.add("t");
        list.add("d");
        list.add("m");
        list.add("b");
        list.add("u");
        System.out.println("list: " + list);

        System.out.println("a: " + list.contains("a"));
        System.out.println("b: " + list.contains("b"));
        System.out.println("t: " + list.contains("t"));
        System.out.println("m: " + list.contains("m"));
        System.out.println("remove x: " + list.remove("x"));
        System.out.println(list);
        System.out.println("remove b: " + list.remove("b"));
        System.out.println(list);
        System.out.println("remove m: " + list.remove("m"));
        System.out.println(list);
        System.out.println("remove t: " + list.remove("t"));
        System.out.println(list);
        System.out.println("remove d: " + list.remove("d"));
        System.out.println(list);
        System.out.println("remove f: " + list.remove("f"));
        System.out.println(list);
        System.out.println("remove d: " + list.remove("d"));
        System.out.println(list);
    }
}


