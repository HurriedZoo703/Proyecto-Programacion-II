package Controladores;

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
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CatalgoController implements Initializable {
    
    @FXML
    private Text btn_cerrarS;
    @FXML
    private Text btn_historial;
    @FXML
    private ImageView ima_C1;
    @FXML
    private ImageView ima_C2;
    @FXML
    private ImageView ima_C3;
    @FXML
    private ImageView ima_C4;
    @FXML
    private ImageView ima_C5;
    @FXML
    private ImageView ima_C6;
    @FXML
    private Pane panel_detalles;
    @FXML
    private Pane panel_catalogo;
    @FXML
    private Pane panel_bolsa;
    @FXML
    private Pane panel_deseos;
    @FXML
    private Button btnPasarC;
    @FXML
    private Button btnEliminarLD;
    @FXML
    private ImageView btnHome;
    @FXML
    private ImageView btnFav;
    @FXML
    private ImageView btnBolsa;
    
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
            
            Stage miStage = (Stage) this.btn_cerrarS.getScene().getWindow();
            miStage.close();
        } catch (IOException ex) {
            Logger.getLogger(CatalgoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void eventAction(MouseEvent event) {
        
        if (event.getSource() == btn_cerrarS) {
            
            closeWindow();
            
        } else if (event.getSource() == btn_cerrarS) {
            
            System.out.println("mientras");
            
        }
        
    }
    
    @FXML
    private void mouseCliked(MouseEvent event) {
        
        if (event.getSource() == ima_C1) {
            
        } else if (event.getSource() == ima_C2) {
        } else if (event.getSource() == ima_C3) {
        } else if (event.getSource() == ima_C4) {
            panel_catalogo.setVisible(false);
            panel_detalles.setVisible(true);
        } else if (event.getSource() == ima_C5) {
        } else if (event.getSource() == ima_C6) {
        } else if (event.getSource() == btnHome) {
            panel_catalogo.setVisible(true);
            panel_bolsa.setVisible(false);
            panel_deseos.setVisible(false);
            panel_detalles.setVisible(false);
        }
    }
    
    @FXML
    private void eventAction(ActionEvent event) {
    }
}
