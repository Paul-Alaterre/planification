package  scheduling.factoredconstraints;
import scheduling.activities.Activity;

public class MeetConstraint extends BinaryConstraint{

	public MeetConstraint(Activity first, Activity second) {
		super(first, second);
	}
	
	@Override

	public boolean isSatisfied(int firstStart, int secondStart) {
		return firstStart + this.getFirst().getDuration() == secondStart;
	}
		
}
