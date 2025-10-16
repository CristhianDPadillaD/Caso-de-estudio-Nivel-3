package umariana.cupi2.esports.mundo;

public class Jugador {

    // Atributos basados en los Datos de la HU (Jugador1 y Jugador2)
    private String idJugador;
    private String idEquipo; 
    private String nombre;
    private String nickname;
    private String correo;
    private int kills;
    private int deaths;
    private int assists;
    //constructor

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
    

    
    public String getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(String idJugador) {
        this.idJugador = idJugador;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
       public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    /**
     * Calcula el KDA (Kill/Death/Assist ratio) del jugador.
     * KDA = (kills + assists) / max(deaths, 1)
     * @return KDA como double
     */
    public double getKDA() {
        int denominator = Math.max(deaths, 1);
        return (double) (kills + assists) / denominator;
    }


}
