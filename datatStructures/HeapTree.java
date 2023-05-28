
public class HeapTree {

    /**
     * This class is not built correctly till the end, in the way of OOP
     * This is only for learning the idea of HeapTree.
     * In java, it can be implemented by 'PriorityQueue'.
     * for a working class look at:
     *
     */

    int _positiveInfinity = Integer.MAX_VALUE;
    //    double pos = Double.POSITIVE_INFINITY;
    private int arr[];
    private int size;

    // those are the indexes of the values, not the values themselves
    public int parent(int i) { // O(1)
        return (i - 1) / 2;
    }

    public int leftChild(int i) { // O(1)
        return i * 2 + 1;
    }

    public int rightChild(int i) { // O(1)
        return i * 2 + 2;
    }

    public int heapMinimum() {
        return this.arr[0];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    //the minHeapfy function maintains the min-heap property
    // this is the main function in the heapTree
    public void minHeapify(int arr[], int v, int heapSize) { //𝑶(𝒍𝒐𝒈𝟐𝒏)
        int smallest = -1;
        int left = leftChild(v);
        int right = rightChild(v);

        if (left < heapSize && arr[left] < arr[v]) { // if left > heapSize, we will go out of bounds from the array
            smallest = left;
        } else {
            smallest = v; // initializing 'smallest with one of our indexes
        }
        if (right < heapSize && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != v) { // left or right
            swap(arr, v, smallest);
            minHeapify(arr, smallest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // O(n)
    public void buildHeap(int[] arr, int size) { // sorting the array in a way that we will call heap
        for (int i = size / 2; i >= 0; i--) {
            minHeapify(arr, i, size);
        }
    }

    public void heapsort(int[] arr) { // O(nlog(n))
        buildHeap(arr, arr.length); // O(n)
        int heapSize = arr.length;
        for (int i = heapSize; i >= 1; i--) { // O(n)
            swap(arr, 0, i);
            heapSize--;
            minHeapify(arr, 0, heapSize); // O(log(n))
        }
    }


    public void heapDecreaseKey(int[] arr, int i, int key) {
        if (key < arr[i]) {
            arr[i] = key;
        }
        while (i > 0 && arr[parent(i)] > arr[i]) {
            swap(arr, i, parent(i));
            i = parent(i);
        }
    }

    public void minHeapinsert(int[] a, int key) { // O(log(n))
        resize(1);
        this.size++;
        this.arr[size - 1] = _positiveInfinity;
        heapDecreaseKey(this.arr, size - 1, key);
    }

    private void resize(int increment) {
        int temp[] = new int[this.size + increment];
        for (int i = 0; i < this.size; i++) {
            temp[i] = this.arr[i];
        }
        this.arr = temp;
        this.size = this.size + increment;
    }

    public int heapMinimum(int[] arr) { // O(1)
        return arr[0];
    }

    public int heapextractMin(int[] a, int heapsize) {
        int min = _positiveInfinity;
        if (!isEmpty()) {
            min = a[0];
            a[0] = a[heapsize - 1];
            heapsize = heapsize - 1;
            minHeapify(a, 0, heapsize); //𝑶(𝒍𝒐𝒈𝟐𝒏)
        }
        return min;
    }

}
