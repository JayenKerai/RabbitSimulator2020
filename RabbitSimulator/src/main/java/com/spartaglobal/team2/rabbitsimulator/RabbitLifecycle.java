package com.spartaglobal.team2.rabbitsimulator;

import java.util.Random;

public class RabbitLifecycle {//int months to run array
    RabbitContainer rabbitContainer = new RabbitContainer();
    Random pregnantChance = new Random();
    long deathToll = 0;
    int[] pregnant = {0, 1};
    int chance = 0;
    String[] gender = {"m", "f"};

    public long getNumberOfRabbits() {
        return rabbitContainer.getNumberOfMales() + rabbitContainer.getNumberOfFemales();
    }

    public long getNumberOfMales() {
        return rabbitContainer.getNumberOfMales();
    }

    public long getNumberOfFemales() {
        return rabbitContainer.getNumberOfFemales();
    }

    public long getNumberOfDeadRabbits() {
        return deathToll;
    }

    public void increaseRabbitAge() { // management of time
        for (int i = 0; i < rabbitContainer.getNumberOfMales(); i++) { //every rabbit age increases by a month
            rabbitContainer.getMaleRabbits().get(i).increaseAge();
        }
        for (int i = 0; i < rabbitContainer.getNumberOfFemales(); i++) {
            rabbitContainer.getFemaleRabbits().get(i).increaseAge();
        }
        rabbitDemise();
    }

    public void increaseTime(int time) throws InterruptedException { //set to sleep
        for (int i = 0; i < time; i++) {
            System.out.println(i);
            increaseRabbitAge();
            impregnateRabbits();
            birthRabbits();
            System.gc();
            Thread.sleep(10); //1000
        }
    }

    public long getDeathToll() {
        return deathToll;
    }


    public void rabbitDemise() {
        long toRemoveMale = 0;
        long toRemoveFemale = 0;
        for (MaleRabbit r : rabbitContainer.getMaleRabbits()) {
            if (r.getAge() >= 5) {
                toRemoveMale++;
            }
        }
        for (FemaleRabbit r : rabbitContainer.getFemaleRabbits()) {
            if (r.getAge() >= 5) {
                toRemoveFemale++;
            }
        }
        for (int i = 1; i <= toRemoveMale; i++) {
            //rabbitContainer.getMaleRabbits().set(0, null);
            rabbitContainer.getMaleRabbits().remove(0);
        }
        for (int i = 1; i <= toRemoveFemale; i++) {
            //rabbitContainer.getFemaleRabbits().set(0, null);
            rabbitContainer.getFemaleRabbits().remove(0);
        }
        deathToll += toRemoveFemale + toRemoveMale;
    }

    public void impregnateRabbits() {
        if (rabbitContainer.getNumberOfMales() > 0) {
            for (MaleRabbit m : rabbitContainer.getMaleRabbits()) {
                if (m.isMature()) {
                    for (FemaleRabbit f : rabbitContainer.getFemaleRabbits()) {
                        if (f.isMature() && !f.isPregnant()) {
                            chance = pregnantChance.nextInt(pregnant.length);
                            if (chance == 1) {
                                f.setPregnant(true);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public int[] getPregnant() {
        return pregnant;
    }

    public int getChance() {
        chance = pregnantChance.nextInt(pregnant.length);
        return chance;
    }

    public void birthRabbits() {
        Random randomLitter = new Random();
        Random randomGender = new Random();
        int toBeBirthedMale = 0;
        int toBeBirthedFemale = 0;
        final int MAX_LITTER = 5;
        final int MIN_LITTER = 1;

        for (FemaleRabbit f : rabbitContainer.getFemaleRabbits()) {
            if (f.isPregnant()) {
                int litter = randomLitter.nextInt(MAX_LITTER - MIN_LITTER) + MIN_LITTER;
                for (int i = 1; i <= litter; i++) {
                    int newGender = randomGender.nextInt(gender.length);
                    if (newGender == 0) {
                        toBeBirthedMale++;
                    } else {
                        toBeBirthedFemale++;
                    }
                }
                f.setPregnant(false);
            }
        }
        for (int i = 1; i <= toBeBirthedMale; i++) {
            rabbitContainer.birthMaleRabbit();
        }
        for (int i = 1; i <= toBeBirthedFemale; i++) {
            rabbitContainer.birthFemaleRabbit();
        }
    }

    public String[] getGender() {
        return gender;
    }
}