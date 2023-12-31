
package UI;

import Controler.LoginManager;
import DB.conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {
    private String labNombreUsuario;
    
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmarCierre();
            }
        });
    }
    
    private void confirmarCierre() {
        int confirmacion = JOptionPane.showConfirmDialog(Login.this, "¿Desea cerrar el programa?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            Login.this.dispose(); // Cierra la interfaz actual

            // Cierra la aplicación cuando se cierra la ventana de Login
            System.exit(0);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabelIcono = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();
        jButtonSesion = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jLabelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/User.png"))); // NOI18N
        getContentPane().add(jLabelIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario : ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        jTextFieldUser.setBackground(new java.awt.Color(0, 0, 51));
        jTextFieldUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldUser.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUserActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 160, 20));

        jPassword.setBackground(new java.awt.Color(0, 0, 51));
        jPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPassword.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 160, -1));

        jButtonSesion.setBackground(new java.awt.Color(0, 0, 51));
        jButtonSesion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonSesion.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSesion.setText("Iniciar Sesión");
        jButtonSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSesionActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, -1, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoAzul.png"))); // NOI18N
        jLabelFondo.setText(" ");
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Desea cerrar el programa?", "Confirmación", JOptionPane.YES_NO_OPTION);
    
    if (confirmacion == JOptionPane.YES_OPTION) {
        this.dispose(); // Cierra la interfaz actual
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUserActionPerformed
 
    }//GEN-LAST:event_jTextFieldUserActionPerformed

    private void jButtonSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSesionActionPerformed
        String usuario = jTextFieldUser.getText();
        String contraseña = new String(jPassword.getPassword());

        int nivelPermisos = obtenerNivelPermisos(usuario, contraseña);

        if (nivelPermisos > 0) {
            labNombreUsuario = obtenerLabNombre(usuario); // Debes implementar esta función
            abrirVentanaSegunPermisos(usuario, nivelPermisos, labNombreUsuario);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null,"No existe el usuario");
        }
    }//GEN-LAST:event_jButtonSesionActionPerformed

    private String obtenerLabNombre(String usuario) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        conn = conexion.getConexion();
        String query = "SELECT laboratorio FROM Usuarios WHERE usuario = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, usuario);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            return rs.getString("laboratorio");
        } else {
            return ""; // Puedes manejar el caso cuando no se encuentra el laboratorio
        }
    } catch (SQLException e) {
        return "";
    } finally {
        // Cerrar recursos
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
        }
    }
}

    private int obtenerNivelPermisos(String usuario, String contraseña) {
    // Verificar si el usuario es "admin" con contraseña "1234"
    if (usuario.equals("admin") && contraseña.equals("1234")) {
        return 4; // Nivel de permisos para el usuario "admin"
    }

    // Obtener el nivel de permisos desde la base de datos
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        conn = conexion.getConexion();
        String query = "SELECT permisos FROM Usuarios WHERE usuario = ? AND contraseña = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, usuario);
        pstmt.setString(2, contraseña);
        rs = pstmt.executeQuery();

        if (rs.next()) {
            return rs.getInt("permisos");
        } else {
            return 0; // Usuario no encontrado
        }
    } catch (SQLException e) {
        return 0;
    } finally {
        // Cerrar recursos
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
        }
    }
}

        
    private void abrirVentanaSegunPermisos(String usuario, int nivelPermisos, String laboratorio) {
        if (nivelPermisos == 4) {
            // Abrir la ventana de administrador
            Admin adminWindow = new Admin(usuario);
            adminWindow.setVisible(true);
        } else {
            // Abrir la ventana normal
            TablaSerigraphy updateWindow = new TablaSerigraphy(laboratorio, nivelPermisos, usuario);
            updateWindow.setVisible(true);
        }
    }
    
    public static void main(String args[]) {
    }

     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelIcono;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jTextFieldUser;
    // End of variables declaration//GEN-END:variables
}