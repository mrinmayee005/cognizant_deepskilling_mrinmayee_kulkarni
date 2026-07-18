package exercises;

import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {
    @Test
    public void testAssertions() {
        // assertEquals
        assertEquals(5, 2 + 3);
        assertEquals("Hello", "Hello");

        // assertArrayEquals
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});

        // assertTrue / assertFalse
        assertTrue(5 > 3);
        assertFalse(5 < 3);

        // assertNull / assertNotNull
        assertNull(null);
        assertNotNull(new Object());

        // assertSame / assertNotSame
        String a = "test";
        String b = "test";
        assertSame(a, b);
        String c = new String("test");
        assertNotSame(a, c);

        // assertArrayEquals with objects
        assertArrayEquals(new String[]{"a", "b"}, new String[]{"a", "b"});
    }
}
