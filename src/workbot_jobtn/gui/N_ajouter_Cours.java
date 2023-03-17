
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.gui;

import com.google.common.io.Files;
import com.itextpdf.text.pdf.parser.Path;
import java.awt.Desktop;
import java.io.File;
import workbot_jobtn.entites.Cours;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.SQLException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.codehaus.plexus.util.FileUtils;
import workbot_jobtn.services.N_Services_Cours;


/**
 *
 * @author ADMIN
 */
public class N_ajouter_Cours implements Initializable {
    
   Cours c=new Cours("","","","",""); 
    
   
   @FXML
    private WebView N_AdsView;

    @FXML
    private Button N_add_cours_Bajouter;

    @FXML
    private Button N_add_cours_Breset;

    @FXML
    private ChoiceBox N_add_cours_categorie;


    @FXML
    private TextField N_add_cours_matiere;

    @FXML
    private TextField N_add_cours_titre;
    
        private WebEngine e;

   @FXML
    private CheckBox N_B_electro_Ajout;

    @FXML
    private CheckBox N_B_info_Ajout;

    @FXML
    private CheckBox N_B_meca_Ajout;

    @FXML
    private CheckBox N_B_reseau_Ajout;
    
    @FXML
    private Label erreur_msg;
    
    
        @FXML
    private Button N_retourne_to_N_menu;

        public void initialize(URL arg0, ResourceBundle arg1) {
            N_add_cours_categorie.getItems().add("Fondamentale");
            N_add_cours_categorie.getItems().add("Appliquée");

            e=N_AdsView.getEngine();
            e.load("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1");
        }
        
        @FXML
        void Ajouter_Cours_Button_Clicked(ActionEvent event) throws IOException{
            String titre=N_add_cours_titre.getText();
            String matiere=N_add_cours_matiere.getText();           
            String chemin=path;
            String logo=path2;
            
            
            String domaine="";
            if(N_B_info_Ajout.isSelected())
                domaine=(domaine+"informatique");
            if(N_B_electro_Ajout.isSelected())
                domaine=(domaine+" electronique");
            if(N_B_meca_Ajout.isSelected())
                domaine=(domaine+" mecanique");
            if(N_B_reseau_Ajout.isSelected())
                domaine=(domaine+" resau");
            
            String categorie=N_add_cours_categorie.getValue().toString(); 
            
            if(titre.length()==0 || matiere.length()==0 || chemin.length()==0 || domaine.length()==0 )
            {
             Alert Atc=new Alert(Alert.AlertType.WARNING);
            Atc.setHeaderText("Alert");
            Atc.setContentText("Il faut remplire tout les champs !!");
            Atc.showAndWait();                
            }
            else
            {
            N_Services_Cours sc=new N_Services_Cours();
            Cours cr=new Cours(titre,matiere,domaine,categorie,chemin,logo);
        try {
            sc.ajouterCours(cr);
            erreur_msg.setText("Ajout effectué avec succés !! ");
            N_add_cours_titre.setText("");
            N_add_cours_matiere.setText("");           
            path="";
            path2="";
            
        } catch (SQLException ex) {
        }
                    System.out.println(chemin+ " "+matiere+" "+titre+" "+domaine+" "+categorie+" "+logo);
       
            File srcFile = SelectedFile;
            File destDir = new File("C:\\Workbot-web\\public\\Upload\\chem");
            try {

            FileUtils.copyFileToDirectory(srcFile, destDir);

            System.out.println("File successfully copied in Java");

            } catch (IOException e) {

            e.printStackTrace();

}
            
            
            File srcFile4 = SelectedFile2;
            File destDir4 = new File("C:\\Workbot-web\\public\\Upload\\chem");
            try {

            FileUtils.copyFileToDirectory(srcFile4, destDir4);

            System.out.println("Logo File successfully copied in Java");

            } catch (IOException e) {

            e.printStackTrace();

}
        
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Afficher_Cours_Liste.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
             
         }
}
        
        @FXML        
        void Retourne_To_N_Menu(ActionEvent event) throws IOException
        {
                                
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Afficher_Cours_Liste.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
             
            
        }

    @FXML
    private void certif(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Afficher_Certif_Liste.fxml"));
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
    private void Browser(MouseEvent event) throws URISyntaxException, IOException {
    
            Desktop.getDesktop().browse(new URI("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1"));
    }

    static public String path="";
    static public File SelectedFile;
    @FXML
    private void path_cours(ActionEvent event) {
        FileChooser fc = new FileChooser();
        SelectedFile = fc.showOpenDialog(null);
        if (SelectedFile != null ){
            path=SelectedFile.getName();
            
    }
        System.out.println(path);
    }

    @FXML
    private void reset(MouseEvent event) {
            N_add_cours_titre.setText("");
            N_add_cours_matiere.setText("");           
            path="";
    }
    
    
    static public File SelectedFile2;
    static public String path2="";
    @FXML
    private void logo_cours(ActionEvent event) {
        FileChooser fc1 = new FileChooser();
         SelectedFile2 = fc1.showOpenDialog(null);
        if (SelectedFile2 != null ){
            path2=SelectedFile2.getName();
            
    }
        System.out.println(path2);
    }
        
}
