package javaexe.exercise2;

public class ex2 {

    // Complete the countingValleys function below.
    static int countingValleys(int steps, String path) {
        int level = 0;
        int total=0;
        boolean below = true;
        for(int i=0; i<steps;i++){
            if(path.charAt(i)=='D'){
                level--;
                if(level<0 && below){
                    total++;
                    below= false;
                }
            }
            if(path.charAt(i)=='U'){
                level++;
                if(!below && level>-1) below = true;
            }

        }
        return total;
    }

}
