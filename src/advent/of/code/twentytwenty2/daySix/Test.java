package advent.of.code.twentytwenty2.daySix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Test {


    public static void main(String[] args) {
        run();
    }

    public static void run() {

        try (BufferedReader reader = new BufferedReader(new FileReader("src/advent/of/code/twentytwenty2/daySix/data.txt"))) {
            String line = reader.readLine();
            System.out.println("Part 1: " + getMarker(line, 4));
            System.out.println("Part 2: " + getMarker(line, 14));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static int getMarker(String line, int markerSize) {
        int count = markerSize;

        for (int i =0; i<line.length()-markerSize+1; i++) {
            int[] array = line.substring(i,i+markerSize).chars().distinct().toArray();
            if (array.length==markerSize) {
                break;
            }
            count++;
        }
        return count;
    }
}
