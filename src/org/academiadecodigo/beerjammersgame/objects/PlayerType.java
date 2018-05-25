package org.academiadecodigo.beerjammersgame.objects;

public enum PlayerType {
    ADRIANO(15, 20, 10),
    ALEXANDRE(20, 10, 15),
    ALFREDO(15, 20, 15),
    ANDRE(1, 30, 25),
    MARIANA(20, 10, 25),
    PEDRO(20, 20, 10),
    SERINGAS(15, 25, 15),
    DUARTE(20, 10, 20),
    FILIPE(20, 10, 15),
    LUIS(5, 25, 25),
    MARCOLINO(5, 3, 1),
    HUMBERTO(50, 5, 5),
    CATARINA(10, 10, 30),
    FRANCISCO(20, 15, 15),
    PANTONINHO(20, 30, 10),
    RODRIGO(25, 10, 20);

    private int beerCapacity;
    private int speed;
    private int strength;

    PlayerType(int beerCapacity, int speed, int strength) {

        this.strength = strength;

        this.speed = speed;

        this.beerCapacity = beerCapacity;

    }

    public int getBeerCapacity(PlayerType name) {
        return name.beerCapacity;
    }

    public int getSpeed(PlayerType name){
        return name.speed;
    }

    public int getStrength(PlayerType name) {
        return name.strength;
    }
}
