package scheduling.constraints;
import scheduling.activities.Activity;
import java.util.Set;
import java.util.Map;

public interface Constraint{

	public Set<Activity> getActivities();
	
	public boolean isSatisfied(Map<Activity, Integer> ensemble);

}