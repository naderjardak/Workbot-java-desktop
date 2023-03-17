/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import workbot_jobtn.entites.Offre;
import workbot_jobtn.entites.Test;
import workbot_jobtn.services.OffreService;
import workbot_jobtn.services.TestService;
import workbot_jobtn.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author Exon
 */
public class AjouterTestController implements Initializable {

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
    private Label choice;
    @FXML
    private Button btnFile;
    @FXML
    private Pane root;
    @FXML
    private Label id_offre;
    @FXML
    private TextField inputUrl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onclick_dash(ActionEvent event) throws IOException {
        Alert Atc = new Alert(AlertType.CONFIRMATION);
        Atc.setHeaderText("Alert");
        Atc.setContentText("Votre avancement sera perdu");
        Optional<ButtonType> result = Atc.showAndWait();
        if (result.get() == ButtonType.OK) {
            int id = Integer.parseInt(id_offre.getText());
            offreservice.deleteById(id);
            Parent fXMLLoader = FXMLLoader.load(getClass().getResource("HomeSociete.fxml"));
            Scene stage = new Scene(fXMLLoader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } else {
            Atc.close();
        }
    }

    OffreService offreservice = new OffreService();

    @FXML
    private void onClicked_menuOffre(ActionEvent event) throws IOException {

        Alert Atc = new Alert(AlertType.CONFIRMATION);
        Atc.setHeaderText("Alert");
        Atc.setContentText("Votre avancement sera perdu");
        Optional<ButtonType> result = Atc.showAndWait();
        if (result.get() == ButtonType.OK) {
            int id = Integer.parseInt(id_offre.getText());
            offreservice.deleteById(id);
            Parent fXMLLoader = FXMLLoader.load(getClass().getResource("Offre.fxml"));
            Scene stage = new Scene(fXMLLoader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } else {
            Atc.close();
        }
    }

    @FXML
    private void OnClicked_menuEvent(ActionEvent event) throws IOException {
        Alert Atc = new Alert(AlertType.CONFIRMATION);
        Atc.setHeaderText("Alert");
        Atc.setContentText("Votre avancement sera perdu");
        Optional<ButtonType> result = Atc.showAndWait();
        if (result.get() == ButtonType.OK) {
            int id = Integer.parseInt(id_offre.getText());
            offreservice.deleteById(id);
            Parent fXMLLoader = FXMLLoader.load(getClass().getResource("firstevent.fxml"));
            Scene stage = new Scene(fXMLLoader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } else {
            Atc.close();
        }
    }

    @FXML
    private void OnClicked_menuEntretiens(ActionEvent event) throws IOException {
        Alert Atc = new Alert(AlertType.CONFIRMATION);
        Atc.setHeaderText("Alert");
        Atc.setContentText("Votre avancement sera perdu");
        Optional<ButtonType> result = Atc.showAndWait();
        if (result.get() == ButtonType.OK) {
            int id = Integer.parseInt(id_offre.getText());
            offreservice.deleteById(id);
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

    @FXML
    private void onclickSuivantStage(ActionEvent event) throws IOException {

        if (SelectedFile != null && inputUrl.getText().length() == 0) {
            //choice n'existe plus ,il afut l'enlever et remplacer par methode crud
            path = SelectedFile.getAbsolutePath();

        } else if (inputUrl.getText().length() != 0 && SelectedFile == null) {
            path = inputUrl.getText();
        } else {
            Alert Atc = new Alert(AlertType.WARNING);
            Atc.setHeaderText("Alert");
            Atc.setContentText("vous ne pouvez pas deposer un ficher et mettre un url en meme temps");
            Atc.showAndWait();
            return;
        }
        try {
            Offre O1 = offreService.readLast();
            Test t = new Test(O1.getTitre(), path);
            t.setId_soc(SessionManager.getId());
            testservice.ajouter(t);
            O1.setId_test(testservice.selectLast().getId());
            offreService.update(O1);

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
        } catch (SQLException ex) {
            Logger.getLogger(AjouterTestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    OffreService offreService = new OffreService();
    TestService testservice = new TestService();

    String path = "";
    File SelectedFile;

    @FXML
    private void Onclic_btnFile(ActionEvent event) throws SQLException {
        FileChooser fc = new FileChooser();
        SelectedFile = fc.showOpenDialog(null);
        if (SelectedFile != null) {
            path = SelectedFile.getAbsolutePath();

        }
    }

    public void setIdOffre(String id) {

        id_offre.setText(id);
    }
}
