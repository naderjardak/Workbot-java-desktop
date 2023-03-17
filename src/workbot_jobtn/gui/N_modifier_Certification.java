/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import workbot_jobtn.entites.Certification;
import static workbot_jobtn.gui.N_ajouter_Certification.path;
import workbot_jobtn.services.N_Services_Certification;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class N_modifier_Certification implements Initializable {

    @FXML
    private TextField N_add_certif_test;
    @FXML
    private TextField N_add_certif_cours;
    @FXML
    private WebView N_AdsView;
    @FXML
    private Button N_retourne_to_N_menu;
    @FXML
    private Button N_add_certif_Breset;
    private TextField N_add_certif_lien;

    /**
     * Initializes the controller class.
     */
      private WebEngine e;
    @FXML
    private Label tE;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         e=N_AdsView.getEngine();    
         e.load("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1");    
         
         N_add_certif_cours.setText(N_Afficher_Certif_Liste.co1.getTitreCours());
         N_add_certif_test.setText(N_Afficher_Certif_Liste.co1.getTitreTest());           
         path1=(N_Afficher_Certif_Liste.co1.getLien());
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

 @FXML
    void Retourne_To_N_Menu(ActionEvent event) throws SQLException, IOException {
            
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Afficher_Certif_Liste.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
                         
    }


    @FXML
    private void Modifer_Certif_Button_Clicked(ActionEvent event) throws SQLException {
         String titrec=N_add_certif_cours.getText();
         String titret=N_add_certif_test.getText();           
        
          if(titret.length()==0 || titrec.length()==0 || path1.length()==0)
            {
            Alert Atc=new Alert(Alert.AlertType.WARNING);
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
        Certification C1=new Certification(N_Afficher_Certif_Liste.co1.getId(),titrec,titret,DateS,path1);
        N_Services_Certification sc=new N_Services_Certification();
        sc.modifierCertif(C1);
        tE.setText("Modification effectuée avec succès ");
    }
    }

    @FXML
    private void reset(ActionEvent event) {
         N_add_certif_cours.setText("");
         N_add_certif_test.setText("");           
         N_add_certif_lien.setText("");
         tE.setText("");
    }

    @FXML
    private void Browser(MouseEvent event) throws URISyntaxException, IOException {
                Desktop.getDesktop().browse(new URI("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1"));

    }
static public String path1="";
    @FXML
    private void path_certif(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File SelectedFile = fc.showOpenDialog(null);
        if (SelectedFile != null ){
            path1=SelectedFile.getAbsolutePath();
    }
        System.out.println(path1);
    }
    
}
