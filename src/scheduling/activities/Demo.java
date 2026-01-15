package scheduling.activities;

/**
* La classe qui instancie des activités
*/

public class Demo {

	public static void main(String[] args) {
		Activity info = new Activity("Informatique",2);
		Activity maths = new Activity("Mathématiques",4);
		System.out.println("Activité "+info.getDescription()+" de durée "+ info.getDuration());
		System.out.println("Activité "+maths.getDescription()+" de durée "+ maths.getDuration());
	}
	
}
