package scheduling.solvers;
import scheduling.constraints.Constraint;
import scheduling.activities.Activity;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;

public class Verifier {
	
	Set<Constraint> constraints;

	public Verifier(Set<Constraint> constraints){
			this.constraints = constraints; 
	}
	
	public Set<Constraint> unsatisfied(Map<Activity, Integer> couples){
		Set<Constraint> unsatisfied = new HashSet<>();
		for(Constraint constraint : this.constraints){
			if(!constraint.isSatisfied(couples)){
					unsatisfied.add(constraint);
			}
		}
		return unsatisfied;
	}
	
}
