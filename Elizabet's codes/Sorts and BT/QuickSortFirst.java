package sorts;

import java.util.Arrays;


public class QuickSortFirst {
	// shuffle the array a[]
	private static void shuffle(int[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int r = (int) (Math.random() * N);   // between i and N-1
			swap(a, i, r);
		}
	}
	private static int partition(int[] array, int low, int high){
		int pivot = low++;
		while (low <= high){
			if (array[low] <= array[pivot]) low++;
			else if (array[high] >= array[pivot]) high--;
			else swap(array, low, high);
		}
		swap(array, high, pivot);
		return high;//pivot = high;
	}
	public static void quick_sort(int[] array, int low, int high){
		if (low <= high){
			int pivot = partition(array, low, high);
			quick_sort(array, low, pivot-1);
			quick_sort(array, pivot+1, high);
		}
	}
	public static void quickSort(int[] array){
		// sort
		quick_sort(array, 0, array.length-1);
	}
	//Swap
	public static void swap(int [] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	private static boolean isSorted(int[] a) {
		for (int i = 1; i < a.length; i++)
			if (a[i] < a[i-1]) return false;
		return true;
	}
	public static void main(String[] args) {
		int[]arr = {9,8,7,6,5,4};//{7,3,9,5,4,8,1};
		quickSort(arr);
		System.out.println("Quick Sort is sorted? "+isSorted(arr));
		////////
		//int size = 30000;
		int size = 10000000;
		System.out.println("size = "+size);
		int [] a = MyLibrary.randomIntegerArray(size);
		int[]b = Arrays.copyOf(a, size);
		long  timeBefore,timeAfter;
// java sort
		timeBefore = System.currentTimeMillis();
		Arrays.sort(a);
		timeAfter = System.currentTimeMillis();
		System.out.println("Java Sort time = " + (timeAfter-timeBefore)/1000.0+" seconds, is sorted? "+isSorted(a));
/// quick sort 
		timeBefore = System.currentTimeMillis();
		quickSort(b);
		timeAfter = System.currentTimeMillis();
		System.out.println("Quick Sort time = " + (timeAfter-timeBefore)/1000.0+" seconds, is sorted? "+isSorted(b));
/// quick sort sorted array
/*		timeBefore = System.currentTimeMillis();
		quickSort(b);
		timeAfter = System.currentTimeMillis();
		System.out.println("Quick Sort (sorted array) time = " + (timeAfter-timeBefore)/1000.0+" seconds, is sorted? "+isSorted(b));
*/	}
}
/*array : {7,3,9,5,4,8,1};
	7, 3, 9, 5, 4, 8, 1, 
	7, 3, 1, 5, 4, 8, 9, 
	4, 3, 1, 5, 7, 8, 9, 
	1, 3, 4, 5, 7, 8, 9, 
	1, 3, 4, 5, 7, 8, 9, 
	1, 3, 4, 5, 7, 8, 9, 
	quickSort time = 0.0 seconds
	Comparisons: 11
	Exchanges:   5
	1, 3, 4, 5, 7, 8, 9, 
	JavaSort time = 0.156 seconds
 */