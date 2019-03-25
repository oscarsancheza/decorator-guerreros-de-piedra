package decorador;


import jugador.Jugador;

public class Diamante extends GemaDecorador {

  private Jugador jugador;

  public Diamante(Jugador jugador) {
    this.jugador = jugador;
  }

  @Override
  public String getDescripcion() {
    return jugador.getDescripcion() + ", " + TipoGema.DIAMANTE;
  }

  @Override
  public int getPuntaje() {
    return TipoGema.DIAMANTE.getValor() + jugador.getPuntaje();
  }
}
