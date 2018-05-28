package org.academiadecodigo.beerjammersgame.objects;

public enum PlayerType {
    ADRIANO(15, 20, 10, "/SmallSkins/Adriano.png"),
    ALEXANDRE(20, 10, 15, "/SmallSkins/Alexandre.png"),
    ALFREDO(15, 20, 15, "/SmallSkins/Alfredo.png"),
    ANDRE(1, 30, 25, "/SmallSkins/Andre.png"),
    MARIANA(20, 10, 25, "/SmallSkins/Mariana.png"),
    PEDRO(20, 20, 10, "/SmallSkins/Pedro.png"),
    SERINGAS(15, 25, 15, "/SmallSkins/Seringas.png"),
    DUARTE(20, 10, 20, "/SmallSkins/Duarte.png"),
    FILIPE(20, 10, 15, "/SmallSkins/Filipe.png"),
    LUIS(5, 25, 25, "/SmallSkins/Luis.png"),
    MARCOLINO(5, 3, 1, "/SmallSkins/Marcolino.png"),
    HUMBERTO(50, 5, 5, "/SmallSkins/Humberto.png"),
    CATARINA(10, 10, 30, "/SmallSkins/Catarina.png"),
    FRANCISCO(20, 15, 15, "/SmallSkins/Francisco.png"),
    PANTONINHO(20, 30, 10, "/SmallSkins/Pantoninho.png"),
    RODRIGO(25, 10, 20, "/SmallSkins/Rodrigo.png");

    private int beerCapacity;
    private int speed;
    private int strength;
    private String urlImage;

    PlayerType(int beerCapacity, int speed, int strength, String urlImage) {

        this.strength = strength;

        this.speed = speed;

        this.beerCapacity = beerCapacity;

        this.urlImage = urlImage;

    }

    public int getBeerCapacity(PlayerType name) {
        return name.beerCapacity;
    }

    public int getSpeed(PlayerType name){
        return name.speed;
    }

    public int getStrength(PlayerType name) { return name.strength; }

    public String geturlImage(PlayerType name){ return name.urlImage; }
}
