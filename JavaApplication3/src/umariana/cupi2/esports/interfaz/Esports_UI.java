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
        jTextField5 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField14 = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextArea9 = new javax.swing.JTextArea();
        jTextField15 = new javax.swing.JTextField();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTextArea10 = new javax.swing.JTextArea();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextArea11 = new javax.swing.JTextArea();
        jTextField18 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jTextField16 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextArea12 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jTextField17 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registro de partidas");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 255)));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 310, 60));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(102, 0, 102));
        jTextField1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
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
        jTextField2.setBackground(new java.awt.Color(102, 0, 102));
        jTextField2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
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
        jTextField3.setBackground(new java.awt.Color(102, 0, 102));
        jTextField3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
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

        jButton1.setBackground(new java.awt.Color(204, 0, 255));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Registrar");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 620, 140, 50));

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(102, 0, 102));
        jTextField4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
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

        jComboBox1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 442, 290, 30));

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(102, 0, 102));
        jTextField5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setText("Equipo 1");
        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, 70, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, 300, 30));

        jComboBox2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 130, 300, 30));

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(102, 0, 102));
        jTextField6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setText("Fecha");
        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 70, 30));

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(102, 0, 102));
        jTextField7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setText("Rival");
        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, 70, 30));

        jTextField8.setEditable(false);
        jTextField8.setBackground(new java.awt.Color(102, 0, 102));
        jTextField8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 13)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(255, 255, 255));
        jTextField8.setText("Marcador");
        jTextField8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 250, 90, 30));

        jTextField9.setEditable(false);
        jTextField9.setBackground(new java.awt.Color(102, 0, 102));
        jTextField9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(255, 255, 255));
        jTextField9.setText("Kills");
        jTextField9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jPanel1.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 70, 30));

        jTextField10.setEditable(false);
        jTextField10.setBackground(new java.awt.Color(102, 0, 102));
        jTextField10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(255, 255, 255));
        jTextField10.setText("Deaths");
        jTextField10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jPanel1.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 330, 70, 30));

        jTextField11.setEditable(false);
        jTextField11.setBackground(new java.awt.Color(102, 0, 102));
        jTextField11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 13)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(255, 255, 255));
        jTextField11.setText("Assists");
        jTextField11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jPanel1.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 370, 70, 30));

        jTextField12.setEditable(false);
        jTextField12.setBackground(new java.awt.Color(102, 0, 102));
        jTextField12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(255, 255, 255));
        jTextField12.setText("Equipo 2");
        jTextField12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, 70, 30));

        jTextField13.setEditable(false);
        jTextField13.setBackground(new java.awt.Color(102, 0, 102));
        jTextField13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jTextField13.setForeground(new java.awt.Color(255, 255, 255));
        jTextField13.setText("Fecha");
        jTextField13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jPanel1.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 460, 70, 30));

        jComboBox3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 420, 300, 30));

        jTextField14.setEditable(false);
        jTextField14.setBackground(new java.awt.Color(102, 0, 102));
        jTextField14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jTextField14.setForeground(new java.awt.Color(255, 255, 255));
        jTextField14.setText("Rival");
        jTextField14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jPanel1.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 500, 70, 30));

        jTextArea7.setColumns(20);
        jTextArea7.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        jTextArea7.setRows(5);
        jTextArea7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jScrollPane10.setViewportView(jTextArea7);

        jPanel1.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 460, 300, 30));

        jTextArea6.setColumns(20);
        jTextArea6.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        jTextArea6.setRows(5);
        jTextArea6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jScrollPane9.setViewportView(jTextArea6);

        jPanel1.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 370, 300, 30));

        jTextArea5.setColumns(20);
        jTextArea5.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        jTextArea5.setRows(5);
        jTextArea5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jScrollPane8.setViewportView(jTextArea5);

        jPanel1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 330, 300, 30));

        jTextArea9.setColumns(20);
        jTextArea9.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        jTextArea9.setRows(5);
        jTextArea9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jScrollPane12.setViewportView(jTextArea9);

        jPanel1.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 540, 300, 30));

        jTextField15.setEditable(false);
        jTextField15.setBackground(new java.awt.Color(102, 0, 102));
        jTextField15.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 11)); // NOI18N
        jTextField15.setForeground(new java.awt.Color(255, 255, 255));
        jTextField15.setText("Marcador");
        jTextField15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jPanel1.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 540, 70, 30));

        jTextArea10.setColumns(20);
        jTextArea10.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        jTextArea10.setRows(5);
        jTextArea10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jScrollPane13.setViewportView(jTextArea10);

        jPanel1.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 580, 300, 30));

        jTextArea11.setColumns(20);
        jTextArea11.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        jTextArea11.setRows(5);
        jTextArea11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jScrollPane14.setViewportView(jTextArea11);

        jPanel1.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 620, 300, 30));

        jTextField18.setEditable(false);
        jTextField18.setBackground(new java.awt.Color(102, 0, 102));
        jTextField18.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jTextField18.setForeground(new java.awt.Color(255, 255, 255));
        jTextField18.setText("Assists");
        jTextField18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jPanel1.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 660, 70, 30));

        jComboBox4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jPanel1.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 210, 300, 30));

        jComboBox5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jPanel1.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 500, 300, 30));

        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        jTextArea4.setRows(5);
        jTextArea4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jScrollPane7.setViewportView(jTextArea4);

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 290, 300, 30));

        jTextField16.setEditable(false);
        jTextField16.setBackground(new java.awt.Color(102, 0, 102));
        jTextField16.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jTextField16.setForeground(new java.awt.Color(255, 255, 255));
        jTextField16.setText("Kills");
        jTextField16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jPanel1.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 580, 70, 30));

        jButton3.setBackground(new java.awt.Color(204, 0, 255));
        jButton3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Registrar");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 720, 120, 30));

        jTextArea12.setColumns(20);
        jTextArea12.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        jTextArea12.setRows(5);
        jTextArea12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jScrollPane15.setViewportView(jTextArea12);

        jPanel1.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 660, 300, 30));

        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Stencil", 2, 14)); // NOI18N
        jTextArea3.setRows(5);
        jTextArea3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jScrollPane6.setViewportView(jTextArea3);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 250, 300, 30));

        jTextField17.setEditable(false);
        jTextField17.setBackground(new java.awt.Color(102, 0, 102));
        jTextField17.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 14)); // NOI18N
        jTextField17.setForeground(new java.awt.Color(255, 255, 255));
        jTextField17.setText("Deaths");
        jTextField17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jPanel1.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 620, 70, 30));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 2, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Registro de Jugadores");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 255)));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 310, 60));

        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 550, 660));

        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 255)));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 550, 610));

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
            // Leer datos de los campos
            String nombre = jEditorPane2.getText().trim();
            String nickname = jEditorPane3.getText().trim();
            String correo = jEditorPane4.getText().trim();

            // Validaciones básicas
            if (nombre.isEmpty() || nickname.isEmpty() || correo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor completa todos los campos antes de registrar.");
                return;
            }

            // Verificar selección de equipo
            int idx = jComboBox1.getSelectedIndex();
            if (idx < 0 || idx >= equipos.size()) {
                JOptionPane.showMessageDialog(this, "Selecciona un equipo válido.");
                return;
            }

            Equipo equipoSeleccionado = equipos.get(idx);

            // Crear un nuevo jugador (con estadísticas iniciales en 0)
            Jugador nuevoJugador = new Jugador(
                    null, // ID (puedes generarlo automático en Jugador)
                    equipoSeleccionado.getIdEquipo(), // ID del equipo
                    nombre,
                    nickname,
                    correo,
                    0, 0, 0 // Kills, Deaths, Assists
            );

            // Registrar jugador
            if (director != null) {
                // Se usa la lógica del DirectorEquipo (que guarda el jugador en archivo)
                director.agregarJugador(nuevoJugador);
            } else {
                // Si no hay director, se agrega directamente al equipo en memoria
                equipoSeleccionado.addJugador(nuevoJugador);
            }

            // Confirmar éxito
            JOptionPane.showMessageDialog(this,
                    "✅ Jugador registrado correctamente en el equipo: " + equipoSeleccionado.getNombre(),
                    "Registro exitoso",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // Limpiar los campos de texto
            jEditorPane2.setText("");
            jEditorPane3.setText("");
            jEditorPane4.setText("");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "❌ Error al registrar el jugador: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

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
    javax.swing.JButton jButton3;
    javax.swing.JComboBox<String> jComboBox1;
    javax.swing.JComboBox<String> jComboBox2;
    javax.swing.JComboBox<String> jComboBox3;
    javax.swing.JComboBox<String> jComboBox4;
    javax.swing.JComboBox<String> jComboBox5;
    javax.swing.JEditorPane jEditorPane2;
    javax.swing.JEditorPane jEditorPane3;
    javax.swing.JEditorPane jEditorPane4;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    javax.swing.JPanel jPanel1;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane10;
    javax.swing.JScrollPane jScrollPane12;
    javax.swing.JScrollPane jScrollPane13;
    javax.swing.JScrollPane jScrollPane14;
    javax.swing.JScrollPane jScrollPane15;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JScrollPane jScrollPane3;
    javax.swing.JScrollPane jScrollPane4;
    javax.swing.JScrollPane jScrollPane6;
    javax.swing.JScrollPane jScrollPane7;
    javax.swing.JScrollPane jScrollPane8;
    javax.swing.JScrollPane jScrollPane9;
    javax.swing.JTextArea jTextArea1;
    javax.swing.JTextArea jTextArea10;
    javax.swing.JTextArea jTextArea11;
    javax.swing.JTextArea jTextArea12;
    javax.swing.JTextArea jTextArea3;
    javax.swing.JTextArea jTextArea4;
    javax.swing.JTextArea jTextArea5;
    javax.swing.JTextArea jTextArea6;
    javax.swing.JTextArea jTextArea7;
    javax.swing.JTextArea jTextArea9;
    javax.swing.JTextField jTextField1;
    javax.swing.JTextField jTextField10;
    javax.swing.JTextField jTextField11;
    javax.swing.JTextField jTextField12;
    javax.swing.JTextField jTextField13;
    javax.swing.JTextField jTextField14;
    javax.swing.JTextField jTextField15;
    javax.swing.JTextField jTextField16;
    javax.swing.JTextField jTextField17;
    javax.swing.JTextField jTextField18;
    javax.swing.JTextField jTextField2;
    javax.swing.JTextField jTextField3;
    javax.swing.JTextField jTextField4;
    javax.swing.JTextField jTextField5;
    javax.swing.JTextField jTextField6;
    javax.swing.JTextField jTextField7;
    javax.swing.JTextField jTextField8;
    javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables

}
