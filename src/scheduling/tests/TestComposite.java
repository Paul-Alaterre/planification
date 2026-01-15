package scheduling.tests;

import java.util.Map;
import java.util.Random;
import scheduling.activities.Activity;
import scheduling.constraints.Constraint;
import scheduling.constraints.PrecedenceConstraint;
import scheduling.constraints.NegationConstraint;
import scheduling.constraints.DisjunctionConstraint;

public class TestComposite {

    public static void main(String[] args) {
        Random random = new Random();
        boolean ok = true;

        // Création d’activités
        Activity a1 = new Activity("Cours de maths", 2);
        Activity a2 = new Activity("Cours de physique", 3);
        Activity a3 = new Activity("Cours de chimie", 1);

        // Exemple de contraintes
        Constraint precedence = new PrecedenceConstraint(a1, a2);
        Constraint negation = new NegationConstraint(precedence);
        Constraint disjunction = new DisjunctionConstraint(precedence, new PrecedenceConstraint(a2, a3));

        // Emplois du temps de test
        Map<Activity, Integer> schedule1 = Map.of(a1, 9, a2, 10, a3, 11);
        Map<Activity, Integer> schedule2 = Map.of(a1, 11, a2, 9, a3, 10);

        // Tests
        ok = ok && testNegationConstraint(negation, schedule1, true);
        ok = ok && testNegationConstraint(negation, schedule2, true);

        ok = ok && testDisjunctionConstraint(disjunction, schedule1, false);
        ok = ok && testDisjunctionConstraint(disjunction, schedule2, false);

        System.out.println(ok ? "All tests passed" : "At least one test failed");
    }

    private static boolean testNegationConstraint(Constraint c, Map<Activity, Integer> schedule, boolean expected) {
        boolean result = c.isSatisfied(schedule);
        if (result != expected) {
            System.out.println("NegationConstraint failed: expected " + expected + " but got " + result);
            return false;
        }
        return true;
    }

    private static boolean testDisjunctionConstraint(Constraint c, Map<Activity, Integer> schedule, boolean expected) {
        boolean result = c.isSatisfied(schedule);
        if (result != expected) {
            System.out.println("DisjunctionConstraint failed: expected " + expected + " but got " + result);
            return false;
        }
        return true;
    }
}
