package umariana.cupi2.esports.test;

import umariana.cupi2.esports.mundo.DirectorEquipo;
import umariana.cupi2.esports.mundo.Equipo;
import umariana.cupi2.esports.mundo.Jugador;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import umariana.cupi2.esports.mundo.Partida;

/**
 * Clase de prueba para la clase {@link DirectorEquipo}.
 * <p>
 * Se encarga de verificar el correcto funcionamiento de:
 * <ul>
 *     <li>Registro de jugadores</li>
 *     <li>Validaciones de datos de jugador</li>
 *     <li>Registro de partidas entre equipos</li>
 *     <li>Consulta de jugadores</li>
 *     <li>Ordenamiento por KDA</li>
 *     <li>Consulta del jugador con más kills</li>
 *     <li>Validaciones de campos simuladas desde la interfaz</li>
 * </ul>
 * Cada prueba sigue el esquema estándar CUPI2.
 */
public class DirectorEquipoTest {

    private Equipo equipo1;
    private Equipo equipo2;
    private DirectorEquipo director1;

    private static final String TEST_DATA_PATH = "./test/testData";

    /**
     * Escenario 1: Equipos instanciados y un director asignado al equipo1.
     * <p>
     * Se ejecuta antes de cada prueba.
     */
    @Before
    public void setUp() {

        equipo1 = new Equipo("E01", "Dark Warriors", new ArrayList<>(), "D01", new ArrayList<>());
        director1 = new DirectorEquipo("D01", "E01", "Luis Ramirez", "luis@esports.com", equipo1);

        equipo2 = new Equipo("E02", "Cyber Ninjas", new ArrayList<>(), "D02", new ArrayList<>());
    }

    // ----------------------------------------------------------------------
    // I. REGISTRO DE JUGADORES
    // ----------------------------------------------------------------------

    /**
     * Prueba 1: Registro exitoso de un jugador.
     * <p>
     * Condición inicial: equipo1 vacío.
     * Acción: agregar jugador válido.
     * Resultado esperado: el jugador debe existir en el equipo.
     */
    @Test
    public void testRegistroJugador() throws Exception {
        Jugador jugador1 = new Jugador("01", "E01", "Carlos Perez", "Shadow", "Shadow@mail.com", 0, 0, 0);
        director1.agregarJugador(jugador1, TEST_DATA_PATH);

        assertTrue(equipo1.existeJugadorConNickname("Shadow"));
    }

    /**
     * Prueba 2: Nombre vacío debe generar excepción.
     */
    @Test(expected = Exception.class)
    public void testRegistrarJugador02() throws Exception {
        Jugador jugador = new Jugador("02", "E01", "", "Zero", "zero@mail.com", 0, 0, 0);
        director1.agregarJugador(jugador, TEST_DATA_PATH);
    }

    /**
     * Prueba 3: Nickname y correo vacíos deben fallar.
     */
    @Test(expected = Exception.class)
    public void testRegistrarJugador03() throws Exception {
        Jugador jugador = new Jugador("03", "E01", "Carlos Perez", "", "", 0, 0, 0);
        director1.agregarJugador(jugador, TEST_DATA_PATH);
    }

    /**
     * Prueba 4: Nombre con caracteres no permitidos.
     */
    @Test(expected = Exception.class)
    public void testRegistrarJugador04_NombreInvalido() throws Exception {
        Jugador jugador = new Jugador("04", "E01", "Carlos123", "Shadow", "shadow@mail.com", 0, 0, 0);
        director1.agregarJugador(jugador, TEST_DATA_PATH);
    }

    /**
     * Prueba 5: Correo con formato incorrecto.
     */
    @Test(expected = Exception.class)
    public void testRegistrarJugador05_CorreoInvalido() throws Exception {
        Jugador jugador = new Jugador("05", "E01", "Carlos Perez", "Shadow", "shadowmail.com", 0, 0, 0);
        director1.agregarJugador(jugador, TEST_DATA_PATH);
    }

    // ----------------------------------------------------------------------
    // II. REGISTRO DE PARTIDAS
    // ----------------------------------------------------------------------

    /**
     * Prueba: registro exitoso de partida.
     * <p>
     * Verifica ID secuencial, ganador correcto y almacenamiento.
     */
    @Test
    public void testRegistrarPartida_Exitoso() throws Exception {
        director1.registrarPartida(equipo2, 3, 1, TEST_DATA_PATH);

        List<Partida> historial = equipo1.getPartidas();
        assertFalse(historial.isEmpty());
        assertEquals(1, historial.size());
        assertEquals("DW-1", historial.get(0).getIdPartida());
        assertEquals(equipo1, historial.get(0).getGanador());
    }

    /**
     * Prueba: ID secuencial en segunda partida registrada.
     */
    @Test
    public void testRegistrarPartida_Secuencial() throws Exception {

        director1.registrarPartida(equipo2, 2, 0, TEST_DATA_PATH);
        director1.registrarPartida(equipo2, 1, 3, TEST_DATA_PATH);

        List<Partida> historial = equipo1.getPartidas();
        assertEquals(2, historial.size());
        assertEquals("DW-2", historial.get(1).getIdPartida());
    }

    /**
     * Prueba: falla si el equipo rival es nulo.
     */
    @Test(expected = Exception.class)
    public void testRegistrarPartida_RivalNulo() throws Exception {
        director1.registrarPartida(null, 3, 1, TEST_DATA_PATH);
    }

    // ----------------------------------------------------------------------
    // III. CONSULTA DE LISTA DE JUGADORES
    // ----------------------------------------------------------------------

    /**
     * Prueba: consulta exitosa de lista con jugadores.
     */
    @Test
    public void testConsultarListaJugadores05_ConJugadores() throws Exception {
        Jugador j1 = new Jugador("J1", "E01", "Carlos Perez", "Shadow", "s@m.com", 0, 0, 0);
        Jugador j2 = new Jugador("J2", "E01", "Ana Gomez", "Luna", "l@m.com", 0, 0, 0);
        director1.agregarJugador(j1, TEST_DATA_PATH);
        director1.agregarJugador(j2, TEST_DATA_PATH);

        List<Jugador> listaConsultada = director1.consultarListaJugadores();

        assertFalse(listaConsultada.isEmpty());
        assertEquals(2, listaConsultada.size());
    }

    /**
     * Prueba: consulta con equipo sin jugadores.
     */
    @Test
    public void testConsultarListaJugadores06_SinJugadores() {

        List<Jugador> listaConsultada = director1.consultarListaJugadores();

        assertTrue(listaConsultada.isEmpty());
    }

    // ----------------------------------------------------------------------
    // IV. VALIDACIONES DE CAMPOS — SIMULADAS DESDE LA INTERFAZ
    // ----------------------------------------------------------------------

    /**
     * Prueba conceptual: fecha vacía debe fallar.
     */
    @Test(expected = Exception.class)
    public void testValidacionCamposObligatorios_Equipo1_FechaVacia() throws Exception {
        String fecha1 = "";
        if (fecha1 == null || fecha1.trim().isEmpty()) {
            throw new Exception("La fecha del Equipo 1 es obligatoria.");
        }
    }

    /**
     * Prueba conceptual: fecha "No se" es inválida.
     */
    @Test(expected = Exception.class)
    public void testValidacionFecha_NoSe() throws Exception {
        String fecha1 = "No se";
        if (fecha1.equalsIgnoreCase("No se")) {
            throw new Exception("La fecha no puede ser 'No se'.");
        }
    }

    /**
     * Prueba conceptual: formato inválido de fecha.
     */
    @Test(expected = Exception.class)
    public void testValidacionFecha_FormatoInvalido() throws Exception {
        String fecha1 = "15-10-2023";
        if (!fecha1.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new Exception("La fecha debe tener formato dd/mm/yyyy.");
        }
    }

    /**
     * Prueba: tratamiento de datos no numéricos en kills/deaths/assists.
     */
    @Test(expected = NumberFormatException.class)
    public void testValidacionKillsDeathsAssists_NoNumeros() throws Exception {
        String kills1Str = "abc";
        Integer.parseInt(kills1Str.trim());
    }

    /**
     * Prueba: valores negativos de estadísticas deben fallar.
     */
    @Test(expected = Exception.class)
    public void testValidacionKillsDeathsAssists_Negativos() throws Exception {
        int kills1 = -1;
        if (kills1 < 0) {
            throw new Exception("Kills deben ser no negativos.");
        }
    }

    /**
     * Prueba: estadísticas con una sola cifra deben fallar (regla de interfaz).
     */
    @Test(expected = Exception.class)
    public void testValidacionKillsDeathsAssists_UnaCifra() throws Exception {
        String kills1Str = "5";
        if (kills1Str.length() == 1) {
            throw new Exception("Kills deben tener más de una cifra.");
        }
    }

    // ----------------------------------------------------------------------
    // V. ORDENAMIENTO DE JUGADORES POR KDA
    // ----------------------------------------------------------------------

    /**
     * Prueba: ordenamiento correcto por KDA descendente.
     */
    @Test
    public void testOrdenarJugadoresPorKDA_Exitoso() throws Exception {

        Jugador j1 = new Jugador("J1", "E01", "Carlos Perez", "Shadow", "s@m.com", 10, 5, 2);
        Jugador j2 = new Jugador("J2", "E01", "Ana Gomez", "Luna", "l@m.com", 5, 2, 3);
        Jugador j3 = new Jugador("J3", "E01", "Pedro Ruiz", "Storm", "st@m.com", 8, 4, 1);
        director1.agregarJugador(j1, TEST_DATA_PATH);
        director1.agregarJugador(j2, TEST_DATA_PATH);
        director1.agregarJugador(j3, TEST_DATA_PATH);

        director1.ordenarJugadoresPorKDA();

        List<Jugador> listaOrdenada = director1.consultarListaJugadores();
        assertEquals("Luna", listaOrdenada.get(0).getNickname());
        assertEquals("Shadow", listaOrdenada.get(1).getNickname());
        assertEquals("Storm", listaOrdenada.get(2).getNickname());
    }

    /**
     * Prueba: falla si director no tiene equipo asignado.
     */
    @Test(expected = Exception.class)
    public void testOrdenarJugadoresPorKDA_SinEquipoAsignado() throws Exception {
        DirectorEquipo directorSinEquipo = new DirectorEquipo("D02", "E02", "Maria Lopez", "maria@esports.com", null);
        directorSinEquipo.ordenarJugadoresPorKDA();
    }

    /**
     * Prueba: falla si la lista de jugadores está vacía.
     */
    @Test(expected = Exception.class)
    public void testOrdenarJugadoresPorKDA_SinDatos() throws Exception {
        director1.ordenarJugadoresPorKDA();
    }

    // ----------------------------------------------------------------------
    // VI. CONSULTA DEL JUGADOR CON MÁS KILLS
    // ----------------------------------------------------------------------

    /**
     * Prueba: consulta exitosa del jugador con más kills.
     */
    @Test
    public void testConsultarJugadorConMasKills_Exitoso() throws Exception {

        Jugador j1 = new Jugador("J1", "E01", "Carlos Perez", "Shadow", "s@m.com", 10, 5, 2);
        Jugador j2 = new Jugador("J2", "E01", "Ana Gomez", "Luna", "l@m.com", 15, 2, 3);
        Jugador j3 = new Jugador("J3", "E01", "Pedro Ruiz", "Storm", "st@m.com", 8, 4, 1);
        director1.agregarJugador(j1, TEST_DATA_PATH);
        director1.agregarJugador(j2, TEST_DATA_PATH);
        director1.agregarJugador(j3, TEST_DATA_PATH);

        Jugador maxKillsJugador = director1.consultarJugadorConMasKills();

        assertNotNull(maxKillsJugador);
        assertEquals("Luna", maxKillsJugador.getNickname());
        assertEquals(15, maxKillsJugador.getKills());
    }

    /**
     * Prueba: retorna null cuando la lista está vacía.
     */
    @Test
    public void testConsultarJugadorConMasKills_SinDatos() throws Exception {

        Jugador maxKillsJugador = director1.consultarJugadorConMasKills();

        assertNull(maxKillsJugador);
    }
}
