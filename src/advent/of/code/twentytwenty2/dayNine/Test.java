package advent.of.code.twentytwenty2.dayNine;

import java.io.BufferedReader;
import java.io.FileReader;

public class Test {

    public static void main(String[] args) {
        int startingX = 500;
        int startingY = 500;

        Head head = new Head(startingX,startingY);
        Tail tail1 = new Tail(startingX, startingY, head);
        Tail tail2 = new Tail(startingX, startingY, tail1);
        Tail tail3 = new Tail(startingX, startingY, tail2);
        Tail tail4 = new Tail(startingX, startingY, tail3);
        Tail tail5 = new Tail(startingX, startingY, tail4);
        Tail tail6 = new Tail(startingX, startingY, tail5);
        Tail tail7 = new Tail(startingX, startingY, tail6);
        Tail tail8 = new Tail(startingX, startingY, tail7);
        Tail tail9 = new Tail(startingX, startingY, tail8);
        Grid grid = new Grid(head, tail1, tail2, tail3, tail4, tail5, tail6, tail7, tail8, tail9);

        applyMovements(grid);
        int p1Score = 0;
        int[][] part1Arr = tail1.getTailLocations();
        for (int[] a: part1Arr) {
            for (int position: a) {
                if (position==1) {
                    p1Score ++;
                }
            }
        }
        System.out.println("Part 1: " + p1Score);

        int p2Score = 0;
        int[][] part2Arr = tail9.getTailLocations();
        for (int[] a: part2Arr) {
            for (int position: a) {
                if (position==1) {
                    p2Score ++;
                }
            }
        }
        System.out.println("Part 2: " + p2Score);
    }



    private static void applyMovements(Grid grid) {

        try (BufferedReader reader = new BufferedReader(new FileReader("src/advent/of/code/twentytwenty2/dayNine/data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(" ");
                Movement dir = Movement.valueOf(arr[0]);
                int magnitude = Integer.parseInt(arr[1]);
                grid.ropePositionHandler(magnitude, dir);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
