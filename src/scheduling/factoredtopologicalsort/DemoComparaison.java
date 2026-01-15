package scheduling.factoredtopologicalsort;

import scheduling.activities.Activity;
import scheduling.factoredconstraints.PrecedenceConstraint;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

public class DemoComparaison {

    public static void main(String[] args) {

        // Nombre d'activités
        int N = 2000;

        // Création des activités
        HashSet<Activity> activities = new HashSet<>();
        for (int i = 0; i < N; i++) {
            activities.add(new Activity("activité " + i, 1));
        }

        // Convertir en liste pour accéder aux mêmes objets
        ArrayList<Activity> activityList = new ArrayList<>(activities);

        // Création des contraintes : activité i < activité i+1
        HashSet<PrecedenceConstraint> constraints = new HashSet<>();
        for (int i = 0; i < N - 1; i++) {
            Activity a = activityList.get(i);
            Activity b = activityList.get(i + 1);
            constraints.add(new PrecedenceConstraint(a, b));
        }

        TopologicalSorter sorter = new TopologicalSorter();

        // ----- TRI BRUTE-FORCE -----
        System.out.println("Début du tri brute force...");
        long startBF = System.currentTimeMillis();
        ArrayList<Activity> orderBF = sorter.bruteForceSort(activities, constraints);
        long endBF = System.currentTimeMillis();
        System.out.println("Fin du tri brute force. Temps = " + (endBF - startBF) + " ms");

        // ----- TRI LINEAIRE -----
        System.out.println("Début du tri en temps linéaire...");
        long startLT = System.currentTimeMillis();
        ArrayList<Activity> orderLT = sorter.linearTimeSort(activities, constraints);
        long endLT = System.currentTimeMillis();
        System.out.println("Fin du tri linéaire. Temps = " + (endLT - startLT) + " ms");

        // Affichage final
        System.out.println("\nRésultats :");
        System.out.println(" - Temps brute force : " + (endBF - startBF) + " ms");
        System.out.println(" - Temps linéaire    : " + (endLT - startLT) + " ms");

        // Optionnel : vérifier que le tri linéaire est correct
        if (orderLT != null) {
            System.out.println("Tri linéaire valide pour " + orderLT.size() + " activités.");
        } else {
            System.out.println("Erreur : cycle détecté !");
        }
    }
}
