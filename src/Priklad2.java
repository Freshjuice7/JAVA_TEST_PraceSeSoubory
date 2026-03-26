import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Priklad2 {
    Scanner sc = new Scanner(System.in);
    Path soubor = Path.of("data", "slova_opravene.txt");
    List<String> slova;
    List<String> vysledky;

    {
        try {
            slova = Files.readAllLines(soubor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Priklad2() {
    }

    public void statistika() {
        pocetSlov();
        prumDelka();
        nejdelsiSlovo();
        nejkratsiSlovo();
        najdiVSouboru();



    }

    public void pocetSlov() {
        int pocetSlov = 0;
        for (String s : slova) {
            pocetSlov++;
        }
        System.out.println("Počet slov: " + pocetSlov);
    }


    public void prumDelka() {
        double average = 0;
        int count = 0;
        double sum = 0;
        for (String s : slova) {
            String input = s;
            String[] words = input.split("\\s+");

            for (String word : words) {
                double wordLength = word.length();
                sum += wordLength;
                count++;
            }


            if (count > 0) {
                average = sum / count;
            }

        }
        System.out.println("Průměrná délka slova: " + average);
    }

    public void nejdelsiSlovo() {
        System.out.print("Nejdelsi slovo/a: ");


        String[] words = new String[0];
        String longestWord = "";
        for (String s : slova) {
            String input = s;
            words = input.split("\\s+");


            for (String word : words) {
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }

        }
        for (String s : slova) {
            if (s.length() == longestWord.length()) {
                System.out.print(s + " ");
            }
        }
        System.out.println();
    }


    public void nejkratsiSlovo() {
        System.out.print("Nejkratsi slovo/a: ");

        String[] words = new String[0];
        String shortestWord = "";
        for (String s : slova) {
            String input = s;
            words = input.split("\\s+");


            for (String word : words) {
                if (word.length() < shortestWord.length() || shortestWord.equals("")) {
                    shortestWord = word;
                }
            }

        }
        for (String s : slova) {
            if (s.length() == shortestWord.length()) {
                System.out.print(s + " ");
            }
        }
        System.out.println();

    }


    public void najdiVSouboru() {
        boolean nalezeno = false;
        System.out.println("Jaký slovo hledáš?");
        String slovicko = sc.next();
        int pozice = 0;
        for (String s : slova) {
            if (s.equals(slovicko)) {
                nalezeno = true;
                pozice++;
            }
            if (!nalezeno) {
                pozice++;
            }

        }
        if (nalezeno) {
            System.out.println("V souboru se nachází " + slovicko);
            System.out.println(slovicko + " se nacházi na: " + pozice + " řádku");
        } else {
            System.out.println("V souboru nebylo nalezeno žádné slovo: " + slovicko);
        }

    }

}



