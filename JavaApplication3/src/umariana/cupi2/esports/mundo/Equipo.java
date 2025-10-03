package umariana.cupi2.esports.mundo;

import java.util.ArrayList;

public class Equipo {


    private String idEquipo;
    private String nombre;
    private ArrayList<Jugador> jugadores;
    private String idDirector; 
    private ArrayList <Partida> partidas;

    public Equipo(String idEquipo, String nombre, ArrayList<Jugador> jugadores, String idDirector, ArrayList<Partida> partidas ) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.jugadores = jugadores;
        this.idDirector = idDirector;
        this.partidas = partidas;
    }
  
    
    public void addJugador(Jugador nuevoJugador) {
        jugadores.add(nuevoJugador);
    }
    
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
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

    public boolean existeJugadorConNickname(String nickname) {
        for (Jugador j : jugadores) {
            if (j.getNickname().equalsIgnoreCase(nickname)) {
                return true;
            }
        }
        return false;
    }
    
  public void addPartida(Partida pPartida) {
        if (partidas == null) {
            partidas = new ArrayList<>();
        }
        this.partidas.add(pPartida);
    }
    
    // Getter esencial para las pruebas y consultas
    public ArrayList<Partida> getPartidas() {
        if (partidas == null) {
            partidas = new ArrayList<>();
        }
        return partidas;
    }
    

}