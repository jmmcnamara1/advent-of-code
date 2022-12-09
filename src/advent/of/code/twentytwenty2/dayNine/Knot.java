package advent.of.code.twentytwenty2.dayNine;

public abstract class Knot {

    private int[] position = new int[2];


    public Knot(int xPosition, int yPosition) {
        this.position[0] = xPosition;
        this.position[1] = yPosition;
    }
    protected void setYPosition(int newPosition) {
        this.position[1] = newPosition;
    }

    protected void setXPosition(int newPosition) {
        this.position[0] = newPosition;
    }

    public int getYPosition() {
        return position[1];
    }

    public int getXPosition() {
        return position[0];
    }

}
