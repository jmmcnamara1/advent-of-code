package advent.of.code.twentytwenty2.dayTwo;

public enum ScoringTable {

    A("Rock", "C", "B", 1),
    B("Paper", "A", "C", 2),
    C("Scissors", "B", "A", 3);

    private String name;
    private String beats;
    private String beatenBy;
    private int points;


    ScoringTable(String name, String beats, String beatenBy, int points) {
        this.name = name;
        this.beats = beats;
        this.beatenBy = beatenBy;
        this.points = points;
    }

    public String getBeats() {
        return beats;
    }

    public String getBeatenBy() {
        return beatenBy;
    }

    public int getPoints() {
        return points;
    }
}
