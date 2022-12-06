package advent.of.code.twentytwenty2.dayTwo.part2;

public enum Strategy {


    X("Lose", 0),
    Y("Draw", 3),
    Z("Win", 6);

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
