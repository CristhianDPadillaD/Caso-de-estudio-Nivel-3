/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umariana.cupi2.esports.mundo;

import java.util.List;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import umariana.cupi2.esports.interfaz.RegistroJugadorUI;


public class Esports {
    
    private List<Equipo> equipos;

    public Esports() {
        this.equipos = new ArrayList <>();
    }
    
    
        public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crear modelo
            Equipo equipo = new Equipo("E01", "Dark Warriors", new ArrayList<>(), "D01");
            DirectorEquipo director = new DirectorEquipo("D01","E01","Luis Ramírez","luis@esports.com", equipo);

            // Crear UI inyectando el director
            RegistroJugadorUI ui = new RegistroJugadorUI( director);
            ui.setVisible(true);
        });
    }
    
}
