package Controladores;

import Modelos.Gestor;
import Modelos.NodoCamiseta;
import Modelos.PilaCamisetas;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
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
    private HBox B_Blanca;
    @FXML
    private HBox B_Verde;
    @FXML
    private HBox B_Roja;
    @FXML
    private HBox B_Gris;
    @FXML
    private HBox B_Turqui;
    @FXML
    private HBox B_Rosa;
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
    private HBox LD_Verde;
    @FXML
    private HBox LD_Blanca;
    @FXML
    private HBox LD_Roja;
    @FXML
    private HBox LD_Rosa;
    @FXML
    private ImageView btnHome3;
    @FXML
    private ImageView btnFav3;
    @FXML
    private ImageView btnBolsa3;
    @FXML
    private FlowPane flowBolsa;
    @FXML
    private FlowPane flowLD;
    @FXML
    public Text txtIdUser;
    @FXML
    private ComboBox<String> combDG;
    @FXML
    private ImageView btnFav4;
    @FXML
    private ImageView btnBolsa4;
    @FXML
    private ComboBox<String> comb1;
    @FXML
    private ComboBox<String> comb2;
    @FXML
    private ComboBox<String> comb3;
    @FXML
    private ComboBox<String> comb4;
    @FXML
    private ComboBox<String> comb5;
    @FXML
    private ComboBox<String> comb6;
    @FXML
    private ImageView imaDG;
    @FXML
    private Button btn_AgregarABolsa;
    @FXML
    private Button btn_AgregarADeseos;
    @FXML
    private Text txtColorDG;
    @FXML
    private Text cont1;
    @FXML
    private Text cont2;
    @FXML
    private Text cont3;
    @FXML
    private Text cont4;
    @FXML
    private Text cont5;
    @FXML
    private Text cont6;
    @FXML
    private ImageView aum1;
    @FXML
    private ImageView dec1;
    @FXML
    private ImageView aum2;
    @FXML
    private ImageView dec2;
    @FXML
    private ImageView aum3;
    @FXML
    private ImageView dec3;
    @FXML
    private ImageView aum4;
    @FXML
    private ImageView dec4;
    @FXML
    private ImageView aum5;
    @FXML
    private ImageView dec5;
    @FXML
    private ImageView aum6;
    @FXML
    private ImageView dec6;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] tallas = {"S", "M", "L", "XL"};
        comb1.getItems().addAll(tallas);
        comb2.getItems().addAll(tallas);
        comb3.getItems().addAll(tallas);
        comb4.getItems().addAll(tallas);
        comb5.getItems().addAll(tallas);
        comb6.getItems().addAll(tallas);
        combDG.getItems().addAll(tallas);

        respaldoBolsa = FXCollections.observableArrayList();
        respaldoListaDeseos = FXCollections.observableArrayList();

        flowBolsa.getChildren().stream().map(node -> (Pane) node).forEachOrdered(newPane -> {
            respaldoBolsa.add(newPane);
        });

        flowLD.getChildren().stream().map(node -> (Pane) node).forEachOrdered(newPane -> {
            respaldoListaDeseos.add(newPane);
        });
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
    private void mouseEvent(MouseEvent event) {

        if (event.getSource() == btn_cerrarS) {

            closeWindow();

        } else if (event.getSource() == btn_historial) {

            System.out.println("mientras");

        }

    }

    @FXML
    private void mouseCliked(MouseEvent event) {

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Aviso");
        a.setContentText("Primero debe seleccionar una talla");

        if (event.getSource() == ima_C1) {
            if (comb1.getValue() != null) {
                panel_catalogo.setVisible(false);
                panel_detalles.setVisible(true);

                Image ima = new Image(getClass().getResourceAsStream("/Imagenes/Camiseta-Gris.png"));
                combDG.setValue(comb1.getValue());
                imaDG.setImage(ima);
                txtColorDG.setText("Gris");
            } else {
                a.showAndWait();
            }
        } else if (event.getSource() == ima_C2) {
            if (comb2.getValue() != null) {
                panel_catalogo.setVisible(false);
                panel_detalles.setVisible(true);

                Image ima = new Image(getClass().getResourceAsStream("/Imagenes/Camiseta-Blanca.png"));
                combDG.setValue(comb2.getValue());
                imaDG.setImage(ima);
                txtColorDG.setText("Blanca");
            } else {
                a.showAndWait();
            }

        } else if (event.getSource() == ima_C3) {
            if (comb3.getValue() != null) {
                panel_catalogo.setVisible(false);
                panel_detalles.setVisible(true);

                Image ima = new Image(getClass().getResourceAsStream("/Imagenes/Camiseta-Roja.png"));
                combDG.setValue(comb3.getValue());
                imaDG.setImage(ima);
                txtColorDG.setText("Roja");
            } else {
                a.showAndWait();
            }
        } else if (event.getSource() == ima_C4) {
            if (comb4.getValue() != null) {
                panel_catalogo.setVisible(false);
                panel_detalles.setVisible(true);

                Image ima = new Image(getClass().getResourceAsStream("/Imagenes/Camiseta-Rosa.png"));
                combDG.setValue(comb4.getValue());
                imaDG.setImage(ima);
                txtColorDG.setText("Rosa");
            } else {
                a.showAndWait();
            }
        } else if (event.getSource() == ima_C5) {
            if (comb5.getValue() != null) {
                panel_catalogo.setVisible(false);
                panel_detalles.setVisible(true);

                Image ima = new Image(getClass().getResourceAsStream("/Imagenes/Camiseta-Turqui.png"));
                combDG.setValue(comb5.getValue());
                imaDG.setImage(ima);
                txtColorDG.setText("Azul Turqui");
            } else {
                a.showAndWait();
            }
        } else if (event.getSource() == ima_C6) {
            if (comb6.getValue() != null) {
                panel_catalogo.setVisible(false);
                panel_detalles.setVisible(true);

                Image ima = new Image(getClass().getResourceAsStream("/Imagenes/Camiseta-Verde.png"));
                combDG.setValue(comb6.getValue());
                imaDG.setImage(ima);
                txtColorDG.setText("Verde");
            } else {
                a.showAndWait();
            }
        } else if (event.getSource() == btnHome || event.getSource() == btnHome2 || event.getSource() == btnHome3) {
            if (!panel_catalogo.isVisible()) {
                panel_catalogo.setVisible(true);
                panel_bolsa.setVisible(false);
                panel_deseos.setVisible(false);
                panel_detalles.setVisible(false);
            }
        } else if (event.getSource() == btnBolsa || event.getSource() == btnBolsa2 || event.getSource() == btnBolsa3 || event.getSource() == btnBolsa4) {
            if (!panel_bolsa.isVisible()) {
                panel_bolsa.setVisible(true);
                panel_catalogo.setVisible(false);
                panel_deseos.setVisible(false);
                panel_detalles.setVisible(false);
                mostrarCamisetasB();
            }
        } else if (event.getSource() == btnFav || event.getSource() == btnFav2 || event.getSource() == btnFav3 || event.getSource() == btnFav4) {
            if (!panel_deseos.isVisible()) {
                panel_deseos.setVisible(true);
                panel_bolsa.setVisible(false);
                panel_catalogo.setVisible(false);
                panel_detalles.setVisible(false);
                mostrarCamisetasLD();
            }
        }
    }

    @FXML
    private void eventAction(ActionEvent event) {
    }

    public void mostrarCamisetasB() {
        try {
            flowBolsa.getChildren().clear();
            flowBolsa.getChildren().addAll(respaldoBolsa);

            int idPropietario = Integer.parseInt(txtIdUser.getText());

            NodoCamiseta camiseta1 = pila.getCamiseta(idPropietario);

            if (camiseta1 == null) {

                System.out.println("No se encontró ninguna camiseta para el usuario: " + txtIdUser.getText());
                return;
            }

            List<HBox> camisetasAagregar = new ArrayList<>();

            if (!flowBolsa.getChildren().isEmpty()) {
                Stack<NodoCamiseta> pilaB = pila.getCamisetas(camiseta1.getIdPropietario());

                for (NodoCamiseta camiseta : pilaB) {
                    for (Node node : flowBolsa.getChildren()) {
                        HBox newHbox = (HBox) node;
                        String color = camiseta.getColor();
                        if (newHbox.getId().equals("B_" + color)) {
                            camisetasAagregar.add(newHbox);
                        }
                    }
                }

                flowBolsa.getChildren().clear();
                flowBolsa.getChildren().addAll(camisetasAagregar);
            }
        } catch (NullPointerException e) {
            System.out.println("Se produjo un error: " + e.getMessage());
        }
    }

    public void mostrarCamisetasLD() {
        try {
            flowLD.getChildren().clear();
            flowLD.getChildren().addAll(respaldoListaDeseos);

            int idPropietario = Integer.parseInt(txtIdUser.getText());

            NodoCamiseta camiseta1 = pila.getCamisetaLD(idPropietario);

            if (camiseta1 == null) {

                System.out.println("No se encontró ninguna camiseta para el usuario: " + txtIdUser.getText());
                return;
            }

            List<HBox> camisetasAagregar = new ArrayList<>();

            if (!flowLD.getChildren().isEmpty()) {
                Stack<NodoCamiseta> pilaLD = pila.getCamisetasLD(camiseta1.getIdPropietario());

                for (NodoCamiseta camiseta : pilaLD) {
                    for (Node node : flowLD.getChildren()) {
                        HBox newHBox = (HBox) node;
                        String color = camiseta.getColor();
                        if (newHBox.getId().equals("LD_" + color)) {
                            camisetasAagregar.add(newHBox);
                        }
                    }
                }

                flowLD.getChildren().clear();
                flowLD.getChildren().addAll(camisetasAagregar);
            }
        } catch (NullPointerException e) {
            System.out.println("Se produjo un error: " + e.getMessage());
        }
    }  

}
