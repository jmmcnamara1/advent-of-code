package advent.of.code.twentytwenty2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;

public class TemplateReader {

    public static void run() {

        try (BufferedReader reader = new BufferedReader(new FileReader("src/advent/of/code/twentytwenty2/dayThree/data.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {


            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
