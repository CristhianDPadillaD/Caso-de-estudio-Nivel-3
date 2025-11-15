# TODO: Implement User Story EA-8: Consulta del jugador con más kills

## Steps to Complete

- [x] Add consultarJugadorConMasKills() method in DirectorEquipo.java to find the player with the most kills in the assigned team
- [x] Add mostrarJugadorConMasKills() method in InterfazEsports.java to handle the UI logic, get selected team, assign to director, call the method, and show JOptionPane with the result or "No hay datos disponibles para mostrar" if no players or no kills
- [x] Add "Ver Jugador con Más Kills" button in PanelConsulta.java that calls principal.mostrarJugadorConMasKills()
- [x] Add unit tests in DirectorEquipoTest.java for consultarJugadorConMasKills() covering successful query (CID 2), no data (CID 3)
- [ ] Compile the project and run the unit tests to verify the implementation (to be done in NetBeans)
- [ ] Test the UI by running the application and accessing the team statistics section to ensure the button and message display work correctly (to be done in NetBeans)
