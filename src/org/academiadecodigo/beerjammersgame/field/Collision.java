package org.academiadecodigo.beerjammersgame.field;

import org.academiadecodigo.beerjammersgame.GameObjects.Ball;
import org.academiadecodigo.beerjammersgame.GameObjects.Player;

public class Collision {
    private Field field;
    private Player player1;
    private Player player2;
    private Ball ball;
    private boolean player1Turn;
    private boolean player2Turn;
    private boolean goal;

    public Collision(Field field, Player player1, Player player2, Ball ball){
        this.field = field;
        this.player1 = player1;
        this.player2 = player2;
        this.ball = ball;
        this.player1Turn =false;
        this.player2Turn =false;
        this.goal=false;
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
