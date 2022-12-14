package enstabretagne.helloworld;

import java.util.LinkedList;

import enstabretagne.base.time.LogicalDateTime;
import enstabretagne.engine.Plan;
import enstabretagne.engine.Scenario;
import enstabretagne.engine.SimuEngine;
import enstabretagne.helloworld.scenario.ScenarioENSTA;
import enstabretagne.helloworld.scenario.ScenarioEnstaInitData;

//dans notre cas simple on a choisi que la date de début et de fin serait commune à tous les scénarios
//mais il aurait pu en être autrement.
public class PlanHelloWorld extends Plan {

	LogicalDateTime debut;
	LogicalDateTime fin;

	public PlanHelloWorld(int nbReplique, LogicalDateTime debut, LogicalDateTime fin) {
		super(nbReplique);
		enstaSC = new LinkedList<>();
		this.debut = debut;
		this.fin = fin;
	}

	// liste chainée des définitions de scénarios à exécuter
	LinkedList<ScenarioENSTA> enstaSC;

	// création de la définition de chaque scénario
	@Override
	public void initScenarii() {
		//on crée autant d'instance d'un scénario donné que de répliques souhaitées
		//on prend l'entier du numéro de réplique comme graine
		
		//premier scénario: scénario à un seul étudiant
		for (int i = 0; i < getNbReplique(); i++)
			enstaSC.add(
					new ScenarioENSTA(getEngine(), new ScenarioEnstaInitData("Scenario 2 Etudiants", i, debut, fin, 1)));

		//deuxième scénario: scénario à 3 étudiants
		for (int i = 0; i < getNbReplique(); i++)
			enstaSC.add(new ScenarioENSTA(getEngine(),
					new ScenarioEnstaInitData("Scenario 4 Etudiants", i, debut, fin, 3)));
	}

	//récupération de la définition du scénario suivant
	@Override
	public Scenario nextScenario() {
		if (hasNextScenario()) {
			Scenario sc = enstaSC.pop();
			
			//on donne le scénario suivant au moteur
			engine.setCurrentScenario(sc);
			return sc;
		}
		return null;
	}

	@Override
	public boolean hasNextScenario() {
		return enstaSC.size() > 0;
	}

}
