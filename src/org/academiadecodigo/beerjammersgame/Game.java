package org.academiadecodigo.beerjammersgame;

import org.academiadecodigo.beerjammersgame.GameObjects.Ball;
import org.academiadecodigo.beerjammersgame.GameObjects.Player;
import org.academiadecodigo.beerjammersgame.field.Catch;
import org.academiadecodigo.beerjammersgame.field.CheckGoal;
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
    private Catch catching;
    private CheckGoal checkGoal;
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

        this.catching = new Catch(player1, player2, ball, field);
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

                    catching.checkCatch();

                    checkGoal();

                }
            }

            playerWinRound();
            gameTime.reset();

        }

        playerWin();
    }

    private void resetRound() throws InterruptedException {

        ball.getPos().set(Field.PADDINGX + (Field.WIDTH / 2), Field.PADDINGY + Field.HEIGHT - 50);
        ball.setVelocity(10);

        while (!player1.gethaveBall() && !player2.gethaveBall()) {
            player1.getPos().set(field.getXPlayer1(), field.getYPlayer());
            player2.getPos().set(field.getXPlayer2(), field.getYPlayer());
            ball.sendToPlayer();
            Thread.sleep(10);
            catching.checkCatch();
        }
    }

    private void checkGoal() throws InterruptedException{

        if(checkGoal.checkGoal()){
            resetRound();

            drink.play(true);

            String p1Score = Integer.toString(player2.getDrinkedBeers());
            String p2Score = Integer.toString(player1.getDrinkedBeers());

            player1Score.setText(p1Score);
            player2Score.setText(p2Score);
        }
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