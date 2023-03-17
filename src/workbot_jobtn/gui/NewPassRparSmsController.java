/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
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
import workbot_jobtn.utils.MyDB;

/**
 * FXML Controller class
 *
 * @author fnmoh
 */
public class NewPassRparSmsController implements Initializable {

    @FXML
    private TextField SmSReponseL;
    @FXML
    private TextField SmsNewPass;
    @FXML
    private Button ConfirmerPassparSMS;
    @FXML
    private TextField SmSMaiL;

    /**
     * Initializes the controller class.
     */
    public void RetourPassword(String ReponseSms, String SmSMaill) {
        SmSMaiL.setText(SmSMaill);
        SmSReponseL.setText(ReponseSms);
    }
    private Connection on;
    private Statement ste;

    public NewPassRparSmsController() {
        on = MyDB.getInstance().getConnection();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ConfirmerPassparSMSM(ActionEvent event) {
        updateRecord();
    }

    private void updateRecord() {
       System.out.println(SmSReponseL.getText());
        System.out.println(SmsNewPass.getText());
        String password=SmsNewPass.getText();
         Argon2 argon2 = Argon2Factory.create();
        password = argon2.hash(4, 65536, 1, password);
        String query = "UPDATE  utilisateur SET  mdp = '" + password + "' WHERE email = '" + SmSReponseL.getText() + "'  ";

        executeQuery(query);
        System.out.println(SmsNewPass.getText());

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("JobTn :: Information correct");
        alert.setHeaderText(null);
        alert.setContentText("ton motpasse changée avec succes");
        alert.showAndWait();
        try {
            Stage stage = (Stage) SmsNewPass.getScene().getWindow();
            stage.close();

            Parent root = FXMLLoader.load(getClass().getResource("M_Login.fxml"));
            Scene scene = new Scene(root, 840, 600);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //////////////////////////////////////////////////////////////

    private void executeQuery(String query) {
        Statement st;
        try {
            st = on.createStatement();
            st.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
