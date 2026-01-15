package scheduling.activities;

public class Activity {

	private String des;
	private int dur;

	/**
	* Le constructeur
	*/
              
	public Activity(String description, int duration) {
		this.des = description;
		this.dur = duration;
	}

	/**
	* Les accesseurs
	*/
		  
	public String getDescription() {
		return this.des;
	}
	public int getDuration() {
		return this.dur;
	}
	
	
}
