package decorador;

import jugador.Jugador;

public class Kriptonita extends GemaDecorador {

  private Jugador jugador;
  private int valorARestar;

  public Kriptonita(Jugador jugador, int valorARestar) {
    this.jugador = jugador;
    this.valorARestar = valorARestar;
  }

  @Override
  public String getDescripcion() {
    return jugador.getDescripcion() + ", " + "KRIPTONITA";
  }

  @Override
  public int getPuntaje() {
    return jugador.getPuntaje() - valorARestar;
  }
}