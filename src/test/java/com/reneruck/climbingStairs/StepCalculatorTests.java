package com.reneruck.climbingStairs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Rene on 01/05/2017.
 */
public class StepCalculatorTests {

    @Test
    public void singleFlightShouldReturn6(){
        int steps = new StepsCalculator(new int[]{17}, 3).calculateSteps();

        assertEquals(6, steps);
    }

    @Test
    public void doubleFlightShouldReturn14(){
        int steps = new StepsCalculator(new int[]{17, 17}, 3).calculateSteps();

        assertEquals(14, steps);
    }

    @Test
    public void multipleFlightsShouldReturn50(){
        int steps = new StepsCalculator(new int[]{4,9,8,11,7,20,14}, 2).calculateSteps();

        assertEquals(50, steps);
    }
}
