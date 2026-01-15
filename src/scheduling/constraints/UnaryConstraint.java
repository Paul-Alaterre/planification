package scheduling.constraints;
import scheduling.activities.Activity;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;

public class UnaryConstraint implements Constraint{
	
	Activity activity;
	
	int minDate;
	
	int maxDate;

	public UnaryConstraint(Activity activity, int minDate, int maxDate){
		this.activity = activity;
		this.minDate = minDate;
		this.maxDate = maxDate;
	}
	
	@Override 
	
	public Set<Activity> getActivities(){
			Set<Activity> activities = new HashSet<>();
			activities.add(this.activity);
			return activities;
	}
	
	@Override 
	
	public boolean isSatisfied(Map<Activity, Integer> ensemble){
		return ensemble.get(this.activity)>=this.minDate && ensemble.get(this.activity)<=this.maxDate;
	}
	
}
