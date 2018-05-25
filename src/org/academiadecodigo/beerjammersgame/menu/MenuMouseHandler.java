package org.academiadecodigo.beerjammersgame.menu;

import org.academiadecodigo.beerjammersgame.Main;
import org.academiadecodigo.simplegraphics.mouse.*;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ConcurrentModificationException;


public class MenuMouseHandler implements MouseHandler {

    //Rectangle initMenu = new Rectangle(50, 50, 50, 50);

    Mouse m = new Mouse(this);
    Picture initMenu = new Picture(10, 10, "./BeerJammersMenuInit.png");
    Picture selectMenu = new Picture(10, 10, "./CodeCadetSelect.png");
    Picture player1Logo = new Picture(1010, -10, "/Player1.png");
    Picture player2Logo = new Picture(1010, -10, "/Player2.png");
    private String[] players = new String[2];
    private int playerCount = 0;
    private boolean menu = false;
    private Boolean next = false;
    private volatile int x = 0;
    private volatile int y = 0;

    public MenuMouseHandler() {
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

        //initMenu.setColor(Color.RED);
        initMenu.draw();
        start();
    }

    public void start(){

        Boolean end = false;

        while(!end) {
            if (x >= 520 && x <= 980 && y >= (530) && y <= (700) && menu == false) {
                System.out.println("You press Start Button");
                menu = true;
                selectMenu.draw();
                player1Logo.draw();
                player1Logo.grow(-25, -25);
                initMenu.delete();
                reset();
            }

            if (x >= 520 && x <= 980 && y >= (730) && y <= (890) && menu == false) {
                System.out.println("You press Controls Menu");
                reset();
            }

            if (menu) {

                if (next) {

                    player2Logo.draw();
                    player2Logo.grow(-40, -40);
                    player1Logo.delete();
                    playerCount++;

                    if (playerCount == 2) {

                        player2Logo.delete();
                        selectMenu.delete();

                        m.removeEventListener(MouseEventType.MOUSE_CLICKED);
                        m.removeEventListener(MouseEventType.MOUSE_MOVED);

                        Main.endMenu(players);
                    }

                    next = false;
                }

                if(x != 0 || y != 0 ) {
                    //---------------------------------Line 1-----------------------------------------
                    if (x >= 89 && x <= 402 && y >= 161 && y <= 300) {
                        System.out.println("You press CodeCadet Adriano");
                        players[playerCount] = "Adriano";
                        next = true;
                    }

                    if (x >= 90 && x <= 405 && y >= 322 && y <= 475) {
                        System.out.println("You press CodeCadet Alexandre");
                        players[playerCount] = "Alexandre";
                        next = true;
                    }

                    if (x >= 90 && x <= 405 && y >= (508) && y <= 657) {
                        System.out.println("You press CodeCadet Alfredo");
                        players[playerCount] = "Alfredo";
                        next = true;
                    }

                    if (x >= 85 && x <= 405 && y >= 685 && y <= 830) {
                        System.out.println("You press CodeCadet Andre");
                        players[playerCount] = "Andre";
                        next = true;
                    }

                    //---------------------------------Line 2-----------------------------------------

                    if (x >= 445 && x <= 770 && y >= 160 && y <= 300) {
                        System.out.println("You press CodeCadet Marina");
                        players[playerCount] = "Mariana";
                        next = true;
                    }

                    if (x >= 440 && x <= 770 && y >= 330 && y <= 475) {
                        System.out.println("You press CodeCadet Pedro");
                        players[playerCount] = "Pedro";
                        next = true;
                    }

                    if (x >= 440 && x <= 770 && y >= 500 && y <= 655) {
                        System.out.println("You press CodeCadet Seringas");
                        players[playerCount] = "Seringas";
                        next = true;
                    }

                    if (x >= 445 && x <= 770 && y >= 685 && y <= 830) {
                        System.out.println("You press CodeCadet Duarte");
                        players[playerCount] = "Duarte";
                        next = true;
                    }

                    //---------------------------------Line 3-----------------------------------------

                    if (x >= 820 && x <= 1135 && y >= 160 && y <= 300) {
                        System.out.println("You press CodeCadet Filipe");
                        players[playerCount] = "Filipe";
                        next = true;
                    }

                    if (x >= 810 && x <= 1130 && y >= 332 && y <= 485) {
                        System.out.println("You press CodeCadet Luis");
                        players[playerCount] = "Luis";
                        next = true;
                    }

                    if (x >= 810 && x <= 1130 && y >= 500 && y <= 670) {
                        System.out.println("You press CodeCadet Marcolino");
                        players[playerCount] = "Marcolino";
                        next = true;
                    }

                    if (x >= 810 && x <= 1150 && y >= 695 && y <= 845) {
                        System.out.println("You press CodeCadet Humberto");
                        players[playerCount] = "Humberto";
                        next = true;
                    }

                    //---------------------------------Line 4-----------------------------------------

                    if (x >= 1170 && x <= 1505 && y >= 160 && y <= 310) {
                        System.out.println("You press CodeCadet Catarina");
                        players[playerCount] = "Catarina";
                        next = true;
                    }

                    if (x >= 1170 && x <= 1490 && y >= 338 && y <= 485) {
                        System.out.println("You press CodeCadet Francisco");
                        players[playerCount] = "Francisco";
                        next = true;
                    }

                    if (x >= 1170 && x <= 1490 && y >= 510 && y <= 660) {
                        System.out.println("You press CodeCadet Pantoninho");
                        players[playerCount] = "Pantoninho";
                        next = true;
                    }

                    if (x >= 1175 && x <= 1472 && y >= 690 && y <= 840) {
                        System.out.println("You press CodeCadet Rodrigo");
                        players[playerCount] = "Rodrigo";
                        next = true;
                    }

                    reset();
                }
            }
        }
    }

    private void reset(){
        x = 0;
        y = 0;
    }

    @Override
    public void mouseClicked(MouseEvent e){
        x = (int) e.getX();
        y = (int) e.getY();
    }

    @Override
    public void mouseMoved (MouseEvent e){
        //System.out.println(e);
    }

}





