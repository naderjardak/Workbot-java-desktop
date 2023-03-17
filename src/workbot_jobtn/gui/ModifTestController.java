/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import workbot_jobtn.entites.Offre;
import workbot_jobtn.entites.Test;
import workbot_jobtn.services.OffreService;
import workbot_jobtn.services.TestService;
import workbot_jobtn.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author Exon
 */
public class ModifTestController implements Initializable {

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
    private Pane root;
    @FXML
    private Pane slide1;
    @FXML
    private Button btnSuivantStage;
    @FXML
    private Label choice;
    @FXML
    private Button btnFile;
    @FXML
    private TextField inputUrl;
    @FXML
    private Button supprimerTest;
    @FXML
    private Button btnRetour;
    @FXML
    private Label changeme;
    @FXML
    private Label id_offre;
    int idtest;
    OffreService offreService = new OffreService();
    @FXML
    private Pane root12;

    void setId_offre(Integer id) {
        System.out.println("first");
        Offre O1 = offreService.selectById(id);
        System.out.println("second");
        id_offre.setText(String.valueOf(O1.getId()));
        idtest = O1.getId_test();
        if (O1.getId_test() == 0) {
            changeme.setText("Ajoutez un test a votre offre! Ca vous permet de faire une préselection des candidats!");

        } else {
            changeme.setText("Votre Offre contient deja un test Modifie le en ajoutant un test ou vous pouvez le supprimer simplement");
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onclick_dash(ActionEvent event) throws IOException {

        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("HomeSociete.fxml"));
        Scene stage = new Scene(fXMLLoader);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }

    @FXML
    private void onClicked_menuOffre(ActionEvent event) throws IOException {

        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("Offre.fxml"));
        Scene stage = new Scene(fXMLLoader);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
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
        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("DisplayEntretiens.fxml"));
        Scene stage = new Scene(fXMLLoader);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
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

    TestService testservice = new TestService();

    @FXML
    private void onclickSuivantStage(ActionEvent event) throws IOException {

        if (SelectedFile != null && inputUrl.getText().length() == 0) {
            //choice n'existe plus ,il afut l'enlever et remplacer par methode crud
            path = SelectedFile.getAbsolutePath();
        } else if (inputUrl.getText().length() != 0 && SelectedFile == null) {
            path = inputUrl.getText();
        } else if (inputUrl.getText().length() != 0 && SelectedFile != null) {
            Alert Atc = new Alert(Alert.AlertType.WARNING);
            Atc.setHeaderText("Alert");
            Atc.setContentText("vous ne pouvez pas deposer un ficher et mettre un url en meme temps");
            Atc.showAndWait();
            return;
        } else {
            Alert Atc = new Alert(Alert.AlertType.WARNING);
            Atc.setHeaderText("Alert");
            Atc.setContentText("Vous devez remplir un champ");
            Atc.showAndWait();
            return;
        }
        try {
            Offre O1 = offreService.selectById(Integer.parseInt(id_offre.getText()));
            System.out.println(id_offre.getText());
            System.out.println(O1.getTitre());
            System.out.println("modif test " + O1.getId_soc());

            Test t = new Test(O1.getTitre(), path);
            t.setId_soc(SessionManager.getId());
            testservice.ajouter(t);
            O1.setId_test(testservice.selectLast().getId());
            System.out.println(O1.getId_soc());
            offreService.update(O1);
             Thread th = new Thread(() -> {
            String ACCOUNT_SID = "AC915cfd330fe7a8b2cacdd031af356e39";
            String AUTH_TOKEN = "7f567885b19a9f20b7ceada26b115be3";
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            String titre = O1.getTitre();
            //num Mohsen : +21626662264
            Message message = Message.creator(new PhoneNumber("+21626662264"),
                    new PhoneNumber("+13854062174"),
                    "Vous avez modifier avec succes le test de l'offre : " + titre).create();
                 });
        th.setDaemon(true);
        th.start();
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("SuccesTest.fxml"));
            Parent root1 = fxml.load();
            Scene scene = btnSuivantStage.getScene();
            root1.translateYProperty().set(scene.getHeight());
            root12.getChildren().add(root1);

            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root1.translateYProperty(), 0, Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
            timeline.getKeyFrames().add(kf);
            timeline.setOnFinished(event1 -> root12.getChildren().remove(slide1));
            timeline.play();
        } catch (SQLException ex) {
            Logger.getLogger(AjouterTestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    String path = "";
    File SelectedFile;

    @FXML
    private void Onclic_btnFile(ActionEvent event) {
        FileChooser fc = new FileChooser();
        SelectedFile = fc.showOpenDialog(null);
        if (SelectedFile != null) {
            path = SelectedFile.getAbsolutePath();

        }
    }

    @FXML
    private void OnclickSuppTest(ActionEvent event) throws SQLException, IOException {
        if (idtest == 0) {
            Alert Atc = new Alert(Alert.AlertType.ERROR);
            Atc.setHeaderText("Erreur");
            Atc.setContentText("Aucun test a supprimer");
            Atc.showAndWait();
            return;
        } else {
            Alert Atc = new Alert(Alert.AlertType.CONFIRMATION);
            Atc.setHeaderText("Confirmation");
            Atc.setContentText("êtes vous sur de vouloir supprimer le test?");
            Optional<ButtonType> result = Atc.showAndWait();
            if (result.get() == ButtonType.OK) {
                Offre O1 = offreService.selectById(Integer.parseInt(id_offre.getText()));
                System.out.println(O1.getId_test());
                Test t = testservice.selectById(O1.getId_test());
                System.out.println(t.getId());
                if (testservice.delete(t)) {
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setHeaderText("Succes");
                    a.setContentText("Votre Offre ne contient plus de test");
                    a.showAndWait();
                    Parent fXMLLoader = FXMLLoader.load(getClass().getResource("Offre.fxml"));
                    Scene stage = new Scene(fXMLLoader);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(stage);
                    window.show();
                }

            } else {
                Atc.close();
            }

        }
    }

    @FXML
    private void onclickRetour(ActionEvent event) throws IOException {

        Parent fXMLLoader = FXMLLoader.load(getClass().getResource("Offre.fxml"));
        Scene stage = new Scene(fXMLLoader);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(stage);
        window.show();
    }

}
