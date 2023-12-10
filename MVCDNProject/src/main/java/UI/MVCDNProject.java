
package UI;

import DB.ResetTablas;
import DB.conexion;
import DB.SerigraphyLaboratoryDAO;
import java.util.List;
import Model.orders;
import javax.swing.JOptionPane;

public class MVCDNProject {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"usuario: admin\ncontraseña: 1234\neste mensaje solo es para probar el administrador");
        Login loginWindow = new Login();
        loginWindow.setVisible(true);
        conexion.estableceConexion();
        SerigraphyLaboratoryDAO dao = new SerigraphyLaboratoryDAO();
        ResetTablas.crear();
        
        //insert.Update(0,fecha, "PD001",null, null);
        
        List<orders> listaPedidos = dao.Listarorders("CarpentryProduction");
        
        for (orders pedido : listaPedidos) {
            pedido.printOrder();
        }
    }
}
