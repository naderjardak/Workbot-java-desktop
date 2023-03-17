/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package workbot_jobtn.tests;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Exon
 */
public class MainFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        try {
            //Parent root1= FXMLLoader.load(getClass().getResource("HomeSociete.fxml"));
            Parent fXMLLoader;
            fXMLLoader = FXMLLoader.load(getClass().getResource("../gui/HomeSociete.fxml"));
           // fXMLLoader.setRoot(new AnchorPane());
           // Parent root =fXMLLoader.load();
            Scene scene = new Scene(fXMLLoader);
            
            //primaryStage.setTitle("Offre!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainFX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
