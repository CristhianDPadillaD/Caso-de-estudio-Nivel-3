package umariana.cupi2.esports.mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DirectorEquipo {

 
    private String idDirector;
    private String idEquipo; 
    private String nombre;
    private String correo;
    
     private Equipo equipoAsignado; 

    public DirectorEquipo(String idDirector, String idEquipo, String nombre, String correo, Equipo equipoAsignado) {
        this.idDirector = idDirector;
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.correo = correo;
        this.equipoAsignado = equipoAsignado;
    }

    public String getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(String idDirector) {
        this.idDirector = idDirector;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Equipo getEquipoAsignado() {
        return equipoAsignado;
    }

    public void setEquipoAsignado(Equipo equipoAsignado) {
        this.equipoAsignado = equipoAsignado;
    }

  /**
     * Registra un nuevo jugador en el equipo dirigido por este Director.
     * Incluye las validaciones de negocio.
     * @param nuevoJugador El objeto Jugador a añadir.
     * @throws Exception Si la validación  falla .
     */
   public void agregarJugador(Jugador nuevoJugador) throws Exception {

    // Validaciones básicas de entrada
    if (equipoAsignado == null) {
        throw new Exception("No hay un equipo asignado al director.");
    }
    if (nuevoJugador == null) {
        throw new Exception("El jugador proporcionado es nulo.");
    }

    // Normalizar y validar campos obligatorios
    String name = (nuevoJugador.getNombre() != null) ? nuevoJugador.getNombre().trim() : "";
    String nickname = (nuevoJugador.getNickname() != null) ? nuevoJugador.getNickname().trim() : "";
    String mail = (nuevoJugador.getCorreo()!=null)? nuevoJugador.getCorreo().trim():"";

    if (name.isEmpty()) {
        throw new Exception("Nombre del jugador es obligatorio.");
    }
    if (nickname.isEmpty()) {
        throw new Exception("Nickname del jugador es obligatorio.");
    }

    // Validación: nickname duplicado (usa la lista en memoria)
    if (equipoAsignado.existeJugadorConNickname(nickname)) {
        throw new Exception("El Nickname '" + nickname + "' ya existe en el equipo.");
    }

    // Preparar línea para persistencia (asegurando nombre de archivo seguro)
    String nombreEquipo = (equipoAsignado.getNombre() != null && !equipoAsignado.getNombre().trim().isEmpty())
                          ? equipoAsignado.getNombre().replaceAll("\\s+", "_")
                          : equipoAsignado.getIdEquipo();
    
    String nombreArchivo = daraFolderPath"./jugadores " + nombreEquipo + ".txt";

     // 3. Leer el archivo y contar cuántos jugadores hay
    int contador = 0;
    File archivo = new File(nombreArchivo);
    if (archivo.exists()) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while (br.readLine() != null) {
                contador++;
            }
        }
    }

    // 4. Generar id incremental según el equipo
    String idJugador = "J" + (contador + 1);
    nuevoJugador.setIdJugador(idJugador);
    
    String lineaJugador = (nuevoJugador.getIdJugador() != null ? nuevoJugador.getIdJugador() : "") + "," 
                        + (nuevoJugador.getIdEquipo() != null ? nuevoJugador.getIdEquipo() : "") + ","
                        + name + ","
                        + nickname+","+
                            mail;

    // Persistencia: escribir en archivo primero
    try (FileWriter fileWriter = new FileWriter(nombreArchivo, true);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {

        printWriter.println(lineaJugador);

    } catch (IOException e) {
        // No añadimos en memoria porque la persistencia falló
        throw new Exception("Error al guardar el jugador en el archivo: " + e.getMessage(), e);
    }

    // Si todo salió bien en el archivo, añadimos en memoria
    equipoAsignado.addJugador(nuevoJugador);

    System.out.println("LOG: Jugador agregado y guardado en " + nombreArchivo);
}
public void registrarPartida(Equipo pEquipoRival, int pPuntuacionPropia, int pPuntuacionRival) throws Exception {


    if (pEquipoRival == null) {
        throw new Exception("El equipo rival es un dato obligatorio.");
    }
    if (equipoAsignado == null) {
        throw new Exception("No hay un equipo asignado al director para registrar la partida.");
    }
    if (pPuntuacionPropia < 0 || pPuntuacionRival < 0) {
        throw new Exception("Las puntuaciones no pueden ser negativas.");
    }


    StringBuilder abreviatura = new StringBuilder();
    String[] palabras = equipoAsignado.getNombre().split("\\s+");
    for (String palabra : palabras) {
        if (!palabra.isEmpty()) {
            abreviatura.append(palabra.charAt(0));
        }
    }
    String prefijoId = abreviatura.toString().toUpperCase();


    int numeroPartida = equipoAsignado.getPartidas().size() + 1;


    String nuevoIdPartida = prefijoId + "-" + numeroPartida;



    Partida nuevaPartida = new Partida(nuevoIdPartida, equipoAsignado, pEquipoRival, pPuntuacionPropia, pPuntuacionRival);


    String lineaPartida = nuevaPartida.getIdPartida() + "," +
                          nuevaPartida.getEquipo1().getIdEquipo() + "," +
                          nuevaPartida.getEquipo2().getIdEquipo() + "," +
                          nuevaPartida.getPuntuacionEquipo1() + "," +
                          nuevaPartida.getPuntuacionEquipo2();

    String nombreEquipoSanitizado = equipoAsignado.getNombre().replaceAll("\\s+", "_");
    String nombreArchivo = "./data/partidas_" + nombreEquipoSanitizado + ".txt";


    try (FileWriter fileWriter = new FileWriter(nombreArchivo, true);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        printWriter.println(lineaPartida);
    } catch (IOException e) {
        throw new Exception("Error al guardar la partida en el archivo: " + e.getMessage(), e);
    }

    equipoAsignado.addPartida(nuevaPartida);

    System.out.println("LOG: Partida " + nuevoIdPartida + " registrada y guardada en " + nombreArchivo);
}

public List<Jugador> consultarListaJugadores() {
        // Criterio 1: El director accede a la lista del equipo asignado
        if (equipoAsignado == null) {
            // Manejar caso extremo si no hay equipo asignado
            System.err.println("Advertencia: El director no tiene un equipo asignado.");
            return new ArrayList<>();
        }
        
        
        return equipoAsignado.getJugadores();
    }
       
 
}