/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbot_jobtn.gui;

import workbot_jobtn.services.CondidatureService;
import workbot_jobtn.entites.Candidature;
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
import javafx.scene.control.Alert.AlertType;
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
public class CandidatureListController implements Initializable {
private Label label;
    public static Candidature connectedCondidature;
    @FXML
    private Button N_BMHome1;
    @FXML
    private TableView<Candidature> tableview2;
    private TableColumn<?, ?> id_usertable;
    private TableColumn<?, ?> Experience;
    private TableColumn<?, ?> NiveauFrancais;
    private TableColumn<?, ?> NiveauAnglais;
    private TableColumn<?, ?> diplome;
    @FXML
    private Button gotooffre;
    @FXML
    private Button gotocontrats;
    @FXML
    private Button Modifier;
    @FXML
    private Button Supprimer;
    private TableColumn<?, ?> TypeCondidature;
    @FXML
    private Button Home;
    @FXML
    private TableColumn<?, ?> Domaine;
    @FXML
    private TableColumn<?, ?> titre;
    @FXML
    private TableColumn<?, ?> date;
    @FXML
    private TableView<Candidature> tableview3;
    @FXML
    private TableColumn<?, ?> Domaine1;
    @FXML
    private TableColumn<?, ?> titre1;
    @FXML
    private TableColumn<?, ?> date1;
    @FXML
    private TableColumn<?, ?> dateexpriration;
    @FXML
    private Button Modifier1;
    @FXML
    private Button Supprimer2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CondidatureService pss = new CondidatureService();
       
        
        ArrayList<Candidature> c = new ArrayList<>();
        try {
            c = (ArrayList<Candidature>) pss.AfficherAllCandidature();
                        System.out.println(c);

        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        
          ArrayList<Candidature> c2 = new ArrayList<>();
           System.out.println(c2);
        try {
            c2 = (ArrayList<Candidature>) pss.AfficherAllCandidatureTache();
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
        
        ObservableList<Candidature> obs2 = FXCollections.observableArrayList(c);
        ObservableList<Candidature> obs3 = FXCollections.observableArrayList(c2);
   
      Domaine.setCellValueFactory(new PropertyValueFactory<>("Domaine"));
        titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        date.setCellValueFactory(new PropertyValueFactory<>("dateAjout"));
        
       Domaine1.setCellValueFactory(new PropertyValueFactory<>("Domaine"));
        titre1.setCellValueFactory(new PropertyValueFactory<>("titre"));
                date1.setCellValueFactory(new PropertyValueFactory<>("dateAjout"));

        dateexpriration.setCellValueFactory(new PropertyValueFactory<>("dateAjout"));
           tableview2.setItems(obs2);
         tableview3.setItems(obs3);
    }


    @FXML
    private void gotooffre(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("Offre_1.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
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
    private void Modifier(ActionEvent event) throws IOException {
        CondidatureService ps = new CondidatureService();
        Candidature c = new Candidature(tableview2.getSelectionModel().getSelectedItem().getId(),
                tableview2.getSelectionModel().getSelectedItem().getStatut(),
                tableview2.getSelectionModel().getSelectedItem().getLettreMotivation(),
                tableview2.getSelectionModel().getSelectedItem().getNoteTest(),
                tableview2.getSelectionModel().getSelectedItem().getDateAjout(),
                tableview2.getSelectionModel().getSelectedItem().getId_offre(),
                tableview2.getSelectionModel().getSelectedItem().getIdcondidat(),
                tableview2.getSelectionModel().getSelectedItem().getNiveauFrancais(),
                tableview2.getSelectionModel().getSelectedItem().getNiveauAnglais(),
                tableview2.getSelectionModel().getSelectedItem().getCv(),
                 tableview2.getSelectionModel().getSelectedItem().getExperience(),
                tableview2.getSelectionModel().getSelectedItem().getTypeCondidature(),
                tableview2.getSelectionModel().getSelectedItem().getDiplome(),
           tableview2.getSelectionModel().getSelectedItem().getDomaine(),
                      tableview2.getSelectionModel().getSelectedItem().getTitre(),
                tableview2.getSelectionModel().getSelectedItem().getDateExpiration()
        );

        CandidatureListController.connectedCondidature = c;

        Parent page1 = FXMLLoader.load(getClass().getResource("CandidatureModifier.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void Supprimer(ActionEvent event) throws SQLException {
      
        if (event.getSource() == Supprimer) {
            Candidature rec = new Candidature();
            rec.setId(tableview2.getSelectionModel().getSelectedItem().getId());
            CondidatureService cs = new CondidatureService();
            Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Delete ");
      alert.setHeaderText("Are you sure want to delete this candidature");
      alert.setContentText(" ");

      // option != null.
      Optional<ButtonType> option = alert.showAndWait();

      if (option.get() == null) {
       
      } else if (option.get() == ButtonType.OK) {
           cs.SupprimerCandidature(rec);
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.SLIDE;
            tray.setAnimationType(type);
            tray.setTitle("Condidature supprimé avec succées");
            tray.setMessage("Condidature supprimé avec succées");
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
        CondidatureService cs = new CondidatureService();
        List<Candidature> listrec = new ArrayList<>();
        listrec = cs.AfficherAllCandidature();
        ObservableList<Candidature> data = FXCollections.observableArrayList(listrec);
        tableview2.setItems(data);
    }
public void resetTableData2() throws SQLDataException, SQLException {
        CondidatureService cs = new CondidatureService();
        List<Candidature> listrec = new ArrayList<>();
        listrec = cs.AfficherAllCandidatureTache();
        ObservableList<Candidature> data = FXCollections.observableArrayList(listrec);
        tableview3.setItems(data);
    }
    private void gotocontact(ActionEvent event) throws IOException {
            Parent page1 = FXMLLoader.load(getClass().getResource("ContratCreation.fxml"));
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

    @FXML
    private void Supprimer2(ActionEvent event) throws SQLException {
          if (event.getSource() == Supprimer2) {
            Candidature rec = new Candidature();
            rec.setId(tableview3.getSelectionModel().getSelectedItem().getId());
            CondidatureService cs = new CondidatureService();
            Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Delete ");
      alert.setHeaderText("Are you sure want to delete this tache");
      alert.setContentText(" ");

      // option != null.
      Optional<ButtonType> option = alert.showAndWait();

      if (option.get() == null) {
       
      } else if (option.get() == ButtonType.OK) {
           cs.SupprimerCandidature(rec);
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.SLIDE;
            tray.setAnimationType(type);
            tray.setTitle("Condidature supprimé avec succées");
            tray.setMessage("Condidature supprimé avec succées");
            tray.setNotificationType(NotificationType.WARNING);
            tray.showAndDismiss(Duration.millis(3000));
       
      } else if (option.get() == ButtonType.CANCEL) {
      
      } else {
         this.label.setText("-");
      }
          
           
         
            
            
            resetTableData2();

        }
        
        
    }

}
