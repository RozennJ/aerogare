package engine;

/**
 * Generateur de scenario
 */
public abstract class Plan {
    private int nbScenario;

    public int getNbScenario(){
        return nbScenario;
    }

    private int nbScenarioActuel;
    public int getNbScenarioActuel(){
        return nbScenarioActuel;
    }

    public Plan(int nbScenario){
        this.nbScenario = nbScenario;
    }

    //cette m�thode permet de d�finir chaque sc�nario � ex�cuter
    //elle pr�suppose que votre impl�mentation saura stocker la d�finition de chaque sc�nario
    public abstract void initScenarii();

    //cette m�thode permet de savoir s'il y a encore un sc�nario � ex�cuter
    public abstract boolean hasNextScenario();

    //cette m�thode permet de r�cup�rer le prochain sc�nario.
    //renvoie null sinon
    public abstract Scenario nextScenario();

}
