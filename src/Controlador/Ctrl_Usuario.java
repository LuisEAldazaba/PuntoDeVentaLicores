package Controlador;

import Conexion.Conexion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Ctrl_Usuario {

    public boolean loginUser(Usuario objeto) {
        boolean respuesta = false;

        Connection cn = Conexion.conectar();
        String sql = "SELECT usuario, password FROM tb_usuario WHERE usuario = '" + objeto.getUsuario() + "' AND password = '" + objeto.getPassword() + "'";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                respuesta = true;
            }

            rs.close();
            st.close();
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión");
        }

        return respuesta;
    }
}
