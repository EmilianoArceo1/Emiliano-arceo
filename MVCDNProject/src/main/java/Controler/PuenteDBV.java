
package Controler;
import DB.SerigraphyLaboratoryDAO;
import javax.swing.table.DefaultTableModel;
public class PuenteDBV {
    public static void puenteBorrar(int id, String tabla){
        SerigraphyLaboratoryDAO.borrar(id, tabla);
    }
    
    public static void puenteActualizar(DefaultTableModel modeloTabla, String tabla){
        SerigraphyLaboratoryDAO.cargarDatos(modeloTabla, tabla);
    }
    
    public static void puenteEditar(int Order, String Nombre, int Hechos,String tabla){
        SerigraphyLaboratoryDAO.editar(Order, Nombre, Hechos, tabla);
    }
}


