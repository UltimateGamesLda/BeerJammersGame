package org.academiadecodigo.beerjammersgame.menu;

import org.academiadecodigo.beerjammersgame.objects.PlayerType;

public class Menu {
    public PlayerType[] init(){
        return new MenuMouseHandler().start();
    }
}
