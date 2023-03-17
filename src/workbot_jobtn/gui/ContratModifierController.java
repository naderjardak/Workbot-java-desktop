/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbot_jobtn.gui;

import workbot_jobtn.services.ContratService;
import workbot_jobtn.entites.Contrat;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class ContratModifierController implements Initializable {

    @FXML
    private DatePicker datedebut;
    @FXML
    private DatePicker debutfin;
    @FXML
    private ComboBox<String> inputtypecontrat;
    @FXML
    private TextField inputsalaire;
    @FXML
    private TextField inputlien;
    @FXML
    private Button ajouter;
    @FXML
    private Label labelid;
    @FXML
    private Hyperlink prec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inputtypecontrat.getItems().addAll("Stage", "Alternance", "CDD", "CDI");
        inputtypecontrat.setValue(ContratListController.connectedContrat.getTypeContrat());
        inputsalaire.setText(ContratListController.connectedContrat.getSalaire());
        inputlien.setText(ContratListController.connectedContrat.getLien());
        labelid.setText(Integer.toString(ContratListController.connectedContrat.getId()));
        java.sql.Date r = new java.sql.Date(ContratListController.connectedContrat.getDateDebut().getTime());
        LocalDate date = r.toLocalDate();

        java.sql.Date r2 = new java.sql.Date(ContratListController.connectedContrat.getDateFin().getTime());
        LocalDate date2 = r2.toLocalDate();
        datedebut.setValue(date);
        debutfin.setValue(date);

    }

    @FXML
    private void insert(ActionEvent event) throws IOException, SQLException, NoSuchAlgorithmException {
        ContratService productService = new ContratService();

        if (inputsalaire.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Veuillez saisir tous les champs ");
            a.setHeaderText(null);
            a.showAndWait();
        } else {

            // Date Ajourd'hui
            Date date = new Date(System.currentTimeMillis());
            java.sql.Date sqlDate2 = new java.sql.Date(date.getTime());

            //date debut 
            java.util.Date date2 = java.util.Date.from(this.datedebut.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDatedebut = new java.sql.Date(date2.getTime());

            //date fin
            java.util.Date date3 = java.util.Date.from(this.debutfin.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date sqlDateFin = new java.sql.Date(date3.getTime());

            Contrat ccc = new Contrat(Integer.parseInt(labelid.getText()), inputtypecontrat.getValue(), sqlDatedebut, inputsalaire.getText(),
                    sqlDateFin, inputlien.getText(), 0, sqlDate2
            );

            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("Confirmer");
            a.setHeaderText(null);
            a.showAndWait();
            productService.modifierContrat(ccc);

            Parent page1 = FXMLLoader.load(getClass().getResource("ContratList.fxml"));
            Scene scene = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        };

    }

    @FXML
    private void prec(ActionEvent event) throws IOException {
           Parent page1 = FXMLLoader.load(getClass().getResource("ContratList.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
        
    }

}
