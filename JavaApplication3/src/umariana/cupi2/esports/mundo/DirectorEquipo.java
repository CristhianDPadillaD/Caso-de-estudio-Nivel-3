package umariana.cupi2.esports.mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Clase que representa al director de un equipo dentro del sistema de eSports.
 * Se encarga de administrar jugadores, registrar partidas y realizar consultas
 * sobre la información del equipo asignado.
 *
 * <b>inv:</b><br>
 * idDirector != null && idDirector != "".<br>
 * idEquipo != null && idEquipo != "".<br>
 * nombre != null && nombre != "".<br>
 * correo != null && correo != "".<br>
 * equipoAsignado != null.<br>
 */
public class DirectorEquipo {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Identificador único del director. idDirector != null && idDirector != "".
     */
    private String idDirector;

    /**
     * Identificador del equipo que dirige el director.
     */
    private String idEquipo;

    /**
     * Nombre del director. nombre != null && nombre != "".
     */
    private String nombre;

    /**
     * Correo electrónico del director. correo != null && correo != "".
     */
    private String correo;

    /**
     * Referencia al objeto Equipo asignado al director.
     * equipoAsignado != null.
     */
    private Equipo equipoAsignado;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo Director de Equipo.
     *
     * @param idDirector  Identificador del director. idDirector != null.
     * @param idEquipo    Identificador del equipo que dirige.
     * @param nombre      Nombre del director. nombre != null.
     * @param correo      Correo electrónico del director. correo != null.
     * @param equipoAsignado Equipo asignado a este director. != null.
     *
     * <b>pre:</b><br>
     * idDirector != null && nombre != null && correo != null && equipoAsignado != null.<br>
     *
     * <b>post:</b><br>
     * Se crea el objeto DirectorEquipo con sus atributos inicializados.
     */
    public DirectorEquipo(String idDirector, String idEquipo, String nombre, String correo, Equipo equipoAsignado) {
        this.idDirector = idDirector;
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.correo = correo;
        this.equipoAsignado = equipoAsignado;
    }

    // -----------------------------------------------------------------
    // Métodos Get/Set
    // -----------------------------------------------------------------

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

    // -----------------------------------------------------------------
    // Funcionalidades
    // -----------------------------------------------------------------

    /**
     * Registra un nuevo jugador en el equipo asignado al director, valida los datos
     * y persiste la información en el archivo correspondiente.
     *
     * @param nuevoJugador     Jugador a registrar. nuevoJugador != null.
     * @param pDataFolderPath  Ruta donde se almacenan los archivos de datos.
     *
     * <b>pre:</b><br>
     * nuevoJugador != null.<br>
     * equipoAsignado != null.<br>
     * pDataFolderPath != null.<br>
     *
     * <b>post:</b><br>
     * El jugador queda registrado en el archivo y agregado al equipo en memoria.
     *
     * @throws Exception Si ocurre un error en validación o persistencia.
     */
    public void agregarJugador(Jugador nuevoJugador, String pDataFolderPath) throws Exception {

        if (equipoAsignado == null) {
            throw new Exception("No hay un equipo asignado al director.");
        }
        if (nuevoJugador == null) {
            throw new Exception("El jugador proporcionado es nulo.");
        }

        String name = (nuevoJugador.getNombre() != null) ? nuevoJugador.getNombre().trim() : "";
        String nickname = (nuevoJugador.getNickname() != null) ? nuevoJugador.getNickname().trim() : "";
        String mail = (nuevoJugador.getCorreo() != null) ? nuevoJugador.getCorreo().trim() : "";

        if (name.isEmpty()) {
            throw new Exception("Nombre del jugador es obligatorio.");
        }
        if (!name.matches("[a-zA-Z\\s]+")) {
            throw new Exception("El nombre solo puede contener letras y espacios.");
        }
        if (nickname.isEmpty()) {
            throw new Exception("El nickname del jugador es obligatorio.");
        }
        if (mail.isEmpty()) {
            throw new Exception("Correo del jugador es obligatorio.");
        }
        if (!mail.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new Exception("El correo electrónico no tiene un formato válido.");
        }
        if (equipoAsignado.existeJugadorConNickname(nickname)) {
            throw new Exception("El Nickname '" + nickname + "' ya existe en el equipo.");
        }

        String nombreEquipo = equipoAsignado.getNombre().replaceAll("\\s+", "_");
        String nombreArchivo = pDataFolderPath + "/jugadores " + nombreEquipo + ".txt";

        File carpeta = new File(pDataFolderPath);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        int contador = 0;
        File archivo = new File(nombreArchivo);

        if (archivo.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                while (br.readLine() != null) {
                    contador++;
                }
            }
        }

        String idJugador = "J" + (contador + 1);
        nuevoJugador.setIdJugador(idJugador);

        String lineaJugador = idJugador + "," +
                nuevoJugador.getIdEquipo() + "," +
                name + "," +
                nickname + "," +
                mail;

        try (FileWriter fileWriter = new FileWriter(nombreArchivo, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            printWriter.println(lineaJugador);

        } catch (IOException e) {
            throw new Exception("Error al guardar el jugador en el archivo: " + e.getMessage(), e);
        }

        equipoAsignado.addJugador(nuevoJugador);

        System.out.println("LOG: Jugador agregado y guardado en " + nombreArchivo);
    }

    /**
     * Registra una nueva partida del equipo asignado contra un equipo rival.
     *
     * @param pEquipoRival       Equipo contrario. != null.
     * @param pPuntuacionPropia  Puntuación del equipo asignado. >= 0.
     * @param pPuntuacionRival   Puntuación del rival. >= 0.
     * @param pDataFolderPath    Ruta donde se guardará el archivo.
     *
     * <b>pre:</b><br>
     * pEquipoRival != null.<br>
     * pPuntuacionPropia >= 0.<br>
     * pPuntuacionRival >= 0.<br>
     *
     * <b>post:</b><br>
     * La partida queda registrada en el archivo y en la memoria del equipo.
     *
     * @throws Exception Si ocurre un error de validación o escritura.
     */
    public void registrarPartida(Equipo pEquipoRival, int pPuntuacionPropia, int pPuntuacionRival, String pDataFolderPath)
            throws Exception {

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
        for (String p : palabras) {
            if (!p.isEmpty()) {
                abreviatura.append(p.charAt(0));
            }
        }
        String prefijoId = abreviatura.toString().toUpperCase();

        int numeroPartida = equipoAsignado.getPartidas().size() + 1;
        String nuevoIdPartida = prefijoId + "-" + numeroPartida;

        Partida nuevaPartida = new Partida(
                nuevoIdPartida,
                equipoAsignado,
                pEquipoRival,
                pPuntuacionPropia,
                pPuntuacionRival
        );

        String lineaPartida = nuevaPartida.getIdPartida() + "," +
                nuevaPartida.getEquipo1().getIdEquipo() + "," +
                nuevaPartida.getEquipo2().getIdEquipo() + "," +
                nuevaPartida.getPuntuacionEquipo1() + "," +
                nuevaPartida.getPuntuacionEquipo2() + "," +
                nuevaPartida.getFechaHora();

        String nombreEquipoSanitizado = equipoAsignado.getNombre().replaceAll("\\s+", "_");
        String nombreArchivo = pDataFolderPath + "/partidas_" + nombreEquipoSanitizado + ".txt";

        File carpeta = new File(pDataFolderPath);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        try (FileWriter fileWriter = new FileWriter(nombreArchivo, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(lineaPartida);
        } catch (IOException e) {
            throw new Exception("Error al guardar la partida en el archivo: " + e.getMessage(), e);
        }

        equipoAsignado.addPartida(nuevaPartida);
        pEquipoRival.addPartida(nuevaPartida);

        System.out.println("LOG: Partida " + nuevoIdPartida + " registrada y guardada en " + nombreArchivo);
    }

    /**
     * Consulta y retorna la lista de jugadores del equipo asignado.
     *
     * @return Lista de jugadores del equipo asignado. Nunca null.
     */
    public List<Jugador> consultarListaJugadores() {
        if (equipoAsignado == null) {
            System.err.println("Advertencia: El director no tiene un equipo asignado.");
            return new ArrayList<>();
        }

        return equipoAsignado.getJugadores();
    }

    /**
     * Ordena los jugadores del equipo asignado por su KDA de forma descendente.
     *
     * <b>pre:</b><br>
     * equipoAsignado != null.<br>
     * equipoAsignado.getJugadores().size() > 0.<br>
     *
     * <b>post:</b><br>
     * La lista de jugadores queda ordenada por KDA de mayor a menor.
     *
     * @throws Exception Si el equipo no está asignado o no hay jugadores.
     */
    public void ordenarJugadoresPorKDA() throws Exception {
        if (equipoAsignado == null) {
            throw new Exception("No hay un equipo asignado al director.");
        }

        List<Jugador> jugadores = equipoAsignado.getJugadores();

        if (jugadores.isEmpty()) {
            throw new Exception("No hay datos disponibles para ordenar.");
        }

        Collections.sort(jugadores, Comparator.comparing(Jugador::getKDA).reversed());
    }

    /**
     * Consulta el jugador con más kills dentro del equipo asignado.
     *
     * @return Jugador con mayor cantidad de kills o null si no hay jugadores.
     * @throws Exception Si no hay equipo asignado.
     */
    public Jugador consultarJugadorConMasKills() throws Exception {
        if (equipoAsignado == null) {
            throw new Exception("No hay un equipo asignado al director.");
        }

        List<Jugador> jugadores = equipoAsignado.getJugadores();

        if (jugadores.isEmpty()) {
            return null;
        }

        Jugador maxKillsJugador = null;
        int maxKills = -1;

        for (Jugador j : jugadores) {
            if (j.getKills() > maxKills) {
                maxKills = j.getKills();
                maxKillsJugador = j;
            }
        }
        return maxKillsJugador;
    }
}
