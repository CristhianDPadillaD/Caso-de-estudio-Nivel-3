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

public class PanelRegistroPartida extends JPanel {

    private InterfazEsports principal;

    // --- Componentes de la GUI de este panel ---
    private JComboBox<String> equipo1Registro, rival1Registro, equipo2Registro, rival2Registro;
    private JTextField fecha1Registro, marcador1Registro, kills1Registro, deaths1Registro, assists1Registro;
    private JTextField fecha2Registro, marcador2Registro, kills2Registro, deaths2Registro, assists2Registro;

    public PanelRegistroPartida(InterfazEsports ventanaPrincipal, Esports esports) {
        this.principal = ventanaPrincipal;
        setBackground(new Color(30, 78, 78));

        // Inicializar todos los componentes y configurar el layout
        initComponents(esports);
    }

    private void initComponents(Esports esports) {
        // --- Creación de todos los componentes ---
        JLabel registroPartidasTitulo = new JLabel("Registro de partidas");
        registroPartidasTitulo.setFont(new Font("Bahnschrift", 1, 36));
        registroPartidasTitulo.setForeground(Color.WHITE);

        // Componentes Equipo 1
        JLabel equipo1Titulo = new JLabel("Equipo 1");
        equipo1Titulo.setFont(new Font("Bahnschrift", 1, 20));
        equipo1Titulo.setForeground(Color.WHITE);
        JLabel nombreTitulo1 = new JLabel("Equipo");
        nombreTitulo1.setFont(new Font("Bahnschrift", 1, 14));
        nombreTitulo1.setForeground(Color.WHITE);
        equipo1Registro = new JComboBox<>();
        JLabel fecha1Titulo = new JLabel("Fecha");
        fecha1Titulo.setFont(new Font("Bahnschrift", 1, 14));
        fecha1Titulo.setForeground(Color.WHITE);
        fecha1Registro = new JTextField();
        JLabel rival1Titulo = new JLabel("Rival");
        rival1Titulo.setFont(new Font("Bahnschrift", 1, 14));
        rival1Titulo.setForeground(Color.WHITE);
        rival1Registro = new JComboBox<>();
        JLabel Marcador1Titulo = new JLabel("Marcador");
        Marcador1Titulo.setFont(new Font("Bahnschrift", 1, 14));
        Marcador1Titulo.setForeground(Color.WHITE);
        marcador1Registro = new JTextField();
        JLabel kills1Titulo = new JLabel("Kills");
        kills1Titulo.setFont(new Font("Bahnschrift", 1, 14));
        kills1Titulo.setForeground(Color.WHITE);
        kills1Registro = new JTextField();
        JLabel deaths1Titulo = new JLabel("Deaths");
        deaths1Titulo.setFont(new Font("Bahnschrift", 1, 14));
        deaths1Titulo.setForeground(Color.WHITE);
        deaths1Registro = new JTextField();
        JLabel assists1Titulo = new JLabel("Assists");
        assists1Titulo.setFont(new Font("Bahnschrift", 1, 14));
        assists1Titulo.setForeground(Color.WHITE);
        assists1Registro = new JTextField();

        // Componentes Equipo 2
        JLabel equipo2Titulo = new JLabel("Equipo 2");
        equipo2Titulo.setFont(new Font("Bahnschrift", 1, 20));
        equipo2Titulo.setForeground(Color.WHITE);
        JLabel nombreTitulo2 = new JLabel("Equipo");
        nombreTitulo2.setFont(new Font("Bahnschrift", 1, 14));
        nombreTitulo2.setForeground(Color.WHITE);
        equipo2Registro = new JComboBox<>();
        JLabel fecha2Titulo = new JLabel("Fecha");
        fecha2Titulo.setFont(new Font("Bahnschrift", 1, 14));
        fecha2Titulo.setForeground(Color.WHITE);
        fecha2Registro = new JTextField();
        JLabel rival2Titulo = new JLabel("Rival");
        rival2Titulo.setFont(new Font("Bahnschrift", 1, 14));
        rival2Titulo.setForeground(Color.WHITE);
        rival2Registro = new JComboBox<>();
        JLabel Marcador2Titulo = new JLabel("Marcador");
        Marcador2Titulo.setFont(new Font("Bahnschrift", 1, 14));
        Marcador2Titulo.setForeground(Color.WHITE);
        marcador2Registro = new JTextField();
        JLabel kills2Titulo = new JLabel("Kills");
        kills2Titulo.setFont(new Font("Bahnschrift", 1, 14));
        kills2Titulo.setForeground(Color.WHITE);
        kills2Registro = new JTextField();
        JLabel deaths2Titulo = new JLabel("Deaths");
        deaths2Titulo.setFont(new Font("Bahnschrift", 1, 14));
        deaths2Titulo.setForeground(Color.WHITE);
        deaths2Registro = new JTextField();
        JLabel assists2Titulo = new JLabel("Assists");
        assists2Titulo.setFont(new Font("Bahnschrift", 1, 14));
        assists2Titulo.setForeground(Color.WHITE);
        assists2Registro = new JTextField();

        // Botón de registro
        JButton registroPartidaBoton = new JButton("Registrar");
        registroPartidaBoton.setBackground(new Color(89, 140, 128));
        registroPartidaBoton.setFont(new Font("Bahnschrift", 1, 18));
        registroPartidaBoton.setForeground(Color.WHITE);
        registroPartidaBoton.setBorder(null);
        registroPartidaBoton.addActionListener(e -> principal.registrarPartida());

        // Llenar los ComboBox con los equipos
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Equipo equipo : esports.getEquipos()) {
            model.addElement(equipo.getNombre());
        }
        String[] items = new String[model.getSize()];
        for (int i = 0; i < model.getSize(); i++) {
            items[i] = model.getElementAt(i);
        }
        equipo1Registro.setModel(new DefaultComboBoxModel<>(items));
        equipo2Registro.setModel(new DefaultComboBoxModel<>(items));
        rival1Registro.setModel(new DefaultComboBoxModel<>(items));
        rival2Registro.setModel(new DefaultComboBoxModel<>(items));

        // --- Layout de este panel ---
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(68, 68, 68)
                                                .addComponent(equipo1Titulo))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(
                                                        layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(nombreTitulo1)
                                                                .addComponent(fecha1Titulo)
                                                                .addComponent(fecha1Registro, GroupLayout.DEFAULT_SIZE,
                                                                        162, Short.MAX_VALUE)
                                                                .addComponent(rival1Titulo)
                                                                .addComponent(Marcador1Titulo)
                                                                .addComponent(marcador1Registro,
                                                                        GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                                                .addComponent(kills1Titulo)
                                                                .addComponent(kills1Registro, GroupLayout.DEFAULT_SIZE,
                                                                        162, Short.MAX_VALUE)
                                                                .addComponent(deaths1Titulo)
                                                                .addComponent(deaths1Registro, GroupLayout.DEFAULT_SIZE,
                                                                        162, Short.MAX_VALUE)
                                                                .addComponent(assists1Titulo)
                                                                .addComponent(assists1Registro,
                                                                        GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                                                .addComponent(equipo1Registro, 0,
                                                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(rival1Registro, 0,
                                                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(equipo2Titulo))
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(nombreTitulo2)
                                                .addComponent(fecha2Titulo)
                                                .addComponent(fecha2Registro)
                                                .addComponent(rival2Titulo)
                                                .addComponent(Marcador2Titulo)
                                                .addComponent(marcador2Registro)
                                                .addComponent(kills2Titulo)
                                                .addComponent(kills2Registro)
                                                .addComponent(deaths2Titulo)
                                                .addComponent(deaths2Registro)
                                                .addComponent(assists2Titulo)
                                                .addComponent(assists2Registro)
                                                .addComponent(equipo2Registro, 0, GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)
                                                .addComponent(rival2Registro, GroupLayout.PREFERRED_SIZE, 162,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addGap(34, 34, 34))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(registroPartidasTitulo, GroupLayout.PREFERRED_SIZE, 360,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(46, 46, 46))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(registroPartidaBoton, GroupLayout.PREFERRED_SIZE, 138,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addGap(159, 159, 159)))));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(registroPartidasTitulo, GroupLayout.PREFERRED_SIZE, 50,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(equipo1Titulo)
                                                .addGap(18, 18, 18)
                                                .addComponent(nombreTitulo1)
                                                .addGap(1, 1, 1)
                                                .addComponent(equipo1Registro, GroupLayout.PREFERRED_SIZE, 34,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fecha1Titulo)
                                                .addGap(2, 2, 2)
                                                .addComponent(fecha1Registro, GroupLayout.PREFERRED_SIZE, 33,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rival1Titulo)
                                                .addGap(1, 1, 1)
                                                .addComponent(rival1Registro, GroupLayout.PREFERRED_SIZE, 34,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Marcador1Titulo)
                                                .addGap(2, 2, 2)
                                                .addComponent(marcador1Registro, GroupLayout.PREFERRED_SIZE, 33,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(kills1Titulo)
                                                .addGap(2, 2, 2)
                                                .addComponent(kills1Registro, GroupLayout.PREFERRED_SIZE, 33,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(deaths1Titulo)
                                                .addGap(2, 2, 2)
                                                .addComponent(deaths1Registro, GroupLayout.PREFERRED_SIZE, 33,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(assists1Titulo)
                                                .addGap(2, 2, 2)
                                                .addComponent(assists1Registro, GroupLayout.PREFERRED_SIZE, 33,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(equipo2Titulo)
                                                .addGap(18, 18, 18)
                                                .addComponent(nombreTitulo2)
                                                .addGap(1, 1, 1)
                                                .addComponent(equipo2Registro, GroupLayout.PREFERRED_SIZE, 34,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(fecha2Titulo)
                                                .addGap(2, 2, 2)
                                                .addComponent(fecha2Registro, GroupLayout.PREFERRED_SIZE, 33,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rival2Titulo)
                                                .addGap(1, 1, 1)
                                                .addComponent(rival2Registro, GroupLayout.PREFERRED_SIZE, 34,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Marcador2Titulo)
                                                .addGap(2, 2, 2)
                                                .addComponent(marcador2Registro, GroupLayout.PREFERRED_SIZE, 33,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(kills2Titulo)
                                                .addGap(2, 2, 2)
                                                .addComponent(kills2Registro, GroupLayout.PREFERRED_SIZE, 33,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(deaths2Titulo)
                                                .addGap(2, 2, 2)
                                                .addComponent(deaths2Registro, GroupLayout.PREFERRED_SIZE, 33,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(assists2Titulo)
                                                .addGap(2, 2, 2)
                                                .addComponent(assists2Registro, GroupLayout.PREFERRED_SIZE, 33,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26,
                                        Short.MAX_VALUE)
                                .addComponent(registroPartidaBoton, GroupLayout.PREFERRED_SIZE, 42,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)));
    }


    public String getEquipo1() {
        return (String) equipo1Registro.getSelectedItem();
    }

    public String getFecha1() {
        return fecha1Registro.getText();
    }
    public String getRival1() { return (String) rival1Registro.getSelectedItem(); }
    public String getMarcador1() { return marcador1Registro.getText(); }
    public String getKills1() { return kills1Registro.getText(); }
    public String getDeaths1() { return deaths1Registro.getText(); }
    public String getAssists1() { return assists1Registro.getText(); }
    
    public String getEquipo2() { return (String) equipo2Registro.getSelectedItem(); }
    public String getFecha2() { return fecha2Registro.getText(); }
    public String getRival2() { return (String) rival2Registro.getSelectedItem(); }
    public String getMarcador2() { return marcador2Registro.getText(); }
    public String getKills2() { return kills2Registro.getText(); }
    public String getDeaths2() { return deaths2Registro.getText(); }
    public String getAssists2() { return assists2Registro.getText(); }

    public void limpiarCampos() {
        fecha1Registro.setText("");
        marcador1Registro.setText("");
    
}
}