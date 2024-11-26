package Controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
}
