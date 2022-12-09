package advent.of.code.twentytwenty2.dayNine;
public class Tail extends Knot {

    private Knot parentKnot;
    private int[][] tailLocations = new int[1000][1000];

    public Tail(int xPosition, int yPosition, Knot parentKnot) {
        super(xPosition, yPosition);
        setTailPositions(xPosition, yPosition);
        this.parentKnot = parentKnot;
    }

    public void move() {
        if (!isNextToHead(parentKnot.getXPosition(), parentKnot.getYPosition())) {
            int xDiff = parentKnot.getXPosition()-this.getXPosition();
            int yDiff = parentKnot.getYPosition()-this.getYPosition();
            setXPosition(this.getXPosition() + getMove(xDiff));
            setYPosition(this.getYPosition() + getMove(yDiff));

            setTailPositions(this.getXPosition(), this.getYPosition());
        }
    }
    private int getMove(int diff) {
        int move = diff;
        if (diff<-1) {
            move = diff + 1;
        } else if (diff > 1){
            move = diff -1;
        }
        return move;
    }

    private boolean isNextToHead(int headXPos, int headYPos) {
        if (Math.abs(headXPos-this.getXPosition())<2 && Math.abs(headYPos-this.getYPosition())<2) {
            return true;
        }
        return false;
    }

    public void setTailPositions(int tailXPos, int tailYPos) {
        this.tailLocations[tailXPos][tailYPos] = 1;
    }

    public int[][] getTailLocations() {
        return tailLocations;
    }
}
