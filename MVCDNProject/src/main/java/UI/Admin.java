
package UI;

import DB.AdminDAO;
import DB.SerigraphyLaboratoryDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import Model.orders;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class Admin extends javax.swing.JFrame {

    private Connection conexion; 
    private DefaultTableModel tablaModel;
    private String nombreUsuario;
    
    public Admin(String usuario) {
        initComponents();
        lbUsuario.setText(nombreUsuario);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        tablaModel = (DefaultTableModel) tblAdmin.getModel();
        conexion = DB.conexion.getConexion();
        cargarTablasAlComboBox();
        String tablaSeleccionada = (String) seleccionTabla.getSelectedItem();
        cargarDatosDeTabla(tablaSeleccionada);
        actualizarTabla(tablaSeleccionada);
        // Asignar un modelo inicial al JComboBox (puede ser vacío o con valores por defecto)
        
        // Agregar un ActionListener al JComboBox para manejar eventos de selección si es necesario
        seleccionTabla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tablaSeleccionada = (String) seleccionTabla.getSelectedItem();
                limpiarTabla();
                cargarTabla();  
                cargarDatosDeTabla(tablaSeleccionada);
            }
        });
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Este código se ejecutará cuando la ventana esté a punto de cerrarse
                cerrarVentana();
            }
        });

        // Llamar al método para cargar las tablas en el JComboBox
        cargarTablasAlComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAdmin = new javax.swing.JTable();
        jButtonExit = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        seleccionTabla = new javax.swing.JComboBox<>();
        btnNuevoLab = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtOrder = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtProduct = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDone = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        btnModificar2 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminarLab = new javax.swing.JButton();
        adminUs = new javax.swing.JButton();
        lbUsuario = new javax.swing.JLabel();
        jLabelTitulo2 = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SerigraphyLaboratory");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Orden", "Producto", "Hechos", "Laboratorio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAdminMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAdmin);
        if (tblAdmin.getColumnModel().getColumnCount() > 0) {
            tblAdmin.getColumnModel().getColumn(0).setResizable(false);
            tblAdmin.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblAdmin.getColumnModel().getColumn(1).setResizable(false);
            tblAdmin.getColumnModel().getColumn(1).setPreferredWidth(8);
            tblAdmin.getColumnModel().getColumn(2).setResizable(false);
            tblAdmin.getColumnModel().getColumn(2).setPreferredWidth(8);
            tblAdmin.getColumnModel().getColumn(3).setResizable(false);
            tblAdmin.getColumnModel().getColumn(3).setPreferredWidth(8);
            tblAdmin.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 540, 290));

        jButtonExit.setBackground(new java.awt.Color(0, 0, 51));
        jButtonExit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExit.setText("Salir");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jButton2.setText("jButton2");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, -1));

        seleccionTabla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        seleccionTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionTablaActionPerformed(evt);
            }
        });
        jPanel2.add(seleccionTabla);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 430, 40));

        btnNuevoLab.setBackground(new java.awt.Color(0, 0, 51));
        btnNuevoLab.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNuevoLab.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoLab.setText("Nuevo Laboratorio");
        btnNuevoLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoLabActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevoLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 210, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Order :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        txtOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderActionPerformed(evt);
            }
        });
        jPanel1.add(txtOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 100, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Product :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        txtProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductActionPerformed(evt);
            }
        });
        jPanel1.add(txtProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 100, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Done :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        txtDone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDoneActionPerformed(evt);
            }
        });
        jPanel1.add(txtDone, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 100, -1));

        btnEliminar.setBackground(new java.awt.Color(0, 0, 51));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Delete");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 80, -1));

        btnLimpiar.setBackground(new java.awt.Color(0, 0, 51));
        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Clean");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 80, -1));

        jLabelTitulo.setBackground(new java.awt.Color(0, 0, 51));
        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(0, 0, 51));
        jLabelTitulo.setText("Serigraphy Laboratory");
        jPanel1.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        btnModificar2.setBackground(new java.awt.Color(0, 0, 51));
        btnModificar2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnModificar2.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar2.setText("Update");
        btnModificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 80, -1));

        btnGuardar.setBackground(new java.awt.Color(0, 0, 51));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Save");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 80, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 210, 290));

        btnEliminarLab.setBackground(new java.awt.Color(0, 0, 51));
        btnEliminarLab.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminarLab.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarLab.setText("Eliminar laboratorio");
        btnEliminarLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarLabActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminarLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 370, 210, -1));

        adminUs.setBackground(new java.awt.Color(0, 0, 51));
        adminUs.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminUs.setForeground(new java.awt.Color(255, 255, 255));
        adminUs.setText("Administrar usuarios");
        adminUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminUsActionPerformed(evt);
            }
        });
        getContentPane().add(adminUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 210, -1));

        lbUsuario.setBackground(new java.awt.Color(255, 255, 255));
        lbUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lbUsuario.setText("label");
        getContentPane().add(lbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, -1, -1));

        jLabelTitulo2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitulo2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo2.setText("Usuario:");
        getContentPane().add(jLabelTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, -1, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoAzul.png"))); // NOI18N
        jLabelFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarVentana() {
        this.setVisible(false);
    }
     
    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Desea cerrar sesión?", "Confirmación", JOptionPane.YES_NO_OPTION);
    
    if (confirmacion == JOptionPane.YES_OPTION) {
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
        }
    }//GEN-LAST:event_jButtonExitActionPerformed
    private void tblAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAdminMouseClicked
        int fila = tblAdmin.getSelectedRow();
        if (fila >= 0) {
        txtOrder.setText(tblAdmin.getValueAt(fila, 1).toString());
        txtProduct.setText(tblAdmin.getValueAt(fila, 2).toString());
        txtDone.setText(tblAdmin.getValueAt(fila, 3).toString());
        }
    }//GEN-LAST:event_tblAdminMouseClicked
    private void btnNuevoLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoLabActionPerformed
        nuevaTabla newWindow = new nuevaTabla(nombreUsuario);
        newWindow.setVisible(true);
    }//GEN-LAST:event_btnNuevoLabActionPerformed
    private void seleccionTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionTablaActionPerformed
        
    }//GEN-LAST:event_seleccionTablaActionPerformed
    private void txtOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderActionPerformed

    }//GEN-LAST:event_txtOrderActionPerformed
    private void txtProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductActionPerformed
    }//GEN-LAST:event_txtProductActionPerformed
    private void txtDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoneActionPerformed
    }//GEN-LAST:event_txtDoneActionPerformed
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada = tblAdmin.getSelectedRow();

        if (filaSeleccionada >= 0) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar la fila?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                int id =Integer.parseInt(txtOrder.getText());
                String tablaSeleccionada = (String) seleccionTabla.getSelectedItem();
                AdminDAO.borrar(id, tablaSeleccionada);
                tablaModel.removeRow(filaSeleccionada);
                cargarTabla();
                limpiar();
                actualizarTabla(tablaSeleccionada);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtOrder.setText("");
        txtProduct.setText("");
        txtDone.setText("");
        tblAdmin.clearSelection();
    }//GEN-LAST:event_btnLimpiarActionPerformed
    private void btnModificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar2ActionPerformed
        int Order =Integer.parseInt(txtOrder.getText());
        String Nombre = txtProduct.getText();
        int Hechos =Integer.parseInt(txtDone.getText());
        DefaultTableModel modeloTabla = (DefaultTableModel) tblAdmin.getModel();
        AdminDAO.editar(Order, Nombre, Hechos, (String) seleccionTabla.getSelectedItem());
        actualizarTabla((String) seleccionTabla.getSelectedItem());
    }//GEN-LAST:event_btnModificar2ActionPerformed

    private void btnEliminarLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarLabActionPerformed
         int confirmacion = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar toda la tabla?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            String tablaSeleccionada = (String) seleccionTabla.getSelectedItem();
            AdminDAO.eliminarTabla(tablaSeleccionada);
            cargarTabla();
            limpiar();
            
        }
    }//GEN-LAST:event_btnEliminarLabActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String tablaSeleccionada = (String) seleccionTabla.getSelectedItem();
        GuardarDatos();
        limpiar();
        actualizarTabla(tablaSeleccionada);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void adminUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminUsActionPerformed
        adminUsuarios admUsuarios = new adminUsuarios(nombreUsuario);
        admUsuarios.setVisible(true);
    }//GEN-LAST:event_adminUsActionPerformed

    void GuardarDatos(){
        String tabla = (String) seleccionTabla.getSelectedItem();
        int Orden = Integer.parseInt(txtOrder.getText());
        String Nombre = txtProduct.getText();
        int Hechos = Integer.parseInt(txtDone.getText());
        boolean respuesta = AdminDAO.RegistrarOrden(Nombre, Orden, Hechos,tabla);
        if(respuesta == true){
            JOptionPane.showMessageDialog(null,"Error al ingresar datos");
        }
    }
    
    private void cargarTablasAlComboBox() {
    try {
        DatabaseMetaData metaData = conexion.getMetaData();
        ResultSet resultSet = metaData.getTables(null, null, "%", null);
        List<String> nombresTablas = new ArrayList<>();
        while (resultSet.next()) {
            String nombreTabla = resultSet.getString("TABLE_NAME");
            nombresTablas.add(nombreTabla);
        }
        resultSet.close();
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(nombresTablas.toArray(new String[0]));
        seleccionTabla.setModel(comboBoxModel);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al cargar las tablas: " + ex.getMessage());
    }
}
    
    
    private void cargarDatosDeTabla(String tabla) {
    actualizarTabla(tabla);
    DefaultTableModel modelo = (DefaultTableModel) tblAdmin.getModel();
    modelo.fireTableDataChanged();
    }
    
    private void limpiarTabla() {
    DefaultTableModel modelo = (DefaultTableModel) tblAdmin.getModel();
    modelo.setRowCount(0);
    }
    
    private void limpiar(){
        tblAdmin.clearSelection();
    }
            
    private void cargarTabla(){
        SerigraphyLaboratoryDAO dao = new SerigraphyLaboratoryDAO();
        String tablaSeleccionada = (String) seleccionTabla.getSelectedItem();
        List<orders> lista = dao.Listarorders(tablaSeleccionada);

        DefaultTableModel modelo = (DefaultTableModel) tblAdmin.getModel();
        for (orders order : lista) {
            Object[] datos = {order.getOrders(), order.getProduct(), order.getDone()};
            modelo.addRow(datos);
        }
    }
  
    private void actualizarTabla(String tabla) {
    DefaultTableModel modeloTabla = (DefaultTableModel) tblAdmin.getModel();
    modeloTabla.setRowCount(0);

    try {
        Connection con = DB.conexion.getConexion();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM " + tabla);
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnas = rsmd.getColumnCount();

        // Configurar los anchos de las columnas dinámicamente
        int[] anchos = new int[columnas];
        for (int i = 0; i < columnas; i++) {
            tblAdmin.getColumnModel().getColumn(i).setPreferredWidth(0);
        }

        // Añadir las columnas al modelo de la tabla con los nombres de la tabla SQL
        modeloTabla.setColumnCount(0);
        for (int i = 1; i <= columnas; i++) {
            modeloTabla.addColumn(rsmd.getColumnName(i));
        }

        while (rs.next()) {
            Object[] fila = new Object[columnas];
            for (int i = 0; i < columnas; i++) {
                fila[i] = rs.getObject(i + 1);

                // Obtener el ancho preferido basado en el tamaño del contenido
                int anchoContenido = fila[i].toString().length() * 8;
                if (anchoContenido > anchos[i]) {
                    anchos[i] = anchoContenido;
                }
            }
            modeloTabla.addRow(fila);
        }

        // Aplicar los anchos obtenidos a las columnas
        for (int i = 0; i < columnas; i++) {
            tblAdmin.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

        tblAdmin.setModel(modeloTabla); // Establecer el modelo actualizado en la tabla

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.toString());
    }
}


    public void main(String[] args) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            new Admin(nombreUsuario).setVisible(true);
        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminUs;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarLab;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar2;
    private javax.swing.JButton btnNuevoLab;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTitulo2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JComboBox<String> seleccionTabla;
    private javax.swing.JTable tblAdmin;
    private javax.swing.JTextField txtDone;
    private javax.swing.JTextField txtOrder;
    private javax.swing.JTextField txtProduct;
    // End of variables declaration//GEN-END:variables
}
