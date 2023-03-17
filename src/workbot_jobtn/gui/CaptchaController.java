/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import workbot_jobtn.entites.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;
import workbot_jobtn.utils.MyDB;
import workbot_jobtn.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author RAMI
 */
public class CaptchaController implements Initializable {

    @FXML
    private WebView webView;
    private WebEngine engine;
    @FXML
    private Label statuss;
    @FXML
    private AnchorPane okcaptcha;
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        engine = webView.getEngine();
        loadPage();
    }    
    
        public void loadPage(){
        engine.load("http://localhost/captcha/index.html");
    }
        
    @FXML
        public void Login(ActionEvent event) throws Exception {
           // create the java mysql update preparedstatement
           Connection connn = MyDB.getInstance().getConnection();
           int number=0;
            String requetee= "SELECT * FROM captcha";
            PreparedStatement stat = connn.prepareStatement(requetee);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int status = rs.getInt("status");
               System.out.format("%s,%s\n", id,status);
               number=status;
            }
                  
           if(number==1)
           {
     try
    {
      String query = "update captcha set status = 0 where id= 0";
      PreparedStatement preparedStmt = connn.prepareStatement(query);
            // execute the java preparedstatement
      preparedStmt.executeUpdate();
      
      
    }
    catch (Exception e)
    {
      System.err.println("Got an exception! ");
      System.err.println(e.getMessage());
    }

        
        
                            Stage stage = new Stage();
                    
                    //Parent rootcaptcha = FXMLLoader.load(getClass().getResource("Captcha.fxml"));
                    Parent root = FXMLLoader.load(getClass().getResource("M_Signup.fxml"));
                    
                    
                    
                    
                    
                   // stagecaptcha.setTitle("Captcha Verify");
                    stage.setTitle("Role");
                    
                   // Scene scenecaptcha = new Scene(root, 1280, 720);
            Scene scene = new Scene(root, 840, 600);

                    /////////stage.initOwner(stage);
                    //stagecaptcha.setScene(scenecaptcha);
                    stage.setScene(scene);
                    
                   // stagecaptcha.show();
                    stage.show();
                    ((Node) (event.getSource())).getScene().getWindow().hide();
    }
           else{
           statuss.setText("login failed");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("login failed");
                    alert.setHeaderText(null);
                    alert.setContentText("login ou mot de pass invalide");
                    alert.showAndWait();
           }
            
        }
        
}