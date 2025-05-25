
package Controlador;

import Vista.InterFacturacion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.Statement;
import conexion.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;


public class VentaPDF {
    
    private String nombreCliente;
    private String ineCliente; //cedula es lo mismo que ine
    private String telefonoCliente;
    private String direccionCliente;
    
    private String fechaActual ="";
    private String nombreArchivoPDFVenta="";
    
    //metodo obtener datos de cliente
    
    public void DatosCliente(int idCliente){
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_cliente where idCliente = '"+idCliente+"'";
        Statement st;
        
        try {
            st=cn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            while(rs.next()){
                nombreCliente=rs.getString("nombre")+" "+rs.getString("apellido");
                ineCliente=rs.getString("ine");
                telefonoCliente=rs.getString("telefono");
                direccionCliente=rs.getString("direccion");
            
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del cliente: "+e);
        }
                
    }
    //metodo para generar factura de venta 
    public void generarFacturaPDF(){
        try{
            // cargar la fecha actual 
            Date date =new Date();
            fechaActual= new SimpleDateFormat("yyyy/MM/dd").format(date);
            //cambiar el formato de fecha de / a _
            String fechaNueva="";
            
            for(int i=0 ; i<fechaActual.length();i++){
                if(fechaActual.charAt(i)=='/'){
                    fechaNueva=fechaActual.replace("/", "_");
                }
            }
            
            nombreArchivoPDFVenta="Venta_"+nombreCliente+"_"+fechaNueva+".pdf";
            
            FileOutputStream archivo;
            File file = new File("src/pdf/"+nombreArchivoPDFVenta);
            archivo=new FileOutputStream(file);
            
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            
            Image img=Image.getInstance("src/img/ventas.png");
            Paragraph fecha =new Paragraph();
            Font negritas=new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD,BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE); //agregar nueva linea
            fecha.add("Factura: 001"+"\nFecha: "+fechaActual+"\n\n");
            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);//quitar borde de la tabla
            //tamaño de celdas
            float[] ColumnaEncabezado = new float[]{20f,30f,70f,40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            //agregar celdas
            Encabezado.addCell(img);
            
            String rfc="0987654321001";
            String nombre="Licoreria Tecno";
            String telefono="2961138682";
            String direccion="Xalapa,ver.";
            String razon="Proyecto Punto De Venta Licoreria";
            
            Encabezado.addCell("");//celda vacia
            Encabezado.addCell("RFC: "+rfc+"\nNombre: "+nombre+"\nTelefono: "+telefono+"\nDireccion: "+direccion+"\nRazon Social: "+razon);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);
            
            //cuerpo
            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);
            cliente.add("Datos del cliente: "+"\n\n");
            doc.add(cliente);
            
            
            //Datos del cliente
            PdfPTable tablaCliente = new PdfPTable(4);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0); //quitar bordes
            
            
            //tamaño de celdas
            float[] ColumnaCliente = new float[]{25f,45f,30f,40f};
            tablaCliente.setWidths(ColumnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1=new PdfPCell(new Phrase("Ine/Rfc: ",negritas));
            PdfPCell cliente2=new PdfPCell(new Phrase("Nombre: ",negritas));
            PdfPCell cliente3=new PdfPCell(new Phrase("Telefono: ",negritas));
            PdfPCell cliente4=new PdfPCell(new Phrase("Direccion: ",negritas));
            //quitar bordes
            cliente1.setBorder(0);
            cliente2.setBorder(0);
            cliente3.setBorder(0);
            cliente4.setBorder(0);
            //agg celda a la tabla
            tablaCliente.addCell(cliente1);
            tablaCliente.addCell(cliente2);
            tablaCliente.addCell(cliente3);
            tablaCliente.addCell(cliente4);
            tablaCliente.addCell(ineCliente);
            tablaCliente.addCell(nombreCliente);
            tablaCliente.addCell(telefonoCliente);
            tablaCliente.addCell(direccionCliente);
            //agregar al documento
            doc.add(tablaCliente);
            
            //espacio blanco
            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);
            
            //agregar los productos
            PdfPTable tablaProductos = new PdfPTable(4);
            tablaProductos.setWidthPercentage(100);
            tablaProductos.getDefaultCell().setBorder(0);
            //tamaño de celdas
            float[] ColumnaProducto = new float[]{15f,50f,15f,20f};
            tablaProductos.setWidths(ColumnaProducto);
            tablaProductos.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell producto1 =new PdfPCell(new Phrase("Cantidad: ",negritas));
            PdfPCell producto2 =new PdfPCell(new Phrase("Descripcion: ",negritas));
            PdfPCell producto3 =new PdfPCell(new Phrase("Precio Unitario: ",negritas));
            PdfPCell producto4 =new PdfPCell(new Phrase("Precio Total: ",negritas));
            
            //quitar bordes
            producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);
            //agregar color al encabezado
            producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);            
            producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);            
            //agregar celda a la tabla
            tablaProductos.addCell(producto1);
            tablaProductos.addCell(producto2);
            tablaProductos.addCell(producto3);
            tablaProductos.addCell(producto4);
            
            for(int i=0;i<InterFacturacion.jTable_productos.getRowCount();i++){
                String producto = InterFacturacion.jTable_productos.getValueAt(i, 1).toString();
                String cantidad = InterFacturacion.jTable_productos.getValueAt(i, 2).toString();
                String precio = InterFacturacion.jTable_productos.getValueAt(i, 3).toString();
                String total = InterFacturacion.jTable_productos.getValueAt(i, 7).toString();
                
                tablaProductos.addCell(cantidad);
                tablaProductos.addCell(producto);
                tablaProductos.addCell(precio);
                tablaProductos.addCell(total);
            }
            //agregar al documento
            doc.add(tablaProductos);
            
            //total pagar
            Paragraph info =new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total a pagar: "+InterFacturacion.txt_total_pagar.getText());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            
            //firma
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Cancelacion y firma\n\n");
            firma.add("______________________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);
            
            //gracias por su compra (mensaje)
            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("Gracias por su compra disfrute sus licores :)");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);
            
            //cerrar el documento y el archivo
            doc.close();
            archivo.close();
            
            //abrir el documento al ser generado automaticamente
            Desktop.getDesktop().open(file);
            
                    
        } catch(DocumentException | IOException e){
            System.out.println("Error en: "+e);
        }
    }
    
    
    
    
}
