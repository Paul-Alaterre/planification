package scheduling.constraints;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import scheduling.activities.Activity;

public class NegationConstraint implements Constraint {

    private final Constraint inner;

    public NegationConstraint(Constraint inner) {
        if (inner == null) {
            throw new IllegalArgumentException("La contrainte ne peut pas être nulle.");
        }
        this.inner = inner;
    }

    @Override
    public Set<Activity> getActivities(){
        return new HashSet<>(inner.getActivities());   // on renvoie les activités de la contrainte encapsulée
    }
    
     @Override
    public boolean isSatisfied(Map<Activity, Integer> schedule) {
        return !inner.isSatisfied(schedule);
    }
}