/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;



import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import workbot_jobtn.utils.MyDB;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.Scanner;
import org.mindrot.jbcrypt.BCrypt;


/**
 * FXML Controller class
 *
 * @author fnmoh
 */
public class Signupetape5ConController implements Initializable {

    @FXML
    private Button M_finaliser;
    @FXML
    private Button M_Back;
    @FXML
    private TextField Rec_Role;
    @FXML
    private TextField Rec_Nom;
    @FXML
    private TextField Rec_Prenom;
    @FXML
    private TextField Rec_Email;
    @FXML
    private TextField Rec_Password;
    @FXML
    private TextField Rec_Questionsec;
    @FXML
    private TextField Rec_reponse;
    @FXML
    private TextField Rec_domaine;
    @FXML
    private TextField Rec_adresse;
    @FXML
    private TextField Rec_numero;
    @FXML
    private TextField Rec_datenaisss;
    private String rolee;
    @FXML
    private TextField checkcodee;
    @FXML
    private Button M_finaliser1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    private Connection on;
    private Statement ste;

    public Signupetape5ConController() {
        on = MyDB.getInstance().getConnection();
    }

    @FXML
    private void M_finaliser(ActionEvent event) {

        message();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Job TN:: Succes");
        alert.setHeaderText(null);
        alert.setContentText("Check votre email ");
        alert.showAndWait();
      //  String passwordV1 = Rec_Password.getText();
      //   String mpasswordV1 = BCrypt.with(BCrypt.Version.VERSION_2Y).hashToString(6, passwordV1.toCharArray());
      //   System.out.println(mpasswordV1) ;
        
      //  String passwordV1 = Rec_Password.getText();
      //   String mpasswordV1 = BCrypt.hashpw(passwordV1, BCrypt.gensalt());
     // mpasswordV1 = "$2y$13" + mpasswordV1.substring(6);
      // String mdpBcrypt = BCrypt.hashpw(passwordV1, BCrypt.gensalt());
        //  Argon2 argon2 = Argon2Factory.create();
       // passwordV1 = argon2.hash(4, 65536, 1, passwordV1);
    // System.out.println(mpasswordV1) ;

    }

    @FXML
    private void M_Back(ActionEvent event) {
        try {
            Stage stage = (Stage) Rec_numero.getScene().getWindow();
            stage.close();

            Parent root = FXMLLoader.load(getClass().getResource("M_Login.fxml"));
            Scene scene = new Scene(root, 840, 600);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Retourintous(String role100, String nom100, String prenom100, String mail100, String password100, String reponce100, String question100, String domaine100, String adresse100, String numero100) {

        Rec_Role.setText(role100);
        Rec_Nom.setText(nom100);
        Rec_Prenom.setText(prenom100);

        Rec_Email.setText(mail100);
        Rec_Password.setText(password100);
        System.out.println(password100);
        Rec_Questionsec.setText(reponce100);
        Rec_reponse.setText(question100);
        Rec_domaine.setText(domaine100);
        Rec_adresse.setText(adresse100);
        Rec_numero.setText(numero100);

    }

    int randomCode;

    public void message() {

        Random rand = new Random();
        randomCode = rand.nextInt(999999);
        System.out.println(randomCode);

        String nom10000 = Rec_Email.getText();
        String username = "mohsen.fennira@esprit.tn";
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
                    InternetAddress.parse(nom10000));
            message.setSubject("Test email");
            message.setText("Bonjour, ce message est un test ..." + randomCode);
// Etape 3 : Envoyer le message
            Transport.send(message);
            System.out.println("Message_envoye");
        } catch ( MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    //////////////////////////////
    private void insertuser1() {
        /*
                String roleV1;
    String prenomV1;
    String mailV1;
    String nomV1;
        String passwordV1;
    String quesecV1;
    String responseV1;
    String domaineV1;
    String adresseV1;
    String numeroV1;
            roleV1=  Rec_Role.getText();
              prenomV1=Rec_Prenom.getText();
              mailV1=  Rec_Email.getText();
              nomV1= Rec_Nom.getText();
              passwordV1=  Rec_Password.getText();
              quesecV1= Rec_Questionsec.getText();
              responseV1=  Rec_reponse.getText();
              domaineV1=Rec_domaine.getText();
               adresseV1=  Rec_adresse.getText();
              numeroV1= Rec_numero.getText();
              
              
              
              String query = "INSERT INTO user (role,nom,prenom,email) VALUES ('" + roleV1 + "','" + nomV1 + "','" + prenomV1 + "','" + mailV1 + "')";
        
        executeQuery(query);
         */
    }

    /*    Encryptor encryptor = new Encryptor();*/

    private void insertuser() {

        String roleV1;
        String prenomV1;
        String mailV1;
        String nomV1;
        String passwordV1;
        String quesecV1;
        String responseV1;
        String domaineV1;
        String adresseV1;
        String numeroV1;
        roleV1 = Rec_Role.getText();
        prenomV1 = Rec_Prenom.getText();
        mailV1 = Rec_Email.getText();
        nomV1 = Rec_Nom.getText();
        passwordV1 = Rec_Password.getText();
        quesecV1 = Rec_Questionsec.getText();
        responseV1 = Rec_reponse.getText();
        domaineV1 = Rec_domaine.getText();
        adresseV1 = Rec_adresse.getText();
        numeroV1 = Rec_numero.getText();
        String mdpsymfony=Rec_Password.getText();
        /*char[] chars = passwordV1.toCharArray();

        for (char c : chars) {
            c += 5;

            System.out.println(c);
        }*/
        
       // Argon2 argon2 = Argon2Factory.create();
      //  passwordV1 = argon2.hash(4, 65536, 1, passwordV1);
        
   //  String i= BCrypt.hashpw(passwordV1,BCrypt.gensalt()t);
       String i = BCrypt.hashpw(passwordV1, BCrypt.gensalt());
//       String mpasswordV1 = BCrypt.with(BCrypt.Version.VERSION_2Y).hashToString(6, passwordV1.toCharArray());
if(  !(roleV1.equals("candidat"))){
    String roles ="[\"ROLE_s\"]";


        //mpasswordV1 = "$2y$13" + mpasswordV1.substring(6);
String query = "INSERT INTO utilisateur (role,nom,prenom,email,mdp,questionSecu,reponseSecu,domaine,adresse,tel,mdpsymfony,roles) VALUES ('" + roleV1 + "','" + nomV1 + "','" + prenomV1 + "','" + mailV1 + "','" + i + "','" + quesecV1 + "','" + responseV1 + "','" + domaineV1 + "','" + adresseV1 + "','" + numeroV1 + "','" + mdpsymfony + "','" + roles + "')";

        executeQuery(query);
}
else {

     String roles ="[\"ROLE_c\"]";


        //mpasswordV1 = "$2y$13" + mpasswordV1.substring(6);
String query = "INSERT INTO utilisateur (role,nom,prenom,email,mdp,questionSecu,reponseSecu,domaine,adresse,tel,mdpsymfony,roles) VALUES ('" + roleV1 + "','" + nomV1 + "','" + prenomV1 + "','" + mailV1 + "','" + i + "','" + quesecV1 + "','" + responseV1 + "','" + domaineV1 + "','" + adresseV1 + "','" + numeroV1 + "','" + mdpsymfony + "','" + roles + "')";

        executeQuery(query);


}
    
    }

    private void insertRoleee(String rolee) {

    }

    ///////////////////
    private void executeQuery(String query) {
        Statement st;
        try {
            st = on.createStatement();
            st.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void M_checKcode(ActionEvent event) {

        if (Integer.valueOf(checkcodee.getText()) == randomCode) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Job TN:: Succes");
            alert.setHeaderText(null);
            alert.setContentText("votre account est verifier");
            alert.showAndWait();
            insertuser();
            try {
                Stage stage = (Stage) Rec_numero.getScene().getWindow();
                stage.close();

                Parent root = FXMLLoader.load(getClass().getResource("M_Login.fxml"));
                Scene scene = new Scene(root, 840, 600);

                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (Integer.valueOf(checkcodee.getText()) != randomCode) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Job TN:: Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Verifier votre code  ");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Job TN:: Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Verifier votre code  ");
            alert.showAndWait();
        }

    }

}