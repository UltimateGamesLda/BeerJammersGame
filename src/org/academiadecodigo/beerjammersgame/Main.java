package org.academiadecodigo.beerjammersgame;

import org.academiadecodigo.beerjammersgame.menu.Menu;
import org.academiadecodigo.beerjammersgame.objects.PlayerType;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();

        Rectangle screen = new Rectangle(10, 10, 1500, 900);
        screen.draw();

        Sound song = new Sound("/resources/GameSong.wav");
        song.play(true);

        PlayerType[] players = menu.init();

        Game game = new Game();
        game.gameStart(players);
    }
}
