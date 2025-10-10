package umariana.cup2.esports.test;

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

    @Before
    public void setUp() {

        equipo1 = new Equipo("E01", "Dark Warriors", new ArrayList<>(), "D01", new ArrayList<>());
        director1 = new DirectorEquipo("D01", "E01", "Luis Ramírez", "luis@esports.com", equipo1);

        equipo2 = new Equipo("E02", "Cyber Ninjas", new ArrayList<>(), "D02", new ArrayList<>());
    }

    @Test
    public void testRegistroJugador() throws Exception {
        Jugador jugador1 = new Jugador("01", "E01", "Carlos Pérez", "Shadow", "Shadow@mail.com", 0, 0, 0);
        director1.agregarJugador(jugador1);

        assertTrue(equipo1.existeJugadorConNickname("Shadow"));
    }

    // invalido nombre vacío
    @Test(expected = Exception.class)
    public void testRegistrarJugador02() throws Exception {
        Jugador jugador = new Jugador("02", "E01", "", "Zero", "zero@mail.com", 0, 0, 0);
        director1.agregarJugador(jugador);
    }

    // invalido por campos vacios
    @Test(expected = Exception.class)
    public void testRegistrarJugador03() throws Exception {
        Jugador jugador = new Jugador("03", "E01", "Carlos Pérez", "", "", 0, 0, 0);
        director1.agregarJugador(jugador);
    }

    // ----------------------------------------------------------------------
    // II. REGISTRO DE PARTIDAS
    // ----------------------------------------------------------------------
    @Test
    public void testRegistrarPartida_Exitoso() throws Exception {
        // Ejecución
        director1.registrarPartida(equipo2, 3, 1);

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
        director1.registrarPartida(equipo2, 2, 0);

        // Ejecución: Registrar una segunda partida
        director1.registrarPartida(equipo2, 1, 3);

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
        director1.registrarPartida(null, 3, 1);
    }

    // ----------------------------------------------------------------------
    // II. CONSULTA DE LISTA DE JUGADORES
    // ----------------------------------------------------------------------

    @Test
    public void testConsultarListaJugadores05_ConJugadores() throws Exception {
        // Preparación: Registrar jugadores
        Jugador j1 = new Jugador("J1", "E01", "Carlos Pérez", "Shadow", "s@m.com", 0, 0, 0);
        Jugador j2 = new Jugador("J2", "E01", "Ana Gómez", "Luna", "l@m.com", 0, 0, 0);
        director1.agregarJugador(j1);
        director1.agregarJugador(j2);

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
}
