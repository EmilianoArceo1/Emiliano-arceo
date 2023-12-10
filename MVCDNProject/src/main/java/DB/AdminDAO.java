package DB;

import Model.orders;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminDAO {

    private Connection cn = conexion.getConexion();

    public List<orders> Listarorders(String tabla) {
        List<orders> lista = new ArrayList<>();

        try (PreparedStatement pstm = cn.prepareStatement("SELECT * FROM " + tabla + " WHERE done = 0");
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                int orders = rs.getInt(1);
                String product = rs.getString(2);
                int done = rs.getInt(3);

                orders order = new orders(orders, product, done);
                lista.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // O utiliza algún sistema de registro de errores
        }

        return lista;
    }

    public static void eliminarTabla(String tabla) {
        String query = "DROP TABLE " + tabla;

        try (Connection conn = conexion.getConexion();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al eliminar la tabla: " + ex.getMessage());
        }
    }

    public static boolean RegistrarOrden(String Nombre, int Orden, int Hechos, String tabla) {
        try {
            Connection con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO " + tabla + " (codigo, nombre, done) VALUES(?,?,?)");
            ps.setInt(1, Orden);
            ps.setString(2, Nombre);
            ps.setInt(3, Hechos);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto registrado correctamente");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();  // Muestra información sobre la excepción en la consola
            JOptionPane.showMessageDialog(null, "Error al registrar producto");
            return false;
        }
    }


    public void update(int _order, String _Product, int _newDone, String tabla) {
        try {
            if (cn != null) { // Validar que la conexión no sea nula
                // Consulta preparada para evitar SQL injection
                String query = "UPDATE " + tabla + " SET done = ? WHERE codigo = ? AND nombre = ?";
                try (PreparedStatement pstm = cn.prepareStatement(query)) {
                    // Establecer los valores de los parámetros en la consulta preparada
                    pstm.setInt(1, _newDone);
                    pstm.setInt(2, _order);
                    pstm.setString(3, _Product);

                    // Ejecutar la actualización
                    pstm.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void borrar(int id, String tabla) {
        try {
            Connection con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("DELETE FROM " + tabla + " WHERE codigo=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro eliminado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public static void editar(int Order, String Nombre, int Hechos, String tabla) {
        try {
            Connection con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE " + tabla + " SET codigo=?, nombre=?, done=?");
            ps.setInt(1, Order);
            ps.setString(2, Nombre);
            ps.setInt(3, Hechos);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro modificado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void cargarDatos(DefaultTableModel modeloTabla, String tabla) {
        try {
            Connection con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement("SELECT id, codigo, nombre, done FROM " + tabla);
            ResultSet rs = ps.executeQuery();
            int columnas = modeloTabla.getColumnCount();

            modeloTabla.setRowCount(0);

            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int indice = 0; indice < columnas; indice++) {
                    fila[indice] = rs.getObject(indice + 1);
                }
                modeloTabla.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public void limpiarTabla(String tabla) {
        try {
            if (cn != null) {
                String query = "DELETE FROM " + tabla + " WHERE done = 0";
                try (PreparedStatement pstm = cn.prepareStatement(query)) {
                    pstm.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean existeOrdenExcepto(int order, int filaSeleccionada, String tabla) {
        try {
            String query = "SELECT COUNT(*) FROM " + tabla + " WHERE codigo = ? AND id <> ?";
            try (PreparedStatement pstm = cn.prepareStatement(query)) {
                pstm.setInt(1, order);
                pstm.setInt(2, filaSeleccionada);

                try (ResultSet rs = pstm.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt(1);
                        return count > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo adecuado de excepciones
        }
        return false;
    }

    public void updateUser(int _id, String _name, int _permiso, String _user) {
        try {
            if (cn != null) { // Validar que la conexión no sea nula
                // Consulta preparada para evitar SQL injection
                String query = "UPDATE Usuarios SET done = ? WHERE id = ? AND nombre = ?";
                try (PreparedStatement pstm = cn.prepareStatement(query)) {
                    // Establecer los valores de los parámetros en la consulta preparada
                    pstm.setInt(1, _id);
                    pstm.setString(2, _name);
                    pstm.setString(3, _user);
                    pstm.setInt(4, _permiso);

                    // Ejecutar la actualización
                    pstm.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
