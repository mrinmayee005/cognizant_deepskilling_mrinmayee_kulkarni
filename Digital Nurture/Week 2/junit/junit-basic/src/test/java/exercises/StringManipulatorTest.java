package exercises;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringManipulatorTest {
    @Test
    public void testReverseString() {
        StringManipulator sm = new StringManipulator();
        assertEquals("dcba", sm.reverseString("abcd"));
        assertEquals("a", sm.reverseString("a"));
        assertEquals("", sm.reverseString(""));
        assertNull(sm.reverseString(null));
    }

    @Test
    public void testToUpperCase() {
        StringManipulator sm = new StringManipulator();
        assertEquals("HELLO", sm.toUpperCase("hello"));
        assertEquals("HELLO", sm.toUpperCase("HELLO"));
        assertNull(sm.toUpperCase(null));
    }

    @Test
    public void testIsEmpty() {
        StringManipulator sm = new StringManipulator();
        assertTrue(sm.isEmpty(null));
        assertTrue(sm.isEmpty(""));
        assertFalse(sm.isEmpty("hello"));
    }

    @Test
    public void testConcat() {
        StringManipulator sm = new StringManipulator();
        assertEquals("HelloWorld", sm.concat("Hello", "World"));
        assertEquals("Hello", sm.concat("Hello", null));
        assertEquals("World", sm.concat(null, "World"));
        assertEquals("", sm.concat(null, null));
    }
}
