package engine;
import enstabretagne.base.time.LogicalDateTime;
public abstract class EntiteSimulee implements Comparable<EntiteSimulee> {
    private InitData initData;
    private  SimuEngine simuEngine;
    public InitData getInitData() {
        return initData;
    }
    public EntiteSimulee(SimuEngine engine, InitData initData) {
        this.simuEngine = engine;
        this.initData = initData;
        engine.entiteSimulees.add(this);
    }
}
