package LinkedList;
class NodeSingle<T> {
	T data;
	NodeSingle<T> next;
	public NodeSingle(T data, NodeSingle<T> next){
		this.data = data;
		this.next = next;
	} 
	
	public String toString(){
		return ""+this.data;
	}
}

public class LinkedListSingle<T> {
	NodeSingle<T> head, tail;
	private int size;
	// Constructor,  constructs an empty list
	public LinkedListSingle(){
		head = null;
		tail = null;
		size = 0;
	} 
	// Removes all of the elements from this list.
	public void clear(){
		while (head != null){
			head = head.next;
		}
		size = 0;
	} 
	// Returns the number of elements in this list.
	public int size(){
		return size;
	} 
	// Appends the specified element to the end of this list. 
	public void add(T obj){
		if (head == null)
			head = tail = new NodeSingle<T>(obj, null);
		else{
			NodeSingle<T> n = new NodeSingle<T>(obj, null);
			tail.next = n;
			tail = n;
		}
		size++;
	} 
	// Removes the first occurrence of the specified element
	// from this list, if it is present. 
	public T remove(T obj){
		T ans = null;
		// empty list
		if (head == null){
			ans = null;
		}
		// remove the first element (head)
		else if (head.data.equals(obj)){
			ans = head.data;
			head = head.next;
		}
		// remove the mid or the last element 
		else{
			NodeSingle<T> prev = head, follow = head;
			while(follow.next != null && !follow.data.equals(obj)){
				prev = follow;
				follow = follow.next;
			}
			/// remove the last element (tail)
			if (follow.next == null && follow.data.equals(obj)){
				ans = tail.data;
				prev.next = null;
				tail = prev;
				size--;
			}
			// remove the mid item
			else if (follow.next != null){
				ans = follow.data;
				prev.next = follow.next;
				size--;
			}
			// element not found
			else{
				ans = null;
			}
		}
		return ans;
	}
	// Returns true if this list contains the specified element
	public boolean contains(T obj){
		boolean ans = true;
		NodeSingle<T> follow = head;
		while (follow != null && !follow.data.equals(obj)){
			follow = follow.next;
		}
		if (follow == null) ans = false;
		return ans;
	}
	//
	public String toString(){
		String s = "[";
		for (NodeSingle<T> follow=head; follow != null; follow=follow.next){
			s = s + follow.toString()+", ";
		}
		return s+"]";
	}
