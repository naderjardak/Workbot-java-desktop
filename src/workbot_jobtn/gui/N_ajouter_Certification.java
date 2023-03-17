/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.gui;

import java.awt.Desktop;
import java.io.File;
import workbot_jobtn.entites.Certification;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.codehaus.plexus.util.FileUtils;
import static workbot_jobtn.gui.N_ajouter_Cours.SelectedFile;
import workbot_jobtn.services.N_Services_Certification;

public class N_ajouter_Certification implements Initializable {

     Connection connexion;
    @FXML
    private WebView N_AdsView;
    private WebEngine e;

    @FXML
    private Button N_add_certif_Bajouter;

    @FXML
    private Button N_add_certif_Breset;

    @FXML
    private TextField N_add_certif_cours;

    private TextField N_add_certif_lien;

    @FXML
    private TextField N_add_certif_test;

    @FXML
    private Button N_retourne_to_N_menu;
    @FXML
    private Label err_msg;

    @FXML
    void Ajouter_Certif_Button_Clicked(ActionEvent event) throws SQLException {
            String tc=N_add_certif_cours.getText();           
            String li=path;           
            String tt=N_add_certif_test.getText();

             if(tc.length()==0 || li.length()==0 || tt.length()==0)
            {
            Alert Atc=new Alert(AlertType.WARNING);
            Atc.setHeaderText("Alert");
            Atc.setContentText("Il faut remplire tout les champs !!");
            Atc.showAndWait();           
            
            }
            else
            {
            String pattern = "dd_MM_yyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            java.util.Date today = Calendar.getInstance().getTime();
            String DateS = df.format(today);
             
            Certification c=new Certification();
            c.setTitreCours(tc);
            c.setTitreTest(tt);
            c.setDateAjout(DateS);
            c.setLien(li);
            
            N_Services_Certification sc=new N_Services_Certification();
            
             
            sc.ajouterCertif(c);
            err_msg.setText("Ajout effectué avec succès !!");
            N_add_certif_cours.setText("");           
            path="";           
            N_add_certif_test.setText("");
            
            }
             
             
            File srcFile = SelectedFile1;
            File destDir = new File("C:\\Workbot-web\\public\\Upload\\cert");
            
            try {

            FileUtils.copyFileToDirectory(srcFile, destDir);

            System.out.println("File successfully copied in Java");

            } catch (IOException e) {

            e.printStackTrace();
            }
      
    }

    @FXML
    void Retourne_To_N_Menu(ActionEvent event) throws SQLException, IOException {
            
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Afficher_Certif_Liste.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();  
                
    }

    @FXML
    void reset(ActionEvent event) {
           N_add_certif_cours.setText("");
           N_add_certif_test.setText("");   
           path="";
    }

    @FXML
    private void Cours(ActionEvent event) throws IOException {
                
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Afficher_Cours_Liste.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();  
              
    }

    @FXML
    private void home(ActionEvent event) throws IOException {

        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Home_Admin.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         e=N_AdsView.getEngine();    
         e.load("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1");    }

    @FXML
    private void Browser(MouseEvent event) throws URISyntaxException, IOException {
                Desktop.getDesktop().browse(new URI("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1"));

    }
     
     static public File SelectedFile1;
     static public String path="";
    @FXML
    private void path_cours(ActionEvent event) {
        FileChooser fc = new FileChooser();
        SelectedFile1 = fc.showOpenDialog(null);
        if (SelectedFile1 != null ){
            path=SelectedFile1.getName();
    }
        System.out.println(path);
    }

}
