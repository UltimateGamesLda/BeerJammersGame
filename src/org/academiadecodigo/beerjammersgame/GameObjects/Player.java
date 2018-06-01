package org.academiadecodigo.beerjammersgame.GameObjects;

import org.academiadecodigo.beerjammersgame.field.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends GameObject implements Drawable, Movable {

    private Position pos;
    private Field field;
    private int velocity;
    private boolean haveBall = false;
    private boolean launch = false;
    private volatile Direction sendBallDirection;
    private Ball ball;
    private PlayerType player;
    private int maxX;
    private int drinkedBeers;
    private int roundWins;
    
    public Player(Field field, int x, PlayerType player, Ball ball, int playerMaxX) {
        this.field = field;
        this.velocity = player.getSpeed();
        this.player = player;
        this.ball = ball;
        this.maxX = playerMaxX;
        pos = new Position(x ,field.getYPlayer(), drawInField(x, field.getYPlayer(), player.geturlImage()));
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
                    if (pos.getX() - velocity <= maxX) {
                        pos.setDistanceX(maxX - pos.getX());
                        break;
                    }
                    pos.setDistanceX(-velocity);
                    break;
                case RIGHT:
                    if (pos.getX() + velocity >= maxX + (Field.WIDTH / 3)) {
                        pos.setDistanceX(maxX + (Field.WIDTH / 3) - pos.getX());
                        break;
                    }
                    pos.setDistanceX(velocity);
                    break;
            }
        } else {
            ball.setVelocity(player.getStrength());
            switch (direction) {
                case UP:
                    sendBallDirection = direction.UP;
                    break;
                case DOWN:
                    sendBallDirection = direction.DOWN;
                    break;
                default:
                    sendBallDirection = direction.FRONT;
                    break;
            }
        }
    }

    @Override
    public void move() {
        if(!haveBall){
            pos.move();
        }
    }

    @Override
    public Picture drawInField(int x, int y,String imageURL) { //to init
        Picture picture = new Picture(x, y, imageURL);
        picture.draw();
        return picture;
    }


    private void sendBall(Direction direction) {

        if(direction == Direction.UP) {
            ball.setVertDirection(Direction.UP);
            ball.changeHorizDirection();
        }

        if(direction == Direction.DOWN) {
            ball.setVertDirection(Direction.DOWN);
            ball.changeHorizDirection();
        }

        if (direction == Direction.FRONT) {
            ball.setVertDirection(Direction.FRONT);
            ball.setVelocity((int)(player.getStrength() * 1.5));
            ball.changeHorizDirection();
        }

        launch = false;
        haveBall = false;
        sendBallDirection = null;

    }

    public void launchBall(){

        if(haveBall == true) {
            launch = true;
        }

        if(launch && sendBallDirection != null){
            sendBall((sendBallDirection));
        }
    }

    public void setHaveBall(boolean state) {
        if(state){
            haveBall = true;
        } else {
            haveBall = false;
        }
    }

    public void addDrinkedBeers(int ammount){
        drinkedBeers += ammount;
    }

    public int getDrinkedBeers(){
        return drinkedBeers;
    }

    public void addRoundWin(){
        roundWins++;
    }

    public int getRoundWins(){
        return roundWins;
    }

    public void resetRoundWins(){
        roundWins = 0;
    }

    public PlayerType getPlayer() {
        return player;
    }

    public boolean gethaveBall(){
        return haveBall;
    }

    public void resetDrinkedBeers(){
        drinkedBeers = 0;
    }

    public Position getPos() {
        return pos;
    }
}
