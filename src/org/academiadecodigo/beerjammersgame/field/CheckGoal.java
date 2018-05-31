package org.academiadecodigo.beerjammersgame.field;

import org.academiadecodigo.beerjammersgame.GameObjects.Ball;
import org.academiadecodigo.beerjammersgame.GameObjects.Player;

public class CheckGoal implements Checkcable {

    private Player player1;
    private Player player2;
    private Ball ball;
    private Collision collision;
    private Field field;

    public CheckGoal(Player player1, Player player2, Ball ball, Collision collision, Field field){
        this.player1 = player1;
        this.player2 = player2;
        this.ball = ball;
        this.collision = collision;
        this.field = field;
    }

    public boolean check() throws InterruptedException {

        int previousplayer2DrinkedBears = player2.getDrinkedBeers();
        int previousplayer1DrinkedBears = player1.getDrinkedBeers();


        /** check if the ball touch in right limit*/
        if (collision.getPlayer2Turn() && collision.hasGoal()) {

            if (ball.getPos().getY() > field.getPaddingY() + 193 && ball.getPos().getY() < field.getPaddingY() + 387) {
                player2.addDrinkedBeers(5);
            } else {
                player2.addDrinkedBeers(3);
            }
            System.out.println("Player 1 Goal");
        }

        /** check if the ball touch in left limit */
        if (collision.getPlayer1Turn() && collision.hasGoal()) {

            if (ball.getPos().getY() > field.getPaddingY() + 193 && ball.getPos().getY() < field.getPaddingY() + 387) {
                player1.addDrinkedBeers(5);
            } else {
                player1.addDrinkedBeers(3);
            }

            System.out.println("Player 2 Goal");
        }


        if(player1.getDrinkedBeers() != previousplayer1DrinkedBears || player2.getDrinkedBeers() != previousplayer2DrinkedBears){
            return true;
        }


        return false;
    }
}
