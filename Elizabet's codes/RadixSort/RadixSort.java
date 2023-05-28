package radixSort;
import java.util.Arrays;


public class RadixSort {//for integer numbers
	
	public static void countingSort0(int[] a) {//O(n+k)
		/** find max and min values **/
		int N = a.length;
		int max = a[0], min = a[0];
		for (int i = 1; i < N; i++){
			if (a[i] > max) max = a[i];
			if (a[i] < min)  min = a[i];
		}
		int range = max - min + 1;
		/** make count/frequency array for each element **/
		int count[] = new int[range];
		for (int i = 0; i < a.length; i++)
			count[a[i] - min]++;
		
		/** modify original array **/
		int k = 0;
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count[i]; j++) {
				a[k++] = min + i;
			}
		}
	}

	public static void countingSort(int[] a) {//O(n+k)
		/** find max and min values **/
		int N = a.length;
		int max = a[0], min = a[0];
		for (int i = 1; i < N; i++){
			if (a[i] > max) max = a[i];
			if (a[i] < min)  min = a[i];
		}
		int range = max - min + 1;
		/** make count/frequency array for each element **/
		int count[] = new int[range];
		for (int i = 0; i < a.length; i++)
			count[a[i] - min]++;
		/** modify count so that positions in final array is obtained **/
		for (int j = 1; j < range; j++)
			count[j] = count[j] + count[j-1];
		
		/** modify original array **/
		for (int i = 0, j = 0; j < range; j++){
			while(i < count[j]) a[i++] = j + min;
		}
	}

	public static void radixSort( int[] a){//O(n)+O(n*log(k))=O(n*log(k))
		int i, max = a[0], exp = 1, n = a.length;
		int base = 10;
		int[] temp = new int[n];
		for (i = 1; i < n; i++){
			if (a[i] > max) max = a[i];
		}
		while (max/exp > 0){
			int[] bucket = new int[base];
			for (i = 0; i < n; i++){
				int index = (a[i] / exp) % base;
				bucket[index]++;
			}
			for (i = 1; i < base; i++){
				bucket[i] = bucket[i] + bucket[i - 1];
			}
			for (i = n - 1; i >= 0; i--){
				//temp[--bucket[(a[i] / exp) % base]] = a[i];
				int j = (a[i] / exp) % base;
				temp[--bucket[j]] = a[i];
			}
			//System.out.println(Arrays.toString(temp));
			for (i = 0; i < n; i++)
				a[i] = temp[i];
			exp = exp * base;        
		}
	}
	
	public static void radixSortWrong( int[] a){//O(n)+O(n*log(k))=O(n*log(k))
		int i, max = a[0], exp = 1, n = a.length;
		int base = 10;
		int[] temp = new int[n];
		for (i = 1; i < n; i++){
			if (a[i] > max) max = a[i];
		}
		while (max/exp > 0){
			int[] bucket = new int[base];
			for (i = 0; i < n; i++){
				int index = (a[i] / exp) % base;
				bucket[index]++;
			}
			for (i = 1; i < base; i++){
				bucket[i] = bucket[i] + bucket[i - 1];
			}
			for (i = 0; i < n; i++){//for (i = n - 1; i >= 0; i--){
				//temp[--bucket[(a[i] / exp) % base]] = a[i];
				int ind1 = (a[i] / exp) % base;
				bucket[ind1] = bucket[ind1] - 1;
				int ind2 = bucket[ind1];
				temp[ind2] = a[i];
			}
			System.out.println(Arrays.toString(temp));
			for (i = 0; i < n; i++)
				a[i] = temp[i];
			exp = exp * base;        
		}
	}
	public static void checkCounting0(){
		int a0[] = {4,8,4,2,9,9,6,2,9};
		countingSort0(a0);
		System.out.println(Arrays.toString(a0));
		
		int[]a2 = {877, 567, 9876, 111,8};
		countingSort0(a2);
		System.out.println(Arrays.toString(a2));
		int[]a1 = {877, 567, 3456, 876, 467, 26, 934, 9876, 1, 4567,90,100,0};
		countingSort0(a1);
		System.out.println(Arrays.toString(a1));
		int[]a3 = {1,2,3,4,5,6};
		countingSort0(a3);
		System.out.println(Arrays.toString(a3));
		int[]a4 = {9,8,7,6,5,4,3,2,1,0};
		countingSort0(a4);
		System.out.println(Arrays.toString(a4));
		
	}
	public static void checkCounting(){
		int a0[] = {4,8,4,2,9,9,6,2,9};
		countingSort0(a0);
		System.out.println(Arrays.toString(a0));
		
		int[]a2 = {877, 567, 9876, 111,8};
		countingSort(a2);
		System.out.println(Arrays.toString(a2));
		int[]a1 = {877, 567, 3456, 876, 467, 26, 934, 9876, 1, 4567,90,100,0};
		countingSort(a1);
		System.out.println(Arrays.toString(a1));
		int[]a3 = {1,2,3,4,5,6};
		countingSort(a3);
		System.out.println(Arrays.toString(a3));
		int[]a4 = {9,8,7,6,5,4,3,2,1,0};
		countingSort(a4);
		System.out.println(Arrays.toString(a4));
		//
		int size = 10000000;
		int [] a = MyLibrary.randomIntegerArray(size);
		// java sort
		long timeBefore = System.currentTimeMillis();
		Arrays.sort(a);
		int[]b = Arrays.copyOf(a, size);
		long timeAfter = System.currentTimeMillis();
		double elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("Java Sort time = " + elapse+" seconds, is sorted? "+MyLibrary.isSorted(a));
// counting sort
		timeBefore = System.currentTimeMillis();
		countingSort(b);
		timeAfter = System.currentTimeMillis();
		elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("Counting Sort time = " + elapse+" seconds, is sorted? "+MyLibrary.isSorted(a));
		
	}
	public static void checkRadix(){
		int[]a = {493, 812, 715 ,212};
		radixSort(a);
		System.out.println(Arrays.toString(a));
		
		int[]a1 = {877, 567, 3456};
		radixSort(a1);
		System.out.println(Arrays.toString(a1));
		
		int[]a2 = {329,457,657,839,436,720,355};
		radixSort(a2);
		System.out.println(Arrays.toString(a2));

		int[]a3 = {9,7,7,9,6,0,5};
		radixSort(a3);
		System.out.println(Arrays.toString(a3));
		//////////
		int[]a4 = {877, 567, 9456};
		radixSort(a4);
		System.out.println(Arrays.toString(a4));
		int size = 100000000;
		int [] a5 = MyLibrary.randomIntegerArray(size);

	}
	public static void checkRadixReverse(){
		//int[]a1 = {877, 567, 3456};
		int[]a1 = {8, 5, 10};
		radixSortWrong(a1);
		System.out.println(Arrays.toString(a1));
		/*
		 *  [3456, 567, 877]
			[3456, 567, 877]
			[3456, 567, 877]
			[877, 567, 3456]
		 */
	}
	
	public static void checkRadixTime(){
		int size = 100000000;
		int [] a = MyLibrary.randomIntegerArray(size);
		int[]b = Arrays.copyOf(a, size);
		long  timeBefore,timeAfter;
		double elapse;
// java sort
		timeBefore = System.currentTimeMillis();
		Arrays.sort(a);
		timeAfter = System.currentTimeMillis();
		elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("Java Sort time = " + elapse+" seconds, is sorted? "+MyLibrary.isSorted(a));
// radix sort
		timeBefore = System.currentTimeMillis();
		radixSort(b);
		timeAfter = System.currentTimeMillis();
		elapse = (timeAfter-timeBefore)/1000.0;
		System.out.println("Radix Sort time = " + elapse+" seconds, is sorted? "+MyLibrary.isSorted(a));
	}
	public static void main(String[] args) {
		checkCounting();
		//checkCounting0();
		//checkRadix();
		//System.out.println("wrong");
		//checkRadixTime();
		//checkRadixReverse();
		//int[] arr = {4,8,4,2,9,9,6,2,9};
		//radixSort(arr);
		//System.out.println(Arrays.toString(arr));
	}

}
