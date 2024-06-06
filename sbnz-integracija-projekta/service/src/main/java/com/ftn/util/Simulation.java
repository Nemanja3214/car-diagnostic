package com.ftn.util;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Simulation {
    public static LocalTime lastStart;
    public static boolean finished = false; 

    // Happy path 2 segments
    public static double calculateValue(double scale, LocalTime now) {
        if(lastStart == null)
            lastStart = now;
        
        // Calculate the elapsed time in minutes
        double minutes = Math.abs(ChronoUnit.SECONDS.between(now, lastStart)) / 60.0;
        
        // Variables to hold the start and end times for each segment
        long startTimeFirstSegment = 0;
        long endTimeFirstSegment = 1;
        long startTimeSecondSegment = 1;
        long endTimeSecondSegment = 3;
        
        // Variables to hold the start and end values for each segment
        double startValueFirstSegment = -50;
        double endValueFirstSegment = 0;
        double startValueSecondSegment = 25;
        double endValueSecondSegment = 0;
        
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


     // Happy path 3 segments
    public static double calculate3PartValue(double scale, LocalTime now) {
        if(lastStart == null)
            lastStart = now;
        
        // Calculate the elapsed time in minutes
        double minutes = Math.abs(ChronoUnit.SECONDS.between(now, lastStart)) / 60.0;
        
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


    public static double calculateDegradationValue(double scale, LocalTime now) {
        if(lastStart == null)
            lastStart = now;
        
        // Calculate the elapsed time in minutes
        double minutes = Math.abs(ChronoUnit.SECONDS.between(now, lastStart)) / 60.0;
        
        // Variables to hold the start and end times for each segment
        long startTimeFirstSegment = 0;
        long endTimeFirstSegment = 1;
        long startTimeSecondSegment = 1;
        long endTimeSecondSegment = 2;
        
        // Variables to hold the start and end values for each segment
        double startValueFirstSegment = -50;
        double endValueFirstSegment = 0;
        double startValueSecondSegment = 100;
        double endValueSecondSegment = 0;
        
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
    
}
