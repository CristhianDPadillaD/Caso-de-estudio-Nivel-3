package umariana.cupi2.esports.interfaz;

import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBanner extends JPanel {

    public PanelBanner() {
        // 1. Configuración del panel
        this.setBackground(new Color(51, 0, 102));
        this.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        // 2. Creación de los componentes internos
        JLabel eSportsTitulo = new JLabel("ESports");
        eSportsTitulo.setFont(new Font("Bahnschrift", 1, 48));
        eSportsTitulo.setForeground(new Color(255, 255, 255));

        // 3. Definición del Layout (la organización de los componentes)
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(370, Short.MAX_VALUE)
                                .addComponent(eSportsTitulo)
                                .addContainerGap(370, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(eSportsTitulo, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                .addContainerGap()));
    }
}