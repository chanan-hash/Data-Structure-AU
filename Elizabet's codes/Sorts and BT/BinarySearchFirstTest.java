package binarySearch;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class BinarySearchFirstTest {
	int size = 100;
/// test loop
	@Test(timeout = 500)
	public void testInduction1() {
		int []arr = MyLibrary.randomIntArrayOfDiffNumbers(size);
		Arrays.sort(arr);
		int val = arr[size-1];
		int expected = size-1;
		int actual = BinarySearchFirst.binarySearchInducion(arr, val);
		assertEquals(expected, actual);
	}
	@Test(timeout = 500)
	public void testInduction2() {
		int []arr = MyLibrary.randomIntArrayOfDiffNumbers(size);
		Arrays.sort(arr);
		int val = arr[0];
		int expected = 0;
		int actual = BinarySearchFirst.binarySearchInducion(arr, val);
		assertEquals(expected, actual);
	}
	@Test(timeout = 500)
	public void testInduction3() {
		int []arr = MyLibrary.randomIntArrayOfDiffNumbers(size);
		Arrays.sort(arr);
		int val = arr[size/2];
		int expected = size/2;
		int actual = BinarySearchFirst.binarySearchInducion(arr, val);
		assertEquals(expected, actual);
	}
	@Test(timeout = 500)
	public void testInduction4() {
		int []arr = MyLibrary.randomIntegerArray(size);
		Arrays.sort(arr);
		int val = arr[0] - 1;
		boolean ans = false;
		for (int i=1; !ans && i<arr.length; i++){
			if (arr[i] - arr[i-1] >= 2){
				val = arr[i-1]+1;
				ans = true;
			}
		}
		int expected = -1;
		int actual = BinarySearchFirst.binarySearchInducion(arr, val);
		System.out.println("ans = "+ans);
		assertEquals(expected, actual);
	}
	@Test(timeout = 500)
	public void testInduction5() {
		int []arr = MyLibrary.randomIntegerArray(size);
		Arrays.sort(arr);
		int val = arr[0] - 1;
		int actual = BinarySearchFirst.binarySearchInducion(arr, val);
		int expected = -1;
		assertEquals(expected, actual);
	}
	/// test recursion
	@Test(timeout = 500)
	public void testRecursion1() {
		int []arr = MyLibrary.randomIntArrayOfDiffNumbers(size);
		Arrays.sort(arr);
		int val = arr[size-1];
		int expected = size-1;
		int actual = BinarySearchFirst.binarySearchInducion(arr, val);
		assertEquals(expected, actual);
	}
	@Test(timeout = 500)
	public void testRecursion2() {
		int []arr = MyLibrary.randomIntArrayOfDiffNumbers(size);
		Arrays.sort(arr);
		int val = arr[0];
		int expected = 0;
		int actual = BinarySearchFirst.binarySearchInducion(arr, val);
		assertEquals(expected, actual);
	}
	@Test(timeout = 500)
	public void testRecursion3() {
		int []arr = MyLibrary.randomIntArrayOfDiffNumbers(size);
		Arrays.sort(arr);
		int val = arr[size/2];
		int expected = size/2;
		int actual = BinarySearchFirst.binarySearchInducion(arr, val);
		assertEquals(expected, actual);
	}
	@Test(timeout = 500)
	public void testRecursion4() {
		int []arr = MyLibrary.randomIntegerArray(size);
		Arrays.sort(arr);
		int val = arr[0] - 1;
		boolean ans = false;
		for (int i=1; !ans && i<arr.length; i++){
			if (arr[i] - arr[i-1] >= 2){
				val = arr[i-1]+1;
				ans = true;
			}
		}
		int expected = -1;
		int actual = BinarySearchFirst.binarySearchInducion(arr, val);
		System.out.println("ans = "+ans);
		assertEquals(expected, actual);
	}
	@Test(timeout = 500)
	public void testRecursion5() {
		int []arr = MyLibrary.randomIntegerArray(size);
		Arrays.sort(arr);
		int val = arr[0] - 1;
		int expected = -1;
		int actual = BinarySearchFirst.binarySearchInducion(arr, val);
		assertEquals(expected, actual);
	}

}
