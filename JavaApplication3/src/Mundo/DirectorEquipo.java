package Mundo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
     * @throws Exception Si la validación de negocio falla (ej: nickname duplicado).
     */
    public void agregarJugador(Jugador nuevoJugador) throws Exception {
        
        //1. VALIDACIÓN: Nickname duplicado
        if (equipoAsignado.existeJugadorConNickname(nuevoJugador.getNickname())) {
            // Se puede usar una excepción personalizada como en el ejemplo (ElementoExisteException)
            throw new Exception("El Nickname '" + nuevoJugador.getNickname() + "' ya existe en el equipo.");
        }
        
        // 2. EJECUCIÓN (En Memoria): Añadir a la lista del Equipo
        equipoAsignado.addJugador(nuevoJugador);
        
        // 3. PERSISTENCIA (En Archivo): Lógica de I/O integrada
        try {
            // a) Formatear el nombre del archivo (ej: jugadoresTeam_Alpha.txt)
            String nombreLimpio = equipoAsignado.getNombre().replaceAll("\\s+", "_");
            String nombreArchivo = "jugadores" + nombreLimpio + ".txt";
            
            // b) Formatear la línea de datos (CSV)
            // Se asume que Jugador tiene: idJugador, idEquipo, nombre, nickname, correo, telefono, activo
            String lineaJugador = nuevoJugador.getIdJugador() + "," 
                                + nuevoJugador.getIdEquipo() + ","
                                + nuevoJugador.getNombre() + ","
                                + nuevoJugador.getNickname();

            // c) Escribir en el archivo (usando 'true' para anexar)
            // Usamos try-with-resources para asegurar que los flujos se cierren.
            try (FileWriter fileWriter = new FileWriter(nombreArchivo, true);
                 PrintWriter printWriter = new PrintWriter(fileWriter)) {
                 
                printWriter.println(lineaJugador);
                
            } 
            
            System.out.println("LOG: Jugador agregado y guardado en " + nombreArchivo);

        } catch (IOException e) {
            // Lanzar una excepción de alto nivel que la Interfaz pueda manejar
            throw new Exception("Error al guardar el jugador en el archivo: " + e.getMessage());
        }
    }

    
    
 
}