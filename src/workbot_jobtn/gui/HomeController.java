/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import workbot_jobtn.services.OffreService;
import workbot_jobtn.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class HomeController implements Initializable {

    @FXML
    private Button Home;
    @FXML
    private Button gotooffre;
    @FXML
    private Button N_BMHome1;
    @FXML
    private Button gotocontrats;
    @FXML
    private PieChart tabchart;
    @FXML
    private WebView N_AdsView;
    private WebEngine e;
    @FXML
    private Pane menu_profile;
    @FXML
    private Button N_BDeconnecter;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO Auto-generated method stub  
         e=N_AdsView.getEngine();
         e.load("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1");
        OffreService of=new OffreService();
        tabchart.getData().add(new PieChart.Data("Offres",of.totNbCandOfrre()));
        tabchart.getData().add(new PieChart.Data("Taches ",of.totNbCandbyCandidat()));
        
        // TODO
    }    

  
    @FXML
    private void gotooffre(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("Offre_1.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void candidature_menu(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("CandidatureList.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void gotocontact(ActionEvent event) throws IOException {
            Parent page1 = FXMLLoader.load(getClass().getResource("ContratCreation.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
        
    }

    @FXML
    private void Home(ActionEvent event) throws IOException {
            Parent page1 = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();   
        
    }

    @FXML
    private void gotocontrats(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("ContratList.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void evennement_menu(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("firstparticip.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Cours_window(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("N_Home.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void reclam(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("y_reclamation.fxml"));
            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
    }

    int i=0;
    @FXML
    private void OnClick_settings(ActionEvent event) {
        if(i%2==0)
        {
        menu_profile.setVisible(true);
        }
        else
        menu_profile.setVisible(false);
        i++;
    }



    @FXML
    private void profile(ActionEvent event) {
    }

    @FXML
    private void compte(ActionEvent event) {
    }
    @FXML
    private void logout(ActionEvent event) throws IOException {
            SessionManager.cleanUserSession();      
            Parent root = FXMLLoader.load(getClass().getResource("M_Login.fxml"));
            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
    }
}
