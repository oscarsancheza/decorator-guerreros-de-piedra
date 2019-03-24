package decorador;

import jugador.Jugador;

public class Onice extends GemaDecorador {

  private Jugador jugador;

  public Onice(Jugador jugador) {
    this.jugador = jugador;
  }

  @Override
  public String getDescripcion() {
    return jugador.getDescripcion() + ", " + TipoGema.ONICE;
  }

  @Override
  public int getPuntaje() {
    return TipoGema.ONICE.getValor() + jugador.getPuntaje();
  }
}
