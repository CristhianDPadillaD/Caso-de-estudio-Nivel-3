package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class RegistroJugadorUI extends JFrame {

    private JTextField txtNombre, txtNickname, txtCorreo, txtTelefono;
    private JButton btnRegistrar;
    private Image backgroundImage;

    public RegistroJugadorUI() {
        setTitle("🎮 Registro de Jugador - Esports");
        setSize(600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
         backgroundImage = new ImageIcon(getClass().getResource("/Data/Imagenes/fondo.jpg")).getImage();


        // Panel principal con imagen de fondo
        JPanel panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panelFondo.setLayout(new GridBagLayout());

        // Panel "card" donde va el formulario
        JPanel cardPanel = new JPanel(new GridBagLayout());
        cardPanel.setBackground(new Color(20, 20, 20, 200)); // semi-transparente
        cardPanel.setBorder(BorderFactory.createLineBorder(new Color(138, 43, 226), 3, true)); // borde morado redondeado

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font fontTitulo = new Font("Consolas", Font.BOLD, 22);
        Font fontTexto = new Font("Consolas", Font.PLAIN, 16);

        // 🔹 Título
        JLabel lblTitulo = new JLabel("Registro de Jugador");
        lblTitulo.setFont(fontTitulo);
        lblTitulo.setForeground(new Color(138, 43, 226));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        cardPanel.add(lblTitulo, gbc);

        gbc.gridwidth = 1; // reset

        // 🔹 Campos
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

        gbc.gridy++;
        gbc.gridx = 0;
        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setForeground(Color.WHITE);
        lblCorreo.setFont(fontTexto);
        cardPanel.add(lblCorreo, gbc);

        gbc.gridx = 1;
        txtCorreo = new JTextField(15);
        estilizarCampo(txtCorreo, fontTexto);
        cardPanel.add(txtCorreo, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setForeground(Color.WHITE);
        lblTelefono.setFont(fontTexto);
        cardPanel.add(lblTelefono, gbc);

        gbc.gridx = 1;
        txtTelefono = new JTextField(15);
        estilizarCampo(txtTelefono, fontTexto);
        cardPanel.add(txtTelefono, gbc);

        // 🔹 Botón
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

        btnRegistrar.addActionListener((ActionEvent e) -> {
            registrarJugador();
        });

        // Añadir la "card" al panel con fondo
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

    private void registrarJugador() {
        String nombre = txtNombre.getText().trim();
        String nickname = txtNickname.getText().trim();
        String correo = txtCorreo.getText().trim();
        String telefono = txtTelefono.getText().trim();

        if (nombre.isEmpty() || nickname.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "⚠️ Debe completar todos los campos obligatorios",
                    "Error de registro",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    """
                    \u2705 Jugador registrado exitosamente:
                    Nombre: """ + nombre + "\n"
                    + "Nickname: " + nickname + "\n"
                    + "Correo: " + correo + "\n"
                    + "Teléfono: " + telefono,
                    "Registro exitoso",
                    JOptionPane.INFORMATION_MESSAGE);

            txtNombre.setText("");
            txtNickname.setText("");
            txtCorreo.setText("");
            txtTelefono.setText("");
        }
    }
    
    
}
