/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fnmoh
 */
public class M_SignupPasswordController implements Initializable {

    ObservableList<String> questionsecu = FXCollections.
            observableArrayList("Quel est votre animal préféré?", "Quel est votre meilleur joueur?", "Ou était votre premiére voiture?");
    @FXML
    private Button M_Suivant2;

    @FXML
    private ChoiceBox M_Questionsec;

    @FXML
    private TextField M_Reponse;

    @FXML
    private PasswordField M_PasswordSD;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        M_Questionsec.setValue("Quel est votre animal préféré?");
        M_Questionsec.setItems(questionsecu);
    }

    @FXML
    private TextField M_prenom2;

    @FXML
    private TextField M_mail2;

    @FXML
    private TextField M_nom2;

    @FXML
    private TextField M_rl2;

    public void RetouremailIttt(String roleee, String nomm, String prenommm, String emailll) {
        M_rl2.setText(roleee);
        M_nom2.setText(nomm);
        M_prenom2.setText(prenommm);
        M_mail2.setText(emailll);
    }

    private Parent root;

    @FXML
    void M_SuivantSD3Secu(ActionEvent event) {

        String question10 = (String) M_Questionsec.getValue();
        String role10 = M_rl2.getText();
        String nom10 = M_nom2.getText();
        String prenom10 = M_prenom2.getText();

        String mail10 = M_mail2.getText();
        String password10 = M_PasswordSD.getText();
        System.out.println(password10);
        String reponce10 = M_Reponse.getText();
        if (password10.isEmpty()
                | reponce10.isEmpty()
                | password10.isEmpty()
                | password10.length() < 8) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Job Tn :: Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Verifier fields !!");
            alert.showAndWait();
        } else {
            {

                try {
                    Stage stage = (Stage) M_Reponse.getScene().getWindow();
                    stage.close();

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("M_Signupetape4.fxml"));
                    root = loader.load();
                    /////////////tawa wala 3ana acces lel controller kif 3malna instance of controller
                    M_Signupetape4Controller M_Signupetape4Controller = loader.getController();
                    /////////tawa najmo n3ayto lel methode
                    M_Signupetape4Controller.RetourinformItc(role10, nom10, prenom10, mail10, password10, reponce10, question10);

                    Scene scene = new Scene(root, 840, 600);
                    stage.setScene(scene);
                    stage.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
