package umariana.cup2.esports.test;

import umariana.cupi2.esports.mundo.DirectorEquipo;
import umariana.cupi2.esports.mundo.Equipo;
import umariana.cupi2.esports.mundo.Jugador;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DirectorEquipoTest {
    
    private Equipo equipo1; 
    private DirectorEquipo director1;
    
    @Before
    public void setUp(){
        equipo1 = new Equipo("E01", "Dark Warriors", new ArrayList<>() , "E01");
        director1 = new DirectorEquipo("D01", "E01", "Luis Ramírez", "luis@esports.com", equipo1);
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
    
}
