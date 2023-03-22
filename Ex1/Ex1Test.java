import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex1Test {

    @Test
    public void testOnes(){
        int[] arr = {-14, 1, 1, 1, 1, 2, 9, 15, 20};
        assertEquals(4, Ex1.ones(arr,1));

        int[] arr2 = {1, 2, 2, 2, 3, 3, 4, 5, 5};
        int k = 2;
        int expected = 3;
        int actual = Ex1.ones(arr2, k);
        assertEquals(expected, actual);

        int[] arr3 = {1, 2, 2, 2, 3, 3, 4, 5, 5};
        int k3 = -1;
        assertEquals(-1, Ex1.ones(arr3,7));


    }
}