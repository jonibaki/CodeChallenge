package Tibra.com;

import java.util.ArrayList;
import java.util.List;

public class TibraRunner {
    public static void main(String[] args) {
        //exercise One data and class
        ExerciseOne exerciseOne = new ExerciseOne();
        List<Long> area = new ArrayList<>();
        List<Long> price = new ArrayList<>();
        long reqArea = 1200;
        area.add(1200L);
        area.add(1300L);
        area.add(1200L);
        area.add(1300L);
        area.add(1200L);
        area.add(2000L);

        price.add(12000L);
        price.add(24000L);
        price.add(14000L);
        price.add(22000L);
        price.add(13000L);
        price.add(30000L);


        exerciseOne.valuation(reqArea,area, price);
        /***
        //exercise three data and class
        ExerciseThree exerciseThree = new ExerciseThree();
        List<String> highValList = new ArrayList<>();
        highValList.add("7/11/20212 0:00:0\t\t345");
        highValList.add("7/11/20212 0:00:0\t\tMissing_20");
        highValList.add("7/11/20212 0:00:0\t\t345");
        highValList.add("7/11/20212 0:00:0\t\tMissing_10.2");
        highValList.add("7/11/20212 0:00:0\t\t345");
        highValList.add("7/11/20212 0:00:0\t\tMissing_20.5");
        highValList.add("7/11/20212 0:00:0\t\t345");
        highValList.add("7/11/20212 0:00:0\t\t345");
        highValList.add("7/11/20212 0:00:0\t\tMissing_5.3");
        highValList.add("7/11/20212 0:00:0\t\t345");
        highValList.add("7/11/20212 0:00:0\t\tMissing_40");
        exerciseThree.calcMissing(highValList);
         ***/
    }
}
