# xspeedit

Robot d'optimisation du nombre de cartons d'emballage.

# Installation

- Lancer la commande *mvn clean package*, ensuite placer le package fourni (target/xspeedit-solution_1.0.0-package.zip) dans le répertoire de votre choix.
- Dézipper le package xspeedit-solution_1.0.0-package.zip. Ce dernier contient les élements suivants:
  - Un dossier bin contenant le fichier jar : xspeedit-solution_1.0.0.jar
  - Un dossier conf contenant les fichiers de configuration suivants: 
      log4j2.properties : pour la gestion des logs.
      xspeedit-solution.properties : fichier de configuration de l'application.
      
# Exécution

- En ligne de commande, se placer dans le répertoire où est situé le jar et lancer la commande suivante:
*java -jar -Dlogging.config="../conf/log4j2.properties" -Dspring.profiles.active=dev xspeedit-solution_1.0.0.jar "163841689525773"*

- Les résultats se trouvent dans le fichier de log xspeedit_solution.log situé dans le répertoire logs.
