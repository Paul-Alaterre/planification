package scheduling.solvers;
import scheduling.activities.Activity;
import scheduling.constraints.PrecedenceConstraint;
import scheduling.constraints.PrecedenceConstraintWithGap;
import scheduling.constraints.UnaryConstraint;
import scheduling.constraints.MeetConstraint;
import scheduling.constraints.Constraint;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class DemoRandom{

	public static void main(String[] args) {
		
			Random rand;

			if (args.length > 0) {
				try {
					long seed = Long.parseLong(args[0]);  // récupère la graine depuis les arguments
					rand = new Random(seed);
					System.out.println("Graine utilisée : " + seed);
				} catch (NumberFormatException e) {
					System.out.println("Argument invalide, génération d'une graine aléatoire.");
					rand = new Random();
				}
			} else {
				rand = new Random(); // aucune graine donnée => aléatoire
				System.out.println("Graine aléatoire générée automatiquement.");
			}
			
			RandomScheduler schedule = new RandomScheduler(rand);
		
			Activity firstActivity = new Activity("activité1",5);
			Activity secondActivity = new Activity("activité2",10);
			Activity thirdActivity = new Activity("activité3",50);
			Activity fourthActivity = new Activity("activité4",2);
			
			Set<Activity> activities = new HashSet<>();
			activities.add(firstActivity);
			activities.add(secondActivity);
			activities.add(thirdActivity);
			activities.add(fourthActivity);
			
			System.out.println("Exemple de génération d'un emploi du temps :\n");
			
			System.out.println(schedule.generateOneSchedule(activities, 1, 5));
			
			
			
			Constraint precedFirst = new PrecedenceConstraint(firstActivity, secondActivity);
			Constraint precedSecond = new PrecedenceConstraint(secondActivity, thirdActivity);
			Constraint precedThird = new PrecedenceConstraint(thirdActivity, fourthActivity);
			Constraint precedInv = new PrecedenceConstraint(fourthActivity, firstActivity);
			Constraint gap = new PrecedenceConstraintWithGap(fourthActivity, firstActivity, 5, 10);
			Constraint meet = new MeetConstraint(fourthActivity, firstActivity);
			Constraint dure = new UnaryConstraint(firstActivity, 0, 20);
			
			
			Set<Constraint> constraintsFirst = new HashSet<>();
			constraintsFirst.add(precedFirst);
			constraintsFirst.add(dure);
			
			System.out.println("Exemple de génération multiple avec peu de contraintes :\n");
			System.out.println(schedule.generateSchedule(activities, constraintsFirst, 1, 5, 200));
			
			Set<Constraint> constraintsSecond = new HashSet<>();
			constraintsSecond.add(precedFirst);
			constraintsSecond.add(precedSecond);
			constraintsSecond.add(precedThird);
			constraintsSecond.add(dure);
			
			System.out.println("Exemple de génération multiple avec beaucoup de contraintes :\n");
			System.out.println(schedule.generateSchedule(activities, constraintsSecond, 1, 5, 200));
			
			Set<Constraint> constraintsThird = new HashSet<>();
			constraintsThird.add(precedFirst);
			constraintsThird.add(precedSecond);
			constraintsThird.add(precedThird);
			constraintsThird.add(precedInv);
			constraintsThird.add(gap);
			constraintsThird.add(meet);
			
			System.out.println("Exemple de génération multiple avec trop de contraintes (renvoie un emploi du temps donc invalide):\n");
			System.out.println(schedule.generateSchedule(activities, constraintsThird, 1, 50, 1));
	}
}
