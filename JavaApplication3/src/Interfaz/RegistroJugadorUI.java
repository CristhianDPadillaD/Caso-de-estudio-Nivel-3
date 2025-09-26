// Archivo: Interfaz/RegistroJugadorUI.java
package Interfaz;

import Mundo.DirectorEquipo;
import Mundo.Jugador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class RegistroJugadorUI extends JFrame {

    private JTextField txtNombre, txtNickname;
    private JButton btnRegistrar;
    private Image backgroundImage;
    private final DirectorEquipo director; // ahora la UI conoce al director

    // Constructor recibe el DirectorEquipo (inyectar dependencia)
    public RegistroJugadorUI(DirectorEquipo director) {
        this.director = director;
        initUI();
    }

    private void initUI() {
        setTitle("🎮 Registro de Jugador - Esports");
        setSize(600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Cargar imagen de fondo de forma segura (evita NullPointerException)
        URL imgUrl = getClass().getResource("/Data/Imagenes/fondo.jpg");
        if (imgUrl != null) {
            backgroundImage = new ImageIcon(imgUrl).getImage();
        } else {
            backgroundImage = null; // fallback: no hay imagen
        }

        JPanel panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } else {
                    // fondo por defecto si no hay imagen
                    g.setColor(new Color(25, 25, 25));
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            }
        };
        panelFondo.setLayout(new GridBagLayout());

        JPanel cardPanel = new JPanel(new GridBagLayout());
        cardPanel.setBackground(new Color(20, 20, 20, 200));
        cardPanel.setBorder(BorderFactory.createLineBorder(new Color(138, 43, 226), 3, true));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font fontTitulo = new Font("Consolas", Font.BOLD, 22);
        Font fontTexto = new Font("Consolas", Font.PLAIN, 16);

        JLabel lblTitulo = new JLabel("Registro de Jugador");
        lblTitulo.setFont(fontTitulo);
        lblTitulo.setForeground(new Color(138, 43, 226));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        cardPanel.add(lblTitulo, gbc);
        gbc.gridwidth = 1;

        // Campos
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel lblNombre = new JLabel("Nombre completo:");
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setFont(fontTexto);
        cardPanel.add(lblNombre, gbc);

        gbc.gridx = 1;
        txtNombre = new JTextField(15);
        estilizarCampo(txtNombre, fontTexto);
        cardPanel.add(txtNombre, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        JLabel lblNickname = new JLabel("Nickname:");
        lblNickname.setForeground(Color.WHITE);
        lblNickname.setFont(fontTexto);
        cardPanel.add(lblNickname, gbc);

        gbc.gridx = 1;
        txtNickname = new JTextField(15);
        estilizarCampo(txtNickname, fontTexto);
        cardPanel.add(txtNickname, gbc);



        // Botón
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        btnRegistrar = new JButton("🚀 Registrar Jugador");
        btnRegistrar.setBackground(new Color(138, 43, 226));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFont(new Font("Consolas", Font.BOLD, 16));
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cardPanel.add(btnRegistrar, gbc);

        btnRegistrar.addActionListener((ActionEvent e) -> registrarJugador());

        panelFondo.add(cardPanel);
        add(panelFondo);
    }

    private void estilizarCampo(JTextField campo, Font font) {
        campo.setBackground(new Color(40, 40, 40));
        campo.setForeground(Color.WHITE);
        campo.setCaretColor(Color.WHITE);
        campo.setFont(font);
        campo.setBorder(BorderFactory.createLineBorder(new Color(138, 43, 226), 2));
    }

    // Método conectado al botón: crea Jugador y delega en DirectorEquipo
    private void registrarJugador() {
        String nombre = txtNombre.getText().trim();
        String nickname = txtNickname.getText().trim();
       //System.out.println("Este es el nombre"+ nombre);
        if (nombre.isEmpty() || nickname.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "⚠️ Debe completar todos los campos obligatorios",
                    "Error de registro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear un id para el jugador (puedes adaptar el esquema a tu modelo)
        //String idJugador = java.util.UUID.randomUUID().toString();
        String idEquipo = (director.getEquipoAsignado() != null) ? director.getEquipoAsignado().getIdEquipo() : "E01";


        try {
   
Jugador nuevo = new Jugador("", idEquipo, nombre, nickname);

            director.agregarJugador(nuevo);

            JOptionPane.showMessageDialog(this,
                    "✅ Jugador registrado exitosamente:\n" +
                            "Nombre: " + nombre + "\n" +
                            "Nickname: " + nickname,
                    "Registro exitoso",
                    JOptionPane.INFORMATION_MESSAGE);

            limpiarCampos();

        } catch (Exception ex) {
            // Mostrar el mensaje que lanzó la lógica de negocio (validaciones / persistencia)
            JOptionPane.showMessageDialog(this,
                    "❌ Error al registrar el jugador:\n" + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtNickname.setText("");
    }
}
