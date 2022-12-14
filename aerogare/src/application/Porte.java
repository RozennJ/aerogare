package application;

import engine.SimEngine;
import engine.SimEntity;

public class Porte extends SimEntity {
    public boolean libre;

    public Porte(SimEngine engine) {
        super(engine, initSc);
    }
}
