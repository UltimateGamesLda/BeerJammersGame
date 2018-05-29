package org.academiadecodigo.beerjammersgame.menu;

import org.academiadecodigo.beerjammersgame.Sound;
import org.academiadecodigo.beerjammersgame.objects.PlayerType;

public class Menu {
    public PlayerType[] init(){

        Sound song = new Sound("/resources/GameSong.wav");
        song.play(true);

        return new MenuMouseHandler().start();
    }
}
