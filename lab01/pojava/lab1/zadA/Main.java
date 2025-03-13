package pojava.lab1.zadA;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                int n = Integer.parseInt(args[0]);
                
                for (int i = 0; i < n; i++) {
                    System.out.println("Witaj!");
                    System.out.println(i + 1);
                }
            } catch (NumberFormatException e) {
                System.out.println("Podany argument nie jest liczbą całkowitą!");
            }
        } else {
            System.out.println("Nie podano argumentu!");
        }
    }
}

