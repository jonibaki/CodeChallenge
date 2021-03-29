package javaexe.exercise4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class ex4 {
    public static long repeatedString(String s, long n) {

        long total_appearance= n/s.length();
        long reminder = n%s.length();
        long number_of_a =0;

        for (char c : s.toCharArray()){
            if(c=='a'){
                number_of_a++;
            }
        }
        long total= number_of_a*total_appearance;
        if(reminder!=0){
            for (int r=0; r<reminder; r++){
                if(s.charAt(r)=='a'){
                    total++;
                }
            }
        }

        return total;

    }
}
