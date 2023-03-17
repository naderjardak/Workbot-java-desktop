/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import workbot_jobtn.entites.Offre;
import workbot_jobtn.entites.TypeOffre;
import workbot_jobtn.services.OffreService;
import workbot_jobtn.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author Exon
 */
public class OffreStageController implements Initializable {

    @FXML
    private HBox rootAjoutOffre;
    @FXML
    private VBox menu;
    @FXML
    private AnchorPane side_anker;
    @FXML
    private Button btnDashboard;
    @FXML
    private Button btnMenuOffre;
    @FXML
    private Button btnMenuEvent;
    @FXML
    private Button btnMenuEntretien;
    @FXML
    private Button fb;
    @FXML
    private Button fb1;
    @FXML
    private Pane s;
    @FXML
    private TextField inputsearch;
    @FXML
    private Button btnUser;
    @FXML
    private Button settings;
    @FXML
    private Pane slide1;
    @FXML
    private ComboBox combobox;
    @FXML
    private TextField inputTitre;
    @FXML
    private Button btn_retourStage;
    @FXML
    private Button btnSuivantStage;
    @FXML
    private TextField inputLieu;
    @FXML
    private TextField inputDuree;
    @FXML
    private ComboBox combobox1;
    @FXML
    private TextArea inputDescription;
    @FXML
    private DatePicker input_calendrier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("Présentiel", "Hybrid", "Teletravail");
        ObservableList<String> list2 = FXCollections.observableArrayList("PFE", "Stage d'été", "Alternance");
        input_calendrier.setValue(LocalDate.now());

        combobox.setItems(list);
        combobox1.setItems(list2);
    }

    @FXML
    private void onclick_dash(ActionEvent event) throws IOException {
        Alert Atc = new Alert(Alert.AlertType.CONFIRMATION);
        Atc.setHeaderText("Alert");
        Atc.setContentText("Votre avancement sera perdu");
        Optional<ButtonType> result = Atc.showAndWait();
        if (result.get() == ButtonType.OK) {
            Parent fXMLLoader = FXMLLoader.load(getClass().getResource("HomeSociete.fxml"));
            Scene stage = new Scene(fXMLLoader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } else {
            Atc.close();
        }
    }

    @FXML
    private void onClicked_menuOffre(ActionEvent event) throws IOException {
        Alert Atc = new Alert(Alert.AlertType.CONFIRMATION);
        Atc.setHeaderText("Alert");
        Atc.setContentText("Votre avancement sera perdu");
        Optional<ButtonType> result = Atc.showAndWait();
        if (result.get() == ButtonType.OK) {
            Parent fXMLLoader = FXMLLoader.load(getClass().getResource("Offre.fxml"));
            Scene stage = new Scene(fXMLLoader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } else {
            Atc.close();
        }
    }

    @FXML
    private void OnClicked_menuEvent(ActionEvent event) throws IOException {
        Alert Atc = new Alert(Alert.AlertType.CONFIRMATION);
        Atc.setHeaderText("Alert");
        Atc.setContentText("Votre avancement sera perdu");
        Optional<ButtonType> result = Atc.showAndWait();
        if (result.get() == ButtonType.OK) {
            Parent fXMLLoader = FXMLLoader.load(getClass().getResource("firstevent.fxml"));
            Scene stage = new Scene(fXMLLoader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } else {
            Atc.close();
        }
    }

    @FXML
    private void OnClicked_menuEntretiens(ActionEvent event) throws IOException {
        Alert Atc = new Alert(Alert.AlertType.CONFIRMATION);
        Atc.setHeaderText("Alert");
        Atc.setContentText("Votre avancement sera perdu");
        Optional<ButtonType> result = Atc.showAndWait();
        if (result.get() == ButtonType.OK) {
            Parent fXMLLoader = FXMLLoader.load(getClass().getResource("DisplayEntretiens.fxml"));
            Scene stage = new Scene(fXMLLoader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } else {
            Atc.close();
        }
    }

    @FXML
    private void Onclicked_fb(ActionEvent event) {
    }

    @FXML
    private void onKeyRealeased_showSearchPropositions(KeyEvent event) {
    }

    @FXML
    private void OnClick_UserIcon(ActionEvent event) {
    }

    @FXML
    private void OnClick_settings(ActionEvent event) {
    }

    @FXML
    private void OnclickRetour(ActionEvent event) throws IOException {

        Alert Atc = new Alert(Alert.AlertType.CONFIRMATION);
        Atc.setHeaderText("Alert");
        Atc.setContentText("Votre avancement sera perdu");
        Optional<ButtonType> result = Atc.showAndWait();
        if (result.get() == ButtonType.OK) {
            Parent fXMLLoader = FXMLLoader.load(getClass().getResource("AjouterOffre.fxml"));
            Scene stage = new Scene(fXMLLoader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
        } else {
            Atc.close();
        }
    }
    String ModeTravail;

    @FXML
    private void selectModeTravail(ActionEvent event) {
        String s = combobox.getSelectionModel().getSelectedItem().toString();
        this.ModeTravail = s;
    }

    @FXML
    private void selectTypeStage(ActionEvent event) {
    }
    OffreService offerservice = new OffreService();

    @FXML
    private void onclickSuivantStage(ActionEvent event) throws IOException {

        String titre = inputTitre.getText();
        String modeTravail = (String) combobox.getSelectionModel().getSelectedItem();
        String lieu = inputLieu.getText();
        String dateExp = input_calendrier.getValue().format(DateTimeFormatter.ISO_DATE);
        String duree = inputDuree.getText();
        String typeStage = (String) combobox1.getSelectionModel().getSelectedItem();
        String desc = inputDescription.getText();
        int id_soc = SessionManager.getId();
        String domaine = SessionManager.getDomaine();
        Offre o = new Offre(titre, duree, desc, domaine, dateExp, typeStage, modeTravail, lieu, id_soc, TypeOffre.Stage);

        if (titre.length() == 0 || combobox.getSelectionModel().getSelectedIndex() == -1 || dateExp.length() == 0 || duree.length() == 0 || combobox1.getSelectionModel().getSelectedIndex() == -1 || desc.length() == 0) {
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setHeaderText("Alert");
            error.setContentText("Veuillez remplir tous les champs");
            error.showAndWait();
            return;
        }
        if (modeTravail.equals("Présentiel") || modeTravail.equals("Hybrid")) {
            if (lieu.length() == 0) {
                Alert error = new Alert(Alert.AlertType.WARNING);
                error.setHeaderText("Alert");
                error.setContentText("En Présentiel ou Hybrid vous devez entrer le lieu!!");
                error.showAndWait();
                return;
            }
        }
        if (dateExp.compareTo(LocalDate.now().toString()) <= 0) {
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setHeaderText("Alert");
            error.setContentText("Date invalide");
            error.showAndWait();
            return;
        }

        List<Offre> listOffre = offerservice.readAll();
        for (Offre o1 : listOffre) {
            if ((o1.getTitre().equals(o.getTitre())) && (o1.getDescription().equals(o.getDescription()))) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setHeaderText("ERREUR");
                error.setContentText("Cette Offre existe deja");
                error.showAndWait();
                return;
            }
        }
        Alert Atc = new Alert(Alert.AlertType.CONFIRMATION);
        Atc.setHeaderText("Alert");
        Atc.setContentText("Verifier bien les informations saisi, vous ne pouvez pas revenir en arriére!! Cliquez OK pour passer");
        Optional<ButtonType> result = Atc.showAndWait();
        if (result.get() == ButtonType.OK) {

            try {
                offerservice.ajouter(o);

                FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("test.fxml"));
                Parent root = fXMLLoader.load();
                TestController testController = fXMLLoader.getController();
                Offre Of = offerservice.readLast();
                System.out.println(Of.getId());
                testController.setIdOffre(Of.getId());
                Scene stage = new Scene(root);
                testController.setChoice("Emploi");

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(stage);
                window.show();
            } catch (SQLException ex) {
                Alert error = new Alert(Alert.AlertType.WARNING);
                error.setHeaderText("Alert");
                error.setContentText("erreur");
                error.showAndWait();
            }

        } else {
            Atc.close();
        }
    }
}
