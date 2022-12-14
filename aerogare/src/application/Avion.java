package application;

import engine.SimEngine;
import engine.SimEntity;
import enstabretagne.base.time.LogicalDateTime;

public class Avion extends SimEntity{
    public Avion(SimEngine engine) {
        super(engine, initSc);
        int numVol;
        LogicalDateTime heure_prevue;
        LogicalDateTime heure;
    }

    public void decollage(){
        Decollage decollage = new Decollage();

    }
    public void atterissage(){
        Atterissage atterissage = new Atterissage();

    }
}