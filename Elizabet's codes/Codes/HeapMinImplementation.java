package Heap;

import java.util.Arrays;

public class HeapMinImplementation {

	int _positiveInfinity = Integer.MAX_VALUE;
	private int _a[];
	private int _size;
	public HeapMinImplementation(int arr[]){
		_size = arr.length;
		_a = new int[_size];
		for (int i=0; i<_size; i++){
			_a[i]=arr[i];
		}
	}
	/** returns the heap size*/
	public int getSize(){return _size;}
	/** returns the heap array */
	public int[] getA(){ return _a;}

	/** parent returns the parent of vertex  i*/
	private  int parent(int i){return (i-1)/2;}

	/** leftChild returns the left child of vertex  i*/
	private  int leftChild(int i){return 2*i+1;}
	/** rightChild returns the right child of vertex  i*/
	private  int rightChild(int i){return 2*i+2;}
	/** returns the heap minimum */
	public int heapMinimum(){return _a[0];}
	/** returns true if the heap is empty, otherwise false */
	public boolean isEmpty(){
		boolean ans = false;
		if (_size == 0) ans = true;
		return ans;
	}
	/** the minHeapfy function maintains the min-heap property */
	private void minHeapify(int v, int heapSize){
		int smallest;
		int left = leftChild(v);
		int right = rightChild(v);
		if (left<heapSize && _a[left]<_a[v]){
			smallest = left;
		}
		else{
			smallest = v;
		}
		if (right<heapSize && _a[right]<_a[smallest]){
			smallest = right;
		}
		if (smallest!=v){
			exchange(v, smallest);
			minHeapify(smallest, heapSize);
		}		
	}
	/** building a min-heap from arbitrary array of Nodes*/
	public void buildMinHeap(){
		for (int i=_size/2-1; i>=0; i--){
			minHeapify(i, _size);
		}
	}
	/** the heap sort algorithm */
	public void heapSort(){
		buildMinHeap();
		print();
		int heapSize = _size;
		for (int i=heapSize-1; i>=1; i--){
			exchange(0, i);
			heapSize = heapSize - 1;
			minHeapify(0, heapSize);
		}
	}	
	/** the heap minimum element extraction */
	public int heapExtractMin(){
		int node=_positiveInfinity;// infinity
		if (!isEmpty()){
			node = _a[0];
			_a[0]=_a[_size-1];
			_size = _size-1;
			minHeapify(0, _size);
		}
		return node;
	}
	/** the heapDecreaseKey implements the Decrease Key operation*/
	private void heapDecreaseKey(int i, int key){
		if (key <=_a[i]){
			_a[i] = key;
			while (i>0 && _a[parent(i)]>_a[i]){
				exchange(i, parent(i));
				i = parent(i);
			}
		}
	}
	/** minHeapInsert function implements the Insert-Key operation*/
	public void minHeapInsert(int key){
		resize(1);
		_a[_size-1] = _positiveInfinity;
		heapDecreaseKey(_size-1, key);
	}
	/** increment an array*/
	private void resize(int increment){
		int temp[] = new int[_size+increment];
		for (int i=0; i<_size; i++){
			temp[i]=_a[i];
		}
		_a = temp;
		_size = _size+increment;
	}	
	/** exchange two array elements*/
	private void exchange(int i, int j){
		int t = _a[i];
		_a[i] = _a[j];
		_a[j] = t;
	}
	/** print a heap array **/
	public void print(){
		for (int i=0; i<_size; i++){
			System.out.print(_a[i]+"; ");
		}
		System.out.println();
	}
	public static boolean isMinHeap(int[] arr){
		boolean ans = true;
		for (int i=0; ans && i<arr.length/2; i++){
			int left = i*2 + 1;
			int right = i*2 + 2;
			if (left<arr.length && arr[i]>arr[left]) ans = false;
			if (ans && right<arr.length && arr[i]>arr[right]) ans = false;
		}
		return ans;
	}
	public static int[] kSmallestNumbers(int[] arr, int k){
		HeapMinImplementation hp = new HeapMinImplementation(arr);
		hp.buildMinHeap();//O(n)
		int []ans = new int[k];
		for(int i=0; i<k; i++){//O(k*log(n))
			ans[i] = hp.heapExtractMin();//O(log(n))
		}
		return ans;
	}
	public static HeapMinImplementation mergeTwoHeaps(HeapMinImplementation h1, HeapMinImplementation h2) {
		int m = h1.getSize(), n = h2.getSize(), p = m + n;
		int[]t = new int[p];
		for (int i = 0; i < n; i++) { 
			t[i] = h1._a[i]; 
		} 
		for (int i = 0; i < m; i++) { 
			t[n + i] = h2._a[i]; 
		} 
		// Builds a max heap of given arr[0..p-1] 
		HeapMinImplementation ans = new HeapMinImplementation(t);
		ans.buildMinHeap();
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nodes1[] = {16,5,8,4,2,1}; 
		int nodes2[] = {5,13,1,25,7,17,2,8,4}; 
		//int nodes3[] = {16,14,10,8,7,9,3,2,4,1}; 
		int nodes4[] = {10,9,8,7,6,5,4,3,2,1}; 
		HeapMinImplementation hp = new HeapMinImplementation(nodes4);
		hp.buildMinHeap();
		hp.print();
		hp.heapSort();
		hp.print();
		/*		int node = 3;
		hp.minHeapInsert(node);
		hp.print();
		System.out.println("min = "+ hp.heapExtractMin());
		hp.print();
		System.out.println("min = "+ hp.heapExtractMin());
		hp.print();
/// heap sort

		HeapMinImplementation hps = new HeapMinImplementation(nodes4);
		hps.heapSort();
		hps.print();
		//////
		int k = nodes2.length;
		int[] ans = kSmallestNumbers(nodes2, k);
		System.out.println(Arrays.toString(ans));
		 */	}

}
