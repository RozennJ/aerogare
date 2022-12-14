package engine;

import enstabretagne.base.time.LogicalDateTime;

public class ScenarioInitData extends InitData{
    int graine;

    LogicalDateTime debut;
    LogicalDateTime fin;

    public ScenarioInitData(String id) {
        super(id);
        this.debut = debut;
        this.fin = fin;
        this.graine = graine;

    }
    public int getGraine(){return graine;}

    public LogicalDateTime getDebut(){return debut; }

    public LogicalDateTime getFin(){return fin;}



}
