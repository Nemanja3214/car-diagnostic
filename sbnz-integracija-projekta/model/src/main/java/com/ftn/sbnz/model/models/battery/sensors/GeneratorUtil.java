package com.ftn.sbnz.model.models.battery.sensors;

public class GeneratorUtil {
    public static double getACoefficient(double voltage){
        if(voltage >= 3.3 && voltage <= 3.452)
            return 26.55;
         else if(voltage >= 3.452 && voltage <= 3.508)
            return 125;
         else if(voltage >= 3.508 && voltage <= 3.595)
            return 149;
         else if(voltage >= 3.595 && voltage <= 3.676)
            return 344;
         else if(voltage >= 3.676 && voltage <= 3.739)
            return 229.5;
        else if(voltage >= 3.739 && voltage <= 3.967)
            return 111.9;
        else if(voltage >= 3.967 && voltage <= 4.039)
            return 104.8;
          else if(voltage >= 4.039 && voltage <= 4.132)
            return 90.61;
        return 0.0;
    }

        public static double getBCoefficient(double voltage){
        if(voltage >= 3.3 && voltage <= 3.452)
            return 88.6;
         else if(voltage >= 3.452 && voltage <= 3.508)
            return 431.1;
         else if(voltage >= 3.508 && voltage <= 3.595)
            return 516.1;
         else if(voltage >= 3.595 && voltage <= 3.676)
            return 1225;
         else if(voltage >= 3.676 && voltage <= 3.739)
            return 800.9;
        else if(voltage >= 3.739 && voltage <= 3.967)
            return 359.9;
        else if(voltage >= 3.967 && voltage <= 4.039)
            return 332;
          else if(voltage >= 4.039 && voltage <= 4.132)
            return 274.7;
        return 0.0;
    }

    public static double getInitialSoc(double voltage){
        return getACoefficient(voltage) * voltage - getBCoefficient(voltage);
    }



}
