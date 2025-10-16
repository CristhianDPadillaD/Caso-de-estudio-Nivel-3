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

public class PanelPromedioVictorias extends JPanel {

    private InterfazEsports principal;
    private JComboBox<String> comboEquipos;
    private JList<String> listaResultado;
    private JButton back;
    private JButton calcular;

    public PanelPromedioVictorias(InterfazEsports principal, Esports esports) {
        this.principal = principal;
        setBackground(new Color(0, 51, 102));

        // Crear componentes
        JLabel titulo = new JLabel("PROMEDIO DE VICTORIAS POR EQUIPO");
        titulo.setFont(new Font("Bahnschrift", 1, 24));
        titulo.setForeground(Color.WHITE);

        JLabel labelEquipo = new JLabel("Selecciona el equipo:");
        labelEquipo.setFont(new Font("Bahnschrift", 1, 18));
        labelEquipo.setForeground(Color.WHITE);

        comboEquipos = new JComboBox<>();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (Equipo equipo : esports.getEquipos()) {
            model.addElement(equipo.getNombre());
        }
        comboEquipos.setModel(model);

        listaResultado = new JList<>();
        JScrollPane scrollPane = new JScrollPane(listaResultado);

        back = new JButton("Volver");
        back.addActionListener(e -> principal.mostrarConsulta());

        calcular = new JButton("Calcular");
        calcular.addActionListener(e -> calcularPromedio(esports));

        // Layout
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(titulo))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(300, 300, 300)
                            .addComponent(labelEquipo))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(350, 350, 350)
                            .addComponent(comboEquipos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(250, 250, 250)
                            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(300, 300, 300)
                            .addComponent(back)
                            .addGap(20, 20, 20)
                            .addComponent(calcular)))
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
                    .addComponent(comboEquipos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(back)
                        .addComponent(calcular))
                    .addContainerGap(50, Short.MAX_VALUE))
        );
    }

    private void calcularPromedio(Esports esports) {
        String equipoSeleccionado = (String) comboEquipos.getSelectedItem();
        if (equipoSeleccionado != null) {
            Equipo equipo = esports.darEquipoPorNombre(equipoSeleccionado);
            if (equipo != null) {
                double promedio = equipo.promedioVictorias();
                DefaultListModel<String> modelResultado = new DefaultListModel<>();
                modelResultado.addElement("Equipo: " + equipo.getNombre());
                modelResultado.addElement("Promedio de Victorias: " + String.format("%.2f", promedio));
                listaResultado.setModel(modelResultado);
            }
        }
    }
}
