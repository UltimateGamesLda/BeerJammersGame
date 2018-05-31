package org.academiadecodigo.beerjammersgame.field;

import org.academiadecodigo.beerjammersgame.GameObjects.Ball;
import org.academiadecodigo.beerjammersgame.GameObjects.Player;

public class Catch implements Catchable {
    private Player player1;
    private Player player2;
    private Ball ball;
    private Field field;


    public Catch(Player player1, Player player2, Ball ball, Field field) {
        this.player1 = player1;
        this.player2 = player2;
        this.ball = ball;
        this.field = field;
    }

    public void checkCatch() {

        if (player1CheckX() && player1CheckY() && !player1.gethaveBall()) {
            System.out.println("Player 1 Catch ball");
            player1.setHaveBall(true);
            System.out.println((player1.getPos().getX() + field.getPlayerWidth() + 10));
            ball.getPos().set((player1.getPos().getX() + field.getPlayerWidth() + 10), (player1.getPos().getY() + (field.getPlayerHeight() / 2)));
            return;
        }

        if (player2CheckX() && player2CheckY() && !player2.gethaveBall()) {
            System.out.println("Player 2 Catch ball");
            player2.setHaveBall(true);
            System.out.println((player2.getPos().getX() - 55));
            ball.getPos().set((player2.getPos().getX() - 55), (player2.getPos().getY() + (field.getPlayerHeight() / 2)));
            return;
        }
    }

    private boolean player1CheckX() {

        if (ball.getPos().getX() + ball.getSize() > player1.getPos().getX() && ball.getPos().getX() + ball.getSize() < player1.getPos().getX() + field.getPlayerWidth()) {
            return true;
        }
        return false;
    }


    private boolean player1CheckY() {
        if (ball.getPos().getY() + ball.getSize() > player1.getPos().getY() && ball.getPos().getY() + ball.getSize() < player1.getPos().getY() + field.getPlayerHeight()) {
            return true;
        }
        return false;
    }

    private boolean player2CheckX() {

        if (ball.getPos().getX() + ball.getSize() > player2.getPos().getX() && ball.getPos().getX() + ball.getSize() < player2.getPos().getX() + field.getPlayerWidth()) {
            return true;
        }
            return false;
        }

    private boolean player2CheckY() {
        if (ball.getPos().getY() + ball.getSize() > player2.getPos().getY() && ball.getPos().getY() + ball.getSize() < player2.getPos().getY() + field.getPlayerHeight()) {
            return true;
        }
        return false;
    }
}

