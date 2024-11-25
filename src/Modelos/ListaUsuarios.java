package Modelos;

public class ListaUsuarios {

    private NodoUsuario cabeza;
    private int nAgregados;

    public ListaUsuarios() {
        this.cabeza = null;
        this.nAgregados = 0;
    }

    public NodoUsuario getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoUsuario cabeza) {
        this.cabeza = cabeza;
    }

    public int getnAgregados() {
        return nAgregados;
    }

    public void setnAgregados(int nAgregados) {
        this.nAgregados = nAgregados;
    }

    public void vaciar() {
        this.cabeza = null;
    }

    
}
