/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import workbot_jobtn.entites.Offre;
import workbot_jobtn.services.OffreService;
import workbot_jobtn.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author Exon
 */
public class ModifierOffreEmploiController implements Initializable {

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
    private TextField salaire;
    @FXML
    private ComboBox combobox1;
    @FXML
    private TextArea inputDescription;
    @FXML
    private DatePicker input_calendrier;
    @FXML
    private Label id_pass;

    String titre1;
    String desc;
    String date;
    String mdTravail;
    String typeC;
    String salary;
    String lieu1;

    OffreService offreService = new OffreService();
    @FXML
    private Pane root;

    public void setId(int id) {
        //   id=idO;

        Offre O1 = offreService.selectById(id);
        inputTitre.setText(O1.getTitre());
        titre1 = inputTitre.getText();
        inputLieu.setText(O1.getLieu());
        inputDescription.setText(O1.getDescription());
        desc = inputDescription.getText();

        input_calendrier.setValue(LocalDate.parse(O1.getDateExpiration()));
        date = input_calendrier.getValue().format(DateTimeFormatter.ISO_DATE);
        salaire.setText(O1.getSalaire());
        salary = salaire.getText();
        combobox.setValue(O1.getModeTravail());
        mdTravail = (String) combobox.getSelectionModel().getSelectedItem();
        combobox1.setValue(O1.getTypeContrat());
        typeC = (String) combobox1.getSelectionModel().getSelectedItem();
        lieu1 = inputLieu.getText();
        id_pass.setText(String.valueOf(id));

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("Présentiel", "Hybrid", "Teletravail");
        ObservableList<String> list2 = FXCollections.observableArrayList("CDI", "CDD", "CIVP");

        combobox.setItems(list);
        combobox1.setItems(list2);
        // TODO
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
          Parent fXMLLoader = FXMLLoader.load(getClass().getResource("firstevent.fxml"));
            Scene stage = new Scene(fXMLLoader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(stage);
            window.show();
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
    private void selectModeTravail(ActionEvent event) {
    }

    @FXML
    private void OnclickRetour(ActionEvent event) throws IOException {
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
    private void onclickSuivantStage(ActionEvent event) {

        String titre = inputTitre.getText();

        String modeTravail = (String) combobox.getSelectionModel().getSelectedItem();
        String lieu = inputLieu.getText();
        String dateExp = input_calendrier.getValue().format(DateTimeFormatter.ISO_DATE);
        String salary1 = salaire.getText();
        String typeContrat = (String) combobox1.getSelectionModel().getSelectedItem();
        String desc2 = inputDescription.getText();
        int id_soc = SessionManager.getId();
        String domaine = SessionManager.getDomaine();

        if (titre1.equals(titre) && desc.equals(desc2) && dateExp.equals(date)
                && salary.equals(salary1) && mdTravail.equals(modeTravail)
                && typeC.equals(typeContrat) && lieu1.equals(lieu)) {
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setHeaderText("Alert");
            error.setContentText("Vous n'avez rien changer");
            error.showAndWait();
            return;
        }

        if (titre.length() == 0 || combobox.getSelectionModel().getSelectedIndex() == -1 || dateExp.length() == 0 || salary.length() == 0 || combobox1.getSelectionModel().getSelectedIndex() == -1 || desc.length() == 0) {
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

        Alert Atc = new Alert(Alert.AlertType.CONFIRMATION);
        Atc.setHeaderText("Alert");
        Atc.setContentText("Verifier bien les informations saisi, vous ne pouvez pas revenir en arriére!! Cliquez OK pour passer");
        Optional<ButtonType> result = Atc.showAndWait();
        if (result.get() == ButtonType.OK) {

            try {
                Offre o = new Offre(Integer.parseInt(id_pass.getText()), titre, salary1, desc2, domaine, dateExp, lieu, modeTravail, typeContrat, "Emploi");

                if (offreService.updateEmploi(o)) {
                    FXMLLoader fxml = new FXMLLoader(getClass().getResource("SuccesModif.fxml"));
                    Parent root1 = fxml.load();

                    Scene scene = btnSuivantStage.getScene();

                    root1.translateYProperty().set(scene.getHeight());
                    //root1.translateXProperty().set(scene.getWidth());

                    root.getChildren().add(root1);

                    Timeline timeline = new Timeline();
                    KeyValue kv = new KeyValue(root1.translateYProperty(), 0, Interpolator.EASE_BOTH);
                    KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
                    timeline.getKeyFrames().add(kf);

                    timeline.setOnFinished(event1 -> root.getChildren().remove(slide1));
                    timeline.play();
                }

            } catch (Exception e) {
            }
        } else {
            Atc.close();
        }
    }

    @FXML
    private void selectTypeStage(ActionEvent event) {
    }

}
