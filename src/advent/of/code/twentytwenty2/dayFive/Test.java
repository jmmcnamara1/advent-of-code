package advent.of.code.twentytwenty2.dayFive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        run();
    }

    private static ArrayList<Stack<String>> stacks = new ArrayList<>();
    private static String[][] tempCrateStorage;
    private static void crateInitialiser(String line) {
        String[] arr = new StringBuilder(line).insert(0, "|").toString().split("");
        StringBuilder sb = new StringBuilder();
        int tempCounter = 0;
        for (int i=0; i < arr.length; i++) {
            sb.append(arr[i]);
            tempCounter++;
            if ((i+1)/4 ==0) {
//                if (sb.toString().con)
            }
        }
    }
    public static void run() {

        try (BufferedReader reader = new BufferedReader(new FileReader("src/advent/of/code/twentytwenty2/dayFive/data.txt"))) {
            reader.mark(2000);
            String line;
            int numberOfStacks = 0;
            int maxHeightOfStacks = -1;
            while ((line = reader.readLine()) != null) {
                maxHeightOfStacks++;
                if (line.startsWith(" 1 ")) {
                    numberOfStacks = Integer.parseInt(line.substring(line.length()-1));
                    break;
                }
            }
            tempCrateStorage = new String[numberOfStacks][maxHeightOfStacks];
            reader.reset();
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith("move") && !line.startsWith(" 1 ")) {
                    crateInitialiser(line);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
