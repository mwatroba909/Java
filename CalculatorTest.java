package kalkulator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator sut = new Calculator();
        sut.add(5);
        assertEquals(5, sut.getState(), "0+5 = 5");
    }

    @Test
    public void testSub() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.subtract(5);
        assertEquals(5, sut.getState(), "10-5 = 5");
    }
    
    @Test
    public void testMul() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.multiply(5);
        assertEquals(50, sut.getState(), "10*5 = 50");
    }

    @Test
    public void testDiv() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.divide(5);
        assertEquals(2, sut.getState(), "10/5 = 2");
    }

    @Test
    public void testDivByZero() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.divide(0);
        assertTrue(sut.getErr(), "10/0 = error");
    }

    @Test
    public void testSaveMem() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.saveMem();
        assertEquals(10, sut.getMem(), "mem = 10");
    }

    @Test
    public void testUseMem() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.saveMem();
        sut.setState(5);
        sut.useMem();
        assertEquals(15, sut.getState(), "5+10 = 15");
    }

    @Test
    public void testAddMem() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.saveMem();
        sut.setState(5);
        sut.addMem();
        assertEquals(15, sut.getMem(), "10+5 = 15");
    }

    @Test
    public void testSubMem() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.saveMem();
        sut.setState(5);
        sut.subMem();
        assertEquals(5, sut.getMem(), "10-5 = 5");
    }

    @Test
    public void testGetMem() {
        Calculator sut = new Calculator();
        sut.setState(10);
        sut.saveMem();
        assertEquals(10, sut.getMem(), "mem = 10");
    }
}
