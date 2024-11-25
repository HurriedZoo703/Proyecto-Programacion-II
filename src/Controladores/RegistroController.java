package Controladores;

import Modelos.Gestor;
import Modelos.ListaUsuarios;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistroController implements Initializable {

    private final ListaUsuarios lista = Gestor.obtenerInstancia().getLista();
    
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtIdentficacion;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtGmail;
    @FXML
    private TextField txtClave;
    @FXML
    private Button btn_cancelar;
    @FXML
    private Button btn_registrar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void closeWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/Login.fxml"));

            Parent roott = loader.load();

            Scene scene = new Scene(roott);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage miStage = (Stage) this.btn_cancelar.getScene().getWindow();
            miStage.close();
        } catch (IOException ex) {
            Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void eventAction(ActionEvent event) {

        if (event.getSource() == btn_cancelar) {

            closeWindow();

        } else if (event.getSource() == btn_registrar) {

            validarUsuario(txtNombre, txtIdentficacion, txtTelefono, txtGmail, txtClave);
        }

    }

    public void validarUsuario(TextField txtNombre, TextField txtIden, TextField txtCell, TextField txtGmail, TextField txtPassword) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setHeaderText("Mensaje de informacion");
        a.setTitle("Dialogo de advertencia");

        if (!"".equals(txtNombre.getText())) {

            if (!"".equals(txtIden.getText())) {

                if (!"".equals(txtCell.getText())) {

                    if (!"".equals(txtGmail.getText())) {

                        if (!"".equals(txtPassword.getText())) {

                            lista.agregarUsuario(txtNombre, txtIdentficacion, txtCell, txtGmail, txtPassword);
                            lista.guardarUsuariosEnArchivoTXT(lista);

                            if (lista.getnAgregados() != 0) {
                                closeWindow();
                            }
                        } else {

                            a.setContentText("Es necesario que se escriba una contraseña");
                            a.showAndWait();
                        }

                    } else {

                        a.setContentText("Es necesario que se escriba un correo");
                        a.showAndWait();
                    }
                } else {

                    a.setContentText("Es necesario que se escriba un"
                            + "\nnumero de numero de telefono");
                    a.showAndWait();
                }

            } else {

                a.setContentText("Es necesario que se escriba un numero de identificacion");
                a.showAndWait();
            }
        } else {

            a.setContentText("Es necesario que se escriba un nombre");
            a.showAndWait();
        }
    }
}
