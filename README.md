# Projet-Dynseo
Exercice demandé par l'entreprise Dynseo : Jeu de calcul mental

# Explication
Pour mes générateurs, j'ai principalement utilisé le random.nextInt() de Java  
  
Pour la génération des calculs à résoudre :  
+ Premier Niveau :
  + Pour les opérateurs j'ai garder seulement le `+` et le `-`
  + Pour les termes je les ai fait varier de manière aléatoire de 0 à 20
+ Deuxième Niveau :
  + Pour les opérateurs j'ai rajouter le `*` et le `:`
  + Pour le cas de `*` j'ai fait en sorte de n'avoir qu'un seul terme dépassant 10 et un autre compris entre 0 et 10
  + Pour le cas du `:` j'ai principalement fait en sorte que le deuxième terme soit choisi aléatoirment entre 0 et le premier terme avec en plus le fait qu'il soit un diviseur du premier terme
+ Troisième Niveau :
  + Pour les termes, ils vont cette fois ci de 0 à 100
  + Pour les autres cas, la manière est la même que ceux des niveaux précédents
  
Pour la génération des propositions :
+ J'ai choisi tout d'abord de manière aléatoire le positionnement de la bonne réponse que je stocke afin de vérifier le choix de l'utilisateur (cela correspond à la variable `res_place`)
+ J'ai ensuite choisi de manière aléatoire (entre le résultat - un décalage et le résultat + un décalage) pour les autres propositions
+ Pour vérifier la bonne réponse, en fonction du bouton appuyé, je compare `res_place` avec *l'id* du bouton (si c'est `button1` qui est appuyé, je regarde si `res_place` vaut 1)
+ Si le bouton appuyé ne contient pas le bonne réponse, il devient rouge et s'affiche `False` sur la fenêtre, sinon s'affiche `Vrai` et on passe à une nouvelle question
  
Pour le changement de niveau, j'ai pris un compteur `cpt_lvl` que j'incrémente à chaque passage de nouvelles questions :
+ Si `cpt_lvl` est supérieure à 10, je passe au Niveau 2
+ Si `cpt_lvl` est supérieure à 25, je passe au Niveau 3  
Le Niveau actuel est affiché en haut de la fenêtre.
  
# Utilisation
Pour exécuter le code il suffit de rentrer la commande suivante `java -jar App.jar` ou bien `java com.calculus.App` 
