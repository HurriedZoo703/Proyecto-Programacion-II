package Modelos;

public class Gestor {

    private static Gestor instancia;
    private final ListaUsuarios lista;

    private Gestor() {
        this.lista = new ListaUsuarios();
    }

    public static Gestor obtenerInstancia() {
        
        if (instancia == null) {
            instancia = new Gestor();
        }
        
        return instancia;
    }

    public ListaUsuarios getLista() {
        return lista;
    }
    
}
