package scheduling.solvers;
import scheduling.activities.Activity;
import scheduling.constraints.Constraint;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class RandomScheduler{
	
		protected Random draw;
		
		public RandomScheduler(Random draw){
			this.draw = draw;
		}
		
		public Map<Activity, Integer> generateOneSchedule(Set<Activity> activities, int minDate, int maxDate){
			Map<Activity, Integer> schedule = new HashMap<>();
			for (Activity activity : activities){
				if(minDate == maxDate){
					schedule.put(activity, minDate);
				}
				else{
					int start = this.draw.nextInt(maxDate - minDate +1) + minDate;
					schedule.put(activity, start);
				}
			}
			return schedule;
		}
		
		public Map<Activity, Integer> generateSchedule(Set<Activity> activities, 
		Set<Constraint> constraints, int minDate, int maxDate, int numberOfDraw){
			Verifier verifier = new Verifier(constraints);
			Map<Activity, Integer> bestSchedule = new HashMap<>();
			Map<Activity, Integer> newSchedule;
			for (int i = 0; i < numberOfDraw; i++){
				newSchedule = generateOneSchedule(activities, minDate, maxDate);
				if (bestSchedule.size() == 0 ||  (verifier.unsatisfied(newSchedule).size() < 
				verifier.unsatisfied(bestSchedule).size())){
						bestSchedule.clear();
						bestSchedule.putAll(newSchedule);
				}
			}
			return bestSchedule;
		}
}
