package engine;

/*Les entitees simulees seront :
 * Liste ordonnee d'avion qui atterissent (sur 1 jour : 7h:22h)
 * 4 portes (on pourra en faire 6 ou 8 apres)
 * TW1 et TW2
 * la Piste
 * */

public abstract class SimEntity {
    enum EtatEntity {NONE,INIT,DEAD};
    private InitData initData;
    private SimEngine engine;
    private EtatEntity etat;


    public SimEntity(SimEngine engine, ScenarioInitData initSc) {
    }

    public InitData getInitData(){return initData;}
    public SimEngine getEngine(){return engine;}
    public EtatEntity getEtat(){return etat; }


}
