package org.academiadecodigo.beerjammersgame;

import org.academiadecodigo.beerjammersgame.menu.Menu;
import org.academiadecodigo.beerjammersgame.menu.Replay;
import org.academiadecodigo.beerjammersgame.objects.PlayerType;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Menu menu = new Menu();

        PlayerType[] players = menu.init();

        Picture field = new Picture(10, 10, "./Field.png");
        field.draw();

        Game game = new Game(players);
        game.start();

        Replay replay = new Replay();

        Boolean playAgain = replay.wannaReplay();

        if(playAgain){
            menu.stopMusic();
            field.delete();
            main(args);
        }

        System.exit(1);
    }
}
