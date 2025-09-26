package Mundo;

public class Jugador {

    // Atributos basados en los Datos de la HU (Jugador1 y Jugador2)
    private String idJugador;
    private String idEquipo; 
    private String nombre;
    private String nickname;
    private String correo;
    //constructor

    public Jugador(String idJugador, String idEquipo, String nombre, String nickname, String correo) {
        this.idJugador = idJugador;
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.nickname = nickname;
        this.correo = correo;
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
    
       public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

   
    @Override
    public String toString() {
        return idJugador +" | "+ idEquipo+" | "+nickname+" | "+nombre+ correo;
    }
}