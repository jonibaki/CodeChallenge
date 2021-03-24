package javaexe.exercise1;

import java.util.ArrayList;
import java.util.List;

public class exerciseOne {
    public static int sockMerchant(int n, int[] ar) {
        // we collect the distinct in an array
        // count how many they are and divide and mod by 2= total pair (colour) &&                      remainng odd one (colour)
        // then add up all the pair
        int totalPair = 0;
        List<Integer> distinctColour = new ArrayList<Integer>();
        for(int i : ar){
            if(!distinctColour.contains(i)){
                distinctColour.add(i);
            }
        }
        for (Integer colour: distinctColour){
            int tempPair =0;
            for (int i : ar){
                if (i==colour){
                    tempPair++;
                }
            }
            totalPair += tempPair/2;
        }
        return totalPair;
    }
}
