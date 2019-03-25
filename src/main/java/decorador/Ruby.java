package decorador;


import jugador.Jugador;

public class Ruby extends GemaDecorador {

  private Jugador jugador;

  public Ruby(Jugador jugador) {
    this.jugador = jugador;
  }

  @Override
  public String getDescripcion() {
    return jugador.getDescripcion() + ", " + TipoGema.RUBY;
  }

  @Override
  public int getPuntaje() {
    return TipoGema.RUBY.getValor() + jugador.getPuntaje();
  }
}
