import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ex1Test {

    @Test
    public void TestEx2() {
        String words[] = {"be", "be", "not", "or", "to", "to", "to"};
        String words2[] = {"be", "be", "not", "or", "to", "to", "hello"};

        String str1 = ex1.regularity2(words);
        String str2 = ex1.regularity2(words2);
        assertEquals("2, 1, 1, 3",str1);
        assertEquals("2, 1, 1, 2, 1",str2);

    }
}