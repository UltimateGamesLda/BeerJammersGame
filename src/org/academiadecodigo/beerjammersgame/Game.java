package org.academiadecodigo.beerjammersgame;

import org.academiadecodigo.beerjammersgame.GameObjects.Ball;
import org.academiadecodigo.beerjammersgame.GameObjects.Player;
import org.academiadecodigo.beerjammersgame.field.Collision;
import org.academiadecodigo.beerjammersgame.field.Field;
import org.academiadecodigo.beerjammersgame.keyboard.PlayerKeyboardHandler;

public class Game {

    private Player player1;
    private Player player2;
    private Ball ball;
    private Field field;
    private Collision  collision;
    private int player1DrinkedBears;
    private int player2DrinkedBears;

    public Game() {
        this.field = new Field();
        this.player1 = new Player(this.field, field.getXPlayer1());
        this.player2 = new Player(this.field, field.getXPlayer2());
        this.ball = new Ball(this.field, this.field.PADDINGX);
        this.collision = new Collision(this.field, this.player1, this.player2, this.ball);
        new PlayerKeyboardHandler(this.player1, this.player2);

    }


    public void init() {
        //criar a field e os objectos
        field.init();
    }

    public void start() throws InterruptedException {
        while (true) {

            Thread.sleep(15);

            if(!player1.gethaveBall() && !player2.gethaveBall()) {

                ball.drawInField();

                collision.check();

                checkCatch();

                checkGoal();
            }
        }
    }

    private void checkGoal() {

        if (ball.getPos().getX() + ball.getSize() == field.getPaddingX() + field.getWidth()) {
            if (ball.getPos().getY() > field.getPaddingY() && ball.getPos().getY() < field.getPaddingY() + 193) {
                player2DrinkedBears += 3;
                System.out.println("3");
            } else if (ball.getPos().getY() > field.getPaddingY() + 193 && ball.getPos().getY() < field.getPaddingY() + 387) {
                player2DrinkedBears += 5;
                System.out.println("5");
            } else {
                player2DrinkedBears += 3;
            }
            System.out.println("Player 1 Goal");
        }

        if (ball.getPos().getX() == field.getPaddingX()) {
            if (ball.getPos().getY() > field.getPaddingY() && ball.getPos().getY() < field.getPaddingY() + 193) {
                player1DrinkedBears += 3;
                System.out.println("3");
            } else if (ball.getPos().getY() > field.getPaddingY() + 193 && ball.getPos().getY() < field.getPaddingY() + 387) {
                player1DrinkedBears += 5;
                System.out.println("5");
            } else {
                player1DrinkedBears += 3;
            }
            System.out.println("Player 2 Goal");
        }
    }

    private void checkCatch() {

        if (player1CheckX() && player1CheckY() && !player1.gethaveBall()) {
            System.out.println("Player 1 Catch ball");
            player1.setHaveBall(true);
            ball.getPos().setX(player1.getPos().getX() + field.getPlayerWidth() + 25);
            ball.getPos().setY(player1.getPos().getY() + (field.getPlayerHeight() / 2));
            ball.getPos().set();
        }

        if (player2CheckX() && player2CheckY() && !player1.gethaveBall()) {
            System.out.println("Player 2 Catch ball");
            player1.setHaveBall(true);
            ball.getPos().setX(player1.getPos().getX() - 25);
            ball.getPos().setY(player1.getPos().getY() + (field.getPlayerHeight() / 2));
            ball.getPos().set();
        }
    }

    private boolean player1CheckX() {

        if (ball.getPos().getX() > player1.getPos().getX() && ball.getPos().getX() + ball.getSize() < player1.getPos().getX() + field.getPlayerWidth()) {
            return true;
        }
        return false;
    }

    private boolean player1CheckY() {
        if (ball.getPos().getY() > player1.getPos().getY() && ball.getPos().getY() + ball.getSize() < player1.getPos().getY() + field.getPlayerHeight()) {
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

