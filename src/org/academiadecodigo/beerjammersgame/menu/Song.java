package org.academiadecodigo.beerjammersgame.menu;

import java.io.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;

public class Song{
    public static void PlaySound(File song){
        try {

            FileInputStream fis = new FileInputStream(song);
            BufferedInputStream bis = new BufferedInputStream(fis);

            try {

                Player player = new Player(bis);
                player.play();

            } catch (JavaLayerException e) { System.out.println("Error Playing Song"); }
            } catch (IOException e){System.out.println("Error Playing Song");}
        }
    }
