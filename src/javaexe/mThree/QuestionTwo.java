package javaexe.mThree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class QuestionTwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Date[] someDate = new Date[n];

        for (int i = 0; i < n; i++) {
            String line = sc.next();

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            try {
                Date date = simpleDateFormat.parse(line);
                someDate[i] = date;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        Date shortTime = someDate[0];
        for(int i =1; i<someDate.length;i++){
            if(someDate[i].getTime()<shortTime.getTime()){
                shortTime= someDate[i];
            }
        }
        System.out.println("swSpinnerTimeValue: " + new SimpleDateFormat("HH:mm:ss")
                .format(shortTime));

    }
}
