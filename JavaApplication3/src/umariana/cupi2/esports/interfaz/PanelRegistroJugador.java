package umariana.cupi2.esports.interfaz;

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import umariana.cupi2.esports.mundo.Equipo;
import umariana.cupi2.esports.mundo.Esports;

public class PanelRegistroJugador extends JPanel {

    private InterfazEsports principal; // Referencia a la ventana principal

    // Componentes de la GUI de este panel
    private JTextField nombreRegistro;
    private JTextField nicknameRegistro;
    private JTextField correoRegistro;
    private JComboBox<String> equipoRegistro;

    public PanelRegistroJugador(InterfazEsports ventanaPrincipal, Esports esports) {
        this.principal = ventanaPrincipal;
        setBackground(new Color(107, 64, 133));

        // --- Aquí se crean todos los componentes que antes estaban en InterfazEsports
        // ---
        JLabel registroJugadoresTitulo = new JLabel("Registro de jugadores");
        registroJugadoresTitulo.setFont(new Font("Bahnschrift", 1, 36));
        registroJugadoresTitulo.setForeground(Color.WHITE);

        JLabel nombreTitulo = new JLabel("Nombre completo");
        nombreTitulo.setFont(new Font("Bahnschrift", 1, 14));
        nombreTitulo.setForeground(Color.WHITE);
        nombreRegistro = new JTextField();

        JLabel nicknameTitulo = new JLabel("Nickname");
        nicknameTitulo.setFont(new Font("Bahnschrift", 1, 14));
        nicknameTitulo.setForeground(Color.WHITE);
        nicknameRegistro = new JTextField();

        JLabel correoTitulo = new JLabel("Correo electronico");
        correoTitulo.setFont(new Font("Bahnschrift", 1, 14));
        correoTitulo.setForeground(Color.WHITE);
        correoRegistro = new JTextField();

        JLabel equipoTitulo = new JLabel("Equipo en el que te vas a registrar");
        equipoTitulo.setFont(new Font("Bahnschrift", 1, 14));
        equipoTitulo.setForeground(Color.WHITE);

        equipoRegistro = new JComboBox<>();
        // Llenar el ComboBox con los equipos del modelo
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Equipo equipo : esports.getEquipos()) {
            model.addElement(equipo.getNombre());
        }
        equipoRegistro.setModel(model);

        JButton registroJugadorBoton = new JButton("Registrar");
        registroJugadorBoton.setBackground(new Color(51, 0, 51));
        registroJugadorBoton.setFont(new Font("Bahnschrift", 1, 18));
        registroJugadorBoton.setForeground(Color.WHITE);
        registroJugadorBoton.setBorder(null);
        // IMPORTANTE: Cuando se haga clic, se llama al método en la ventana principal
        registroJugadorBoton.addActionListener(e -> principal.registrarJugador());

        JButton consultarBoton = new JButton("Consultar Jugadores");
        consultarBoton.setBackground(new Color(51, 0, 51));
        consultarBoton.setFont(new Font("Bahnschrift", 1, 18));
        consultarBoton.setForeground(Color.WHITE);
        consultarBoton.setBorder(null);
        consultarBoton.addActionListener(e -> principal.mostrarConsulta());

        // --- Layout de este panel ---
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        // (El código del GroupLayout es largo, pero es el mismo que tenías antes, solo
        // que ahora está encapsulado aquí)
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addGroup(
                                                        layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(equipoRegistro, 0, 325, Short.MAX_VALUE)
                                                                .addComponent(equipoTitulo)
                                                                .addComponent(correoTitulo)
                                                                .addComponent(correoRegistro)
                                                                .addComponent(nicknameTitulo)
                                                                .addComponent(nicknameRegistro)
                                                                .addComponent(nombreTitulo)
                                                                .addComponent(nombreRegistro)))
                .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(registroJugadorBoton, GroupLayout.PREFERRED_SIZE, 120,
                                GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(consultarBoton, GroupLayout.PREFERRED_SIZE, 200,
                                GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(registroJugadoresTitulo, GroupLayout.PREFERRED_SIZE, 380,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(27, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(registroJugadoresTitulo, GroupLayout.PREFERRED_SIZE, 50,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(nombreTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreRegistro, GroupLayout.PREFERRED_SIZE, 32,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nicknameTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nicknameRegistro, GroupLayout.PREFERRED_SIZE, 32,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(correoTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(correoRegistro, GroupLayout.PREFERRED_SIZE, 32,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(equipoTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(equipoRegistro, GroupLayout.PREFERRED_SIZE, 32,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(registroJugadorBoton, GroupLayout.PREFERRED_SIZE, 42,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(consultarBoton, GroupLayout.PREFERRED_SIZE, 42,
                                        GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(63, Short.MAX_VALUE)));
    }

    // Métodos para que la ventana principal pueda obtener los datos de este panel
    public String getNombre() {
        return nombreRegistro.getText();
    }

    public String getNickname() {
        return nicknameRegistro.getText();
    }

    public String getCorreo() {
        return correoRegistro.getText();
    }

    public String getEquipoSeleccionado() {
        return (String) equipoRegistro.getSelectedItem();
    }

    // Método para que la ventana principal pueda limpiar este panel
    public void limpiarCampos() {
        nombreRegistro.setText("");
        nicknameRegistro.setText("");
        correoRegistro.setText("");
        equipoRegistro.setSelectedIndex(0);
    }
}