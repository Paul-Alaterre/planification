package scheduling.basictopologicalsort;
import scheduling.activities.Activity;
import scheduling.basicconstraints.PrecedenceConstraint;
import scheduling.basictopologicalsort.TopologicalSorter;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

/**
*Cette classe donne deux exemples d'instanciation de la classe TopologicalSorter et des méthodes dont elle dispose
*/

public class DemoBruteForce {

	public static void main(String[] args) {
		
		//Un exemple où le tri est possible	

		Activity lever = new Activity("se lever",1);
		Activity travail = new Activity("aller au travail",15);
		Activity douche = new Activity("douche",10);
		Activity brossage = new Activity("se brosser les dents",3);
		Activity habillage = new Activity("s'habiller",2);
		Activity dej = new Activity("petit déjeuner",15);
		
		HashSet<Activity> firstActivities = new HashSet<>();
		
		firstActivities.add(lever);
		firstActivities.add(travail);
		firstActivities.add(douche);
		firstActivities.add(brossage);
		firstActivities.add(habillage);
		firstActivities.add(dej);
		
		HashSet<PrecedenceConstraint> firstConstraints = new HashSet<>();

		firstConstraints.add(new PrecedenceConstraint(lever,dej));
		firstConstraints.add(new PrecedenceConstraint(lever,habillage));
		firstConstraints.add(new PrecedenceConstraint(dej,brossage));
		firstConstraints.add(new PrecedenceConstraint(douche,habillage));
		firstConstraints.add(new PrecedenceConstraint(brossage,travail));
		firstConstraints.add(new PrecedenceConstraint(habillage,travail));
		firstConstraints.add(new PrecedenceConstraint(lever,douche));
		firstConstraints.add(new PrecedenceConstraint(dej,travail));
	
	
		TopologicalSorter premierTri = new TopologicalSorter();
		ArrayList<Activity> premierTriFini = premierTri.bruteForceSort(firstActivities, firstConstraints);
		
		System.out.println("Un premier tri possible : \n");
		for (Activity elt : premierTriFini){
			System.out.println(elt.getDescription());
		}

		HashMap<Activity, Integer> schedule = premierTri.schedule(firstActivities, firstConstraints, 20);
		
		System.out.println("\nEt l'emploi du temps lié à ce tri : \n");
		for (HashMap.Entry<Activity, Integer> entry : schedule.entrySet()) {
            String nom = entry.getKey().getDescription();
            Integer note = entry.getValue();
            System.out.println(nom + " : " + note);
        }
		
		//Un exemple où le tri n'est pas possible
		
		Activity connaissance = new Activity("prendre connaissance du sujet",30);
		Activity reviser = new Activity("réviser",300);
		Activity entrer = new Activity("entrer",8);
		
		HashSet<Activity> secondActivities = new HashSet<>();
		
		secondActivities.add(connaissance);
		secondActivities.add(reviser);
		secondActivities.add(entrer);
		
		HashSet<PrecedenceConstraint> secondConstraints = new HashSet<>();
		
		secondConstraints.add(new PrecedenceConstraint(reviser,entrer));
		secondConstraints.add(new PrecedenceConstraint(entrer,connaissance));
		secondConstraints.add(new PrecedenceConstraint(connaissance,reviser));
		
		TopologicalSorter secondTri = new TopologicalSorter();

		System.out.println("\nEt le resultat du second tri :\n");
		ArrayList<Activity> secondTriFini = premierTri.bruteForceSort(secondActivities, secondConstraints);
		
	}
 
}
