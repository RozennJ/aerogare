package engine;
import enstabretagne.simulation.basics.ISimulationDateProvider;
import enstabretagne.simulation.basics.SortedList;
import enstabretagne.base.time.LogicalDateTime;

import java.util.ArrayList;
import java.util.Comparator;

public class SimuEngine{
    private LogicalDateTime start;
    private LogicalDateTime end;
    /*sort SimEvent : echeancier*/
    SortedList<SimEvent> listeEvent = new SortedList<SimEvent>();

    /*sort EntitesSimulees*/
    protected SortedList<EntiteSimulee> entiteSimulees;

}
