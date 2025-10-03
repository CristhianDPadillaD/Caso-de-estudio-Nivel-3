/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umariana.cupi2.esports.mundo;

import java.util.ArrayList;
import javax.swing.SwingUtilities;
import umariana.cupi2.esports.interfaz.Esports_UI;


public class Esports {

    private ArrayList<Equipo> equipos;

    public Esports() {
        this.equipos = new ArrayList<>();
    }

   public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        ArrayList<Equipo> listaEquipos = new ArrayList<>();

        listaEquipos.add(new Equipo("E01", "Dark Warriors", new ArrayList<>(), "D01"));
        listaEquipos.add(new Equipo("E02", "Cyber Ninjas", new ArrayList<>(), "D02"));
        listaEquipos.add(new Equipo("E03", "Pixel Masters", new ArrayList<>(), "D03"));

        DirectorEquipo director = new DirectorEquipo(
            "D01",
            "E01",
            "Luis Ramírez",
            "luis@esports.com",
            listaEquipos.get(0)  // por defecto el primer equipo
        );

        // Ahora pasamos la lista completa
        Esports_UI ui = new Esports_UI(director, listaEquipos);
        ui.setVisible(true);
    });
}}
