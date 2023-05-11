import com.sun.source.tree.BinaryTree;

import java.util.LinkedList;

public class ex8 {
    public static void main(String[] args) {
        LinkedList<Integer> class1 = new LinkedList<>();
        LinkedList<Integer> class2 = new LinkedList<>();
        class1.add(26);
        class1.add(59);
        class1.add(83);
        class1.add(92);
        class1.add(94);

        class2.add(34);
        class2.add(76);
        class2.add(92);
        class2.add(99);
        class2.add(100);

        LinkedList<Integer> sortedGrades = mergeList(class1, class2);
        System.out.println(sortedGrades.toString());

    }

    //Ex4
    // similar to merge function of mergesort
    public static LinkedList<Integer> mergeList(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> l3 = new LinkedList<>();
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) <= l2.get(j)) { // ONe of the condition of the inequality
                if (!l2.contains(l1.get(i))) { // splitting the condition because we want to increment the i or j, if it contains
                    l3.add(l1.get(i));
                }
                i++;
            } else if (l1.get(i) > l2.get(j)) {
                if (!l1.contains(l2.get(j))) {
                    l3.add(l2.get(j++));
                }
                j++;
            }
        }
        while (i < l1.size()) { // if l1.size > l2.size
            if (!l2.contains(l1.get(i))) { // adding here again the condition
                l3.add(l1.get(i));
            }
            i++;
        }
        while (j < l2.size()) { // if l1.size < l2.size
            if (!l1.contains(l2.get(j))) {
                l3.add(l2.get(j));
            }
            j++;
        }
        return l3;
    }

 /*
 This answer is based on the classes we have built, the sorted linked list, each time when it's adding it keeps it sorted
 // Form Eyal's levi github
 //https://github.com/LeviEyal/DataStructuresCourse/blob/master/leead_exsercises/src/%D7%AA%D7%99%D7%A8%D7%92%D7%95%D7%9C%D7%99%D7%9D/ex8.java
 //Question 4:
    public static MyLinkedList q4(GenericLinkedList<Integer> c1, GenericLinkedList<Integer> c2) {
        MyLinkedList sorted = new MyLinkedList();
        for(int i=0; i<c1.size(); i++){
            int t = c1.get(i);
            if(c2.search(t) == null)
                sorted.add(t);
        }
        for(int i=0; i<c2.size(); i++){
            int t = c2.get(i);
            if(c1.search(t) == null)
                sorted.add(t);
        }
        return sorted;
    }
 */

    // Ex7
    public static <T> void treverse_rec(LinkedList l) {
        LinkedList<T> l_rec = new LinkedList<>();
        reverse_rec(l, l_rec);
        l.addAll(l_rec);
    }

    public static <T> void reverse_rec(LinkedList l1, LinkedList l2) {
        if (l1.isEmpty()) {
            return;
        }
        l2.add(l1.removeLast());
        reverse_rec(l1, l2);
    }


    // Ex8
    public static boolean isSymetric(LinkedList l) {
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i) != l.get(l.size() - i)) {
                return false;
            }
        }
        return true;
    }

    // Another way for it
    /*
    //Question 8:   O(n)
    public static <T> boolean q8(GenericLinkedList<T> t){
        int h = t.size()-1, l=0;
        while(l<h){
            if(t.get(l++) != t.get(h--))
                return false;
        }
        return true;
    }
    */

    

}
