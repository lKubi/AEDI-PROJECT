
# AEDI-PROJECT
 Cinquillo de oros AEDI. Enunciado:
 
 
## Historia del cinquillo
El cinquillo es un juego de cartas extremadamente similar a los seises y al reihe. Se juega con la
baraja española y pueden jugar de 3 a 6 jugadores/as.

Se reparten todas las cartas entre los/as jugadores/as y el juego consiste en ir colocando las cartas
sobre la mesa, una carta como mucho en cada turno, hasta que algún/a jugador/a coloque todas las cartas de su mano.

La forma de colocar las cartas en la mesa es la siguiente:

•   Empieza el/la jugador/a que posea el cinco de oros y lo coloca.

•   Después continúa el/la jugador/a situado a su derecha y así sucesivamente.

Solo se pueden colocar cincos o todas aquellas cartas que siguen en progresión ascendente o
descendente a las que hay en la mesa y sean del mismo palo. Es decir, si, por ejemplo, solamente está colocado el cinco de oros en la mesa, los/as jugadores/as solo podrán colocar el seis o el cuatro de oros o un cinco de otro palo.

Si un/a jugador/a no puede colocar ninguna carta, pasa, y el turno le corresponde al siguiente jugador/a. Y si un/a jugador/a puede poner varias cartas deberá elegir la que más le convenga para ganar el juego. Los/as jugadores/as no pueden pasar voluntariamente, es decir, si tienen una carta en su mano que puedan jugar, entonces deben jugarla.

El/La primer/a jugador/a que consigue colocar todas sus cartas sobre la mesa (quedándose, por
tanto, sin ninguna en la mano) es el/la ganador/a.

## Objetivo del juego
Para facilitar la implementación del juego **Cinquillo-Oro**, se exponen a continuación unas reglas más sencillas que las reglas del juego original.

Para jugar al **Cinquillo-Oro** son necesarias **48 cartas**. Consideramos una baraja de 4 palos (Oros, Espadas, Bastos y Copas) con 12 cartas cada uno (enumeradas del 1 al 12).

Pueden jugar solo **3** o **4 jugadores/as**.

Los **objetivos** del juego son colocar el **“as de oros”** si se dispone de él y colocar todas las cartas en la mesa antes que los/as jugadores/as contrarios/as. Si un/a jugador/a consigue colocar el “as de oros” en la mesa obtendrá unos puntos que denominaremos **puntosAsDeOro**, y el/la jugador/a que coloca todas las cartas en la mesa obtendrá unos puntos que denominaremos **puntosPartida**.

Un juego consta de una o más partidas consecutivas. Cada partida termina cuando un/a jugador/a coloca todas sus cartas en la mesa y el juego finaliza cuando en una partida un/a jugador/a ha colocado el **“as de oros”**.

## Cómo jugar al Cinquillo-Oro
Al iniciar una partida se le asignará a **puntosPartida** el valor 4 y **puntosAsDeOro** se incrementará en 2 (si es la primera partida del juego se le asignará el valor 2). Es decir, si en una partida no se coloca el “as de oros” los **puntosAsDeOro** se van acumulando para las siguientes partidas (añadiéndose 2 puntos más) y, en el momento en el que un/a jugador/a coloca dicha carta, estos puntos se le asignarán a él/ella. Sin embargo, los **puntosPartida** siempre son 4, que son los que se le asignarán al primer/a jugador/a que coloque todas sus cartas en la mesa (dando lugar a que finalice la partida).

Al iniciar la partida, todas las cartas de la baraja se reparten entre los/as jugadores/as (que podrán ser 3 o 4 jugadores/as, a escoger). **Inicia la partida un/a jugador/a al azar**; a partir de ese momento, los/as jugadores/as realizarán su jugada, por turnos, siguiendo el sentido de las
manecillas del reloj.

## Desarrollo del juego
En su turno, cada jugador/a debe colocar en la mesa una de sus cartas o pasar turno (solo si no tiene ninguna carta que pueda añadir a la mesa). La carta que se coloque puede ser un 5 o seguir una progresión ascendente o descendente de una carta de su mismo palo que ya esté en la mesa.

Una vez que el/la jugador/a ha colocado la carta, su turno termina y pasa al siguiente jugador/a. Si un/a jugador/a no puede jugar “pierde su turno”.

## Final de una partida y final del juego
Como se dijo anteriormente, una partida termina cuando un/a jugador/a coloca todas sus cartas en la mesa. En ese momento a ese/a jugador/a se le asignan los **puntosPartida** (4 puntos). El juego termina cuando en una partida se coloca el “as de oros”.

Cada partida comenzará con todas las cartas en la baraja, la mesa vacía y los/as jugadores/as sin cartas, los **puntosAsDeOro** con 2 puntos más que en la partida anterior y los **puntosPartida** a 4. Se jugarán partidas consecutivas hasta que un/a jugador/a coloca el “as de oros”, y esa será la última partida del juego, la cual finalizará cuando un/a jugador/a haya colocado todas sus cartas.

Una vez que finalice el juego ganará aquel/la jugador/a que obtenga el mayor número de puntos acumulado (procedentes tanto de **puntosPartida** de las partidas ganadas, como de los **puntosAsDeOro**, si es el caso).

Si varios/as jugadores/as finalizan con los mismos puntos (empate), se mostrarán todos/as los/as ganadores/as.
    

## ORGANIZACIÓN DEL TRABAJO A REALIZAR:
1. El trabajo será colaborativo, es decir se realizará en grupo de 4/5 alumnos/as, se recomienda que sean del mismo turno (mañana o tarde). La formación de los equipos corre por cuenta de los/as alumnos/as, anotándose a los grupos disponibles en Moovi.

2. El trabajo consiste en desarrollar un proyecto que implemente el juego del Cinquillo_Oro
siguiendo las reglas anteriormente expuestas, utilizando el lenguaje de programación Java y el entorno NetBeans.

3. Cada miembro del grupo debe ser responsable de su trabajo, de comunicarse con otros
miembros del grupo y de conocer todas las partes del proyecto.

## ENTREGAS A REALIZAR:
El proyecto a realizar será tutorizado por el/la profesor/a para lo cual se exigirán **3 entregas completamente funcionales**. La descripción de las tareas/funciones a realizar en cada una de las entregas, así como la fecha tope de subida de cada entrega se irá indicando en la plataforma Moovi. Cada entrega será posteriormente evaluada de forma grupal por el/la profesor/a con el objetivo de conocer el grado de implicación de cada componente del grupo en la entrega realizada y realizar las correcciones oportunas que garanticen el correcto desarrollo del proyecto para conseguir el juego final.

**El hallazgo de copias de entregas supondrá el suspenso de la parte práctica, tanto para el grupo con código original, como para el grupo con código copiado.**

## EVALUACIÓN (Obtenido 9/10 pts):
La evaluación constará de dos partes: **3 evaluaciones grupales**, una por cada entrega, en forma de tutoría obligatoria; y **1 evaluación individual** en forma de examen en el ordenador.

1. **Evaluación grupal: tutoría obligatoria** para todos los miembros del grupo, en la que se mostrará la evolución del proyecto y donde el/la profesor/a pondrá preguntar a cada miembro
del grupo sobre su trabajo o sobre el de sus compañeros; el/la profesor/a acordará con cada
grupo cuándo se realizará la tutoría, siempre en la siguiente semana a cada entrega. Esta tutoría es evaluable y la media de las tres evaluaciones supondrá el 20% de la calificación final de la asignatura. Los no asistentes tendrán una única tutoría obligatoria, antes de la evaluación individual, en la que defenderán el trabajo realizado y supondrá el 20% de la calificación final de la asignatura.

2. La **Evaluación individual** del proyecto se realizará en ordenador el **6 de junio de 2023**. Supondrá el 20% de la calificación final de la asignatura, tanto para el alumnado que sigue la modalidad de asistentes como la de no asistentes
