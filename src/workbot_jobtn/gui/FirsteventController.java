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
public class FirsteventController implements Initializable {

    @FXML
    private Button commencerbtn1;
    @FXML
    private Button Toaddevent;
    @FXML
    private Button Toeventlist;
    @FXML
    private Button HOMEfirstev;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void commencerexp(ActionEvent event) throws IOException {
        Stage stage = (Stage) commencerbtn1.getScene().getWindow();
                stage.close();
       FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("newhomeevent.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }

    @FXML
    private void doclickToaddevent(ActionEvent event) throws IOException {
        Stage stage = (Stage) commencerbtn1.getScene().getWindow();
                stage.close();
       FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("newhomeevent.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
        
    }

    @FXML
    private void doclickToeventlist(ActionEvent event) throws IOException {
        Stage stage = (Stage) commencerbtn1.getScene().getWindow();
                stage.close();
       FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("afficheevent.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }

    @FXML
    private void doclickHOMEfirstev(ActionEvent event) throws IOException 
    { Stage stage = (Stage) commencerbtn1.getScene().getWindow();
                stage.close();
       FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("HomeSociete.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }
    
}
