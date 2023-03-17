/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

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

import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fnmoh
 */
public class ForgotPasswordMethodeController implements Initializable {

    @FXML
    private Button SuivantMethodePassword;
    @FXML
    private Button B_ParSms;
    @FXML
    private Button B_PQueSec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void SuivantMethodePass(ActionEvent event) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("M_Login.fxml"));

            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void B_ParSms(ActionEvent event) {
        /*
         try {
    
                        Parent root = FXMLLoader.load(getClass().getResource("smsmethodeRestore.fxml"));
                        
        Scene stage=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
         */
        try {

            Parent root = FXMLLoader.load(getClass().getResource("smsmethodeRestore.fxml"));

            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void B_PQueSec(ActionEvent event) {
        /*
         try {
    
                        Parent root = FXMLLoader.load(getClass().getResource("RestoreAccountParSms.fxml"));
                        
        Scene stage=new Scene(root);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
         */
        try {

            Parent root = FXMLLoader.load(getClass().getResource("RestoreAccountParSms.fxml"));

            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
