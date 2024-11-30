package Controladores;

import Modelos.Gestor;
import Modelos.ListaUsuarios;
import Modelos.NodoUsuario;
import Modelos.PilaCamisetas;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class LoginController implements Initializable {
    
    private final ListaUsuarios lista = Gestor.obtenerInstancia().getLista();
    private final PilaCamisetas pila = Gestor.obtenerInstancia().getPilaCamiseta();
    
    @FXML
    private TextField txt_usuario;
    @FXML
    private PasswordField txt_clave;
    @FXML
    private Button btn_iniciar;
    @FXML
    private Button btn_registrar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lista.llenarUsuariosDesdeArchivoTXT();
        pila.cargarCamisetas();
        pila.cargarCamisetasLD();
    }
    
    @FXML
    private void eventAction(ActionEvent event) {
        
        if (event.getSource() == btn_iniciar) {
            
            iniciar();
            
        } else if (event.getSource() == btn_registrar) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/Registro.fxml"));
                Parent root = loader.load();
                
                RegistroController controller = loader.getController();
                
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                
                stage.setScene(scene);
                stage.setOnCloseRequest((WindowEvent value) -> {
                    controller.closeWindow();
                });
                stage.setTitle("CATALOGO");
                stage.show();
                
                Stage miStage = (Stage) this.btn_iniciar.getScene().getWindow();
                miStage.close();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void iniciar() {
        Alert alert = new Alert(Alert.AlertType.NONE);
        
        if (txt_usuario.getText().isEmpty() && txt_clave.getText().isEmpty()) {
            
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setContentText("No se puede verificar\nLos campos están vacios");
            alert.showAndWait();
        } else if (txt_usuario.getText().isEmpty()) {
            
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setContentText("No se puede verificar\nDebe ingresar un correo o usuario");
            alert.showAndWait();
        } else if (txt_clave.getText().isEmpty()) {
            
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setContentText("No se puede verificar\nDebe ingresar una contraseña");
            alert.showAndWait();
            
        } else {
            
            NodoUsuario usuario = lista.buscarPorCorreo(txt_usuario.getText());
            
            if (usuario != null && usuario.getClave().equals(txt_clave.getText())) {
                
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setContentText("BIENVENIDO..!");
                alert.showAndWait();                
                
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/Catalogo.fxml"));
                    Parent root = loader.load();
                    
                    CatalgoController controller = loader.getController();                    
                    controller.txtIdUser.setText("" + usuario.getIdentificacion());
                    
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    
                    stage.setScene(scene);
                    stage.setOnCloseRequest((WindowEvent value) -> {
                        controller.closeWindow();                        
                    });
                    stage.show();
                    
                    Stage miStage = (Stage) this.btn_iniciar.getScene().getWindow();
                    miStage.close();
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                txt_usuario.setText("");
                txt_clave.setText("");
                
            } else {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Alerta");
                alert.setContentText("Contraseña incorrecta");
                alert.showAndWait();                
                
                txt_clave.setText("");
                txt_clave.requestFocus();
            }
            
            if (usuario == null) {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Alerta");
                alert.setContentText("El Correo \nno está registrado o es erroneo, por favor verifique");
                alert.showAndWait();                
                
                txt_usuario.setText("");
                txt_clave.setText("");
                txt_usuario.requestFocus();
            }
        }
    }
    
}
