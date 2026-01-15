package scheduling.constraints;
import scheduling.activities.Activity;

public class MeetConstraint extends BinaryConstraint implements Constraint{

	public MeetConstraint(Activity first, Activity second) {
		super(first, second);
	}
	
	@Override

	public boolean isSatisfied(int firstStart, int secondStart) {
		return firstStart + this.getFirst().getDuration() == secondStart;
	}
		
}
