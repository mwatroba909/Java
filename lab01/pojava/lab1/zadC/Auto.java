package pojava.lab1.zadC;

import java.util.Random;

public class Auto {
    private float[] przebieg;

    public Auto() {
        Random random = new Random();
        przebieg = new float[12]; 
        float min = 0;
        float max = 10000;

        for (int i = 0; i < przebieg.length; i++) {
            przebieg[i] = min + random.nextFloat() * (max - min);
        }
    }

    public float srPrzebieg() {
        float suma = 0;
        for (int i = 0; i < przebieg.length; i++) {
            suma += przebieg[i];
        }
        return suma / przebieg.length;
    }

    public float[] getPrzebieg() {
        return przebieg;
    }
}

class Taxi extends Auto {
    private float[] zarobki;

    public Taxi() {
            Random random = new Random();
            zarobki = new float[12]; 
            float min = 2000;
            float max = 7000;

            for (int i = 0; i < zarobki.length; i++) {
                zarobki[i] = min + random.nextFloat() * (max - min);
        }
    }


    public float srZarobki() {
        float suma = 0;
        for (int i = 0; i < zarobki.length; i++) {
            suma += zarobki[i];
        }
        return suma / zarobki.length;
    }

    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        System.out.println("Średni przebieg: " + taxi.srPrzebieg());
        System.out.println("Średnie zarobki: " + taxi.srZarobki());
    }
}