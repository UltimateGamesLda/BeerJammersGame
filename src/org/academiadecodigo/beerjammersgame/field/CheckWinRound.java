package org.academiadecodigo.beerjammersgame.field;

import org.academiadecodigo.beerjammersgame.GameObjects.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CheckWinRound implements Checkcable{

    private Player player1;
    private Player player2;
    private Picture finalShow;

    public CheckWinRound(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public boolean check() throws InterruptedException {

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

        return false;
    }

    public void pictureEndDraw() throws InterruptedException {
        finalShow.draw();
        Thread.sleep(5000);
        finalShow.delete();
    }
}
