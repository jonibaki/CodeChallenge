package Tibra.com;

import java.util.List;

public class ExerciseThree {
    public  void calcMissing(List<String> readings) {
        for(int i=0; i<readings.size(); i++){
            if(readings.get(i).contains("Missing")){
                String[]readingValues = readings.get(i).split("\\t\\t");
                String[] strVal = readingValues[1].split("_");
                float missingVal = Float.parseFloat(strVal[1]);
                //TODO: work out the missing value

                System.out.println(missingVal);
            }
        }
        System.out.println("End of Exercise Three");

    }

}
