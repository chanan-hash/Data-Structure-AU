package sorts;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class QuickSortFirstTest {
	@Test(timeout=5000)
	public void test1() {
		int[] a = {1,3,5,6,7,90};
		QuickSortFirst.quickSort(a);
		assertArrayEquals(a, a);
	}
	@Test(timeout=5000)
	public void test2() {
		int[] a = {45,34,15,7,5,3,0};
		int[] expected = {0,3,5,7,15,34,45};
		QuickSortFirst.quickSort(a);
		assertArrayEquals(expected, a);
	}
	@Test(timeout=5000)
	public void test3() {
		int[] a = {7,3,9,5,4,8,1};
		int[] expected = {1,3,4,5,7,8,9};
		QuickSortFirst.quickSort(a);
		assertArrayEquals(a, a);
	}
	@Test(timeout=5000)
	public void test4() {
		int size = 100;
		int[] a = MyLibrary.randomIntegerArray(size);
		long  timeBefore = System.currentTimeMillis();
		QuickSortFirst.quickSort(a);
		long timeAfter = System.currentTimeMillis();
		double elapse = (timeAfter-timeBefore)/1000.0;;
		System.out.println("QuickSortFirst time = " +  + elapse+" seconds");	
		assertTrue(MyLibrary.isSorted(a));
	}
	@Test(timeout=5000)
	public void test5() {
		int size = 10000000;
		int[] a = MyLibrary.randomIntegerArray(size);
		int[]b = Arrays.copyOf(a, a.length);
		//Quick Sort
		long  timeBefore = System.currentTimeMillis();
		QuickSortFirst.quickSort(a);
		long timeAfter = System.currentTimeMillis();
		double elapse = (timeAfter-timeBefore)/1000.0;;
		System.out.println("QuickSortFirst time = " +  + elapse+" seconds");	
		assertTrue(MyLibrary.isSorted(a));
		//Java Sort
		timeBefore = System.currentTimeMillis();
		QuickSortFirst.quickSort(a);
		timeAfter = System.currentTimeMillis();
		elapse = (timeAfter-timeBefore)/1000.0;;
		System.out.println("JavaSort time = " +  + elapse+" seconds");	
		assertTrue(MyLibrary.isSorted(a));
	}
}
