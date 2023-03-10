import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ex2Test {

    @Test
    public void testEx2() {
        double a = 5;
        double b = 6;
        double sum = ex2.sum(a, b);
        double sub = ex2.subtract(a, b);
        double mul = ex2.mul(2.5,2);
        double div = ex2.div(10,2);
        assertEquals(11, sum);
        assertEquals(-1, sub);
        assertEquals(0,ex2.subtract(a,a));
        assertEquals(5,mul);
        assertEquals(5,div);

        assertEquals(6,ex2.remainder(6,12));
        assertEquals(5.5,ex2.remainder(12,6.5));
        assertEquals(0,ex2.remainder(28,4));
        assertEquals(4,ex2.remainder(4,28));

    }

}