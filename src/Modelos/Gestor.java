package Modelos;

public class Gestor {

    private static Gestor instancia;
    private final ListaUsuarios lista;
    private final PilaCamisetas pilaCamiseta;
    
    private Gestor() {
        this.lista = new ListaUsuarios();
        this.pilaCamiseta = new PilaCamisetas();
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

    public PilaCamisetas getPilaCamiseta() {
        return pilaCamiseta;
    }
        
}
