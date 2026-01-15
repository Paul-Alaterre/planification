package scheduling.factoredconstraints;
import scheduling.activities.Activity;

	public class DemoGap {
	
		public static void main(String[] args) {
			Activity info = new Activity("Informatique",2);
			Activity maths = new Activity("Mathématiques",4);
			PrecedenceConstraintWithGap precedenceDelai = new PrecedenceConstraintWithGap(info, maths, 3, 15);
			System.out.println("=== Test PrecedenceConstraintWithGap ===");
			System.out.println("Contrainte de precdence avec delai satisfaite (10, 20) ? " +precedenceDelai.isSatisfied(10,20));
			System.out.println("Contrainte de precdence avec delai satisfaite (10, 15) ? "+precedenceDelai.isSatisfied(10,30));
		}
		
	}
