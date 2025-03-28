package StosRpn;

import java.util.Stack;

public class StackMethod {

    private static Stack<String> stack = new Stack<>();

    public static void pushString(String value) {
        stack.push(value);        
    }

    public static String popString() {
        if (stack.isEmpty()) {
            System.err.println("Stos jest pusty");
            return null;
        } else {
            return stack.pop();
        }
    }

    public static String peekString() {
        if (stack.isEmpty()) {
            System.err.println("Stos jest pusty");
            return null;
        } else {
            return stack.peek();
        }
    } 

    public static Integer getLeangh() {
        return stack.size();
    }
}