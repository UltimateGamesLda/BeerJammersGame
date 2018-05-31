package org.academiadecodigo.beerjammersgame.field;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {

    public static final int PADDINGX = 167;
    public static final int PADDINGY = 257;
    public static final int HEIGHT = 572;
    public static final int WIDTH = 1170;
    private int player1maxX;
    private int player2maxX;
    private int goalSize;
    private int playerHeight;
    private int playerWidth;
    private int playerMaxX;
    private int playerMaxY;

    private Rectangle border;
    private int ballHeight;
    private int ballWidth;
    private int ballMaxX;
    private int ballMaxY;

    public Field() {

        this.goalSize = WIDTH / 16 ; //goals have one eight
        this.playerHeight = 150;
        this.playerWidth = 75;
        this.playerMaxX = WIDTH / 2;
        this.playerMaxY = PADDINGY + HEIGHT - playerHeight;
        this.ballHeight= 40;
        this.ballWidth = 40;
        this.ballMaxX = PADDINGX + WIDTH - ballWidth;
        this.ballMaxY = PADDINGY + HEIGHT - ballHeight;
        this.player1maxX = PADDINGX + playerWidth;
        this.player2maxX = PADDINGX + (WIDTH / 2) + 40;
    }

    public int getXPlayer1() {
        return PADDINGX + goalSize;
    }

    public int getXPlayer2() {
        return PADDINGX + WIDTH - goalSize - playerWidth;
    }

    public int getYPlayer() {
        return PADDINGY + (HEIGHT / 2) - (playerHeight / 2) ;
    }

    public int getPlayerHeight() {
        return playerHeight;
    }

    public int getPlayerWidth() {
        return playerWidth;
    }

    public int getPlayerMaxX() {
        return playerMaxX;
    }

    public int getPlayerMaxY() {
        return playerMaxY;
    }

    public int getHeight(){
        return HEIGHT;
    }

    public int getWidth(){
        return WIDTH;
    }

    public int getPaddingX() {
        return PADDINGX ;
    }

    public int getPaddingY() {
        return PADDINGY ;
    }

    public int getBallHeight() {
        return ballHeight;
    }

    public int getBallWidth() {
        return ballWidth;
    }

    public int getBallMaxX() {
        return ballMaxX;
    }

    public int getBallMaxY() {
        return ballMaxY;
    }

    public int getGoalSize(){
        return goalSize;
    }

    public int getPlayer1maxX(){
        return player1maxX;
    }

    public int getPlayer2maxX(){
        return player2maxX;
    }
}

