package workbot_jobtn.gui;


import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import workbot_jobtn.utils.SessionManager;

public class N_Home_1 implements Initializable{
       
        @FXML
        private WebView N_AdsView;
        private WebEngine e;
        
        

    @FXML
    private Button N_BDeconnecter;

    @FXML
    private Button N_BGererCompte;


    @FXML
    private Button N_BMBadge;

    @FXML
    private Button N_BMCertification;

    @FXML
    private Button N_BMCours;

    @FXML
    private Button N_BMHome;

    @FXML
    private Button N_BMenuTOP;

    @FXML
    private Button N_BProfile;

    @FXML
    private Pane menu_profile;
    @FXML
    private Button N_BHomeCours;
    @FXML
    private Button N_BHomeCertification;
    @FXML
    private Button contacter;
    @FXML
    private ImageView sun;
    @FXML
    private ImageView badge;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		// TODO Auto-generated method stub                
                show();                	
	}
   	public void show()
        {
            e=N_AdsView.getEngine();
            e.load("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1");
        }
        
    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {

       Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Affiche.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
     
    }       
        


    
    
    @FXML
    void N_menu_certif_Admin(ActionEvent event) throws IOException {

        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Rechercher_Certif_Liste.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
              
    
    }
int i=0;
    @FXML
    private void show_menu(ActionEvent event) {
        if(i%2==0)
        {
        menu_profile.setVisible(true);
        }
        else
        menu_profile.setVisible(false);
        i++;
    }
    
    @FXML
    void contacter(ActionEvent event) throws IOException {
                Stage stage = (Stage) N_BMCours.getScene().getWindow();
               stage.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("N_Contacter.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage = new Stage();
                stage.setScene(new Scene(root1,895,535)); 
                stage.resizableProperty().setValue(false);
                stage.show();
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
    private void badge(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Badge.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }

    @FXML
    private void Browser(MouseEvent event) throws URISyntaxException, IOException {
    Desktop.getDesktop().browse(new URI("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1"));

    }

    @FXML
    private void animation_lompe(MouseEvent event) {
FadeTransition fadeInTransition = new FadeTransition(Duration.millis(1500), sun);
fadeInTransition.setFromValue(0.0);
fadeInTransition.setToValue(1.0);
fadeInTransition.play();
 
//Fade out transition
FadeTransition fadeOutTransition = new FadeTransition(Duration.millis(1500), sun);
fadeOutTransition.setFromValue(1.0);
fadeOutTransition.setToValue(0.0);
fadeOutTransition.play();

FadeTransition fadeInTransition1 = new FadeTransition(Duration.millis(1500), sun);
fadeInTransition1.setFromValue(0.0);
fadeInTransition1.setToValue(1.0);
fadeInTransition1.play();


    }

    @FXML
    private void certif_animation(MouseEvent event) {
  Duration duration = Duration.millis(2500);
    //Create new rotate transition
    RotateTransition rotateTransition = new RotateTransition(duration, badge);
    //Rotate by 200 degree
    rotateTransition.setByAngle(360);
    rotateTransition.play();
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }



}
