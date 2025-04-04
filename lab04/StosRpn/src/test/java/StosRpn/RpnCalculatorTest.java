package StosRpn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RpnCalculatorTest {
    
    private RpnCalculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new RpnCalculator();
    }
    
    @Test
    void testEmptyStackAfterCreation() {
        assertTrue(calculator.isEmpty());
    }
    
    @Test
    void testPushAndPop() {
        calculator.push(5);
        assertFalse(calculator.isEmpty());
        assertEquals(5, calculator.pop());
        assertTrue(calculator.isEmpty());
    }
    
    @Test
    void testPeek() {
        calculator.push(10);
        assertEquals(10, calculator.peek());
        assertFalse(calculator.isEmpty());
        assertEquals(10, calculator.pop());
    }
    
    @Test
    void testPopEmptyStack() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            calculator.pop();
        });
        assertEquals("Stos jest pusty", exception.getMessage());
    }
    
    @Test
    void testPeekEmptyStack() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            calculator.peek();
        });
        assertEquals("Stos jest pusty", exception.getMessage());
    }
    
    @Test
    void testAddition() {
        calculator.push(3);
        calculator.push(2);
        calculator.operation("+");
        assertEquals(5, calculator.pop());
    }
    
    @Test
    void testSubtraction() {
        calculator.push(5);
        calculator.push(2);
        calculator.operation("-");
        assertEquals(3, calculator.pop());
    }
    
    @Test
    void testMultiplication() {
        calculator.push(4);
        calculator.push(3);
        calculator.operation("*");
        assertEquals(12, calculator.pop());
    }
    
    @Test
    void testDivision() {
        calculator.push(10);
        calculator.push(2);
        calculator.operation("/");
        assertEquals(5, calculator.pop());
    }
    
    @Test
    void testOperationOrder() {
        calculator.push(10); // b
        calculator.push(5);  // a
        calculator.operation("-");
        assertEquals(5, calculator.pop()); // b - a = 10 - 5 = 5
    }
    
    @Test
    void testOperationWithInsufficientElements() {
        calculator.push(5);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            calculator.operation("+");
        });
        assertEquals("Za mało elementów na stosie do wykonania operacji.", exception.getMessage());
    }
    
    @Test
    void testUnknownOperation() {
        calculator.push(5);
        calculator.push(3);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.operation("$");
        });
        assertEquals("Nieznana operacja: $", exception.getMessage());
    }
    
    @Test
    void testComplexOperationSequence() {
        calculator.push(3);
        calculator.push(4);
        calculator.operation("+");  // 7
        calculator.push(2);
        calculator.operation("*");  // 14
        calculator.push(7);
        calculator.operation("/");  // 2
        assertEquals(2, calculator.pop());
        assertTrue(calculator.isEmpty());
    }
}