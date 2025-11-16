package umariana.cupi2.esports.test;


import org.junit.Test;
import static org.junit.Assert.*;
import umariana.cupi2.esports.mundo.Jugador;

/**
 * Clase de pruebas para la clase {@link Jugador}.
 *
 * Esta clase valida el correcto funcionamiento del método encargado de calcular
 * el indicador KDA (Kills / Deaths / Assists) de un jugador. 
 *
 * Se verifican distintos escenarios para asegurar que:
 * <ul>
 *     <li>El cálculo sea correcto cuando hay muertes.</li>
 *     <li>El cálculo se ajuste cuando las muertes son cero (evitando división por cero).</li>
 *     <li>El cálculo sea consistente en casos donde las muertes son altas.</li>
 * </ul>
 */
public class JugadorTest {

    /**
     * Prueba el cálculo del KDA cuando el jugador tiene un número válido de muertes (> 0).
     *
     * Se utiliza un jugador con:
     * <ul>
     *     <li>10 asesinatos</li>
     *     <li>2 muertes</li>
     *     <li>5 asistencias</li>
     * </ul>
     * 
     * El KDA esperado es: (asesinatos + asistencias) / muertes = 15 / 2 = 7.5.
     */
    @Test
    public void testGetKDA() {
        // Scenario 2: KDA Calculation with Deaths > 0
        // Given a player has kills=10, deaths=2, assists=5
        Jugador jugador = new Jugador("J1", "E1", "Nombre", "Nickname", "correo@example.com", 10, 2, 5);
        // When the KDA is calculated
        double kda = jugador.getKDA();
        // Then the KDA should be 7.5 (15 / 2)
        assertEquals(7.5, kda, 0.001);
    }

    /**
     * Prueba el cálculo del KDA cuando el jugador tiene cero muertes.
     *
     * En este caso, el método debe evitar la división por cero y considerar las muertes como 1
     * para efectos del cálculo.
     *
     * Se utiliza un jugador con:
     * <ul>
     *     <li>5 asesinatos</li>
     *     <li>0 muertes</li>
     *     <li>3 asistencias</li>
     * </ul>
     * 
     * El KDA esperado es: (asesinatos + asistencias) / 1 = 8 / 1 = 8.0.
     */
    @Test
    public void testGetKDAWithZeroDeaths() {
        // Scenario 3: KDA Calculation with Deaths = 0
        // Given a player has kills=5, deaths=0, assists=3
        Jugador jugador = new Jugador("J1", "E1", "Nombre", "Nickname", "correo@example.com", 5, 0, 3);
        // When the KDA is calculated
        double kda = jugador.getKDA();
        // Then the KDA should be 8.0 (8 / 1)
        assertEquals(8.0, kda, 0.001);
    }

    /**
     * Prueba el cálculo del KDA cuando el jugador presenta un número alto de muertes.
     *
     * Se utiliza un jugador con:
     * <ul>
     *     <li>2 asesinatos</li>
     *     <li>10 muertes</li>
     *     <li>1 asistencia</li>
     * </ul>
     *
     * El KDA esperado es: (asesinatos + asistencias) / muertes = 3 / 10 = 0.3.
     */
    @Test
    public void testGetKDAWithHighDeaths() {
        // Scenario 4: KDA Calculation with High Deaths
        // Given a player has kills=2, deaths=10, assists=1
        Jugador jugador = new Jugador("J1", "E1", "Nombre", "Nickname", "correo@example.com", 2, 10, 1);
        // When the KDA is calculated
        double kda = jugador.getKDA();
        // Then the KDA should be 0.3 (3 / 10)
        assertEquals(0.3, kda, 0.001);
    }
}
