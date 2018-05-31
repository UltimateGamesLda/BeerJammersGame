package org.academiadecodigo.beerjammersgame.GameObjects;

public enum PlayerType {

    ADRIANO(15, 20, 8, "/SmallSkins/Adriano.png"),
    ALEXANDRE(20, 10, 10, "/SmallSkins/Alexandre.png"),
    ALFREDO(15, 20, 10, "/SmallSkins/Alfredo.png"),
    ANDRE(1, 30, 15, "/SmallSkins/Andre.png"),
    MARIANA(20, 10, 15, "/SmallSkins/Mariana.png"),
    PEDRO(20, 20, 8, "/SmallSkins/Pedro.png"),
    SERINGAS(15, 25, 10, "/SmallSkins/Seringas.png"),
    DUARTE(20, 10, 12, "/SmallSkins/Duarte.png"),
    FILIPE(20, 10, 10, "/SmallSkins/Filipe.png"),
    LUIS(5, 25, 15, "/SmallSkins/Luis.png"),
    MARCOLINO(5, 3, 1, "/SmallSkins/Marcolino.png"),
    HUMBERTO(50, 5, 5, "/SmallSkins/Humberto.png"),
    CATARINA(10, 10, 20, "/SmallSkins/Catarina.png"),
    FRANCISCO(20, 15, 10, "/SmallSkins/Francisco.png"),
    PANTONINHO(20, 30, 8, "/SmallSkins/Pantoninho.png"),
    RODRIGO(25, 10, 12, "/SmallSkins/Rodrigo.png");

    private int beerCapacity;
    private int speed;
    private int strength;
    private String urlImage;

    PlayerType(int beerCapacity, int speed, int strength, String urlImage) {

        this.strength = strength;

        this.speed = speed * 2;

        this.beerCapacity = beerCapacity;

        this.urlImage = urlImage;

    }

    public int getBeerCapacity() {
        return this.beerCapacity;
    }

    public int getSpeed(){
        return this.speed;
    }

    public int getStrength() { return this.strength; }

    public String geturlImage(){ return this.urlImage; }

}
