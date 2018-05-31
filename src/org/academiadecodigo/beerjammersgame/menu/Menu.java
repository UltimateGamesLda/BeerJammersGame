package org.academiadecodigo.beerjammersgame.menu;

import org.academiadecodigo.beerjammersgame.Sound;
import org.academiadecodigo.beerjammersgame.GameObjects.PlayerType;

public class Menu {

    private Sound song = new Sound("/resources/GameSong.wav");

    public PlayerType[] init(){

        song.play(true);

        return new MenuMouseHandler().start();
    }

    public void stopMusic(){
        song.stop();
    }
}
