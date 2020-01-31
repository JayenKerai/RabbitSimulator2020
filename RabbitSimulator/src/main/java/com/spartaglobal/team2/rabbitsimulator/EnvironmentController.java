package com.spartaglobal.team2.rabbitsimulator;

import com.spartaglobal.team2.rabbitsimulator.Foxes.FoxDataRetriever;
import com.spartaglobal.team2.rabbitsimulator.Foxes.FoxUpdater;
import com.spartaglobal.team2.rabbitsimulator.Foxes.FoxUpdaterWithoutBirth;
import com.spartaglobal.team2.rabbitsimulator.Rabbits.RabbitDataRetriever;
import com.spartaglobal.team2.rabbitsimulator.Rabbits.RabbitUpdater;
import com.spartaglobal.team2.rabbitsimulator.Rabbits.RabbitUpdaterWithBirthWithoutDeath;
import com.spartaglobal.team2.rabbitsimulator.Rabbits.RabbitUpdaterWithoutBirth;

import java.io.IOException;

public class EnvironmentController {

    public static int currentMonthCounter = 0;

    public void increaseTime(int time, int month) throws InterruptedException, IOException { //set to sleep
        RabbitUpdater rabbitUpdater = new RabbitUpdater();
        FoxUpdater foxUpdater = new FoxUpdater();
        RabbitUpdaterWithBirthWithoutDeath rabbitUpdaterWithBirthWithoutDeath = new RabbitUpdaterWithBirthWithoutDeath();
        FoxUpdaterWithoutBirth foxUpdaterWithoutBirth = new FoxUpdaterWithoutBirth();

        for (int i = 0; i < time; i++) {
            currentMonthCounter++;
            if (currentMonthCounter >= month) { //after n months, rabbits can start to be killed by foxes //19 is a good number to ensure rabbits don't get killed immediately
                rabbitUpdater.incrementAge();
                //foxUpdater.incrementAge();
            } else {
                rabbitUpdaterWithBirthWithoutDeath.incrementAge();
                //foxUpdaterWithoutBirth.incrementAge();
            }
            RabbitDataRetriever rabbitDataRetriever = new RabbitDataRetriever();

            System.out.println("current month: " + currentMonthCounter);
            System.out.println("current rabbits: " + rabbitDataRetriever.getNumOfRabbits());
            FoxDataRetriever foxDataRetriever = new FoxDataRetriever();
            System.out.println("current foxes: " + foxDataRetriever.getNumOfFoxes());
            System.out.println("fox kills this month: " + FoxDataRetriever.getNumberOfRabbitsToBeKilledByFoxes());
            System.out.println();
            foxUpdater.incrementAge();
            Thread.sleep(1); //1000
        }
    }

    public void increaseTimeWithoutBirth(int time) throws InterruptedException, IOException { //set to sleep
        RabbitUpdaterWithoutBirth rabbitUpdaterWithoutBirth = new RabbitUpdaterWithoutBirth();
        FoxUpdaterWithoutBirth foxUpdaterWithoutBirth = new FoxUpdaterWithoutBirth();
        for (int i = 0; i < time; i++) {
            rabbitUpdaterWithoutBirth.incrementAge();
            foxUpdaterWithoutBirth.incrementAge();
            Thread.sleep(1); //1000
        }
    }
}
