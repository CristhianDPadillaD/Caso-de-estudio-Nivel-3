# TODO: Implementar funcionalidad en PanelRegistroPartidas.java

## Información Recopilada

- PanelRegistroPartidas.java es el panel correcto para registrar partidas entre equipos.
- Tiene dos secciones: TEAM 1 y TEAM 2, con campos para equipo, fecha, rival, marcador, kills, deaths, assists.
- Esports.java maneja la carga de equipos desde archivos .txt.
- Equipo.java tiene métodos para agregar partidas.
- Partida.java representa una partida con equipos, puntuaciones y determina ganador.
- DirectorEquipo.java tiene registrarPartida() que guarda en .txt.
- InterfazEsports.java tiene registrarPartida() que valida y registra para ambos equipos, pero actualmente usa PanelRegistroPartida (inexistente), debe cambiarse a PanelRegistroPartidas.

## Plan

1. Editar PanelRegistroPartidas.java:

   - Inicializar combo boxes con nombres de equipos desde esports.
   - Agregar action listener al botón "Registrar partida" para llamar a ventana.registrarPartida().
   - Agregar métodos getter para obtener valores de campos (getEquipo1, getFecha1, etc.).
   - Agregar método limpiarCampos() para resetear campos después de registro.

2. Editar InterfazEsports.java:
   - Cambiar instancias de PanelRegistroPartida a PanelRegistroPartidas.
   - Ajustar registrarPartida() para usar panelRegistroPartidas.

## Archivos Dependientes

- PanelRegistroPartidas.java
- InterfazEsports.java

## Pasos de Seguimiento

- Después de ediciones, compilar y probar el registro de una partida.
- Verificar que se guarde correctamente en los .txt con ganador/perdedor.
