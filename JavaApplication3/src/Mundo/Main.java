// Archivo: Mundo/Main.java o Interfaz/Main.java
package Mundo; // o el paquete que uses

import Interfaz.RegistroJugadorUI;
import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crear modelo
            Equipo equipo = new Equipo("E01", "Dark Warriors", new ArrayList<>(), "E01");
            DirectorEquipo director = new DirectorEquipo("D01","E01","Luis Ramírez","luis@esports.com", equipo);

            // Crear UI inyectando el director
            RegistroJugadorUI ui = new RegistroJugadorUI( director);
            ui.setVisible(true);
        });
    }
}
