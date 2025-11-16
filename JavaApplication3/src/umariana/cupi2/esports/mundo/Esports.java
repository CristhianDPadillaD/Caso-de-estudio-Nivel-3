package umariana.cupi2.esports.mundo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// ---------------------------------------------------------------------
// Clase Esports
// ---------------------------------------------------------------------

/**
 * Clase principal del mundo que administra la información relacionada
 * con los equipos, jugadores, directores y partidas del sistema de
 * eSports.
 *
 * <b>inv:</b><br>
 * - equipos != null.<br>
 */
public class Esports {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de equipos registrados en el sistema.
     * equipos != null.
     */
    private ArrayList<Equipo> equipos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una instancia del sistema e inicializa la lista de equipos.
     * <b>post:</b> equipos se inicializa como una lista vacía.
     */
    public Esports() {
        this.equipos = new ArrayList<>();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Agrega un equipo a la lista de equipos.
     *
     * <b>pre:</b> equipo != null.<br>
     * <b>post:</b> El equipo es agregado a la lista.
     *
     * @param equipo Equipo a agregar.
     */
    public void addEquipo(Equipo equipo) {
        this.equipos.add(equipo);
    }

    /**
     * Retorna la lista de equipos registrados.
     *
     * <b>post:</b> Se retorna la lista de equipos.
     *
     * @return Lista de equipos.
     */
    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    /**
     * Busca un equipo por su nombre ignorando mayúsculas/minúsculas.
     *
     * <b>pre:</b> nombre != null. <br>
     * <b>post:</b> Se retorna el equipo correspondiente o null si no existe.
     *
     * @param nombre Nombre del equipo a buscar.
     * @return El equipo encontrado o null si no coincide ningún nombre.
     */
    public Equipo darEquipoPorNombre(String nombre) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombre)) {
                return equipo;
            }
        }
        return null;
    }

    // ---------------------------------------------------------------------
    // Clase interna CargadorDatos
    // ---------------------------------------------------------------------

    /**
     * Clase interna que se encarga de cargar los datos desde archivos de texto
     * y construir el modelo (equipos, jugadores, directores y partidas).
     */
    public class CargadorDatos {

        /**
         * Ruta del archivo que contiene los equipos.
         */
        private static final String ARCHIVO_EQUIPOS = "./data/equipos.txt";

        /**
         * Ruta del archivo que contiene los directores.
         */
        private static final String ARCHIVO_DIRECTORES = "./data/directores.txt";

        /**
         * Carga todo el modelo desde los archivos de datos.
         *
         * <b>pre:</b> Los archivos deben existir y tener el formato correcto.<br>
         * <b>post:</b> Se retorna un objeto Esports con todos los datos cargados.
         *
         * @return El sistema Esports inicializado.
         * @throws Exception Si ocurre un error de lectura o formato.
         */
        public Esports cargarModelo() throws Exception {

            Esports esports = new Esports();
            Map<String, Equipo> mapaEquipos = new HashMap<>();

            cargarEquipos(mapaEquipos, esports.getEquipos());
            cargarDirectores(mapaEquipos);
            cargarJugadores(mapaEquipos);
            cargarPartidas(esports.getEquipos());

            return esports;
        }

        // -----------------------------------------------------------------
        // Métodos de carga
        // -----------------------------------------------------------------

        /**
         * Carga los equipos desde el archivo equipos.txt.
         *
         * Formato esperado:
         * idEquipo, nombreEquipo, idDirectorAsignado
         *
         * <b>pre:</b> mapaEquipos != null, listaEquipos != null.<br>
         * <b>post:</b> Los equipos son añadidos a la lista y al mapa.
         *
         * @param mapaEquipos Mapa para búsqueda rápida por ID.
         * @param listaEquipos Lista donde se agregan los equipos.
         * @throws Exception Si ocurre un error de lectura.
         */
        private void cargarEquipos(Map<String, Equipo> mapaEquipos, List<Equipo> listaEquipos) throws Exception {
            try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_EQUIPOS))) {
                String linea;
                while ((linea = br.readLine()) != null) {

                    String[] partes = linea.split(",");

                    if (partes.length >= 3) {
                        String id = partes[0].trim();
                        String nombre = partes[1].trim();
                        String idDirector = partes[2].trim();

                        Equipo nuevoEquipo = new Equipo(id, nombre, new ArrayList<>(), idDirector, new ArrayList<>());
                        listaEquipos.add(nuevoEquipo);
                        mapaEquipos.put(id, nuevoEquipo);
                    }
                }
            } catch (IOException e) {
                throw new Exception("Error al cargar el archivo de equipos: " + e.getMessage());
            }
        }

        /**
         * Carga los directores desde el archivo directores.txt y los asigna a los equipos.
         *
         * Formato esperado:
         * idDirector, idEquipoDirigido, nombreDirector, correoDirector
         *
         * <b>pre:</b> mapaEquipos != null.<br>
         * <b>post:</b> Se asignan los directores a sus equipos correspondientes.
         *
         * @param mapaEquipos Mapa con los equipos cargados.
         * @throws Exception Si ocurre un error de lectura.
         */
        private void cargarDirectores(Map<String, Equipo> mapaEquipos) throws Exception {
            try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_DIRECTORES))) {

                String linea;
                while ((linea = br.readLine()) != null) {

                    String[] partes = linea.split(",");

                    if (partes.length >= 4) {
                        String idDirector = partes[0].trim();
                        String idEquipo = partes[1].trim();
                        String nombre = partes[2].trim();
                        String correo = partes[3].trim();

                        Equipo equipo = mapaEquipos.get(idEquipo);

                        if (equipo != null) {
                            DirectorEquipo director = new DirectorEquipo(idDirector, idEquipo, nombre, correo, equipo);
                        } else {
                            System.err.println("Advertencia: Director apunta a equipo inexistente.");
                        }
                    }
                }

            } catch (IOException e) {
                throw new Exception("Error al cargar el archivo de directores: " + e.getMessage());
            }
        }

        /**
         * Carga los jugadores de cada equipo desde archivos individuales.
         *
         * Formato esperado:
         * idJugador,idEquipo,nombre,nickname,correo
         *
         * <b>pre:</b> mapaEquipos != null.<br>
         * <b>post:</b> Los jugadores se agregan a sus respectivos equipos.
         *
         * @param mapaEquipos Mapa con los equipos.
         * @throws Exception Si ocurre un error de lectura.
         */
        private void cargarJugadores(Map<String, Equipo> mapaEquipos) throws Exception {

            for (Equipo equipo : mapaEquipos.values()) {

                String archivo = "./data/jugadores " + equipo.getNombre().replaceAll("\\s+", "_") + ".txt";

                try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

                    String linea;
                    while ((linea = br.readLine()) != null) {

                        String[] partes = linea.split(",");

                        if (partes.length >= 5) {

                            Jugador jugador = new Jugador(
                                    partes[0].trim(),
                                    partes[1].trim(),
                                    partes[2].trim(),
                                    partes[3].trim(),
                                    partes[4].trim(),
                                    0, 0, 0
                            );

                            equipo.addJugador(jugador);
                        }
                    }

                } catch (IOException e) {
                    System.out.println("Archivo de jugadores no encontrado para " + equipo.getNombre());
                }
            }
        }

        /**
         * Carga las partidas de cada equipo desde archivos individuales.
         *
         * Formato esperado:
         * idPartida,idEquipo1,idEquipo2,puntuacion1,puntuacion2
         *
         * <b>pre:</b> listaEquipos != null.<br>
         * <b>post:</b> Las partidas se agregan a los equipos correspondientes.
         *
         * @param listaEquipos Lista de equipos cargados.
         * @throws Exception Si ocurre un error de lectura.
         */
        private void cargarPartidas(List<Equipo> listaEquipos) throws Exception {

            Map<String, Equipo> mapa = new HashMap<>();

            for (Equipo eq : listaEquipos) {
                mapa.put(eq.getIdEquipo(), eq);
            }

            for (Equipo equipo : listaEquipos) {

                String archivo = "./data/partidas_" + equipo.getNombre().replaceAll("\\s+", "_") + ".txt";

                try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

                    String linea;
                    while ((linea = br.readLine()) != null) {

                        String[] partes = linea.split(",");

                        if (partes.length >= 5) {

                            Equipo eq1 = mapa.get(partes[1].trim());
                            Equipo eq2 = mapa.get(partes[2].trim());

                            if (eq1 != null && eq2 != null) {

                                Partida partida = new Partida(
                                        partes[0].trim(),
                                        eq1,
                                        eq2,
                                        Integer.parseInt(partes[3].trim()),
                                        Integer.parseInt(partes[4].trim())
                                );

                                equipo.addPartida(partida);

                            } else {
                                System.err.println("Advertencia: Partida apunta a equipos inexistentes.");
                            }
                        }
                    }

                } catch (IOException e) {
                    System.out.println("Archivo de partidas no encontrado para " + equipo.getNombre());
                }
            }
        }
    }
}
