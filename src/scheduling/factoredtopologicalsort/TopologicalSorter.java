package scheduling.factoredtopologicalsort;
import scheduling.activities.Activity;
import scheduling.factoredconstraints.PrecedenceConstraint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
* La classe du tri topologique
*/

public class TopologicalSorter {

	/**
	* Constructeur vide
	*/
    public TopologicalSorter(){

    }

	/**
	* Méthode qui recherche si une activité peut être candidate
	*/
    
    public Activity searchObject(HashSet<Activity> copie, ArrayList<Activity> res, HashSet<PrecedenceConstraint> constraints){
    	for(Activity elt : copie){
	    	boolean ok = true;

			// Vérification des contraintes
	    	for (PrecedenceConstraint constraint : constraints){
	    		if(constraint.getSecond() == elt && !res.contains(constraint.getFirst())){
	    			ok = false;	
	    			break;
	    		}
	    	}
	    	if (ok){
				return elt; //Activité disponible
			}
		}

		// Aucune activité n'est disponible
		return null;
	}
	
	/**
	*Méthode qui trie si possible des activités selon des critères de précédence
	*/

    public ArrayList<Activity> bruteForceSort(HashSet<Activity> activities, HashSet<PrecedenceConstraint> constraints){	
           // Copie locale des activités
		HashSet<Activity> copy = new HashSet<>(activities);

		   // Résultat final : liste triée d'activités	
		ArrayList<Activity> res = new ArrayList<>();

		// Boucle principale : activités non triées
		while(!copy.isEmpty()){
			// Recherche d'une activité "disponible"
			Activity availableObject = searchObject(copy,res,constraints);
			if (availableObject == null){
				 // Si aucune n'est disponible
					 return null;
			}
			// Ajouter l'activité disponible au résultat
			res.add(availableObject);
			// La retirer de la copie
			copy.remove(availableObject);
		}
		return res;
    }
    
    public ArrayList<Activity> linearTimeSort(HashSet<Activity> activities, HashSet<PrecedenceConstraint> constraints){
		HashMap<Activity, Integer> nbPredecesseurs = new HashMap<>();
		HashMap<Activity, ArrayList<Activity>> successeurs = new HashMap<>();
		
		for (Activity activity : activities) {
            nbPredecesseurs.put(activity, 0);
            successeurs.put(activity, new ArrayList<>());
        }
        
        for (PrecedenceConstraint constraint : constraints) {
            nbPredecesseurs.put(constraint.getSecond(), nbPredecesseurs.get(constraint.getSecond()) + 1);
            successeurs.get(constraint.getFirst()).add(constraint.getSecond());
        }
        
        ArrayList<Activity> list = new ArrayList<>();
        ArrayList<Activity> res = new ArrayList<>();
        
        for (Activity activity : activities) {
            if (nbPredecesseurs.get(activity) == 0) {
                list.add(activity);
            }
        }
        
        while (!list.isEmpty()) {
            Activity activity = list.remove(0);
            res.add(activity);
			for (Activity successeur : successeurs.get(activity)) {
                nbPredecesseurs.put(successeur, nbPredecesseurs.get(successeur) - 1);
                if (nbPredecesseurs.get(successeur) == 0) {
                    list.add(successeur);
                }
            }
        }
        
        if (res.size() == activities.size()) {
            return res;
        }
        return null;
        
        
	}

	/**
	* Méthode qui permet de créer un emploi du temps
	*/

	public HashMap<Activity, Integer> schedule(HashSet<Activity> activities, HashSet<PrecedenceConstraint> constraints, int time){	
		ArrayList<Activity> tri = bruteForceSort(activities, constraints);
		HashMap<Activity, Integer> scheduling = new HashMap<>();
		if(tri == null){
			return null;
		}
		for (Activity elt:tri){
			scheduling.put(elt,time);
			time+=elt.getDuration();
		}
		return scheduling;
    
	}
}
