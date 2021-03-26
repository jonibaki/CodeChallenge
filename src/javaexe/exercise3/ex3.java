package javaexe.exercise3;

public class ex3 {

    public static int jumpingOnClouds(int[] c) {
        int totalJump = 0;
        int index = 0;
        while (index < c.length-1) {
                for (int i = index + 1; i < c.length; i++) {
                    if (c[i] == 1 && i != c.length-1) {
                        totalJump++;
                        index = i + 1;
                        break;
                    } else if (i != c.length - 1) {
                        if (c[i] == c[index] && c[index] == c[i + 1]) {
                            totalJump++;
                            index = i + 1;
                            break;
                        } else if (c[i] != 1) {
                            totalJump++;
                            index = i;
                            break;
                        }
                    }else{
                            totalJump++;
                            index = i;
                            break;
                    }

                }
            }
        return totalJump;
    }
}
