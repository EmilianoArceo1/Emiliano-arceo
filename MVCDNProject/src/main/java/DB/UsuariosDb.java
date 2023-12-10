package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuariosDb {

    public static void insertarUsuario(String nombre, String usuario, String permisos, String laboratorio) {
        ejecutarQuery("INSERT INTO Usuarios (nombre, usuario, permisos, laboratorio) VALUES (?, ?, ?, ?)",
                      nombre, usuario, permisos, laboratorio);
    }

    public static void actualizarUsuario(int id, String nuevoUsuario, String nuevosPermisos) {
        ejecutarQuery("UPDATE Usuarios SET usuario = ?, permisos = ? WHERE id = ?", nuevoUsuario, nuevosPermisos, id);
    }

    public static void eliminarUsuario(int id) {
        ejecutarQuery("DELETE FROM Usuarios WHERE id = ?", id);
    }

    public static ResultSet obtenerUsuarios() {
        return ejecutarConsulta("SELECT id, nombre, usuario, permisos, laboratorio FROM Usuarios");
    }
    
    public static void cambiarPermisos(int id, String nuevosPermisos) {
        String sql = "UPDATE Usuarios SET permisos = ? WHERE id = ?";

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nuevosPermisos);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            // Manejo de excepciones (puedes personalizarlo según tus necesidades)
            e.printStackTrace();
        }
    }
    
    public static boolean insertarUsuario(String nombre, String usuario, String contraseña, int permisos, String laboratorio) {
        String query = "INSERT INTO Usuarios (nombre, usuario, contraseña, permisos, laboratorio) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conexion.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Establecer los valores en la consulta preparada
            pstmt.setString(1, nombre);
            pstmt.setString(2, usuario);
            pstmt.setString(3, contraseña);
            pstmt.setInt(4, permisos);
            pstmt.setString(5, laboratorio);

            // Ejecutar la inserción
            pstmt.executeUpdate();

            return true; // Éxito

        } catch (SQLException ex) {
            // Manejar cualquier error de SQL
            ex.printStackTrace();
            return false;
        }
    }

    private static void ejecutarQuery(String sql, Object... parametros) {
        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            for (int i = 0; i < parametros.length; i++) {
                ps.setObject(i + 1, parametros[i]);
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    private static ResultSet ejecutarConsulta(String sql) {
        try {
            Connection con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
}
