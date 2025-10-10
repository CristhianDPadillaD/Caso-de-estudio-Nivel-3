/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umariana.cupi2.esports.test;


import java.util.ArrayList;
import umariana.cupi2.esports.mundo.Esports;
import umariana.cupi2.esports.mundo.Equipo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EsportsTest {
    
    private Esports sistema;
    
    @Before
    public void setUp() {
        // Inicializa un sistema vacío para la mayoría de las pruebas, excepto la de carga.
        sistema = new Esports();
    }

    /**
     * Prueba la adición simple de un equipo al sistema.
     */
    @Test
    public void testAddEquipo() {
        // Preparación
        Equipo equipo1 = new Equipo("E01", "Dark Warriors", new ArrayList<>(), "D01", new ArrayList<>());
        
        // Ejecución
        sistema.addEquipo(equipo1);
        
        // Verificación
        assertEquals("El sistema debe tener un equipo", 1, sistema.getEquipos().size());
        assertTrue("El equipo Dark Warriors debe estar en la lista", sistema.getEquipos().contains(equipo1));
    }
    
    /**
     * Prueba la funcionalidad completa de la clase CargadorDatos.
     * REQUIERE los archivos 'equipos.txt' y 'directores.txt' en la ruta 'data/'.
     */
    @Test
    public void testCargadorDatos_CargaCompleta() throws Exception {
        // Ejecución: Crea una instancia del cargador (que está anidada)
        Esports.CargadorDatos cargador = sistema.new CargadorDatos(); 
        Esports sistemaCargado = cargador.cargarModelo();
        
        // Verificación
        // Asumiendo que 'equipos.txt' tiene al menos 1 línea
        assertFalse("La lista de equipos no debe estar vacía después de la carga", sistemaCargado.getEquipos().isEmpty());
        assertTrue("La lista de equipos debe tener al menos 1 equipo", sistemaCargado.getEquipos().size() >= 1);
        
        // Verificación de datos del equipo (ejemplo)
        Equipo primerEquipo = sistemaCargado.getEquipos().get(0);
        assertNotNull("El primer equipo cargado no debe ser nulo", primerEquipo);
        
        // Verificación de la asignación del Director (asumiendo que el Director se crea)
        // Nota: Para verificar el Director, necesitarías que Equipo.setDirector(Director) esté implementado
        // y que accedas al Director del equipo.
    }
}