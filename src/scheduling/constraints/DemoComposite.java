package scheduling.constraints;

import scheduling.activities.Activity;
import java.util.Map;

public class DemoComposite {

    public static void main(String[] args) {
        // Création de quelques activités avec nom et durée
        Activity a1 = new Activity("Cours de maths", 2);
        Activity a2 = new Activity("Cours de physique", 3);
        Activity a3 = new Activity("Cours de chimie", 1);

        // Exemple de contrainte de précédence (a1 avant a2)
        Constraint precedence = new PrecedenceConstraint(a1, a2);

        // Négation de cette contrainte
        Constraint negation = new NegationConstraint(precedence);

        // Disjonction : (a1 avant a2) OU (a2 avant a3)
        Constraint disjunction = new DisjunctionConstraint(
            precedence,
            new PrecedenceConstraint(a2, a3)
        );

        // Exemple d’emploi du temps (mapping activité -> créneau horaire)
        Map<Activity, Integer> schedule1 = Map.of(
            a1, 9,
            a2, 10,
            a3, 11
        );

        Map<Activity, Integer> schedule2 = Map.of(
            a1, 11,
            a2, 9,
            a3, 10
        );

        // Vérification des contraintes
        System.out.println("=== Démonstration avec schedule1 ===");
        
        System.out.println("Negation (NON a1 avant a2) : " + negation.isSatisfied(schedule1));
        System.out.println("Disjunction (a1 avant a2 OU a2 avant a3) : " + disjunction.isSatisfied(schedule1));

        System.out.println("\n=== Démonstration avec schedule2 ===");
        
        System.out.println("Negation (NON a1 avant a2) : " + negation.isSatisfied(schedule2));
        System.out.println("Disjunction (a1 avant a2 OU a2 avant a3) : " + disjunction.isSatisfied(schedule2));
    }
}
