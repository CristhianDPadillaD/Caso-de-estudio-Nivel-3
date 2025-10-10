/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umariana.cupi2.esports.mundo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Esports {

    private ArrayList<Equipo> equipos;

    public Esports() {
        this.equipos = new ArrayList<>();
    }
public void addEquipo(Equipo equipo) {
        this.equipos.add(equipo);
    }
    
   
    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }
    
    public class CargadorDatos { // Puedes integrar esto en tu Interfaz principal

    private static final String ARCHIVO_EQUIPOS = "./data/equipos.txt";
    private static final String ARCHIVO_DIRECTORES = "./data/directores.txt";

    /**
     * Carga todos los datos de equipos y directores e inicializa el modelo.
     * @return El objeto Esports inicializado con los datos cargados.
     * @throws Exception Si ocurre un error de lectura o formato.
     */
    public Esports cargarModelo() throws Exception {
        
        // Paso 1: Inicializar el modelo y colecciones auxiliares
        Esports esports = new Esports();
        Map<String, Equipo> mapaEquipos = new HashMap<>(); // Para búsqueda rápida por ID

        // Paso 2: Cargar Equipos
        cargarEquipos(mapaEquipos, esports.getEquipos());

        // Paso 3: Cargar Directores y asignarlos a los Equipos
        cargarDirectores(mapaEquipos);

        // Paso 4: Cargar Jugadores y Partidas
        cargarJugadores(mapaEquipos);
        cargarPartidas(esports.getEquipos());
        
        return esports;
    }

    // ------------------- Métodos de Carga -------------------

    private void cargarEquipos(Map<String, Equipo> mapaEquipos, List<Equipo> listaEquipos) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_EQUIPOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                // Formato: idEquipo, nombreEquipo, idDirectorAsignado
                if (partes.length >= 3) {
                    String id = partes[0].trim();
                    String nombre = partes[1].trim();
                    // El idDirectorAsignado se usará solo como referencia aquí.
                    // El objeto DirectorEquipo real se asignará en el siguiente paso.

                    // La lista de jugadores es vacía al inicio (new ArrayList<>())
                    Equipo nuevoEquipo = new Equipo(id, nombre, new ArrayList<>(), partes[2].trim(),new ArrayList<>() ); 
                    
                    listaEquipos.add(nuevoEquipo);
                    mapaEquipos.put(id, nuevoEquipo);
                }
            }
        } catch (IOException e) {
            throw new Exception("Error al cargar el archivo de equipos: " + e.getMessage());
        }
    }
    
    private void cargarDirectores(Map<String, Equipo> mapaEquipos) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_DIRECTORES))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                // Formato: idDirector, idEquipoDirigido, nombreDirector, correoDirector
                if (partes.length >= 4) {
                    String idDirector = partes[0].trim();
                    String idEquipo = partes[1].trim();
                    String nombreDirector = partes[2].trim();
                    String correoDirector = partes[3].trim();

                    Equipo equipoAsignado = mapaEquipos.get(idEquipo);

                    if (equipoAsignado != null) {
                        // Creamos el Director y lo asignamos al Equipo (si tienes un método en Equipo para esto)
                        DirectorEquipo nuevoDirector = new DirectorEquipo(
                            idDirector, idEquipo, nombreDirector, correoDirector, equipoAsignado
                        );

                        // Podrías necesitar un método para asignar el director al equipo, ej:
                        // equipoAsignado.setDirector(nuevoDirector);
                    } else {
                        System.err.println("Advertencia: Director " + nombreDirector + " apunta a un Equipo inexistente (" + idEquipo + ").");
                    }
                }
            }
        } catch (IOException e) {
            throw new Exception("Error al cargar el archivo de directores: " + e.getMessage());
        }
    }

    private void cargarJugadores(Map<String, Equipo> mapaEquipos) throws Exception {
        for (Equipo equipo : mapaEquipos.values()) {
            String nombreArchivo = "./data/jugadores " + equipo.getNombre().replaceAll("\\s+", "_") + ".txt";
            try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(",");
                    // Formato: idJugador,idEquipo,nombre,nickname,correo
                    if (partes.length >= 5) {
                        String idJugador = partes[0].trim();
                        String idEquipo = partes[1].trim();
                        String nombre = partes[2].trim();
                        String nickname = partes[3].trim();
                        String correo = partes[4].trim();

                        Jugador nuevoJugador = new Jugador(idJugador, idEquipo, nombre, nickname, correo, 0, 0, 0);
                        equipo.addJugador(nuevoJugador);
                    }
                }
            } catch (IOException e) {
                // Si el archivo no existe, simplemente no cargamos nada para ese equipo
                System.out.println("Archivo de jugadores no encontrado para " + equipo.getNombre() + ": " + nombreArchivo);
            }
        }
    }

    private void cargarPartidas(List<Equipo> listaEquipos) throws Exception {
        Map<String, Equipo> mapaEquiposPorId = new HashMap<>();
        for (Equipo eq : listaEquipos) {
            mapaEquiposPorId.put(eq.getIdEquipo(), eq);
        }

        for (Equipo equipo : listaEquipos) {
            String nombreArchivo = "./data/partidas_" + equipo.getNombre().replaceAll("\\s+", "_") + ".txt";
            try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(",");
                    // Formato: idPartida,idEquipo1,idEquipo2,puntuacion1,puntuacion2
                    if (partes.length >= 5) {
                        String idPartida = partes[0].trim();
                        String idEquipo1 = partes[1].trim();
                        String idEquipo2 = partes[2].trim();
                        int puntuacion1 = Integer.parseInt(partes[3].trim());
                        int puntuacion2 = Integer.parseInt(partes[4].trim());

                        Equipo eq1 = mapaEquiposPorId.get(idEquipo1);
                        Equipo eq2 = mapaEquiposPorId.get(idEquipo2);

                        if (eq1 != null && eq2 != null) {
                            Partida nuevaPartida = new Partida(idPartida, eq1, eq2, puntuacion1, puntuacion2);
                            equipo.addPartida(nuevaPartida);
                        } else {
                            System.err.println("Advertencia: Partida " + idPartida + " apunta a equipos inexistentes.");
                        }
                    }
                }
            } catch (IOException e) {
                // Si el archivo no existe, simplemente no cargamos nada para ese equipo
                System.out.println("Archivo de partidas no encontrado para " + equipo.getNombre() + ": " + nombreArchivo);
            }
        }
    }
}
    
    public Equipo darEquipoPorNombre(String nombre) {
    for (Equipo equipo : equipos) {
        if (equipo.getNombre().equalsIgnoreCase(nombre)) {
            return equipo;
        }
    }
    return null; 
}
    
}