package org.academiadecodigo.beerjammersgame;


import java.time.Instant;

public class Chronometer {

    private int totalMs;
    private int msLeft;
    private long lastTickTime;


    public Chronometer(int totalMs) {
        this.totalMs = totalMs;
        this.msLeft = totalMs;
    }

    public void start() {
        lastTickTime = Instant.now().toEpochMilli();
    }

    public void tick() {

        if (lastTickTime == 0) {
            throw new ExceptionInInitializerError("Chronometer needs to be started before calling tick().");
        }

        long currentMs = Instant.now().toEpochMilli();
        long deltaMs = currentMs - lastTickTime;

        msLeft -= deltaMs;

        msLeft = msLeft > 0 ? msLeft : 0;
        lastTickTime = currentMs;
    }

    public void stop() {
        lastTickTime = 0;
    }

    public void reset() {
        this.stop();
        this.msLeft = this.totalMs;
    }

    public int getMsLeft() {
        return msLeft;
    }

    public String toString() {

        int convertMsToSec = msLeft/1000;
        return Integer.toString(convertMsToSec);
    }


}
