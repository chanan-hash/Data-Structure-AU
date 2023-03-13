import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ex2Test {

    @Test
    public void testEx2() {
        double a = 5;
        double b = 6;
        double sum = ex2.sum(a, b);
        double sub = ex2.subtract(a, b);

        assertEquals(11, sum);
        assertEquals(-1, sub);
        assertEquals(0,ex2.subtract(a,a));
    }

}