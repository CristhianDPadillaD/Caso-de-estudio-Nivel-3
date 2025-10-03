package umariana.cupi2.esports.mundo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Partida implements Serializable {

    private String idPartida;
    private Equipo equipo1;
    private Equipo equipo2;
    private int puntuacionEquipo1;
    private int puntuacionEquipo2;
    private LocalDateTime fechaHora;
    private String ganador;

    // Constructor
    public Partida(String idPartida, Equipo equipo1, Equipo equipo2, int puntuacionEquipo1, int puntuacionEquipo2) {
        this.idPartida = idPartida;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.puntuacionEquipo1 = puntuacionEquipo1;
        this.puntuacionEquipo2 = puntuacionEquipo2;
        this.fechaHora = LocalDateTime.now();
        this.ganador = calcularGanador();
    }

    // Método para determinar el ganador
    private String calcularGanador() {
        if (puntuacionEquipo1 > puntuacionEquipo2) {
            return equipo1.getNombre();
        } else if (puntuacionEquipo2 > puntuacionEquipo1) {
            return equipo2.getNombre();
        } else {
            return "Empate";
        }
    }

    // Getters
    public String getIdPartida() { return idPartida; }
    public Equipo getEquipo1() { return equipo1; }
    public Equipo getEquipo2() { return equipo2; }
    public int getPuntuacionEquipo1() { return puntuacionEquipo1; }
    public int getPuntuacionEquipo2() { return puntuacionEquipo2; }
    public String getGanador() { return ganador; }
    public LocalDateTime getFechaHora() { return fechaHora; }

    @Override
    public String toString() {
        return "Partida entre " + equipo1.getNombre() + " y " + equipo2.getNombre() +
               " → Ganador: " + ganador + " (" + fechaHora + ")";
    }
}
