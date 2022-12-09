package advent.of.code.twentytwenty2.dayNine;

import java.util.LinkedList;

public class Grid {

    private Head head;
    private LinkedList<Tail> tails ;

    public Grid(Head head, Tail... tails) {
        this.head = head;
        this.tails = new LinkedList<>();
        for (Tail tail : tails) {
            this.tails.add(tail);
        }
    }

    public void ropePositionHandler(int magnitudeOfMov, Movement movement) {
        for (int i=0; i<magnitudeOfMov; i++) {
            head.move(movement.getDirection(), movement.getAxis());
            for (Tail tail : tails) {
                tail.move();
            }
        }
    }

}
