/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package workbot_jobtn.gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import workbot_jobtn.utils.SessionManager;

/**
 *
 * @author hp
 */
public class NewFXMain_1 extends Application {
 
    
    @Override
    public void start(Stage stage) throws IOException {
                
        SessionManager.setId(1);
        SessionManager.setEmail("naderjardak5@gmail.com");
 
               FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("homepartsoc.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,895,535)); 
                stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
