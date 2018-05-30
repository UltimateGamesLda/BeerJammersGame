package org.academiadecodigo.beerjammersgame.GameObjects;

import org.academiadecodigo.beerjammersgame.field.Direction;
import org.academiadecodigo.beerjammersgame.field.Drawable;
import org.academiadecodigo.beerjammersgame.field.Field;
import org.academiadecodigo.beerjammersgame.field.Position;
import org.academiadecodigo.beerjammersgame.keyboard.PlayerKeyboardHandler;
import org.academiadecodigo.beerjammersgame.objects.PlayerType;

public class Player extends GameObject implements Drawable {

    private String name;
    private Position pos;
    private Field field;
    private int velocity;
    private boolean haveBall = false;
    private boolean launch = false;
    private Direction sendBallDirection;
    private PlayerKeyboardHandler playerKeyboardHandler;
    private Ball ball;
    
    public Player(Field field, int x, PlayerType player, Ball ball) {
        this.field = field;
        this.velocity = player.getSpeed();
        this.name = player.toString();
        //pos = new Position(this.field, x, field.getYPlayer(), field.getPlayerWidth(), field.getPlayerHeight());
        pos = new Position(this.field, x ,field.getYPlayer(), player.geturlImage());this.ball = ball;

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
                    sendBallDirection = direction.UP;
                    System.out.println("PHELLO");
                    break;
                case DOWN:
                    sendBallDirection = direction.DOWN;
                    System.out.println("DOWN");
                    break;
                default:
                    sendBallDirection = direction.FRONT;
                    System.out.println("FRONT");
                    break;
            }
        }
    }

    @Override
    public void drawInField() { //to init
        pos.move();
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

    public boolean gethaveBall(){
        return haveBall;
    }

    public Position getPos() {
        return pos;
    }

    public String getName() {
        return name;
    }
}
