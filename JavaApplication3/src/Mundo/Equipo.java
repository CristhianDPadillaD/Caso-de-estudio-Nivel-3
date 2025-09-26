package Mundo;

import java.util.ArrayList;

public class Equipo {


    private String idEquipo;
    private String nombre;
    private ArrayList<Jugador> jugadores; // Lista de jugadores que pertenecen a este equipo

    private String idDirector; 

    public Equipo(String idEquipo, String nombre, ArrayList<Jugador> jugadores, String idDirector) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.jugadores = jugadores;
        this.idDirector = idDirector;
    }
  
     // Método de bajo nivel: solo añade el jugador a su lista.
    public void addJugador(Jugador nuevoJugador) {
        jugadores.add(nuevoJugador);
    }
    
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    
    // Método de búsqueda para validación
    public boolean existeJugadorConNickname(String nickname) {
        for (Jugador j : jugadores) {
            if (j.getNickname().equalsIgnoreCase(nickname)) {
                return true;
            }
        }
        return false;
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

    public String getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(String idDirector) {
        this.idDirector = idDirector;
    }

 

}