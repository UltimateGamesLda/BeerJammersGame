package org.academiadecodigo.beerjammersgame;

import org.academiadecodigo.beerjammersgame.menu.Menu;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        Rectangle screen = new Rectangle(10, 10, 1500, 900);
        screen.draw();

        menu.init();


    }
}
