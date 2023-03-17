/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.URL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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

import workbot_jobtn.utils.MyDB;

/**
 * FXML Controller class
 *
 * @author fnmoh
 */
public class SmsmethodeRestoreController implements Initializable {

    int randomCode;
    @FXML
    private TextField SmSReponseL;
    @FXML
    private TextField SmSMaiL;
    @FXML
    private TextField SmsNewPass;
    @FXML
    private Button ConfirmerPassparSMS;
    @FXML
    private TextField SmsNewPass1;
    @FXML
    private Button SendMail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    private Connection on;
    private Statement ste;

    public SmsmethodeRestoreController() {
        on = MyDB.getInstance().getConnection();
    }
    ResultSet rs = null;
    PreparedStatement pst = null;

    private Parent root;

    @FXML

    private void ConfirmerSms(ActionEvent event) {

        if (Integer.valueOf(SmsNewPass1.getText()) == randomCode) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Job TN:: Succes");
            alert.setHeaderText(null);
            alert.setContentText("on peut changer ton password");
            alert.showAndWait();

            try {
                String ReponseSms = SmsNewPass.getText();
                Stage stage = (Stage) SmsNewPass.getScene().getWindow();
                stage.close();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("passwordapiSms_M.fxml"));
                root = loader.load();
                PasswordapiSmsMController passwordapiSms_MController = loader.getController();
                passwordapiSms_MController.RetourPassword(ReponseSms);

                Scene scene = new Scene(root, 840, 600);

                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Job TN:: Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Verifier votre numero ");
            alert.showAndWait();
        }
    }

    @FXML
    private void SendMail(ActionEvent event) {

        if (SmsNewPass.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Job TN:: Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Verifier votre numero ");
            alert.showAndWait();
        } else {
            String ACCOUNT_SID = "AC915cfd330fe7a8b2cacdd031af356e39";
            String AUTH_TOKEN = "7f567885b19a9f20b7ceada26b115be3";
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            String getf = SmsNewPass.getText();
            Random rand = new Random();
            randomCode = rand.nextInt(999999);
            System.out.println(randomCode);
Thread th = new Thread(() -> {
            Message message = Message.creator(new PhoneNumber(getf),
                    new PhoneNumber("(+13854062174"),
                    "Your reset code is " + randomCode).create();
            System.out.println(message.getSid());
                    });
        th.setDaemon(true);
        th.start();  
        }

    }

    private void executeQuery(String query) {
        Statement st;
        try {
            st = on.createStatement();
            st.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    /////////////////////////Sms

}
