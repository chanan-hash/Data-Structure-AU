import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ex3Test {
    @Test
    public void testBinarySearch(){
        int[] arr = {1, 2, 3, 4, 5, 8, 9, 11, 57};
        assertEquals(-1,ex3.binarySreach(arr,10));
        assertEquals(7,ex3.recBinaryserach(arr,11,arr[0],arr.length-1));
        assertEquals(5,ex3.finalRecBin(arr,8));
        assertEquals(-1,ex3.finalRecBin(arr,12));

    }
}