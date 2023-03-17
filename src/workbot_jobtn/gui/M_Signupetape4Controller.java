/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fnmoh
 */
public class M_Signupetape4Controller implements Initializable {

    @FXML
    private Button M_Suivanetape4;
    @FXML
    private TextField M_DomaineSD;
    @FXML
    private TextField M_NTLF;
    @FXML
    private TextField M_adresseSD;
    @FXML
    private DatePicker M_DateNaissa;
    @FXML
    private TextField role3;
    @FXML
    private TextField nom3;
    @FXML
    private TextField prenom3;
    @FXML
    private TextField email3;
    @FXML
    private TextField password3;
    @FXML
    private TextField questionsec3;
    @FXML
    private TextField eponse3;

    public void RetourinformItc(String role10, String nom10, String prenom10, String mail10, String password10, String reponce10, String question10) {

        role3.setText(role10);
        nom3.setText(nom10);
        prenom3.setText(prenom10);

        email3.setText(mail10);
        password3.setText(password10);
        questionsec3.setText(reponce10);
        eponse3.setText(question10);

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private Parent root;

    @FXML
    private void M_Suivanetape4(ActionEvent event) {

        String question100 = (String) questionsec3.getText();
        String role100 = role3.getText();
        String nom100 = nom3.getText();
        String prenom100 = prenom3.getText();
        String mail100 = email3.getText();
        String password100 = password3.getText();

        String reponce100 = eponse3.getText();
        String domaine100 = M_DomaineSD.getText();
        String adresse100 = M_adresseSD.getText();

        String numero100 = M_NTLF.getText();

        if (domaine100.isEmpty()
                | adresse100.isEmpty()
                | reponce100.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Job Tn :: Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Verifier fields !!");
            alert.showAndWait();
        } else {

            try {
                Stage stage = (Stage) M_adresseSD.getScene().getWindow();
                stage.close();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("Signupetape5Con.fxml"));
                root = loader.load();
                /////////////tawa wala 3ana acces lel controller kif 3malna instance of controller
                /*  Signupetape5ConController Signupetape5ConController = loader.getController();*/

                Signupetape5ConController Signupetape5ConController = loader.getController();
                /////////tawa najmo n3ayto lel methode
                Signupetape5ConController.Retourintous(role100, nom100, prenom100, mail100, password100, reponce100, question100, domaine100, adresse100, numero100);

                Scene scene = new Scene(root, 840, 600);

                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
