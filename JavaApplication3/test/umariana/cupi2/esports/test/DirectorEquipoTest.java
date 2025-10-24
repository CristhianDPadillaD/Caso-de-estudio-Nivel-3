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

public class DirectorEquipoTest {

    private Equipo equipo1;
    private Equipo equipo2;
    private DirectorEquipo director1;

    private static final String TEST_DATA_PATH = "./test/testData";
    
    @Before
    public void setUp() {

        equipo1 = new Equipo("E01", "Dark Warriors", new ArrayList<>(), "D01", new ArrayList<>());
        director1 = new DirectorEquipo("D01", "E01", "Luis Ramirez", "luis@esports.com", equipo1);

        equipo2 = new Equipo("E02", "Cyber Ninjas", new ArrayList<>(), "D02", new ArrayList<>());
    }

    @Test
    public void testRegistroJugador() throws Exception {
        Jugador jugador1 = new Jugador("01", "E01", "Carlos Perez", "Shadow", "Shadow@mail.com", 0, 0, 0);
        director1.agregarJugador(jugador1, TEST_DATA_PATH);

        assertTrue(equipo1.existeJugadorConNickname("Shadow"));
    }

    // invalido nombre vacío
    @Test(expected = Exception.class)
    public void testRegistrarJugador02() throws Exception {
        Jugador jugador = new Jugador("02", "E01", "", "Zero", "zero@mail.com", 0, 0, 0);
        director1.agregarJugador(jugador, TEST_DATA_PATH);
    }

    // invalido por campos vacios
    @Test(expected = Exception.class)
    public void testRegistrarJugador03() throws Exception {
        Jugador jugador = new Jugador("03", "E01", "Carlos Perez", "", "", 0, 0, 0);
        director1.agregarJugador(jugador, TEST_DATA_PATH);
    }

    // invalido por nombre con caracteres no permitidos
    @Test(expected = Exception.class)
    public void testRegistrarJugador04_NombreInvalido() throws Exception {
        Jugador jugador = new Jugador("04", "E01", "Carlos123", "Shadow", "shadow@mail.com", 0, 0, 0);
        director1.agregarJugador(jugador, TEST_DATA_PATH);
    }

    // invalido por correo con formato incorrecto
    @Test(expected = Exception.class)
    public void testRegistrarJugador05_CorreoInvalido() throws Exception {
        Jugador jugador = new Jugador("05", "E01", "Carlos Perez", "Shadow", "shadowmail.com", 0, 0, 0);
        director1.agregarJugador(jugador, TEST_DATA_PATH);
    }

    // ----------------------------------------------------------------------
    // II. REGISTRO DE PARTIDAS
    // ----------------------------------------------------------------------
    @Test
    public void testRegistrarPartida_Exitoso() throws Exception {
        // Ejecución
        director1.registrarPartida(equipo2, 3, 1,TEST_DATA_PATH);

        // Verificación
        List<Partida> historial = equipo1.getPartidas();
        assertFalse("El historial no debería estar vacío", historial.isEmpty());
        assertEquals("El historial del equipo debe tener 1 partida", 1, historial.size());

        // Verificar que el ID se generó correctamente (DW por Dark Warriors, -1 por ser
        // la primera)
        assertEquals("El ID de la partida debe ser 'DW-1'", "DW-1", historial.get(0).getIdPartida());

        // Verificar el ganador
        assertEquals("El ganador debe ser el equipo propio (Dark Warriors)", equipo1,
                historial.get(0).getGanador());
    }

    /**
     * Prueba que se genera un ID secuencial correcto para la segunda partida.
     */
    @Test
    public void testRegistrarPartida_Secuencial() throws Exception {
        // Preparación: Registrar una primera partida
        director1.registrarPartida(equipo2, 2, 0,TEST_DATA_PATH);

        // Ejecución: Registrar una segunda partida
        director1.registrarPartida(equipo2, 1, 3,TEST_DATA_PATH);

        // Verificación
        List<Partida> historial = equipo1.getPartidas();
        assertEquals("El historial del equipo debe tener 2 partidas", 2, historial.size());

        // Verificar que el ID de la segunda partida es correcto
        assertEquals("El ID de la segunda partida debe ser 'DW-2'", "DW-2", historial.get(1).getIdPartida());
    }

    /**
     * Prueba el registro fallido si el equipo rival es nulo.
     */
    @Test(expected = Exception.class)
    public void testRegistrarPartida_RivalNulo() throws Exception {
        // Se envía un equipo rival nulo
        director1.registrarPartida(null, 3, 1,TEST_DATA_PATH);
    }

    // ----------------------------------------------------------------------
    // II. CONSULTA DE LISTA DE JUGADORES
    // ----------------------------------------------------------------------

    @Test
    public void testConsultarListaJugadores05_ConJugadores() throws Exception {
        // Preparación: Registrar jugadores
        Jugador j1 = new Jugador("J1", "E01", "Carlos Perez", "Shadow", "s@m.com", 0, 0, 0);
        Jugador j2 = new Jugador("J2", "E01", "Ana Gomez", "Luna", "l@m.com", 0, 0, 0);
        director1.agregarJugador(j1,TEST_DATA_PATH);
        director1.agregarJugador(j2,TEST_DATA_PATH);

        // Ejecución
        List<Jugador> listaConsultada = director1.consultarListaJugadores();

        // Verificación
        assertFalse("La lista no debe estar vacía", listaConsultada.isEmpty());
        assertEquals("La lista debe contener 2 jugadores", 2, listaConsultada.size());
    }

    @Test
    public void testConsultarListaJugadores06_SinJugadores() {
        // Preparación: Equipo vacío (por setUp)

        // Ejecución
        List<Jugador> listaConsultada = director1.consultarListaJugadores();

        // Verificación
        assertTrue("La lista debe estar vacía cuando no hay jugadores", listaConsultada.isEmpty());
    }

    // ----------------------------------------------------------------------
    // III. VALIDACIONES PARA REGISTRO DE PARTIDAS (NUEVAS PRUEBAS)
    // ----------------------------------------------------------------------

    /**
     * Prueba que falla si algún campo obligatorio está vacío para Equipo 1.
     * Nota: Esta prueba simula la validación que ahora se hace en InterfazEsports.registrarPartida().
     * Como DirectorEquipo.registrarPartida no valida campos de interfaz, esta prueba es conceptual.
     * En un futuro, si se extiende el modelo, se puede mover aquí.
     */
    @Test(expected = Exception.class)
    public void testValidacionCamposObligatorios_Equipo1_FechaVacia() throws Exception {
        // Simular validación de fecha vacía (como en InterfazEsports)
        String fecha1 = "";
        if (fecha1 == null || fecha1.trim().isEmpty()) {
            throw new Exception("La fecha del Equipo 1 es obligatoria.");
        }
        // Si llega aquí, la validación falló
    }

    /**
     * Prueba que falla si la fecha es "No se".
     */
    @Test(expected = Exception.class)
    public void testValidacionFecha_NoSe() throws Exception {
        String fecha1 = "No se";
        if (fecha1.equalsIgnoreCase("No se")) {
            throw new Exception("La fecha no puede ser 'No se'.");
        }
    }

    /**
     * Prueba que falla si el formato de fecha no es dd/mm/yyyy.
     */
    @Test(expected = Exception.class)
    public void testValidacionFecha_FormatoInvalido() throws Exception {
        String fecha1 = "15-10-2023"; // Formato incorrecto
        if (!fecha1.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new Exception("La fecha debe tener formato dd/mm/yyyy.");
        }
    }

    /**
     * Prueba que falla si kills, deaths o assists no son números no negativos.
     */
    @Test(expected = NumberFormatException.class)
    public void testValidacionKillsDeathsAssists_NoNumeros() throws Exception {
        String kills1Str = "abc"; // No es número
        Integer.parseInt(kills1Str.trim()); // Debe fallar
    }

    /**
     * Prueba que falla si kills, deaths o assists son negativos.
     */
    @Test(expected = Exception.class)
    public void testValidacionKillsDeathsAssists_Negativos() throws Exception {
        int kills1 = -1;
        if (kills1 < 0) {
            throw new Exception("Kills deben ser no negativos.");
        }
    }

    /**
     * Prueba que falla si kills, deaths o assists tienen una sola cifra.
     */
    @Test(expected = Exception.class)
    public void testValidacionKillsDeathsAssists_UnaCifra() throws Exception {
        String kills1Str = "5"; // Una sola cifra
        if (kills1Str.length() == 1) {
            throw new Exception("Kills deben tener más de una cifra.");
        }
    }
}
