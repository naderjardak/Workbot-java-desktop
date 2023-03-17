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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import workbot_jobtn.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class Compte implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void user(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Home.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();


                SessionManager.setId(3);
                SessionManager.setNom("nader");
                SessionManager.setPrenom("jardak");
                SessionManager.setEmail("naderjardak5@gmail.com");
                SessionManager.setPhoto("");
                SessionManager.setTel("90446128");
                SessionManager.setRole("User");
                
    
    }

   
    @FXML
    private void Admin(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Home_Admin.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
       
                SessionManager.setId(20);
                SessionManager.setNom("mahdi");
                SessionManager.setPrenom("jardak");
                SessionManager.setEmail("naderjardak5@gmail.com");
                SessionManager.setPhoto("");
                SessionManager.setTel("90446128");
                SessionManager.setRole("Admin");
                
    }
                
}
