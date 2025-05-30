package Finder;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class ReadFile {
    static String content = "";

    public static void read(String[] args) {
        try {
            content = Files.readString(Paths.get("src/main/resources/tekst.txt"));
        } catch (IOException e) {
            System.out.println("Błąd odczytu pliku: " + e.getMessage());
        }
    }

    public static void replace(String[] args) {
        read(args);

        String modifiedContent = content.replace("ó", "?")
                                        .replace("u", "?")
                                        .replace("ż", "?")
                                        .replace("rz", "?")
                                        .replace("ch", "?")
                                        .replace("h", "?");

        content = modifiedContent;
    }

    public static void main(String[] args) {
        read(args);
        System.out.println("Originalny tekst:");
        System.out.println(content);;
        replace(args);
        System.out.println("Zamieniony tekst:");
        System.out.println(content);
    }
}
