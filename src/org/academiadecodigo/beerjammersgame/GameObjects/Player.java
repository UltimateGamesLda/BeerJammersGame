package org.academiadecodigo.beerjammersgame.GameObjects;

import org.academiadecodigo.beerjammersgame.field.Direction;
import org.academiadecodigo.beerjammersgame.field.Drawable;
import org.academiadecodigo.beerjammersgame.field.Field;
import org.academiadecodigo.beerjammersgame.field.Position;

public class Player extends GameObject implements Drawable {

    private Position pos;
    private Field field;
    private int velocity;
    private boolean haveBall = false;
    private boolean launch = false;

    public Player(Field field, int x) {
        this.field = field;
        this.velocity = 100;
        pos = new Position(this.field, x, field.getYPlayer(), field.getPlayerWidth(), field.getPlayerHeight());
    }


    public void setDistance(Direction direction) {
        if(!haveBall) {
            switch (direction) {
                case UP:
                    //if what he walks is bigger than the limit he goes to the limit
                    if (pos.getY() - velocity <= field.PADDINGY) {
                        pos.setDistanceY(field.PADDINGY - pos.getY());
                        break;
                    }
                    pos.setDistanceY(-velocity);
                    break;
                case DOWN:
                    if (pos.getY() + velocity >= field.getPlayerMaxY()) {
                        pos.setDistanceY(field.getPlayerMaxY() - pos.getY());
                        break;
                    }
                    pos.setDistanceY(velocity);
                    break;
                case LEFT:
                    break;
                case RIGHT:
                    break;
            }
        } else {
            switch (direction) {
                case UP:
                    if(launch){
                        haveBall = false;
                        setDistance(Direction.UP);
                    }
                case DOWN:
                    if(launch){
                        haveBall = false;
                        setDistance(Direction.DOWN);
                    }
            }
        }
    }

    @Override
    public void drawInField() { //to init
        pos.move();
    }


    public void launchBall() {
        launch = true;
    }

    public void setHaveBall(boolean state) {
        if(state){
            haveBall = true;
        } else {
            haveBall = false;
        }
    }

    public boolean gethaveBall(){
        return haveBall;
    }

    public Position getPos() {
        return pos;
    }
}