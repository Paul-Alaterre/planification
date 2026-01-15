package scheduling.solvers;
import scheduling.activities.Activity;
import scheduling.constraints.PrecedenceConstraint;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    
    public Activity searchObject(Set<Activity> copie, List<Activity> res, Set<PrecedenceConstraint> constraints){
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

    public List<Activity> bruteForceSort(Set<Activity> activities, Set<PrecedenceConstraint> constraints){	
           // Copie locale des activités
		Set<Activity> copy = new HashSet<>(activities);

		   // Résultat final : liste triée d'activités	
		List<Activity> res = new ArrayList<>();

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

	public List<Activity> linearTimeSort(Set<Activity> activities, Set<PrecedenceConstraint> constraints){
		Map<Activity, Integer> nbPredecesseurs = new HashMap<>();
		Map<Activity, List<Activity>> successeurs = new HashMap<>();
		
		for (Activity activity : activities) {
            nbPredecesseurs.put(activity, 0);
            successeurs.put(activity, new ArrayList<>());
        }
        
        for (PrecedenceConstraint constraint : constraints) {
            nbPredecesseurs.put(constraint.getSecond(), nbPredecesseurs.get(constraint.getSecond()) + 1);
            successeurs.get(constraint.getFirst()).add(constraint.getSecond());
        }
        
        List<Activity> list = new ArrayList<>();
        List<Activity> res = new ArrayList<>();
        
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

	public Map<Activity, Integer> schedule(Set<Activity> activities, Set<PrecedenceConstraint> constraints, int time){	
		List<Activity> tri = bruteForceSort(activities, constraints);
		Map<Activity, Integer> scheduling = new HashMap<>();
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

