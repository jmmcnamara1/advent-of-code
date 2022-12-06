package advent.of.code.twentytwenty2.dayTwo.part2;

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
        Strategy yourChoice = Strategy.valueOf(b);
        ScoringTable theirPick = ScoringTable.valueOf(a);
        if (b.equals("X")) {
           return ScoringTable.valueOf(theirPick.getBeats()).getPoints() + yourChoice.getScore();
        } else if (b.equals("Z")) {
            return ScoringTable.valueOf(theirPick.getBeatenBy()).getPoints() + yourChoice.getScore();
        } else {
            return theirPick.getPoints() + yourChoice.getScore();
        }

    }

    public static void main(String[] args) {

        System.out.println(getScores());
    }
}
