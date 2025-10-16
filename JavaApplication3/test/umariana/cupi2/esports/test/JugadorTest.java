package umariana.cupi2.esports.test;


import org.junit.Test;
import static org.junit.Assert.*;
import umariana.cupi2.esports.mundo.Jugador;

public class JugadorTest {

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
