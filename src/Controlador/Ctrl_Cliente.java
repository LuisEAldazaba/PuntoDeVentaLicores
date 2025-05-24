package Controlador;

import Modelo.Cliente;
import Modelo.Producto;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// OJO INE ES LO MISMO QUE CEDULA
public class Ctrl_Cliente {

    //metodo para guardar un nuevo Cliente
    public boolean guardar(Cliente objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_cliente values(?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getIne());
            consulta.setString(5, objeto.getTelefono());
            consulta.setString(6, objeto.getDireccion());
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar Cliente: " + e);
        }

        return respuesta;
    }
    // INE ES LO MISMO QUE CEDULA
    //metodo para consultar si el Cliente ya esta en la BBDD
    public boolean existeCliente(String ine) {
        boolean respuesta = false;
        String sql = "select ine from tb_cliente where ine = '" + ine + "';";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar cliente: " + e);
        }

        return respuesta;
    }
    
    //metodo actualizar cliente
    public boolean actualizar(Cliente objeto, int idCliente) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("update tb_cliente set nombre= ?, apellido= ?, ine= ?, telefono= ?,direccion= ?,estado= ? where idCliente = '" + idCliente + "'");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getIne());
            consulta.setString(4, objeto.getTelefono());
            consulta.setString(5, objeto.getDireccion());
            consulta.setInt(6, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e);
        }

        return respuesta;
    }

    //metodo eliminar cliente
    public boolean eliminar(int idCliente) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("delete from tb_cliente where idCliente = '" + idCliente + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e);
        }
        return respuesta;
    }

}
