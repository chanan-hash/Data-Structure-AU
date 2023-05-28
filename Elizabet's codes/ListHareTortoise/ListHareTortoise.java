package linkedlist;
public class ListHareTortoise {
	//Finding the Loop in a Circular Linked List
	public static boolean hasLoop(NodeSingle<Integer> head){
		if (head == null) return false;
		NodeSingle<Integer> fast = head.next, slow = head;
		boolean ans = true;
		while (ans){
			if (fast==null || slow==null || fast.next==null)
				return false;
			if (fast==slow) {
				System.out.println("has loop - slow: "+slow.data+", fast: "+fast.data);
				return true;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		return ans;
	}
	//Finding the Start of a Loop in a Circular Linked List
	public static NodeSingle<Integer> findLoopStart(NodeSingle<Integer> head){
		if (head == null) return null;
		NodeSingle<Integer> fast = head.next, slow = head;
		boolean ans = false;
		while (!ans){
			if (fast==null || slow==null || fast.next==null) break;
			if (fast==slow) ans = true; // here ans = true
			fast = fast.next.next;
			slow = slow.next;
		}
		if (ans) {
			System.out.println("loop start - slow: "+slow.data+", fast: "+fast.data);
			// the circle exists, the fast moves to the start point
			// the slow remains in the meeting point
			fast = head;
			while (fast != slow) {
				fast = fast.next;
				slow = slow.next;
			}
			return fast;
		}
		return null;
	}
	//Finding the Length of a Loop in a Circular Linked List
	public static int findLoopLength(NodeSingle<Integer> head){
		NodeSingle<Integer> meetingPoint = findLoopStart(head);
		if (meetingPoint != null){
			int loopLength = 1;
			NodeSingle<Integer> fast = meetingPoint.next, slow = meetingPoint;
			while(fast != slow){
				loopLength++;
				fast = fast.next;
			}
			return loopLength;
		}
		return -1;
	}

	public static void main(String[] args) {
		LinkedListSingle<Integer> list = new LinkedListSingle<Integer>();
		for (int i=1; i<=6; i++) {
			list.add(i);			
		}
		System.out.println(hasLoop(list.head));//false
		list.tail.next = list.head.next;
		//list.tail.next = list.head;
		//list.tail.next = list.head.next.next;
		System.out.println(hasLoop(list.head)); // true
		System.out.println("loop start: "+findLoopStart(list.head).data);
		System.out.println("loop length: "+findLoopLength(list.head));
		
	}

}
