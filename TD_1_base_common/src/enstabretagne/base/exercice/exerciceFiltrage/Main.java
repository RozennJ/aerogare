package enstabretagne.base.exercice.exerciceFiltrage;

import java.util.*;

public class Main {
    public static void main(String[] args){
        List<Integer> liste= new ArrayList<Integer>();
        for (int i=0; i<10; i++){
            liste.add((int) (Math.random()*10 + 1));
        }
        ArrayList<Integer> res = Service.Filter(liste, i -> i < 7);
        System.out.println(res);
    }
}
