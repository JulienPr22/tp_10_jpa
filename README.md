# Tp 10 JPA

## Démarrage : ##

- lancer une base de données, dans EntityManagerHelper vous pouvez choisir votre unité de persistence:
- persistence-unit mysql: serveur phpMyAdmin contenu dans un conteneur docker
- persistence-unit dev: base hsqldb en local
- Vous pouvez lancer JPATest pour remplir la base avec quelques données
- Et enfin vous pouvez lancer RestApplication
## Applcation : 

- En plus des dépendances vues dans le TP OpenAPi, on utilise le plugin Lombok afin d'alléger les classes entité
## Packages :
- domain : définition des classes entité correspondant aux objets stockés en base
- enum : énumérations utilisées dans les entités afn de garantir un bon format des données attendues
- dao : définition des classes DAO permettant d'interagir avec la base de donnée 
- dto : définition des classes DTO afin de correspondre avec les objets attendus das le front
- mappers: définition de Mapper (écrit à la main) afin de transformer facilement les DTO et les entités
- rest : définition des classes ressources permettant de gérer les requêtes HTTP
- webbapp : contient le fichier distant pour swagger