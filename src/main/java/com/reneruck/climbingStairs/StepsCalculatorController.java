package com.reneruck.climbingStairs;


import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Rene on 01/05/2017.
 */
public class StepsCalculatorController {

    public JSONObject handle(String stepsPerFlight, int stepsPerStride) {
        int[] stepsPerFlightArray = new JSONArray(stepsPerFlight).toList().stream().mapToInt(n -> Integer.valueOf((int)n)).toArray();
        int steps = new StepsCalculator(stepsPerFlightArray, stepsPerStride).calculateSteps();
        return new JSONObject().put("steps", steps);
    }
}
