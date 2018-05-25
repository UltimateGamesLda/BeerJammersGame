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

    public MenuMouseHandler() {

        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        m.addEventListener(MouseEventType.MOUSE_MOVED);

        //initMenu.setColor(Color.RED);
        initMenu.draw();

    }

    @Override
    public void mouseClicked(MouseEvent e){
        //System.out.println(e);

        if (menu == true) {

            if(chareterSelect(e) == true){

                player2Logo.draw();
                player2Logo.grow(-40, -40);
                player1Logo.delete();
                playerCount++;

                if (playerCount == 2){

                    player2Logo.delete();
                    selectMenu.delete();

                    m.removeEventListener(MouseEventType.MOUSE_CLICKED);
                    m.removeEventListener(MouseEventType.MOUSE_MOVED);
                    Main.endMenu(players);
                }
            }
        }

        if (e.getX() >= 520 && e.getX() <= 980 && e.getY() >= (530) && e.getY() <= (700) && menu == false) {
            System.out.println("You press Start Button");
            menu = true;
            selectMenu.draw();
            player1Logo.draw();
            player1Logo.grow(-25, -25);
            initMenu.delete();
        }

        if (e.getX() >= 520 && e.getX() <= 980 && e.getY() >= (730) && e.getY() <= (890) && menu == false) {
            System.out.println("You press Controls Menu");
        }
    }


    private boolean chareterSelect(MouseEvent e) {
        //---------------------------------Line 1-----------------------------------------
        if (e.getX() >= 89 && e.getX() <= 402 && e.getY() >= 161 && e.getY() <= 300) {
            System.out.println("You press CodeCadet Adriano");
            players[playerCount] = "Adriano";
            return true;
        }

        if (e.getX() >= 90 && e.getX() <= 405 && e.getY() >= 322 && e.getY() <= 475) {
            System.out.println("You press CodeCadet Alexandre");
            players[playerCount] = "Alexandre";
            return true;
        }

        if (e.getX() >= 90 && e.getX() <= 405 && e.getY() >= (508) && e.getY() <= 657) {
            System.out.println("You press CodeCadet Alfredo");
            players[playerCount] = "Alfredo";
            return true;
        }

        if (e.getX() >= 85 && e.getX() <= 405 && e.getY() >= 685 && e.getY() <= 830) {
            System.out.println("You press CodeCadet Andre");
            players[playerCount] = "Andre";
            return true;
        }

        //---------------------------------Line 2-----------------------------------------

        if (e.getX() >= 445 && e.getX() <= 770 && e.getY() >= 160 && e.getY() <= 300) {
            System.out.println("You press CodeCadet Marina");
            players[playerCount] = "Mariana";
            return true;
        }

        if (e.getX() >= 440 && e.getX() <= 770 && e.getY() >= 330 && e.getY() <= 475) {
            System.out.println("You press CodeCadet Pedro");
            players[playerCount] = "Pedro";
            return true;
        }

        if (e.getX() >= 440 && e.getX() <= 770 && e.getY() >= 500 && e.getY() <= 655) {
            System.out.println("You press CodeCadet Seringas");
            players[playerCount] = "Seringas";
            return true;
        }

        if (e.getX() >= 445 && e.getX() <= 770 && e.getY() >= 685 && e.getY() <= 830) {
            System.out.println("You press CodeCadet Duarte");
            players[playerCount] = "Duarte";
            return true;
        }

        //---------------------------------Line 3-----------------------------------------

        if (e.getX() >= 820 && e.getX() <= 1135 && e.getY() >= 160 && e.getY() <= 300) {
            System.out.println("You press CodeCadet Filipe");
            players[playerCount] = "Filipe";
            return true;
        }

        if (e.getX() >= 810 && e.getX() <= 1130 && e.getY() >= 332 && e.getY() <= 485) {
            System.out.println("You press CodeCadet Luis");
            players[playerCount] = "Luis";
            return true;
        }

        if (e.getX() >= 810 && e.getX() <= 1130 && e.getY() >= 500 && e.getY() <= 670) {
            System.out.println("You press CodeCadet Marcolino");
            players[playerCount] = "Marcolino";
            return true;
        }

        if (e.getX() >= 810 && e.getX() <= 1150 && e.getY() >= 695 && e.getY() <= 845) {
            System.out.println("You press CodeCadet Humberto");
            players[playerCount] = "Humberto";
            return true;
        }

        //---------------------------------Line 4-----------------------------------------

        if (e.getX() >= 1170 && e.getX() <= 1505 && e.getY() >= 160 && e.getY() <= 310) {
            System.out.println("You press CodeCadet Catarina");
            players[playerCount] = "Catarina";
            return true;
        }

        if (e.getX() >= 1170 && e.getX() <= 1490 && e.getY() >= 338 && e.getY() <= 485) {
            System.out.println("You press CodeCadet Francisco");
            players[playerCount] = "Francisco";
            return true;
        }

        if (e.getX() >= 1170 && e.getX() <= 1490 && e.getY() >= 510 && e.getY() <= 660) {
            System.out.println("You press CodeCadet Pantoninho");
            players[playerCount] = "Pantoninho";
            return true;
        }

        if (e.getX() >= 1175 && e.getX() <= 1472 && e.getY() >= 690 && e.getY() <= 840) {
            System.out.println("You press CodeCadet Rodrigo");
            players[playerCount] = "Rodrigo";
            return true;
        }

        return  false;
    }

        @Override
        public void mouseMoved (MouseEvent e){

            //System.out.println(e);

        }

    }





