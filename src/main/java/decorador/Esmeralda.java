package decorador;

import jugador.Jugador;

public class Esmeralda extends GemaDecorador {

  private Jugador jugador;

  public Esmeralda(Jugador jugador) {
    this.jugador = jugador;
  }

  @Override
  public String getDescripcion() {
    return jugador.getDescripcion() + ", " + TipoGema.ESMERALDA;
  }

  @Override
  public int getPuntaje() {
    return TipoGema.ESMERALDA.getValor() + jugador.getPuntaje();
  }
}
