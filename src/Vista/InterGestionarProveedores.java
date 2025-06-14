package Vista;

import Controlador.Ctrl_Proveedores;
import Modelo.Proveedores;
import java.sql.PreparedStatement;
import java.sql.Statement;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Dimension;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InterGestionarProveedores extends javax.swing.JInternalFrame {

    private int idProveedor;

    public InterGestionarProveedores() {
        initComponents();
        this.setSize(new Dimension(900, 500)); //se modifica tamaño a como se agrando
        this.setTitle("Gestionar Proveedores");

        this.CargarTablaProveedores();

        //insertar imagen en nuestro Jlabel
        ImageIcon wallpaper = new ImageIcon("src/img/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(900, 500, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_proveedores = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_eliminar = new javax.swing.JButton();
        jButton_actualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_empresa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        txt_direccion_fiscal = new javax.swing.JTextField();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrar Proveedores");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_proveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_proveedores);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 700, 230));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 730, 270));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_eliminar.setBackground(new java.awt.Color(255, 51, 51));
        jButton_eliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, -1));

        jButton_actualizar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_actualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 130, 80));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Empresa:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, -1));

        txt_empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_empresaActionPerformed(evt);
            }
        });
        jPanel3.add(txt_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 170, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Telefono:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Direccion Fiscal:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 160, -1));

        txt_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonoActionPerformed(evt);
            }
        });
        jPanel3.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 170, -1));
        jPanel3.add(txt_direccion_fiscal, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 100));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        Ctrl_Proveedores controlProveedores = new Ctrl_Proveedores();
        if(idProveedor == 0){
            JOptionPane.showMessageDialog(null, "Seleccione un Proveedor");
        }else{
            if(!controlProveedores.eliminar(idProveedor)){
              JOptionPane.showMessageDialog(null, "Proveedor eliminado"); 
              this.CargarTablaProveedores();
              this.Limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar proveedor"); 
                this.Limpiar();
            }
        }
            
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        if(txt_empresa.getText().isEmpty() && txt_telefono.getText().isEmpty() && txt_direccion_fiscal.getText().isEmpty()){

            JOptionPane.showMessageDialog(null, "Completa todos los campos");
        }else{
            Proveedores  proveedores = new Proveedores();
            Ctrl_Proveedores controlProveedores = new Ctrl_Proveedores();
            
            proveedores.setEmpresa(txt_empresa.getText().trim());
            proveedores.setTelefono(txt_telefono.getText().trim());
            proveedores.setDireccionFiscal(txt_direccion_fiscal.getText().trim());
            
            if(controlProveedores.actualizar(proveedores, idProveedor)){
                JOptionPane.showMessageDialog(null, "Datos del proveedor actualizados");
                this.CargarTablaProveedores();
                this.Limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al actualizar");
            }
                    
        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void txt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonoActionPerformed

    private void txt_empresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_empresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_empresaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_proveedores;
    private javax.swing.JTextField txt_direccion_fiscal;
    private javax.swing.JTextField txt_empresa;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables

    //metodo limpiar
    private void Limpiar() {
        txt_empresa.setText("");
        txt_telefono.setText("");
        txt_direccion_fiscal.setText("");

    }



    private void CargarTablaProveedores() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select * from tb_proveedores";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarProveedores.jTable_proveedores = new JTable(model);
            InterGestionarProveedores.jScrollPane1.setViewportView(InterGestionarProveedores.jTable_proveedores);

            model.addColumn("N°");//id
            model.addColumn("empresa");
            model.addColumn("telefono");
            model.addColumn("direccion fiscal");
            model.addColumn("estado");

            while (rs.next()) {

                Object fila[] = new Object[5];

                for (int i = 0; i < 5; i++) {
                    fila[i] = rs.getObject(i + 1);

                }
                model.addRow(fila);

            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla proveedores: " + e);
        }

        jTable_proveedores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_proveedores.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    idProveedor = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosProveedorSeleccionado(idProveedor); //metodo
                }
            }
        });
    }

//metodo enviar producto seleccionado 
    private void EnviarDatosProveedorSeleccionado(int idProveedor) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("select * from tb_proveedores where idProveedor = '" + idProveedor + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txt_empresa.setText(rs.getString("empresa"));
                txt_telefono.setText(rs.getString("telefono"));
                txt_direccion_fiscal.setText(rs.getString("direccionFiscal"));

            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Error al seleccionar proveedor: " + e);
        }
    }

}
