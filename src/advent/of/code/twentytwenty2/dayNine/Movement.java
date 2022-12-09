package advent.of.code.twentytwenty2.dayNine;

public enum Movement {

    R("i", 1),
    L("i", -1),
    U("j", 1),
    D("j", -1);

    private String axis;
    private int direction;

    Movement(String axis, int direction) {
        this.axis = axis;
        this.direction = direction;
    }

    public String getAxis() {
        return axis;
    }

    public int getDirection() {
        return direction;
    }
}
