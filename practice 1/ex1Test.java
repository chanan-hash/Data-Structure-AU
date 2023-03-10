import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ex1Test {

    @Test
    public void testEx2() {
        String words[] = {"be", "be", "not", "or", "to", "to", "to"};
        String words2[] = {"be", "be", "not", "or", "to", "to", "hello"};

        String str1 = ex1.regularity2(words);
        String str2 = ex1.regularity2(words2);
        assertEquals("2, 1, 1, 3", str1);
        assertEquals("2, 1, 1, 2, 1", str2);
    }

    @Test
    public void testEx3() {
        int[] arr = {1, 4, 9, 17, 23, -1, 14};
        int sa1 = ex1.smallAbsolute2(arr);
        int[] arr2 = {1, 4, 9, 17, 23, 0, 14};
        int sa2 = ex1.smallAbsolute2(arr2);

        assertEquals(2, sa1);
        assertEquals(1, sa2);
    }

    @Test
    public void testEx4() {
        int[] arr6 = {1, 4, 9, 17, 23, -1, 14};
        int maxAbs = ex1.maxAbsolute2(arr6);
        assertEquals(24, maxAbs);
    }


    @Test
    public void testEx5() {
        int[] arr3 = {98, 2, 3, 1, 0, 0, 0, 3, 98, 98, 2, 2, 2, 0, 0, 0, 2};
        int[] arr4 = arr3.clone();
        ex1.sort(arr3);
        Arrays.sort(arr4);
        assertArrayEquals(arr4, arr3);
    }

    @Test
    public void testEx6(){
        int[] arr2 = {1, 4, 9, 17, 23, 0, 14};
        int[] arr6 = {1,4,9,17,23,-1,14};

        boolean is1 = ex1.sumZero(arr2);
        boolean is2 = ex1.sumZero(arr6);

        assertFalse(is1);
        assertTrue(is2);
    }
}