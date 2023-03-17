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
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static workbot_jobtn.gui.AjouterCondidatureController.sendMail;
import workbot_jobtn.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class TacheDetailController implements Initializable {

    @FXML
    private Label labeltitre;
    @FXML
    private Label labelsalaire;
    @FXML
    private Label labeldescription;
    @FXML
    private Label labeldomaine;
    @FXML
    private Button Contacter;
    @FXML
    private Hyperlink prec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labeltitre.setText(OffreController_1.connectedOffre.getTitre());
        labeldomaine.setText(OffreController_1.connectedOffre.getDomaine());
        labeldescription.setText(OffreController_1.connectedOffre.getDescription());

        labelsalaire.setText(OffreController_1.connectedOffre.getSalaire());
    }
 public static void sendMail(String recipient,String Subject,String Text) throws MessagingException {
       Thread th = new Thread(() -> {
     System.out.println("Preparing to send email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        String myAccountEmail = "pidev45@gmail.com";
        String password = "uxxyvfdrustffozf";
        Session session = Session.getInstance(properties, new Authenticator() {
             @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(myAccountEmail, password);
            }
        });
            
        Message message = prepareMessage(session, myAccountEmail, recipient,Subject,Text);

           try {
               javax.mail.Transport.send(message);
           } catch (MessagingException ex) {
               Logger.getLogger(TacheDetailController.class.getName()).log(Level.SEVERE, null, ex);
           }
        System.out.println("Message sent successfully");
                        });
        th.setDaemon(true);
        th.start();  
        
    }  
   
    
    private static Message prepareMessage(Session session, String myAccountEmail, String recipient,String Subject,String Text) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(Subject);
            message.setText(Text);
            return message;
        } catch (MessagingException ex) {
          
        }
        return null;} 
    @FXML
    private void Contacter(ActionEvent event) throws SQLException, IOException, MessagingException {
        CondidatureService productService = new CondidatureService();

          Date date = new Date(System.currentTimeMillis());
            java.sql.Date d2 = new java.sql.Date(date.getTime());
            String sqlDate2=d2.toString();

        Candidature ccc = new Candidature("non traité", " ", " ", sqlDate2, OffreController_1.connectedOffre.getId(),SessionManager.getId(), " ",
                 " ", " ", " ", "tache", " ",OffreController_1.connectedOffre.getDomaine()
                ,OffreController_1.connectedOffre.getTitre(),OffreController_1.connectedOffre.getDateExpiration());

        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("Confirmer ");
        a.setHeaderText(null);
        a.showAndWait();
        productService.AjouterCandidateure(ccc);

        Parent page1 = FXMLLoader.load(getClass().getResource("Offre_1.fxml"));
        Scene scene = new Scene(page1);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
          sendMail("ameni.boughanmi@esprit.tn", "Votre Candidature a été envoyé avec succées", 
                  "Votre Candidature a été envoyé avec succées");
        
        

    }
;

    @FXML
    private void prec(ActionEvent event) throws IOException {
        
               Parent page1 = FXMLLoader.load(getClass().getResource("Offre_1.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }


}
