package com.spartaglobal.team2.rabbitsimulator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void testThatMaleRabbitHasMaleGender() {
        MaleRabbit maleRabbit = new MaleRabbit();
        Assertions.assertEquals('m', maleRabbit.getGender());
    }
    @Test
    public void testThatFemaleRabbitHasFemaleGender() {
        FemaleRabbit femaleRabbit = new FemaleRabbit();
        Assertions.assertEquals('f', femaleRabbit.getGender());
    }
    @Test
    public void testThatMaleRabbitHasMaleGenderUpperCase() {
        MaleRabbit maleRabbit = new MaleRabbit();
        Assertions.assertEquals('M', maleRabbit.getGender());
    }
    @Test
    public void testThatFemaleRabbitHasFemaleGenderUpperCase() {
        FemaleRabbit femaleRabbit = new FemaleRabbit();
        Assertions.assertEquals('F', femaleRabbit.getGender());
    }
    @Test
    public void testThatRabbitIsMatureAfter3Months() {
        MaleRabbit maleRabbit = new MaleRabbit();
        maleRabbit.increaseAge();
        maleRabbit.increaseAge();
        maleRabbit.increaseAge();
        Assertions.assertEquals(true,maleRabbit.isMature());
    }
    @Test
    public void testThatRabbitIsNotMatureAfter2Months(){
        MaleRabbit maleRabbit = new MaleRabbit();
        maleRabbit.increaseAge();
        maleRabbit.increaseAge();
        Assertions.assertEquals(false,maleRabbit.isMature());
    }
}