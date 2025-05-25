package Controlador;

import Modelo.Categoria;
import Modelo.Producto;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ctrl_Producto {

    //metodo para guardar un nuevo producto
    public boolean guardar(Producto objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_producto values(?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getNombre());
            consulta.setInt(3, objeto.getCantidad());
            consulta.setDouble(4, objeto.getPrecio());
            consulta.setString(5, objeto.getDescripcion());
            consulta.setInt(6, objeto.getProcentajeIVA());
            consulta.setInt(7, objeto.getIdCategoria());
            consulta.setInt(8, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar producto: " + e);
        }

        return respuesta;
    }

    //metodo para consultar si el producto ya esta en la BBDD
    public boolean existeProducto(String nombre, String descripcion) {
        boolean respuesta = false;
        // se cambio para que cheque si son iguales el nombre y la descripcion
        String sql = "SELECT * FROM tb_producto WHERE nombre = ? AND descripcion = ?";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, descripcion);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar producto: " + e);
        }

        return respuesta;
    }

    //metodo actualizar producto
    public boolean actualizar(Producto objeto, int idProducto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("update tb_producto set nombre= ?, cantidad= ?, precio= ?, descripcion= ?,porcentajeIva= ?,idCategoria= ?,estado= ? where idProducto = '" + idProducto + "'");
            consulta.setString(1, objeto.getNombre());
            consulta.setInt(2, objeto.getCantidad());
            consulta.setDouble(3, objeto.getPrecio());
            consulta.setString(4, objeto.getDescripcion());
            consulta.setInt(5, objeto.getProcentajeIVA());
            consulta.setInt(6, objeto.getIdCategoria());
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e);
        }

        return respuesta;
    }

    //metodo eliminar producto
    public boolean eliminar(int idProducto) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("delete from tb_producto where idProducto = '" + idProducto + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e);
        }
        return respuesta;
    }

    //metodo para actualizar stock del producto
    public boolean actualizarStock(Producto object, int idProducto) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("update  tb_producto set cantidad = ? where idProducto = '" + idProducto + "'");
            consulta.setInt(1, object.getCantidad());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar stock del producto: " + e);
        }
        return respuesta;
    }

}
