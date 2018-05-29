package org.academiadecodigo.beerjammersgame.field;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Position {
    private Rectangle rectangle;
    private Picture picture;
    private int x;
    private int y;
    private int distanceX;
    private int distanceY;
    private Field field;


    public Position(Field field, int x, int y , int sizeX, int sizeY) {
        this.field = field;
        this.x = x;
        this.y = y;
        this.distanceX = 0;
        this.distanceY = 0;

        rectangle = new Rectangle(x, y, sizeX, sizeY);
        rectangle.draw();
    }

    public Position(Field field, int x, int y , String imageURL) {
        this.field = field;
        this.x = x;
        this.y = y;
        this.distanceX = 0;
        this.distanceY = 0;

        picture = new Picture(x, y, imageURL);
        picture.draw();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //

    public void move() {
        x += distanceX;
        y += distanceY;
        if(rectangle != null){
        rectangle.translate(distanceX, distanceY);
        } else {
            picture.translate(distanceX, distanceY);
        }
        distanceX = 0;
        distanceY = 0;

    }

    public void set(double newX, double newY){
        double previousX = x;
        double previousY = y;
        x = (int) newX;
        y = (int) newY;
        picture.translate(newX - previousX, newY - previousY);



    }

    public int getDistanceX() {
        return distanceX;
    }

    public void setDistanceX(int distanceX) {
        this.distanceX = distanceX;
    }

    public int getDistanceY() {
        return distanceY;
    }

    public void setDistanceY(int distanceY) {
        this.distanceY = distanceY;
    }

}


