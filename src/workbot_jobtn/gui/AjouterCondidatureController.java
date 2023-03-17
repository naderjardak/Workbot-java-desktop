/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbot_jobtn.gui;


import workbot_jobtn.services.CondidatureService;
import workbot_jobtn.entites.Candidature;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import workbot_jobtn.entites.TypeOffre;
import javax.mail.Transport;
import workbot_jobtn.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class AjouterCondidatureController implements Initializable {
private Label label;
    @FXML
    private Label labeldescription;
    @FXML
    private Label labeltitre;
    @FXML
    private Label labeldurée;
    @FXML
    private Label labelanneeexperience;
    @FXML
    private Label labeldomaine;
    @FXML
    private Label labellieu;
    @FXML
    private Label labelmodetravail;
    @FXML
    private Label labelsalaire;
    @FXML
    private Label labeltypecontrat;
    @FXML
    private TextField inputexperience;
    @FXML
    private ComboBox<String> inputdiplome;
    @FXML
    private TextArea inputmotivation;
    @FXML
    private ComboBox<String> inputfrancais;
    @FXML
    private ComboBox<String> inputanglais;
    @FXML
    private Button Postuler;
    @FXML
    private Button Timage;
    @FXML
    private ImageView imgajoutincours;
    @FXML
    private Label imgpathttt;
    @FXML
    private Hyperlink prec;
    @FXML
    private Button Home;
    @FXML
    private Button gotooffre;
    @FXML
    private Button N_BMHome1;
    @FXML
    private Button gotocontrats;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inputdiplome.getItems().addAll("Informatique", "Mecanique", "Electrique", "Genie Civil", "Finance", "Marketing", "Aéronotique");

        inputfrancais.getItems().addAll("Notions", "Compétence Professionnelle limitée", "Compétence Professionnelle",
                "Capacité Professionnelle compléte ", "Bilingue ou lange natale");
        inputanglais.getItems().addAll("Notions", "Compétence Professionnelle limitée", "Compétence Professionnelle",
                "Capacité Professionnelle compléte ", "Bilingue ou lange natale");

        labeltitre.setText(OffreController_1.connectedOffre.getTitre());
        labeldomaine.setText(OffreController_1.connectedOffre.getDomaine());
        labeldescription.setText(OffreController_1.connectedOffre.getDescription());
        labeldurée.setText(OffreController_1.connectedOffre.getDureeStage());
        labeltypecontrat.setText(OffreController_1.connectedOffre.getTypeContrat());
        labelanneeexperience.setText(OffreController_1.connectedOffre.getAnneeExperience());
        labelmodetravail.setText(OffreController_1.connectedOffre.getModeTravail());
        labellieu.setText(OffreController_1.connectedOffre.getLieu());
        labelsalaire.setText(OffreController_1.connectedOffre.getSalaire());

    }

    @FXML
    private void Postuler(ActionEvent event) throws IOException, SQLException, MessagingException {
        CondidatureService productService = new CondidatureService();

        if (inputexperience.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Veuillez saisir tous les champs ");
            a.setHeaderText(null);
            a.showAndWait();
        } 
        else if (inputmotivation.getText().length()>600){
                Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("la lettre de motivation ne doit pas étre plus que 600 lettres");
            a.setHeaderText(null);
            a.showAndWait();
            
        }
        
        
        else {

            Date date = new Date(System.currentTimeMillis());
            java.sql.Date d2 = new java.sql.Date(date.getTime());
            String sqlDate2=d2.toString();
            System.out.println("111111  "+SessionManager.getId());
                        System.out.println(OffreController_1.connectedOffre.getId());

            Candidature ccc = new Candidature("non traité", " ", " ", sqlDate2, OffreController_1.connectedOffre.getId(),SessionManager.getId(), " ",
                 " ", " ", " ", OffreController_1.connectedOffre.getTypeOffre().toString(), " ",OffreController_1.connectedOffre.getDomaine()
                ,OffreController_1.connectedOffre.getTitre(),OffreController_1.connectedOffre.getDateExpiration());

   Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Confirmer ");
      alert.setHeaderText("Confirmer");
      alert.setContentText(" ");
      
         Optional<ButtonType> option = alert.showAndWait();

      if (option.get() == null) {
       
      } else if (option.get() == ButtonType.OK) {
                 productService.AjouterCandidateure(ccc);
                 TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.SLIDE;
            tray.setAnimationType(type);
            tray.setTitle("Votre condidature est envoyé avec succées");
            tray.setMessage("Votre condidature est envoyé avec succées");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.millis(3000));
           // SMS smsTut =new SMS ();
            //smsTut.SendSMS("ameni55","12345789Ameni","bonjour","56434502","EAPI_URL/submission/send_sms/2/2.0");
            //smsTut.SendSMS("ameni55","12345789Ameni","hi","216434502", "EAPI_URL/submission/send_sms/2/2.0?username=ameni55&password=12345789Ameni&message=Hi&msisdn=+21656434502");
           // sendMail("boughanmiameni2019@gmail.com", "Votre Candidature a été envoyé avec succées", 
                   // "Votre Candidature dans le post"+ OffreController.connectedOffre.getTitre()+" a été envoyé avec succées");
                // 
             Parent page1 = FXMLLoader.load(getClass().getResource("Offre_1.fxml"));
              Scene scene = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
         
      
      } else if (option.get() == ButtonType.CANCEL) {
      
      } else {
         this.label.setText("-");
      }
      

          

        };

    }
    
   /* public void message() {

        

        
        String username = "m";
        String password = "moh20100";
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
                    InternetAddress.parse("ameni.boughanmi@esprit.tn"));
            message.setSubject("Test email");
            message.setText("Bonjour, ce message est un test ..." );
// Etape 3 : Envoyer le message
            Transport.send(message);
            System.out.println("Message_envoye");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }*/


/*
public void sendsms(String str, int body) {
		Twilio.init("AC1031db4af6517ccd09f33ef47e73e278", "cf4632728e95b7aedd1b953468ce63b4");
		try {
			com.twilio.rest.api.v2010.account.Message message = com.twilio.rest.api.v2010.account.Message
					.creator(new PhoneNumber("+21692207710"), // To number
							new PhoneNumber("+16066136706"), // From number
							"This is an Alert you send a bad word :" + body)
					.create();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
  */
  
 public static void sendMail(String recipient,String Subject,String Text) throws MessagingException {
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

        javax.mail.Transport.send(message);
        System.out.println("Message sent successfully");
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
    private void addimgcours(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG
                = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg
                = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");

        FileChooser.ExtensionFilter exFilterpdf
                = new FileChooser.ExtensionFilter("pdf files (*.pdf)", "*.pdf");

        FileChooser.ExtensionFilter exFilterPDF
                = new FileChooser.ExtensionFilter("PDF files (*.PDF)", "*.PDF");

        FileChooser.ExtensionFilter extFilterPNG
                = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng
                = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);
        File file = fileChooser.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
            imgajoutincours.setImage(image);
            imgajoutincours.setFitWidth(200);
            imgajoutincours.setFitHeight(200);
            imgajoutincours.scaleXProperty();
            imgajoutincours.scaleYProperty();
            imgajoutincours.setSmooth(true);
            imgajoutincours.setCache(true);
            FileInputStream fin = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fin.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            byte[] person_image = bos.toByteArray();
        } catch (IOException ex) {
            Logger.getLogger("ss");
        }
        imgpathttt.setText(file.getAbsolutePath());
    }

    @FXML
    private void prec(ActionEvent event) throws IOException {
           Parent page1 = FXMLLoader.load(getClass().getResource("Offre_1.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
        
        
    }

    @FXML
    private void Home(ActionEvent event) {
    }

    @FXML
    private void gotooffre(ActionEvent event) {
    }

    @FXML
    private void gotocontrats(ActionEvent event) {
    }

}
