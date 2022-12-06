package advent.of.code.twentytwenty2.dayThree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
       run();
    }


    public static void run() {

        try (BufferedReader reader = new BufferedReader(new FileReader("src/advent/of/code/twentytwenty2/dayThree/data.txt"))) {
            String line;
            int part1Total = 0;
            int part2Total = 0;
            int counter = 0;
            ArrayList<String> strings = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                strings.add(line);
                counter++;
                if (counter == 3) {
                    part2Total += getValueOfChar(findBadgeInGroup(strings));
                    counter = 0;
                    strings.clear();
                }
                part1Total += getValueOfChar(findSharedItemInBags(line));

            }
            System.out.println("Part 1 : " + part1Total);
            System.out.println("Part 2 : " + part2Total);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    public static char findBadgeInGroup(ArrayList<String> strings) {
        char[] str1 = strings.get(0).toCharArray();
        for (char s : str1) {
            if (strings.get(1).contains(String.valueOf(s)) && strings.get(2).contains(String.valueOf(s))) {
                return s;
            }
        }
        System.out.println("No match was found");
        return ' ';
    }

    public static char findSharedItemInBags(String item) {
        char[] str1 = item.substring(0, item.length() / 2).toCharArray();
        String str2 = item.substring(item.length() / 2);
        for (char s : str1) {
            if (str2.contains(String.valueOf(s))) {
                return s;
            }
        }
        System.out.println("No match was found");
        return ' ';
    }

    private static int getValueOfChar(Character i) {
        if (Character.isLowerCase(i)) {
            return i - 96;
        } else {
            return i - 38;
        }
    }
}
