package Tibra.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExerciseOne {
    public static Map<Integer,Long> finalArea;
    public long valuation(long reqArea, List<Long> area, List<Long> price) {
        finalArea = new HashMap<>();
        long result = 0;
        for(int i=0; i<area.size(); i++){
            List<Long> compList = getCompList(area,price,i,area.get(i));
            if(compList.size() > 0){
                long pMean = getMean(compList);
                long stdDiv = getStdDiv(compList,pMean);
                long areaWithPrice = Math.abs(price.get(i) - pMean);
                addToFinalArea(i,area.get(i), stdDiv, areaWithPrice);
            }else{
                finalArea.put(i,area.get(i));
            }

        }


        for(Map.Entry<Integer,Long> entryMap: finalArea.entrySet()){
            System.out.println(entryMap.getKey() +" "+entryMap.getValue() + " "+price.get(entryMap.getKey()));
        }




        //TODO:
        // Valuation of the calculated list
        // 0 house then use 1000 per sqFoot as the price
        // 1 house then use house price
        // 1 or more exact house then use the mean price of the houses
        //Interpolate:
            //price using the means of the closest higher and lower home
            // ? + (meanHighPriceA - meanHighPriceB)/ (highSqrFootA- lowSqrFootB) * (rqSqrFoot - closestVal2rqSqrFoot)
        //Extrapolate:
            //means of two houses value that are closest to the home
            // ? + (rqSqrFoot - closestVal_rqSqrFoot) * (meanHighPriceA - meanHighPriceB)/ (closestHigherSqrFootA- closetLowSqrFootB)
        return result;
    }
    public static void addToFinalArea(int index,long l, long sd, long price){
        System.out.println(l+" and sd :"+sd+" price: "+price);
        if(3*sd>=price){
            finalArea.put(index,l);
        }
    }
    public static List<Long> getCompList (List<Long> area,List<Long> price, int index, long areaLength){
        List<Long> aCompList = new ArrayList<>();
        for(int i=0; i<area.size(); i++){
            if(index != i && areaLength== area.get(i)){
                    aCompList.add(price.get(i));
            }
        }
        return aCompList;
    }
    public List<Long> associateArea(){
        return null;
    }
    public static long getMean(List<Long>compList){
        long total =0;
        for(long l: compList){
            total += l;
        }
        return total/compList.size();

    }
    public static long getStdDiv(List<Long>compList, long pMean){
        long priceHolder=0;
        for(int i=0; i<compList.size();i++){
            priceHolder += Math.pow((compList.get(i)-pMean),2);
        }
        return (long) Math.sqrt(priceHolder/compList.size());
    }
    public long calcValuation(long reqArea){
        return 0;

    }
}
