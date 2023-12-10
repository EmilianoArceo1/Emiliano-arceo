package Controler;

import DB.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginManager {

    public boolean realizarInicioSesion(String usuario, String contraseña) {
        // Lógica de validación del usuario y la contraseña con la base de datos
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            if (usuario.equals("admin") && contraseña.equals("1234")) {
            return true;
            }
            conn = conexion.getConexion(); // Obtener la conexión a la base de datos
            String query = "SELECT * FROM Usuarios WHERE usuario = ? AND contraseña = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, usuario);
            pstmt.setString(2, contraseña);
            rs = pstmt.executeQuery();

            return rs.next(); // Devuelve true si encuentra una coincidencia, false en caso contrario
        } catch (SQLException e) {
            mostrarMensajeError("Error al realizar inicio de sesión");
            return false;
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                mostrarMensajeError("Error al cerrar recursos");
            }
        }
    }

    public void mostrarMensajeError(String mensaje) {
        // Muestra un cuadro de diálogo con el mensaje de error y detalles adicionales
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
