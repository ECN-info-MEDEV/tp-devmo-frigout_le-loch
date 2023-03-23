# DEVMO - ÉCOLE CENTRALE DE NANTES

## Authors
- Antoine FRIGOUT : antoine.frigout@eleves.ec-nantes.fr
- Mailys LE LOC'H : mailys.le-loch@eleves.ec-nantes.fr

## Description
Ce projet a pour objectif de faciliter la gestion des sports dans le cadre universitaire.

Dans ce projet, nous avons ajouter 4 vues :
	1) Vue LOGIN : cette vue permet de se connecter. Si le compte n'existe pas, alors un popup affiche que le nom d'utilisateur et le mot de passe sont éronnés.
		- Nous avons ajouté deux comptes (John DOE - ID : jdoe - MDP : 12345) et (Mimi DUPONT - ID : mdupont - MDP : mdp123)
		- Le nom de l'utilisateur est récupéré dans la base de données et passé à la vue suivante via un Intent.
 	2) Vue ACCUEIL : une fois connecté via la page de login, nous arrivons sur cette vue. Cette vue contient un menu déroulant en haut à droite qui permet d'accéder aux deux autres vues.
		- Compétitions -> Planning
		- Compétitions -> Remplir une feuille de match
		- Les autres liens ne sont pas implémentés
	3) Vue PLANNING : Cette vue affiche les différentes compétitions stockées dans la base de données.
	4) Vue FEUILLE DE MATCH : Cette vue permet de remplir une feuille de match et de la stockée dans la base de données.

NB) Pour revenir en arrière glissez votre doigts à partir du bord gauche de votre téléphone. 
