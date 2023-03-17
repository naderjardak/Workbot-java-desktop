/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import workbot_jobtn.entites.DTOCandidature_Offre;
import workbot_jobtn.entites.Entretien;
import workbot_jobtn.services.EntretienService;
import workbot_jobtn.services.OffreService;
import workbot_jobtn.utils.Mail;
import static workbot_jobtn.gui.CandOffreController.dto;


/**
 * FXML Controller class
 *
 * @author Exon
 */
public class EntretienController implements Initializable {

    @FXML
    private DatePicker dateMeet;
    @FXML
    private TextField lienMeet;
    @FXML
    private Button envoyerMail;
    @FXML
    private Spinner<Integer> heureMeet;

    int id_passed;

    OffreService OffreService = new OffreService();
    private int id_cand_passed;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpinnerValueFactory<Integer> valuefactory
                = new SpinnerValueFactory.IntegerSpinnerValueFactory(00, 23, 00, 01);

        valuefactory.setValue(8);
        heureMeet.setValueFactory(valuefactory);
        dateMeet.setValue(LocalDate.now());

    }

    @FXML
    private void onclickEnvoyerMail(ActionEvent event) throws SQLException {
        if (dateMeet.getValue().format(DateTimeFormatter.ISO_DATE).isEmpty() || lienMeet.getText().isBlank() || heureMeet.getValue() == null) {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setHeaderText("ERREUR");
            alert1.setContentText("Merci de remplir tous les champs");
            alert1.showAndWait();
            return;
        }
        if (dateMeet.getValue().toString().compareTo(LocalDate.now().toString()) <= 0) {
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setHeaderText("Alert");
            error.setContentText("Date invalide");
            error.showAndWait();
            return;

        }
        Integer heure = heureMeet.getValue();
        String date = dateMeet.getValue().format(DateTimeFormatter.ISO_DATE);
        String meet = lienMeet.getText();
        int idOffre = id_passed;
        int idCand1 = id_cand_passed;
        System.out.println("idoff :" + idOffre);
        System.out.println("idcand " + idCand1);
        DTOCandidature_Offre Dfinal = new DTOCandidature_Offre();
        EntretienService es = new EntretienService();
        System.out.println(id_passed + "5555555");
        ObservableList<DTOCandidature_Offre> dto1 = OffreService.candidatures_Offre(idOffre);
        for (DTOCandidature_Offre d : dto1) {
            if (d.getId_cand() == idCand1) {
                Dfinal.setEmail(d.getEmail());
                Dfinal.setNomCandidat(d.getNomCandidat());
                System.out.println("email1 : " + d.getEmail());
                System.out.println("email : " + Dfinal.getEmail());
            }

        }

        Entretien e1 = new Entretien(date, meet, idCand1, heure);
        System.out.println("!!!!!2222222! : " + idCand1);
        List<Entretien> listE = es.readAll();
        for (Entretien e : listE) {
            if (e.getId_Candidature() == idCand1) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setHeaderText("ERREUR");
                alert1.setContentText("Vous avez deja prévu  un entretien avec ce candidat pour le " + e.getDate() + " a " + e.getHeure() + "h");
                alert1.showAndWait();
                return;
            }
            if (e.getDate().equals(date) && e.getHeure().equals(heure)) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setHeaderText("ERREUR");
                alert1.setContentText("Vous avez deja prévu un entretien a cet date et heure.");
                alert1.showAndWait();
                return;
            }
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Confirmation");
        alert.setContentText("Vous etes sur des information saisie?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.out.println("1-"+e1.getLienMeet());
            es.ajouter(e1);
             dto.setStatut("Entretien");
            System.out.println(dto.getId_cand()+" jjjjjjjjjjjjjjjjjjjj");
            System.out.println("!!!!!!!!!!!!lol  " + Dfinal.getEmail());
            Thread th = new Thread(() -> {
            Mail mail = new Mail();
            mail.envoyerMailEntretien(heure, date, meet, Dfinal.getEmail());
                  });
        th.setDaemon(true);
        th.start();  
           
            OffreService.updateStatut(dto);
            String title = "Entretien";
            String message = "Votre renuion avec " + Dfinal.getNomCandidat() + " est fixé pour le " + date + " a " + heure + "h";
            // Notification notification = Notifications.SUCCESS;

            TrayNotification tray = new TrayNotification();
            tray.setTitle(title);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.setAnimationType(AnimationType.POPUP);
//        tray.setNotification(notification);
            tray.showAndWait();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.close();

        } else {
            alert.close();
        }
    }

    public void setId(int id) {

        id_passed = id;

    }

    public void setIdCandidature(int id) {

        id_cand_passed = id;

    }

}
