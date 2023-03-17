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
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import workbot_jobtn.utils.Mail;

/**
 * FXML Controller class
 *
 * @author Exon
 */
public class SuccesOffreController implements Initializable {

    @FXML
    private Pane slide1;
    @FXML
    private Label choice;
    @FXML
    private Button btnDash;
    @FXML
    private Button btnAjouterOffre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Thread th = new Thread(() -> {
        Mail mail = new Mail();
        mail.envoyer();    
        });
        th.setDaemon(true);
        th.start();  
        

    }

    @FXML
    private void onClick_Dash(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("HomeSociete.fxml"));
        Scene stage = new Scene(fXMLLoader);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();

    }

    @FXML
    private void OnclickAjouterOffre(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("AjouterOffre.fxml"));
        Scene stage = new Scene(fXMLLoader);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }

}
