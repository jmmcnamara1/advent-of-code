package advent.of.code.twentytwenty2.dayTwo.part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import advent.of.code.twentytwenty2.dayTwo.ScoringTable;

public class Test {


    public static int getScores() {

        int total = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/advent/of/code/twentytwenty2/dayTwo/data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) {
                    String a = String.valueOf(line.charAt(0));
                    String b = String.valueOf(line.charAt(2));
                    total += scoreCalc(a, b);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return total;
    }


    public static int scoreCalc(String a, String b) {
        int drawPoints = 3;
        int winPoints = 6;

        Strategy yourChoice = Strategy.valueOf(b);
        ScoringTable theirPick = ScoringTable.valueOf(a);

        int choicePoints = yourChoice.getScore();

        if (theirPick.getBeatenBy().equals(yourChoice.getName())) {
            return winPoints + choicePoints;
        } else if (theirPick.getBeats().equals(yourChoice.getName())) {
            return choicePoints;
        } else {
            return drawPoints + choicePoints;
        }
    }

    public static void main(String[] args) {

        System.out.println(getScores());
    }
}
