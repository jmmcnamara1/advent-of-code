package advent.of.code.twentytwenty2.dayTwo.part1;

public enum Strategy {


    X("A", 1),
    Y("B", 2),
    Z("C", 3);

    private String name;
    private int score;

    Strategy(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
