package linkedlist;

class NodeSorted {
	String data;
	NodeSorted next;
	NodeSorted(String data, NodeSorted next){
		this.data = data;
		this.next = next;
	} 
	public String toString(){
		return this.data;
	}
}

public class LinkedListSorted {
	private NodeSorted head;
	private int size;
	// Constructor,  constructs an empty list
	public LinkedListSorted(){
		head = null;
		size = 0;
	}
	// Appends the specified element to this list.
	public void add(String str){// O(N)
		if (head == null)	head = new NodeSorted(str, null);
		//str<head.data, new node->head
		else if (str.compareTo(head.data) < 0){
			head = new NodeSorted(str, head);
		}
		else{
			// find place
			NodeSorted n = head.next, prev = head;
			while(n!=null && n.data.compareTo(str) < 0){
				prev = n;
				n=n.next;
			}
			prev.next = new NodeSorted(str, n);
		}
		size++;
	}
	// Returns true if this list contains the specified element
	public boolean contains(String str){// O(N)
		boolean ans = true;
		NodeSorted n = head;
		while (n != null && !n.data.equals(str) && n.data.compareTo(str)<0){
			n = n.next;
		}
		if (n == null || n.data.compareTo(str)>0) ans = false;
		return ans;
	}
	// Removes the first occurrence of the specified element
	// from this list, if it is present. 
	public String remove(String str){// O(N)
		String ans = null;
		// empty list
		if (head == null) ans = null;
		// remove the first element (head)
		else if (head.data.equals(str)){
			ans = head.data;
			head = head.next;
		}
		// remove the mid or the last element 
		else{
			NodeSorted prev = head, n = head;
			while(n.next != null && !n.data.equals(str) && n.data.compareTo(str)<0){
				prev = n;
				n = n.next;
			}
			/// remove the element
			if (n.data.equals(str)){
				ans = n.data;
				prev.next = n.next;
				size--;
			}
		}
		return ans;
	}

	public String toString(){
		String s = "[";
		if (head != null){
			s = s + head.toString() + ", ";
			for (NodeSorted n = head.next; n != null; n=n.next){
				s = s + n.toString() + ", ";
			}
			s = s.substring(0, s.length()-2);
		}
		return s+"]";
	}

	public static void main(String[] args) {
		LinkedListSorted list = new LinkedListSorted();
		list.add("f");
		list.add("t");
		list.add("d");
		list.add("m");
		list.add("b");
		list.add("u");
		System.out.println("list: "+list);

		System.out.println("a: "+list.contains("a"));
		System.out.println("b: "+list.contains("b"));
		System.out.println("t: "+list.contains("t"));
		System.out.println("m: "+list.contains("m"));
		System.out.println("remove x: "+list.remove("x"));
		System.out.println(list);
		System.out.println("remove b: "+list.remove("b"));
		System.out.println(list);
		System.out.println("remove m: "+list.remove("m"));
		System.out.println(list);
		System.out.println("remove t: "+list.remove("t"));
		System.out.println(list);
		System.out.println("remove d: "+list.remove("d"));
		System.out.println(list);
		System.out.println("remove f: "+list.remove("f"));
		System.out.println(list);
		System.out.println("remove d: "+list.remove("d"));
		System.out.println(list);
	}
}
