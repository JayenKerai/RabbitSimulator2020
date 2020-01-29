package com.spartaglobal.team2.rabbitsimulator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestRabbitLifecycle {
    RabbitLifecycle r2 = new RabbitLifecycle();

    public RabbitLifecycle getR2() {
        return r2;
    }

    @BeforeEach
    void createRabbit() throws InterruptedException {
        r2.increaseTime(60);
    }

    @Test
    public void testDeathCountIsCorrectValue() {
        Assertions.assertEquals(2, r2.getDeathToll());
    }

    @Test
    public void testDeathCountIsNotCorrect() {
        Assertions.assertNotEquals(1, r2.getDeathToll());
    }

    @Test
    public void testThatChanceOfPregnancyIsEqualToZeroOrOne() {
        Assertions.assertArrayEquals(new int[]{0, 1}, r2.getPregnant());
    }

    @Test
    public void testThatPregnancyRandomNumberGeneratorIsEqualToOneOrZero() {
        int chance = r2.getChance();
        if (chance == 1) {
            Assertions.assertEquals(1, chance);
        } else {
            Assertions.assertEquals(0, chance);
        }
    }

    @Test
    public void testThatNewRabbitGenderIsMaleOrFemale() {
        Assertions.assertArrayEquals(new String[]{"m", "f"}, r2.getGender());
    }


}

