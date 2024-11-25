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

    public NodoUsuario getUltimo() {

        if (getCabeza() == null) {
            return null;
        } else {
            NodoUsuario usuario = getCabeza();
            while (usuario.getSig() != null) {
                usuario = usuario.getSig();
            }
            return usuario;
        }
    }
    
    public NodoUsuario buscarPorCorreo(String gmail) {
        if (getCabeza()== null) {
            return null;
        } else {
            NodoUsuario aux = getCabeza();
            while (aux != null) {
                if (aux.getCorreo().equalsIgnoreCase(gmail)) {
                    return aux;
                } else {
                    aux = aux.getSig();
                }
            }
            return null;
        }
    }

    public NodoUsuario buscarPorID(int identificacion) {
        if (getCabeza()== null) {
            return null;
        } else {
            NodoUsuario aux = getCabeza();
            while (aux != null) {
                if (aux.getIdentificacion()== identificacion) {
                    return aux;
                } else {
                    aux = aux.getSig();
                }
            }
            return null;
        }
    }
    
    
}
