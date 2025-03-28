package StosRpn;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackMethodTest {
    @BeforeEach
    public void setUp() {
        while (StackMethod.popString() != null);
    }

    @Test
    public void pushTest() {
        StackMethod.pushString("Test1");
        StackMethod.pushString("Test2");

        assertEquals(2, StackMethod.getLeangh());
    }

    @Test
    public void popTest() {
        StackMethod.pushString("Test1");
        StackMethod.popString();

        assertEquals(0, StackMethod.getLeangh());
    }

    @Test
    public void peekTest() {
        StackMethod.pushString("Test1");

        assertEquals("Test1", StackMethod.peekString());
    }

    @Test 
    public void peekWithtwoTest() {
        StackMethod.pushString("Test1");
        StackMethod.pushString("Test2");

        assertEquals("Test2", StackMethod.peekString());
    }

    @Test
    public void stackIsNull1Test() {
        assertNull(StackMethod.popString());
    }

    @Test
    public void stackIsNull2Test() {
        assertNull(StackMethod.peekString());
    }
}
