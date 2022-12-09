package advent.of.code.twentytwenty2.dayNine;

public class Head extends Knot {

    public Head(int xPosition, int yPosition) {
        super(xPosition, yPosition);
    }

    public void move(int move, String dir) {
        if ("i".equals(dir)) {
            setXPosition(getXPosition()+move);
        } else {
            setYPosition(getYPosition()+move);
        }
    }

}
