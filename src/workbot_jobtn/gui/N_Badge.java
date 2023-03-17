/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.awt.Desktop;
import workbot_jobtn.entites.Badge;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import workbot_jobtn.services.N_Services_Badge;
import workbot_jobtn.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class N_Badge implements Initializable {

    @FXML
    private TextField N_cours_recherche_input;

    @FXML
    private WebView N_AdsView;
    private WebEngine e;
    

    /**
     * Initializes the controller class.
     */
    
       private final ObservableList<Badge> dataList = FXCollections.observableArrayList();
        
   @FXML 
   private TableView<Badge> N_view_badge;
   @FXML
   private TableColumn<Badge, String> titre;
    @FXML
    private TableColumn<Badge,Integer> id;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

   
            
         e=N_AdsView.getEngine();
         e.load("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1");
         
           e=N_AdsView.getEngine();
         e.load("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1");
         
           N_Services_Badge sc=new N_Services_Badge();
            ObservableList<Badge> list;
   
          try {
                 
            FilteredList<Badge> filteredData = new FilteredList<>(dataList, b -> true);
		
		N_cours_recherche_input.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(cours -> {
					
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
							
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (cours.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} 
				     else  
				    	 return false; // Does not match.
			});
		});
                
               
            SortedList<Badge> sortedData = new SortedList<>(filteredData);
		
            sortedData.comparatorProperty().bind(N_view_badge.comparatorProperty());
		System.out.println(dataList); 
            dataList.addAll(sc.readAll_Badge(SessionManager.getId()));
            System.out.println(dataList);            
            id.setCellValueFactory(new PropertyValueFactory<Badge, Integer>("id"));
            titre.setCellValueFactory(new PropertyValueFactory<Badge, String>("nom"));
            N_view_badge.setItems(sortedData);
                 
          } catch (SQLException ex) {
              Logger.getLogger(N_Badge.class.getName()).log(Level.SEVERE, null, ex);
          }
    }    



    @FXML
    private void cours(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Affiche.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();

    }

    @FXML
    private void certif(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_rechercher_Certif_Liste.fxml"));
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
