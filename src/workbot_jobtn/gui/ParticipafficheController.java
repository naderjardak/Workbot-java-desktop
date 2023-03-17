/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import workbot_jobtn.entites.Evennement;
import workbot_jobtn.entites.Participation;
import workbot_jobtn.entites.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.List;
import java.util.Properties;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import workbot_jobtn.services.EventService;
import workbot_jobtn.services.Partiservice;
import workbot_jobtn.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ParticipafficheController implements Initializable {

    @FXML
    private TableView<Evennement> HTABV1;
    @FXML
    private TableColumn<Evennement, String> aff_datedb1;
    @FXML
    private TableColumn<Evennement, String> aff_datefin1;
    @FXML
    private TableColumn<Evennement, String> aff_lib1;
    @FXML
    private TableColumn<Evennement, String> aff_heuredb1;
    @FXML
    private TableColumn<Evennement, String> aff_heurefin1;
    @FXML
    private TableColumn<Evennement, Integer> aff_nbplc1;
    @FXML
    private TableColumn<Evennement, String> aff_prix1;
    @FXML
    private TableColumn<Evennement, String> aff_flyer1;
    @FXML
    private TableColumn<Evennement, String> aff_video1;
    @FXML
    private TableColumn<Evennement, Integer> idev;

    /**
     * Initializes the controller class.
     */
    ObservableList<Evennement> list = FXCollections.observableArrayList();
    @FXML
    private Button btnajpart;
    @FXML
    private Button retourpart;
    @FXML
    private Label alertparticipaff;
    @FXML
    private Button homepartaff;
    @FXML
    private Button eventsrefrech;
    @FXML
    private TextField searchinput;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        FilteredList<Evennement> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		searchinput.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(admin -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (admin.getLibelle().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter prenom.
				}
                                
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Evennement> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(HTABV1.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		HTABV1.setItems(sortedData);
               
        
      
        
       
         
        try {
          //  FilteredList<Evennement> filteredData = new FilteredList<>(list, b -> true);
            EventService es=new EventService();
            Evennement e = new Evennement();
            /*
            
*/
                
           //     SortedList<Evennement> sortedData = new SortedList<>(filteredData);
		
            sortedData.comparatorProperty().bind(HTABV1.comparatorProperty());
         
            
            int ids=SessionManager.getId();
            list.addAll(es.readALL_p());
            System.out.println((List)list);
            
            
            
            
            aff_datedb1.setCellValueFactory(new PropertyValueFactory<Evennement, String>("dateDebut"));
            aff_datefin1.setCellValueFactory(new PropertyValueFactory<Evennement, String>("dateFin"));
            aff_lib1.setCellValueFactory(new PropertyValueFactory<Evennement, String>("libelle"));
            aff_heuredb1.setCellValueFactory(new PropertyValueFactory<Evennement, String>("heureDebut"));
            aff_heurefin1.setCellValueFactory(new PropertyValueFactory<Evennement, String>("heureFin"));
            aff_nbplc1.setCellValueFactory(new PropertyValueFactory<Evennement, Integer>("nbPlaces"));
            aff_prix1.setCellValueFactory(new PropertyValueFactory<Evennement, String>("prix"));
            aff_flyer1.setCellValueFactory(new PropertyValueFactory<Evennement, String>("flyer"));
            aff_video1.setCellValueFactory(new PropertyValueFactory<Evennement, String>("video"));
            idev.setCellValueFactory(new PropertyValueFactory<Evennement, Integer>("id"));
            
             sortedData.comparatorProperty().bind(HTABV1.comparatorProperty());
             HTABV1.setItems(sortedData);
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(ParticipafficheController.class.getName()).log(Level.SEVERE, null, ex);
}


    } 

    @FXML
    private void remplire_update(MouseEvent event) {
        
        
    }

    @FXML
    private void btn_ajpart(ActionEvent event) throws SQLException, IOException {
        
        int index;
        
        
       index =  HTABV1.getSelectionModel().getSelectedIndex();
       
       if(index <= -4){
          
            return;
       }
       
            Stage stage = (Stage) HTABV1.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("participaffiche.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
               
       Participation p=new Participation();
       p.setId_event(idev.getCellData(index).intValue());
       p.setId_userP(SessionManager.getId());
       EventService es=new EventService();
       Partiservice ps=new Partiservice();
       ps.ajouterp(p);
       es.update_place(idev.getCellData(index).intValue());
       
       message();
       
       alertparticipaff.setText("Participation ajoutée avec succés");
    }

    @FXML
    private void annulerpart(ActionEvent event) throws SQLException, IOException {
        Stage stage = (Stage) alertparticipaff.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("participannule.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
        
        
    }

    @FXML
    private void retourpartev(ActionEvent event) throws IOException {
        Stage stage = (Stage) alertparticipaff.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("firstparticip.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }

    @FXML
    private void doclickhomepartaff(ActionEvent event) throws IOException {
        Stage stage = (Stage) alertparticipaff.getScene().getWindow();
                stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("Home.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage.setScene(new Scene(root1,900,550)); 
                stage.show();
    }
    @FXML
    private void doclickeventsrefrech(ActionEvent event) {
    }
    public void message() {
Thread th = new Thread(() -> {
        User u = new User();
        
   //     String nom10000 = Rec_Email.getText();
        String username = "houssem.bribech@esprit.tn";
        String password = "213JMT670555";
// Etape 1 : Création de la session
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.debug", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
// Etape 2 : Création de l'objet Message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(SessionManager.getEmail()));
            message.setSubject("Test email");
            message.setText("Votre participation a été effectuer avec succés");
// Etape 3 : Envoyer le message
            Transport.send(message);
            System.out.println("Message_envoye");
        } catch ( MessagingException e) {
            throw new RuntimeException(e);
        }
                });
        th.setDaemon(true);
        th.start();  
    }

    
}

