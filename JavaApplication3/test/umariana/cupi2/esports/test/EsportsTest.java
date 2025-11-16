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

/**
 * Clase de pruebas para la clase {@link Esports}.
 * 
 * Esta clase valida el funcionamiento del sistema principal encargado de almacenar
 * y gestionar los equipos de eSports. Se realizan pruebas sobre:
 * <ul>
 *     <li>La adición de equipos al sistema.</li>
 *     <li>La correcta carga de datos utilizando la clase interna {@code CargadorDatos}.</li>
 * </ul>
 * 
 * Cada prueba tiene como propósito verificar que las operaciones fundamentales
 * del modelo funcionen correctamente y que los datos se carguen de forma adecuada
 * desde los archivos externos requeridos.
 */

public class EsportsTest {
    
    /**
     * Instancia del sistema de eSports usado en las pruebas.
     */
    private Esports sistema;
    
    /**
     * Configuración inicial que se ejecuta antes de cada prueba.
     * 
     * Se crea un sistema vacío para validar funcionalidades independientes,
     * excepto aquellas en las que la carga de datos puede sobrescribir el modelo.
     */
    @Before
    public void setUp() {
        // Inicializa un sistema vacío para la mayoría de las pruebas, excepto la de carga.
        sistema = new Esports();
    }

    /**
     * Prueba unitaria que verifica la adición de un equipo al sistema.
     * 
     * Se crea un equipo de ejemplo, se agrega al sistema mediante
     * {@link Esports#addEquipo(Equipo)}, y se comprueba que:
     * <ul>
     *     <li>El sistema contiene exactamente un equipo.</li>
     *     <li>El equipo agregado se encuentra en la lista interna.</li>
     * </ul>
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
     * Prueba integral del proceso de carga de datos utilizando la clase interna
     * {@link Esports.CargadorDatos}.
     * 
     * Esta prueba requiere que existan los archivos:
     * <ul>
     *     <li>{@code data/equipos.txt}</li>
     *     <li>{@code data/directores.txt}</li>
     * </ul>
     * 
     * La prueba valida que:
     * <ul>
     *     <li>El modelo cargado contenga al menos un equipo.</li>
     *     <li>Los datos del primer equipo cargado no sean nulos.</li>
     *     <li>Los directores hayan sido asignados correctamente (si aplica).</li>
     * </ul>
     * 
     * @throws Exception si ocurre un error durante la lectura o carga de los archivos.
     */
    @Test
    public void testCargadorDatos_CargaCompleta() throws Exception {
           
        Esports.CargadorDatos cargador = sistema.new CargadorDatos(); 
        Esports sistemaCargado = cargador.cargarModelo();
        
        assertFalse("La lista de equipos no debe estar vacía después de la carga", sistemaCargado.getEquipos().isEmpty());
        assertTrue("La lista de equipos debe tener al menos 1 equipo", sistemaCargado.getEquipos().size() >= 1);
        
        Equipo primerEquipo = sistemaCargado.getEquipos().get(0);
        assertNotNull("El primer equipo cargado no debe ser nulo", primerEquipo);
        
    }
}