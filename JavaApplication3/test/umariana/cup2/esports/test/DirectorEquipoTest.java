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
    public void setUp(){
        equipo1 = new Equipo("E01", "Dark Warriors", new ArrayList<>() , "E01", new ArrayList<>());
        director1 = new DirectorEquipo("D01", "E01", "Luis Ramírez", "luis@esports.com", equipo1);
         equipo1 = new Equipo("E01", "Dark Warriors", new ArrayList<>(), "D01", new ArrayList<>());
        equipo2 = new Equipo("E02", "Cyber Ninjas", new ArrayList<>(), "D02", new ArrayList<>());
    }
    
    @Test
    public void testRegistroJugador() throws Exception {
                Jugador jugador1 = new Jugador("01", "E01", "Carlos Pérez", "Shadow", "Shadow@mail.com",0,0,0);
        director1.agregarJugador(jugador1);

        assertTrue(equipo1.existeJugadorConNickname("Shadow"));
    }
    // invalido nombre vacío
    @Test(expected = Exception.class)
    public void testRegistrarJugador02() throws Exception {
        Jugador jugador = new Jugador("02", "E01", "", "Zero","zero@mail.com",0,0,0);
        director1.agregarJugador(jugador);
    }
    
    //invalido por campos vacios
 @Test(expected = Exception.class)
    public void testRegistrarJugador03() throws Exception {
        Jugador jugador = new Jugador("03", "E01", "Carlos Pérez", "","",0,0,0);
        director1.agregarJugador(jugador);
    }
    
    
    // ----------------------------------------------------------------------
    // II. REGISTRO DE PARTIDAS
    //  ----------------------------------------------------------------------
      @Test
    public void testRegistrarPartida_Exitoso() throws Exception {
        // Ejecución
        director1.registrarPartida("P_TEST_01", equipo2, 3, 1);

        // Verificación (Criterio 2: Guardar los resultados en el sistema)
        List<Partida> historial = equipo1.getPartidas();
        
        assertEquals("El historial del equipo debe tener 1 partida", 1, historial.size());
        assertEquals("La partida debe ser la registrada", "P_TEST_01", historial.get(0).getIdPartida());
        assertEquals("El ganador debe ser el equipo propio (Dark Warriors)", equipo1.getNombre(), historial.get(0).getGanador());
    }

    /**
     * Prueba el registro fallido por omisión de ID de partida (Criterio 3).
     */
    @Test(expected = Exception.class)
    public void testRegistrarPartida_FaltaID() throws Exception {
        // Se omite el ID de partida (se envía null o vacío)
        director1.registrarPartida(null, equipo2, 5, 0); 
    }
    
    /**
     * Prueba el registro fallido por puntuación negativa.
     */
    @Test(expected = Exception.class)
    public void testRegistrarPartida_PuntuacionNegativa() throws Exception {
        // Se omite el ID de partida (se envía null o vacío)
        director1.registrarPartida("P_TEST_03", equipo2, -1, 5); 
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
