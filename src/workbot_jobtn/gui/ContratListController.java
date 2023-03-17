/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbot_jobtn.gui;

import java.awt.Desktop;
import java.io.File;
import workbot_jobtn.services.CondidatureService;
import workbot_jobtn.services.ContratService;
import workbot_jobtn.entites.Candidature;
import workbot_jobtn.entites.Contrat;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class ContratListController implements Initializable {
private Label label;
    @FXML
    private Button gotooffre;
    @FXML
    private TableView<Contrat> tableview2;
    @FXML
    private TableColumn<?, ?> typeContrat;
    @FXML
    private TableColumn<?, ?> dateDebut;
    @FXML
    private TableColumn<?, ?> dateFin;
    @FXML
    private TableColumn<?, ?> salaire;
    @FXML
    private TableColumn<?, ?> lien;
    @FXML
    private Button gotocontrats;
    @FXML
    private Button AjouterContrat;
    @FXML
    private Button Modifier;
public static  Contrat connectedContrat;
    @FXML
    private Button Supprimer;
    @FXML
    private TableColumn<?, ?> datecreation;
    @FXML
    private Button Home;
    @FXML
    private Button AfficheParEtat;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             ContratService pss = new ContratService();
        ArrayList<Contrat> c = new ArrayList<>();
        try {
            c = (ArrayList<Contrat>) pss.AfficherAllContrat();
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        ObservableList<Contrat> obs2 = FXCollections.observableArrayList(c);
        tableview2.setItems(obs2);

        typeContrat.setCellValueFactory(new PropertyValueFactory<>("typeContrat"));
        dateDebut.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        dateFin.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        salaire.setCellValueFactory(new PropertyValueFactory<>("salaire"));
        lien.setCellValueFactory(new PropertyValueFactory<>("lien"));
        datecreation.setCellValueFactory(new PropertyValueFactory<>("dateCreation"));
        // id_candidature.setCellValueFactory(new PropertyValueFactory<>("id_candidature"));
    }    

   @FXML
    private void gotooffre(ActionEvent event) throws IOException {
                  Parent page1 = FXMLLoader.load(getClass().getResource("Offre_1.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void gotocondidature(ActionEvent event) throws IOException {
            Parent page1 = FXMLLoader.load(getClass().getResource("CandidatureList.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
        
    }

    private void AjouterContrat(ActionEvent event) throws IOException {
             Parent page1 = FXMLLoader.load(getClass().getResource("ContratCreation.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void Modifier(ActionEvent event) throws IOException {
            ContratService ps = new ContratService();
        Contrat c = new Contrat(tableview2.getSelectionModel().getSelectedItem().getId(),
                tableview2.getSelectionModel().getSelectedItem().getTypeContrat(),
                 tableview2.getSelectionModel().getSelectedItem().getDateDebut(),
                tableview2.getSelectionModel().getSelectedItem().getSalaire(),
               tableview2.getSelectionModel().getSelectedItem().getDateFin(),
                tableview2.getSelectionModel().getSelectedItem().getLien(),
                 tableview2.getSelectionModel().getSelectedItem().getId_candidature(),
                 tableview2.getSelectionModel().getSelectedItem().getDateCreation() );
               
        ContratListController.connectedContrat = c;
        
             Parent page1 = FXMLLoader.load(getClass().getResource("ContratModifier.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
        
    }

    @FXML
    private void Supprimer(ActionEvent event) throws SQLException {
         if (event.getSource() ==  Supprimer) {
            Contrat rec = new Contrat();
            rec.setId(tableview2.getSelectionModel().getSelectedItem().getId());  
            ContratService cs = new ContratService();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Delete ");
      alert.setHeaderText("Are you sure want to delete this Contract");
      alert.setContentText(" ");

      // option != null.
      Optional<ButtonType> option = alert.showAndWait();

      if (option.get() == null) {
       
      } else if (option.get() == ButtonType.OK) {
          cs.SupprimerContrat(rec);
              TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.SLIDE;
            tray.setAnimationType(type);
            tray.setTitle("Contrat supprimé avec succées");
            tray.setMessage("Contrat supprimé avec succées");
            tray.setNotificationType(NotificationType.WARNING);
            tray.showAndDismiss(Duration.millis(3000));
          
       
      } else if (option.get() == ButtonType.CANCEL) {
      
      } else {
         this.label.setText("-");
      }
            
            resetTableData();  
        
        
         }
    }
      public void resetTableData() throws SQLDataException, SQLException {
 ContratService cs = new ContratService();
        List<Contrat> listrec = new ArrayList<>();
        listrec = cs.AfficherAllContrat();
        ObservableList<Contrat> data = FXCollections.observableArrayList(listrec);
        tableview2.setItems(data);
    }

    @FXML
    private void Home(ActionEvent event) throws IOException {
               Parent page1 = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
        
    }
public void AfficherParSalaire() throws SQLDataException, SQLException {
 ContratService cs = new ContratService();
         List<Contrat> listrec = new ArrayList<>();
        listrec = cs.AfficherAllContratBySalaire();
        ObservableList<Contrat> data = FXCollections.observableArrayList(listrec);
        tableview2.setItems(data);
    }    
    @FXML
    private void AfficheParEtat(ActionEvent event) throws SQLException {
        
        AfficherParSalaire();
        
        
    }

    @FXML
    private void AfficherContrat(ActionEvent event) throws IOException {
                            Desktop.getDesktop().open(new File("C:\\PDFapi\\" +tableview2.getSelectionModel().getSelectedItem().getId_candidature() + ".pdf"));

    }

    @FXML
    private void onclickCandidature(ActionEvent event) throws IOException {
                Parent page1 = FXMLLoader.load(getClass().getResource("CandidatureList.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
