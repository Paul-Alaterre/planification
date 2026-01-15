package scheduling.constraints;
import scheduling.activities.Activity;
import java.util.Set;
import java.util.Map;

public class MaxSpanConstraint implements Constraint{
	
	Set<Activity> activities;
	
	int maxSpan;

	public MaxSpanConstraint(Set<Activity> activities, int maxSpan){
		this.activities = activities;
		this.maxSpan = maxSpan;
	}
	
	@Override 
	
	public Set<Activity> getActivities(){
			return this.activities;
	}
	
	@Override 
	
	public boolean isSatisfied(Map<Activity, Integer> ensemble){
		if (this.activities.isEmpty()){
				return true;
		}
		int maxDate = Integer.MIN_VALUE;
		int minDate = Integer.MAX_VALUE;
		
		for(Activity activity : this.activities){
			if(ensemble.containsKey(activity) && ensemble.get(activity)<= minDate){
					minDate = ensemble.get(activity);
			}
			if(ensemble.containsKey(activity) && ensemble.get(activity)+activity.getDuration()>= maxDate){
					maxDate = ensemble.get(activity)+activity.getDuration();
			}
		}
		if (maxDate - minDate <= this.maxSpan){
			return true;
		}
		else {
			return false;
		}
	}
}

