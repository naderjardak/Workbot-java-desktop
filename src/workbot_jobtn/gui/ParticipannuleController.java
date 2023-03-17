/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import workbot_jobtn.entites.Evennement;
import workbot_jobtn.entites.Participation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import workbot_jobtn.services.EventService;
import workbot_jobtn.services.Partiservice;
import workbot_jobtn.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ParticipannuleController implements Initializable {

    @FXML
    private TableView<Evennement> HTABV2;
    @FXML
    private TableColumn<Evennement, String> aff_datedb2;
    @FXML
    private TableColumn<Evennement, String> aff_datefin2;
    @FXML
    private TableColumn<Evennement, String> aff_lib2;
    @FXML
    private TableColumn<Evennement, String> aff_heuredb2;
    @FXML
    private TableColumn<Evennement, String> aff_heurefin2;
    @FXML
    private TableColumn<Evennement, Integer> aff_nbplc2;
    @FXML
    private TableColumn<Evennement, String> aff_prix1;
    @FXML
    private TableColumn<Evennement, String> aff_flyer2;
    @FXML
    private TableColumn<Evennement, String> aff_video2;
    @FXML
    private TableColumn<Evennement, Integer> idev2;
     ObservableList<Evennement> list = FXCollections.observableArrayList();
   
    @FXML
    private Label annullepartlabel;
    @FXML
    private Button homepartannul;
    @FXML
    private Button RETparticip;
    @FXML
    private Button refrech;
    @FXML
    private Button Topartaffiche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            
            EventService es=new EventService();
            
            
            int ids=SessionManager.getId();
            list.addAll(es.readALL_p_Ann());
            System.out.println((List)list);
            
            
            
            
            aff_datedb2.setCellValueFactory(new PropertyValueFactory<Evennement, String>("dateDebut"));
            aff_datefin2.setCellValueFactory(new PropertyValueFactory<Evennement, String>("dateFin"));
            aff_lib2.setCellValueFactory(new PropertyValueFactory<Evennement, String>("libelle"));
            aff_heuredb2.setCellValueFactory(new PropertyValueFactory<Evennement, String>("heureDebut"));
            aff_heurefin2.setCellValueFactory(new PropertyValueFactory<Evennement, String>("heureFin"));
            aff_nbplc2.setCellValueFactory(new PropertyValueFactory<Evennement, Integer>("nbPlaces"));
            aff_prix1.setCellValueFactory(new PropertyValueFactory<Evennement, String>("prix"));
            aff_flyer2.setCellValueFactory(new PropertyValueFactory<Evennement, String>("flyer"));
            aff_video2.setCellValueFactory(new PropertyValueFactory<Evennement, String>("video"));
            idev2.setCellValueFactory(new PropertyValueFactory<Evennement, Integer>("id"));
            
             HTABV2.setItems( list);
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(ParticipafficheController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
    }    

    private void retourpartev2(ActionEvent event) throws IOException {
        Stage stage = (Stage) HTABV2.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("participaffiche.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }

    @FXML
    private void remplire_update(MouseEvent event) {
    }

    @FXML
    private void annulerpart2(ActionEvent event) throws SQLException, IOException {
        int index;
        
        
       index =  HTABV2.getSelectionModel().getSelectedIndex();
       
       if(index <= -4){
          
            return;
    }
       Participation p=new Participation();
       p.setId_event(idev2.getCellData(index).intValue());
       p.setId_userP(SessionManager.getId());
        Partiservice ps=new Partiservice();
       ps.deletep(p);
      Stage stage = (Stage) HTABV2.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("participannule.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
        annullepartlabel.setText("Participation annulé avec succés");
    }

    private void homeannule1(ActionEvent event) throws IOException {
        Stage stage = (Stage) HTABV2.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("Home.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }

    @FXML
    private void doclickhomepartannul(ActionEvent event) throws IOException {
        Stage stage = (Stage) HTABV2.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("firstparticip.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }

    @FXML
    private void doclickRETparticip(ActionEvent event) throws IOException {
        Stage stage = (Stage) HTABV2.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("participaffiche.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }

    @FXML
    private void doclickrefrech(ActionEvent event) {
    }

    @FXML
    private void doclickTopartaffiche(ActionEvent event) throws IOException {
        Stage stage = (Stage) HTABV2.getScene().getWindow();
                stage.close();
       FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("participaffiche.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }
    
}
