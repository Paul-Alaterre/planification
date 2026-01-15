package scheduling.factoredconstraints;
import scheduling.activities.Activity;

public abstract class BinaryConstraint {
    
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
}
