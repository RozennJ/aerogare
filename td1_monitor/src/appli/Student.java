package appli;

import engine.EntiteSimulee;
import engine.InitData;
import engine.SimuEngine;

public class Student extends EntiteSimulee {


    public Student(SimuEngine engine, InitData data) {
        super(engine, data);
        //Hello hello = new  Hello(this, , name, "bonjour !");
    }

    @Override
    public InitStudent getInitData() {

        return (InitStudent) getInitData();
    }


    @Override
    public int compareTo(EntiteSimulee entiteSimulee) {
        return 0;
    }
}
