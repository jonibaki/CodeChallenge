package javaexe.mThree;

import java.util.Scanner;


//TODO: optimise it to operate bigger number

public class QuestionOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        long r = sc.nextLong();

        int total = 0;



        while(l<=r){
            if(isLuckyNumber(l)) total++;
            l++;
        }

        System.out.println(total);

    }
    public static boolean isLuckyNumber(Long num){
        boolean isLucky = false;
        StringBuilder sbl = new StringBuilder(String.valueOf(num));
        for(int i =0; i<sbl.length(); i ++){
            int holdNumber = Integer.parseInt(String.valueOf(sbl.charAt(i)));
            if(holdNumber ==8){
                isLucky =true;
                if(i <sbl.length()-1){
                    for(int k = i+1; k<sbl.length();k++){
                        if( Integer.parseInt(String.valueOf(sbl.charAt(k)))==6) {
                            return false;
                        }
                    }
                }
            } else if(holdNumber ==6){
                isLucky =true;
                if(i <sbl.length()-1){
                    for(int k = i+1; k<sbl.length();k++){
                        if( Integer.parseInt(String.valueOf(sbl.charAt(k)))==8) {
                            return false;
                        }
                    }
                }
            }

        }
        return isLucky;

    }
}
