package Modelo;

public class Proveedores {
    //atributos

    private int idProveedor;
    private String empresa;
    private String telefono;
    private String direccionFiscal;
    private int estado;

    //constructor
    public Proveedores() {
        this.idProveedor = 0;
        this.empresa = "";
        this.telefono = "";
        this.estado = 0;
    }

    //constructor sobrecargado
    public Proveedores(int idProveedor, String empresa, String telefono, String direccionFiscal, int estado) {
        this.idProveedor = idProveedor;
        this.empresa = empresa;
        this.telefono = telefono;
        this.direccionFiscal = direccionFiscal;
        this.estado = estado;
    }
    
    //metodo set and get

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccionFiscal() {
        return direccionFiscal;
    }

    public void setDireccionFiscal(String direccionFiscal) {
        this.direccionFiscal = direccionFiscal;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
