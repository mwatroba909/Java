package pojava.lab1.zadB;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Podaj 4 argumenty!");
        } else {
            String[] tab = {args[0], args[1], args[2], args[3]};

            System.out.println(Arrays.toString(tab));
        }
    }
}
