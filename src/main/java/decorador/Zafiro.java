package decorador;


import jugador.Jugador;

public class Zafiro extends GemaDecorador {

  private Jugador jugador;

  public Zafiro(Jugador jugador) {
    this.jugador = jugador;
  }

  @Override
  public String getDescripcion() {
    return jugador.getDescripcion() + ", " + TipoGema.ZAFIRO;
  }

  @Override
  public int getPuntaje() {
    return TipoGema.ZAFIRO.getValor() + jugador.getPuntaje();
  }
}
