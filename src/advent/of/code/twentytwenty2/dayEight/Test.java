package advent.of.code.twentytwenty2.dayEight;

import java.io.BufferedReader;
import java.io.FileReader;

public class Test {

    public static void main(String[] args) {

        run();
        fillOutCountArray();
        fillOutScoreArray();

        int totalTrees=0;
        for (int i =0; i<xAxisTrees; i++) {
            for (int j=0; j<yAxisTrees; j++) {
                if (countArr[i][j]==1) {
                    totalTrees++;
                }
            }}
        int highestScore = 0;
        for (int i =0; i<xAxisTrees; i++) {
            for (int j=0; j<yAxisTrees; j++) {
                if (scoreArr[i][j]>highestScore) {
                    highestScore = scoreArr[i][j];
                }
            }}
        System.out.println("Part 1: " + totalTrees);
        System.out.println("Part 2: " + highestScore);
    }



    private static int[][] treeGrid;
    private static int[][] countArr;
    private static int[][] scoreArr;
    private static int xAxisTrees = 0;
    private static int yAxisTrees = 0;

    private static void fillOutScoreArray() {

        for (int i =0; i<xAxisTrees; i++) {
            for (int j=0; j<yAxisTrees; j++) {
                if (countArr[i][j] == 1) {

                    scoreArr[i][j] = returnScore(i,j);

                }
            }
        }
    }

    private static int returnScore(int x, int y) {
        if (x==0||y==0||x==(treeGrid.length)-1||y==(treeGrid.length)-1) {
            return 0;
        }
        int height = treeGrid[x][y];
        //      Right visibility
        int visibleRight = 0;
        for (int i =x+1; i<xAxisTrees; i++) {
                if (treeGrid[i][y] < height) {
                    visibleRight ++;
                } else {
                    visibleRight ++;
                    break;
                }
        }
        //      Left visibility
        int visibleLeft = 0;
        for (int i =x-1; i>=0; i--) {
            if (treeGrid[i][y] < height) {
                visibleLeft ++;
            } else {
                visibleLeft ++;
                break;
            }
        }
        //      Up visibility
        int visibleUp = 0;
        for (int j =y+1; j<yAxisTrees; j++) {
            if (treeGrid[x][j] < height) {
                visibleUp ++;
            } else {
                visibleUp ++;
                break;
            }
        }
        //      Down visibility
        int visibleDown = 0;
        for (int j =y-1; j>=0; j--) {
            if (treeGrid[x][j] < height) {
                visibleDown ++;
            } else {
                visibleDown ++;
                break;
            }
        }

        return visibleUp * visibleDown * visibleLeft * visibleRight;
    }

    private static void fillOutCountArray() {

        int currentTallestTree = -1;
        for (int i =0; i<xAxisTrees; i++) {
            for (int j=0; j<yAxisTrees; j++) {
                int targetTree = treeGrid[i][j];
                if (targetTree>currentTallestTree) {
                    currentTallestTree = targetTree;
                    countArr[i][j] = 1;
                }
            }
            currentTallestTree = -1;
        }

        for (int i =0; i<xAxisTrees; i++) {
            for (int j=0; j<yAxisTrees; j++) {
                int targetTree = treeGrid[j][i];
                if (targetTree>currentTallestTree) {
                    currentTallestTree = targetTree;
                    countArr[j][i] = 1;
                }
            }
            currentTallestTree = -1;
        }
        for (int i = treeGrid.length-1; i>=0; i--) {
            for (int j = treeGrid[i].length-1; j>=0; j--) {
                int targetTree = treeGrid[i][j];
                if (targetTree>currentTallestTree) {
                    currentTallestTree = targetTree;
                    countArr[i][j] = 1;
                }
            }
            currentTallestTree = -1;
        }
        for (int i = treeGrid.length-1; i>=0; i--) {
            for (int j = treeGrid[i].length-1; j>=0; j--) {
                int targetTree = treeGrid[j][i];
                if (targetTree>currentTallestTree) {
                    currentTallestTree = targetTree;
                    countArr[j][i] = 1;
                }
            }
            currentTallestTree = -1;
        }
    }



    private static void run() {

        try (BufferedReader reader = new BufferedReader(new FileReader("src/advent/of/code/twentytwenty2/dayEight/data.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (xAxisTrees == 0) {
                    xAxisTrees = line.length();
                    treeGrid = new int[xAxisTrees][xAxisTrees];
                    countArr = new int[xAxisTrees][xAxisTrees];
                    scoreArr = new int[xAxisTrees][xAxisTrees];
                }
                for (int i = 0; i<line.length(); i++) {
                    int c =  Integer.parseInt(String.valueOf(line.charAt(i)));
                    treeGrid[i][yAxisTrees] = c;
                }
                yAxisTrees ++;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
