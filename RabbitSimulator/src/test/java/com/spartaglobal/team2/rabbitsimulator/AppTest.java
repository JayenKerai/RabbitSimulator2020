package com.spartaglobal.team2.rabbitsimulator;
import com.spartaglobal.team2.rabbitsimulator.Rabbits.AddNewRabbit;
import com.spartaglobal.team2.rabbitsimulator.Rabbits.RabbitDataRetriever;
import com.spartaglobal.team2.rabbitsimulator.Rabbits.RabbitUpdater;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest {
    RabbitUpdater rabbitUpdater = new RabbitUpdater();
    AddNewRabbit addNewRabbit = new AddNewRabbit("text\\TotalRabbits.txt");
    EnvironmentController environmentController = new EnvironmentController();
    RabbitDataRetriever rabbitDataRetriever = new RabbitDataRetriever();

    public AppTest() throws IOException {
    }

    @BeforeEach
    public void initialCode() throws IOException, InterruptedException {
        rabbitUpdater.totalRabbitFileCleaner();
        addNewRabbit.createRabbit("m");
        addNewRabbit.createRabbit("f");
        //int input = 59;
        //environmentController.increaseTimeWithoutBirth(input);
    }

    @Test
    void testTheCorrectAmountOfRabbitsHaveDied() throws IOException {
        Assertions.assertEquals(2, rabbitDataRetriever.getNumOfRabbits());  //Check if there are two rabbits
    }
}