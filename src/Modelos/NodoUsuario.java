package Modelos;

public class NodoUsuario {
    
    private String nombre;
    private int identificacion;
    private String telefono;
    private String correo;
    private String clave;
    private NodoUsuario sig, ant;

    public NodoUsuario(String nombre, int identificacion, String telefono, String correo, String clave) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.correo = correo;
        this.clave = clave;
        this.sig = null;
        this.ant = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public NodoUsuario getSig() {
        return sig;
    }

    public void setSig(NodoUsuario sig) {
        this.sig = sig;
    }

    public NodoUsuario getAnt() {
        return ant;
    }

    public void setAnt(NodoUsuario ant) {
        this.ant = ant;
    }
        
}
