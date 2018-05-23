package org.academiadecodigo.beerjammersgame.menu;

import org.academiadecodigo.simplegraphics.mouse.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class MenuMouseHandler implements MouseHandler {

    //Rectangle initMenu = new Rectangle(50, 50, 50, 50);

    Picture initMenu = new Picture(10,10, "./BeerJammersMenuInit.png");
    Picture selectMenu = new Picture(10,10, "./BeerJammersMenuInit.png");

    public MenuMouseHandler() {

        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

        //initMenu.setColor(Color.RED);
        initMenu.draw();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println(e);
        if(e.getX() >= 520 && e.getX() <= 980 && e.getY() >= (530) && e.getY() <= (700)){
            System.out.println("You press Start Button");
            selectMenu.draw();
            initMenu.delete();
        }
        if(e.getX() >= 520 && e.getX() <= 980 && e.getY() >= (730) && e.getY() <= (890)){
            System.out.println("You press Controls Menu");
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        //System.out.println(e);

    }

}



