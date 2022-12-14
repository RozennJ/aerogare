package application;

import engine.SimEngine;
import engine.SimEntity;

public class Piste extends SimEntity {
    public boolean libre;

    public Piste(SimEngine engine) {
        super(engine, initSc);

    }
}
