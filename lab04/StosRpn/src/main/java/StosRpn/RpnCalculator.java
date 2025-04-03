package StosRpn;

import java.util.Stack;

public class RpnCalculator {
    private Stack<Integer> stack;

    public RpnCalculator() {
        stack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stos jest pusty");
        }
        return stack.pop();
    }

    public int peek() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stos jest pusty");
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void operation(String operation) {
        if (stack.size() < 2) {
            throw new IllegalStateException("Za mało elementów na stosie do wykonania operacji.");
        }
    
        int a = stack.pop();
        int b = stack.pop();
    
        switch (operation) {
            case "+":
                stack.push(b + a);
                break;
            case "-":
                stack.push(b - a);
                break;
            case "*":
                stack.push(b * a);
                break;
            case "/":
                if (a == 0) {
                    System.err.println("Nie można dzielić przez zero");
                    break;
                }
                stack.push(b / a);
                break;
            default:
                throw new IllegalArgumentException("Nieznana operacja: " + operation);
        }
    }
    
    public static void main(String[] args) {
        RpnCalculator calculator = new RpnCalculator();
        
        calculator.push(5);
        calculator.push(3);
        calculator.operation("+");
        System.out.println("Wynik: " + calculator.pop());
    }
}