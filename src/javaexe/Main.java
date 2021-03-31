package javaexe;

import static javaexe.exercise1.exerciseOne.sockMerchant;
import static javaexe.exercise3.ex3.jumpingOnClouds;
import static javaexe.exercise4.ex4.repeatedString;
import static javaexe.exercise5.ex5.hourglassSum;

public class Main {
    public static void main (String []args){
        System.out.println("Java Code execution from Java folder");
        int [] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int [] exThree = {0,0,0,1,0,0,1,0,0};
        long n = 1000000000000L;
        String s = "abc";

//        System.out.println("Total pair "+ sockMerchant(9, ar));
//       System.out.println("Min jumps "+ jumpingOnClouds(exThree));
//        System.out.println(repeatedString( s, n));
        int [][] test = {{-9, -34, -9, 12,1,4},{-10, 0, 2,8, 2,3},{-2,7, -1,1, -2, 10},{9,  1,7, 2,5, 18},{9,  1,7, 2,5, 18},{9,  1,7, 2,5, 18}};
        hourglassSum(test);

    }
}
