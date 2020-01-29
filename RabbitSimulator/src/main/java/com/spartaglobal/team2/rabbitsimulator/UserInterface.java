package com.spartaglobal.team2.rabbitsimulator;

import java.util.Scanner;

public class UserInterface {
    public UserInterface() throws InterruptedException {
        run();
    }

    public void run() throws InterruptedException {
        RabbitLifecycle rl = new RabbitLifecycle();
        Scanner in = new Scanner(System.in);
        boolean validInput = false;
        String strInput = null;
        while (!validInput) { //ensure that only numerical values are passed as an input
            System.out.print("How many months would you like to simulate?: ");
            strInput = in.nextLine();
            if (strInput.matches("-?\\d+(\\.\\d+)?")) {
                validInput = true;
            }
        }
        int input = Integer.parseInt(strInput);
        rl.increaseTime(input); //run program with given time
        System.out.println("There are " + (rl.rabbitContainer.getNumberOfMales() + rl.rabbitContainer.getNumberOfFemales()) + " rabbits in total");
        System.out.println("There are " + rl.rabbitContainer.getNumberOfMales() + " male rabbits"); //TODO correct grammar errors
        System.out.println("There are " + rl.rabbitContainer.getNumberOfFemales() + " female rabbits");
        System.out.println("There are " + rl.getDeathToll() + " dead rabbits");
    }
}