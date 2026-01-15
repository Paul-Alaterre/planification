package  scheduling.factoredconstraints;
import scheduling.activities.Activity;

public class PrecedenceConstraintWithGap extends PrecedenceConstraint {
    private int minGap;
    private int maxGap;

    public PrecedenceConstraintWithGap(Activity first, Activity second, int minGap, int maxGap) {
        super(first, second);
        this.minGap = minGap;
        this.maxGap = maxGap;
    }

    @Override
    public boolean isSatisfied(int firstStart, int secondStart){
        int firstEnd = firstStart + this.getFirst().getDuration();
        return secondStart >= firstEnd + this.minGap && secondStart <= firstEnd + this.maxGap;
    }
}
