/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbot_jobtn.gui;


import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import workbot_jobtn.services.OffreService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;
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
import javafx.stage.Stage;
import workbot_jobtn.entites.Offre;
import workbot_jobtn.entites.TypeOffre;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */

public class OffreController_1 implements Initializable {
 public static final String ACCOUNT_SID = "AC04fedb666177e902b410a42d0b4614b9";
    public static final String AUTH_TOKEN = "e19969ecb5f0279d8539e03f2c414f40";

    public static Offre connectedOffre;
    @FXML
    private Button N_BMCours1;
    @FXML
    private TableView<Offre> tableview;
    @FXML
    private TableColumn<?, ?> inputtitre;
    @FXML
    private TableColumn<?, ?> inputdomaine;
    @FXML
    private TableColumn<?, ?> inputdescription;
    @FXML
    private TableColumn<?, ?> inputtypeContrat;
    @FXML
    private TableColumn<?, ?> inputlieu;
    @FXML
    private TableColumn<?, ?> inputanneexperience;
    @FXML
    private TableColumn<?, ?> inputdateexpiration;
    public ObservableList<Offre> list;
    @FXML
    private TableColumn<?, ?> inputsalaire;

    @FXML
    private Button Afficher;
    @FXML
    private Button gotocondidature;
    @FXML
    private Button gotocontrats;
    @FXML
    private Button Home;
    @FXML
    private TextField inputrech2;
    @FXML
    private TableColumn<?, ?> id_offre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        OffreService pss = new OffreService();
        ArrayList<Offre> c = new ArrayList<>();
        try {
            c = (ArrayList<Offre>) pss.AfficherAllOffre();
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        ObservableList<Offre> obs2 = FXCollections.observableArrayList(c);
        int i=0;
        for(Offre k : obs2)
        {
            System.out.println(" for ------------");
            if(k.getTypeOffre().toString().equals("Stage"))
            {
                System.out.println(" hi ------------");
                obs2.get(i).setTypeContrat(k.getTypeStage());
            }
            i++;
        }
        tableview.setItems(obs2);
        id_offre.setCellValueFactory(new PropertyValueFactory<>("id"));
        inputtitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        inputdomaine.setCellValueFactory(new PropertyValueFactory<>("domaine"));
        inputdescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        
        inputtypeContrat.setCellValueFactory(new PropertyValueFactory<>("typeContrat"));
        inputanneexperience.setCellValueFactory(new PropertyValueFactory<>("typeOffre"));
        inputlieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        inputdateexpiration.setCellValueFactory(new PropertyValueFactory<>("dateExpiration"));
        inputsalaire.setCellValueFactory(new PropertyValueFactory<>("salaire"));
        
        
        
        ArrayList<Offre> c2 = new ArrayList<>();
  
        ObservableList<Offre> obs22 = FXCollections.observableArrayList(c2);
   
        
              try {
            list = FXCollections.observableArrayList(
                    pss.AfficherAllOffre()
            );      
            FilteredList<Offre> filteredData = new FilteredList<>(list, e -> true);
            inputrech2.setOnKeyReleased(e -> {
                inputrech2.textProperty().addListener((ObservableValue, oldValue, newValue) -> {
                    filteredData.setPredicate((Predicate<? super Offre>) Offres -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lower = newValue.toLowerCase();
                        if (Offres.getTitre().toLowerCase().contains(lower)) {
                            return true;
                        }

                        return false;
                    });
                });
                SortedList<Offre> sortedData = new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(tableview.comparatorProperty());
                tableview.setItems(sortedData);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
         
        

    }

    @FXML
    private void Afficher(ActionEvent event) throws IOException {

        OffreService ps = new OffreService();
        Offre off = new Offre(tableview.getSelectionModel().getSelectedItem().getId(),
                tableview.getSelectionModel().getSelectedItem().getTitre(),
                tableview.getSelectionModel().getSelectedItem().getSalaire(),
                tableview.getSelectionModel().getSelectedItem().getDescription(),
                tableview.getSelectionModel().getSelectedItem().getDomaine(),
                tableview.getSelectionModel().getSelectedItem().getDateExpiration(),
                tableview.getSelectionModel().getSelectedItem().getTypeContrat(),
                tableview.getSelectionModel().getSelectedItem().getTypeOffre().toString(),
                tableview.getSelectionModel().getSelectedItem().getId_soc(),
                tableview.getSelectionModel().getSelectedItem().getModeTravail(),
                tableview.getSelectionModel().getSelectedItem().getLieu(),
                tableview.getSelectionModel().getSelectedItem().getId_test());
       
    
        System.out.println(" --- "+off.getId());
        OffreController_1.connectedOffre = off;

        Parent page1 = FXMLLoader.load(getClass().getResource("AjouterCondidature.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

   

    @FXML
    private void gotocondidature(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("CandidatureList.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

        //twiliosend(ACCOUNT_SID,AUTH_TOKEN, "+21650460710");

    }
  public static void twiliosend(String ACCOUNT_SID, String AUTH_TOKEN, String num) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Verification verification;
        verification = Verification.creator(
                "VA43d502871f086dd1dc62cb5fccfef0b2",
                num,
                "sms")
                .create();

        System.out.println(verification.getStatus());
    }

 

    @FXML
    private void gotocontrats(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("ContratList.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Home(ActionEvent event) throws IOException {
               Parent page1 = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
        
    }

}
