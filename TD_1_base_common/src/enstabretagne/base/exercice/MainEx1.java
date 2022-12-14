package enstabretagne.base.exercice;
import enstabretagne.base.time.LogicalDateTime;
import enstabretagne.base.time.LogicalDuration;
public class MainEx1 {
    public static void main(String[] args){
        String date = "10/12/2016 10:34:47.6789";
        LogicalDateTime logical_date_time = new LogicalDateTime(date);
        System.out.println(logical_date_time);
        LogicalDuration offset = LogicalDuration.ofDay(2);
        //on fait une copy de la date pour y ajouter 2 jours
        LogicalDateTime copy = logical_date_time.getCopy();
        copy = logical_date_time.add(offset);
        System.out.println(copy);

        LogicalDateTime hours = logical_date_time.truncateToHours();
        System.out.println("hours : " + hours);

    }
}
