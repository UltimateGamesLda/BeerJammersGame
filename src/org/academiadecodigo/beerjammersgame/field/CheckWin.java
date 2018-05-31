package org.academiadecodigo.beerjammersgame.field;

import org.academiadecodigo.beerjammersgame.GameObjects.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CheckWin implements Checkcable {

    private Player player1;
    private Player player2;
    private Picture finalShow;

    public CheckWin(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public boolean check() throws InterruptedException {
        if (player1.getRoundWins() == 2){
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

        return false;
    }

    public void pictureEndDraw() throws InterruptedException {
        finalShow.draw();
        Thread.sleep(5000);
        finalShow.delete();
    }
}
