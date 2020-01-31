package com.spartaglobal.team2.rabbitsimulator.Rabbits;

public class DeadRabbitStorage {
    static private int deadRabbitsCounter;
    static private int rabbitsKilledByFoxes;

    public static int getRabbitsKilledByFoxes() {
        return rabbitsKilledByFoxes;
    }

    public int getNumberOfDeadRabbits() {
        return deadRabbitsCounter;
    }

    public void incrementDeadRabbits() {
        deadRabbitsCounter++;
    }

    public void incrementKilledRabbits() {
        rabbitsKilledByFoxes++;
    }
}
