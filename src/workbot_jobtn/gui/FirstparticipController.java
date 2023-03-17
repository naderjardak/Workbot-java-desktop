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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FirstparticipController implements Initializable {

    @FXML
    private Button commencerpart;
    @FXML
    private Button btnhomefrstparticip;
    @FXML
    private Button Topartaffiche;
    @FXML
    private Button Topartannul;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void commencerpaticip(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) commencerpart.getScene().getWindow();
                stage.close();
       FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("participaffiche.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }

    @FXML
    private void doclickbtnhomefrstparticip(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) commencerpart.getScene().getWindow();
                stage.close();
       FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("Home.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }

    @FXML
    private void doclickTopartaffiche(ActionEvent event) throws IOException {
        Stage stage = (Stage) commencerpart.getScene().getWindow();
                stage.close();
       FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("participaffiche.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }

    @FXML
    private void doclickTopartannul(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) commencerpart.getScene().getWindow();
                stage.close();
       FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("participannule.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }
    
}
