package workbot_jobtn.gui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class N_CoursHtml implements Initializable{
	@FXML	
        private WebView N_CoursHtml;
	private WebEngine e1;
        
        @FXML
        private WebView N_AdsView;
        private WebEngine e;
 
        @FXML
         private Button retourne;
    @FXML
    private Button reset;
        
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
                e=N_AdsView.getEngine();
                e.load("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1");
            
		e1=N_CoursHtml.getEngine();
                String link =null;
                //link=Services_Afficher_Cours_Liste.co.getChemin().toString();
                link=N_AfficheController.co.getChemin().toString();
                System.out.println(link);
                
                e1.load("file:\\"+link);
                //e1.load("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1");
	}
   
    
                
 
        @FXML
        void reset_html(ActionEvent event) throws IOException {
            
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_CoursHtml.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
           
        }               
                
            @FXML         
        void retourne(ActionEvent event) throws IOException {

        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Affiche.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();   
                
      }

    @FXML
    private void Certif(ActionEvent event) throws IOException {
        
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Rechercher_Certif_Liste.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();   
               
    }

    @FXML
    private void Home(ActionEvent event) throws IOException {
        
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
}

