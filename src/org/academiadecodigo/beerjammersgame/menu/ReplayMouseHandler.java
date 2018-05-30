package org.academiadecodigo.beerjammersgame.menu;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ReplayMouseHandler implements MouseHandler {
    private Mouse m = new Mouse(this);
    private Picture choiceMenu = new Picture(10, 10, "./PlayAgainMenu.png");
    private Boolean choice = false;
    private Boolean playAgain;
    private volatile int x = 0;
    private volatile int y = 0;

    public ReplayMouseHandler(){

        m.addEventListener(MouseEventType.MOUSE_CLICKED);

        choiceMenu.draw();
    }

    public boolean choice(){
        while(!choice){

            if (x >= 690 && x <= 812 && y >= 495 && y <= 545){
                choice = true;
                playAgain = true;
            }

            if (x >= 690 && x <= 780 && y >= 560 && y <= 615){
                choice = true;
                playAgain = false;
            }

        }
        deleteMenu();
        return playAgain;
    }

    public void deleteMenu(){
        m.removeEventListener(MouseEventType.MOUSE_CLICKED);
        choiceMenu.delete();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        x = (int) e.getX();
        y = (int) e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
}
