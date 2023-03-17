/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workbot_jobtn.gui;


import workbot_jobtn.services.CondidatureService;
import workbot_jobtn.entites.Candidature;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import static org.joda.time.format.ISODateTimeFormat.date;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import workbot_jobtn.utils.SessionManager;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class CandidatureModifierController implements Initializable {

    @FXML
    private TextField inputexperience;
    @FXML
    private ComboBox<String> inputdiplome;
    @FXML
    private TextArea inputmotivation;
    @FXML
    private ComboBox<String> inputfrancais;
    @FXML
    private ComboBox<String> inputanglais;
    @FXML
    private Button Postuler;
    @FXML
    private Button Timage;
    @FXML
    private Label imgpathttt;
    @FXML
    private ImageView imgajoutincours;
    @FXML
    private Label labelid;
    @FXML
    private Button Home;
    @FXML
    private Button gotooffre;
    @FXML
    private Button N_BMHome1;
    @FXML
    private Button gotocontrats;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inputdiplome.getItems().addAll("Informatique", "Mecanique", "Electrique", "Genie Civil", "Finance", "Marketing", "Aéronotique");

        inputfrancais.getItems().addAll("Notions", "Compétence Professionnelle limitée", "Compétence Professionnelle",
                "Capacité Professionnelle compléte ", "Bilingue ou lange natale");
        inputanglais.getItems().addAll("Notions", "Compétence Professionnelle limitée", "Compétence Professionnelle",
                "Capacité Professionnelle compléte ", "Bilingue ou lange natale");

        labelid.setText(Integer.toString(CandidatureListController.connectedCondidature.getId()));
        imgpathttt.setText(CandidatureListController.connectedCondidature.getCv());
        Timage.setText(CandidatureListController.connectedCondidature.getCv());
        inputanglais.setValue(CandidatureListController.connectedCondidature.getNiveauAnglais());
        inputfrancais.setValue(CandidatureListController.connectedCondidature.getNiveauFrancais());
        inputmotivation.setText(CandidatureListController.connectedCondidature.getLettreMotivation());
        inputdiplome.setValue(CandidatureListController.connectedCondidature.getDiplome());
        inputexperience.setText(CandidatureListController.connectedCondidature.getExperience());

    }

    @FXML
    private void Postuler(ActionEvent event) throws SQLException, NoSuchAlgorithmException, IOException {
        CondidatureService productService = new CondidatureService();

        if (inputexperience.getText().equals("")) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Veuillez saisir tous les champs");
            a.setHeaderText(null);
            a.showAndWait();
        } else {

           
              Date date = new Date(System.currentTimeMillis());
            java.sql.Date d2 = new java.sql.Date(date.getTime());
            String sqlDate2=d2.toString();

            Candidature ccc = new Candidature(Integer.parseInt(labelid.getText()), null, inputmotivation.getText(), null, sqlDate2,SessionManager.getId(), CandidatureListController.connectedCondidature.getId_offre(), inputfrancais.getValue(),
                    inputanglais.getValue(), Timage.getText(),inputexperience.getText(),
                    CandidatureListController.connectedCondidature.getTypeCondidature(), inputdiplome.getValue()        
            ,CandidatureListController.connectedCondidature.getDomaine(),CandidatureListController.connectedCondidature.getTitre()
            ,CandidatureListController.connectedCondidature.getDateExpiration()
            );

            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("Confirmer");
            a.setHeaderText(null);
            a.showAndWait();
            productService.modifierCondidature(ccc);
       TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.SLIDE;
            tray.setAnimationType(type);
            tray.setTitle("Contrat modifié avec succées");
            tray.setMessage("Contrat modifié avec succées");
            tray.setNotificationType(NotificationType.INFORMATION);
            tray.showAndDismiss(Duration.millis(3000));
            Parent page1 = FXMLLoader.load(getClass().getResource("CandidatureList.fxml"));
            Scene scene = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        };

    }

    @FXML
    private void addimgcours(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG
                = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg
                = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");

        FileChooser.ExtensionFilter exFilterpdf
                = new FileChooser.ExtensionFilter("pdf files (*.pdf)", "*.pdf");

        FileChooser.ExtensionFilter exFilterPDF
                = new FileChooser.ExtensionFilter("PDF files (*.PDF)", "*.PDF");

        FileChooser.ExtensionFilter extFilterPNG
                = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng
                = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);
        File file = fileChooser.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            WritableImage image = SwingFXUtils.toFXImage(bufferedImage, null);
            imgajoutincours.setImage(image);
            imgajoutincours.setFitWidth(200);
            imgajoutincours.setFitHeight(200);
            imgajoutincours.scaleXProperty();
            imgajoutincours.scaleYProperty();
            imgajoutincours.setSmooth(true);
            imgajoutincours.setCache(true);
            FileInputStream fin = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fin.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            byte[] person_image = bos.toByteArray();
        } catch (IOException ex) {
            Logger.getLogger("ss");
        }
        imgpathttt.setText(file.getAbsolutePath());
    }

     @FXML
    private void Home(ActionEvent event) throws IOException {
            Parent page1 = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();   
        
    }
    @FXML
    private void gotooffre(ActionEvent event) throws IOException {
                   Parent page1 = FXMLLoader.load(getClass().getResource("Offre_1.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show(); 
    }

    @FXML
    private void gotocontrats(ActionEvent event) throws IOException {
                   Parent page1 = FXMLLoader.load(getClass().getResource("ContratList.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show(); 
    }

}
