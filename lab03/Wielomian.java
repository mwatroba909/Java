package lab03;

import java.util.*;

public class Wielomian {

    public static int obliczWielomian(int x) {
        double mianownik = Math.pow(x, 2) - 7 * x + 1;

        if (mianownik == 0) {
            throw new ArithmeticException("Dzielenie przez zero dla x = " + x);
        }

        return (int) ((Math.pow(x, 5) + 4 * Math.pow(x, 4) + 3 * Math.pow(x, 3) - 2 * Math.pow(x, 2) + 17) / mianownik);
    }

    public static void main(String[] args) {
        int[] x = new int[]{-3, -2, -1, 1, 2, 3};
        int[] wyniki = new int[x.length];

        for (int i = 0; i < x.length; i++) {
            try {
                wyniki[i] = obliczWielomian(x[i]);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Wyniki: " + Arrays.toString(wyniki));
    }    
}
