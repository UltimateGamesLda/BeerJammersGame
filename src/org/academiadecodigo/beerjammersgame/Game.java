package org.academiadecodigo.beerjammersgame;

import org.academiadecodigo.beerjammersgame.GameObjects.Ball;
import org.academiadecodigo.beerjammersgame.GameObjects.Player;
import org.academiadecodigo.beerjammersgame.field.Collision;
import org.academiadecodigo.beerjammersgame.field.Field;
import org.academiadecodigo.beerjammersgame.field.Position;
import org.academiadecodigo.beerjammersgame.keyboard.PlayerKeyboardHandler;
import org.academiadecodigo.beerjammersgame.objects.PlayerType;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;


public class Game {

    private Player player1;
    private Player player2;
    private Ball ball;
    private Field field;
    private Collision  collision;
    private int player1DrinkedBears;
    private int player2DrinkedBears;
    private Sound drink = new Sound("/resources/Drink.wav");
    private Text player1Score;
    private Text player2Score;
    private String p1Score;
    private String p2Score;

    public Game(PlayerType[] players) {

        this.field = new Field();
        this.ball = new Ball(this.field, this.field.PADDINGX);
        this.player1 = new Player(this.field, field.getXPlayer1(), players[0], ball);
        this.player2 = new Player(this.field, field.getXPlayer2(), players[1], ball);
        this.collision = new Collision(this.field, this.player1, this.player2, this.ball);
        new PlayerKeyboardHandler(this.player1, this.player2);
        this.p1Score = "0";
        this.player1Score = new Text((double)((Field.WIDTH)/2)+Field.PADDINGX -100,(double)(Field.PADDINGX/2)+15,p1Score);
        this.p2Score = "0";
        this.player2Score = new Text((double)((Field.WIDTH)/2)+Field.PADDINGX +100,(double)(Field.PADDINGX/2)+15,p1Score);

        player1Score.draw();
        player1Score.grow(30,30);
        player1Score.setColor(Color.RED);

        player2Score.draw();
        player2Score.grow(30,30);
        player2Score.setColor(Color.RED);
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

        int previousplayer2DrinkedBears = player2DrinkedBears;
        int previousplayer1DrinkedBears = player1DrinkedBears;



            /** check if the ball touch in right limit*/
            if (collision.getPlayer2Turn() && collision.hasGoal()) {

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

            /** check if the ball touch in left limit */
            if (collision.getPlayer1Turn() && collision.hasGoal()) {

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


        if(player1DrinkedBears != previousplayer1DrinkedBears || player2DrinkedBears != previousplayer2DrinkedBears){
            drink.play(true);
            ball.getPos().set(Field.PADDINGX + (Field.WIDTH / 2), Field.PADDINGY + Field.HEIGHT - 50);
            player1.getPos().set(field.getXPlayer1(),field.getYPlayer());
            player2.getPos().set(field.getXPlayer2(),field.getYPlayer());
        }
        String p1Score= Integer.toString(player1DrinkedBears);
        String p2Score = Integer.toString(player2DrinkedBears);

        player1Score.setText(p1Score);
        player2Score.setText(p2Score);
    }

    private void checkCatch() {

        if (player1CheckX() && player1CheckY() && !player1.gethaveBall()) {
            System.out.println("Player 1 Catch ball");
            player1.setHaveBall(true);
            ball.getPos().set((player1.getPos().getX() + field.getPlayerWidth() + 10), (player1.getPos().getY() + (field.getPlayerHeight() / 2)));
        }

        if (player2CheckX() && player2CheckY() && !player2.gethaveBall()) {
            System.out.println("Player 2 Catch ball");
            player2.setHaveBall(true);
            ball.getPos().set((player2.getPos().getX() - 55), (player2.getPos().getY() + (field.getPlayerHeight() / 2)));
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

