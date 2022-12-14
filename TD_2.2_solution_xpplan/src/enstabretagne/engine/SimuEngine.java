package enstabretagne.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import enstabretagne.base.logger.Logger;
import enstabretagne.base.math.MoreRandom;
import enstabretagne.base.time.LogicalDateTime;
import enstabretagne.engine.EntiteSimulee.EtatEntite;
import enstabretagne.simulation.basics.IScenarioIdProvider;
import enstabretagne.simulation.basics.ISimulationDateProvider;
import enstabretagne.simulation.basics.ScenarioId;
import enstabretagne.simulation.basics.SortedList;
/*
 * SimuEngine implémente ISimulationDateProvider et IScenarioIdProvider
 * Il est donc apte à délivrer :
 * - un temps logique
 * - l'identifiant du scénario en cours * 
 */
public class SimuEngine implements ISimulationDateProvider, IScenarioIdProvider{
	
	//échéancier. Pièce principale du moteur
	private SortedList<SimEvent> echeancier;
	//dates de début et fin de fonctionnement de la simulation
	private LogicalDateTime start;
	private LogicalDateTime end;
	
	//Liste des entités de simulation créées et connues du moteur
	protected List<EntiteSimulee> mesEntitesSimulees; 

	//temps logique de la simulation géré par le moteur de simulation
	private LogicalDateTime currentDate;
	protected LogicalDateTime getCurrentDate()
	{
		return currentDate;
	}
	
	//générateur de nombre aléatoire principal du moteur de simulation
	private MoreRandom randomGenerator;
	MoreRandom getRandomGenerator() {
		return randomGenerator;
	}

	//scénario en cours d'exécution
	Scenario currentscenario;
	public Scenario getCurrentscenario() {
		return currentscenario;
	}
	public void setCurrentScenario(Scenario sc) {
		currentscenario = sc;
		//on réinitialise le générateur avec la nouvelle graine à chaque changement de scénario
		randomGenerator = new MoreRandom(sc.getGraine());
	}

	public SimuEngine() {
		echeancier = new SortedList<>();
		mesEntitesSimulees = new ArrayList<>();
		//on initialise le journaliseur
		Logger.setDateProvider(this);
	}

	//initialisation de la simulation avec paramètres de début et fin
	public void initSimulation(LogicalDateTime start, LogicalDateTime end) {
		//initialisation du temps logique de la simulation 
		//et des bornes temporelles d'exécution de la simulation
		this.start=start;
		currentDate = this.start;
		this.end = end;
		
		//initialisation des entités simulées
		for(EntiteSimulee e:mesEntitesSimulees)
			e.requestInit();
	}
	
	//initialisation de la simulation sans paramètres de début et fin
	//Le début et fin viennent du scénario
	public void initSimulation() {
		if(currentscenario!=null) {
			this.start=currentscenario.getDebut();
			currentDate = this.start;
			this.end = currentscenario.getFin();
			
			currentscenario.requestInit();
		}
	}

	//seule méthode donnant accès à l'échéancier
	protected void Post(SimEvent ev) {
		echeancier.add(ev);
	}
	
	//boucle de simulation
	public void simulate()
	{
		//simple parcours de l'échéancier
		while(hasANextEvent())
		{
			//on prend le premier événement suivant de l'échéancier
			SimEvent ev = echeancier.first();
			//on l'enlève de l'échéancier
			echeancier.remove(ev);
			
			//si l'entité est DEAD on ne tire pas l'événement
			if(ev.entitePorteuseEvenement.getEtat()==EtatEntite.INITIALIZED) {
				currentDate = ev.getDateOccurence();
				ev.process();
			}
		}
	}
	
	public void terminate(boolean last) {
		//on vide l'échéancier.
		//il peut contenir des événements restants
		//indispensable pour le prochain run
		echeancier.clear();
		
		//on termine les entités.
		//on vide la liste des entités
		for(EntiteSimulee e:mesEntitesSimulees)
		{
			//seule l'entité scénario persiste d'un run à l'autre			
			if(!last) {
				if(!(e instanceof Scenario)) e.terminate();
			}
			else
				e.terminate();
		}
		mesEntitesSimulees.clear();
		
		//on ne fait plus référence au scénario précédent
		currentscenario = null;
		
		//on met à zero les éléments de temps logique
		currentDate = null;
		start = null;
		end = null;

		//on sollicite le garbage collector pour qu'il cleane la mémoire
		//c'est un bon moment pour le faire
		System.gc();

	}

	//permet de savoir s'il reste un événement encore à traiter
	private boolean hasANextEvent() {
		if(echeancier.size()>0) {
			if(echeancier.first().getDateOccurence().compareTo(end)<=0) return true;
		}
		return false;
	}


	//moteur de recherche très simple sur les entités
	public List<EntiteSimulee> recherche(Predicate<EntiteSimulee> query) {
		List<EntiteSimulee> resultats = new ArrayList<>();
		for(EntiteSimulee e:mesEntitesSimulees)
			if(query.test(e)) resultats.add(e);
		return resultats;
	}

	
	@Override
	public ScenarioId getScenarioId() {
		if (currentscenario != null)
			return currentscenario.getID();
		else
			return null;
	}

	@Override
	public LogicalDateTime SimulationDate() {
		return currentDate;
	}
}
