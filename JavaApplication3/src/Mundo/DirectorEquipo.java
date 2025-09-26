package Mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
// No se usa ArrayList directamente aquí, solo en la clase Equipo y el Main.

public class DirectorEquipo {

    // Atributos basados en los Datos de la HU (Director1)
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
    String nombreArchivo = "jugadores " + nombreEquipo + ".txt";

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
                        + nickname ;

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


       
 
}