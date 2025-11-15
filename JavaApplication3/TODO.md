# TODO: Implementar registro y validación de KDA en formato "kills/deaths/assists"

## Información Recopilada

- El campo KDA en PanelRegistroJugadores es un JTextField con placeholder "kda".
- El formato esperado es "kills/deaths/assists" (ej. "5/2/3").
- Actualmente, los jugadores se crean con KDA 0/0/0 y no se guarda en persistencia.
- La persistencia de jugadores está en archivos "jugadores [Equipo].txt" con formato: idJugador,idEquipo,nombre,nickname,correo
- La carga de datos inicializa KDA en 0/0/0.

## Plan de Implementación

1. Modificar PanelRegistroJugadores.registrarJugador para obtener el valor del campo KDA.
2. Modificar InterfazEsports.registrarJugador para recibir el KDA, validarlo (formato y valores >=0), y pasarlo al DirectorEquipo.
3. Modificar DirectorEquipo.agregarJugador para recibir kills, deaths, assists, y guardarlos en el Jugador y en la persistencia.
4. Actualizar el formato de persistencia de jugadores para incluir kills,deaths,assists al final de la línea.
5. Actualizar Esports.cargarJugadores para leer y asignar kills, deaths, assists desde el archivo.

## Archivos a Editar

- src/umariana/cupi2/esports/interfaz/PanelRegistroJugadores.java
- src/umariana/cupi2/esports/interfaz/InterfazEsports.java
- src/umariana/cupi2/esports/mundo/DirectorEquipo.java
- src/umariana/cupi2/esports/mundo/Esports.java

## Pasos de Seguimiento

- [ ] Editar PanelRegistroJugadores para obtener KDA.
- [ ] Editar InterfazEsports para validar y pasar KDA.
- [ ] Editar DirectorEquipo para recibir y guardar KDA.
- [ ] Actualizar persistencia de jugadores.
- [ ] Actualizar carga de datos de jugadores.
- [ ] Probar el registro de un jugador con KDA.
- [ ] Verificar que se guarde y cargue correctamente.
