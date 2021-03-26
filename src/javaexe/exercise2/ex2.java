package javaexe.exercise2;

public class ex2 {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int level = 0;
        int total=0;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='D'){
                level--;
                if(level<0){
                    total++;
                }
            }
            if(s.charAt(i)=='U'){
                level++;
            }

        }
        return total;


    }

}
