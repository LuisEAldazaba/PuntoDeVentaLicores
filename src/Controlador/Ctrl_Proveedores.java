package Controlador;


import Modelo.Proveedores;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ctrl_Proveedores {
    //metodo para guardar un nuevo Proveedor
    public boolean guardar(Proveedores objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_proveedores values(?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getEmpresa());
            consulta.setString(3, objeto.getTelefono());
            consulta.setString(4, objeto.getDireccionFiscal());
            consulta.setInt(5, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar Proveedor: " + e);
        }

        return respuesta;
    }
    //metodo para consultar si el proveedor ya esta en la BBDD
    public boolean existeProveedor(String empresa) {
        boolean respuesta = false;
        String sql = "select empresa from tb_proveedores where empresa = '" + empresa + "';";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar proveedor: " + e);
        }

        return respuesta;
    }
    
    //metodo actualizar proveedor
    public boolean actualizar(Proveedores objeto, int idProveedor) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("update tb_proveedores set empresa= ?, telefono= ?, direccionFiscal= ?, estado= ? where idProveedor = '" + idProveedor + "'");
            consulta.setString(1, objeto.getEmpresa());
            consulta.setString(2, objeto.getTelefono());
            consulta.setString(3, objeto.getDireccionFiscal());
            consulta.setInt(4, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar proveedor: " + e);
        }

        return respuesta;
    }

    //metodo eliminar proveedor
    public boolean eliminar(int idProveedor) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("delete from tb_proveedores where idProveedor = '" + idProveedor + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar proveedor: " + e);
        }
        return respuesta;
    }
}
