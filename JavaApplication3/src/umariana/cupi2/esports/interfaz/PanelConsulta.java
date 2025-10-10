package umariana.cupi2.esports.interfaz;

import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import umariana.cupi2.esports.mundo.Equipo;
import umariana.cupi2.esports.mundo.Esports;
import umariana.cupi2.esports.mundo.Jugador;

public class PanelConsulta extends JPanel {

    private InterfazEsports principal;
    private JComboBox<String> EquipoConsulta;
    private JList<String> listaJugadores;
    private JButton back;
    private JButton refresh;

    public PanelConsulta(InterfazEsports principal, Esports esports) {
        this.principal = principal;
        setBackground(new Color(0, 51, 102));

        // Crear componentes
        JLabel titulo = new JLabel("CONSULTA EL REGISTRO DE JUGADORES");
        titulo.setFont(new Font("Bahnschrift", 1, 24));
        titulo.setForeground(Color.WHITE);

        JLabel labelEquipo = new JLabel("Selecciona el equipo del que quieres ver los jugadores");
        labelEquipo.setFont(new Font("Bahnschrift", 1, 18));
        labelEquipo.setForeground(Color.WHITE);

        EquipoConsulta = new JComboBox<>();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Equipo equipo : esports.getEquipos()) {
            model.addElement(equipo.getNombre());
        }
        EquipoConsulta.setModel(model);
        EquipoConsulta.addActionListener(e -> actualizarListaJugadores(esports));

        listaJugadores = new JList<>();
        JScrollPane scrollPane = new JScrollPane(listaJugadores);

        back = new JButton("Volver");
        back.addActionListener(e -> principal.mostrarPrincipal());

        refresh = new JButton("Refresh");
        refresh.addActionListener(e -> actualizarListaJugadores(esports));

        // Layout
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(120, 120, 120)
                            .addComponent(titulo))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(labelEquipo))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(200, 200, 200)
                            .addComponent(EquipoConsulta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(back)
                            .addGap(10, 10, 10)
                            .addComponent(refresh)))
                    .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(titulo)
                    .addGap(30, 30, 30)
                    .addComponent(labelEquipo)
                    .addGap(10, 10, 10)
                    .addComponent(EquipoConsulta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addComponent(back)
                    .addGap(10, 10, 10)
                    .addComponent(refresh)
                    .addContainerGap(50, Short.MAX_VALUE))
        );
    }

    private void actualizarListaJugadores(Esports esports) {
        String equipoSeleccionado = (String) EquipoConsulta.getSelectedItem();
        if (equipoSeleccionado != null) {
            Equipo equipo = esports.darEquipoPorNombre(equipoSeleccionado);
            if (equipo != null) {
                DefaultListModel<String> listModel = new DefaultListModel<>();
                for (Jugador jugador : equipo.getJugadores()) {
                    listModel.addElement(jugador.getNombre() + " (" + jugador.getNickname() + ")");
                }
                listaJugadores.setModel(listModel);
            }
        }
    }
}
