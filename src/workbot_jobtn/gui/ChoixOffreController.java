/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Exon
 */
public class ChoixOffreController implements Initializable {

    private AnchorPane choix_type;
    @FXML
    private Button btn_suivant;
    @FXML
    private RadioButton radio_emploi;
    @FXML
    private ToggleGroup offre;
    @FXML
    private RadioButton radio_stage;
    @FXML
    private RadioButton radio_freelancer;
    @FXML
    private AnchorPane choix_typeRoot;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onclicked_suivant(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("test.fxml"));
        Parent root = loader.load();
        TestController testController = loader.getController();
        if (radio_stage.isSelected()) {
            testController.setChoice("Stage");

            Parent fXMLLoader = FXMLLoader.load(getClass().getResource("OffreStage.fxml"));
            Scene stage = new Scene(fXMLLoader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        }
        if (radio_emploi.isSelected()) {
            testController.setChoice("Emploi");

            Parent fXMLLoader = FXMLLoader.load(getClass().getResource("OffreEmploi.fxml"));
            Scene stage = new Scene(fXMLLoader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        }
        if (radio_freelancer.isSelected()) {
            testController.setChoice("Freelancer");

            Parent fXMLLoader = FXMLLoader.load(getClass().getResource("OffreFreelancer.fxml"));
            Scene stage = new Scene(fXMLLoader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        }

    }

    private String typeOffre;

    @FXML
    private void getOffre(ActionEvent event) {

    }

}
