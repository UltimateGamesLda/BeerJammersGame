package org.academiadecodigo.beerjammersgame.field;

import org.academiadecodigo.beerjammersgame.GameObjects.Ball;
import org.academiadecodigo.beerjammersgame.GameObjects.Player;

public class Collision {
    private Field field;

    private Ball ball;
    private boolean player1Turn;
    private boolean player2Turn;

    public Collision(Field field, Ball ball){
        this.field = field;
        this.ball = ball;
        this.player1Turn = false;
        this.player2Turn = false;
    }

    public void check(){
        fieldCollision(ball.getVertDirection());
        ball.toNextPos();
    }

    public boolean hasGoal() {

        if ((ball.getPos().getX() + ball.getSize()) < field.getPaddingX() || (ball.getPos().getX() + ball.getSize()) > (Field.WIDTH + field.PADDINGX)) {
            return true;
        }
        return false;
    }

    public void fieldCollision(Direction currentDirection) {

        /**check collision in left side of field */
        if (ball.getPos().getX() <= (field.WIDTH / 2) + field.PADDINGX) {
            this.player1Turn=true;
            this.player2Turn= false;
            verticalMovement(currentDirection);

        }
        /**check collision in right side of field */
        if (ball.getPos().getX() >= (field.WIDTH / 2) + field.PADDINGX) {
            this.player1Turn=false;
            this.player2Turn=true;
            verticalMovement(currentDirection);
        }
        /** check collision exactly in middle of field*/
        if (ball.getPos().getX() == (field.WIDTH / 2) + field.PADDINGX) {
            verticalMovement(currentDirection);
        }

    }

    private void verticalMovement(Direction currVerticalDir) {

        switch (currVerticalDir) {

            case UP:
                //if the ball are in top limit change direction to
                if (ball.isOnTopLimit()) {
                    ball.toTopLimit();
                    ball.changeVertDirection();
                }
                break;
            case DOWN:
                if (ball.isOnBottomLimit()) {
                    ball.toBottomLimit();
                    ball.changeVertDirection();
                }
                break;
        }


    }
    public boolean getPlayer1Turn(){
        return player1Turn;
    }

    public boolean getPlayer2Turn(){
        return player2Turn;
    }
}
