package appli;

import engine.EntiteSimulee;
import engine.SimEvent;
import enstabretagne.base.logger.Logger;
import enstabretagne.base.time.LogicalDateTime;

public class Hello extends SimEvent {
    String message;
    public Hello(EntiteSimulee entiteSimulee, LogicalDateTime occurrenceDate, String name, String message) {
        super(entiteSimulee, occurrenceDate);
        this.message = "bonjour !";
    }



    @Override
    public void process() {
        System.out.println(this.message);
        Logger.Information(null,"process", "il a dit bonjour");
    }
}
