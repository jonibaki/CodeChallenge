package javaexe.exercise6;

public class ex6 {
    public static int[] rotLeft(int[] a, int d) {
        int [] arr = new int [a.length];
        for(int i=0; i<d;i++){
            arr[i] = a[i];
        }
        for(int num : arr){
            System.out.println(num);
        }
        return arr;

    }
}
