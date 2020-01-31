package com.spartaglobal.team2.rabbitsimulator.Foxes;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FoxUpdater {
    File totalFoxes = new File("text\\TotalFoxes.csv");
    File temp = new File("text\\TempFoxes.csv");
    DeadFoxStorage deadFoxStorage = new DeadFoxStorage();

    public FoxUpdater() throws IOException {
        tempFileCleaner();
    }

    public void incrementAge() throws IOException {

        FileWriter tempFileWriter = new FileWriter(temp, true);
        FileReader tempFileReader = new FileReader(temp);

        FileWriter totalFoxesFileWriter = new FileWriter(totalFoxes, true);
        FileReader totalFoxesFileReader = new FileReader(totalFoxes); // A stream that connects to the text file

        BufferedWriter bufferedTotalFoxesWriter = new BufferedWriter(totalFoxesFileWriter);
        BufferedReader bufferedTotalFoxesReader = new BufferedReader(totalFoxesFileReader); // Connect the FileReader to the BufferedReader

        BufferedWriter bufferedTempWriter = new BufferedWriter(tempFileWriter);
        BufferedReader bufferedTempReader = new BufferedReader(tempFileReader); // Connect the FileReader to the BufferedReader

        FoxDataRetriever FoxDataRetriever = new FoxDataRetriever();

        tempFileCleaner();
        long matureMaleFoxCount = FoxDataRetriever.getNumOfMatureFoxes("m"); //get number of male foxes (cant impregnate more than this number of females)
        long pregnantFemaleCount = 0;

        String line;
        while ((line = bufferedTotalFoxesReader.readLine()) != null) { //do for each fox

            String[] array = line.split(", ");

            int i = Integer.parseInt(array[0]);
            i++; //increment age for fox

            if (i < 60) { // if the foxes age is less than 60

                // set maturity to true when older than 2
                if (i > 9) {
                    array[2] = "true";
                }

                // this method comes before setting pregnant to ensure foxes dont give birth immediately
                if (array[3].equals("true") && array[1].equals("f")) { //if a foxes is pregnant and is female
                    giveBirth(); //create a new fox\
                    array[3] = "false"; //set fox to no longer pregnant
                }

                // if there are still unmated mature males, and this fox is a mature female
                if ((pregnantFemaleCount <= matureMaleFoxCount) && array[1].equals("f") && array[2].equals("true")) {
                    array[3] = "true";
                    pregnantFemaleCount++;
                }

                bufferedTempWriter.write(i + ", " + array[1] + ", " + array[2] + ", " + array[3]); // age, gender, maturity, pregnant
                bufferedTempWriter.newLine();

            } else {
                deadFoxStorage.incrementDeadFoxes();// if foxes are > 59, increment the counter
            }
        }
        bufferedTotalFoxesReader.close();
        bufferedTempWriter.close();
        totalFoxesFileCleaner();

        while ((line = bufferedTempReader.readLine()) != null) {
            bufferedTotalFoxesWriter.write(line);
            bufferedTotalFoxesWriter.newLine();
        }
        bufferedTempReader.close();
        bufferedTotalFoxesWriter.close();

    }

    private void giveBirth() throws IOException {
        AddNewFox addNewFox = new AddNewFox("text\\TotalFoxes.csv");
        int max = 10;
        int min = 1;
        int foxesToCreate = (int) (Math.random() * ((max - min) + 1)) + min; //create random number between max and min

        for (int i = 0; i < foxesToCreate; i++) { //create between min and max new foxes
            List<String> gender = new ArrayList<>();
            gender.add("m");
            gender.add("f"); //add male and female as options for genders
            Collections.shuffle(gender); //randomises m/f in array
            addNewFox.createFox(gender.get(0)); //creates new fox with random gender
        }
    }

    private void tempFileCleaner() throws IOException {
        FileWriter fileWriter = new FileWriter(temp, false);
        BufferedWriter bufferedTempWriter = new BufferedWriter(fileWriter);
        bufferedTempWriter.write("");
    }

    public void totalFoxesFileCleaner() throws IOException {
        FileWriter fileWriter = new FileWriter(totalFoxes, false);
        BufferedWriter bufferedTempWriter = new BufferedWriter(fileWriter);
        bufferedTempWriter.write("");
    }

}
