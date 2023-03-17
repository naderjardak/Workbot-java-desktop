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
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import workbot_jobtn.utils.SessionManager;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.taskrouter.v1.workspace.Task;
import javafx.scene.Node;


/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class N_Contacter implements Initializable {
    public static final String ACCOUNT_SID = "AC4ad18a2d3b9e37a630727e7818a0920d"; //Find your Account Sid and Auth Token at https://www.twilio.com/console
    public static final String AUTH_TOKEN = "ea8c0f247f12d453f340d28b72f86ad5";

    @FXML
    private Button N_BMCours;
    @FXML
    private Button N_BMCertification;
    @FXML
    private Button N_BMHome;
    @FXML
    private WebView N_AdsView;
        private WebEngine e;
    private Button N_BDeconnecter;
    @FXML
    private WebView maps_view;
    private WebEngine m;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        e=N_AdsView.getEngine();    
         e.load("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1");
         
          m=maps_view.getEngine();    
         m.load("file:///C:/maps/index.html");
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
    
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Affiche.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();

    }

    @FXML
    private void N_menu_certif_Admin(ActionEvent event) throws IOException {
 
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Afficher_Certif_Liste.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();

    }


    @FXML
    private void N_B_Home(ActionEvent event) throws IOException {
 
       Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Home.fxml"));
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
    private void Sms_Localisation(ActionEvent event) {
                CreateTask();
    }
     
    protected Task CreateTask(){
        String messageBody = "JOB.TN Notre Localisation:https://maps.app.goo.gl/dCviC88FjRipt6mG6";
        String to = "+216"+SessionManager.getTel();
       // String sendList[] = jTextFieldTo.getText().split(",");

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
            new com.twilio.type.PhoneNumber(to),                //Recipient(s)
            new com.twilio.type.PhoneNumber("+18585195482"),    //Sender Phone No. - Find your Twilio phone number at https://www.twilio.com/console
            messageBody)
        .setMediaUrl(										//MMS, Comment out this and the next line if you don't want to attach picture to your message.
            Arrays.asList(URI.create("http://oracleprofessor.com/LO.jpg")))	//MMS
        .create();
        System.out.println(message.getSid());
        return null;
        
    }
    
}
