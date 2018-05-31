package org.academiadecodigo.beerjammersgame;

import org.academiadecodigo.beerjammersgame.GameObjects.Ball;
import org.academiadecodigo.beerjammersgame.GameObjects.Player;
import org.academiadecodigo.beerjammersgame.field.*;
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
    private CheckCatch catching;
    private CheckGoal checkGoal;
    private CheckWin checkWin;
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

        this.checkWin = new CheckWin(player1, player2, finalShow);
        this.catching = new CheckCatch(player1, player2, ball, field);
        this.collision = new Collision(this.field, this.player1, this.player2, this.ball);
        this.checkGoal = new CheckGoal(player1,player2, ball, collision, field);
        this.player2Score = new Text((double) ((Field.WIDTH) / 2) + Field.PADDINGX + 100, (double) (Field.PADDINGX / 2) + 15, defaultScore);
        this.player1Score = new Text((double) ((Field.WIDTH) / 2) + Field.PADDINGX - 100, (double) (Field.PADDINGX / 2) + 15, defaultScore);
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


        while (player1.getRoundWins() != 2 && player2.getRoundWins() != 2) {

            Chronometer gameTime = new Chronometer(60000);
            gameTime.start();

            while (player1.getDrinkedBeers() < player1.getPlayer().getBeerCapacity() && player2.getDrinkedBeers() < player2.getPlayer().getBeerCapacity() && gameTime.getMsLeft() > 0) {

                gameTime.tick();

                timerShow.setText(gameTime.toString());

                Thread.sleep(15);

                scoreRefresh();

                if (!player1.gethaveBall() && !player2.gethaveBall()) {

                    ball.drawInField();

                    collision.check();

                    catching.check();

                    checkGoal();

                }
            }

            playerWinRound();
            gameTime.reset();

        }

        playerWin();
    }

    private void scoreRefresh() {
        String p1Score = Integer.toString(player2.getDrinkedBeers());
        String p2Score = Integer.toString(player1.getDrinkedBeers());

        player1Score.setText(p1Score);
        player2Score.setText(p2Score);
    }

    private void playerWinRound() throws InterruptedException {

        checkWin.playerWinRound();
        resetRound();

    }

    private void playerWin() throws InterruptedException {

        checkWin.playerWin();

        ball.getPos().deletePicture();
        player1Score.delete();
        player2Score.delete();
        player1MaxBeer.delete();
        player2MaxBeer.delete();

    }

    private void resetRound() throws InterruptedException {

        ball.getPos().set(Field.PADDINGX + (Field.WIDTH / 2), Field.PADDINGY + Field.HEIGHT - 50);
        ball.setVelocity(10);

        while (!player1.gethaveBall() && !player2.gethaveBall()) {
            player1.getPos().set(field.getXPlayer1(), field.getYPlayer());
            player2.getPos().set(field.getXPlayer2(), field.getYPlayer());
            ball.sendToPlayer();
            Thread.sleep(10);
            catching.check();
        }
    }

    private void checkGoal() throws InterruptedException{

        if(checkGoal.check()){

            resetRound();

            drink.play(true);

        }
    }

    public void deleteLastGame() {
        menu.stopMusic();
        field.delete();
    }
}