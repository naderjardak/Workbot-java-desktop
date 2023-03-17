/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import workbot_jobtn.services.OffreService;

/**
 * FXML Controller class
 *
 * @author Exon
 */
public class TestController implements Initializable {

    @FXML
    private HBox rootAjoutOffre;
    @FXML
    private VBox menu;
    @FXML
    private AnchorPane side_anker;
    @FXML
    private Button btnDashboard;
    @FXML
    private Button btnMenuOffre;
    @FXML
    private Button btnMenuEvent;
    @FXML
    private Button btnMenuEntretien;
    @FXML
    private Button fb;
    @FXML
    private Button fb1;
    @FXML
    private Button fb2;
    @FXML
    private Pane s;
    @FXML
    private TextField inputsearch;
    @FXML
    private Button btnUser;
    @FXML
    private Button settings;
    @FXML
    private Pane slide1;
    @FXML
    private Button btnSuivantStage;
    @FXML
    private RadioButton radio_oui;
    @FXML
    private RadioButton radio_non;
    @FXML
    private Label choice;
    @FXML
    private Pane root;
    @FXML
    private ToggleGroup test;
    @FXML
    private Label id_offre;
    @FXML
    private Button btnRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onclick_dash(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Alert");
        alert.setContentText("Votre avancement sera perdu");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            int id = Integer.parseInt(id_offre.getText());
            offreservice.deleteById(id);
            Parent fXMLLoader = FXMLLoader.load(getClass().getResource("HomeSociete.fxml"));
            Scene stage = new Scene(fXMLLoader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } else {
            alert.close();
        }
    }

    @FXML
    private void onClicked_menuOffre(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Alert");
        alert.setContentText("Votre avancement sera perdu");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            int id = Integer.parseInt(id_offre.getText());
            offreservice.deleteById(id);
            Parent fXMLLoader = FXMLLoader.load(getClass().getResource("Offre.fxml"));
            Scene stage = new Scene(fXMLLoader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } else {
            alert.close();
        }
    }

    @FXML
    private void OnClicked_menuEvent(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Alert");
        alert.setContentText("Votre avancement sera perdu");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            int id = Integer.parseInt(id_offre.getText());
            offreservice.deleteById(id);
            Parent fXMLLoader = FXMLLoader.load(getClass().getResource(""));
            Scene stage = new Scene(fXMLLoader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } else {
            alert.close();
        }
    }

    @FXML
    private void OnClicked_menuEntretiens(ActionEvent event) throws IOException {
        Alert Atc = new Alert(Alert.AlertType.CONFIRMATION);
        Atc.setHeaderText("Alert");
        Atc.setContentText("Votre avancement sera perdu");
        Optional<ButtonType> result = Atc.showAndWait();
        if (result.get() == ButtonType.OK) {
            Parent fXMLLoader = FXMLLoader.load(getClass().getResource("DisplayEntretiens.fxml"));
            Scene stage = new Scene(fXMLLoader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } else {
            Atc.close();
        }
    }

    @FXML
    private void Onclicked_fb(ActionEvent event) {
    }

    @FXML
    private void onKeyRealeased_showSearchPropositions(KeyEvent event) {
    }

    @FXML
    private void OnClick_UserIcon(ActionEvent event) {
    }

    @FXML
    private void OnClick_settings(ActionEvent event) {
    }
    OffreService offreservice = new OffreService();

    @FXML
    private void OnclickRetour(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Alert");
        alert.setContentText("Votre avancement sera perdu");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            int id = Integer.parseInt(id_offre.getText());
            offreservice.deleteById(id);

            if (choice.getText().equals("Stage")) {
                Parent fXMLLoader = FXMLLoader.load(getClass().getResource("OffreStage.fxml"));
                Scene stage = new Scene(fXMLLoader);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(stage);
                window.show();
            }
            if (choice.getText().equals("Emploi")) {
                Parent fXMLLoader = FXMLLoader.load(getClass().getResource("OffreEmploi.fxml"));
                Scene stage = new Scene(fXMLLoader);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(stage);
                window.show();
            }
            if (choice.getText().equals("Freelancer")) {
                Parent fXMLLoader = FXMLLoader.load(getClass().getResource("OffreFreelancer.fxml"));
                Scene stage = new Scene(fXMLLoader);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(stage);
                window.show();
            }
        } else {
            alert.close();
        }
    }

    @FXML
    private void onclickSuivantStage(ActionEvent event) throws IOException {
        if (radio_oui.isSelected()) {
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("ajouterTest.fxml"));
            Parent root = fXMLLoader.load();
            Scene stage = new Scene(root);
            AjouterTestController ajoutContr = fXMLLoader.getController();
            ajoutContr.setIdOffre(id_offre.getText());
            System.out.println(id_offre.getText());

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } else {
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("SuccesOffre.fxml"));

            Parent root1 = fxml.load();

            Scene scene = btnSuivantStage.getScene();

            root1.translateYProperty().set(scene.getHeight());
            root.getChildren().add(root1);

            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root1.translateYProperty(), 0, Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
            timeline.getKeyFrames().add(kf);
            timeline.setOnFinished(event1 -> root.getChildren().remove(slide1));
            timeline.play();
        }

    }

    public void setChoice(String choix) {

        choice.setText(choix);
    }

    public void setIdOffre(int id) {
        String StringId = String.valueOf(id);
        id_offre.setText(StringId);
    }
}
