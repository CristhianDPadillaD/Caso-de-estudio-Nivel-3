package umariana.cupi2.esports.interfaz;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import umariana.cupi2.esports.mundo.*;

public class InterfazEsports extends javax.swing.JFrame {

    // --- Atributos ---
    private static final String DATA_FOLDER_PATH = "./data";
    private Esports esports; // El modelo
    private DirectorEquipo director; // Para interactuar con el modelo
    private Jugador jugador;
    
    // Los paneles (las vistas)
    private PanelBanner panelBanner;
    private JPanel panelContenedor;
    private PanelRegistroJugador panelRegistroJugador;
    private PanelRegistroPartida panelRegistroPartida;
    private PanelConsulta panelConsulta;
    private PanelPromedioVictorias panelPromedioVictorias;
    private PanelPromedioDerrotas panelPromedioDerrotas;
    private PanelKDA panelKDA;
    private CardLayout cardLayout;

    /**
     * Constructor de la ventana principal
     */
    public InterfazEsports() {
        try {
            // Cargar los datos del mundo
            Esports.CargadorDatos cargador = new Esports().new CargadorDatos();
            esports = cargador.cargarModelo();
            director = new DirectorEquipo("D1", null, "Director General", "admin@esports.com", null);

            // Construir la interfaz gráfica
            initComponents();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fatal al cargar los datos: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    /**
     * Este método es llamado por el PanelRegistroJugador cuando se hace clic en el
     * botón.
     */
public void registrarJugador() {
        
        String nombre = panelRegistroJugador.getNombre();
        String nickname = panelRegistroJugador.getNickname();
        String correo = panelRegistroJugador.getCorreo();
        String nombreEquipo = panelRegistroJugador.getEquipoSeleccionado();

        // 2. Valida los datos de la interfaz
        if (nombre.isEmpty() || nickname.isEmpty() || correo.isEmpty() || nombreEquipo == null) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error de Validación",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // 3. Llama al mundo para hacer la lógica de negocio
            
            // a. Encontrar el objeto Equipo basado en el nombre seleccionado
            umariana.cupi2.esports.mundo.Equipo equipoSeleccionado = esports.darEquipoPorNombre(nombreEquipo);
            if (equipoSeleccionado == null) {
                throw new Exception("No se encontró el equipo '" + nombreEquipo + "'.");
            }

            // b. Asignar temporalmente el equipo al director para que pueda operar sobre él
            director.setEquipoAsignado(equipoSeleccionado);

            // c. Crear el nuevo objeto Jugador
            // El ID del jugador se genera dentro de agregarJugador, por eso se pasa null.
            Jugador nuevoJugador = new Jugador(null, equipoSeleccionado.getIdEquipo(), nombre, nickname, correo, 0,0,0);

            // d. Llamar al método del director para agregar el jugador
            director.agregarJugador(nuevoJugador,DATA_FOLDER_PATH);

            // 4. Informa al usuario del éxito y limpia el panel
            JOptionPane.showMessageDialog(this,
                    "¡Éxito! Jugador '" + nickname + "' registrado en el equipo '" + nombreEquipo + "'.",
                    "Registro Completo", JOptionPane.INFORMATION_MESSAGE);
            panelRegistroJugador.limpiarCampos();

        } catch (Exception e) {
            // 5. Si algo falla en la lógica de negocio, muestra el error
            JOptionPane.showMessageDialog(this, "Error al registrar el jugador:\n" + e.getMessage(), "Error de Negocio",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
 public void registrarPartida() {
        try {
            // 1. Pide los datos del panel para ambos equipos
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

            // 2. Validar que todos los campos obligatorios estén presentes y no vacíos
            if (nombreEquipo1 == null || nombreEquipo1.trim().isEmpty() ||
                fecha1 == null || fecha1.trim().isEmpty() ||
                nombreRival1 == null || nombreRival1.trim().isEmpty() ||
                marcador1Str == null || marcador1Str.trim().isEmpty() ||
                kills1Str == null || kills1Str.trim().isEmpty() ||
                deaths1Str == null || deaths1Str.trim().isEmpty() ||
                assists1Str == null || assists1Str.trim().isEmpty()) {
                throw new Exception("Todos los campos del Equipo 1 son obligatorios.");
            }

            if (nombreEquipo2 == null || nombreEquipo2.trim().isEmpty() ||
                fecha2 == null || fecha2.trim().isEmpty() ||
                nombreRival2 == null || nombreRival2.trim().isEmpty() ||
                marcador2Str == null || marcador2Str.trim().isEmpty() ||
                kills2Str == null || kills2Str.trim().isEmpty() ||
                deaths2Str == null || deaths2Str.trim().isEmpty() ||
                assists2Str == null || assists2Str.trim().isEmpty()) {
                throw new Exception("Todos los campos del Equipo 2 son obligatorios.");
            }

            // Validar fechas: no permitir "No se", formato dd/mm/yyyy, y fechas válidas (mes 1-12, día válido)
            if (fecha1.equalsIgnoreCase("No se") || !fecha1.matches("\\d{2}/\\d{2}/\\d{4}")) {
                throw new Exception("La fecha del Equipo 1 debe tener formato dd/mm/yyyy y no puede ser 'No se'.");
            }
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate.parse(fecha1, formatter);
            } catch (DateTimeParseException e) {
                throw new Exception("La fecha del Equipo 1 no es válida (día/mes/año incorrectos).");
            }

            if (fecha2.equalsIgnoreCase("No se") || !fecha2.matches("\\d{2}/\\d{2}/\\d{4}")) {
                throw new Exception("La fecha del Equipo 2 debe tener formato dd/mm/yyyy y no puede ser 'No se'.");
            }
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate.parse(fecha2, formatter);
            } catch (DateTimeParseException e) {
                throw new Exception("La fecha del Equipo 2 no es válida (día/mes/año incorrectos).");
            }

            // Validar que los equipos no jueguen contra sí mismos
            if (nombreEquipo1.equals(nombreRival1)) {
                throw new Exception("El Equipo 1 no puede jugar contra sí mismo.");
            }
            if (nombreEquipo2.equals(nombreRival2)) {
                throw new Exception("El Equipo 2 no puede jugar contra sí mismo.");
            }

            // Validar y convertir marcadores
            String[] marcadorSplit1 = marcador1Str.split("-");
            if (marcadorSplit1.length != 2) {
                throw new Exception("El formato del marcador del Equipo 1 debe ser 'puntosPropios-puntosRival' (ej: 3-1).");
            }
            int puntosPropios1 = Integer.parseInt(marcadorSplit1[0].trim());
            int puntosRival1 = Integer.parseInt(marcadorSplit1[1].trim());

            String[] marcadorSplit2 = marcador2Str.split("-");
            if (marcadorSplit2.length != 2) {
                throw new Exception("El formato del marcador del Equipo 2 debe ser 'puntosPropios-puntosRival' (ej: 3-1).");
            }
            int puntosPropios2 = Integer.parseInt(marcadorSplit2[0].trim());
            int puntosRival2 = Integer.parseInt(marcadorSplit2[1].trim());

            // Validar kills, deaths, assists como números enteros no negativos y con sentido (no de una cifra)
            int kills1 = Integer.parseInt(kills1Str.trim());
            int deaths1 = Integer.parseInt(deaths1Str.trim());
            int assists1 = Integer.parseInt(assists1Str.trim());
            if (kills1 < 0 || deaths1 < 0 || assists1 < 0) {
                throw new Exception("Kills, deaths y assists del Equipo 1 deben ser números no negativos.");
            }
            if (kills1Str.length() == 1 || deaths1Str.length() == 1 || assists1Str.length() == 1) {
                throw new Exception("Kills, deaths y assists del Equipo 1 deben tener más de una cifra.");
            }

            int kills2 = Integer.parseInt(kills2Str.trim());
            int deaths2 = Integer.parseInt(deaths2Str.trim());
            int assists2 = Integer.parseInt(assists2Str.trim());
            if (kills2 < 0 || deaths2 < 0 || assists2 < 0) {
                throw new Exception("Kills, deaths y assists del Equipo 2 deben ser números no negativos.");
            }
            if (kills2Str.length() == 1 || deaths2Str.length() == 1 || assists2Str.length() == 1) {
                throw new Exception("Kills, deaths y assists del Equipo 2 deben tener más de una cifra.");
            }

            // 3. Llama al mundo para hacer la lógica de negocio
            // Registrar la partida para Equipo 1
            Equipo equipoPropio1 = esports.darEquipoPorNombre(nombreEquipo1);
            Equipo equipoRival1 = esports.darEquipoPorNombre(nombreRival1);

            if (equipoPropio1 == null || equipoRival1 == null) {
                throw new Exception("Uno de los equipos seleccionados no es válido.");
            }

            // Asignar el equipo al director y registrar para Equipo 1
            director.setEquipoAsignado(equipoPropio1);
            director.registrarPartida(equipoRival1, puntosPropios1, puntosRival1, DATA_FOLDER_PATH);

            // Registrar la partida para Equipo 2 (desde su perspectiva)
            Equipo equipoPropio2 = esports.darEquipoPorNombre(nombreEquipo2);
            Equipo equipoRival2 = esports.darEquipoPorNombre(nombreRival2);

            if (equipoPropio2 != null && equipoRival2 != null) {
                director.setEquipoAsignado(equipoPropio2);
                director.registrarPartida(equipoRival2, puntosPropios2, puntosRival2, DATA_FOLDER_PATH);
            }

            // 4. Informa al usuario del éxito
            JOptionPane.showMessageDialog(this, "Partida registrada exitosamente entre " + nombreEquipo1 + " y " + nombreEquipo2 + ".", "Registro Completo", JOptionPane.INFORMATION_MESSAGE);
            panelRegistroPartida.limpiarCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Los marcadores, kills, deaths y assists deben contener solo números.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar la partida:\n" + e.getMessage(), "Error de Negocio", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrarConsulta() {
        cardLayout.show(panelContenedor, "consulta");
    }

    public void mostrarPrincipal() {
        cardLayout.show(panelContenedor, "principal");
    }

    public void mostrarPromedioVictorias() {
        cardLayout.show(panelContenedor, "promedioVictorias");
    }

    public void mostrarPromedioDerrotas() {
        cardLayout.show(panelContenedor, "promedioDerrotas");
    }

    public void mostrarKDA() {
        cardLayout.show(panelContenedor, "kda");
    }

    public void mostrarJugadorConMasKills() {
        String equipoSeleccionado = panelConsulta.getEquipoSeleccionado();
        if (equipoSeleccionado != null) {
            Equipo equipo = esports.darEquipoPorNombre(equipoSeleccionado);
            if (equipo != null) {
                director.setEquipoAsignado(equipo);
                try {
                    Jugador jugadorMaxKills = director.consultarJugadorConMasKills();
                    if (jugadorMaxKills != null) {
                        JOptionPane.showMessageDialog(this, "El jugador con más kills es: " + jugadorMaxKills.getNombre() + " (" + jugadorMaxKills.getNickname() + ") con " + jugadorMaxKills.getKills() + " kills.", "Jugador con Más Kills", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "No hay datos disponibles para mostrar.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error al consultar el jugador con más kills: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * Este método construye la ventana, pero en lugar de tener miles de líneas,
     * ahora solo crea y posiciona nuestros paneles personalizados.
     */
    private void initComponents() {
        // Configuración de la ventana principal
        setTitle("Gestor ESports");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLayout(null); // Usamos layout absoluto para posicionar los paneles

        // Panel de fondo
        javax.swing.JPanel background = new javax.swing.JPanel();
        background.setBackground(new java.awt.Color(0, 0, 51));
        background.setLayout(null);
        setContentPane(background);

        // 1. Crear y añadir el panel del banner
        panelBanner = new PanelBanner();
        panelBanner.setBounds(50, 20, 920, 90);
        background.add(panelBanner);

        // 2. Crear el panel contenedor con CardLayout
        cardLayout = new CardLayout();
        panelContenedor = new JPanel(cardLayout);
        panelContenedor.setBounds(40, 140, 940, 630);
        background.add(panelContenedor);

        // Panel principal (registro de jugadores y partidas)
        JPanel panelPrincipal = new JPanel(null);
        panelRegistroJugador = new PanelRegistroJugador(this, esports);
        panelRegistroJugador.setBounds(0, 0, 440, 630);
        panelPrincipal.add(panelRegistroJugador);

        panelRegistroPartida = new PanelRegistroPartida(this, esports);
        panelRegistroPartida.setBounds(480, 0, 460, 630);
        panelPrincipal.add(panelRegistroPartida);

        panelContenedor.add(panelPrincipal, "principal");

        // 3. Crear y añadir el panel de consulta
        panelConsulta = new PanelConsulta(this, esports);
        panelContenedor.add(panelConsulta, "consulta");

        // 4. Crear y añadir el panel de promedio de victorias
        panelPromedioVictorias = new PanelPromedioVictorias(this, esports);
        panelContenedor.add(panelPromedioVictorias, "promedioVictorias");

        // 5. Crear y añadir el panel de promedio de derrotas
        panelPromedioDerrotas = new PanelPromedioDerrotas(this, esports);
        panelContenedor.add(panelPromedioDerrotas, "promedioDerrotas");

        // 6. Crear y añadir el panel de KDA
        panelKDA = new PanelKDA(this, esports);
        panelContenedor.add(panelKDA, "kda");

        setSize(1010, 810);
        setResizable(false);
        setLocationRelativeTo(null);
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