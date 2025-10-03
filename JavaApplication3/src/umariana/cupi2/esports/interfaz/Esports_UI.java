/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package umariana.cupi2.esports.interfaz;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import umariana.cupi2.esports.mundo.DirectorEquipo;
import umariana.cupi2.esports.mundo.Equipo;
import umariana.cupi2.esports.mundo.Jugador;

/**
 *
 * @author Omar Salazar
 */

public class Esports_UI extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Esports_UI.class.getName());

    // ---------- ATRIBUTOS DE LÓGICA ----------
    private DirectorEquipo director;
    private ArrayList<Equipo> equipos; // ⚠ must be 'equipos' (lowercase)

    // ---------- CONSTRUCTORES ----------
    /**
     * Constructor vacío seguro (para NetBeans GUI builder / pruebas).
     */
    public Esports_UI() {
        this.director = null;
        this.equipos = new ArrayList<>();
        initComponents();
        // dejar el combo vacío (o con items de prueba si deseas)
        jComboBox1.removeAllItems();
    }

    /**
     * Constructor principal: recibe el director y la lista de equipos.
     */
    public Esports_UI(DirectorEquipo director, ArrayList<Equipo> equipos) {
        this.director = director;
        this.equipos = (equipos != null) ? equipos : new ArrayList<>();
        initComponents();

        // Quitar items por defecto del form y cargar equipos reales
        jComboBox1.removeAllItems();
        for (Equipo eq : this.equipos) {
            jComboBox1.addItem(eq.getNombre());
        }

        // Si quieres seleccionar por defecto el equipo que tiene el director:
        if (this.director != null && this.director.getEquipoAsignado() != null) {
            // intentar seleccionar el índice del equipo asignado
            String idAsignado = this.director.getEquipoAsignado().getIdEquipo();
            for (int i = 0; i < this.equipos.size(); i++) {
                if (this.equipos.get(i).getIdEquipo().equals(idAsignado)) {
                    jComboBox1.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane2 = new javax.swing.JEditorPane();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jEditorPane3 = new javax.swing.JEditorPane();
        jButton1 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jEditorPane4 = new javax.swing.JEditorPane();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Stencil", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de Jugadores");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 255)));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 310, 60));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Equipo a registrar->");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 170, 30));

        jEditorPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jEditorPane2.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        jScrollPane2.setViewportView(jEditorPane2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 310, 30));

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("NoMbre CoMpleto ->");
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 170, 30));

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("NICKNAME ->");
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 170, 30));

        jEditorPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jEditorPane3.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        jScrollPane3.setViewportView(jEditorPane3);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 310, 30));

        jButton1.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        jButton1.setText("rEGISTRAR");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 620, 140, 50));

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("CORREO ELECTRONICO->");
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 170, 30));

        jEditorPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jEditorPane4.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        jScrollPane4.setViewportView(jEditorPane4);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 310, 30));

        jComboBox1.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 442, 290, 30));

        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 550, 610));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Data/Imagenes/Fondo2.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1330, 1080));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        int index = jComboBox1.getSelectedIndex();
        if (index >= 0 && index < equipos.size()) {
            Equipo seleccionado = equipos.get(index);
            // Si quieres mantener la referencia en director:
            if (director != null) {
                director.setEquipoAsignado(seleccionado);
            }
            // para debugging rápido:
            System.out.println("Equipo seleccionado: " + seleccionado.getNombre() + " (id=" + seleccionado.getIdEquipo() + ")");
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String nombre = jEditorPane2.getText().trim();
            String nickname = jEditorPane3.getText().trim();
            String correo = jEditorPane4.getText().trim();

            if (nombre.isEmpty() || nickname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nombre y nickname son obligatorios.");
                return;
            }

            int idx = jComboBox1.getSelectedIndex();
            if (idx < 0 || idx >= equipos.size()) {
                JOptionPane.showMessageDialog(this, "Selecciona un equipo válido.");
                return;
            }

            Equipo seleccionado = equipos.get(idx);

            // IMPORTANTE: actualizar el equipo asignado al director para que la persistencia
            // en DirectorEquipo use el equipo correcto
            if (director != null) {
                director.setEquipoAsignado(seleccionado);
            }

            Jugador nuevo = new Jugador(null, seleccionado.getIdEquipo(), nombre, nickname, correo, 0, 0, 0);

            // La lógica de agregarJugador maneja validaciones y la persistencia en archivo
            if (director == null) {
                // si por alguna razón no hay director, añadimos en memoria directamente al equipo
                seleccionado.addJugador(nuevo);
            } else {
                director.agregarJugador(nuevo);
            }

            JOptionPane.showMessageDialog(this, "Jugador registrado correctamente en equipo: " + seleccionado.getNombre());

            // limpiar campos
            jEditorPane2.setText("");
            jEditorPane3.setText("");
            jEditorPane4.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Esports_UI().setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton jButton1;
    javax.swing.JComboBox<String> jComboBox1;
    javax.swing.JEditorPane jEditorPane2;
    javax.swing.JEditorPane jEditorPane3;
    javax.swing.JEditorPane jEditorPane4;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JPanel jPanel1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JScrollPane jScrollPane3;
    javax.swing.JScrollPane jScrollPane4;
    javax.swing.JTextField jTextField1;
    javax.swing.JTextField jTextField2;
    javax.swing.JTextField jTextField3;
    javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

}
