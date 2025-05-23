package Modelo;

public class Cliente {

    //atributos
    private int idCliente;
    private String nombre;
    private String apellido;
    private String ine;
    private String telefono;
    private String direccion;
    private int estado;

    //constructor
    public Cliente() {
        this.idCliente = 0;
        this.nombre = "";
        this.apellido = "";
        this.ine = "";
        this.telefono = "";
        this.direccion = "";
        this.estado = 0;
    }

    //constructor sobrecargado
    public Cliente(int idCliente, String nombre, String apellido, String ine, String telefono, String direccion, int estado) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ine = ine;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }
    //metodo set and get

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
