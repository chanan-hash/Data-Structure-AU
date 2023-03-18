import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ex3Test {
    @Test
    public void testBinarySearch() {
        int[] arr = {1, 2, 3, 4, 5, 8, 9, 11, 57};
        String[] srr = {"contribute", "geeks", "ide", "practice"};
        String x = "ide";
        assertEquals(-1, ex3.binarySreach(arr, 10));
        assertEquals(7, ex3.recBinaryserach(arr, 11, arr[0], arr.length - 1));
        assertEquals(5, ex3.finalRecBin(arr, 8));
        assertEquals(-1, ex3.finalRecBin(arr, 12));

        assertEquals(2, ex3.stringBinarySerach(srr, x));
        assertEquals(-1, ex3.stringBinarySerach(srr, "abc"));

    }

    void testCommonElements() {
        String[] arr1 = {"apple", "banana", "orange", "grape"};
        String[] arr2 = {"banana", "grape", "kiwi", "pear"};
        String[] arr3 = {"banana", "grape", "kiwi", "orange", "strawberry"};
        String[] expected = {"banana", "grape"};
        String[] actual = ex3.joinSrr(arr1, arr2, arr3);

        assertArrayEquals(expected, actual);
    }

    @Test
    void testEmptyArrays() {
        String[] arr1 = {};
        String[] arr2 = {"banana", "kiwi", "grape", "pear"};
        String[] arr3 = {};

        String[] expected = {};
        String[] actual = ex3.joinSrr(arr1, arr2, arr3);

        assertArrayEquals(expected, actual);
    }

    @Test
    void testNoCommonElements() {
        String[] arr1 = {"apple", "banana", "orange"};
        String[] arr2 = {"kiwi", "pear"};
        String[] arr3 = {"strawberry", "watermelon"};

        String[] expected = {};
        String[] actual = ex3.joinSrr(arr1, arr2, arr3);

        assertArrayEquals(expected, actual);
    }


}