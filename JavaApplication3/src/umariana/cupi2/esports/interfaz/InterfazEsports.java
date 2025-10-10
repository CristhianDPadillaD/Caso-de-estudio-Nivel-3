package umariana.cupi2.esports.interfaz;

import javax.swing.JOptionPane;
import umariana.cupi2.esports.mundo.DirectorEquipo;
import umariana.cupi2.esports.mundo.Esports;

public class InterfazEsports extends javax.swing.JFrame {

    // --- Atributos ---
    private Esports esports; // El modelo
    private DirectorEquipo director; // Para interactuar con el modelo

    // Los paneles (las vistas)
    private PanelBanner panelBanner;
    private PanelRegistroJugador panelRegistroJugador;
    private PanelRegistroPartida panelRegistroPartida;
    // private PanelRegistroPartida panelRegistroPartida; // Lo añadiremos después

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
        // 1. Pide los datos al panel
        String nombre = panelRegistroJugador.getNombre();
        String nickname = panelRegistroJugador.getNickname();
        String correo = panelRegistroJugador.getCorreo();
        String nombreEquipo = panelRegistroJugador.getEquipoSeleccionado();

        // 2. Valida los datos
        if (nombre.isEmpty() || nickname.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error",
                    JOptionPane.WARNING_MESSAGE);
            return; // Detiene la ejecución si algo está mal
        }

        // 3. Llama al mundo para hacer la lógica de negocio (ejemplo)
        // director.agregarJugadorAEquipo(nombreEquipo, nombre, nickname, correo);

        // 4. Informa al usuario y limpia el panel
        JOptionPane.showMessageDialog(this,
                "Jugador '" + nickname + "' registrado en el equipo '" + nombreEquipo + "'.");
        panelRegistroJugador.limpiarCampos();
    }
      public void registrarPartida() {
        // 1. Pide los datos al panel
        String equipo1 = panelRegistroPartida.getEquipo1();
        String fecha1 = panelRegistroPartida.getFecha1();

        // 2. Aquí iría la validación de los datos

        // 3. Llama al mundo para hacer la lógica de negocio (ejemplo)
        // director.registrarPartida(...);

        // 4. Informa al usuario
        JOptionPane.showMessageDialog(this, "Partida del equipo '" + equipo1 + "' registrada para la fecha " + fecha1 + ".");
        // panelRegistroPartida.limpiarCampos(); // Podrías crear este método también
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

        // --- Aquí está la magia ---
        // 1. Crear y añadir el panel del banner
        panelBanner = new PanelBanner();
        panelBanner.setBounds(50, 20, 920, 90);
        background.add(panelBanner);

        // 2. Crear y añadir el panel de registro de jugadores
        panelRegistroJugador = new PanelRegistroJugador(this, esports);
        panelRegistroJugador.setBounds(40, 140, 440, 630);
        background.add(panelRegistroJugador);


        // 3. Crear y añadir el panel de registro de partidas
        panelRegistroPartida = new PanelRegistroPartida(this, esports);
        panelRegistroPartida.setBounds(520, 140, 460, 630); // Lo posicionamos a la derecha
        background.add(panelRegistroPartida);

        setSize(1010, 810);
        setResizable(false);
        setLocationRelativeTo(null);

        // Ajustar tamaño final de la ventana
        setSize(1010, 810);
        setResizable(false);
        setLocationRelativeTo(null); // Centrar en pantalla
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