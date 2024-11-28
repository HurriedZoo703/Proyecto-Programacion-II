package Modelos;

public class NodoCamiseta {

    private int idPropietario;
    private String URL_ima;
    private String talla;
    private String color;
    private float precio;
    private int tComprado;

    public NodoCamiseta(int idPropietario, String color, String URL_ima) {
        this.idPropietario = idPropietario;
        this.color = color;
        this.URL_ima = URL_ima;
    }

    public NodoCamiseta(int idPropietario, String URL_ima, String talla, String color, float precio) {
        this.idPropietario = idPropietario;
        this.URL_ima = URL_ima;
        this.talla = talla;
        this.color = color;
        this.precio = precio;
        this.tComprado = 0;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getURL_ima() {
        return URL_ima;
    }

    public void setURL_ima(String URL_ima) {
        this.URL_ima = URL_ima;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int gettComprado() {
        return tComprado;
    }

    public void settComprado(int tComprado) {
        this.tComprado = tComprado;
    }

}
