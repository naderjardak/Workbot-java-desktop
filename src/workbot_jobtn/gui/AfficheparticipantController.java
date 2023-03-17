package workbot_jobtn.gui;

import workbot_jobtn.entites.Evennement;
import workbot_jobtn.entites.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import static java.util.Collections.list;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import workbot_jobtn.services.EventService;
import workbot_jobtn.services.Partiservice;

public class AfficheparticipantController implements Initializable {
    ObservableList<User> list = FXCollections.observableArrayList();

  

    @FXML
    private TableView<User> HTBPART;

    @FXML
    private TableColumn<User, String> H_mail;

    @FXML
    private TableColumn<User, String> H_nom;

    @FXML
    private TableColumn<User, String> H_prenom;
    @FXML
    private Button retour;
    @FXML
    private Button H_homebtn;
    @FXML
    private Button refrechev;
    @FXML
    private Button btnaddrefrech;
   



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        try {
            User u=new User();
            //int ide=
            Partiservice ps=new Partiservice();
            System.out.println(list);
            int ide=AfficheeventController.ide;
            list.addAll(ps.readALLpr(ide));
            
            H_nom.setCellValueFactory(new PropertyValueFactory<User, String>("nom"));
            H_prenom.setCellValueFactory(new PropertyValueFactory<User, String>("prenom"));
            H_mail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
            HTBPART.setItems((ObservableList<User>) list);
        } catch (SQLException ex) {
            Logger.getLogger(AfficheparticipantController.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    @FXML
    private void retourpartaff(ActionEvent event) throws IOException {
        
        Stage stage = (Stage) retour.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("afficheevent.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }

    @FXML
    private void doclickhomebtnpartaff(ActionEvent event) throws IOException {
        Stage stage = (Stage) retour.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("HomeSociete.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }

    @FXML
    private void doclickrefrechev(ActionEvent event) {
    }

    @FXML
    private void doclickbtnaddrefrech(ActionEvent event) throws IOException {
             Stage stage = (Stage) retour.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("newhomeevent.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }
}

