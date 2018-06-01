package org.academiadecodigo.beerjammersgame;

import org.academiadecodigo.beerjammersgame.menu.Replay;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Picture epilepsia = new Picture(10, 10,"./Epilepsia.png");
        epilepsia.draw();
        Thread.sleep(10000);
        epilepsia.delete();

        Game game = new Game();

        game.start();

        Replay replay = new Replay();

        Boolean playAgain = replay.wannaReplay();

        if(playAgain){
            game.deleteLastGame();
            main(args);
        }

        System.exit(1);

    }
}
