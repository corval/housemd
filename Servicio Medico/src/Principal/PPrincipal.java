/*
 * To change this template, choose Tools | Templates
 * and open the
template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on 10-feb-2009, 10:44:18
 */
package Principal;

import Recetas.Receta;
import Recetas.SeleccionarMedicina;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import inventario.*;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author papa
 */
public class PPrincipal extends javax.swing.JFrame {

    /** Creates new form NewJFrame */
    DefaultTableModel modelo;
    Object[][] arreglo;
    NuevoProducto nProducto;
    int cantidad;
    SeleccionarMedicina selecMed;
    Receta recetaActual;

    public PPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        actualizaTabla();
        recetaActual = new Receta(0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/housi.png")).getImage());
    }

    boolean hayItemSelecto() {
        if (jTable1.getSelectedRow() < 0) {
            return false;
        }
        return true;
    }

    void actualizaTabla() {
        Main.productos.BurbujasoSort();
        arreglo = new Object[Main.productos.getN()][3];
        for (int i = 1, j = 0; i <= Main.productos.getN(); i++, j++) {
            arreglo[j][0] = Main.productos.getProductos()[i].getNombre();
            arreglo[j][1] = Main.productos.getProductos()[i].getNumCodigoBarras();
            arreglo[j][2] = Main.productos.getProductos()[i].getCantidad();
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(arreglo,
                new String[]{
                    "Nombre", "Codigo de Barras", "En Existencia"
                }) {

            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean[]{
                true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
    }

    void actualizaLista() {
        AProductos auxPro;
        DefaultListModel aux = new DefaultListModel();
        String[] medi = new String[10002];
        auxPro = recetaActual.getMedicamentos();
        auxPro.BurbujasoSort();
        for(int i = 1; i <= auxPro.getN(); i++){
            aux.addElement("( " + auxPro.getProductos()[i].getCantidad() + " ) " + auxPro.getProductos()[i].getNombre());
        }
        listMed.setModel(aux);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        paneles = new javax.swing.JTabbedPane();
        panelInventario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        panelReceta = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jTextField9 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listMed = new javax.swing.JList();
        btnAgregarMedicinaAReceta = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuArchivo = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        MenuInventario = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        MenuAyuda = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jLabel9.setText("Presion Arterial:");

        jLabel10.setText("Frec. Cardiaca:");

        jTextField8.setEditable(false);

        jTextField7.setEditable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dr. House");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                cerrar(evt);
            }
        });

        paneles.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Codigo de Barras", "En Existencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCellSelectionEnabled(true);
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Busqueda: ");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscar(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscar(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Codigo de Barras" }));

        javax.swing.GroupLayout panelInventarioLayout = new javax.swing.GroupLayout(panelInventario);
        panelInventario.setLayout(panelInventarioLayout);
        panelInventarioLayout.setHorizontalGroup(
            panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInventarioLayout.createSequentialGroup()
                .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInventarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelInventarioLayout.setVerticalGroup(
            panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInventarioLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        paneles.addTab("Inventario", panelInventario);

        panelReceta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelRecetaFocusGained(evt);
            }
        });

        jLabel2.setText("Boleta:");

        jButton1.setText("Buscar Historial");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Signos Vitales"));

        jLabel3.setText("Estatura:");

        jTextField3.setEditable(false);

        jLabel4.setText("Peso:");

        jTextField4.setEditable(false);

        jTextField5.setEditable(false);

        jLabel5.setText("Presion Arterial:");

        jLabel6.setText("Frec. Cardiaca:");

        jTextField6.setEditable(false);

        jButton3.setText("Ver Hist. Completo");

        jTextField9.setEditable(false);

        jLabel8.setText("Temperatura:");

        jLabel11.setText("Frec. Respiratoria:");

        jTextField10.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                            .addComponent(jTextField6)
                            .addComponent(jTextField10)))
                    .addComponent(jButton3))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextField3, jTextField4, jTextField9});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3))
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripción"));

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setTabSize(3);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder("Medicamentos"));

        listMed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                listMedKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(listMed);

        btnAgregarMedicinaAReceta.setText("Agregar");
        btnAgregarMedicinaAReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMedicinaARecetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(btnAgregarMedicinaAReceta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarMedicinaAReceta)
                .addContainerGap())
        );

        jButton5.setText("Imprimir");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRecetaLayout = new javax.swing.GroupLayout(panelReceta);
        panelReceta.setLayout(panelRecetaLayout);
        panelRecetaLayout.setHorizontalGroup(
            panelRecetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRecetaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRecetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRecetaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRecetaLayout.createSequentialGroup()
                        .addGroup(panelRecetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(7, 7, 7)
                        .addGroup(panelRecetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRecetaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                .addComponent(jButton5)
                                .addGap(46, 46, 46))
                            .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panelRecetaLayout.setVerticalGroup(
            panelRecetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRecetaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRecetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRecetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRecetaLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRecetaLayout.createSequentialGroup()
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)))
                .addContainerGap())
        );

        paneles.addTab("Receta", panelReceta);

        paneles.setBounds(10, 10, 588, 370);
        jLayeredPane1.add(paneles, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/SerMed.png"))); // NOI18N
        jLabel7.setText("Esta Mierda");
        jLabel7.setBounds(10, 50, 60, 330);
        jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        MenuArchivo.setText("Archivo");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Salir(evt);
            }
        });
        MenuArchivo.add(jMenuItem3);

        jMenuBar1.add(MenuArchivo);

        MenuInventario.setText("Inventario");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Nuevo Producto");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MenuInventario.add(jMenuItem1);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Eliminar Producto Seleccionado");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar(evt);
            }
        });
        MenuInventario.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Agregar Cantidad a Seleccionado");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar(evt);
            }
        });
        MenuInventario.add(jMenuItem5);

        jMenuBar1.add(MenuInventario);

        MenuAyuda.setText("Ayuda");

        jMenuItem2.setText("Acerca de..");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Acerca(evt);
            }
        });
        MenuAyuda.add(jMenuItem2);

        jMenuBar1.add(MenuAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Acerca(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Acerca
        new Creditos(this, true).setVisible(true);
    }//GEN-LAST:event_Acerca

    private void Salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salir
        System.exit(0);
    }//GEN-LAST:event_Salir

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        nProducto = new NuevoProducto(this, true);
        nProducto.setVisible(true);
        if (nProducto.creado) {
            Main.productos.nuevoProducto(nProducto.res.getNombre(), nProducto.res.getNumCodigoBarras(), nProducto.res.getCantidad());
        }
        actualizaTabla();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void eliminar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar
        /*                Producto cam = Main.productos.getProductos()[jTable1.getSelectedRow() - 1];
        if(jTable1.getSelectedColumn() == 0){
        Main.productos.modificaProducto(jTable1.getSelectedRow() - 1, cam.getNumCodigoBarras(), jTable1.getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn()).toString(), cam.getCantidad());
        }
        if(jTable1.getSelectedColumn() == 1){
        Main.productos.modificaProducto(jTable1.getSelectedRow() - 1, jTable1.getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn()).toString(), cam.getNombre(), cam.getCantidad());
        }
        actualizaTabla();
         * */
        if (hayItemSelecto()) {
            if (jTable1.getSelectedColumn() >= 0 && jTable1.getSelectedRow() >= 0) {
                for (int i = jTable1.getSelectedRow() + 1; i <= jTable1.getSelectedRow() + jTable1.getSelectedRowCount(); i++) {
                    Main.productos.eliminarProducto(i);
                }
                actualizaTabla();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un item");
        }
    }//GEN-LAST:event_eliminar

    private void agregar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar
        if (hayItemSelecto()) {
            String res = JOptionPane.showInputDialog(this, "¿Cuanto deseas incrementar?", "Incrementar Cantidad", JOptionPane.QUESTION_MESSAGE);
            try {
                cantidad = Integer.parseInt(res);
                for (int i = jTable1.getSelectedRow() + 1; i <= jTable1.getSelectedRow() + jTable1.getSelectedRowCount(); i++) {
                    Main.productos.aniadirCantidad(i, cantidad);
                }
                actualizaTabla();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Deben de ser numeros");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un item");
        }
    }//GEN-LAST:event_agregar

    private void buscar(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscar
        String palbus = jTextField1.getText();
        if (palbus.length() == 0) {
            jTable1.clearSelection();
            return;
        }
        for (int i = 1; i <= Main.productos.getN(); i++) {
            if (jComboBox1.getSelectedIndex() == 0) {
                if (Main.productos.regresaPosProductoPorNombre(palbus) > 0) {
                    jTable1.changeSelection(Main.productos.regresaPosProductoPorNombre(palbus) - 1, 0, false, false);
                }
            } else {
                if (Main.productos.regresaPosProductoPorCodigoBarras(palbus) > 0) {
                    jTable1.changeSelection(Main.productos.regresaPosProductoPorCodigoBarras(palbus) - 1, 1, false, false);
                }
            }
        }
}//GEN-LAST:event_buscar

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
        try {
            if (hayItemSelecto()) {
                Producto cam = Main.productos.getProductos()[jTable1.getSelectedRow() + 1];
                if (jTable1.getSelectedColumn() == 0) {
                    Main.productos.modificaProducto(jTable1.getSelectedRow() + 1, cam.getNumCodigoBarras(), jTable1.getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn()).toString(), cam.getCantidad());
                }
                if (jTable1.getSelectedColumn() == 1) {
                    Main.productos.modificaProducto(jTable1.getSelectedRow() + 1, jTable1.getValueAt(jTable1.getSelectedRow(), jTable1.getSelectedColumn()).toString(), cam.getNombre(), cam.getCantidad());
                }
                actualizaTabla();
            }
        } catch (Exception e) {
        }
}//GEN-LAST:event_jTable1PropertyChange

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        JOptionPane.showMessageDialog(this, "Espere, un momento, \nla impresora esta saturada.");
    }//GEN-LAST:event_jButton5MouseClicked

    private void panelRecetaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelRecetaFocusGained
        // TODO add your handling code here:
}//GEN-LAST:event_panelRecetaFocusGained

    private void btnAgregarMedicinaARecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMedicinaARecetaActionPerformed
        selecMed = new SeleccionarMedicina(this, true, Main.productos);
        selecMed.setVisible(true);
        if (selecMed.elegido) {
            recetaActual.getMedicamentos().nuevoProducto(selecMed.prodSeleccionado.getNumCodigoBarras(), selecMed.prodSeleccionado.getNombre(), selecMed.prodSeleccionado.getCantidad());
            actualizaLista();
        }
    }//GEN-LAST:event_btnAgregarMedicinaARecetaActionPerformed

    private void listMedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listMedKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_DELETE && listMed.getSelectedIndex() != -1){
            recetaActual.getMedicamentos().eliminarProducto(listMed.getSelectedIndex());
            actualizaLista();
        }
    }//GEN-LAST:event_listMedKeyReleased

    private void cerrar(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_cerrar
        Main.guardaUsuarios();
        Main.guardaProductos();
    }//GEN-LAST:event_cerrar

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuArchivo;
    private javax.swing.JMenu MenuAyuda;
    private javax.swing.JMenu MenuInventario;
    private javax.swing.JButton btnAgregarMedicinaAReceta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JList listMed;
    private javax.swing.JPanel panelInventario;
    private javax.swing.JPanel panelReceta;
    private javax.swing.JTabbedPane paneles;
    // End of variables declaration//GEN-END:variables
}
