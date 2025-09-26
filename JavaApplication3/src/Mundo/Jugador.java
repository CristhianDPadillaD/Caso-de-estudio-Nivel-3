package Mundo;

public class Jugador {

    // Atributos basados en los Datos de la HU (Jugador1 y Jugador2)
    private String idJugador;
    private String idEquipo; 
    private String nombre;
    private String nickname;
    //constructor

    public Jugador(String idJugador, String idEquipo, String nombre, String nickname) {
        this.idJugador = idJugador;
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.nickname = nickname;
    }
    
    //getter and setter
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

   
    @Override
    public String toString() {
        return idJugador +" | "+ idEquipo+" | "+nickname+" | "+nombre;
    }
}