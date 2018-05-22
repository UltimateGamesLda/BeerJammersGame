package org.academiadecodigo.beerjammersgame.menu;

import org.academiadecodigo.beerjammersgame.simpleGraphics.graphics.Color;
import org.academiadecodigo.beerjammersgame.simpleGraphics.graphics.Rectangle;
import org.academiadecodigo.beerjammersgame.simpleGraphics.mouse.Mouse;
import org.academiadecodigo.beerjammersgame.simpleGraphics.mouse.MouseEvent;
import org.academiadecodigo.beerjammersgame.simpleGraphics.mouse.MouseEventType;
import org.academiadecodigo.beerjammersgame.simpleGraphics.mouse.MouseHandler;


public class MenuMouseHandler implements MouseHandler {

    Rectangle r = new Rectangle(50, 50, 50, 50);


    public MenuMouseHandler() {

        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

        r.setColor(Color.RED);
        r.fill();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println(e);
        if(e.getX() >= r.getX() && e.getX() <= (r.getX() + r.getWidth()) && e.getY() >= (r.getY() + 25) && e.getY() <= (r.getY() + r.getHeight() + 25) && r.getDrawed()){
            System.out.println("You Delete Rectangle");
            r.delete();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        //System.out.println(e);

    }

}



