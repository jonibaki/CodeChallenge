package Tibra.com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TibraRunner {
    public static void main(String[] args) {

        //exercise One data and class
        ExerciseOne exerciseOne = new ExerciseOne();
        List<Long> area = new ArrayList<>();
        List<Long> price = new ArrayList<>();
        long reqArea = 1500;
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

        //exercise Two data and class
//        List<Integer> node_values = new ArrayList<>();
//        node_values.add(1);
//        node_values.add(3);
//        node_values.add(-1);
//        node_values.add(3);
//        node_values.add(1);
//        node_values.add(5);
//        System.out.println(ExerciseTwo.maximum_path(node_values));

        //exercise three data and class
 /*       List<String> highValList = new ArrayList<>();
         try {
         BufferedReader bf = new BufferedReader(new FileReader("src/resources/input000.txt"));
         String line = bf.readLine();
         while(line !=null){
             highValList.add(line);
             line = bf.readLine();
         }
         } catch (FileNotFoundException e) {
         e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
        ExerciseThree exerciseThree = new ExerciseThree();
//        highValList.add("20");
//        highValList.add("7/11/20212 0:00:0      345");
//        highValList.add("7/11/20212 0:00:0      Missing_20");
//        highValList.add("7/11/20212 0:00:0      345");
//        highValList.add("7/11/20212 0:00:0      Missing_10.2");
//        highValList.add("7/11/20212 0:00:0      345");
//        highValList.add("7/11/20212 0:00:0      Missing_20.5");
//        highValList.add("7/11/20212 0:00:0      345");
//        highValList.add("7/11/20212 0:00:0      345");
//        highValList.add("7/11/20212 0:00:0      Missing_5.3");
//        highValList.add("7/11/20212 0:00:0      345");
//        highValList.add("7/11/20212 0:00:0      Missing_40");
        exerciseThree.calcMissing(highValList);
*/
    }
}
