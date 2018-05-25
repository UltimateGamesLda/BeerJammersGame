package org.academiadecodigo.beerjammersgame;

import org.academiadecodigo.beerjammersgame.menu.Menu;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import java.io.File;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();

        Rectangle screen = new Rectangle(10, 10, 1500, 900);
        screen.draw();

        Sound song = new Sound("/resources/GameSong.wav");
        //song.play(true);

        menu.init();
    }

    public static void endMenu(String[] players){
        System.out.println(players[0]);
        System.out.println(players[1]);
        Game game = new Game();
        game.gameStart();
    }
}
