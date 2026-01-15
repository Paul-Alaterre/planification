package scheduling.constraints;
import scheduling.activities.Activity;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;

public abstract class BinaryConstraint implements Constraint{
    
    private Activity firstActivity;
    private Activity secondActivity;

    public BinaryConstraint(Activity first, Activity second) {
        this.firstActivity = first;
        this.secondActivity = second;
    }
    
    public Activity getFirst(){
		return this.firstActivity;
	}
    
    public Activity getSecond(){
		return this.secondActivity;
	}

    public abstract boolean isSatisfied(int firstStart, int secondStart);
    
    @Override
    
    public boolean isSatisfied(Map<Activity, Integer> ensemble){
		return this.isSatisfied(ensemble.get(this.firstActivity),ensemble.get(this.secondActivity));
	}
	
	@Override 
	
	public Set<Activity> getActivities(){
		Set<Activity> activities = new HashSet<>();
		activities.add(this.firstActivity);
		activities.add(this.secondActivity);
		return activities;
	}
}
