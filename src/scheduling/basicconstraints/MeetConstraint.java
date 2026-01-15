package scheduling.basicconstraints;
import scheduling.activities.Activity;

public class MeetConstraint {

	private Activity first;
	private Activity second;

	/**
	* Le constructeur
	*/
	public MeetConstraint(Activity first, Activity second) {
		this.first = first;
		this.second = second;
	}

	/**
	* Les accesseurs
	*/
	public Activity getFirst() {
		return this.first;
	}
	public Activity getSecond() {
		return this.second;
	}

	/**
	* Vérification de la contrainte
	*/	
	public boolean isSatisfied(int startFirst, int startSecond) {
		
			return startSecond == startFirst + first.getDuration();
	}
		
}
