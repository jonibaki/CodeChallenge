    package javaexe.assessment;

    import java.io.BufferedReader;
    import java.io.IOError;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.math.BigDecimal;
    import java.math.RoundingMode;
    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.*;


    public class Assessment {
        public static void main(String[] args) throws IOError, IOException {
            final long FIRST_HOUR = 3;
            final long EACH_MIN = 1;
            Assessment parking = new Assessment();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String end = "";
            while(!end.equals("quit")){
                System.out.println("Please enter starting time");
                String start_time = reader.readLine();
                parking.is_valid_parking_time(start_time);
                System.out.println("Time in : "+start_time);

                System.out.println("Please enter ending time");
                String end_time = reader.readLine();
                System.out.println("Time out : "+end_time);


                long parking_duration = 0;
                try {
                    parking_duration = parking.get_calculate_duration(start_time, end_time);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if(parking_duration/60>24){
                    System.out.println("BAD NEWS:: Your car got towed!!!");
                    break;
                }else{
                    double total_cost = parking.get_calculate_cost(FIRST_HOUR,EACH_MIN,parking_duration);
                    double bill_paid_in = 0.0;
                    double total_payment_in = parking.authorise_bill_entry(bill_paid_in,total_cost, reader);


                    String due_changed = parking.get_due_change(total_payment_in,total_cost).replace(" ",", ");

                    System.out.println("Output Change : "+due_changed);

                }

                System.out.println("Type \'quit\' to terminate or press \"Enter\" to pay for another parking ticket");
                end = reader.readLine();
            }

        }

        //can't be asked to do this func
        private boolean is_valid_parking_time(String t){
            boolean operator = t.contains(":");
    //        int i =Arrays.asList(t).stream().filter(x->x.equals(":")).count();
    //        System.out.println(i);
    //        if(t.substring(0,i)){
    //
    //        }

            return operator;

        }
        private  double authorise_bill_entry(double bill_paid_in, double original_cost, BufferedReader reader) throws IOException {
            while(bill_paid_in<=original_cost){
                System.out.println("Payment Accepts In: [£20 \t£10 \t£5 \t£1 \t50p \t20p \t10p \t5p \t2p \t1p]");
                String read = reader.readLine();
                switch (read){
                    case "£20":
                        bill_paid_in+=20;
                        break;
                    case "£10":
                        bill_paid_in+=10;
                        break;
                    case "£5":
                        bill_paid_in+=5;
                        break;
                    case "£1":
                        bill_paid_in+=1;
                        break;
                    case "50p":
                        bill_paid_in+=0.50;
                        break;
                    case "20p":
                        bill_paid_in+=0.20;
                        break;
                    case "10p":
                        bill_paid_in+=0.10;
                        break;
                    case "5p":
                        bill_paid_in+=0.05;
                        break;
                    case "2p":
                        bill_paid_in+=0.02;
                        break;
                    case "1p":
                        bill_paid_in+=0.01;
                        break;
                    default:
                        System.out.println("Invalid amount options!");
                        System.out.println("Example: notes/coins in pound \"£1\" and coins in penny \"50p\" \n");
                }
                if(original_cost-bill_paid_in>0){
                    System.out.printf("Payment in £%.2f | Remains £%.2f \n",bill_paid_in, original_cost-bill_paid_in );
                }else{
                    System.out.printf("Paid £%.2f | Collect Change £%.2f \n",bill_paid_in, bill_paid_in-original_cost );
                }

            }
            return bill_paid_in;
        }
        private long get_calculate_duration(String time_start, String time_end) throws ParseException {

            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date parking_start = null;
            try {
                parking_start = format.parse(time_start);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date parking_end = null;
            try {
                parking_end = format.parse(time_end);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            long duration = 0;

            if(parking_end.getTime() < parking_start.getTime()){
                Date end_of_day= format.parse("24:60");
                duration = (end_of_day.getTime()-parking_start.getTime()+ parking_end.getTime())/1000;
            }else {
                duration = (parking_end.getTime() - parking_start.getTime())/1000;
            }
            return duration/60;
        }
        private double get_calculate_cost(long first_hour, long each_min, long duration){
            long hour = duration/60;
            long min = duration%60;

            if(hour>1){
                min = min+((hour-1)*60);
            }
            double total_cost = first_hour +  (double)(min*each_min)/100;
            System.out.println("Output Cost : "+ total_cost);
            return total_cost;

        }
        private String get_due_change(double payment_in, double total_cost){
            System.out.println("Output Cost : "+total_cost);
            StringBuilder change_receive = new StringBuilder();

            Map<Double, String> money_bank = new TreeMap<>(Collections.reverseOrder());
            money_bank.put(20.0,"£20");
            money_bank.put(10.0,"£10");
            money_bank.put(5.0,"£5");
            money_bank.put(1.0,"£1");
            money_bank.put(0.50,"50p");
            money_bank.put(0.20,"20p");
            money_bank.put(0.10,"10p");
            money_bank.put(0.05,"5p");
            money_bank.put(0.02,"2p");
            money_bank.put(0.01,"1p");

            double cash_return = new BigDecimal(payment_in-total_cost).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
            while(cash_return>0){
                for(Map.Entry<Double, String> bankIndex:money_bank.entrySet()){
                    if(bankIndex.getKey()<=cash_return){
                        cash_return = new BigDecimal(cash_return-bankIndex.getKey()).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
                        change_receive.append(String.valueOf(bankIndex.getValue())).append(" ");
                        break;
                    }
                }

            }

            return change_receive.toString().trim();
        }
    }
