package umariana.cupi2.esports.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import umariana.cupi2.esports.mundo.Equipo;
import umariana.cupi2.esports.mundo.Partida;
import java.util.ArrayList;

/**
 * Clase de pruebas para la clase {@link Equipo}.
 * 
 * Se validan los métodos relacionados con el cálculo de promedios de
 * victorias y derrotas, evaluando diferentes escenarios:
 *  - Equipos sin partidas registradas.
 *  - Equipos con partidas donde hay victorias, derrotas o empates.
 *  - Casos donde las partidas están registradas en ambos equipos.
 * 
 * Cada prueba verifica que los métodos retornen el valor esperado
 * según los datos ingresados.
 */
public class EquipoTest {

    /**
     * Prueba que verifica el cálculo del promedio de victorias cuando el equipo
     * tiene una mezcla de victorias, empates y derrotas.
     * 
     * Se crean tres partidas:
     *  - 1 victoria
     *  - 1 empate
     *  - 1 derrota
     * 
     * Se espera un promedio de victorias de 1/3 = 0.333.
     */
    @Test
    public void testPromedioVictorias() {
        // Crear equipos
        Equipo equipo1 = new Equipo("E1", "Equipo1", new ArrayList<>(), "D1", new ArrayList<>());
        Equipo equipo2 = new Equipo("E2", "Equipo2", new ArrayList<>(), "D2", new ArrayList<>());

        // Crear partidas: 2 victorias, 1 derrota
        Partida p1 = new Partida("P1", equipo1, equipo2, 3, 1); // Victoria para equipo1
        Partida p2 = new Partida("P2", equipo1, equipo2, 2, 2); // Empate
        Partida p3 = new Partida("P3", equipo2, equipo1, 4, 0); // Derrota para equipo1

        equipo1.addPartida(p1);
        equipo1.addPartida(p2);
        equipo1.addPartida(p3);

        double promedio = equipo1.promedioVictorias();
        assertEquals(0.333, promedio, 0.001); // 1 victoria / 3 partidas
    }

    /**
     * Prueba que verifica el cálculo del promedio de derrotas cuando el equipo
     * ha ganado una partida y perdido dos.
     * 
     * Se espera un promedio de derrotas de 2/3 = 0.667.
     */
    @Test
    public void testPromedioDerrotas() {
        // Crear equipos
        Equipo equipo1 = new Equipo("E1", "Equipo1", new ArrayList<>(), "D1", new ArrayList<>());
        Equipo equipo2 = new Equipo("E2", "Equipo2", new ArrayList<>(), "D2", new ArrayList<>());

        // Crear partidas: 1 victoria, 2 derrotas
        Partida p1 = new Partida("P1", equipo1, equipo2, 3, 1); // Victoria para equipo1
        Partida p2 = new Partida("P2", equipo2, equipo1, 4, 0); // Derrota para equipo1
        Partida p3 = new Partida("P3", equipo2, equipo1, 2, 1); // Derrota para equipo1

        equipo1.addPartida(p1);
        equipo1.addPartida(p2);
        equipo1.addPartida(p3);

        double promedio = equipo1.promedioDerrotas();
        assertEquals(0.667, promedio, 0.001); // 2 derrotas / 3 partidas
    }

    /**
     * Prueba que valida que el promedio de victorias sea 0 cuando el equipo no
     * tiene partidas registradas.
     */
    @Test
    public void testPromedioVictoriasSinPartidas() {
        Equipo equipo = new Equipo("E1", "Equipo1", new ArrayList<>(), "D1", new ArrayList<>());
        double promedio = equipo.promedioVictorias();
        assertEquals(0.0, promedio, 0.001);
    }

    /**
     * Prueba que valida que el promedio de derrotas sea 0 cuando el equipo no
     * tiene partidas registradas.
     */
    @Test
    public void testPromedioDerrotasSinPartidas() {
        Equipo equipo = new Equipo("E1", "Equipo1", new ArrayList<>(), "D1", new ArrayList<>());
        double promedio = equipo.promedioDerrotas();
        assertEquals(0.0, promedio, 0.001);
    }

    /**
     * Prueba que verifica el cálculo del promedio de victorias cuando las partidas
     * están registradas tanto en el equipo 1 como en el equipo 2.
     * 
     * Se verifica que esto no afecte el cálculo y el método retorne 1/3 = 0.333.
     */
    @Test
    public void testPromedioVictoriasConPartidasAmbosEquipos() {
        // Crear equipos
        Equipo equipo1 = new Equipo("E1", "Equipo1", new ArrayList<>(), "D1", new ArrayList<>());
        Equipo equipo2 = new Equipo("E2", "Equipo2", new ArrayList<>(), "D2", new ArrayList<>());

        // Crear partidas: equipo1 gana 2, pierde 1
        Partida p1 = new Partida("P1", equipo1, equipo2, 3, 1); // Victoria para equipo1
        Partida p2 = new Partida("P2", equipo1, equipo2, 2, 2); // Empate
        Partida p3 = new Partida("P3", equipo2, equipo1, 4, 0); // Derrota para equipo1

        // Añadir a ambos equipos
        equipo1.addPartida(p1);
        equipo1.addPartida(p2);
        equipo1.addPartida(p3);
        equipo2.addPartida(p1);
        equipo2.addPartida(p2);
        equipo2.addPartida(p3);

        double promedio = equipo1.promedioVictorias();
        assertEquals(0.333, promedio, 0.001); // 1 victoria / 3 partidas
    }

    /**
     * Prueba que verifica el cálculo del promedio de derrotas cuando las partidas
     * están registradas tanto en el equipo 1 como en el equipo 2.
     * 
     * Se valida que el promedio de derrotas sea 2/3 = 0.667.
     */
    @Test
    public void testPromedioDerrotasConPartidasAmbosEquipos() {
        // Crear equipos
        Equipo equipo1 = new Equipo("E1", "Equipo1", new ArrayList<>(), "D1", new ArrayList<>());
        Equipo equipo2 = new Equipo("E2", "Equipo2", new ArrayList<>(), "D2", new ArrayList<>());

        // Crear partidas: equipo1 gana 1, pierde 2
        Partida p1 = new Partida("P1", equipo1, equipo2, 3, 1); // Victoria para equipo1
        Partida p2 = new Partida("P2", equipo2, equipo1, 4, 0); // Derrota para equipo1
        Partida p3 = new Partida("P3", equipo2, equipo1, 2, 1); // Derrota para equipo1

        // Añadir a ambos equipos
        equipo1.addPartida(p1);
        equipo1.addPartida(p2);
        equipo1.addPartida(p3);
        equipo2.addPartida(p1);
        equipo2.addPartida(p2);
        equipo2.addPartida(p3);

        double promedio = equipo1.promedioDerrotas();
        assertEquals(0.667, promedio, 0.001); // 2 derrotas / 3 partidas
    }
}
