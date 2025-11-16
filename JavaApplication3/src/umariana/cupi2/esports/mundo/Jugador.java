package umariana.cupi2.esports.mundo;

/**
 * Representa un jugador dentro del sistema de eSports.
 * 
 * Cada jugador tiene un identificador, un equipo al que pertenece, información personal
 * y estadísticas de rendimiento (kills, deaths, assists).
 *
 * <b>inv:</b><br>
 * idJugador != null && idJugador != "".<br>
 * idEquipo != null && idEquipo != "".<br>
 * nombre != null && nombre != "".<br>
 * nickname != null && nickname != "".<br>
 * correo != null && correo != "".<br>
 * kills >= 0.<br>
 * deaths >= 0.<br>
 * assists >= 0.<br>
 */
public class Jugador {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Identificador único del jugador.
     */
    private String idJugador;

    /**
     * Identificador del equipo al que pertenece.
     */
    private String idEquipo;

    /**
     * Nombre real del jugador.
     */
    private String nombre;

    /**
     * Alias o nickname del jugador.
     */
    private String nickname;

    /**
     * Correo electrónico del jugador.
     */
    private String correo;

    /**
     * Cantidad de kills del jugador.
     */
    private int kills;

    /**
     * Cantidad de muertes del jugador.
     */
    private int deaths;

    /**
     * Cantidad de asistencias del jugador.
     */
    private int assists;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo jugador con toda la información suministrada.
     *
     * <b>pre:</b><br>
     * idJugador != null.<br>
     * idEquipo != null.<br>
     * nombre != null.<br>
     * nickname != null.<br>
     * correo != null.<br>
     * kills >= 0, deaths >= 0, assists >= 0.<br>
     *
     * <b>post:</b><br>
     * Se inicializa el jugador con los valores proporcionados.
     *
     * @param idJugador Identificador del jugador.
     * @param idEquipo Identificador del equipo.
     * @param nombre Nombre real del jugador.
     * @param nickname Nickname del jugador.
     * @param correo Correo electrónico.
     * @param kills Cantidad de kills.
     * @param deaths Cantidad de muertes.
     * @param assists Cantidad de asistencias.
     */
    public Jugador(String idJugador, String idEquipo, String nombre, String nickname, String correo, int kills, int deaths, int assists) {
        this.idJugador = idJugador;
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.nickname = nickname;
        this.correo = correo;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
    }

    // -----------------------------------------------------------------
    // Métodos getters y setters
    // -----------------------------------------------------------------

    /**
     * Retorna el identificador del jugador.
     * @return idJugador.
     */
    public String getIdJugador() {
        return idJugador;
    }

    /**
     * Cambia el identificador del jugador.
     * @param idJugador Nuevo ID.
     */
    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
    }

    /**
     * Retorna el ID del equipo.
     * @return idEquipo.
     */
    public String getIdEquipo() {
        return idEquipo;
    }

    /**
     * Cambia el ID del equipo del jugador.
     * @param idEquipo Nuevo ID.
     */
    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    /**
     * Retorna el nombre real del jugador.
     * @return nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del jugador.
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el nickname del jugador.
     * @return nickname.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Cambia el nickname del jugador.
     * @param nickname Nuevo nickname.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Retorna el correo electrónico del jugador.
     * @return correo.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Cambia el correo del jugador.
     * @param correo Nuevo correo.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Retorna la cantidad de kills registrados.
     * @return kills.
     */
    public int getKills() {
        return kills;
    }

    /**
     * Cambia la cantidad de kills.
     * @param kills Nuevo valor.
     */
    public void setKills(int kills) {
        this.kills = kills;
    }

    /**
     * Retorna la cantidad de muertes registradas.
     * @return deaths.
     */
    public int getDeaths() {
        return deaths;
    }

    /**
     * Cambia la cantidad de muertes.
     * @param deaths Nuevo valor.
     */
    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    /**
     * Retorna la cantidad de asistencias registradas.
     * @return assists.
     */
    public int getAssists() {
        return assists;
    }

    /**
     * Cambia la cantidad de asistencias.
     * @param assists Nuevo valor.
     */
    public void setAssists(int assists) {
        this.assists = assists;
    }

    // -----------------------------------------------------------------
    // Métodos funcionales
    // -----------------------------------------------------------------

    /**
     * Calcula el KDA (Kill / Death / Assist ratio) del jugador.
     *
     * Fórmula:<br>
     * <code>KDA = (kills + assists) / max(deaths, 1)</code><br>
     *
     * <b>post:</b> Retorna un valor >= 0.
     *
     * @return Valor KDA como double.
     */
    public double getKDA() {
        int denominator = Math.max(deaths, 1);
        return (double) (kills + assists) / denominator;
    }
}
