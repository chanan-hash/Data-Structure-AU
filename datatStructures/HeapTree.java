public class HeapTree {

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

    public void buildHeap(int[] arr, int size){ // sorting the array in a way that we will call heap

    }

}
