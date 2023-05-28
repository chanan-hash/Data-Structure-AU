package Heap;
/** The root of the tree is A[1], i is the of a node
    the Max-Heap Property : for every node i other than the root:
    A[parent[i]]>=A[i], that is the value of the node
	is at most the value of its parent.
    Thus, the largest element in a max-heap is stored at the root.
 **/
/** Constructor */
public class HeapMaxImplementation {
	static int count = 0, exchange = 0;
	int _negativeInfinity = Integer.MIN_VALUE;
	private int _a[];
	private int _size;
	public HeapMaxImplementation(int arr[]){
		_size = arr.length;
		_a = new int[_size];
		for (int i=0; i<_size; i++){
			_a[i]=arr[i];
		}
		buildMaxHeap();
	}
	/** parent returns the parent of vertex  i*/
	private  int parent(int i){return (i-1)/2;} //O(1)
	/** leftChild returns the left child of vertex  i*/
	private  int leftChild(int i){return 2*i+1;}//O(1)
	/** rightChild returns the right child of vertex  i*/
	private  int rightChild(int i){return 2*i+2;}//O(1)
	/** returns the heap maximum */
	public int heapMaximum(){return _a[0];}//O(1)
	/** returns true if the heap is empty, otherwise false */
	public boolean isEmpty(){return _size == 0;}//O(1)	
	/** 
	 * The maxHeapfy maintains the Max-Heap Property
	 * complexity is O(log(n))
	 * @param _a - array of numbers
	 * @param v - vertex 
	 * @param heapSize - size of the heap
	 * The function of maxHeapfy is to let the value of a[v] "float-down"
	 * in the Max-Heap so that subtree rooted at index v becomes a Max-Heap
	 */
	private void maxHeapify(int v, int heapSize){// O(log(n))
		count++;
		int largest;
		int left = leftChild(v);
		int right = rightChild(v);
		if (left<heapSize && _a[left]>_a[v]){
			largest = left;
		}
		else{
			largest = v;
		}
		if (right<heapSize && _a[right]>_a[largest]){
			largest = right;
		}
		if (largest!=v){
			exchange++;
			exchange(v, largest);
			maxHeapify(largest, heapSize);
		}		
	}
	/** 
	 * buildMaxHeap produces a Max-Heap from an unordered input array.
	 * buildMaxHeap runs in linear time O(n)
	 */
	public void buildMaxHeap(){//O(n)
		for (int i=_size/2-1; i>=0; i--){
			maxHeapify(i, _size);
		}
	}
	/** heapSort sorts an array in place
	 * complexity is O(n*log(n))
	 **/

	public void heapSort(){//O(n*log(n))
		count = 0;
		System.out.println("count before sort = "+count);
		//print(); heap
		int heapSize = _size;
		for (int i=heapSize-1; i>=1; i--){
			exchange++;
			exchange(0, i);
			heapSize = heapSize - 1;
			maxHeapify(0, heapSize);
		}
		System.out.println("count after sort = "+count);
	}
	/**
	 *  heapExtractMax removes and returns the largest element of heap
	 * O(log(n))
	 **/
	public int heapExtractMax(){
		int max = _negativeInfinity; // infinity
		if (!isEmpty()){
			max = _a[0];
			_a[0]=_a[_size-1];
			_size = _size-1;
			maxHeapify(0, _size);
		}
		return max;
	}
	/**
	 * heapIncreaseKey(v, key) increases the value of element v-s key 
	 * to the new value key, which is assumed to be at least as large
	 * as v's current key value
	 */
	public void heapIncreaseKey(int i, int key){
		if (key >=_a[i]){
			_a[i] = key;
			while (i>0 && _a[parent(i)]<_a[i]){
				exchange(i, parent(i));
				i = parent(i);
			}
		}
	}
	/**
	 * heapInsert(key) inserts the element key into a heap
	 */
	public void heapInsert(int key){
		resize(1);
		_a[_size-1] = _negativeInfinity;
		heapIncreaseKey(_size-1, key);
	}
	private void resize(int increment){
		int temp[] = new int[_size+increment];
		for (int i=0; i<_size; i++){
			temp[i]=_a[i];
		}
		_a = temp;
		_size = _size+increment;
	}
	/**
	 * exchange two elements of an array
	 * @param i - index (0 <= i < a.length)
	 * @param j - index (0 <= j < a.length)
	 */
	private void exchange(int i, int j){
		int t = _a[i];
		_a[i] = _a[j];
		_a[j] = t;
	}
	/** print a heap array */
	public void print(){
		for (int i=0; i<_size; i++){
			System.out.print(_a[i]+", ");
		}
		System.out.println();
	}
	public static boolean isMaxHeap(int[] arr){
		boolean ans = true;
		for (int i=0; ans && i<arr.length/2; i++){
			int left = i*2 + 1;
			int right = i*2 + 2;
			if (left<arr.length && arr[i]<arr[left]) ans = false;
			if (ans && right<arr.length && arr[i]<arr[right]) ans = false;
		}
		return ans;
	}
	public boolean isSorted() {
		boolean flag = true;
		for (int i=1; flag && i < _a.length; i++) {
			if(_a[i-1] > _a[i]) flag = false;
		}
		return flag;
	}
	public static void test1() {
		//		int arr[] = {5,13,2,25,7,17,2,8,4};
		//		int arr[] = {1,2,4,8,16,3,9,7,10,14};
		int arr2[] = {1,2,20,8,16};
		int arr3[] = {16,8,4,2,1};
		int arr1[] = {16,14,10,8,7,9,3,2,4,1};
		int arr[] = {4,1,3,2,16,9,10,14,8,7};
		HeapMaxImplementation hp = new HeapMaxImplementation(arr3);
		hp.buildMaxHeap();
		hp.print();
		/////// 
		System.out.println("is max heap? " + isMaxHeap(arr));
		System.out.println("is max heap? " + isMaxHeap(arr2));
		System.out.println("is max heap? " + isMaxHeap(hp._a));
		System.out.println("is max heap? " + isMaxHeap(arr1));
		//insert
		hp.heapInsert(-1);
		hp.print();
		hp.heapSort();
		hp.print();;
		hp.heapExtractMax();
		hp.print();
		hp.heapExtractMax();
		hp.print();
		hp.heapSort();
		hp.print();		
	}
	public static void test2() {
		int[]a = {1,2,3,4,5,6,7,8,9,10};
		HeapMaxImplementation hp = new HeapMaxImplementation(a);
		hp.buildMaxHeap();
		hp.print();
	}
	
	public static void test3(int n) {
		count = 0;
		System.out.println("a is sorted by decreasing order ");
		int[]a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = a.length-i-1;
		}
		HeapMaxImplementation hp = new HeapMaxImplementation(a);
		hp.heapSort();
		System.out.println("is sorted? "+hp.isSorted());
	}
	public static void test4(int n) {
		count = 0;
		//System.out.println("a is sorted by increasing order ");
		int[]a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = i+1;
		}
		HeapMaxImplementation hp = new HeapMaxImplementation(a);
		//hp.heapSort();
		//System.out.println("is sorted? "+hp.isSorted());
	}
	public static void main(String[] args) {
		int n = 1024;
		System.out.println("n = "+n);
		exchange = 0;
		test2();
		System.out.println("exchange = "+exchange);
		System.out.println();
		exchange = 0;
		test4(n);
		System.out.println("exchange = "+exchange);
	}
}
/*
n = 1024
a is sorted by increasing order 
count before sort = 0
count after sort = 8953
is sorted? true
exchange = 9968

n = 1024
a is sorted by decreasing order 
count before sort = 0
count after sort = 8542
is sorted? true
exchange = 8542
*/