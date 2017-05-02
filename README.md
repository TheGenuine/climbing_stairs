# Climbing stairs

## The Problem
A stairwell has a number of flights of stairs separated by landings. 
Each flight is a straight line of steps that you can climb without stopping.  You can stride more than one step at a time when climbing each flight.
It takes two strides to turn on the landing and start again on next flight of stairs.

As input, you are given an array listing the number of steps in each flight of stairs in the stairwell.  You also receive the number of steps you can cover with each stride (you could climb 2 steps per stride, or 3 steps per stride if you were tall and fit).

The stairwell has between 1 and 30 flights inclusive.  Each flight can have a maximum of 20 steps.  You can stride between 1 and 4 steps inclusive.

The solution will calculate the minimum number of strides necessary to get to the top of the stairwell.

## Requirements

- Java 1.8

## How to build

On Unix:
```bash
./gradlew clean build
```

On Windows:
```bash
gradlew.bat clean build
```

## How to run
On Unix:
```bash
./gradlew run
```

On Windows:
```bash
gradlew.bat run
```

## How to use
The app exposes 1 endpoint `http://localhost:8080/steps`

**Params**  
| Name | Required | example |  
|------|----------|----------|  
| stepsPerFlight | YES | [17] |  
| stepsPerStride | YES | 3 |

```bash
curl http://localhost:8080/steps?stepsPerFlight=\[17\]&stepsPerStride=3
```