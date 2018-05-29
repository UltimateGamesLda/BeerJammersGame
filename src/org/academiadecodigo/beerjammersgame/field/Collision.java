package org.academiadecodigo.beerjammersgame.field;

import org.academiadecodigo.beerjammersgame.GameObjects.Ball;
import org.academiadecodigo.beerjammersgame.GameObjects.Player;

public class Collision {
    private Field field;
    private Player player1;
    private Player player2;
    private Ball ball;

    public Collision(Field field, Player player1, Player player2, Ball ball){
        this.field = field;
        this.player1 = player1;
        this.player2 = player2;
        this.ball = ball;
    }

    public void check(){
        //while it hasn't collide
        if(!checkColision(ball.getHorizDirection(),ball.getVertDirection())){
            ball.toNextPos();
        }
    }

    public void collidesGoals1(){
        if(ball.getPos().getX() <= field.PADDINGX + field.getGoalSize()){
            System.out.println("TOUCOU NA BALIZA1");
        }

    }


    private boolean checkColision(Direction horizDirection, Direction vertDirection) {
        boolean collision = false;
        switch (vertDirection) {
            case UP:
                //verifica limite sup
                if (ball.isOnTopLimit()) {
                    ball.toTopLimit();
                    ball.changeVertDirection();
                    collision = true;
                }
                //verifica se está a bater na parte inf do player
                //muda de direção
                break;

            case DOWN:
                //verifica limite inf
                //se estiver no limite inferior
                if (ball.isOnBottomLimit()) {
                    ball.toBottomLimit();
                    ball.changeVertDirection();
                    collision =  true;
                }

                //verifica se bate em cima do player
                //muda de direção
                break;
        }

        switch (horizDirection) {
            case LEFT:
                //verifica lim. esq
                if (ball.isOnLeftLimit()) {
                    ball.toLeftLimit();
                    ball.changeHorizDirection();
                    collision = true;
                }
                //verifica se bate no lado direito do player 1
                //muda de direção
                //verifica se bate no lado direito das balizas 1
                //muda de direção
                break;
            case RIGHT:
                //se estiver no limite direito
                if (ball.isOnRightLimit()) {
                    ball.toRightLimit();
                    ball.changeHorizDirection();
                    collision =true;
                }
                //verifica se bate no lado direito do player 2
                //muda de direção
                //verifica se bate no lado direito das balizas 2
                //muda de direção
                break;
        }

        if(!collision){

        }
        return collision;
    }


}
