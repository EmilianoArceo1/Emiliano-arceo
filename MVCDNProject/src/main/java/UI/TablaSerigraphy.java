
package UI;

import Controler.PuenteDBV;
import static Controler.PuenteDBV.puenteBorrar;
import DB.AdminDAO;
import DB.SerigraphyLaboratoryDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import Model.orders;

public class TablaSerigraphy extends javax.swing.JFrame {

    private DefaultTableModel tablaModel;
    private String laboratorioActual;
    private String user;
    private int nivelPermisos;

    public TablaSerigraphy(String laboratorio, int permisos, String usuario) {
        initComponents();
        this.user = usuario;
        nivelPermisos = permisos;
        configurarPermisos();
        this.setLocationRelativeTo(null);
        this.laboratorioActual = laboratorio;
        lbUsuarioName.setText(user);
        labelLab.setText(laboratorioActual);
        tablaModel = (DefaultTableModel) tblSerigraphy.getModel();
        cargarTabla();
        actualizarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSerigraphy = new javax.swing.JTable();
        jButtonExit = new javax.swing.JButton();
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
        labelLab = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnRecargar = new javax.swing.JButton();
        labelLab1 = new javax.swing.JLabel();
        lbUsuarioName = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SerigraphyLaboratory");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSerigraphy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "NumOrder", "NumProduct", "NumDone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
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
        tblSerigraphy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSerigraphyMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSerigraphy);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 250, 290));

        jButtonExit.setBackground(new java.awt.Color(0, 0, 51));
        jButtonExit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExit.setText("Salir");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Order :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        txtOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderActionPerformed(evt);
            }
        });
        jPanel1.add(txtOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 100, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Product :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        txtProduct.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductActionPerformed(evt);
            }
        });
        jPanel1.add(txtProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 100, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Done :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        txtDone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDoneActionPerformed(evt);
            }
        });
        jPanel1.add(txtDone, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 100, -1));

        btnEliminar.setBackground(new java.awt.Color(0, 0, 51));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Delete");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 80, -1));

        btnLimpiar.setBackground(new java.awt.Color(0, 0, 51));
        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Clean");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 80, -1));

        jLabelTitulo.setBackground(new java.awt.Color(0, 0, 51));
        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(0, 0, 51));
        jLabelTitulo.setText("Laboratory");
        jPanel1.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        btnModificar2.setBackground(new java.awt.Color(0, 0, 51));
        btnModificar2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnModificar2.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar2.setText("Update");
        btnModificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 80, -1));

        labelLab.setBackground(new java.awt.Color(0, 0, 51));
        labelLab.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelLab.setForeground(new java.awt.Color(0, 0, 51));
        labelLab.setText("label");
        jPanel1.add(labelLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        btnCreate.setBackground(new java.awt.Color(0, 0, 51));
        btnCreate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        jPanel1.add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 80, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 210, 340));

        jButton2.setText("jButton2");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, -1));

        btnRecargar.setBackground(new java.awt.Color(0, 0, 51));
        btnRecargar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRecargar.setForeground(new java.awt.Color(255, 255, 255));
        btnRecargar.setText("Refresh");
        btnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRecargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 90, -1));

        labelLab1.setBackground(new java.awt.Color(0, 0, 51));
        labelLab1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelLab1.setForeground(new java.awt.Color(255, 255, 255));
        labelLab1.setText("Usuario: ");
        getContentPane().add(labelLab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, -1, -1));

        lbUsuarioName.setBackground(new java.awt.Color(0, 0, 51));
        lbUsuarioName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbUsuarioName.setForeground(new java.awt.Color(255, 255, 255));
        lbUsuarioName.setText("Usuario: ");
        getContentPane().add(lbUsuarioName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, -1, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoAzul.png"))); // NOI18N
        jLabelFondo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Desea cerrar sesión?", "Confirmación", JOptionPane.YES_NO_OPTION);
    Login login = new Login();
    if (confirmacion == JOptionPane.YES_OPTION) {
        login.setVisible(true);
        this.dispose(); // Cierra la interfaz actual
        }
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void txtOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderActionPerformed
        
    }//GEN-LAST:event_txtOrderActionPerformed

    private void txtProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductActionPerformed
        
    }//GEN-LAST:event_txtProductActionPerformed

    private void txtDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoneActionPerformed

    }//GEN-LAST:event_txtDoneActionPerformed

    private void tblSerigraphyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSerigraphyMouseClicked
         int fila = tblSerigraphy.getSelectedRow();
        if (fila >= 0) {
            txtOrder.setText(tblSerigraphy.getValueAt(fila, 0).toString());
            txtProduct.setText(tblSerigraphy.getValueAt(fila, 1).toString());
            txtDone.setText(tblSerigraphy.getValueAt(fila, 2).toString());
        }
    }//GEN-LAST:event_tblSerigraphyMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       int filaSeleccionada = tblSerigraphy.getSelectedRow();

        if (filaSeleccionada >= 0) {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar la fila?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                int id = Integer.parseInt(txtOrder.getText());
                puenteBorrar(id, laboratorioActual);
                tablaModel.removeRow(filaSeleccionada);
                cargarTabla();
                limpiar();
                actualizarTabla();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void configurarPermisos() {
        switch (nivelPermisos) {
            case 1:
                // Nivel 1: Solo puede ver la tabla y salir
                btnEliminar.setVisible(false);
                btnLimpiar.setVisible(false);
                btnModificar2.setVisible(false);
                btnCreate.setVisible(false);
                break;
            case 2:
                // Nivel 2: Puede actualizar ordenes, pero no borrar ni crear
                btnEliminar.setVisible(false);
                btnCreate.setVisible(false);
                break;
            case 3:
                // Nivel 3: Puede hacer todo
                break;
            default:
                // Nivel no reconocido, ocultar todo por precaución
                btnEliminar.setVisible(false);
                btnLimpiar.setVisible(false);
                btnModificar2.setVisible(false);
                btnCreate.setVisible(false);
                break;
        }
    }
    private void limpiar(){
        txtOrder.setText("");
        txtProduct.setText("");
        txtDone.setText("");
        tblSerigraphy.clearSelection();
    }
    
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtOrder.setText("");
        txtProduct.setText("");
        txtDone.setText("");
        tblSerigraphy.clearSelection();
        limpiarTablaEnDAO();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarActionPerformed
        limpiarTablaEnDAO();
        actualizarTabla();
    }//GEN-LAST:event_btnRecargarActionPerformed

    private void btnModificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar2ActionPerformed
        int Order = Integer.parseInt(txtOrder.getText());
        String Nombre = txtProduct.getText();
        int Hechos = Integer.parseInt(txtDone.getText());
        DefaultTableModel modeloTabla = (DefaultTableModel) tblSerigraphy.getModel();
        PuenteDBV.puenteEditar(Order, Nombre, Hechos, laboratorioActual);
        actualizarTabla();
    }//GEN-LAST:event_btnModificar2ActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        GuardarDatos();
        limpiar();
        actualizarTabla();
    }//GEN-LAST:event_btnCreateActionPerformed
    
    void GuardarDatos(){
        int Orden = Integer.parseInt(txtOrder.getText());
        String Nombre = txtProduct.getText();
        int Hechos = Integer.parseInt(txtDone.getText());
        boolean respuesta = AdminDAO.RegistrarOrden(Nombre, Orden, Hechos,laboratorioActual);
        if(respuesta == false){
            JOptionPane.showMessageDialog(null,"Error al ingresar datos");
        }
    }
    
    private void limpiarTablaEnDao(){
        SerigraphyLaboratoryDAO dao = new SerigraphyLaboratoryDAO();
        dao.limpiarTabla(laboratorioActual);
    }
    
    private void cargarTabla(){
        limpiarTablaEnDAO();
        SerigraphyLaboratoryDAO dao = new SerigraphyLaboratoryDAO();
        List<orders> lista = dao.Listarorders(laboratorioActual);

        DefaultTableModel modelo = (DefaultTableModel) tblSerigraphy.getModel();
        for (orders order : lista) {
            Object[] datos = {order.getOrders(), order.getProduct(), order.getDone()};
            modelo.addRow(datos);
        }
    }

    private void limpiarTablaEnDAO() {
     
    }
    
    private void actualizarTabla(){
        DefaultTableModel modeloTabla = (DefaultTableModel) tblSerigraphy.getModel();
        PuenteDBV.puenteActualizar(modeloTabla, laboratorioActual);
    }

    public static void main(String[] args) {
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar2;
    private javax.swing.JButton btnRecargar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelLab;
    private javax.swing.JLabel labelLab1;
    private javax.swing.JLabel lbUsuarioName;
    private javax.swing.JTable tblSerigraphy;
    private javax.swing.JTextField txtDone;
    private javax.swing.JTextField txtOrder;
    private javax.swing.JTextField txtProduct;
    // End of variables declaration//GEN-END:variables
}
