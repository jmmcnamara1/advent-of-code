package advent.of.code.twentytwenty2.daySeven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Test {


    public static ArrayList<Directory> arr = new ArrayList<>();
    public static ArrayList<Integer> directorySizes = new ArrayList<>();

    public static void main(String[] args) {
        getFileStructure();
        System.out.println("Part 1 : "  + getFileSizes());
        System.out.println("Part 2 : " + getSmallestDirToDelete());
    }

    private static int getSmallestDirToDelete() {
        Collections.sort(directorySizes);
        int spaceNeeded =   30000000 - (70000000 - directorySizes.get(directorySizes.size()-1));
        for (Integer i : directorySizes) {
            if (i>spaceNeeded) {
                return i;
            }
        }
        return 0;
    }

    private static int getFileSizes() {
        int totalMemory = 0;
        for (Directory entry : arr) {
            ArrayList<Integer> arr = entry.getAllSubFiles();
            int sum = 0;
            for (Integer i: arr) {
                sum+=i;
            }
            directorySizes.add(sum);
            if (sum < 100000) {
                totalMemory += sum;
            }
        }
        return totalMemory;
    }

    public static void getFileStructure() {

        Directory root = new Directory("/");
        arr.add(root);
        Directory currentDir = root;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/advent/of/code/twentytwenty2/daySeven/data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("$")) {
                    String[] command = line.split(" ");
                    switch (command[1]) {
                        case "cd":
                            switch (command[2]){
                                case "/":
                                    break;
                                case "..":
                                currentDir = currentDir.getParentDir();
                                break;
                                default:
                                    for(Directory child : currentDir.getChildren()) {
                                        if (child.getName().equals(command[2])) {
                                            currentDir = child;
                                        }
                                    }
                            }

                    }
                } else {
                    String[] command = line.split(" ");
                    switch (command[0]) {
                        case "dir":
                            Directory newDir = new Directory(line.substring(4), currentDir);
                            arr.add(newDir);
                            break;
                        default:
                            currentDir.addFiles(Integer.parseInt(command[0]));
                    }
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }





}
