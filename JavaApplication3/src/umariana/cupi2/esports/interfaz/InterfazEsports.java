package umariana.cupi2.esports.interfaz;

import javax.swing.JOptionPane;
import umariana.cupi2.esports.mundo.*;

public class InterfazEsports extends javax.swing.JFrame {

    // --- Atributos ---
    private Esports esports; // El modelo
    private DirectorEquipo director; // Para interactuar con el modelo
    private Jugador jugador;

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
            director.agregarJugador(nuevoJugador);

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
            // 1. Pide los datos del panel para el Equipo 1
            String nombreEquipo1 = panelRegistroPartida.getEquipo1();
            String nombreRival1 = panelRegistroPartida.getRival1();
            String marcador1Str = panelRegistroPartida.getMarcador1();
            
            // 2. Validar y convertir datos
            if (nombreEquipo1 == null || nombreRival1 == null || marcador1Str.isEmpty()) {
                throw new Exception("Para el Equipo 1, debe seleccionar equipo, rival y marcador.");
            }
            if (nombreEquipo1.equals(nombreRival1)) {
                throw new Exception("Un equipo no puede jugar contra sí mismo.");
            }

            String[] marcadorSplit = marcador1Str.split("-");
            if (marcadorSplit.length != 2) {
                throw new Exception("El formato del marcador debe ser 'puntosPropios-puntosRival' (ej: 3-1).");
            }
            int puntosPropios = Integer.parseInt(marcadorSplit[0].trim());
            int puntosRival = Integer.parseInt(marcadorSplit[1].trim());

            // 3. Llama al mundo para hacer la lógica de negocio
            Equipo equipoPropio = esports.darEquipoPorNombre(nombreEquipo1);
            Equipo equipoRival = esports.darEquipoPorNombre(nombreRival1);

            if (equipoPropio == null || equipoRival == null) {
                throw new Exception("Uno de los equipos seleccionados no es válido.");
            }

            // Asignar el equipo al director
            director.setEquipoAsignado(equipoPropio);

            // Llamar al método del director
            director.registrarPartida(equipoRival, puntosPropios, puntosRival);

            // 4. Informa al usuario del éxito
            JOptionPane.showMessageDialog(this, "Partida registrada exitosamente para " + nombreEquipo1 + ".", "Registro Completo", JOptionPane.INFORMATION_MESSAGE);
            // panelRegistroPartida.limpiarCampos(); // Podrías llamar a un método para limpiar el panel

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El marcador debe contener solo números separados por un guion.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar la partida:\n" + e.getMessage(), "Error de Negocio", JOptionPane.ERROR_MESSAGE);
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