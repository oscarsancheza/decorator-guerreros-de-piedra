package guerrerosApp;

import decorador.Kriptonita;
import jugador.Guerrero;
import jugador.Jugador;
import jugador.JugadorEstatus;
import tablero.Tablero;

import java.util.*;


public class Juego {
    private List<Jugador> jugadores = new ArrayList<>();
    private Map<Integer, Integer> jugadoresPosicion = new HashMap<>();
    private Tablero tablero;

    public Juego() {
        init();
    }

    private void init() {
        jugadores.add(new Guerrero("El Primo"));
        jugadores.add(new Guerrero("Colt"));
        jugadores.add(new Guerrero("Shelly"));

        for (int i = 0; i < jugadores.size(); i++) {
            jugadoresPosicion.put(i, -1);
        }

        tablero = new Tablero();
    }

    public void jugar() {
        Random random = new Random();
        Integer dado;
        Integer nuevaposicion;
        Jugador jugadorActual;
        boolean estaJugando = true;

        while (estaJugando) {
            for (Integer posicionArray : jugadoresPosicion.keySet()) {
                jugadorActual = jugadores.get(posicionArray);
                if (jugadorActual.getEstatus() == JugadorEstatus.JUGANDO) {

                    dado = random.nextInt(3) + 1;
                    nuevaposicion = jugadoresPosicion.get(posicionArray) + dado;

                    if (nuevaposicion > Tablero.TABLERO_SIZE - 1) {
                        nuevaposicion = Tablero.TABLERO_SIZE - 1;
                    }

                    jugadorActual = this.tablero.decorar(jugadorActual, nuevaposicion);
                    jugadorActual = this.pelea(jugadorActual, nuevaposicion);

                    if (jugadorActual.getEstatus() != JugadorEstatus.PERDIO && nuevaposicion == Tablero.TABLERO_SIZE - 1) {
                        jugadorActual.setEstatus(JugadorEstatus.FINALIZO);
                    }

                    jugadores.set(posicionArray, jugadorActual);
                    jugadoresPosicion.replace(posicionArray, nuevaposicion);
                }
            }
            mostrarEstadisticas();
            estaJugando = seTerminoJuego();
        }

        imprimirGanador();
    }

    private void mostrarEstadisticas() {
        for (Integer posicionJugador : jugadoresPosicion.keySet()) {
            Jugador jugador = jugadores.get(posicionJugador);

            System.out.println("Posicion Tablero:" + (jugadoresPosicion.get(posicionJugador) + 1)
                    + " --- " + jugador.getDescripcion()
                    + ", Puntaje:" + jugador.getPuntaje() + ", Estado:" + jugador.getEstatus());
        }
        System.out.println("\n");
    }

    private void imprimirGanador() {

        Jugador ganador = new Guerrero();
        List<Jugador> empates = new ArrayList<>();

        for (Integer posicionJugador : jugadoresPosicion.keySet()) {
            Jugador jugador = jugadores.get(posicionJugador);

            if (jugador.getPuntaje() > ganador.getPuntaje()) {
                ganador = jugador;
            }
        }

        for (Integer posicionJugador : jugadoresPosicion.keySet()) {
            Jugador jugador = jugadores.get(posicionJugador);

            if (ganador.getPuntaje() == jugador.getPuntaje() &&
                    !ganador.getDescripcion().equals(jugador.getDescripcion())) {
                empates.add(jugador);
            }
        }

        if (!empates.isEmpty()) {
            System.out.println("Empates:");
            empates.forEach(jugador -> System.out.println(jugador.getDescripcion() + ", Puntaje:" + jugador.getPuntaje()));
        } else {
            System.out.println("Campeon:" + ganador.getDescripcion() + ", Puntaje:" + ganador.getPuntaje());
        }
    }

    private boolean seTerminoJuego() {
        int perdedores = 0;
        int ganadores = 0;

        for (Integer posicionJugador : jugadoresPosicion.keySet()) {
            Jugador jugador = jugadores.get(posicionJugador);

            if (jugador.getEstatus() == JugadorEstatus.PERDIO) {
                perdedores++;
            }

            if (jugador.getEstatus() == JugadorEstatus.FINALIZO) {
                ganadores++;
            }
        }


        return !(perdedores == jugadores.size() - 1 || ganadores == jugadores.size() ||
                (ganadores + perdedores == jugadores.size()));
    }

    private Jugador pelea(Jugador jugador, Integer posicionCasilla) {
        for (Integer posicionJugador : jugadoresPosicion.keySet()) {
            if (jugadoresPosicion.get(posicionJugador).compareTo(posicionCasilla) == 0) {
                Jugador Peleador = jugadores.get(posicionJugador);

                int res = jugador.getPuntaje() - Peleador.getPuntaje();

                if (res < 0) {
                    jugador = new Kriptonita(jugador, res * -1);
                    if (jugador.getPuntaje() <= 0) {
                        jugador.setEstatus(JugadorEstatus.PERDIO);
                    }
                } else if (res > 0) {
                    Peleador = new Kriptonita(Peleador, res);
                    if (Peleador.getPuntaje() <= 0) {
                        Peleador.setEstatus(JugadorEstatus.PERDIO);
                    }
                    jugadores.set(posicionJugador, Peleador);
                }
            }
        }

        return jugador;
    }

    public static void main(String args[]) {
        Juego juego = new Juego();
        juego.jugar();
    }
}
