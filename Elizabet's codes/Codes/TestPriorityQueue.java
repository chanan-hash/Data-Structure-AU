package Heap;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class TestPriorityQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**The head of this queue is the least element with respect to the specified ordering.
		 * Implementation note: this implementation provides O(log(n)) time 
		 * for the enqueing and dequeing methods (offer, poll, remove() and add); 
		 * linear time for the remove(Object) and contains(Object) methods; 
		 * and constant time for the retrieval methods (peek, element, and size). 
		 * Note that this implementation is not synchronized. 
		**/
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(2);
		pq.add(8);
		pq.add(1);
		pq.add(5);
		while(!pq.isEmpty()){
			System.out.print(pq.poll()+", ");
		}
		System.out.println();
		/**Multiple threads should not access a PriorityQueue instance concurrently 
		 * if any of the threads modifies the queue. Instead, use the thread-safe PriorityBlockingQueue class. 		
		 */
		PriorityBlockingQueue<Integer> pbq = new PriorityBlockingQueue<Integer>();
		pbq.add(3);
		pbq.add(5);
		pbq.add(4);
		pbq.add(1);
		while(!pbq.isEmpty()){
			System.out.print(pbq.poll()+", ");
		}
		System.out.println();
	}

}
