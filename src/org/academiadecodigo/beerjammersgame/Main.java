package org.academiadecodigo.beerjammersgame;

import org.academiadecodigo.beerjammersgame.menu.Replay;

public class Main {
    public static void main(String[] args) throws InterruptedException {

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
