/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workbot_jobtn.gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import workbot_jobtn.entites.User;
import workbot_jobtn.utils.MyDB;

/**
 *
 * @author fnmoh
 */
public class RestoreAccountParSmsController implements Initializable {

    private Connection on;
    private Statement ste;

    public RestoreAccountParSmsController() {

        on = MyDB.getInstance().getConnection();
    }

    ObservableList<String> questionsecu = FXCollections.
            observableArrayList("Quel est votre animal préféré?", "Quel est votre meilleur joueur?", "Ou était votre premiére voiture?");
    @FXML
    private TextField Sms_Email_RPASS;
    @FXML
    private ChoiceBox<String> Sms_QS_RPASS;
    @FXML
    private TextField Reponse_Email_RPASS;
    @FXML
    private Button Suivant_RPASS;

    @FXML
    private void M_validerMethodeSmsNP(ActionEvent event) {

        login();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Sms_QS_RPASS.setValue("Quel est votre animal préféré?");
        Sms_QS_RPASS.setItems(questionsecu);

    }

    private Parent root;

    public void login() {

        String query2 = "select * from utilisateur where email=?  and reponseSecu=?";
        on = MyDB.getInstance().getConnection();
        try {
            PreparedStatement smt = on.prepareStatement(query2);

            smt.setString(1, Sms_Email_RPASS.getText());
            smt.setString(2, Reponse_Email_RPASS.getText());
            ResultSet rs = smt.executeQuery();
            User p;
            if (rs.next()) {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("JobTn :: Information correct");
                alert.setHeaderText(null);
                alert.setContentText("On peut changer ton password");
                alert.showAndWait();
                try {
                    Stage stage = (Stage) Sms_QS_RPASS.getScene().getWindow();
                    stage.close();

                    String SmSMaill = Sms_Email_RPASS.getText();
                    String ReponseSms = Reponse_Email_RPASS.getText();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("NewPassRparSms.fxml"));
                    root = loader.load();
                    NewPassRparSmsController NewPassRparSmsController = loader.getController();
                    NewPassRparSmsController.RetourPassword(Sms_Email_RPASS.getText(), Reponse_Email_RPASS.getText());

                    Scene scene = new Scene(root, 840, 600);

                    stage.setScene(scene);
                    stage.show();

                    /////////tawa najmo n3ayto lel methode
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("JobTn :: Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Wrong  !!");
                alert.showAndWait();
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
