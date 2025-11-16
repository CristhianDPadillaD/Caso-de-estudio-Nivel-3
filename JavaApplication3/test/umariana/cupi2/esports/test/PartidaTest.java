/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umariana.cupi2.esports.test;


import umariana.cupi2.esports.mundo.Partida;
import umariana.cupi2.esports.mundo.Equipo;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase de prueba para la clase {@link Partida}.
 * 
 * Esta clase valida el correcto funcionamiento del cálculo del ganador en los 
 * diferentes escenarios posibles dentro de una partida entre dos equipos.
 * 
 * Se evalúan los siguientes casos:
 * <ul>
 *     <li>Cuando el equipo 1 (equipoA) obtiene una puntuación mayor.</li>
 *     <li>Cuando el equipo 2 (equipoB) obtiene una puntuación mayor.</li>
 *     <li>Cuando ambos equipos empatan en puntuación.</li>
 * </ul>
 */
public class PartidaTest {

    
    private final Equipo equipoA = new Equipo("E01", "Furia", new ArrayList<>(), "D01", new ArrayList<>());
    private final Equipo equipoB = new Equipo("E02", "Templarios", new ArrayList<>(), "D02", new ArrayList<>());

    /**
     * Prueba el cálculo del ganador cuando el Equipo 1 gana la partida.
     *
     * Se utiliza una partida con marcador 3-1 a favor del equipoA (Furia).
     * El método {@link Partida#getGanador()} debe devolver correctamente 
     * el equipo con mayor puntuación.
     */
    @Test
    public void testCalcularGanador_Equipo1Gana() {
        
        
        Partida partida = new Partida("P01", equipoA, equipoB, 3, 1);
        
        
        assertEquals("El ganador debe ser el nombre del Equipo 1 (Furia)", equipoA.getNombre(), partida.getGanador().getNombre());
        assertTrue("La diferencia de puntuación debe ser correcta", partida.getPuntuacionEquipo1() > partida.getPuntuacionEquipo2());
    }

    /**
     * Prueba el cálculo del ganador cuando el Equipo 2 gana la partida.
     *
     * Se utiliza una partida con marcador 8-10 a favor del equipoB (Templarios).
     * El método {@link Partida#getGanador()} debe identificar al equipoB 
     * como el equipo ganador.
     */
    @Test
    public void testCalcularGanador_Equipo2Gana() {
        
        Partida partida = new Partida("P02", equipoA, equipoB, 8, 10);
        
        
        assertEquals("El ganador debe ser el nombre del Equipo 2 (Templarios)", equipoB.getNombre(), partida.getGanador().getNombre());
    }

    /**
     * Prueba el cálculo del ganador cuando la partida termina en empate.
     *
     * Con una puntuación 2-2, no debe asignarse un equipo ganador.
     * El método {@link Partida#getGanador()} debe retornar {@code null}.
     */
    @Test
    public void testCalcularGanador_Empate() {
       
        Partida partida = new Partida("P03", equipoA, equipoB, 2, 2);

        
        assertNull("En caso de empate, el ganador debe ser null", partida.getGanador());
    }
}