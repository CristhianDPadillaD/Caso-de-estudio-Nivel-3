# TODO: Update Panels and Connections

## Overview

Update the specified panels (PanelRegistroJugadores, PanelRegistroPartidas, PanelConsultarJugadores, PanelNavBar) to load teams into comboboxes from data/equipos.txt, connect buttons to logic in InterfazEsports.java, and ensure functionality. Keep all logic in InterfazEsports.java, do not create new classes or files.

## Steps

1. **Edit PanelRegistroJugadores.java** ✅

   - Add code in constructor to load teams into 'equipo' combobox using esports.getEquipos(). ✅
   - Add action listener to 'registrarButton' to call ventana.registrarJugador() with field values (nombreCompleto.getText(), nickname.getText(), correo.getText(), equipo.getSelectedItem().toString()). ✅

2. **Edit PanelRegistroPartidas.java** ✅

   - Add code in constructor to load teams into 'equipo', 'equipo2', 'rival', 'rival2' comboboxes using esports.getEquipos(). ✅
   - Add action listener to 'jButton1' to call ventana.registrarPartida() – note: registrarPartida() already exists and uses panel methods to get values. ✅

3. **Edit PanelConsultarJugadores.java** ✅

   - Add code in constructor to load teams into 'equipo' combobox using esports.getEquipos(). ✅
   - Add action listener to 'verKDA' to call ventana.consultarKDA(equipo.getSelectedItem().toString()) and update listaJugadores with results. ✅
   - Add action listener to 'verPromedioVictorias' to call ventana.consultarPromedioVictorias(equipo.getSelectedItem().toString()) and show result in JOptionPane or update listaJugadores. ✅
   - Add action listener to 'verPromedioDerrotas' to call ventana.consultarPromedioDerrotas(equipo.getSelectedItem().toString()) and show result in JOptionPane. ✅
   - Add action listener to 'verJugadorMasKills' to call ventana.consultarJugadorMasKills(equipo.getSelectedItem().toString()) and update listaJugadores with result. ✅

4. **Edit InterfazEsports.java** ✅

   - Add method consultarKDA(String nombreEquipo): Get team, list players with KDA. ✅
   - Add method consultarPromedioVictorias(String nombreEquipo): Calculate and return average wins. ✅
   - Add method consultarPromedioDerrotas(String nombreEquipo): Calculate and return average losses. ✅
   - Add method consultarJugadorMasKills(String nombreEquipo): Find player with most kills. ✅
   - Ensure inicializarPaneles() calls methods to load comboboxes if needed, but since panels have esports, load in constructors. ✅ Fixed card layout names.

5. **Test Connections** ✅
   - Run the application and verify comboboxes load teams, buttons trigger correct actions, and results display properly. ✅
