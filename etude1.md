# Étude de cas #1 : Un jeu de Dés

On s’intéresse ici à la conception d’un Jeu de Dé, qui se joue à plusieurs joueurs (entre 2 et 4) sur un
plateau de jeu carré de 50 cases par 50 cases. La case au centre du plateau de jeu est la case de fin de
partie, le jeu s’arrête dès qu’un joueur arrive dessus. Certaines cases, réparties aléatoirement sur la grille,
sont des cases dites « bonus » (il y en a 15), et d’autres sont des cases dites « marchand » (il y en a 15).
Toutes les autres cases sont qualifiées de normales. Les positions de départ des joueurs sont aléatoires,
mais tous les joueurs sont initialement placés sur la grille à plus de 5 cases mais moins de 10 les uns des
autres, et sur une case normale.

Au démarrage, chaque joueur possède deux dés, un dé de direction à 4 faces (Nord, Sud, Est, Ouest) et un
dé de puissance à 4 faces aussi (1,2,3,4), et une réserve contenant 2 pièces. Le jeu se joue au tour par
tour. A son tour, un joueur lance ses dés, et déplace son pion dans la direction de ses dés, pour une
distance allant jusqu’à la puissance tirée (par exemple s’il tire « 3 » et « Nord », il peut déplacer son joueur
de 0, 1, 2 ou 3 cases vers le haut du plateau).

Plusieurs situations peuvent arriver selon la case d’arrivée, selon qu’elle soit normale, spéciale, ou
occupée par un autre joueur. Si c’est une case normale, le jeu passe au joueur suivant. Si c’est la case de
fin de partie, la partie s’arrête immédiatement et le vainqueur est désigné. Si c’est une case « bonus », le
joueur peut décider de (i) recevoir 5 pièces ou (ii) faire perdre 2 pièces à tous les autres joueurs. Si c’est
une case « marchand », le joueur peut décider de (i) revendre un dé, (ii) acheter un nouveau dé (à 2, 4, 6,
ou 8 faces), ou (iii) remplacer une face d’un de ses dés par une nouvelle (l’ancienne face est alors détruite).
Lors des transactions avec le marchand, revendre un dé rapporte autant que son nombre de face. Acheter
une face de direction coûte 1 pièce, et une face de puissance coûte la valeur de la face achetée (acheter
un 4 coûte 4 pièces). Lorsqu’il achète un nouveau dé, celui-ci est un dé de puissance dont toutes les faces
valent un. La puissance maximale d’une face est de 6, et il est possible de mélanger des faces de puissance
et de direction sur un même dé. Si un joueur est présent sur la case d’arrivée, alors le joueur se déplaçant
vole la moitié de la fortune du joueur présent sur la case (arrondi à l’entier inférieur) : si A arrive sur une
case occupée par B, et que B possédait 7 pièces dans sa réserve, alors A reçoit 3 pièces et B n’en a plus
que 4.

Un joueur peut posséder autant de dés qu’il le souhaite. Quand il tire ses dés, les puissances
s’additionnent (tirer un 2 et un 4 lui permet de se déplacer entre 0 et 6 cases sur le plateau). Lorsque deux
directions différentes sont tirées, le joueur peut choisir celle de son choix, ou composer les deux pour se
déplacer en diagonale si c’est possible. Les déplacements en diagonale coûtent deux fois plus de
puissance. Par exemple, le joueur a tiré 5 points de puissance, et les directions Nord et Ouest. Il peut
choisir de se déplacer de [0,5] cases vers le Nord, [0,5] cases vers l’Ouest, ou de [0,2] cases en diagonale
Nord-Ouest (5/2 = 2,5, arrondi à l’entier inférieur).

Est désigné vainqueur en fin de partie le joueur qui a le plus d’argent en réserve. En cas d’égalité de pièces,
c’est le joueur ayant la plus grande puissance (la somme de ses faces de puissance) qui est élu vainqueur.
En cas d’égalité, il n’y a pas de vainqueur, la partie est perdue pour tous les joueurs.
La liste des actions applicables lors de l’arrivée sur une case « bonus » n’est pas encore définitive et
pourrait évolue r dans le futur. De la même manière, on pourrait imaginer de nouveaux types de cases
spéciales dans le futur (par exemple des portails de téléportation pour se déplacer plus rapidement sur le
plateau de jeu). Des faces de puissance multiplicatrices (x2, x3) sont aussi à l’étude.
