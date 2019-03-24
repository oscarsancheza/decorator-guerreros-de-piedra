package jugador;

public class Guerrero extends Jugador {

  public Guerrero() {
    descripcion = "Guerrero";
  }

  public Guerrero(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public int getPuntaje() {
    return 4;
  }

}

