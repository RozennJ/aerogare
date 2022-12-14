package engine;

import enstabretagne.base.time.LogicalDateTime;

public abstract class Scenario extends SimEntity {

    public LogicalDateTime getDebut(){
        return ((ScenarioInitData) getInitData()).getDebut();
    }
    public LogicalDateTime getFin() {
        return ((ScenarioInitData) getInitData()).getFin();
    }



    public Scenario(SimEngine engine,ScenarioInitData initSc) {
        super(engine, initSc);


    }

    /**
     * Creation des entites à simuler
     */
    public abstract void createSimEntity();
}
