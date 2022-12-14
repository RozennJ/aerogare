package enstabretagne.base.exercice.exerciceSortedList;
import java.util.Random;
public class Toto implements Comparable<Toto>{
    int valeur;
    public Toto() {
        this.valeur = (int) (Math.random()*10);
    }

    @Override
    public int compareTo(Toto toto) {
        return Integer.compare(this.valeur, toto.valeur);
    }

}
