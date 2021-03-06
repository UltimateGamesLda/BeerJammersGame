package org.academiadecodigo.beerjammersgame.keyboard;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.beerjammersgame.GameObjects.Player;
import org.academiadecodigo.beerjammersgame.field.Direction;

public class PlayerKeyboardHandler implements KeyboardHandler {
    private Player player1;
    private Player player2;

    public PlayerKeyboardHandler(Player player1, Player player2){

        this.player1 = player1;
        this.player2 = player2;

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_UP);//KeyboardEvent.KEY_UP
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_LEFT);//KeyboardEvent.KEY_UP
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_L);//KeyboardEvent.KEY_UP
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_W);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_S);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_A);//KeyboardEvent.KEY_UP
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_D);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        event.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(event);
    }

    @Override
    public void keyPressed(KeyboardEvent event ) {

        switch (event.getKey()){
            case KeyboardEvent.KEY_UP:
                player2.setDistance(Direction.UP);
                player2.move();
                break;
            case KeyboardEvent.KEY_DOWN:
                player2.setDistance(Direction.DOWN);
                player2.move();
                break;
            case KeyboardEvent.KEY_LEFT:
                player2.setDistance(Direction.LEFT);
                player2.move();
                break;
            case KeyboardEvent.KEY_RIGHT:
                player2.setDistance(Direction.RIGHT);
                player2.move();
                break;
            case KeyboardEvent.KEY_L:
                player2.launchBall();
                break;
            case KeyboardEvent.KEY_W:
                player1.setDistance(Direction.UP);
                player1.move();
                break;
            case KeyboardEvent.KEY_S:
                player1.setDistance(Direction.DOWN);
                player1.move();
                break;
            case KeyboardEvent.KEY_A:
                player1.setDistance(Direction.LEFT);
                player1.move();
                break;
            case KeyboardEvent.KEY_D:
                player1.setDistance(Direction.RIGHT);
                player1.move();
                break;
            case KeyboardEvent.KEY_SPACE:
                player1.launchBall();
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent event) {

        System.out.println(event);
    }
}
