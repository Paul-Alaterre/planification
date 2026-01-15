package scheduling.basicconstraints;
import scheduling.activities.Activity;

public class PrecedenceConstraint {

	private Activity firstActivity;
	private Activity secondActivity;

	/**
	* Le constructeur
	*/
	public PrecedenceConstraint(Activity first, Activity second) {
		this.firstActivity = first;
		this.secondActivity = second;
	}

	/**
	* Les accesseurs
	*/
	public Activity getFirst() {
		return this.firstActivity;
	}
	public Activity getSecond() {
		return this.secondActivity;
	}

	/**
	* Vérification des contraintes de précédence
	*/	
	public boolean isSatisfied(int firstStart, int secondStart) {
		return firstStart+this.firstActivity.getDuration() <= secondStart;
	}
	
	
	
}
