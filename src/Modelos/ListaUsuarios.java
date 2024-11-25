package Modelos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
        if (getCabeza() == null) {
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
        if (getCabeza() == null) {
            return null;
        } else {
            NodoUsuario aux = getCabeza();
            while (aux != null) {
                if (aux.getIdentificacion() == identificacion) {
                    return aux;
                } else {
                    aux = aux.getSig();
                }
            }
            return null;
        }
    }

    public ObservableList<NodoUsuario> obtenerUsuarios() {
        ObservableList<NodoUsuario> todos = FXCollections.observableArrayList();

        if (getCabeza() == null) {
            return todos;
        }

        NodoUsuario actual = getCabeza();

        do {

            todos.add(actual);
            actual = actual.getSig();

        } while (actual != null && actual != getCabeza());

        return todos;
    }

    public void agregarUsuario(TextField txtNombre, TextField txtIdentificacion, TextField txtCell, TextField txtGmail, PasswordField txtPassword) {
        Alert alert = new Alert(Alert.AlertType.WARNING);

        NodoUsuario user1 = buscarPorCorreo(txtGmail.getText());
        NodoUsuario user2 = buscarPorID(Integer.parseInt(txtIdentificacion.getText()));

        try {

            if (user1 != null) {
                alert.setTitle("Importante...!");
                alert.setContentText("Ya existe un usuario con este Correo");
                alert.showAndWait();
                txtGmail.setText("");
                txtGmail.requestFocus();
                return;
            } else if (user2 != null) {
                alert.setTitle("Importante...!");
                alert.setContentText("Ya existe un usuario con esta identificación");
                alert.showAndWait();
                txtIdentificacion.setText("");
                txtIdentificacion.requestFocus();
                return;
            } else {

                alert.setAlertType(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Dialogo de confirmación.");
                alert.setContentText("Registro realizado con exito...!\n"
                        + "Felicidades...! ya haces parte de nuestros usuarios.");

                NodoUsuario nuevo = new NodoUsuario(txtNombre.getText(), Integer.parseInt(txtIdentificacion.getText()), txtCell.getText(), txtGmail.getText(), txtPassword.getText());

                if (nuevo != null) {
                    if (getCabeza() == null) {
                        setCabeza(nuevo);
                        nAgregados++;
                        alert.showAndWait();
                    } else {
                        nuevo.setSig(getCabeza());
                        getCabeza().setAnt(nuevo);
                        setCabeza(nuevo);
                        nAgregados++;
                        alert.showAndWait();
                    }
                }

                txtNombre.setText("");
                txtIdentificacion.setText("");
                txtCell.setText("");
                txtGmail.setText("");
                txtPassword.setText("");
            }

        } catch (NumberFormatException e) {
            Logger.getLogger(ListaUsuarios.class.getName()).log(Level.SEVERE, null, e);
            return;
        }
    }
    
    public void guardarUsuariosEnArchivoTXT(ListaUsuarios lista) {

        String direccion = System.getProperty("user.dir") + "\\src\\Archivos_TXT\\Usuarios.txt";

        Path archivo = Paths.get(direccion);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo.toFile(), false))) {
            NodoUsuario actual = lista.getCabeza();

            while (actual != null) {
                writer.write(actual.getNombre() + ", ");
                writer.write(actual.getIdentificacion() + ", ");
                writer.write(actual.getTelefono()+ ", ");
                writer.write(actual.getCorreo() + ", ");
                writer.write(actual.getClave());

                writer.newLine();

                actual = actual.getSig();
            }

        } catch (IOException e) {
            Logger.getLogger(ListaUsuarios.class.getName()).log(Level.SEVERE, null, e);            
        }
    }
}
