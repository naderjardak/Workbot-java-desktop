/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import workbot_jobtn.utils.MyDB;
/**
 * FXML Controller class
 *
 * @author fnmoh
 */
public class M_signupEmailnomController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        System.out.println(M_SignupUser.ro);
        if(M_SignupUser.ro.equals("sociéte"))
        {
            panne.setVisible(true);
            
        }
        
    }
    static void RetourRoleItc(String username) {
    }

    ///////////////
    @FXML
    private TextField M_rolc;
    @FXML
    private TextField M_rolle;
    @FXML
    private Label namelabel;
    @FXML
    private AnchorPane panne;

    public void RetourRoleItcc(String username) {
        M_rolc.setText(username);
    }

    @FXML
    private TextField M_pomSD1;
    @FXML
    private TextField M_mailmSD2;

    private Connection on;
    private Statement ste;

    public M_signupEmailnomController() {
        on = MyDB.getInstance().getConnection();
    }
    /////////////////////////////////////////

    @FXML
    private Button M_Suivant;

    @FXML
    private TextField M_NomSD;

    /**
     * Initializes the controller class.
     */
    
    private Parent root;

    @FXML
    public void M_SuivantSD(ActionEvent event) {
        boolean dataValid = true;
        String prenommm=M_pomSD1.getText();
        String roleee = M_rolc.getText();
        if(M_rolc.getText().equals("sociéte"))
        {
         prenommm =" ";   
        }
        String nomm = M_NomSD.getText();
         
        String emailll = M_mailmSD2.getText();

        if (nomm.isEmpty()
                | nomm.isEmpty()
                | prenommm.isEmpty()
                | emailll.isEmpty()
                | emailll.length() < 8) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Job Tn :: Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Verifier fields !!");
            alert.showAndWait();
        } else {
            if (isValid(emailll)) {

                try {
                    Stage stage = (Stage) M_NomSD.getScene().getWindow();
                    stage.close();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("M_SignupPassword.fxml"));
                    root = loader.load();

                    /////////////tawa wala 3ana acces lel controller kif 3malna instance of controller
                    M_SignupPasswordController M_SignupPasswordController = loader.getController();
                    /////////tawa najmo n3ayto lel methode
                    M_SignupPasswordController.RetouremailIttt(roleee, nomm, prenommm, emailll);
                    Scene scene = new Scene(root, 840, 600);

                    stage.setScene(scene);
                    stage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void insertRoleee() {

        String nomm = M_NomSD.getText();
        String prenommm = M_pomSD1.getText();
        String emailll = M_mailmSD2.getText();

    }
    /////////////////mail 

    String emailll = null;

    @FXML
    private void checkFIELD(KeyEvent event) {
        emailll = M_mailmSD2.getText();
        if (isValid(emailll)) {
            M_mailmSD2.setStyle("-fx-border-color:blue");
        } else {
            M_mailmSD2.setStyle("-fx-border-color:red");
        }

    }

    private boolean isValid(String emailll) {
        String M_mailm = "[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9._]+([.][a-zA-Z0-9]+)+";
        Pattern pat = Pattern.compile(M_mailm);
        if (M_mailmSD2 == null) {
            return false;
        }
        return pat.matcher(emailll).matches();
    }
}
