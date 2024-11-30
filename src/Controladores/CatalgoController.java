package Controladores;

import Modelos.Gestor;
import Modelos.PilaCamisetas;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CatalgoController implements Initializable {

    private final PilaCamisetas pila = Gestor.obtenerInstancia().getPilaCamiseta();
    //Respaldos
    private ObservableList<Pane> respaldoBolsa;
    private ObservableList<Pane> respaldoListaDeseos;

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
    @FXML
    private HBox B_Rosada;
    @FXML
    private HBox B_Blanca;
    @FXML
    private HBox B_Verde;
    @FXML
    private HBox B_Roja;
    @FXML
    private HBox B_Gris;
    @FXML
    private ImageView btnHome2;
    @FXML
    private ImageView btnFav2;
    @FXML
    private ImageView btnBolsa2;
    @FXML
    private HBox LD_Gris;
    @FXML
    private HBox LD_Turqui;
    @FXML
    private HBox LD_Rojo;
    @FXML
    private HBox LD_Rosada;
    @FXML
    private HBox LD_Verde;
    @FXML
    private HBox LD_Blanca;
    @FXML
    private ImageView btnHome3;
    @FXML
    private ImageView btnFav3;
    @FXML
    private ImageView btnBolsa3;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

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

        } else if (event.getSource() == btn_historial) {

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
        } else if (event.getSource() == btnHome || event.getSource() == btnHome2 || event.getSource() == btnHome3) {
            if (!panel_catalogo.isVisible()) {
                panel_catalogo.setVisible(true);
                panel_bolsa.setVisible(false);
                panel_deseos.setVisible(false);
                panel_detalles.setVisible(false);
            }
        } else if (event.getSource() == btnBolsa || event.getSource() == btnBolsa2 || event.getSource() == btnBolsa3) {
            if (!panel_bolsa.isVisible()) {
                panel_bolsa.setVisible(true);
                panel_catalogo.setVisible(false);
                panel_deseos.setVisible(false);
                panel_detalles.setVisible(false);
            }
        } else if (event.getSource() == btnFav || event.getSource() == btnFav2 || event.getSource() == btnFav3) {
            if (!panel_deseos.isVisible()) {
                panel_deseos.setVisible(true);
                panel_bolsa.setVisible(false);
                panel_catalogo.setVisible(false);
                panel_detalles.setVisible(false);
            }
        }
    }

    @FXML
    private void eventAction(ActionEvent event) {
    }
}
