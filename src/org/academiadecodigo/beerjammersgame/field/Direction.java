package org.academiadecodigo.beerjammersgame.field;

public enum Direction {
    UP(0, -1 ),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private int mx;
    private int my;


    Direction(int mx, int my) {
        this.mx = mx;
        this.my = my;
    }

    public int mx() {
        return mx;
    }

    public int my() {
        return my;
    }

    public static Direction getOpposite( Direction direction) {

        Direction opposite = UP;
       switch (direction){
           case UP:
               opposite = DOWN;
               break;
           case DOWN:
                opposite = UP;
                break;
           case LEFT:
               opposite = RIGHT;
               break;
           case RIGHT:
               opposite = LEFT;
               break;
       }
       return opposite;
    }
}

