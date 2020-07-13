
# Travail 2

Le deuxième travail pratique individuel vous demandra d'appliquer les patrons de conceptions GoF pour résoudre un problème concrèt. Ce travail vous demandera d'appliquer les patrons _Façade_, _Builder_, _Composite_ et _Visiteur_.

Comme pour le premier travail, vous serez évaluer en partie sur la bonne exécution des tests unitaires, sur l'implémentation correcte des patrons de conception et finalement sur la qualité de votre code.

#### Spécifications

Vous devrez implémenter une calculatrice en Java. Le projet initial fourni contient une gamme de tests unitaires pour vous guider sur les fonctionnalités que cette calculatrice devra fournir :

* Possibilité de calculer le résultat d'une expression textuelle (e.g. "2 + 4 * 3 - 14 / 2")
  * Pour garder les choses simples, **vous n'avez pas à considérer l'ordre des opérations** : l'expression ci-dessus donnerait donc un résultat de 2.
* Possibilité d'utiliser une classe pour bâtir une expression complexe (``ExpressionBuilder``)
* Possibilité de d'utiliser différents visiteurs pour changer le comportement de la calculatrice
  * ``CalculateVisitor`` calcule le résultat de l'expression
  * ``PrintVisitor`` bâti une ``String`` représentant l'expression

Pour implémenter les fonctionnalités ci-dessus, vous devrez faire usage de quatre différents patrons de conception GoF. La qualité de l'implémentation et de l'interaction entre ces patrons sera évaluée. Voici quelques points pour vous guider :

* Tous les calculs devront être fait de la même façon : avec le CalculateVisitor
  * Pas de duplication de code (principe DRY!)
* La classe ``Calculator`` servira de ``Façade`` pour le point de départ des calculs
  * ``calculate(String)`` utilise ``calculate(Expression)``
  * ``calculate(Expression)`` utilise ``visit(Expression, ExpressionVisitor)``
  * ``visit(Expression, ExpressionVisitor)`` applique le visiteur à l'expression

N'oubliez pas de garder vos méthodes courtes avec des noms significatifs.

#### Récupération du code

Vous pouvez récupérer le code du travail 2 sur le GitHub suivant : https://classroom.github.com/a/yvRSxuYX

## Critères de correction

| Critère                              | Poids |
| ---                                  | ---   |
| Les tests unitaires passent          | 40%   |
| Patron _Façade_                      | 5%    |
| Patron _Composite_                   | 5%    |
| Patron _Builder_                     | 10%   |
| Patron _Visiteur_                    | 10%   |
| Principe DRY (Don't Repeat Yourself) | 10%   |
| Clarté et qualité du code            | 20%   |

## Remise des travaux

La date de remise du travail 2 est le 10 aout 2020 à 23:50.

Pour remettre votre travail, il suffira de faire un push de vos modifications vers le Github et je pourrai le récupérer à la date de remise. Vous pouvez dès aujourd'hui remettre votre travail, il n'y a pas de date minimale à attendre.

**Les travaux remis passé la date de remise ne seront pas évalués.**
