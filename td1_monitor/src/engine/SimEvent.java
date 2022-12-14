package engine;
import enstabretagne.base.time.LogicalDateTime;
public abstract class SimEvent implements Comparable<SimEvent>{

    private EntiteSimulee entiteSimulee ;
    private LogicalDateTime occurrenceDate;


    public SimEvent(EntiteSimulee entiteSimulee, LogicalDateTime occurrenceDate) {
        this.entiteSimulee = entiteSimulee;
        this.occurrenceDate = occurrenceDate;

    }

    @Override
    public int compareTo(SimEvent simEvent) {
        return this.occurrenceDate.compareTo(simEvent.occurrenceDate);
    }

    public abstract void process();



}
