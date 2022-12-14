package enstabretagne.base.exercice.exerciceSortedList;
import  enstabretagne.base.exercice.exerciceSortedList.Toto;
import enstabretagne.base.time.LogicalDateTime;
import enstabretagne.simulation.basics.SortedList;

//exercice sur SortedListe
public class MainEx3 {
    public static void main(String[] args) {
        /*SortedList <Toto> liste = new SortedList<Toto>();
        for (int i=0; i<9; i++) {
            liste.add(new Toto() );
        }
        for (Toto t : liste) {
            System.out.println(t.valeur);
        }
    }*/
        /*sort logicalDateTime*/
        SortedList<LogicalDateTime> liste = new SortedList<LogicalDateTime>();
        /*Exemple de date*/
        String date = "10/12/2016 00:34:47.6789";
        String date1 = "10/10/2006 10:56:47.6789";
        String date2 = "14/12/2010 10:34:50.0000";
        String date3 = "01/02/2016 10:24:45.6789";
        String date4 = "01/03/2016 10:24:45.6789";

        /*ajoute les date à la liste*/
        liste.add(new LogicalDateTime(date));
        liste.add(new LogicalDateTime(date1));
        liste.add(new LogicalDateTime(date2));
        liste.add(new LogicalDateTime(date3));
        liste.add(new LogicalDateTime(date4));

        /*print la liste ordonnée*/
        for (LogicalDateTime l : liste) {
            System.out.println(l);
        }
    }
}