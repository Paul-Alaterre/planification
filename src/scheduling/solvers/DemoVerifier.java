package scheduling.solvers;
import scheduling.activities.Activity;
import scheduling.constraints.PrecedenceConstraint;
import scheduling.constraints.UnaryConstraint;
import scheduling.constraints.Constraint;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;


public class DemoVerifier{

	public static void main(String[] args) {
			Activity firstActivity = new Activity("activité1",5);
			Activity secondActivity = new Activity("activité2",10);
			Activity thirdActivity = new Activity("activité3",50);
			Activity fourthActivity = new Activity("activité4",2);
			
			Map<Activity,Integer> ensembleActivities = new HashMap<>();
			ensembleActivities.put(firstActivity, 0);
			ensembleActivities.put(secondActivity, 5);
			ensembleActivities.put(thirdActivity, 20);
			ensembleActivities.put(fourthActivity, 100);
			
			Constraint preced = new PrecedenceConstraint(firstActivity,fourthActivity);
			Constraint precedInv = new PrecedenceConstraint(fourthActivity,firstActivity);
			Constraint dure = new UnaryConstraint(firstActivity, 0, 20);
			
			Set<Constraint> ensembleConstraints = new HashSet<>();
			ensembleConstraints.add(preced);
			ensembleConstraints.add(dure);
			
			Set<Constraint> ensembleConstraintsWrong = new HashSet<>();
			ensembleConstraintsWrong.add(precedInv);
			ensembleConstraintsWrong.add(dure);
			
			Verifier check = new Verifier(ensembleConstraints);
			System.out.println(check.unsatisfied(ensembleActivities));
			
			Verifier checkWrong = new Verifier(ensembleConstraintsWrong);
			System.out.println(checkWrong.unsatisfied(ensembleActivities));
	}
}
