/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package workbot_jobtn.gui;

import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import workbot_jobtn.entites.DTOCandidature_Offre;
import workbot_jobtn.entites.DTOEntretien;
import workbot_jobtn.entites.Entretien;
import workbot_jobtn.entites.Offre;
import workbot_jobtn.services.EntretienService;

/**
 * FXML Controller class
 *
 * @author Exon
 */
public class DisplayEntretiensController implements Initializable {

    @FXML
    private HBox root;
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
    private TableView<DTOEntretien> table;

    EntretienService entretienService = new EntretienService();
    @FXML
    private TableColumn<DTOEntretien, String> nom;
    @FXML
    private TableColumn<DTOEntretien, String> date;
    @FXML
    private TableColumn<DTOEntretien, String> heure;
    @FXML
    private TableColumn<DTOEntretien, String> lienM;
    @FXML
    private Button QRcode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ObservableList<DTOEntretien> list = entretienService.displayEntretiens();

            nom.setCellValueFactory(new PropertyValueFactory<>("nomCand"));
            date.setCellValueFactory(new PropertyValueFactory<>("date"));
            heure.setCellValueFactory(new PropertyValueFactory<>("heure"));
            lienM.setCellValueFactory(new PropertyValueFactory<>("lien"));
            FilteredList<DTOEntretien> filteredList = new FilteredList<>(list, b -> true);
            inputsearch.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredList.setPredicate(DTOEntretien -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();
                    if (DTOEntretien.getNomCand().toLowerCase().contains(lowerCaseFilter)) {
                        return true;
                    } else {
                        return false;
                    }
                });
            });
            SortedList<DTOEntretien> sortedList = new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(table.comparatorProperty());
            table.setItems(sortedList);
        } catch (SQLException ex) {
            Logger.getLogger(DisplayEntretiensController.class.getName()).log(Level.SEVERE, null, ex);
        }

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
    private void OnClicked_menuEntretiens(ActionEvent event) {
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
    private void OnclickQrCode(ActionEvent event) throws FileNotFoundException, IOException {
        
          ObservableList<DTOEntretien> offreSelected = table.getSelectionModel().getSelectedItems();
        DTOEntretien dto = offreSelected.get(0);
        String detailsCand = dto.getLien();
        ByteArrayOutputStream out = QRCode.from(detailsCand).to(ImageType.PNG).stream();
        File f = new File("C:\\PDFapi\\QRgenerator.PNG");

        FileOutputStream fos = new FileOutputStream(f);
        fos.write(out.toByteArray());
        fos.flush();
        fos.close();
        Desktop.getDesktop().open(new File("C:\\PDFapi\\QRgenerator.PNG"));
    }

}
