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
        int id = Integer.parseInt(txtIdUser.getText());
        Stack<NodoCamiseta> pilaB = pila.getCamisetas(id);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Aviso");

        if (event.getSource() == btn_AgregarABolsa) {
            String URL_ima = imaDG.getUserData().toString();

            NodoCamiseta c = new NodoCamiseta(id, txtColorDG.getText(), URL_ima);

            if (pila.getPilaB().isEmpty()) {
                pila.setPush(c);
                pila.guardarCamisetas(pila.getPilaB());
                a.setContentText("Camiseta agregada exitosamente a la bolsa de compras...!");
                a.showAndWait();
            } else {
                if (pila.getPilaB().indexOf(c) != -1) {
                    a.setContentText("Esta camiseta ya a sido agregada a la bolsa de compras...!"
                            + "\nNo se pudo agregar.");
                    a.showAndWait();
                } else {
                    pila.setPush(c);
                    pila.guardarCamisetas(pila.getPilaB());
                    a.setContentText("Camiseta agregada exitosamente a la bolsa de compras...!");
                    a.showAndWait();
                }
            }
        } else if (event.getSource() == btn_AgregarADeseos) {
            String URL_ima = imaDG.getUserData().toString();

            NodoCamiseta c = new NodoCamiseta(id, txtColorDG.getText(), URL_ima);

            if (pila.getPilaLD().isEmpty()) {
                pila.setPushLD(c);
                pila.guardarCamisetasLD(pila.getPilaLD());
                a.setContentText("Camiseta agregada exitosamente a la lista de deseos...!");
                a.showAndWait();
            } else {
                if (pila.getPilaLD().indexOf(c) != -1) {
                    a.setContentText("Esta camiseta ya a sido agregada a la lista de deseos...!"
                            + "\nNo se pudo agregar.");
                    a.showAndWait();
                } else {
                    pila.setPushLD(c);
                    pila.guardarCamisetasLD(pila.getPilaLD());
                    a.setContentText("Camiseta agregada exitosamente a la lista de deseos...!");
                    a.showAndWait();
                }
            }
        } else if (event.getSource() == btnPasarB1) {

            NodoCamiseta c = new NodoCamiseta(id, "Gris", "/Imagenes/Camiseta-Gris.png");

            if (pilaB.isEmpty()) {
                pila.setPush(c);
                pila.guardarCamisetas(pila.getPilaB());
                a.setContentText("Camiseta agregada exitosamente a la bolsa de compras...!");
                a.showAndWait();
            } else {
                if (pilaB.indexOf(c) != -1) {
                    a.setContentText("Esta camiseta ya a sido agregada a la bolsa de compras...!"
                            + "\nNo se pudo agregar.");
                    a.showAndWait();
                } else {
                    pila.setPush(c);
                    pila.guardarCamisetas(pila.getPilaB());
                    a.setContentText("Camiseta agregada exitosamente a la bolsa de compras...!");
                    a.showAndWait();
                }
            }

        } else if (event.getSource() == btnPasarB2) {

            NodoCamiseta c = new NodoCamiseta(id, "Turqui", "/Imagenes/Camiseta-Turqui.png");

            if (pilaB.isEmpty()) {
                pila.setPush(c);
                pila.guardarCamisetas(pila.getPilaB());
                a.setContentText("Camiseta agregada exitosamente a la bolsa de compras...!");
                a.showAndWait();
            } else {
                if (pilaB.indexOf(c) != -1) {
                    a.setContentText("Esta camiseta ya a sido agregada a la bolsa de compras...!"
                            + "\nNo se pudo agregar.");
                    a.showAndWait();
                } else {
                    pila.setPush(c);
                    pila.guardarCamisetas(pila.getPilaB());
                    a.setContentText("Camiseta agregada exitosamente a la bolsa de compras...!");
                    a.showAndWait();
                }
            }
        } else if (event.getSource() == btnPasarB3) {

            NodoCamiseta c = new NodoCamiseta(id, "Roja", "/Imagenes/Camiseta-Roja.png");

            if (pilaB.isEmpty()) {
                pila.setPush(c);
                pila.guardarCamisetas(pila.getPilaB());
                a.setContentText("Camiseta agregada exitosamente a la bolsa de compras...!");
                a.showAndWait();
            } else {
                if (pilaB.indexOf(c) != -1) {
                    a.setContentText("Esta camiseta ya a sido agregada a la bolsa de compras...!"
                            + "\nNo se pudo agregar.");
                    a.showAndWait();
                } else {
                    pila.setPush(c);
                    pila.guardarCamisetas(pila.getPilaB());
                    a.setContentText("Camiseta agregada exitosamente a la bolsa de compras...!");
                    a.showAndWait();
                }
            }
        } else if (event.getSource() == btnPasarB4) {

            NodoCamiseta c = new NodoCamiseta(id, "Rosa", "/Imagenes/Camiseta-Rosa.png");

            if (pilaB.isEmpty()) {
                pila.setPush(c);
                pila.guardarCamisetas(pila.getPilaB());
                a.setContentText("Camiseta agregada exitosamente a la bolsa de compras...!");
                a.showAndWait();
            } else {
                if (pilaB.indexOf(c) != -1) {
                    a.setContentText("Esta camiseta ya a sido agregada a la bolsa de compras...!"
                            + "\nNo se pudo agregar.");
                    a.showAndWait();
                } else {
                    pila.setPush(c);
                    pila.guardarCamisetas(pila.getPilaB());
                    a.setContentText("Camiseta agregada exitosamente a la bolsa de compras...!");
                    a.showAndWait();
                }
            }
        } else if (event.getSource() == btnPasarB5) {

            NodoCamiseta c = new NodoCamiseta(id, "Verde", "/Imagenes/Camiseta-Verde.png");

            if (pilaB.isEmpty()) {
                pila.setPush(c);
                pila.guardarCamisetas(pila.getPilaB());
                a.setContentText("Camiseta agregada exitosamente a la bolsa de compras...!");
                a.showAndWait();
            } else {
                if (pilaB.indexOf(c) != -1) {
                    a.setContentText("Esta camiseta ya a sido agregada a la bolsa de compras...!"
                            + "\nNo se pudo agregar.");
                    a.showAndWait();
                } else {
                    pila.setPush(c);
                    pila.guardarCamisetas(pila.getPilaB());
                    a.setContentText("Camiseta agregada exitosamente a la bolsa de compras...!");
                    a.showAndWait();
                }
            }
        } else if (event.getSource() == btnPasarB6) {

            NodoCamiseta c = new NodoCamiseta(id, "Blanca", "/Imagenes/Camiseta-Blanca.png");

            if (pilaB.isEmpty()) {
                pila.setPush(c);
                pila.guardarCamisetas(pila.getPilaB());
                a.setContentText("Camiseta agregada exitosamente a la bolsa de compras...!");
                a.showAndWait();
            } else {
                if (pilaB.indexOf(c) != -1) {
                    a.setContentText("Esta camiseta ya a sido agregada a la bolsa de compras...!"
                            + "\nNo se pudo agregar.");
                    a.showAndWait();
                } else {
                    pila.setPush(c);
                    pila.guardarCamisetas(pila.getPilaB());
                    a.setContentText("Camiseta agregada exitosamente a la bolsa de compras...!");
                    a.showAndWait();
                }
            }
        } else if (event.getSource() == btnEliminarLD1) {
            flowLD.getChildren().remove(LD_Gris);
            pila.eliminarLD(id, "Gris");
            pila.guardarCamisetasLD(pila.getPilaLD());
        } else if (event.getSource() == btnEliminarLD2) {
            flowLD.getChildren().remove(LD_Turqui);
            pila.eliminarLD(id, "Turqui");
            pila.guardarCamisetasLD(pila.getPilaLD());
        } else if (event.getSource() == btnEliminarLD3) {
            flowLD.getChildren().remove(LD_Roja);
            pila.eliminarLD(id, "Roja");
            pila.guardarCamisetasLD(pila.getPilaLD());
        } else if (event.getSource() == btnEliminarLD4) {
            flowLD.getChildren().remove(LD_Rosa);
            pila.eliminarLD(id, "Rosa");
            pila.guardarCamisetasLD(pila.getPilaLD());
        } else if (event.getSource() == btnEliminarLD5) {
            flowLD.getChildren().remove(LD_Verde);
            pila.eliminarLD(id, "Verde");
            pila.guardarCamisetasLD(pila.getPilaLD());
        } else if (event.getSource() == btnEliminarLD6) {
            flowLD.getChildren().remove(LD_Blanca);
            pila.eliminarLD(id, "Blanca");
            pila.guardarCamisetasLD(pila.getPilaLD());
        }
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

    @FXML
    private void toggleCant(MouseEvent event) {

        ImageView ima = (ImageView) event.getSource();

        switch (ima.getParent().getId()) {
            case "B_Rosa":
                if (event.getSource() == aum1) {
                    int dato = Integer.parseInt(cont1.getText()) + 1;
                    cont1.setText("" + dato);
                } else if (event.getSource() == dec1) {
                    int dato = Integer.parseInt(cont1.getText()) - 1;
                    if (dato >= 0) {
                        cont1.setText("" + dato);
                    } else {
                        flowBolsa.getChildren().remove(B_Rosa);
                    }
                }
                break;
            case "B_Blanca":
                if (event.getSource() == aum2) {
                    int dato = Integer.parseInt(cont2.getText()) + 1;
                    cont2.setText("" + dato);
                } else if (event.getSource() == dec2) {
                    int dato = Integer.parseInt(cont2.getText()) - 1;
                    if (dato >= 0) {
                        cont2.setText("" + dato);
                    } else {
                        flowBolsa.getChildren().remove(B_Blanca);
                    }
                }
                break;
            case "B_Verde":
                if (event.getSource() == aum3) {
                    int dato = Integer.parseInt(cont3.getText()) + 1;
                    cont3.setText("" + dato);
                } else if (event.getSource() == dec3) {
                    int dato = Integer.parseInt(cont3.getText()) - 1;
                    if (dato >= 0) {
                        cont3.setText("" + dato);
                    } else {
                        flowBolsa.getChildren().remove(B_Verde);
                    }
                }
                break;
            case "B_Roja":
                if (event.getSource() == aum4) {
                    int dato = Integer.parseInt(cont4.getText()) + 1;
                    cont4.setText("" + dato);
                } else if (event.getSource() == dec4) {
                    int dato = Integer.parseInt(cont4.getText()) - 1;
                    if (dato >= 0) {
                        cont4.setText("" + dato);
                    } else {
                        flowBolsa.getChildren().remove(B_Roja);
                    }
                }
                break;
            case "B_Gris":
                if (event.getSource() == aum5) {
                    int dato = Integer.parseInt(cont5.getText()) + 1;
                    cont5.setText("" + dato);
                } else if (event.getSource() == dec5) {
                    int dato = Integer.parseInt(cont5.getText()) - 1;
                    if (dato >= 0) {
                        cont5.setText("" + dato);
                    } else {
                        flowBolsa.getChildren().remove(B_Gris);
                    }
                }
                break;
            case "B_Turqui":
                if (event.getSource() == aum6) {
                    int dato = Integer.parseInt(cont6.getText()) + 1;
                    cont6.setText("" + dato);
                } else if (event.getSource() == dec6) {
                    int dato = Integer.parseInt(cont6.getText()) - 1;
                    if (dato >= 0) {
                        cont6.setText("" + dato);
                    } else {
                        flowBolsa.getChildren().remove(B_Turqui);
                    }
                }
                break;

            default:
                throw new AssertionError();
        }
    }
}
