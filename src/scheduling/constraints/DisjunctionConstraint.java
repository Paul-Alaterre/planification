package scheduling.constraints;

import scheduling.activities.Activity;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;



public class DisjunctionConstraint implements Constraint{
       private final Constraint left;
       private final Constraint right;
       
/**
* Construit une contrainte représentant la disjonction de deux autres contraintes
*/
       
       public DisjunctionConstraint(Constraint left, Constraint right){
		   if(left == null || right == null){
			   throw new IllegalArgumentException("Les contraintes ne peuvent pas être null");
			   }
			   this.left = left;
			   this.right = right;
		   }
/**
* La disjonction est satisfaite si au moins une des deux contraintes l'est.
*/
           @Override
            public Set<Activity> getActivities() {
        // Union des activités des deux contraintes
               Set<Activity> activities = new HashSet<>(left.getActivities());
               activities.addAll(right.getActivities());
        return activities;
    }

		   @Override 
		    public boolean isSatisfied(Map<Activity, Integer> schedule) {
        return left.isSatisfied(schedule) || right.isSatisfied(schedule);
    }
			   
		   @Override
		   public String toString(){
			   return "(" + left.toString() + " OR " + right.toString() + ")";
			   }
	}
