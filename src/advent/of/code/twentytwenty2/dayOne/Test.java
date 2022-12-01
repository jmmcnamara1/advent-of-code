package advent.of.code.twentytwenty2.dayOne;

import java.io.BufferedReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class Test {


    public static void main(String[] args) {
        run();
    }


    public static void run() {

        ArrayList<Integer> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/advent/of/code/twentytwenty2/dayOne/data.txt"))) {
            String line;
            int elfTotal = 0;
            while ((line = reader.readLine()) != null) {

                if (line.isBlank()) {
                    list.add(elfTotal);
                    elfTotal = 0;
                } else {
                    elfTotal += Integer.parseInt(line);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Integer totalCalories = 0;

        for(int i = 0; i<3; i++){
            Optional<Integer> maxCalories = list.stream().max(Comparator.comparingInt(a -> a));
            if (maxCalories.isPresent()) {
                if (i==0) {
                    System.out.println("Part 1: " + maxCalories.get());
                }
                totalCalories += maxCalories.get();
                list.remove(maxCalories.get());
            }
        }


        System.out.println("Part 2: " + totalCalories);




    }




}
