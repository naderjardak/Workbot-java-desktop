/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbot_jobtn.gui;

import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import workbot_jobtn.utils.MyDB;

/**
 *
 * @author fnmoh
 */
public class M_SignupUser implements Initializable {

    ObservableList<String> choixBoxRole = FXCollections.
            observableArrayList("candidat", "sociéte");
    @FXML
    private ChoiceBox M_choixBoxRole;
    @FXML
    private Button M_Suiv1SD;
    @FXML
    private Button M_Suivant;
    @FXML
    private TextField M_PrenomSD;
    @FXML
    private TextField M_MailSD;
    @FXML
    private TextField M_NomSD;
    private String rolee;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        M_choixBoxRole.setValue("sociéte");
        M_choixBoxRole.setItems(choixBoxRole);
        ro="sociéte";
    }
    ///////////////
    private Connection on;
    private Statement ste;

    public M_SignupUser() {
        on = MyDB.getInstance().getConnection();
    }
    /////////////////////////////////////////

    //////////////
    @FXML
    private Parent root;
static public String ro;
    public void M_Suiv1S(ActionEvent event) {
        ///// username bech ya5o el valeur mt3 role bech najmo n3adouh lel controller e thani fel textfluid
        String username = (String) M_choixBoxRole.getValue();
        ro=(String) M_choixBoxRole.getValue();
        if (event.getSource() == M_Suiv1SD) {

        }
        /*
         
          
         */
        try {
            Stage stage = (Stage) M_choixBoxRole.getScene().getWindow();
            stage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("M_signupEmailnom.fxml"));
            root = loader.load();
            /////////////tawa wala 3ana acces lel controller kif 3malna instance of controller
            M_signupEmailnomController M_signupEmailnomController = loader.getController();
            /////////tawa najmo n3ayto lel methode
            System.out.println(username);
            M_signupEmailnomController.RetourRoleItcc(username);

            Scene scene = new Scene(root, 840, 600);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /////////////////

    //////////////////////
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
/////////////////////////

///////////

