package tablero;

import jugador.Jugador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Tablero {
    public static final int TABLERO_SIZE = 20;
    private List<Casilla> casillas;

    public Tablero() {
        casillas = new ArrayList<>();
        IntStream.rangeClosed(1, TABLERO_SIZE).forEach((i) -> casillas.add(new Casilla()));
    }

    public Jugador decorar(Jugador jugador, Integer posicion) {
        return casillas.get(posicion).getGema(jugador);
    }
}
