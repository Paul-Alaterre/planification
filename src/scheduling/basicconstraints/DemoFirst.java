package scheduling.basicconstraints;
import scheduling.activities.Activity;


public class DemoFirst{

    /**
    *La classe instancie des exemples de contraintes
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
        
		PrecedenceConstraintWithGap precedenceConstraintWithGapTester = new PrecedenceConstraintWithGap(info,maths, 8, 13);
		System.out.println("\n=== Test PrecedenceConstraintWithGap ===");
        System.out.println("Contrainte de precedence avec delai satisfaite (13, 8) ? " + precedenceConstraintWithGapTester.isSatisfied(13, 8));
        System.out.println("Contrainte de precedence avec delai satisfaite (13, 11) ? " + precedenceConstraintWithGapTester.isSatisfied(13, 11));
        
	}

}