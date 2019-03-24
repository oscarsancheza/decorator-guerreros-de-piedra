package decorador;

public enum TipoGema {
  DIAMANTE(8), ESMERALDA(2), ONICE(1), RUBY(5), ZAFIRO(3);

  private final int valor;

  TipoGema(int valor) {
    this.valor = valor;
  }

  public int getValor() {
    return this.valor;
  }
}
