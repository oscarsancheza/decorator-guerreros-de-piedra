package jugador;

public abstract class Jugador {
  private JugadorEstatus estatus;
  protected String descripcion = "Jugador desconocio";

  public Jugador() {
    estatus = JugadorEstatus.JUGANDO;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public abstract int getPuntaje();

  public JugadorEstatus getEstatus() {
    return estatus;
  }

  public void setEstatus(JugadorEstatus estatus) {
    this.estatus = estatus;
  }
}
