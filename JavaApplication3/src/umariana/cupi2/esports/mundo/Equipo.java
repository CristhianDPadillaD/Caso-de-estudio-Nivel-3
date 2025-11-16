package umariana.cupi2.esports.mundo;

import java.util.ArrayList;

/**
 * Representa un equipo dentro del sistema de eSports.
 *
 * Cada equipo tiene un identificador, un nombre, un director, una lista de jugadores
 * y una lista de partidas jugadas.
 *
 * <b>inv:</b><br>
 * idEquipo != null && idEquipo != "".<br>
 * nombre != null && nombre != "".<br>
 * jugadores != null.<br>
 * partidas != null.<br>
 */
public class Equipo {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Identificador único del equipo.
     */
    private String idEquipo;

    /**
     * Nombre del equipo.
     */
    private String nombre;

    /**
     * Lista de jugadores que pertenecen a este equipo.
     * jugadores != null.
     */
    private ArrayList<Jugador> jugadores;

    /**
     * Identificador del director del equipo.
     */
    private String idDirector;

    /**
     * Lista de partidas jugadas por el equipo.
     * partidas != null.
     */
    private ArrayList<Partida> partidas;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo equipo con la información suministrada.
     *
     * <b>pre:</b> idEquipo != null, nombre != null, jugadores != null, partidas != null.<br>
     * <b>post:</b> Se inicializa el equipo con los valores dados.
     *
     * @param idEquipo Identificador único del equipo.
     * @param nombre Nombre del equipo.
     * @param jugadores Lista inicial de jugadores.
     * @param idDirector Identificador del director.
     * @param partidas Lista inicial de partidas jugadas.
     */
    public Equipo(String idEquipo, String nombre, ArrayList<Jugador> jugadores, String idDirector, ArrayList<Partida> partidas) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.jugadores = jugadores;
        this.idDirector = idDirector;
        this.partidas = partidas;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Agrega un nuevo jugador al equipo.
     *
     * <b>pre:</b> nuevoJugador != null.<br>
     * <b>post:</b> El jugador es agregado a la lista.
     *
     * @param nuevoJugador Jugador a agregar.
     */
    public void addJugador(Jugador nuevoJugador) {
        jugadores.add(nuevoJugador);
    }

    /**
     * Retorna la lista de jugadores del equipo.
     *
     * @return Lista de jugadores. jugadores != null.
     */
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    /**
     * Retorna el ID del equipo.
     * @return idEquipo.
     */
    public String getIdEquipo() {
        return idEquipo;
    }

    /**
     * Cambia el identificador del equipo.
     *
     * @param idEquipo Nuevo identificador.
     */
    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    /**
     * Retorna el nombre del equipo.
     * @return nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del equipo.
     *
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el ID del director.
     * @return idDirector.
     */
    public String getIdDirector() {
        return idDirector;
    }

    /**
     * Cambia el ID del director.
     *
     * @param idDirector Nuevo identificador.
     */
    public void setIdDirector(String idDirector) {
        this.idDirector = idDirector;
    }

    /**
     * Verifica si existe un jugador con un nickname específico.
     *
     * <b>pre:</b> nickname != null.<br>
     * <b>post:</b> Retorna true si existe, false si no.
     *
     * @param nickname Nickname del jugador a buscar.
     * @return True si existe un jugador con ese nickname.
     */
    public boolean existeJugadorConNickname(String nickname) {
        for (Jugador j : jugadores) {
            if (j.getNickname().equalsIgnoreCase(nickname)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Agrega una partida a la lista del equipo.
     *
     * <b>pre:</b> pPartida != null.<br>
     * <b>post:</b> La partida es agregada a la lista.
     *
     * @param pPartida Nueva partida.
     */
    public void addPartida(Partida pPartida) {
        if (partidas == null) {
            partidas = new ArrayList<>();
        }
        this.partidas.add(pPartida);
    }

    /**
     * Retorna la lista de partidas del equipo.
     *
     * @return Lista de partidas jugadas.
     */
    public ArrayList<Partida> getPartidas() {
        if (partidas == null) {
            partidas = new ArrayList<>();
        }
        return partidas;
    }

    /**
     * Calcula el promedio de victorias del equipo.
     *
     * <b>post:</b> Retorna un valor entre 0 y 1.
     *
     * @return Promedio de victorias.
     */
    public double promedioVictorias() {
        ArrayList<Partida> partidas = getPartidas();
        if (partidas.isEmpty()) {
            return 0.0;
        }
        int victorias = 0;
        for (Partida p : partidas) {
            if (p.getGanador() != null && p.getGanador().equals(this)) {
                victorias++;
            }
        }
        return (double) victorias / partidas.size();
    }

    /**
     * Calcula el promedio de derrotas del equipo.
     *
     * <b>post:</b> Retorna un valor entre 0 y 1.
     *
     * @return Promedio de derrotas.
     */
    public double promedioDerrotas() {
        ArrayList<Partida> partidas = getPartidas();
        if (partidas.isEmpty()) {
            return 0.0;
        }
        int derrotas = 0;
        for (Partida p : partidas) {
            if (p.getGanador() != null && !p.getGanador().equals(this)) {
                derrotas++;
            }
        }
        return (double) derrotas / partidas.size();
    }
}
