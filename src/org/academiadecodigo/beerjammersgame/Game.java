package org.academiadecodigo.beerjammersgame;

import org.academiadecodigo.beerjammersgame.GameObjects.Ball;
import org.academiadecodigo.beerjammersgame.GameObjects.Player;
import org.academiadecodigo.beerjammersgame.field.Collision;
import org.academiadecodigo.beerjammersgame.field.Field;
import org.academiadecodigo.beerjammersgame.keyboard.PlayerKeyboardHandler;
import org.academiadecodigo.beerjammersgame.GameObjects.PlayerType;
import org.academiadecodigo.beerjammersgame.menu.Menu;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Menu menu;
    private Player player1;
    private Player player2;
    private Ball ball;
    private Field field;
    private Collision collision;
    private int player1DrinkedBears;
    private int player2DrinkedBears;
    private int player1RoundsWin;
    private int player2RoundsWin;
    private Sound drink = new Sound("/resources/Drink.wav");
    private Text player1Score;
    private Text player2Score;
    private Text player1MaxBeer;
    private Text player2MaxBeer;
    private String defaultScore = "0";
    private Text timerShow;

    private Picture finalShow;


    public Game() throws InterruptedException {

        menu = new Menu();
        PlayerType[] playersTYPE = menu.init();

        this.field = new Field();
        field.drawInField();

        this.ball = new Ball(this.field, this.field.PADDINGX);
        this.player1 = new Player(this.field, field.getXPlayer1(), playersTYPE[0], ball, field.getPlayer1maxX());
        this.player2 = new Player(this.field, field.getXPlayer2(), playersTYPE[1], ball, field.getPlayer2maxX());

        new PlayerKeyboardHandler(this.player1, this.player2);

        this.collision = new Collision(this.field, this.player1, this.player2, this.ball);
        this.player1Score = new Text((double) ((Field.WIDTH) / 2) + Field.PADDINGX - 100, (double) (Field.PADDINGX / 2) + 15, defaultScore);
        this.player2Score = new Text((double) ((Field.WIDTH) / 2) + Field.PADDINGX + 100, (double) (Field.PADDINGX / 2) + 15, defaultScore);
        this.player1MaxBeer = new Text((double) (Field.PADDINGX / 3), (double) (Field.PADDINGY) + 10, Integer.toString(playersTYPE[0].getBeerCapacity()));
        this.player2MaxBeer = new Text((double) (Field.PADDINGX / 2) + Field.WIDTH + Field.PADDINGX, (double) (Field.PADDINGY) + 10, Integer.toString(playersTYPE[1].getBeerCapacity()));
        this.timerShow = new Text((double) ((Field.WIDTH) / 2) + Field.PADDINGX - 10, (double) (Field.PADDINGX / 2) + 15, defaultScore);

        timerShow.draw();
        timerShow.grow(25, 25);
        timerShow.setColor(Color.YELLOW);

        player1Score.draw();
        player1Score.grow(30, 30);
        player1Score.setColor(Color.RED);

        player2Score.draw();
        player2Score.grow(30, 30);
        player2Score.setColor(Color.RED);

        player1MaxBeer.draw();
        player1MaxBeer.grow(40, 40);
        player1MaxBeer.setColor(Color.ORANGE);

        player2MaxBeer.draw();
        player2MaxBeer.grow(40, 40);
        player2MaxBeer.setColor(Color.ORANGE);

    }



    public void start() throws InterruptedException {


        while (player1RoundsWin != 2 && player2RoundsWin != 2) {

            Chronometer gameTime = new Chronometer(60000);
            gameTime.start();

            while (player1DrinkedBears < player1.getPlayer().getBeerCapacity() && player2DrinkedBears < player2.getPlayer().getBeerCapacity() && gameTime.getMsLeft() > 0) {

                gameTime.tick();

                timerShow.setText(gameTime.toString());

                Thread.sleep(15);

                if (!player1.gethaveBall() && !player2.gethaveBall()) {

                    ball.drawInField();

                    collision.check();

                    checkCatch();

                    checkGoal();

                }
            }

            playerWinRound();
            gameTime.reset();

        }

        playerWin();
    }
    private void checkGoal() throws InterruptedException {

        int previousplayer2DrinkedBears = player2DrinkedBears;
        int previousplayer1DrinkedBears = player1DrinkedBears;


            /** check if the ball touch in right limit*/
            if (collision.getPlayer2Turn() && collision.hasGoal()) {

                if (ball.getPos().getY() > field.getPaddingY() && ball.getPos().getY() < field.getPaddingY() + 193) {
                    player2DrinkedBears += 3;
                } else if (ball.getPos().getY() > field.getPaddingY() + 193 && ball.getPos().getY() < field.getPaddingY() + 387) {
                    player2DrinkedBears += 5;
                } else {
                    player2DrinkedBears += 3;
                }
                System.out.println("Player 1 Goal");
            }

            /** check if the ball touch in left limit */
            if (collision.getPlayer1Turn() && collision.hasGoal()) {

                if (ball.getPos().getY() > field.getPaddingY() && ball.getPos().getY() < field.getPaddingY() + 193) {
                    player1DrinkedBears += 3;
                } else if (ball.getPos().getY() > field.getPaddingY() + 193 && ball.getPos().getY() < field.getPaddingY() + 387) {
                    player1DrinkedBears += 5;
                } else {
                    player1DrinkedBears += 3;
                }

                System.out.println("Player 2 Goal");
            }


        if(player1DrinkedBears != previousplayer1DrinkedBears || player2DrinkedBears != previousplayer2DrinkedBears){
            drink.play(true);
            resetRound();
        }

        String p1Score = Integer.toString(player1DrinkedBears);
        String p2Score = Integer.toString(player2DrinkedBears);

        player1Score.setText(p1Score);
        player2Score.setText(p2Score);

    }

    private void resetRound() throws InterruptedException {

        ball.getPos().set(Field.PADDINGX + (Field.WIDTH / 2), Field.PADDINGY + Field.HEIGHT - 50);
        ball.setVelocity(10);

        while (!player1.gethaveBall() && !player2.gethaveBall()) {
            player1.getPos().set(field.getXPlayer1(), field.getYPlayer());
            player2.getPos().set(field.getXPlayer2(), field.getYPlayer());
            ball.sendToPlayer();
            Thread.sleep(10);
            checkCatch();
        }
    }

    private void checkCatch() {

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

    private void playerWin() throws InterruptedException {
        if (player1RoundsWin == 2){
            System.out.println("Player 1 WIN");
            finalShow = new Picture(10,10,"./Player1Win.png");
            pictureEndDraw();
        } else {
            System.out.println("Player 2 WIN");
            finalShow = new Picture(10,10,"./Player2Win.png");
            pictureEndDraw();
        }

        player1.getPos().deletePicture();
        player2.getPos().deletePicture();
        ball.getPos().deletePicture();
        player1Score.delete();
        player2Score.delete();
        player1MaxBeer.delete();
        player2MaxBeer.delete();
    }

    private void playerWinRound() throws InterruptedException {

        if (player1DrinkedBears == player2DrinkedBears) {
            System.out.println("Nobody Wins");
            finalShow = new Picture(10,10,"./RoundDraw.png");
            pictureEndDraw();
        } else if (player1DrinkedBears < player1.getPlayer().getBeerCapacity() && player1DrinkedBears < player2DrinkedBears){
            player1RoundsWin++;
            System.out.println("Player 1 WIN ROUND");
            finalShow = new Picture(10,10,"./Player1WinRound.png");
            pictureEndDraw();
        } else if(player2DrinkedBears < player2.getPlayer().getBeerCapacity() && player2DrinkedBears < player1DrinkedBears){
            player2RoundsWin++;
            System.out.println("Player 2 WIN ROUND");
            finalShow = new Picture(10,10,"./Player2RoundWin.png");
            pictureEndDraw();
        }

        player1DrinkedBears = 0;
        player2DrinkedBears = 0;

        player1.setHaveBall(false);
        player2.setHaveBall(false);

        resetRound();
    }

    public void pictureEndDraw() throws InterruptedException {
        finalShow.draw();
        System.out.println("asdjkhjaklsd");
        Thread.sleep(5000);
        finalShow.delete();
    }


    public void deleteLastGame() {
        menu.stopMusic();
        field.delete();
    }
}