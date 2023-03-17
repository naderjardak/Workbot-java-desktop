/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.gui;


import java.awt.Desktop;
import java.io.File;
import workbot_jobtn.entites.Cours;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static workbot_jobtn.gui.N_ajouter_Cours.path;
import workbot_jobtn.services.N_Services_Cours;
/**
 *
 * @author ADMIN*
 */
public class N_modifier_Cours implements Initializable {
   
public static String path1="";

@FXML
    private WebView N_AdsView;

    @FXML
    private CheckBox N_B_electro_Ajout;

    @FXML
    private CheckBox N_B_info_Ajout;

    @FXML
    private CheckBox N_B_meca_Ajout;

    @FXML
    private CheckBox N_B_reseau_Ajout;

    @FXML
    private ChoiceBox<String> N_add_cours_categorie;

    private TextField N_add_cours_chemin;

    @FXML
    private TextField N_add_cours_matiere;

    @FXML
    private TextField N_add_cours_titre;

    @FXML
    private Button N_mod_cours_Bmodifier;

    @FXML
    private Button N_modifer_cours_Breset;

    @FXML
    private Button N_retourne_to_N_menu;

    @FXML
    private Label erreur_msg;


    
      private WebEngine e;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         e=N_AdsView.getEngine();    
         e.load("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1");    
        N_add_cours_categorie.getItems().add("Fondamentale");
        N_add_cours_categorie.getItems().add("Appliquée");
        //N_Afficher_Cours_Liste.co.getId();
        N_add_cours_titre.setText(N_Afficher_Cours_Liste.co.getTitre().toString());
        N_add_cours_matiere.setText(N_Afficher_Cours_Liste.co.getMatiere().toString());
        path1=(N_Afficher_Cours_Liste.co.getChemin().toString());       
        String categorie=N_Afficher_Cours_Liste.co.getCategorie();          
        N_add_cours_categorie.setValue(categorie);
        
       if(N_Afficher_Cours_Liste.co.getDomaine().contains("informatique"))
       {
          N_B_info_Ajout.setSelected(true);
       }
       if(N_Afficher_Cours_Liste.co.getDomaine().contains("electronique"))
       {
          N_B_electro_Ajout.setSelected(true);
       } 
       if(N_Afficher_Cours_Liste.co.getDomaine().contains("mecanique"))
       {
          N_B_meca_Ajout.setSelected(true);
       }
       if(N_Afficher_Cours_Liste.co.getDomaine().contains("reseau"))
       {
          N_B_reseau_Ajout.setSelected(true);
       }
        
        
    }

    
    @FXML
    public void Modifier_Cours_Button_Clicked(ActionEvent event) throws SQLException {
           String titre=N_add_cours_titre.getText();
            String matiere=N_add_cours_matiere.getText();           
            
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
            System.out.println("hi :" +path1);
          if(titre.length()==0 || matiere.length()==0  || domaine.length()==0 || categorie.equals(" ") || path1.equals(""))
            {
            Alert Atc=new Alert(Alert.AlertType.WARNING);
            Atc.setHeaderText("Alert");
            Atc.setContentText("Il faut remplire tout les champs !!");
            Atc.showAndWait();           
            }
            else
            {
         Cours C1=new Cours(N_Afficher_Cours_Liste.co.getId(),titre,matiere,domaine,categorie,path1);
        N_Services_Cours sc=new N_Services_Cours();
        sc.modifierCours(C1);
        erreur_msg.setText("Modification validé !!");
    }
}          

    @FXML
    public void Retourne_To_N_Menu(ActionEvent event) throws IOException {
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

    @FXML
    private void reset(ActionEvent event) {
        N_add_cours_titre.setText("");
        N_add_cours_matiere.setText("");
        N_add_cours_chemin.setText(""); 
        path1="";
    }
    @FXML
    private void path_cours(ActionEvent event) {   
        
        FileChooser fc = new FileChooser();
        File SelectedFile = fc.showOpenDialog(null);
        if (SelectedFile != null ){
            path1=SelectedFile.getAbsolutePath();
            path1 = path1.replace('\\', '/');
    }
        System.out.println(path1);
    }

}
 

