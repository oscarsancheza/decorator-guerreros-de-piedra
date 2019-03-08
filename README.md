# EJERCICIO-PATRÓN DECORADOR
# REQUISITOS-MINISIMULACIÓN JUEGO “GUERREROS DE PIEDRAS PRECIOSAS”

“Guerreros de Piedras Preciosas” es un juego de búsqueda de piedras preciosas en las cuales los participantes adquieren poderes conforme encuentran piedras preciosas y pierden poderes cuando son derrotados en batallas con sus oponentes. Las reglas del juego son las siguientes:

A)	Los jugadores pasan por 20 posiciones donde pueden suceder cualquiera de las siguientes situaciones:
a.	Encontrar y guardar una piedra preciosa donde el jugador suma los siguientes puntos de poder:
  i.	Esmeralda: gana 2 puntos.
  ii.	Ruby: gana 5 puntos.
  iii.	Ónice: gana 1 punto.
  iv.	Diamante: gana 8 puntos
  v.	Zafiro: gana 3 puntos.
b.	Si además de encontrar la piedra se encuentra con otros oponentes en la misma posición deberá luchar con cada uno, ganando la batalla aquél que posee mayor poder. Los perdedores disminuyen su poder de acuerdo a la diferencia que hay entre el poder del ganador y cada perdedor (Esta derrota se puede considerar como una piedra que quita poder). 

Ej.- Si el jugador A posee 15 puntos de poder y el jugador B tiene 11 puntos de poder. El jugador A se mantiene con 15 puntos y el perdedor queda en 7 puntos (pierde 15-11=4 puntos). El perdedor agregaría una piedra (tipo Kryptonita) que le quita un poder de 4 puntos. En caso de empate, nadie pierde poder, no se agrega ninguna piedra.
B)	Cuando un jugador queda con un poder menor o igual a 0 puntos es eliminado del juego.
C)	El ganador del torneo es aquél que al recorrer las 20 posiciones queda con mayor poder o cuando todos han sido eliminados excepto el ganador, aunque no haya recorrido las 20 posiciones.
D)	En cada cuadro pueden existir un máximo de 3 piedras preciosas. Al llegar un jugador al cuadro selecciona la de mayor puntaje y la agrega a su poder.
E)	 Al iniciar el juego, se generará el tablero aleatoriamente.
F)	Al final se muestran el estado de los 3 jugadores mostrando, mínimante, las piedras ganadas y perdidas, así como su poder final.
Construya una aplicación que simule la participación de 3 jugadores, lanzando un dado de hasta 3 caras (valores 1 al 3) para ir avanzando en el tablero. El simulador deberá mostrar el estado de cada jugador: luchando, ganando/perdiendo poder o avanzando (no necesariamente debe existir piedra preciosa o lucha en alguna posición). Todos los jugadores inician con un poder de 4 puntos. El programa, además, deberá mostrar el ganador (o empate si fuera el caso).
ENTREGABLES:
a)	Puede realizarse en equipos de 2 participantes.
b)	El Diagrama de Clases mostrando la vista estructural del diseño (En documento Word). Debe mostrarse claramente el uso del patrón decorador como herramienta clave para la implementación de este juego, principalmente en la adquisición y pérdida de poderes.
c)	Las ramas que se crearon para su construcción y control de cambios.
d)	La URL del repositorio GIT del proyecto.
e)	1 Ejemplo de corrida del proyecto.
