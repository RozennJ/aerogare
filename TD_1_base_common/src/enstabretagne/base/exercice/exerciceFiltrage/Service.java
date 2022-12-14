package enstabretagne.base.exercice.exerciceFiltrage;
import java.util.*;
import java.util.function.Predicate;

public class Service {


    public static ArrayList<Integer> Filter (List<Integer> list,  Predicate<Integer> lambda){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Integer i: list){
            if(lambda.test(i)){
                result.add(i);
            }
        }
        return result;

    }


}
