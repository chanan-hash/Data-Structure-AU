package sorts;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class MergeFirstTest {
	int size = 500;
	
	@Test
	public void test1() {
		int a1[] = {1,4,6,12};
		int a2[] = {2,4,7,10,15};
		Arrays.sort(a1);
		Arrays.sort(a2);
		int[] expected = {1,2,4,4,6,7,10,12,15};
		int [] actual = MergeFirst.merge(a1, a2);
		assertArrayEquals(expected, actual);
	}
	@Test
	public void test2() {
		int a1[] = {1,4,6,12};
		int a2[] = {22,24,27,100,115};
		Arrays.sort(a1);
		Arrays.sort(a2);
		int[] expected = {1,4,6,12,22,24,27,100,115};
		int [] actual = MergeFirst.merge(a1, a2);
		assertArrayEquals(expected, actual);
	}
	@Test
	public void test3() {
		int a1[] = {22,24,27,100,115};
		int a2[] = {1,4,6,12};
		Arrays.sort(a1);
		Arrays.sort(a2);
		int[] expected = {1,4,6,12,22,24,27,100,115};
		int [] actual = MergeFirst.merge(a1, a2);
		assertArrayEquals(expected, actual);
	}
	@Test
	public void test4() {
		int a1[] = {22};
		int a2[] = {1};
		Arrays.sort(a1);
		Arrays.sort(a2);
		int[] expected = {1,22};
		int [] actual = MergeFirst.merge(a1, a2);
		assertArrayEquals(expected, actual);
	}
	@Test
	public void test5() {
		int a1[] = MyLibrary.randomIntegerArray(size);
		int a2[] = MyLibrary.randomIntegerArray(size);
		Arrays.sort(a1);
		Arrays.sort(a2);
		int [] expected = MergeFirst.merge(a1, a2);
		assertTrue(MergeFirst.isSorted(expected));
	}

}
