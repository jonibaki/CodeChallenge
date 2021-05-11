package Tibra.com;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ExerciseThree {    public static void calcMissing(List<String> readings) {
    List<Float> missingDataSet = new ArrayList<>();
    int numOfRows = 0;
    for (int i = 0; i < readings.size(); i++) {
//            if(i==0){
//                numOfRows= Integer.parseInt(readings.get(i));
//            }else
        if (readings.get(i).contains("Missing_")) {
            //check if the index is first in position
            if (i == 1 && readings.get(i).contains("Missing_")) {
                //do the different calculation and add the result in a container
                int nextIndexOne = getNextValue(readings, 2);
                int nextIndexTwo = getNextValue(readings, nextIndexOne + 1);
                int a = nextIndexTwo - nextIndexOne;
                float newMissingValue = getData(readings, nextIndexOne) - (getData(readings, nextIndexTwo) - getData(readings, nextIndexOne) / a) * nextIndexOne;
                missingDataSet.add(newMissingValue);
            } else if (i == readings.size() - 1 && readings.get(i).contains("Missing_")) { //found in last
                //do the extrapolation calculation and add the result in the container
                int prevIndexOne = getPreviousValue(readings, i-1);
                int prevIndexTwo = getPreviousValue(readings, prevIndexOne - 1);
                int k = readings.size()  - prevIndexOne;
                int a = readings.size()  - prevIndexTwo;
                float newMissingValue = getData(readings, prevIndexOne) + (getData(readings, prevIndexOne) - getData(readings, prevIndexTwo) / a) * k;
                missingDataSet.add(newMissingValue);
            } else { //in the middle somewhere in a dataset
                //do the interpolation calculation and add to the container
                int prevIndex = getPreviousValue(readings, i - 1);
                int nextIndex = getPreviousValue(readings, i + 1);
                int k = Math.abs(prevIndex - i);
                int a = Math.abs(nextIndex - i);
                float newMissingValue = getData(readings, prevIndex) + (getData(readings, nextIndex) - getData(readings, prevIndex) / (a + k)) * k;
                missingDataSet.add(newMissingValue);

            }
        }
    }
    for (Float f : missingDataSet) {
        System.out.printf("%.2f\n",f);
    }

}

    public static int getPreviousValue(List<String> data, int index) {
        int prevIndex = 0;
        for (int i = index; i >= 0; i--) {
            String[] temp = data.get(i).split("\\t");
            if (!temp[1].contains("Missing_")) {
                prevIndex = i;
                break;
            }

        }
        return prevIndex;

    }

    public static int getNextValue(List<String> data, int index) {
        int nextIndex = 0;
        for (int i = index; i <data.size(); i++) {
            String[] temp = data.get(i).split("\\t");
            if (!temp[1].contains("Missing_")) {
                nextIndex = i;
                break;
            }
        }
        return nextIndex;

    }

    public static float getData(List<String> readings, int index) {
        float data = 0;
        for (int i = index; i < readings.size(); i++) {
            String[] readingValues = readings.get(i).split("\\t");
            data = Float.parseFloat(readingValues[1]);
            break;
        }
        return data;
    }

}
