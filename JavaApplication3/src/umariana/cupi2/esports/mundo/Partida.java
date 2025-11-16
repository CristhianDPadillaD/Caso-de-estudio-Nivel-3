package umariana.cupi2.esports.mundo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Representa una partida entre dos equipos dentro del sistema de eSports.
 *
 * Cada partida tiene un identificador, dos equipos, sus puntuaciones,
 * la fecha y hora del encuentro y el equipo ganador.
 *
 * <b>inv:</b><br>
 * idPartida != null && idPartida != "".<br>
 * equipo1 != null.<br>
 * equipo2 != null.<br>
 * puntuacionEquipo1 >= 0.<br>
 * puntuacionEquipo2 >= 0.<br>
 * fechaHora != null.<br>
 */
public class Partida implements Serializable {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /** Identificador único de la partida. */
    private String idPartida;

    /** Primer equipo participante. */
    private Equipo equipo1;

    /** Segundo equipo participante. */
    private Equipo equipo2;

    /** Puntuación obtenida por el primer equipo. */
    private int puntuacionEquipo1;

    /** Puntuación obtenida por el segundo equipo. */
    private int puntuacionEquipo2;

    /** Fecha y hora en la que se registró la partida. */
    private LocalDateTime fechaHora;

    /** Equipo ganador de la partida, o null si hubo empate. */
    private Equipo ganador;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Crea una nueva partida entre dos equipos con sus respectivas puntuaciones.
     *
     * <b>pre:</b><br>
     * idPartida != null.<br>
     * equipo1 != null.<br>
     * equipo2 != null.<br>
     * puntuacionEquipo1 >= 0 && puntuacionEquipo2 >= 0.<br>
     *
     * <b>post:</b><br>
     * La partida queda creada con fechaHora asignada automáticamente y
     * ganador definido según las puntuaciones.
     *
     * @param idPartida Identificador único de la partida.
     * @param equipo1 Primer equipo participante.
     * @param equipo2 Segundo equipo participante.
     * @param puntuacionEquipo1 Puntuación del equipo 1.
     * @param puntuacionEquipo2 Puntuación del equipo 2.
     */
    public Partida(String idPartida, Equipo equipo1, Equipo equipo2, int puntuacionEquipo1, int puntuacionEquipo2) {
        this.idPartida = idPartida;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.puntuacionEquipo1 = puntuacionEquipo1;
        this.puntuacionEquipo2 = puntuacionEquipo2;
        this.fechaHora = LocalDateTime.now();
        this.ganador = calcularGanador();
    }

    // -----------------------------------------------------------------
    // Métodos privados
    // -----------------------------------------------------------------

    /**
     * Determina el ganador de la partida según las puntuaciones.
     *
     * <b>pre:</b><br>
     * puntuacionEquipo1 >= 0 && puntuacionEquipo2 >= 0.<br>
     *
     * <b>post:</b><br>
     * Retorna equipo1 si su puntuación es mayor.<br>
     * Retorna equipo2 si su puntuación es mayor.<br>
     * Retorna null en caso de empate.<br>
     *
     * @return Equipo ganador o null si hubo empate.
     */
    private Equipo calcularGanador() {
        if (puntuacionEquipo1 > puntuacionEquipo2) {
            return equipo1;
        } else if (puntuacionEquipo2 > puntuacionEquipo1) {
            return equipo2;
        } else {
            return null;
        }
    }

    // -----------------------------------------------------------------
    // Getters
    // -----------------------------------------------------------------

    /** @return Identificador de la partida. */
    public String getIdPartida() { return idPartida; }

    /** @return Primer equipo participante. */
    public Equipo getEquipo1() { return equipo1; }

    /** @return Segundo equipo participante. */
    public Equipo getEquipo2() { return equipo2; }

    /** @return Puntuación obtenida por el primer equipo. */
    public int getPuntuacionEquipo1() { return puntuacionEquipo1; }

    /** @return Puntuación obtenida por el segundo equipo. */
    public int getPuntuacionEquipo2() { return puntuacionEquipo2; }

    /** @return Equipo ganador o null si hubo empate. */
    public Equipo getGanador() { return ganador; }

    /** @return Fecha y hora en que se registró la partida. */
    public LocalDateTime getFechaHora() { return fechaHora; }

    // -----------------------------------------------------------------
    // Otros métodos
    // -----------------------------------------------------------------

    /**
     * Retorna una representación en texto de la partida.
     *
     * <b>post:</b><br>
     * Retorna una cadena no nula describiendo la partida.
     *
     * @return Cadena con información descriptiva de la partida.
     */
    @Override
    public String toString() {
        String resultado = (ganador != null) ? ganador.getNombre() : "Empate";
        return "Partida entre " + equipo1.getNombre() + " y " + equipo2.getNombre() +
               " → Ganador: " + resultado + " (" + fechaHora + ")";
    }
}
