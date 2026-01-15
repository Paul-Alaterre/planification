# planification
Projet autour de la génération d'emplois du temps
Réalisé en novembre 2026 dans le cadre du projet de groupe de fin de semestre de la matière "Programmation Orientée Objet en Java" en L2 d'Informatique.

Les différentes classes permettent d'abord de créer des activitées. Ensuite on peut mettre en places des contraintes plus ou moins complexes sur un certains nombre d'activités. Enfin, différentes méthodes sont disponibles pour créer des emploi du temps avec des activitées et contraintes données

Pour compiler les fichiers/classes de chaque sous-package on fait :

javac -source 11 -d ../build -cp .:../lib/schedulingtests.jar scheduling/<sous-package>/*.java
	
Et pour executer les fichiers :

java -cp ../build:../lib/schedulingtests.jar scheduling.<sous-package>.<classe>

Pour créer la javadoc du projet :

javadoc -d ../doc -cp ../lib/schedulingtests.jar scheduling/*/*.java
