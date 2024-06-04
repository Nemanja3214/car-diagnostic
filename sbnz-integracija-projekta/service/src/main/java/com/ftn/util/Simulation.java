package com.ftn.util;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Simulation {
    public static LocalTime lastStart;
    public static boolean finished = false; 

    // happy path
    public static double calculateValue(double scale) {
        if(lastStart == null)
            lastStart = LocalTime.now();
        
        // Calculate the elapsed time in minutes
        double minutes = Math.abs(ChronoUnit.SECONDS.between(LocalTime.now(), lastStart)) / 60.0;
        
        // Variables to hold the start and end times for each segment
        long startTimeFirstSegment = 0;
        long endTimeFirstSegment = 1;
        long startTimeSecondSegment = 1;
        long endTimeSecondSegment = 3;
        
        // Variables to hold the start and end values for each segment
        double startValueFirstSegment = -50;
        double endValueFirstSegment = 0;
        double startValueSecondSegment = 100;
        double endValueSecondSegment = 0;

        // // Variables to hold the start and end times for each segment
        // long startTimeFirstSegment = 0;
        // long endTimeFirstSegment = 30;
        // long startTimeSecondSegment = 30;
        // long endTimeSecondSegment = 90;
        
        // // Variables to hold the start and end values for each segment
        // double startValueFirstSegment = 50;
        // double endValueFirstSegment = 100;
        // double startValueSecondSegment = 100;
        // double endValueSecondSegment = 0;
        
        double value;
        
        // first 30 mins from 50 to 100, then drop to 0
        if (minutes <= endTimeFirstSegment) {
            // Linearly interpolate between startValueFirstSegment and endValueFirstSegment over 30 minutes
            value = startValueFirstSegment + ((endValueFirstSegment - startValueFirstSegment) / (endTimeFirstSegment - startTimeFirstSegment)) * minutes;
        } else if (minutes <= endTimeSecondSegment) {
            // Linearly interpolate between startValueSecondSegment and endValueSecondSegment over the next hour
            value = startValueSecondSegment - ((startValueSecondSegment - endValueSecondSegment) / (endTimeSecondSegment - startTimeSecondSegment)) * (minutes - startTimeSecondSegment);
        } else {
            // After 90 minutes, the value remains 0
            value = 0;
            finished = true;
        }
        
        return value / scale;
    }

        // happy path
    public static double calculate3PartValue(double scale) {
        if(lastStart == null)
            lastStart = LocalTime.now();
        
        // Calculate the elapsed time in minutes
        double minutes = Math.abs(ChronoUnit.SECONDS.between(LocalTime.now(), lastStart)) / 60.0;
        
        // Variables to hold the start and end times for each segment
        long startTimeFirstSegment = 0;
        long endTimeFirstSegment = 1;
        long startTimeSecondSegment = 1;
        long endTimeSecondSegment = 2;

        long startTimeThirdSegment = 2;
        long endTimeThirdSegment = 3;
        
        // Variables to hold the start and end values for each segment
        double startValueFirstSegment = -50;
        double endValueFirstSegment = 0;
        double startValueSecondSegment = 50;
        double endValueSecondSegment = 0;

        double startValueThirdSegment = -50;
        double endValueThirdSegment = 0;
        
        double value;
        
        // first 30 mins from 50 to 100, then drop to 0
        if (minutes <= endTimeFirstSegment) {
            // Linearly interpolate between startValueFirstSegment and endValueFirstSegment over 30 minutes
            value = startValueFirstSegment + ((endValueFirstSegment - startValueFirstSegment) / (endTimeFirstSegment - startTimeFirstSegment)) * minutes;
        } else if (minutes <= endTimeSecondSegment) {
            // Linearly interpolate between startValueSecondSegment and endValueSecondSegment over the next hour
            value = startValueSecondSegment - ((startValueSecondSegment - endValueSecondSegment) / (endTimeSecondSegment - startTimeSecondSegment)) * (minutes - startTimeSecondSegment);
        }  else if (minutes <= endTimeThirdSegment) {
            // Linearly interpolate between startValueSecondSegment and endValueSecondSegment over the next hour
            value = startValueThirdSegment + ((endValueThirdSegment - startValueThirdSegment) / (endTimeThirdSegment - startTimeThirdSegment)) * (minutes - startTimeThirdSegment);
        } else {
            // After 90 minutes, the value remains 0
            value = 0;
            finished = true;
        }
        
        return value / scale;
    }
    
}
