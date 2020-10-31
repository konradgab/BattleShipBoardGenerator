## Zadanie 3: zbudować kreator losowej planszy do gry w statki

Należy napisać kreator do losowania poprawnych plansz do gry w statki.

Plansza do gry w statki jest kwadratem 10x10. Każde pole może zawierać element statku (maszt), oznaczony znakiem `*`, lub zawierać wodę oznaczoną przez `.`.

Statki mogą być 1, 2, 3, lub 4 masztowe. Statek to jedno, lub więcej stykających się bokiem, pole zawierające maszt. Maszty stykające się tylko rogami nie są statkiem.

Przykłady prawidłowych statków (w otoczeniu wody):
```
...
.#.  -> jednomasztowiec
...

......
.##.#. -> dwa dwumasztowce
....#.

.....
..#..  -> trójmasztowiec
.##..

.........
......##.
.####.##. -> dwa czteromasztowce
.........
```

Przykłady nieprawidłowych statków:
```
......
..#...  -> nieprawidłowy dwumasztowiec
...#..
......
.......
...#...
..#.#..  -> nieprawidłowy czteromasztowiec
...#...
```

Prawidłowa plansza zawiera: 4 jednomasztowce, 3 dwumasztowce, 2 trójmasztowce, oraz 1 czteromasztowiec. Pomiędzy statkami musi być przynajmniej jedno pole odstępu (statki nie mogą dotykać się rogami).


Przykładowa plansza
```
..#.......
#......#..
#..#......
..##......
......##..
.##.......
.........#
..##...#..
.##....#.#
.......#..
```
