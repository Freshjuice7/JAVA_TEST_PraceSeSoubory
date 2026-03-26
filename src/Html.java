import javax.swing.text.html.HTML;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Html {
    Scanner sc = new Scanner(System.in);
    List<String> data = new ArrayList<>();

    public Html() {

    }

    public void generaceHtml() {
        System.out.println("jaký je titulek HTML?");
        String titulek = sc.nextLine();
        System.out.println("jaký je nadpis HTML?");
        String nadpis = sc.nextLine();

        String aToZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String odstavec1 = generateRandom(aToZ);
        String odstavec2 = generateRandom(aToZ);
        String odstavec3 = generateRandom(aToZ);


        data.add("<!DOCTYPE html>");
        data.add("<html>");
        data.add("<head>");
        data.add("<title>" + titulek + "</title>");
        data.add("</head>");
        data.add("<body>");
        data.add("<h1>" + nadpis + "</h1>");
        data.add("<p>" + odstavec1 + "</p>");
        data.add("<p>" + odstavec2 + "</p>");
        data.add("<p>" + odstavec3 + "</p>");
        data.add("</body>");
        data.add("</html>");
        zapis();
    }

    private void zapis() {
        Path vystup = Path.of("data", "test.html");
        try {
            if (!Files.exists(vystup.getParent())) {
                Files.createDirectories(vystup.getParent());
            }
            Files.write(vystup, data);
            System.out.println("Soubor uložen do: " + vystup.toAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String generateRandom(String aToZ) {
        Random rand = new Random();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 17; i++) {
            int randIndex = rand.nextInt(aToZ.length());
            res.append(aToZ.charAt(randIndex));
        }
        return res.toString();
    }


}
