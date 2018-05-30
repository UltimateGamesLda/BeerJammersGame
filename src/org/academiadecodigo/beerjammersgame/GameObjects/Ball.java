package org.academiadecodigo.beerjammersgame.GameObjects;

import org.academiadecodigo.beerjammersgame.field.Direction;
import org.academiadecodigo.beerjammersgame.field.Drawable;
import org.academiadecodigo.beerjammersgame.field.Field;
import org.academiadecodigo.beerjammersgame.field.Position;
import org.academiadecodigo.simplegraphics.graphics.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ball implements Drawable {
    private Position pos;
    private Field field;
    private int velocity;
    private int size;
    private Direction vertDirection;
    private Direction horizDirection;
    private String ballURL = "./Disk.png";


    public Ball(Field field, int x) {
        this.field = field;
        this.velocity = 10;
        this.size = 40;
        //pos = new Position(this.field, x, this.field.PADDINGX, size, size);
        pos = new Position(this.field,Field.PADDINGX + (Field.WIDTH / 2), Field.PADDINGY + Field.HEIGHT - 300, ballURL);
        System.out.println(Field.PADDINGX + (Field.WIDTH / 2));
        System.out.println(Field.PADDINGY + Field.HEIGHT - 300);
        this.vertDirection = Direction.DOWN;
        this.horizDirection = Direction.RIGHT;
    }

    @Override
    public void drawInField() { //to init
        pos.move();
    }


    public void changeVertDirection() {
        this.vertDirection = Direction.getOpposite(vertDirection);
    }

    public void changeHorizDirection() {
        this.horizDirection = Direction.getOpposite(horizDirection);
    }

    public void toNextPos() {
        pos.setDistanceY(vertDirection.my() * velocity);
        pos.setDistanceX(horizDirection.mx() * velocity);
    }

    public void toTopLimit() {
        pos.setDistanceY(field.PADDINGY - pos.getY());
        pos.setDistanceX(horizDirection.mx() * velocity);
    }

    public void toBottomLimit() {
        pos.setDistanceY(field.getBallMaxY() - pos.getY());
        pos.setDistanceX(horizDirection.mx() * velocity);
    }

    public void toLeftLimit() {
        pos.setDistanceX(field.PADDINGX - pos.getX());
        pos.setDistanceY(vertDirection.my() * velocity);
    }

    public void toRightLimit() {
        pos.setDistanceX(field.getBallMaxX() - pos.getX());
        pos.setDistanceY(vertDirection.my() * velocity);
    }

    public Position getPos() {
        return pos;
    }

    public Direction getHorizDirection() {
        return horizDirection;
    }

    public Direction getVertDirection() {
        return vertDirection;
    }

    public void setHorizDirection(Direction direction){
        horizDirection = direction;
    }

    public void setVertDirection(Direction direction){
        vertDirection = direction;
    }

    public int getVelocity() {
        return velocity;
    }

    public boolean isOnTopLimit() {
        return pos.getY() + vertDirection.my() * velocity <= field.PADDINGY;
    }

    public boolean isOnBottomLimit() {
        return pos.getY() + vertDirection.my() * velocity >= field.getBallMaxY();
    }

    public boolean isOnLeftLimit() {
        return pos.getX() + horizDirection.mx() * velocity <= field.PADDINGX;
    }

    public boolean isOnRightLimit() {
        return pos.getX() + horizDirection.mx() * velocity >= field.getBallMaxX();
    }

    public int getSize(){ return size; }

    public void sendToPlayer() {
        pos.setDistanceY(vertDirection.my() * (velocity - 5));
        pos.setDistanceX(horizDirection.mx() * (velocity));
        setVertDirection(Direction.UP);
        pos.move();
    }
}


//enquando tiver dentro da
//  if (pos.getY() < field.getBallMaxY()) {
//se estiver no limite inferior
// if (pos.getY() + my * velocity >= field.getBallMaxY()) {
//pos.setDistanceY(field.getBallMaxY() - pos.getY());
//my = -1;
//return;
//}

//limite superior
//if (pos.getY() + my * velocity <= field.PADDING) {
//pos.setDistanceY(field.PADDING - pos.getY());
//my = 1;
//return;
//}

//}

//if (pos.getX() < field.getBallMaxX()) {
////se estiver no limite direito
//if (pos.getX() + mx * velocity >= field.getBallMaxX()) {
//pos.setDistanceY(field.getBallMaxX() - pos.getX());
//mx = -1;
//return;
//}
//esq.
//if (pos.getX() + mx * velocity <= field.PADDING) {
//pos.setDistanceX(field.PADDING - pos.getX());
//mx = 1;
//return;
//}
//}