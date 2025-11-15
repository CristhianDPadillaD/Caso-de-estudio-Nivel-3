package umariana.cupi2.esports.interfaz;

import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JFrame;
import umariana.cupi2.esports.mundo.*;

public class InterfazEsports extends javax.swing.JFrame {

    // --- Atributos ---
    private static final String DATA_FOLDER_PATH = "./data";
    
    private Esports esports; 
    private DirectorEquipo director; 
    
    // Layouts y paneles principales
    private JPanel panelContenedor;   // Donde cambian los paneles
    private CardLayout cardLayout;

    // Paneles funcionales

    private PanelNavBar panelNavBar;
    
    private PanelRegistroPartida panelRegistroPartida;
    private PanelRegistroJugadores panelRegistroJugadores;
    private PanelConsultarJugadores panelConsultarJugadores;


    /**
     * Constructor de la ventana principal
     */
    public InterfazEsports() {
        try {
            // Cargar los datos del mundo
            Esports.CargadorDatos cargador = new Esports().new CargadorDatos();
            esports = cargador.cargarModelo();
            
            director = new DirectorEquipo("D1", null, "Director General", "admin@esports.com", null);

            // Construir interfaz
            initComponents();
            inicializarPaneles();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fatal al cargar los datos: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    
    private void inicializarPaneles() {

        panelRegistroPartida = new PanelRegistroPartida(this, esports);
        panelRegistroJugadores = new PanelRegistroJugadores(this, esports);
        panelConsultarJugadores = new PanelConsultarJugadores(this, esports);

        // Añadirlos al CardLayout
        panelContenedor.add(panelRegistroJugadores, "registroJugadores");
        panelContenedor.add(panelRegistroPartida, "registroPartidas");
        panelContenedor.add(panelConsultarJugadores, "consultaJugadores");
    }

     /**
     * Cambia dinámicamente el panel dentro del contenedor central
     */
  public void mostrarPanel(String nombre) {
    cardLayout.show(panelContenedor, nombre);
}

    
     /**
     * Este método es llamado por el PanelRegistroJugador cuando se hace clic en el
     * botón.
     */
 public void registrarJugador(String nombre, String nickname, String correo, String nombreEquipo, String kda) {

        try {
            if (nombre.isEmpty() || nickname.isEmpty() || correo.isEmpty() || nombreEquipo == null || kda.isEmpty()) {
                throw new Exception("Todos los campos son obligatorios.");
            }

            // Validar formato KDA: kills/deaths/assists
            String[] partesKDA = kda.split("/");
            if (partesKDA.length != 3) {
                throw new Exception("El KDA debe tener el formato kills/deaths/assists (ej. 5/2/3).");
            }

            int kills, deaths, assists;
            try {
                kills = Integer.parseInt(partesKDA[0].trim());
                deaths = Integer.parseInt(partesKDA[1].trim());
                assists = Integer.parseInt(partesKDA[2].trim());
            } catch (NumberFormatException ex) {
                throw new Exception("Los valores del KDA deben ser números enteros.");
            }

            if (kills < 0 || deaths < 0 || assists < 0) {
                throw new Exception("Los valores del KDA no pueden ser negativos.");
            }

            Equipo equipo = esports.darEquipoPorNombre(nombreEquipo);
            if (equipo == null)
                throw new Exception("El equipo seleccionado no existe.");

            director.setEquipoAsignado(equipo);

            Jugador nuevo = new Jugador(
                    null,
                    equipo.getIdEquipo(),
                    nombre,
                    nickname,
                    correo,
                    kills, deaths, assists
            );

            director.agregarJugador(nuevo, DATA_FOLDER_PATH);

            JOptionPane.showMessageDialog(this,
                    "Jugador registrado exitosamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al registrar jugador:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
 public void registrarPartida() {
    try {


        String nombreEquipo1 = panelRegistroPartida.getEquipo1();
        String fecha1 = panelRegistroPartida.getFecha1();
        String nombreRival1 = panelRegistroPartida.getRival1();
        String marcador1Str = panelRegistroPartida.getMarcador1();
        String kills1Str = panelRegistroPartida.getKills1();
        String deaths1Str = panelRegistroPartida.getDeaths1();
        String assists1Str = panelRegistroPartida.getAssists1();

        String nombreEquipo2 = panelRegistroPartida.getEquipo2();
        String fecha2 = panelRegistroPartida.getFecha2();
        String nombreRival2 = panelRegistroPartida.getRival2();
        String marcador2Str = panelRegistroPartida.getMarcador2();
        String kills2Str = panelRegistroPartida.getKills2();
        String deaths2Str = panelRegistroPartida.getDeaths2();
        String assists2Str = panelRegistroPartida.getAssists2();

        // ============================================================
        // VALIDACIONES — TEAM 1
        // ============================================================
        if (nombreEquipo1 == null || nombreEquipo1.trim().isEmpty() ||
            fecha1 == null || fecha1.trim().isEmpty() ||
            nombreRival1 == null || nombreRival1.trim().isEmpty() ||
            marcador1Str == null || marcador1Str.trim().isEmpty() ||
            kills1Str == null || kills1Str.trim().isEmpty() ||
            deaths1Str == null || deaths1Str.trim().isEmpty() ||
            assists1Str == null || assists1Str.trim().isEmpty()) {
            throw new Exception("Todos los campos del Equipo 1 son obligatorios.");
        }

        // ============================================================
        // VALIDACIONES — TEAM 2
        // ============================================================
        if (nombreEquipo2 == null || nombreEquipo2.trim().isEmpty() ||
            fecha2 == null || fecha2.trim().isEmpty() ||
            nombreRival2 == null || nombreRival2.trim().isEmpty() ||
            marcador2Str == null || marcador2Str.trim().isEmpty() ||
            kills2Str == null || kills2Str.trim().isEmpty() ||
            deaths2Str == null || deaths2Str.trim().isEmpty() ||
            assists2Str == null || assists2Str.trim().isEmpty()) {
            throw new Exception("Todos los campos del Equipo 2 son obligatorios.");
        }

        // ============================================================
        // VALIDAR FECHAS
        // ============================================================
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (!fecha1.matches("\\d{2}/\\d{2}/\\d{4}"))
            throw new Exception("La fecha del Equipo 1 debe ser dd/mm/yyyy.");

        LocalDate.parse(fecha1, formatter);

        if (!fecha2.matches("\\d{2}/\\d{2}/\\d{4}"))
            throw new Exception("La fecha del Equipo 2 debe ser dd/mm/yyyy.");

        LocalDate.parse(fecha2, formatter);

        // ============================================================
        // VALIDAR QUE NO SE ENFRENTEN A SÍ MISMOS
        // ============================================================
        if (nombreEquipo1.equals(nombreRival1))
            throw new Exception("El Equipo 1 no puede jugar contra sí mismo.");

        if (nombreEquipo2.equals(nombreRival2))
            throw new Exception("El Equipo 2 no puede jugar contra sí mismo.");

        // ============================================================
        // VALIDAR MARCADORES TEAM 1
        // ============================================================
        String[] marcadorSplit1 = marcador1Str.split("-");
        if (marcadorSplit1.length != 2)
            throw new Exception("Marcador de Equipo 1 debe ser X-Y.");

        int puntosPropios1 = Integer.parseInt(marcadorSplit1[0].trim());
        int puntosRival1 = Integer.parseInt(marcadorSplit1[1].trim());

        // ============================================================
        // VALIDAR MARCADORES TEAM 2
        // ============================================================
        String[] marcadorSplit2 = marcador2Str.split("-");
        if (marcadorSplit2.length != 2)
            throw new Exception("Marcador de Equipo 2 debe ser X-Y.");

        int puntosPropios2 = Integer.parseInt(marcadorSplit2[0].trim());
        int puntosRival2 = Integer.parseInt(marcadorSplit2[1].trim());

        // ============================================================
        // VALIDAR K/D/A — TEAM 1
        // ============================================================
        int kills1 = Integer.parseInt(kills1Str.trim());
        int deaths1 = Integer.parseInt(deaths1Str.trim());
        int assists1 = Integer.parseInt(assists1Str.trim());

        if (kills1 < 0 || deaths1 < 0 || assists1 < 0)
            throw new Exception("K/D/A del Equipo 1 deben ser >= 0.");

        // ============================================================
        // VALIDAR K/D/A — TEAM 2
        // ============================================================
        int kills2 = Integer.parseInt(kills2Str.trim());
        int deaths2 = Integer.parseInt(deaths2Str.trim());
        int assists2 = Integer.parseInt(assists2Str.trim());

        if (kills2 < 0 || deaths2 < 0 || assists2 < 0)
            throw new Exception("K/D/A del Equipo 2 deben ser >= 0.");

        // ============================================================
        // 3. INTERACCIÓN CON EL MUNDO
        // ============================================================

        Equipo equipoPropio1 = esports.darEquipoPorNombre(nombreEquipo1);
        Equipo equipoRival1 = esports.darEquipoPorNombre(nombreRival1);

        Equipo equipoPropio2 = esports.darEquipoPorNombre(nombreEquipo2);
        Equipo equipoRival2 = esports.darEquipoPorNombre(nombreRival2);

        if (equipoPropio1 == null || equipoRival1 == null ||
            equipoPropio2 == null || equipoRival2 == null) {
            throw new Exception("Uno de los equipos seleccionados no existe.");
        }

        // Registrar para TEAM 1
        director.setEquipoAsignado(equipoPropio1);
        director.registrarPartida(equipoRival1, puntosPropios1, puntosRival1, DATA_FOLDER_PATH);

        // Registrar para TEAM 2
        director.setEquipoAsignado(equipoPropio2);
        director.registrarPartida(equipoRival2, puntosPropios2, puntosRival2, DATA_FOLDER_PATH);

        // ============================================================
        // 4. ÉXITO
        // ============================================================
        JOptionPane.showMessageDialog(
                this,
                "Partida registrada correctamente.",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);

        panelRegistroPartida.limpiarCampos();

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Los campos numéricos tienen formato incorrecto.",
                "Error", JOptionPane.ERROR_MESSAGE);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Error al registrar partida:\n" + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}

  
     public void irARegistroJugadores() {
        mostrarPanel("jugadores");
    }

    public void irARegistroPartida() {
        mostrarPanel("registro");
    }

    public void irAConsultaJugadores() {
        mostrarPanel("consulta");
    }
    /**
     * Este método construye la ventana, pero en lugar de tener miles de líneas,
     * ahora solo crea y posiciona nuestros paneles personalizados.
     */

      private void initComponents() {

        setTitle("Gestor ESports");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null); // Para posicionar elementos manualmente
        setSize(1010, 810);
        setLocationRelativeTo(null);
        setResizable(false);

        // -----------------------------------
        // 1. NAV BAR FIJO ARRIBA
        // -----------------------------------
        panelNavBar = new PanelNavBar(this);
        panelNavBar.setBounds(0, 0, 1010, 80);
        add(panelNavBar);

        // -----------------------------------
        // 2. PANEL CONTENEDOR CON CARDLAYOUT
        // -----------------------------------
        cardLayout = new CardLayout();
        panelContenedor = new JPanel(cardLayout);
        panelContenedor.setBounds(0, 80, 1010, 730);
        add(panelContenedor);


        // -----------------------------------
        // 3. CREACIÓN DE LOS PANELES
        // -----------------------------------

        panelRegistroJugadores = new PanelRegistroJugadores(this, esports);
        panelContenedor.add(panelRegistroJugadores, "registroJugadores");

        panelRegistroPartida = new PanelRegistroPartida(this, esports);
        panelContenedor.add(panelRegistroPartida, "registroPartidas");

        panelConsultarJugadores = new PanelConsultarJugadores(this, esports);
        panelContenedor.add(panelConsultarJugadores, "consultaJugadores");

        // -----------------------------------
        // 4. MOSTRAR PANEL INICIAL
        // -----------------------------------
        mostrarPanel("registroJugadores");  // Panel por defecto
    }
    
            

    public void consultarKDA(String nombreEquipo) {
        try {
            Equipo equipo = esports.darEquipoPorNombre(nombreEquipo);
            if (equipo == null) {
                throw new Exception("Equipo no encontrado.");
            }
            String[] kdas = equipo.consultarKDAJugadores();
            panelConsultarJugadores.actualizarLista(kdas);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void consultarPromedioVictorias(String nombreEquipo) {
        try {
            Equipo equipo = esports.darEquipoPorNombre(nombreEquipo);
            if (equipo == null) {
                throw new Exception("Equipo no encontrado.");
            }
            double promedio = equipo.calcularPromedioVictorias();
            JOptionPane.showMessageDialog(this, "Promedio de victorias: " + promedio, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void consultarPromedioDerrotas(String nombreEquipo) {
        try {
            Equipo equipo = esports.darEquipoPorNombre(nombreEquipo);
            if (equipo == null) {
                throw new Exception("Equipo no encontrado.");
            }
            double promedio = equipo.calcularPromedioDerrotas();
            JOptionPane.showMessageDialog(this, "Promedio de derrotas: " + promedio, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void consultarJugadorMasKills(String nombreEquipo) {
        try {
            Equipo equipo = esports.darEquipoPorNombre(nombreEquipo);
            if (equipo == null) {
                throw new Exception("Equipo no encontrado.");
            }
            String[] resultado = equipo.consultarJugadorMasKills();
            panelConsultarJugadores.actualizarLista(resultado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // El método main para ejecutar la aplicación
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazEsports().setVisible(true);
            }
        });
    }
}
