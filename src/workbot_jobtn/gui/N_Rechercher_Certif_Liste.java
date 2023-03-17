package workbot_jobtn.gui;

import java.awt.Desktop;
import java.io.File;
import workbot_jobtn.entites.Certification;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import workbot_jobtn.services.N_Services_Certification;
import workbot_jobtn.utils.SessionManager;

public class N_Rechercher_Certif_Liste implements Initializable{

    @FXML
    private Button Cours_button_menu;

    @FXML
    private WebView N_AdsView;
    private WebEngine e;
        

    @FXML
    private Button N_BCertification;

    @FXML
    private Button N_BHome;

    @FXML
    private Button N_C_consulter;

    @FXML
    private Button N_CertifActualiser;

    @FXML
    private Button N_CertifRetour;

    @FXML
    private TableView<Certification> N_Tab_aff_certif;

    @FXML
    private TextField N_certif_recherche_input;

    @FXML
    private TableColumn<Certification, String> datea;

    @FXML
    private TableColumn<Certification, Integer> id;

    @FXML
    private TableColumn<Certification, String> lien;

    @FXML
    private TableColumn<Certification, String> titrec;

    @FXML
    private TableColumn<Certification, String> titret;

    static public Certification co1=new Certification();
 
 private final ObservableList<Certification> dataList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            e=N_AdsView.getEngine();    
            e.load("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1");
        
            N_Services_Certification sc=new N_Services_Certification();
            ObservableList<Certification> list;
   
          try {
                 
            FilteredList<Certification> filteredData = new FilteredList<>(dataList, b -> true);
		
		N_certif_recherche_input.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(certif -> {
					
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
		
                                
				String lowerCaseFilter = newValue.toLowerCase();
                                
                                String t=""+certif.getId();
                                if(t.toLowerCase().indexOf(lowerCaseFilter) != -1)
                                {
                                   return true;  
                                }				
                                else if (certif.getTitreCours().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (certif.getTitreTest().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                else if (certif.getDateAjout().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                else if (certif.getLien().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				     else  
				    	 return false; // Does not match.
			});
		});
                
               
            SortedList<Certification> sortedData = new SortedList<>(filteredData);
		
            sortedData.comparatorProperty().bind(N_Tab_aff_certif.comparatorProperty());
            int idu =SessionManager.getId();
            dataList.addAll(sc.readAll_Certif_U(idu));
            System.out.println(dataList);             
            id.setCellValueFactory(new PropertyValueFactory<Certification, Integer>("id"));
            titrec.setCellValueFactory(new PropertyValueFactory<Certification, String>("titreCours"));
            titret.setCellValueFactory(new PropertyValueFactory<Certification, String>("titreTest"));
            datea.setCellValueFactory(new PropertyValueFactory<Certification, String>("dateAjout"));
            lien.setCellValueFactory(new PropertyValueFactory<Certification, String>("lien"));
            N_Tab_aff_certif.setItems(sortedData);
                 
          } catch (SQLException ex) {
              Logger.getLogger(N_Rechercher_Certif_Liste.class.getName()).log(Level.SEVERE, null, ex);
          }  
    }
    
         @FXML
    void Afficher_certif_a_consulter(ActionEvent event) throws IOException, URISyntaxException {
       int index;
       index =  N_Tab_aff_certif.getSelectionModel().getSelectedIndex();
       
       if(index <= -1){
          
            return;
       }
    co1.setId(id.getCellData(index).intValue());
    co1.setTitreCours(titrec.getCellData(index).toString());
    co1.setTitreTest(titret.getCellData(index).toString());
    co1.setDateAjout(datea.getCellData(index).toString());
    co1.setLien(lien.getCellData(index).toString());
    
        Desktop.getDesktop().browse(new URI("http://127.0.0.1:8000/question/reponse/"+co1.getId()+"/testQuiz"));

    }

    void B_badge(ActionEvent event) throws IOException {
               /* Stage stage = (Stage) N_C_consulter.getScene().getWindow();
                stage.close();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(".fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage = new Stage();
                stage.setScene(new Scene(root1,895,525)); 
                stage.resizableProperty().setValue(false);
                stage.show();
                */
    }

    @FXML
    void B_cours(ActionEvent event) throws IOException {
        
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Affiche.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
              
    }

    @FXML
    void B_home(ActionEvent event) throws IOException {
                        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Home.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
        
        
    }

    @FXML
    void N_W_CertifRetour(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Home.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }

    @FXML
    void N_W_Certif_actualiser(ActionEvent event) throws IOException {
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("N_Rechercher_Certif_Liste.fxml"));
        Scene stage=new Scene(fXMLLoader);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();       
        

    }

       void passerTest(ActionEvent event) throws IOException {
      

}

    @FXML
    private void passerTest(MouseEvent event) {
    }

    @FXML
    private void Browser(MouseEvent event) throws URISyntaxException, IOException {
                Desktop.getDesktop().browse(new URI("https://www.profitablegatetocontent.com/d38ziwqqhm?key=833e83d5b619c6162602e331d6104cd1"));

    }

    

}
