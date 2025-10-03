/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umariana.cup2.esports.test;


import umariana.cupi2.esports.mundo.Partida;
import umariana.cupi2.esports.mundo.Equipo;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class PartidaTest {

    // Equipos de prueba (solo necesitamos el nombre para el cálculo del ganador)
    private final Equipo equipoA = new Equipo("E01", "Furia", new ArrayList<>(), "D01", new ArrayList<>());
    private final Equipo equipoB = new Equipo("E02", "Templarios", new ArrayList<>(), "D02", new ArrayList<>());

    /**
     * Prueba el cálculo del ganador cuando el Equipo 1 gana.
     */
    @Test
    public void testCalcularGanador_Equipo1Gana() {
        
        // Puntuación: 3-1 a favor de Furia (Equipo A)
        Partida partida = new Partida("P01", equipoA, equipoB, 3, 1);
        
        // El ganador calculado debe ser el nombre del Equipo A
        assertEquals("El ganador debe ser el nombre del Equipo 1 (Furia)", equipoA.getNombre(), partida.getGanador());
        assertTrue("La diferencia de puntuación debe ser correcta", partida.getPuntuacionEquipo1() > partida.getPuntuacionEquipo2());
    }

    /**
     * Prueba el cálculo del ganador cuando el Equipo 2 gana.
     */
    @Test
    public void testCalcularGanador_Equipo2Gana() {
        // Puntuación: 8-10 a favor de Templarios (Equipo B)
        Partida partida = new Partida("P02", equipoA, equipoB, 8, 10);
        
        // El ganador calculado debe ser el nombre del Equipo B
        assertEquals("El ganador debe ser el nombre del Equipo 2 (Templarios)", equipoB.getNombre(), partida.getGanador());
    }

    /**
     * Prueba el cálculo del ganador en caso de empate.
     */
    @Test
    public void testCalcularGanador_Empate() {
        // Puntuación: 2-2 (Empate)
        Partida partida = new Partida("P03", equipoA, equipoB, 2, 2);
        
        // El ganador calculado debe ser "Empate"
        assertEquals("El resultado debe ser 'Empate'", "Empate", partida.getGanador());
    }
}