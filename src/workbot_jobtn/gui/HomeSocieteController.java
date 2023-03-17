/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import workbot_jobtn.entites.StatCertif;
import workbot_jobtn.services.OffreService;
import workbot_jobtn.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author Exon
 */
public class HomeSocieteController implements Initializable {

    @FXML
    private HBox root;
    @FXML
    private VBox menu;
    @FXML
    private AnchorPane side_anker;
    @FXML
    private Button btnDashboard;
    @FXML
    private Button btnMenuOffre;
    @FXML
    private Button btnMenuEvent;
    @FXML
    private Button btnMenuEntretien;
    @FXML
    private Pane s;
    @FXML
    private Pane dash_offre;
    @FXML
    private Label tot_offre;
    @FXML
    private Label semaine_offre;
    @FXML
    private TextField inputsearch;
    @FXML
    private Button btnUser;
    @FXML
    private Label Bonjour;
    @FXML
    private Label nomSociete;
    @FXML
    private Pane dash_cand;
    @FXML
    private Label tot_cand;
    @FXML
    private Label semaine_cand;
    @FXML
    private Pane dash_event;
    @FXML
    private Label tot_event;
    @FXML
    private Label semaine_event;
    @FXML
    private Pane dash_part;
    @FXML
    private Label tot_part;
    @FXML
    private Label semaine_part;
    @FXML
    private WebView N_AdsView;
    private WebEngine e;
    
    OffreService offreservice = new OffreService();
    @FXML
    private Pane menu_profile;
    @FXML
    private Button N_BDeconnecter;
    @FXML
    private Button fb;
    @FXML
    private PieChart sttOFF;
    @FXML
    private PieChart statOffSem;
    @FXML
    private PieChart statEventTot;
    @FXML
    private PieChart statEventTotS;
    
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        		// TODO Auto-generated method stub  
         e=N_AdsView.getEngine();
         e.load("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1");
        OffreService of=new OffreService();

        sttOFF.getData().add(new PieChart.Data("Offres",of.totNbOffres(1)));
        sttOFF.getData().add(new PieChart.Data("Candidature ",of.totNbCandidature()));
                   
        statOffSem.getData().add(new PieChart.Data("Offres",of.totNbOffresParSemaine(1)));
        statOffSem.getData().add(new PieChart.Data("Candidat",of.totNbCandidatureParSemaine()));
        
        statEventTot.getData().add(new PieChart.Data("Evenements ",of.totNbEvenement()));
        statEventTot.getData().add(new PieChart.Data("Participation ",of.totNbParticipations()));
        
        statEventTotS.getData().add(new PieChart.Data("Evenement",of.totNbevennementParSemaine()));
        statEventTotS.getData().add(new PieChart.Data("Participation",of.totNbParticipationsPrévu()));

        
        int nbTot = offreservice.totNbOffres(SessionManager.getId());
        int nbSemaine = offreservice.totNbOffresParSemaine(SessionManager.getId());
        int nbTotCand = offreservice.totNbCandidature();
        int nbTotCandSemaine = offreservice.totNbCandidatureParSemaine();
        int totEvenet = offreservice.totNbEvenement();
        int eventaveneir =offreservice.totNbevennementParSemaine();
        int totPart=offreservice.totNbParticipations();
        int totPartPrevu=offreservice.totNbParticipations();



        tot_offre.setText(String.valueOf(nbTot));
        semaine_offre.setText(String.valueOf(nbSemaine));
        tot_cand.setText(String.valueOf(nbTotCand));
        semaine_cand.setText(String.valueOf(nbTotCandSemaine));
        tot_event.setText(String.valueOf(totEvenet));
        semaine_event.setText(String.valueOf(eventaveneir));
        tot_part.setText(String.valueOf(totPart));
        semaine_part.setText(String.valueOf(totPartPrevu));
        
        
        

    }

    @FXML
    private void onClicked_menuOffre(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("Offre.fxml"));
        Scene stage = new Scene(fXMLLoader);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }

    @FXML
    private void OnClicked_menuEvent(ActionEvent event) throws IOException {
          Parent fXMLLoader = FXMLLoader.load(getClass().getResource("firstevent.fxml"));
        Scene stage = new Scene(fXMLLoader);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();

    }

    @FXML
    private void OnClicked_menuEntretiens(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("DisplayEntretiens.fxml"));
        Scene stage = new Scene(fXMLLoader);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }

    @FXML
    private void onKeyRealeased_showSearchPropositions(KeyEvent event) {
    }

    @FXML
    private void OnClick_UserIcon(ActionEvent event) {
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


    @FXML
    private void onfacebook(ActionEvent event) throws IOException {
        try {
            Desktop browser=Desktop.getDesktop();
            
            browser.browse(new URI("https://www.facebook.com/Job-TN-102084759380863"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(HomeSocieteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void reclam(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("y_reclamation.fxml"));
            Scene stage = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
    }

}
