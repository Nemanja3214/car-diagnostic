package com.ftn.sbnz.model.models;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.ftn.sbnz.model.models.FaultProblems.BreakingSensorsProblem;
import com.ftn.sbnz.model.models.FaultProblems.FaultProblem;
import com.ftn.sbnz.model.models.FaultProblems.HVACProblem;
import com.ftn.sbnz.model.models.FaultProblems.HVACProblemKinds;
import com.ftn.sbnz.model.models.FaultProblems.InfotainmentProblem;
import com.ftn.sbnz.model.models.FaultProblems.InvertorProblem;
import com.ftn.sbnz.model.models.FaultProblems.MotorProblem;
import com.ftn.sbnz.model.models.FaultProblems.PowertrainProblems;
import com.ftn.sbnz.model.models.FaultProblems.WheelSpeedProblem;

public class Util {
          private static final List<FaultCodes> VALUES = Collections.unmodifiableList(Arrays.asList(FaultCodes.values()));
        private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

  public static FaultCodes randomCode()  {
    return VALUES.get(RANDOM.nextInt(SIZE));
  }

    public static HVACProblemKinds randomHVACProblem()  {
      List<HVACProblemKinds> vals = Collections.unmodifiableList(Arrays.asList(HVACProblemKinds.values()));
      return vals.get(RANDOM.nextInt(vals.size()));
  }

  public static PowertrainProblems checkPowertrain(String carId){
    if(RANDOM.nextBoolean())
        return new MotorProblem(RANDOM.nextInt(100), carId);
    else
        return new InvertorProblem(RANDOM.nextDouble()*4000.0, carId);
  }

public static FaultProblem checkAuxiliary(String carId) {
     if(RANDOM.nextBoolean())
        return new HVACProblem(randomHVACProblem(), carId);
    else
        return new InfotainmentProblem(carId);
}

public static FaultProblem checkRegenerativeBreaking(String carId) {
     if(RANDOM.nextBoolean())
        return new WheelSpeedProblem(RANDOM.nextDouble()*100.0, carId);
    else
        return new BreakingSensorsProblem(carId);
}
}
