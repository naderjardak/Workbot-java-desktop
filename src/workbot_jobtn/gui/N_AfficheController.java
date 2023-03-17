/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.gui;

import java.awt.Desktop;
import java.awt.Toolkit;
import workbot_jobtn.entites.Cours;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
//import jdbc.JDBC;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import workbot_jobtn.services.N_Services_Cours;

  




public class N_AfficheController implements Initializable{

    @FXML
    private Button N_B_rechercher_Cours; 
      
    @FXML
    private TextField N_cours_recherche_input;

    @FXML
    private CheckBox N_electronique;

    @FXML
    private CheckBox N_informatique;

    @FXML
    private CheckBox N_mecanique;

    @FXML
    private CheckBox N_reseau;

    
    @FXML
    private ChoiceBox N_categorie;
    
    
    
   @FXML
        private WebView N_AdsView;
        private WebEngine e;
        
    
    @FXML
    private GridPane coursContainer;
    
     Connection connexion;
    
     static public Cours co=new Cours();
  
   private final ObservableList<Cours> dataList = FXCollections.observableArrayList();
    @FXML
    private Button retourne;
      @Override
       	public void initialize(URL url, ResourceBundle rb) {
        try {
            N_categorie.getItems().add("Fondamentale");
            N_categorie.getItems().add("Appliquée");
            N_Services_Cours sc=new N_Services_Cours();
            
            int column =0;
            int row=1;
            
            e=N_AdsView.getEngine();
            e.load("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1");

            List<Cours> affichage;
          
                affichage =new ArrayList<>(sc.read_Cours());
                
               
                for(Cours cours:affichage)
                {
                    
                    FXMLLoader fxmlloader=new FXMLLoader();
                    
                    fxmlloader.setLocation(getClass().getResource("N_cardCours.fxml"));
                    
                    try {
                        VBox coursBox1 = fxmlloader.load(); System.out.println("-----------");
                        N_cardCours cardcours=fxmlloader.getController();
                        cardcours.setData(cours);
                        
                        if(column==3)
                        {
                            column=0;
                            ++row;
                        }
                        coursContainer.add(coursBox1,column++,row);
                        GridPane.setMargin(coursBox1, new Insets(10));
                        
                        
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(N_AfficheController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
    

        } catch (SQLException ex) {
            Logger.getLogger(N_AfficheController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }   
            
       
            
           
      
        
    
      @FXML
    void rechercher_cours(ActionEvent event) throws IOException, SQLException {
            coursContainer.getChildren().clear();
            int column =0;
            int row=1;
            
            
        String titre1=N_cours_recherche_input.getText();
        
       String categorie1=N_categorie.getValue().toString();  
      
       
           String domaine1="";
            if(N_informatique.isSelected())
                domaine1=(domaine1+"informatique");
            if(N_electronique.isSelected())
                domaine1=(domaine1+" electronique");
            if(N_mecanique.isSelected())
                domaine1=(domaine1+" mecanique");
            if(N_reseau.isSelected())
                domaine1=(domaine1+" resau"); 
           
        System.out.println("....."+domaine1);          
        N_Services_Cours sc=new N_Services_Cours();
        
                   Cours c=new Cours(titre1,domaine1,categorie1);
                ObservableList<Cours> list;
                list = sc.rechercherCours(c);
                for(Cours cours:list)
            {
               
                FXMLLoader fxmlloader=new FXMLLoader();
                
                fxmlloader.setLocation(getClass().getResource("N_cardCours.fxml"));         
                     
             
                   VBox coursBox1 = fxmlloader.load(); 
                    N_cardCours cardcours=fxmlloader.getController();
                    cardcours.setData(cours);
                    
                if(column==3)
                {
                    column=0;
                    ++row;
                }
                coursContainer.add(coursBox1,column++,row);
                GridPane.setMargin(coursBox1, new Insets(10));
        
    }  
 }
    
    
    
    
    
    
    
    void N_Consulter_Cours(MouseEvent event) throws IOException {
      

    }
    
    
    @FXML
    void retourne(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Home.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
       
    }

    @FXML
    private void certif(ActionEvent event) throws IOException {
        
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Rechercher_Certif_Liste.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
      
    }

    @FXML
    private void home(ActionEvent event) throws IOException {

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
