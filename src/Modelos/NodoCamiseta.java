package Modelos;

public class NodoCamiseta {
    
    private String URL_ima;
    private String talla;
    private String color;
    private float precio;

    public NodoCamiseta(String URL_ima, String talla, String color, float precio) {
        this.URL_ima = URL_ima;
        this.talla = talla;
        this.color = color;
        this.precio = precio;
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
    
}
