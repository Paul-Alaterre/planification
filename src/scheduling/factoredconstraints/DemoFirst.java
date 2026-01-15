package scheduling.factoredconstraints;
import scheduling.activities.Activity;

public class DemoFirst {

    /**
    *La classe qui instancie des exemples de contraintes
    */

	public static void main(String[] args) {
		Activity info = new Activity("Informatique",2);
		Activity maths = new Activity("Mathématiques",4);
		PrecedenceConstraint contraintePrecedence = new PrecedenceConstraint(info,maths);
		System.out.println("=== Test PrecedenceConstraint ===");
		System.out.println("Contrainte de precdence satisfaite (10, 11) ? " +contraintePrecedence.isSatisfied(10,11));
		System.out.println("Contrainte de precdence satisfaite (10, 15) ? "+contraintePrecedence.isSatisfied(10,15));
		MeetConstraint contrainteRencontre = new MeetConstraint(info, maths);
        System.out.println("\n=== Test MeetConstraint ===");
        System.out.println("Contrainte de rencontre satisfaite (8, 10) ? " + contrainteRencontre.isSatisfied(8, 10));
        System.out.println("Contrainte de rencontre satisfaite (8, 11) ? " + contrainteRencontre.isSatisfied(8, 11));

	}

}
