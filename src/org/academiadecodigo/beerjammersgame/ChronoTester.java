package org.academiadecodigo.beerjammersgame;

public class ChronoTester {

    public static void main(String[] args) throws InterruptedException {


        Chronometer c = new Chronometer(5000);
        c.start();
        System.out.println("started chrono: " + c);

        while (c.getMsLeft() > 0) {
            c.tick();
            System.out.println("tick: " + c);


            Thread.sleep(20);
        }
    }
}
