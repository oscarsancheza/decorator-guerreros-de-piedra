package tablero;

import decorador.*;
import jugador.Jugador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Casilla {

  private final int TOTAL_GEMAS = 4;

  private List<Jugador> jugadores;
  private List<TipoGema> gemas;


  public Casilla() {
    Random random = new Random();
    gemas = new ArrayList<>();
    jugadores = new ArrayList<>();
    int numgem = random.nextInt(TOTAL_GEMAS);

    if (numgem > 0) {
      IntStream.rangeClosed(1, numgem).forEach((i) -> {
        gemas.add(this.crearGema(random.nextInt(5) + 1));
      });
    }
  }

  public TipoGema crearGema(Integer tipo) {
    TipoGema gema = null;

    switch (tipo) {
      case 1:
        gema = TipoGema.ESMERALDA;
        break;
      case 2:
        gema = TipoGema.RUBY;
        break;
      case 3:
        gema = TipoGema.ONICE;
        break;
      case 4:
        gema = TipoGema.DIAMANTE;
        break;
      case 5:
        gema = TipoGema.ZAFIRO;
        break;
    }

    return gema;
  }

  private TipoGema getMayorValor() {
    TipoGema tipoGema = null;

    if (this.gemas != null) {
      for (TipoGema item : this.gemas) {
        if (tipoGema == null) {
          tipoGema = item;
        } else if (tipoGema.getValor() < item.getValor()) {
          tipoGema = item;
        }
      }
      this.gemas.remove(tipoGema);
    }

    return tipoGema;

  }

  public Jugador getGema(Jugador jugador) {
    TipoGema tipoGema = getMayorValor();

    if (tipoGema != null) {
      switch (tipoGema) {
        case RUBY:
          jugador = new Ruby(jugador);
          break;
        case ONICE:
          jugador = new Onice(jugador);
          break;
        case ZAFIRO:
          jugador = new Zafiro(jugador);
          break;
        case DIAMANTE:
          jugador = new Diamante(jugador);
          break;
        case ESMERALDA:
          jugador = new Esmeralda(jugador);
          break;
      }
    }

    return jugador;
  }
}

