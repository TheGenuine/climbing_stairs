package com.reneruck.climbingStairs;

import java.util.Arrays;

/**
 * Created by Rene on 01/05/2017.
 */
class StepsCalculator {

    private int[] flights;
    private int stepsPerStride;

    StepsCalculator(int[] flights, int stepsPerStride) {
        this.flights = flights;
        this.stepsPerStride = stepsPerStride;
    }

    int calculateSteps(){
        int stridesOnFlight = Arrays.stream(flights).map(flight -> flight % stepsPerStride == 0 ? flight / stepsPerStride : (flight / stepsPerStride) + 1).sum();
        int stridesOnLanding = flights.length > 1 ? (flights.length-1) * 2 : 0;
        return stridesOnFlight + stridesOnLanding;
    }
}
