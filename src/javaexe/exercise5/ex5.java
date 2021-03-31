package javaexe.exercise5;

import java.util.Arrays;

public class ex5 {
    // Complete the hourglassSum function below.
    public static int hourglassSum(int[][] arr) {
        int max =0;
        int offset =1;
        for(int row = 1; row<arr.length-1; row++){
            for (int col = 1; col < arr.length-1 ; col++) {
                int top_left = arr[row-offset][col-offset];
                int top_centre = arr[row-offset][col];
                int top_right = arr[row-offset][col+offset];
                int centre = arr[row][col];
                int bottom_left = arr[row+offset][col-offset];
                int bottom_centre = arr[row+offset][col];
                int bottom_right = arr[row+offset][col+offset];

                int total = top_left+top_centre+top_right+centre
                        +bottom_left+bottom_centre+bottom_right;
                if(max<total) max= total;
            }
        }
        return max;
    }

}
