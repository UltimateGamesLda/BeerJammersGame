package org.academiadecodigo.beerjammersgame.field;

import org.academiadecodigo.beerjammersgame.GameObjects.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CheckWin {

    private Player player1;
    private Player player2;
    private Picture finalShow;

    public CheckWin(Player player1, Player player2, Picture finalShow){
        this.player1 = player1;
        this.player2 = player2;
        this.finalShow = finalShow;
    }

    public void playerWin() throws InterruptedException {
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
    }

    public void playerWinRound() throws InterruptedException {

        if (player1.getDrinkedBeers() == player2.getDrinkedBeers()) {
            System.out.println("Nobody Wins");
            finalShow = new Picture(10,10,"./RoundDraw.png");
            pictureEndDraw();
        } else if (player1.getDrinkedBeers() < player1.getPlayer().getBeerCapacity() && player1.getDrinkedBeers() < player2.getDrinkedBeers()){
            player1.addRoundWin();
            System.out.println("Player 1 WIN ROUND");
            finalShow = new Picture(10,10,"./Player1WinRound.png");
            pictureEndDraw();
        } else if(player2.getDrinkedBeers() < player2.getPlayer().getBeerCapacity() && player2.getDrinkedBeers() < player1.getDrinkedBeers()){
            player2.addRoundWin();
            System.out.println("Player 2 WIN ROUND");
            finalShow = new Picture(10,10,"./Player2RoundWin.png");
            pictureEndDraw();
        }

        player1.resetDrinkedBeers();
        player2.resetDrinkedBeers();

        player1.setHaveBall(false);
        player2.setHaveBall(false);
    }

    public void pictureEndDraw() throws InterruptedException {
        finalShow.draw();
        Thread.sleep(5000);
        finalShow.delete();
    }
}
