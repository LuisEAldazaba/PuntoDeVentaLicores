
package Controlador;

import Modelo.Categoria;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;


public class Ctrl_Categoria {
    public boolean guardar(Categoria objeto){
        boolean respuesta=false;
        Connection cn= conexion.Conexion.conectar();
        try {
            PreparedStatement consulta= cn.prepareStatement("insert into tb_categoria values(?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getDescripcion());
        }catch (SQLException e) {
            System.out.println("Error al guardar categoria: ",e);
        }
    }
}
