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
import javafx.scene.control.Label;
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
    @FXML
    private Button btnPasarB1;
    @FXML
    private Button btnEliminarLD1;
    @FXML
    private Button btnPasarB2;
    @FXML
    private Button btnEliminarLD2;
    @FXML
    private Button btnPasarB3;
    @FXML
    private Button btnEliminarLD3;
    @FXML
    private Button btnPasarB4;
    @FXML
    private Button btnEliminarLD4;
    @FXML
    private Button btnPasarB5;
    @FXML
    private Button btnEliminarLD5;
    @FXML
    private Button btnPasarB6;
    @FXML
    private Button btnEliminarLD6;
    @FXML
    private Label NO_HAY;
    @FXML
    private Button btnComprarGN;
    @FXML
    private Text txtTotal;

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
                imaDG.setUserData("/Imagenes/Camiseta-Gris.png");
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
                imaDG.setUserData("/Imagenes/Camiseta-Blanca.png");
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
                imaDG.setUserData("/Imagenes/Camiseta-Roja.png");
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
                imaDG.setUserData("/Imagenes/Camiseta-Rosa.png");
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
                imaDG.setUserData("/Imagenes/Camiseta-Turqui.png");
                txtColorDG.setText("Turqui");
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
                imaDG.setUserData("/Imagenes/Camiseta-Verde.png");
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
                NO_HAY.setVisible(false);
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

    private void agregarBolsa(int id, String color, String URL_ima, Text cont) {
        NodoCamiseta camiseta = new NodoCamiseta(id, color, URL_ima);
        Alert a = new Alert(Alert.AlertType.INFORMATION);

        if (pila.getPilaB().stream().anyMatch(b -> b.getColor().equals(color) && b.getIdPropietario() == id)) {
            switch (cont.getId()) {
                case "cont1":
                    cont1.setText((Integer.parseInt(cont1.getText()) + 1) + "");
                    break;
                case "cont2":
                    cont2.setText((Integer.parseInt(cont2.getText()) + 1) + "");
                    break;
                case "cont3":
                    cont3.setText((Integer.parseInt(cont3.getText()) + 1) + "");
                    break;
                case "cont4":
                    cont4.setText((Integer.parseInt(cont4.getText()) + 1) + "");
                    break;
                default:
                    throw new AssertionError();
            }

            a.setTitle("Info");
            a.setContentText("Camiseta agregada exitosamente la bolsa de compras. Indice aumentado en 1.");
            a.showAndWait();
            return;
        }

        pila.setPush(camiseta);
        pila.guardarCamisetas();

        NodoCamiseta camisetaDes = pila.getCamisetaLD(id, color);
        if (camisetaDes != null) {
            pila.eliminarLD(id, color);
            pila.guardarCamisetasLD();
        }

        a.setTitle("Info");
        a.setContentText("Camiseta agregada exitosamente a la bolsa de compras.");
        a.showAndWait();
    }

    private void agregarDeseos(int id, String color, String URL_ima) {
        NodoCamiseta camiseta = new NodoCamiseta(id, color, URL_ima);
        Alert a = new Alert(Alert.AlertType.INFORMATION);

        if (pila.getPilaLD().stream().anyMatch(b -> b.getColor().equals(color) && b.getIdPropietario() == id)) {
            a.setTitle("Info");
            a.setContentText("Camiseta agregada exitosamente a deseadas.");
            a.showAndWait();
            return;
        }

        pila.setPushLD(camiseta);
        pila.guardarCamisetasLD();

        NodoCamiseta cam = pila.getCamiseta(id, color);
        if (cam != null) {
            pila.eliminar(id, color);
            pila.guardarCamisetas();
        }

        a.setTitle("Info");
        a.setContentText("Camiseta agregada exitosamente a deseadas.");
        a.showAndWait();
    }

    private void moverCamisetaBolsa(int idUsuario, NodoCamiseta camiseta, FlowPane flowDeseo, HBox camisetaHB) {
        Stack<NodoCamiseta> pilaAux = pila.getCamisetas(idUsuario);
        Alert a = new Alert(Alert.AlertType.INFORMATION);

        if (pilaAux.stream().anyMatch(b -> b.getColor().equals(camiseta.getColor()) && camiseta.getIdPropietario() == idUsuario)) {
            a.setTitle("Aviso");
            a.setContentText("La camiseta ya ha sido agregada a la bolsa..!");
            a.showAndWait();
            return;
        }

        pila.setPush(camiseta);
        pila.guardarCamisetas();
        a.setTitle("Aviso");
        a.setContentText("Camiseta agregada de forma esxitosa a la bolsa..!");
        a.showAndWait();

        flowDeseo.getChildren().remove(camisetaHB);
        pila.popCamisetaLD(idUsuario, camiseta.getColor());
        pila.guardarCamisetasLD();
    }

    @FXML
    private void eventAction(ActionEvent event) {
        int id = Integer.parseInt(txtIdUser.getText());
        Stack<NodoCamiseta> pilaB = pila.getCamisetas(id);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Aviso");

        if (event.getSource() == btn_AgregarABolsa) {

            switch (imaDG.getUserData().toString()) {
                case "/Imagenes/Camiseta-Gris.png":
                    agregarBolsa(id, "Gris", "/Imagenes/Camiseta-Gris.png", cont1);
                    break;
                case "/Imagenes/Camiseta-Blanca.png":
                    agregarBolsa(id, "Blanca", "/Imagenes/Camiseta-Blanca.png", cont2);
                    break;
                case "/Imagenes/Camiseta-Roja.png":
                    agregarBolsa(id, "Roja", "/Imagenes/Camiseta-Roja.png", cont3);
                    break;
                case "/Imagenes/Camiseta-Rosa.png":
                    agregarBolsa(id, "Rosa", "/Imagenes/Camiseta-Rosa.png", cont4);
                    break;
                case "/Imagenes/Camiseta-Turqui.png":
                    agregarBolsa(id, "Turqui", "/Imagenes/Camiseta-Turqui.png", cont5);
                    break;
                case "/Imagenes/Camiseta-Verde.png":
                    agregarBolsa(id, "Verde", "/Imagenes/Camiseta-Verde.png", cont6);
                    break;
                default:
                    throw new AssertionError();
            }

        } else if (event.getSource() == btn_AgregarADeseos) {
            switch (imaDG.getUserData().toString()) {
                case "/Imagenes/Camiseta-Gris.png":
                    agregarDeseos(id, "Gris", "/Imagenes/Camiseta-Gris.png");
                    break;
                case "/Imagenes/Camiseta-Blanca.png":
                    agregarDeseos(id, "Blanca", "/Imagenes/Camiseta-Blanca.png");
                    break;
                case "/Imagenes/Camiseta-Roja.png":
                    agregarDeseos(id, "Roja", "/Imagenes/Camiseta-Roja.png");
                    break;
                case "/Imagenes/Camiseta-Rosa.png":
                    agregarDeseos(id, "Rosa", "/Imagenes/Camiseta-Rosa.png");
                    break;
                case "/Imagenes/Camiseta-Turqui.png":
                    agregarDeseos(id, "Turqui", "/Imagenes/Camiseta-Turqui.png");
                    break;
                case "/Imagenes/Camiseta-Verde.png":
                    agregarDeseos(id, "Verde", "/Imagenes/Camiseta-Verde.png");
                    break;
                default:
                    throw new AssertionError();
            }
        } else if (event.getSource() == btnPasarB1) {
            NodoCamiseta camiseta = new NodoCamiseta(id, "Gris", "/Imagenes/Camiseta-Gris.png");
            moverCamisetaBolsa(id, camiseta, flowLD, LD_Gris);
        } else if (event.getSource() == btnPasarB2) {

            NodoCamiseta camiseta = new NodoCamiseta(id, "Turqui", "/Imagenes/Camiseta-Turqui.png");

            moverCamisetaBolsa(id, camiseta, flowLD, LD_Turqui);
        } else if (event.getSource() == btnPasarB3) {

            NodoCamiseta camiseta = new NodoCamiseta(id, "Roja", "/Imagenes/Camiseta-Roja.png");

            moverCamisetaBolsa(id, camiseta, flowLD, LD_Roja);
        } else if (event.getSource() == btnPasarB4) {

            NodoCamiseta camiseta = new NodoCamiseta(id, "Rosa", "/Imagenes/Camiseta-Rosa.png");

            moverCamisetaBolsa(id, camiseta, flowLD, LD_Rosa);
        } else if (event.getSource() == btnPasarB5) {

            NodoCamiseta camiseta = new NodoCamiseta(id, "Verde", "/Imagenes/Camiseta-Verde.png");

            moverCamisetaBolsa(id, camiseta, flowLD, LD_Verde);
        } else if (event.getSource() == btnPasarB6) {

            NodoCamiseta camiseta = new NodoCamiseta(id, "Blanca", "/Imagenes/Camiseta-Blanca.png");

            moverCamisetaBolsa(id, camiseta, flowLD, LD_Verde);
        } else if (event.getSource() == btnEliminarLD1) {
            flowLD.getChildren().remove(LD_Gris);
            pila.eliminarLD(id, "Gris");
            pila.guardarCamisetasLD();
            pila.cargarCamisetasLD();
            mostrarCamisetasLD();
        } else if (event.getSource() == btnEliminarLD2) {
            flowLD.getChildren().remove(LD_Turqui);
            pila.eliminarLD(id, "Turqui");
            pila.guardarCamisetasLD();
            pila.cargarCamisetasLD();
            mostrarCamisetasLD();
        } else if (event.getSource() == btnEliminarLD3) {
            flowLD.getChildren().remove(LD_Roja);
            pila.eliminarLD(id, "Roja");
            pila.guardarCamisetasLD();
            pila.cargarCamisetasLD();
            mostrarCamisetasLD();
        } else if (event.getSource() == btnEliminarLD4) {
            flowLD.getChildren().remove(LD_Rosa);
            pila.eliminarLD(id, "Rosa");
            pila.guardarCamisetasLD();
            pila.cargarCamisetasLD();
            mostrarCamisetasLD();
        } else if (event.getSource() == btnEliminarLD5) {
            flowLD.getChildren().remove(LD_Verde);
            pila.eliminarLD(id, "Verde");
            pila.guardarCamisetasLD();
            pila.cargarCamisetasLD();
            mostrarCamisetasLD();
        } else if (event.getSource() == btnEliminarLD6) {
            flowLD.getChildren().remove(LD_Blanca);
            pila.eliminarLD(id, "Blanca");
            pila.guardarCamisetasLD();
            pila.cargarCamisetasLD();
            mostrarCamisetasLD();
        }
    }

    public void mostrarCamisetasB() {
        try {
            flowBolsa.getChildren().clear();
            flowBolsa.getChildren().addAll(respaldoBolsa);

            int idPropietario = Integer.parseInt(txtIdUser.getText());

            Stack<NodoCamiseta> camisetas = pila.getCamisetas(idPropietario);

            if (camisetas == null) {

                flowBolsa.getChildren().clear();
                NO_HAY.setVisible(true);
                return;
            }

            List<HBox> camisetasAagregar = new ArrayList<>();

            if (!flowBolsa.getChildren().isEmpty()) {
                Stack<NodoCamiseta> pilaB = pila.getCamisetas(idPropietario);

                for (NodoCamiseta camiseta : pilaB) {
                    for (Node node : flowBolsa.getChildren()) {
                        HBox newHbox = (HBox) node;
                        String color = camiseta.getColor();
                        if (newHbox.getId().equals("B_" + color)) {
                            camisetasAagregar.add(newHbox);
                        }
                    }
                }

                if (camisetasAagregar.isEmpty()) {
                    flowBolsa.getChildren().clear();
                    NO_HAY.setVisible(true);
                } else {
                    flowBolsa.getChildren().clear();
                    flowBolsa.getChildren().addAll(camisetasAagregar);
                    NO_HAY.setVisible(false);
                }
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

            Stack<NodoCamiseta> camiseta1 = pila.getCamisetasLD(idPropietario);

            if (camiseta1 == null) {

                flowLD.getChildren().clear();
                NO_HAY.setVisible(true);
                return;
            }

            List<HBox> camisetasAagregar = new ArrayList<>();

            if (!flowLD.getChildren().isEmpty()) {
                Stack<NodoCamiseta> pilaLD = pila.getCamisetasLD(idPropietario);

                for (NodoCamiseta camiseta : pilaLD) {
                    for (Node node : flowLD.getChildren()) {
                        HBox newHBox = (HBox) node;
                        String color = camiseta.getColor();
                        if (newHBox.getId().equals("LD_" + color)) {
                            camisetasAagregar.add(newHBox);
                        }
                    }
                }

                if (camisetasAagregar.isEmpty()) {
                    flowLD.getChildren().clear();
                    NO_HAY.setVisible(true);
                } else {
                    flowLD.getChildren().clear();
                    flowLD.getChildren().addAll(camisetasAagregar);
                    NO_HAY.setVisible(false);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Se produjo un error: " + e.getMessage());
        }
    }
    private float valor = 0;
    @FXML
    private void toggleCant(MouseEvent event) {
        int id = Integer.parseInt(txtIdUser.getText());               

        if (event.getSource() == btnComprarGN) {

            Stack<NodoCamiseta> camisetas = pila.getCamisetas(id);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Aviso");
            if (camisetas != null) {
                a.setContentText("Su compra ha sido exitosa, por un costo de: " + txtTotal.getText());
                a.showAndWait();
                for (NodoCamiseta camiseta : camisetas) {
                    pila.popCamiseta(id, camiseta.getColor());
                }
                valor = 0;
                txtTotal.setText("00000.0 COP");
                pila.guardarCamisetas();
                mostrarCamisetasB();
            }
        } else {
            ImageView ima = (ImageView) event.getSource();
            
            switch (ima.getParent().getId()) {
                case "B_Rosa":
                    if (event.getSource() == aum1) {
                        int dato = Integer.parseInt(cont1.getText()) + 1;
                        cont1.setText("" + dato);
                        valor += 45000.0f;
                        txtTotal.setText((valor) + " COP");
                    } else if (event.getSource() == dec1) {
                        int dato = Integer.parseInt(cont1.getText()) - 1;
                        if (dato >= 0) {
                            cont1.setText("" + dato);
                            valor -= 45000.0f;
                            txtTotal.setText((valor) + " COP");
                        } else {
                            flowBolsa.getChildren().remove(B_Rosa);
                            pila.eliminar(id, "Rosa");
                            pila.guardarCamisetas();
                            pila.cargarCamisetas();
                            mostrarCamisetasB();
                        }
                    }
                    break;
                case "B_Blanca":
                    if (event.getSource() == aum2) {
                        int dato = Integer.parseInt(cont2.getText()) + 1;
                        cont2.setText("" + dato);
                        valor += 45000.0f;
                        txtTotal.setText((valor) + " COP");
                    } else if (event.getSource() == dec2) {
                        int dato = Integer.parseInt(cont2.getText()) - 1;
                        if (dato >= 0) {
                            cont2.setText("" + dato);
                            valor -= 45000.0f;
                            txtTotal.setText((valor) + " COP");
                        } else {
                            flowBolsa.getChildren().remove(B_Blanca);
                            pila.eliminar(id, "Blanca");
                            pila.guardarCamisetas();
                            pila.cargarCamisetas();
                            mostrarCamisetasB();
                        }
                    }
                    break;
                case "B_Verde":
                    if (event.getSource() == aum3) {
                        int dato = Integer.parseInt(cont3.getText()) + 1;
                        cont3.setText("" + dato);
                        valor += 45000.0f;
                        txtTotal.setText((valor) + " COP");
                    } else if (event.getSource() == dec3) {
                        int dato = Integer.parseInt(cont3.getText()) - 1;
                        if (dato >= 0) {
                            cont3.setText("" + dato);
                            valor -= 45000.0f;
                            txtTotal.setText((valor) + " COP");
                        } else {
                            flowBolsa.getChildren().remove(B_Verde);
                            pila.eliminar(id, "Verde");
                            pila.guardarCamisetas();
                            pila.cargarCamisetas();
                            mostrarCamisetasB();
                        }
                    }
                    break;
                case "B_Roja":
                    if (event.getSource() == aum4) {
                        int dato = Integer.parseInt(cont4.getText()) + 1;
                        cont4.setText("" + dato);
                        valor += 45000.0f;
                        txtTotal.setText((valor) + " COP");
                    } else if (event.getSource() == dec4) {
                        int dato = Integer.parseInt(cont4.getText()) - 1;
                        if (dato >= 0) {
                            cont4.setText("" + dato);
                            valor -= 45000.0f;
                            txtTotal.setText((valor) + " COP");
                        } else {
                            flowBolsa.getChildren().remove(B_Roja);
                            pila.eliminar(id, "Roja");
                            pila.guardarCamisetas();
                            pila.cargarCamisetas();
                            mostrarCamisetasB();
                        }
                    }
                    break;
                case "B_Gris":
                    if (event.getSource() == aum5) {
                        int dato = Integer.parseInt(cont5.getText()) + 1;
                        cont5.setText("" + dato);
                        valor += 45000.0f;
                        txtTotal.setText((valor) + " COP");
                    } else if (event.getSource() == dec5) {
                        int dato = Integer.parseInt(cont5.getText()) - 1;
                        if (dato >= 0) {
                            cont5.setText("" + dato);
                            valor -= 45000.0f;
                            txtTotal.setText((valor) + " COP");
                        } else {
                            flowBolsa.getChildren().remove(B_Gris);
                            pila.eliminar(id, "Gris");
                            pila.guardarCamisetas();
                            pila.cargarCamisetas();
                            mostrarCamisetasB();
                        }
                    }
                    break;
                case "B_Turqui":
                    if (event.getSource() == aum6) {
                        int dato = Integer.parseInt(cont6.getText()) + 1;
                        cont6.setText("" + dato);
                        valor += 45000.0f;
                        txtTotal.setText((valor) + " COP");
                    } else if (event.getSource() == dec6) {
                        int dato = Integer.parseInt(cont6.getText()) - 1;
                        if (dato >= 0) {
                            cont6.setText("" + dato);
                            valor -= 45000.0f;
                            txtTotal.setText((valor) + " COP");
                        } else {
                            flowBolsa.getChildren().remove(B_Turqui);
                            pila.eliminar(id, "Turqui");
                            pila.guardarCamisetas();
                            pila.cargarCamisetas();
                            mostrarCamisetasB();
                        }
                    }
                    break;

                default:
                    throw new AssertionError();
            }
        }
    }
}
